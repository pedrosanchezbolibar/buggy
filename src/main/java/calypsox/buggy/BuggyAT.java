package calypsox.buggy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import org.concordion.api.FullOGNL;
import org.concordion.api.extension.Extensions;
import org.concordion.ext.EmbedExtension;
import org.concordion.ext.TimestampFormatterExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDate;
import com.calypso.tk.util.ConnectException;

import calypsox.buggy.acc.ATCre;
import calypsox.buggy.acc.ATCres;
import calypsox.buggy.cml.CMLImporter;
import calypsox.buggy.infra.ATEngines;
import calypsox.buggy.infra.ATWorkflows;
import calypsox.buggy.msg.ATMessage;
import calypsox.buggy.msg.ATMessages;
import calypsox.buggy.product.ATTrade;
import calypsox.buggy.product.ATTrades;
import calypsox.buggy.refdata.ATJDate;
import calypsox.buggy.refdata.ATUsers;
import calypsox.buggy.sched.ATScheduledTask;
import calypsox.buggy.sched.ATScheduledTasks;
import calypsox.buggy.task.ATTask;
import calypsox.buggy.task.ATTasks;
import calypsox.buggy.uploader.DUPAck;
import calypsox.buggy.uploader.DUPImporter;
import calypsox.buggy.uti.CalypsoEnvironment;
import calypsox.buggy.uti.ImgResource;
import calypsox.buggy.uti.References;
import calypsox.buggy.xfer.ATSdi;
import calypsox.buggy.xfer.ATSdis;
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
     * Initialize the Calypso Environment.
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
     * Adds a new action to workflow.
     *
     * @param fromStatus
     *            the from status
     * @param action
     *            the action
     * @param toStatus
     *            the to status
     * @param eventClass
     *            the event class
     * @param productType
     *            the product type
     * @param wfSubType
     *            the wf sub type
     * @return the int
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public int addManualWorkflowAction(final String fromStatus, final String action, final String toStatus,
            final String eventClass, final String productType, final String wfSubType) throws CalypsoServiceException {
        return new ATWorkflows().addManualAction(fromStatus, action, toStatus, eventClass, productType, wfSubType);
    }

    /**
     * Calculate date by tenor.
     *
     * @param tenor
     *            the tenor
     * @param holidays
     *            the holidays
     * @return the ATJ date
     */
    public JDate calculateDateByTenor(final String tenor, final List<String> holidays) {
        return new ATJDate().calculateDateByTenor(tenor, holidays, null);
    }

    /**
     * Calculate date by tenor.
     *
     * @param tenor
     *            the tenor
     * @param holidays
     *            the holidays
     * @param timeZone
     *            the time zone
     * @return the ATJ date
     */
    public JDate calculateDateByTenor(final String tenor, final List<String> holidays, final String timeZone) {
        return new ATJDate().calculateDateByTenor(tenor, holidays, timeZone);
    }

    /**
     * Compare two objects
     *
     * @param expected
     *            the expected result
     * @param actual
     *            the actual result
     * @return true, if objects are equals
     */
    public boolean compare(final Object expected, final Object actual) {
        if (expected.equals(actual)) {
            return true;
        }
        throw new AssertionError("Expected = '" + expected + "', Actual = '" + actual + "'");
    }

    /**
     * Delete cres by event type.
     *
     * @param trade
     *            the trade
     * @param eventType
     *            the event type
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public void deleteCresByEventType(final ATTrade trade, final String eventType) throws CalypsoServiceException {
        new ATCres().deleteCres(trade, eventType);
    }

    /**
     * delete action in a workflow.
     *
     * @param transitionId
     *            transition to delete
     * @return OK if everything was fine
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public boolean deleteWorkflowAction(final String transitionId) throws CalypsoServiceException {
        return new ATWorkflows().deleteAction(transitionId);
    }

    /**
     * Format.
     *
     * @param date
     *            the date
     * @return the string
     */
    public String format(final JDate date) {
        return new ATJDate().toString(date);
    }

    /**
     * Format.
     *
     * @param date
     *            the date
     * @param timeZoneId
     *            the time zone id
     * @return the string
     */
    public String format(final JDate date, final String timeZoneId) {
        return new ATJDate().toString(date, TimeZone.getTimeZone(timeZoneId));
    }

    /**
     * Format.
     *
     * @param date
     *            the date
     * @param pattern
     *            the pattern
     * @param timeZoneId
     *            the time zone id
     * @return the string
     */
    public String format(final JDate date, final String pattern, final String timeZoneId) {
        return new ATJDate().toString(date, pattern, TimeZone.getTimeZone(timeZoneId));
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
     * Gets the cre by event type.
     *
     * @param trade
     *            the trade
     * @param creType
     *            the cre type
     * @return the cre by event type
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATCre getCreByEventType(final ATTrade trade, final String creType) throws CalypsoServiceException {
        return new ATCres().getCre(trade, creType);
    }

    /**
     * Gets the cre by event type and valuation date.
     *
     * @param trade
     *            the trade
     * @param creType
     *            the cre type
     * @param valDate
     *            the val date
     * @return the cre by event type and valuation date
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATCre getCreByEventTypeAndValuationDate(final ATTrade trade, final String creType, final String valDate)
            throws CalypsoServiceException {
        return new ATCres().getCre(trade, creType, valDate);
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
     * Embed a resource image.
     *
     * @param resource
     *            the resource
     * @return the image
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @see ImgResource
     */
    public String getImage(final String resource) throws IOException {
        return new ImgResource().getImage(this, resource);
    }

    /**
     * Gets the message by event type.
     *
     * @param trade
     *            the trade
     * @param eventType
     *            the event type
     * @return the message by event type
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATMessage getMessageByEventType(final ATTrade trade, final String eventType) throws CalypsoServiceException {
        return new ATMessages().getMessageByEventType(trade, eventType);
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
     * Gets the message by template name.
     *
     * @param trade
     *            the trade
     * @param templateName
     *            the template name
     * @return the message by template name
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATMessage getMessageByTemplateName(final ATTrade trade, final String templateName)
            throws CalypsoServiceException {
        return new ATMessages().getMessageByTemplateName(trade, templateName);
    }

    /**
     * Gets the messages by event types.
     *
     * @param trade
     *            the trade
     * @param eventTypes
     *            the msg types
     * @return the message by event types
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATMessage> getMessagesByEventTypes(final ATTrade trade, final List<String> eventTypes)
            throws CalypsoServiceException {
        return new ATMessages().getMessagesByEventTypes(trade, eventTypes);
    }

    /**
     * Gets the message by msg types.
     *
     * @param trade
     *            the trade
     * @param msgTypes
     *            the msg types
     * @return the message by msg types
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATMessage> getMessagesByMsgTypes(final ATTrade trade, final List<String> msgTypes)
            throws CalypsoServiceException {
        return new ATMessages().getMessagesByMsgTypes(trade, msgTypes);
    }

    /**
     * Gets the messages by template name.
     *
     * @param trade
     *            the trade
     * @param templateName
     *            the template name
     * @return the messages by template name
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATMessage> getMessagesByTemplateName(final ATTrade trade, final List<String> templateName)
            throws CalypsoServiceException {
        return new ATMessages().getMessagesByTemplateName(trade, templateName);
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
     * Gets the netted transfers with status.
     *
     * @param trade
     *            the trade
     * @param status
     *            the status
     * @return the netted transfers with status
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTransfer> getNettedTransfersWithStatus(final ATTrade trade, final String status)
            throws CalypsoServiceException {
        return new ATTransfers().getNettedTransfersWithStatus(trade, status);
    }

    /**
     * Gets the non completed tasks.
     *
     * @param trade
     *            the trade
     * @return the non completed tasks
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getNonCompletedTasks(final ATTrade trade) throws CalypsoServiceException {
        return new ATTasks().getNonCompletedTasks(trade);
    }

    /**
     * Gets the non completed tasks by event type.
     *
     * @param trade
     *            the trade
     * @param eventTypes
     *            the event types
     * @return the non completed tasks by event type
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getNonCompletedTasksByEventType(final ATTrade trade, final List<String> eventTypes)
            throws CalypsoServiceException {
        return new ATTasks().getNonCompletedTasksByEventType(trade, eventTypes);
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
     * Gets the scheduled task.
     *
     * @param stExternalRef
     *            the Scheduled Task External Reference
     * @return the scheduled task
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATScheduledTask getScheduledTask(final String stExternalRef) throws CalypsoServiceException {
        return new ATScheduledTasks().getScheduledTask(stExternalRef);
    }

    /**
     * Retrieve a SDI using its reference
     *
     * @param reference
     *            the reference
     * @return the sdi
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATSdi getSdi(final String reference) throws CalypsoServiceException {
        return new ATSdis().get(reference);
    }

    /**
     * Gets the tasks by event type.
     *
     * @param trade
     *            the trade
     * @param eventTypes
     *            the event types
     * @return the tasks by event type
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasksByEventType(final ATTrade trade, final List<String> eventTypes)
            throws CalypsoServiceException {
        return new ATTasks().getTasksByEventType(trade, eventTypes);
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
     * Gets the trades.
     *
     * @param extRef
     *            the ext ref
     * @return the trades
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTrade> getTrades(final String extRef) throws CalypsoServiceException {
        return new ATTrades().getTrades(extRef);
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
     * Repeat the execution of a method in a list of objects.
     *
     * @param objects
     *            the objects
     * @param methodName
     *            the method name
     * @param param
     *            the param
     * @throws NoSuchMethodException
     *             the no such method exception
     * @throws IllegalAccessException
     *             the illegal access exception
     * @throws InvocationTargetException
     *             the invocation target exception
     */
    public void repeat(final List<Object> objects, final String methodName, final Object param)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (final Object obj : objects) {
            invoke(obj, methodName, param);
        }
    }

    /**
     * Sets the property.
     *
     * @param key
     *            the key
     * @param value
     *            the value
     */
    public void setProperty(final String key, final Object value) {
        testProperties.setProperty(key, value.toString());
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
     * Today.
     *
     * @return the ATJ date
     */
    public ATJDate today() {
        return new ATJDate(JDate.getNow());
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

    /**
     * Invoke.
     *
     * @param obj
     *            the obj
     * @param methodName
     *            the method name
     * @param param
     *            the param
     * @return the string
     * @throws NoSuchMethodException
     *             the no such method exception
     * @throws IllegalAccessException
     *             the illegal access exception
     * @throws InvocationTargetException
     *             the invocation target exception
     */
    private String invoke(final Object obj, final String methodName, final Object param)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        final Method method = obj.getClass().getMethod(methodName, param.getClass());
        return String.valueOf(method.invoke(obj, param));
    }
}
