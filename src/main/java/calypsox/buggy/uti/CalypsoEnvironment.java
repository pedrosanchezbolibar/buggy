package calypsox.buggy.uti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.core.Log;
import com.calypso.tk.publish.jaxb.CalypsoAcknowledgement;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.LocalCache;
import com.calypso.tk.util.ConnectException;
import com.calypso.tk.util.ConnectionUtil;
import com.calypso.tk.util.DataUploaderUtil;

import calypsox.buggy.prototype.Prototype;
import calypsox.buggy.uploader.AATAck;

/**
 * The Class ReferenceEnvironment.
 */
public class CalypsoEnvironment {

    /** The instance. */
    private static final CalypsoEnvironment INSTANCE = new CalypsoEnvironment();

    /** The Constant DATA_DIRECTORIES. */
    private static final String[] DATA_DIRECTORIES = { "testdata/le", "testdata/account", "testdata/relation",
	    "testdata/contact", "testdata/sdi", "testdata/legalAgreement" };

    /**
     * Gets the single instance of ReferenceEnvironment.
     *
     * @return single instance of ReferenceEnvironment
     */
    public static CalypsoEnvironment getInstance() {

	return INSTANCE;

    }

    /** The ds. */
    private DSConnection dsConnnection;

    /** The loaded. */
    private boolean loaded = false;

    /**
     * Instantiates a new reference environment.
     */
    private CalypsoEnvironment() {
	super();
	// this is just to avoid class instantiation
    }

    /**
     * Connect.
     *
     * @throws ConnectException the connect exception
     */
    public void connect() throws ConnectException {
	if (dsConnnection == null) {

	    final String user = System.getProperty("user");
	    final String password = System.getProperty("password");
	    final String env = System.getProperty("env");

	    if (user == null || password == null || env == null) {
		final String msg = "necesita especificar los parámetros -Duser=user -Dpassword=password -Denv=env";
		Log.error(this, msg);
		throw new ConnectException(msg);
	    } else {
		dsConnnection = ConnectionUtil.connect(user, password, "MainEntry", env);
	    }
	}
    }

    /**
     * Gets the DS connection.
     *
     * @return the DS connection
     */
    public DSConnection getDSConnection() {
	return dsConnnection;
    }

    /**
     * Gets the env name.
     *
     * @return the env name
     */
    public String getEnvName() {
	return System.getProperty("env");
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
	return System.getProperty("password");
    }

    /**
     * Gets the resource files.
     *
     * @param path the path
     * @return the resource files
     */
    public List<CdufFile> getResourceFiles(final String path) {
	final List<CdufFile> filenames = new ArrayList<>();

	try (InputStream inputStream = new ResourceReader().getResourceAsStream(path)) {
	    if (inputStream != null) {
		final BufferedReader breader = new BufferedReader(new InputStreamReader(inputStream));

		String resource;

		while ((resource = breader.readLine()) != null) {
		    final CdufFile file = new CdufFile();
		    file.setFileName(path + '/' + resource);
		    filenames.add(file);
		}
	    }
	} catch (final IOException ex) {
	    Log.error(this, ex);
	}

	return filenames;
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public String getUser() {
	return System.getProperty("user");
    }

    /**
     * Insert.
     *
     * @param filepath the filepath
     * @return true, if successful
     */
    public boolean insert(final String filepath) {
	final CdufFile file = new CdufFile();
	file.setFileName(filepath);
	insert(file);
	return file.getReceived() == file.getUploaded();
    }

    /**
     * Insert full test data set.
     */
    public void insertFullTestDataSet() {
	if (!loaded && !dontReloadStaticDataOption()) {
	    loaded = true;
	    Log.info(this, "--------------- Loading Reference and Static Data ------------------");

	    for (final String directory : DATA_DIRECTORIES) {
		final List<CdufFile> dataFiles = getResourceFiles(directory);
		insert(dataFiles);
		clearCache();
	    }

	    Log.info(this, "--------------- END Loading Reference and Static Data ------------------");
	}
    }

    /**
     * Disconnect default DSConnection.
     *
     * @throws ConnectException the connect exception
     */
    public void reconnect() throws ConnectException {
	final SecurityManager prevSecManager = System.getSecurityManager();
	System.setSecurityManager(new AvoidSystemExitSecurityManager());

	try {
	    DSConnection.logout();
	} catch (final SecurityException e) {
	    // please, don't write to log.
	}

	System.setSecurityManager(prevSecManager);
	DSConnection.setDefault(null);
	dsConnnection = null;
	connect();
    }

    /**
     * Clear cache.
     */
    private void clearCache() {
	BOCache.clear();
	LocalCache.clear();
    }

    /**
     * Dont reload static data option.
     *
     * @return true, if successful
     */
    private boolean dontReloadStaticDataOption() {
	final String dontReload = System.getProperty("dontReloadStaticData");
	return dontReload != null && "true".equals(dontReload);
    }

    /**
     * Insert.
     *
     * @param file the file
     */
    private void insert(final CdufFile file) {
	try {
	    final StringBuilder messageText = new Prototype().readResource(file.getFileName());
	    final CalypsoAcknowledgement ack = DataUploaderUtil.uploadXML(messageText.toString());

	    file.setRejected(ack.getRejected());
	    file.setUploaded(ack.getUploaded());
	    file.setReceived(ack.getReceived());

	    if (ack.getRejected() > 0) {
		final AATAck aatack = new AATAck(ack);
		Log.error(this, "NACK cargando datos de referencia: \r\n" + aatack.getAckAsString());
	    }
	} catch (final Exception ex) {
	    Log.error(this, "Exception loading file '" + file + "'", ex);
	}
    }

    /**
     * Insert.
     *
     * @param list the list
     */
    private void insert(final List<CdufFile> list) {
	for (final CdufFile file : list) {
	    insert(file);
	}
    }
}
