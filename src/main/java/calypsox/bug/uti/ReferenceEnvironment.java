package calypsox.bug.uti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.Log;
import com.calypso.tk.publish.jaxb.CalypsoAcknowledgement;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.LocalCache;
import com.calypso.tk.util.ConnectException;
import com.calypso.tk.util.ConnectionUtil;
import com.calypso.tk.util.DataUploaderUtil;

import calypsox.bug.prototype.Prototype;
import calypsox.bug.uploader.AATAck;

/**
 * The Class ReferenceEnvironment.
 */
public class ReferenceEnvironment extends ResourceReader {

    /** The instance. */
    private static final ReferenceEnvironment INSTANCE = new ReferenceEnvironment();

    /**
     * Gets the single instance of ReferenceEnvironment.
     *
     * @return single instance of ReferenceEnvironment
     */
    public static ReferenceEnvironment getInstance() {

	return INSTANCE;

    }

    /** The ds. */
    private DSConnection dsConnnection;

    /** The legal entities. */
    private List<CdufFile> legalEntities;

    /** The relations. */
    private List<CdufFile> relations;

    /** The contacts. */
    private List<CdufFile> contacts;

    /** The sdis. */
    private List<CdufFile> sdis;

    /** The legal Agreements. */
    private List<CdufFile> legalAgreements;

    /** The loaded. */
    private boolean loaded = false;

    /** The accounts. */
    private List<CdufFile> accounts;

    /**
     * Instantiates a new reference environment.
     */
    private ReferenceEnvironment() {
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
	final List<CdufFile> filenames = new ArrayList<CdufFile>();

	try (InputStream inputStream = getResourceAsStream(path)) {
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
	    Log.info(this, "--------------- cargando static data ------------------");
	    Log.info(this, "----- este mensaje no debe salir más de una vez -------");

	    legalEntities = getResourceFiles("com/bbva/klyo/aat/testenv/data/le");
	    accounts = getResourceFiles("com/bbva/klyo/aat/testenv/data/account");
	    relations = getResourceFiles("com/bbva/klyo/aat/testenv/data/relation");
	    contacts = getResourceFiles("com/bbva/klyo/aat/testenv/data/contact");
	    sdis = getResourceFiles("com/bbva/klyo/aat/testenv/data/sdi");
	    legalAgreements = getResourceFiles("com/bbva/klyo/aat/testenv/data/legalAgreement");

	    insert(legalEntities);
	    clearCache();
	    insert(accounts);
	    clearCache();
	    insert(relations);
	    clearCache();
	    insert(contacts);
	    clearCache();
	    insert(sdis);
	    clearCache();
	    insert(legalAgreements);
	    clearCache();

	    generateReport();

	    Log.info(this, "--------------- FIN static data ------------------");
	}
    }

    private boolean dontReloadStaticDataOption() {
	final String dontReload = System.getProperty("dontReloadStaticData");
	return dontReload != null && "true".equals(dontReload);
    }

    /**
     * Clear cache.
     */
    private void clearCache() {
	BOCache.clear();
	LocalCache.clear();
    }

    /**
     * Generate report.
     */
    private void generateReport() {
	Log.info(this, "LEGAL ENTITIES");
	for (final CdufFile file : legalEntities) {
	    Log.info(this, file.toString());
	}
	Log.info(this, "LEGAL ENTITIES RELATIONSHIPS");
	for (final CdufFile file : relations) {
	    Log.info(this, file.toString());
	}
	Log.info(this, "LEGAL ENTITIES_CONTACTS");
	for (final CdufFile file : contacts) {
	    Log.info(this, file.toString());
	}
	Log.info(this, "SDI");
	for (final CdufFile file : sdis) {
	    Log.info(this, file.toString());
	}
	Log.info(this, "LEGAL AGREEMENT");
	for (final CdufFile file : legalAgreements) {
	    Log.info(this, file.toString());
	}
	Log.info(this, "ACCOUNTS");
	for (final CdufFile file : accounts) {
	    Log.info(this, file.toString());
	}
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

    /**
     * returns the vector with the posible differnt products.
     *
     * @param line the line
     * @return the vector
     */
    private Vector<String> loadVectorProduct(final String line) {
	final Vector<String> vectorReturn = new Vector<String>();
	final StringTokenizer tokens = new StringTokenizer(line, ",");
	while (tokens.hasMoreTokens()) {
	    final String str = tokens.nextToken();
	    vectorReturn.add(str);
	}
	return vectorReturn;

    }

    /**
     * Parses the dates.
     *
     * @param dateString the date string
     * @return the j date
     */
    private JDate parseDates(final String dateString) {

	final List<String> vectorReturn = new ArrayList<String>();
	final StringTokenizer tokens = new StringTokenizer(dateString, "/");
	while (tokens.hasMoreTokens()) {
	    final String str = tokens.nextToken();
	    vectorReturn.add(str);
	}

	return JDate.valueOf(Integer.parseInt(vectorReturn.get(2)), Integer.parseInt(vectorReturn.get(1)),
		Integer.parseInt(vectorReturn.get(0)));
    }

    public DSConnection getDSConnection() {
	return dsConnnection;
    }

}
