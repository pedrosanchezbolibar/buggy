package calypsox.buggy.uploader;

import java.util.Properties;

import com.calypso.tk.core.Log;
import com.calypso.tk.publish.jaxb.CalypsoAcknowledgement;
import com.calypso.tk.util.DataUploaderUtil;

import calypsox.buggy.prototype.Prototype;

/**
 * Import data in Calypso using the DataUploader.
 */
public class DUPImporter {

    /** The instance. */
    private static DUPImporter instance;

    /**
     * Gets the single instance of DUPImporter.
     *
     * @return single instance of DUPImporter
     */
    public static synchronized DUPImporter getInstance() {
        if (instance == null) {
            instance = new DUPImporter();
        }
        return instance;
    }

    /**
     * Instantiates a new DUP importer.
     */
    private DUPImporter() {
        // prevent to instantiate this class
    }

    /**
     * Insert a CDUF file using a prototype.
     *
     * @param owner
     *            the owner
     * @param template
     *            the template
     * @param params
     *            the params
     * @return the DUP ack
     * @throws Exception
     *             the exception
     */
    public DUPAck insert(final Object owner, final String template, final Properties params) throws Exception {
        if (template == null) {
            Log.error(this, "template can not be null");
            throw new IllegalArgumentException("Template can not be null");
        }
        final String messageText = new Prototype().getPrototype(owner, template, params);

        final CalypsoAcknowledgement ack = DataUploaderUtil.uploadXML(messageText);

        return new DUPAck(ack);
    }
}
