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

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.util.ConnectException;

import calypsox.buggy.acc.ATCre;
import calypsox.buggy.acc.ATCres;
import calypsox.buggy.cml.CMLImporter;
import calypsox.buggy.infra.ATEngines;
import calypsox.buggy.msg.ATMessage;
import calypsox.buggy.msg.ATMessages;
import calypsox.buggy.product.ATTrade;
import calypsox.buggy.product.ATTrades;
import calypsox.buggy.refdata.ATUsers;
import calypsox.buggy.uploader.DUPAck;
import calypsox.buggy.uploader.DUPImporter;
import calypsox.buggy.uti.CalypsoEnvironment;
import calypsox.buggy.uti.ImgResource;
import calypsox.buggy.uti.References;
import calypsox.buggy.xfer.ATTransfer;
import calypsox.buggy.xfer.ATTransfers;

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
     * @throws ConnectException
     *             the connect exception
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
     * Generate external ref.
     *
     * @return the string
     */
    public String generateExternalRef() {
        return new References().generateExternalRef();
    }

    /**
     * Gets the cres.
     *
     * @param trade
     *            the trade
     * @return the cres
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATCre> getCres(final ATTrade trade) throws CalypsoServiceException {
        return new ATCres().getCres(trade);
    }

    /**
     * Gets the image.
     *
     * @param resource
     *            the resource
     * @return the image
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public String getImage(final String resource) throws IOException {
        return new ImgResource().getImage(this, resource);
    }

    /**
     * Gets the trade's message by msg type.
     *
     * @param trade
     *            the trade
     * @param msgType
     *            the msg type
     * @return the message by msg type
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATMessage getMessageByMsgType(final ATTrade trade, final String msgType) throws CalypsoServiceException {
        return new ATMessages().getMessageByMsgType(trade, msgType);
    }

    /**
     * Gets the messages by event types.
     *
     * @param trade
     *            the trade
     * @param msgTypes
     *            the msg types
     * @return the messages by event types
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATMessage> getMessagesByEventTypes(final ATTrade trade, final List<String> msgTypes)
            throws CalypsoServiceException {
        return new ATMessages().getMessageByEventTypes(trade, msgTypes);
    }

    /**
     * Gets the netting transfers of the trade.
     *
     * @param trade
     *            the trade
     * @return the transfers
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTransfer> getNettedTransfers(final ATTrade trade) throws CalypsoServiceException {
        return new ATTransfers().getNettedTransfers(trade);
    }

    /**
     * Gets the property.
     *
     * @param key
     *            the key
     * @return the property
     */
    public String getProperty(final String key) {
        return testProperties.getProperty(key);
    }

    /**
     * Gets the trade indicated in the DataUploader ack.
     *
     * @param ack
     *            the ack
     * @return the trade
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTrade getTrade(final DUPAck ack) throws CalypsoServiceException {
        return new ATTrades().getTrade(ack);
    }

    /**
     * Gets the trade.
     *
     * @param tradeId
     *            the trade id
     * @return the trade
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTrade getTrade(final int tradeId) throws CalypsoServiceException {
        return new ATTrades().getTrade(tradeId);
    }

    /**
     * Gets the user name.
     *
     * @param groups
     *            the groups
     * @return the user name
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public String getUserName(final List<String> groups) throws CalypsoServiceException {
        return new ATUsers().getUserName(groups);
    }

    /**
     * Insert CDUF.
     *
     * @param template
     *            the template
     * @return the DUP ack
     * @throws Exception
     *             the exception
     */
    public DUPAck importCDUF(final String template) throws Exception {
        return new DUPImporter().insert(this, template, testProperties);
    }

    /**
     * Import a trade in CML format.
     *
     * @param template
     *            the template
     * @return the list
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public int importCMLTrade(final String template) throws IOException {
        return new CMLImporter().importTrade(this, template, testProperties);
    }

    /**
     * Invoke.
     *
     * @param obj
     *            the obj
     * @param methodName
     *            the method name
     * @param params
     *            the params
     * @return the string
     * @throws NoSuchMethodException
     *             the no such method exception
     * @throws IllegalAccessException
     *             the illegal access exception
     * @throws InvocationTargetException
     *             the invocation target exception
     */
    public String invoke(final Object obj, final String methodName, final List<String> params)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        params.toArray(new String[] {});
        final Method method = obj.getClass().getMethod(methodName, String.class);
        return method.invoke(obj, params).toString();
    }

    /**
     * Sets the property.
     *
     * @param key
     *            the key
     * @param value
     *            the value
     */
    public void setProperty(final String key, final String value) {
        testProperties.setProperty(key, value);
    }

    /**
     * Wait for engine.
     *
     * @param engine
     *            the engine
     * @return the int
     * @throws InterruptedException
     *             the interrupted exception
     */
    public int waitForEngine(final String engine) throws InterruptedException {
        return new ATEngines().waitForEngine(engine, DEFAULT_WAIT_INTERVAL, DEFAULT_CHECK_TIMES);
    }

}
