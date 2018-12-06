package calypsox.buggy.uploader;

import java.util.Properties;

import com.calypso.tk.publish.jaxb.CalypsoAcknowledgement;
import com.calypso.tk.util.DataUploaderUtil;

import calypsox.buggy.prototype.Prototype;

/**
 * The Class DUPImporter.
 */
public class DUPImporter {

    /**
     * Insert a CDUF file using a prototype
     *
     * @param owner the owner
     * @param params the params
     * @return the DUP ack
     * @throws Exception the exception
     */
    public DUPAck insert(final Object owner, final String template, final Properties params) throws Exception {
	final String messageText = new Prototype().getPrototype(owner, template, params);

	final CalypsoAcknowledgement ack = DataUploaderUtil.uploadXML(messageText);

	return new DUPAck(ack);
    }
}
