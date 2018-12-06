package calypsox.buggy.uploader;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.calypso.tk.core.Log;
import com.calypso.tk.publish.jaxb.CalypsoAcknowledgement;

import calypsox.buggy.uti.JAXBContextBinder;

/**
 * The Class AATAck.
 */
public class DUPAck {

    /** The ack. */
    private final CalypsoAcknowledgement ack;

    /** The ack str. */
    private final String ackStr;

    private static JAXBContext jaxbContext;

    private static Unmarshaller unmarshaller;

    private static Marshaller marshaller;

    static {
	try {
	    jaxbContext = JAXBContextBinder.getInstance().get("com.calypso.tk.publish.jaxb");
	    unmarshaller = jaxbContext.createUnmarshaller();
	    marshaller = jaxbContext.createMarshaller();
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	} catch (final JAXBException e) {
	    Log.error("AATAck", "Error getting marshaller/unmarshaller ", e);
	}
    }

    /**
     * Instantiates a new AAT ack.
     *
     * @param ackStr the ack str
     */
    public DUPAck(final String ackStr) {
	this.ackStr = ackStr;
	ack = unmarshal(ackStr);
    }

    /**
     * Instantiates a new AAT ack.
     *
     * @param ackStr the ack str
     */
    public DUPAck(final CalypsoAcknowledgement ack) {
	ackStr = marshal(ack);
	this.ack = ack;
    }

    /**
     * Unmarshall.
     *
     * @param ackStr the ack str
     * @return the calypso acknowledgement
     */
    protected CalypsoAcknowledgement unmarshal(final String ackStr) {

	CalypsoAcknowledgement result = null;

	try {
	    result = (CalypsoAcknowledgement) unmarshaller.unmarshal(new StringReader(ackStr));
	} catch (final JAXBException e) {
	    Log.error(this, "Error while unmarshalling " + ackStr, e);
	}

	return result;
    }

    /**
     * Unmarshall.
     *
     * @param ackStr the ack str
     * @return the calypso acknowledgement
     */
    protected String marshal(final CalypsoAcknowledgement ack) {

	final StringWriter result = new StringWriter();

	try {
	    marshaller.marshal(ack, result);
	} catch (final JAXBException e) {
	    Log.error(this, "Error while marshalling " + ackStr, e);
	    return null;
	}

	return result.toString();
    }

    /**
     * Gets the ack as string.
     *
     * @return the ack as string
     */
    @Override
    public String toString() {
	return ackStr;
    }

    /**
     * Gets the trade errors type.
     *
     * @return the trade errors type
     */
    public List<com.calypso.tk.publish.jaxb.Error> getErrors() {
	return ack.getCalypsoTrades().getCalypsoTrade().get(0).getError();
    }
}
