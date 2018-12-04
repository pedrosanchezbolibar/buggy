package calypsox.buggy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.jar.Manifest;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.Defaults;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.upload.DATAUploader;
import com.calypso.tk.util.ClientVersionInterface;
import com.calypso.tk.util.InstantiateUtil;

/**
 * The Class BuggyVersion.
 */
public class BuggyVersion {
    /** The Constant BUGGY_VERSION. */
    private static final String BUGGY_VERSION = "0.0.1 for Calypso 15.2";

    /**
     * Gets the buggy version.
     *
     * @return the buggy version
     */
    public String getBuggyVersion() {
	return BUGGY_VERSION;
    }

    /**
     * Gets the custom code version.
     *
     * @return the custom code version
     */
    public String getClientVersion() {
	try {
	    final ClientVersionInterface clientVersion = (ClientVersionInterface) InstantiateUtil
		    .getInstance("tk.util.ClientVersion");
	    return clientVersion.getVersion();
	} catch (InstantiationException | IllegalAccessException e) {
	    return "Unable to retrieve ClientVersion";
	}
    }

    /**
     * Gets the data model version.
     *
     * @return the data model version
     * @throws CalypsoServiceException the remote exception
     */
    public String getDataModelVersion() throws CalypsoServiceException {
	return DSConnection.getDefault().getRemoteAccess().getDataModelVersion();
    }

    /**
     * Gets the data uploader version.
     *
     * @return the data uploader version
     */
    public String getDataUploaderVersion() {
	return getModuleVersion(DATAUploader.class, "calypso-datauploader-version");
    }

    /**
     * Gets the environment name.
     *
     * @return the environment name
     */
    public String getEnvironmentName() {
	return Defaults.getProperty("ENV_NAME");
    }

    /**
     * Gets the module version.
     *
     * @param clazz  the clazz
     * @param module the module
     * @return the module version
     */
    public String getModuleVersion(final Class<?> clazz, final String module) {
	String rst = null;

	final String resource = "/" + clazz.getName().replace(".", "/") + ".class";
	final String fullPath = clazz.getResource(resource).toString();
	final String archivePath = fullPath.substring(0, fullPath.length() - resource.length());

	InputStream input;
	try {
	    input = new URL(archivePath + "/META-INF/MANIFEST.MF").openStream();
	    final Manifest manifest = new Manifest(input);
	    rst = manifest.getMainAttributes().getValue(module);

	    return rst;
	} catch (final IOException e) {
	    return "Unable to retrieve DataUploaderVersion";
	}
    }
}
