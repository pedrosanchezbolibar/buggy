package calypsox.buggy.uploader;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.calypso.tk.core.Log;
import com.calypso.tk.publish.jaxb.CalypsoAcknowledgement;
import com.calypso.tk.publish.jaxb.CalypsoTrades;

import calypsox.buggy.uti.JAXBContextBinder;

/**
 * Bean to encapsulate and process a Data Uploader ack.
 */
public class DUPAck {

    /** The ack. */
    private final CalypsoAcknowledgement ack;

    /** The ack str. */
    private final String ackStr;

    /** The jaxb context. */
    private static JAXBContext jaxbContext;

    /** The unmarshaller. */
    private static Unmarshaller unmarshaller;

    /** The marshaller. */
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
     * @param ack the ack
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
     * @param ack the ack
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
     * Gets the trade id.
     *
     * @return the trade id
     */
    public int getTradeId() {
	int result = -1;
	final CalypsoTrades calypsoTrades = ack.getCalypsoTrades();
	if (calypsoTrades != null && calypsoTrades.getCalypsoTrade().size() == 1) {
	    result = calypsoTrades.getCalypsoTrade().get(0).getCalypsoTradeId();
	}

	return result;
    }
}
