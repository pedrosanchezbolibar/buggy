package calypsox.buggy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

import org.concordion.api.FullOGNL;
import org.concordion.api.extension.Extensions;
import org.concordion.ext.EmbedExtension;
import org.concordion.ext.TimestampFormatterExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.calypso.tk.bo.MessageFormatException;
import com.calypso.tk.bo.swift.SwiftFieldMessage;
import com.calypso.tk.bo.swift.SwiftMessage;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.util.ConnectException;

import calypsox.buggy.acc.ATCre;
import calypsox.buggy.acc.ATCres;
import calypsox.buggy.infra.ATEngines;
import calypsox.buggy.msg.ATMessage;
import calypsox.buggy.msg.ATMessages;
import calypsox.buggy.msg.ATSwiftMessage;
import calypsox.buggy.product.ATTrade;
import calypsox.buggy.product.ATTrades;
import calypsox.buggy.ui.ATAmount;
import calypsox.buggy.uploader.DUPAck;
import calypsox.buggy.uploader.DUPImporter;
import calypsox.buggy.uti.CalypsoEnvironment;
import calypsox.buggy.uti.ImgResource;
import calypsox.buggy.uti.References;
import calypsox.buggy.xfer.ATTransfer;
import calypsox.buggy.xfer.ATTransfers;

// TODO: Auto-generated Javadoc
/**
 * Parent class for all tests fixtures.
 */
@RunWith(ConcordionRunner.class)
@FullOGNL
@Extensions({ EmbedExtension.class, TimestampFormatterExtension.class })
public class BuggyAT extends BuggyVersion {

    /** The Constant DEFAULT_WAIT_INTERVAL. */
    private static final long DEFAULT_WAIT_INTERVAL = 200;

    /** The Constant DEFAULT_CHECK_TIMES. */
    private static final int DEFAULT_CHECK_TIMES = 200;

    /**
     * Inits the Calypso Environment.
     *
     * @throws ConnectException the connect exception
     */
    @BeforeClass
    public static void init() throws ConnectException {
	CalypsoEnvironment.getInstance().connect();
	CalypsoEnvironment.getInstance().insertFullTestDataSet();
    }

    /** The test properties. */
    private final Properties testProperties;

    /**
     * Instantiates a new buggy AT.
     */
    public BuggyAT() {
	testProperties = new Properties();
    }

    /**
     * Apply action to message.
     *
     * @param message  the message
     * @param action   the action
     * @param userName the user name
     * @return true, if successful
     * @throws CalypsoServiceException    the calypso service exception
     * @throws CloneNotSupportedException the clone not supported exception
     */
    public boolean applyActionToMessage(final ATMessage message, final String action, final String userName)
	    throws CalypsoServiceException, CloneNotSupportedException {
	return new ATMessages().applyActionToMessage(message, action, userName);
    }

    /**
     * Apply action to trade.
     *
     * @param trade    the trade
     * @param action   the action
     * @param userName the user name
     * @return true, if successful
     * @throws CalypsoServiceException    the calypso service exception
     * @throws CloneNotSupportedException the clone not supported exception
     */
    public boolean applyActionToTrade(final ATTrade trade, final String action, final String userName)
	    throws CalypsoServiceException, CloneNotSupportedException {
	return new ATTrades().applyActionToTrade(trade, action, userName);
    }

    /**
     * Format swift document.
     *
     * @param message    the message
     * @param pricingEnv the pricing env
     * @return the AT swift message
     * @throws CalypsoServiceException the calypso service exception
     * @throws MessageFormatException  the message format exception
     */
    public ATSwiftMessage formatSwiftDocument(final ATMessage message, final String pricingEnv)
	    throws CalypsoServiceException, MessageFormatException {
	return new ATMessages().formatSwiftDocument(message, pricingEnv);
    }

    /**
     * Generate external ref.
     *
     * @return the string
     */
    public String generateExternalRef() {
	return new References().generateExternalRef();
    }

    /**
     * Gets the cre amount.
     *
     * @param cre      the cre
     * @param strIndex the str index
     * @return the cre amount
     */
    public ATAmount getCreAmount(final ATCre cre, final String strIndex) {
	final int index = Integer.parseInt(strIndex);
	return cre.getCreAmount(index);
    }

    /**
     * Gets the cres.
     *
     * @param trade the trade
     * @return the cres
     * @throws CalypsoServiceException the calypso service exception
     */
    public List<ATCre> getCres(final ATTrade trade) throws CalypsoServiceException {
	return new ATCres().getCres(trade);
    }

    /**
     * Gets the image.
     *
     * @param resource the resource
     * @return the image
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public String getImage(final String resource) throws IOException {
	return new ImgResource().getImage(this, resource);
    }

    /**
     * Gets the trade's message by msg type.
     *
     * @param trade   the trade
     * @param msgType the msg type
     * @return the message by msg type
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATMessage getMessageByMsgType(final ATTrade trade, final String msgType) throws CalypsoServiceException {
	return new ATMessages().getMessageByMsgType(trade, msgType);
    }

    /**
     * Gets the messages by event types.
     *
     * @param trade    the trade
     * @param msgTypes the msg types
     * @return the messages by event types
     * @throws CalypsoServiceException the calypso service exception
     */
    public List<ATMessage> getMessagesByEventTypes(final ATTrade trade, final List<String> msgTypes)
	    throws CalypsoServiceException {
	return new ATMessages().getMessageByEventTypes(trade, msgTypes);
    }

    /**
     * Gets the netting transfers of the trade.
     *
     * @param trade the trade
     * @return the transfers
     * @throws CalypsoServiceException the calypso service exception
     */
    public List<ATTransfer> getNettedTransfers(final ATTrade trade) throws CalypsoServiceException {
	return new ATTransfers().getNettedTransfers(trade);
    }

    /**
     * Gets the property.
     *
     * @param key the key
     * @return the property
     */
    public String getProperty(final String key) {
	return testProperties.getProperty(key);
    }

    /**
     * Gets the swift tag.
     *
     * @param atSwiftMessage the at swift message
     * @param tag            the tag
     * @param count          the count
     * @return the swift tag
     */
    public String getSwiftTag(final ATSwiftMessage atSwiftMessage, final String tag, final int count) {
	int found = 0;

	final SwiftMessage swiftMessage = atSwiftMessage.getSwiftMessage();
	if (swiftMessage != null) {
	    for (final SwiftFieldMessage field : swiftMessage.getFields()) {
		if ((":" + tag + ":").equals(field.getTAG())) {
		    found++;
		    if (found == count) {
			return field.getValue().replace("\r\n", " \\ ");
		    }
		}
	    }
	}
	return "";
    }

    /**
     * Gets the trade indicated in the DataUploader ack.
     *
     * @param ack the ack
     * @return the trade
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATTrade getTrade(final DUPAck ack) throws CalypsoServiceException {
	return new ATTrades().getTrade(ack);
    }

    /**
     * Insert CDUF.
     *
     * @param template the template
     * @return the DUP ack
     * @throws Exception the exception
     */
    public DUPAck insertCDUF(final String template) throws Exception {
	return new DUPImporter().insert(this, template, testProperties);
    }

    /**
     * Invoke.
     *
     * @param obj        the obj
     * @param methodName the method name
     * @param param      the param
     * @return the string
     * @throws NoSuchMethodException     the no such method exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     */
    public String invoke(final Object obj, final String methodName, final String param)
	    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
	final Method method = obj.getClass().getMethod(methodName, String.class);
	return method.invoke(obj, param).toString();
    }

    /**
     * Reload.
     *
     * @param msg the msg
     * @return the AT message
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATMessage reload(final ATMessage msg) throws CalypsoServiceException {
	return new ATMessages().reload(msg);
    }

    /**
     * Sets the property.
     *
     * @param key   the key
     * @param value the value
     */
    public void setProperty(final String key, final String value) {
	testProperties.setProperty(key, value);
    }

    /**
     * Wait for engine.
     *
     * @param engine the engine
     * @return the int
     * @throws InterruptedException the interrupted exception
     */
    public int waitForEngine(final String engine) throws InterruptedException {
	return new ATEngines().waitForEngine(engine, DEFAULT_WAIT_INTERVAL, DEFAULT_CHECK_TIMES);
    }
}
