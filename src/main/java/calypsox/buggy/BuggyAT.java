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
import calypsox.buggy.refdata.ATCurrencies;
import calypsox.buggy.refdata.ATCurrency;
import calypsox.buggy.refdata.ATJDate;
import calypsox.buggy.refdata.ATMarginCallConfig;
import calypsox.buggy.refdata.ATMarginCallConfigs;
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
import calypsox.buggy.xfer.ATTradeTransferRule;
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
        return ATWorkflows.getInstance().addManualAction(fromStatus, action, toStatus, eventClass, productType,
                wfSubType);
    }

    /**
     * Compare two objects.
     *
     * @param expected
     *            the expected result
     * @param actual
     *            the actual result
     * @return true, if objects are equals
     */
    public boolean assertEquals(final Object expected, final Object actual) {
        if (expected.equals(actual)) {
            return true;
        }
        throw new AssertionError("Expected = '" + expected + "', Actual = '" + actual + "'");
    }

    /**
     * Assert not null.
     *
     * @param actual
     *            the actual
     * @return true, if successful
     */
    public boolean assertNotNull(final Object actual) {
        if (actual != null) {
            return true;
        }

        throw new AssertionError("Object is null");
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
     * Creates the transfer rule.
     *
     * @param transferType
     *            the transfer type
     * @param payRec
     *            the pay rec
     * @return the AT trade transfer rule
     */
    public ATTradeTransferRule createTransferRule(final String transferType, final String payRec) {
        return new ATTradeTransferRule().withTransferType(transferType).withPayRec(payRec);
    }

    /**
     * Creates the transfer rule.
     *
     * @param transferType
     *            the transfer type
     * @param payRec
     *            the pay rec
     * @param direction
     *            which SDI need to be assigned PAYER or RECEIVER
     * @return the AT trade transfer rule
     */
    public ATTradeTransferRule createTransferRule(final String transferType, final String payRec,
            final String direction) {
        return new ATTradeTransferRule().withTransferType(transferType).withPayRec(payRec).withDirection(direction);
    }

    /**
     * Creates the transfer rule.
     *
     * @param transferType
     *            the transfer type
     * @param payRec
     *            the pay rec
     * @param ccy
     *            the ccy
     * @param role
     *            the role
     * @param leShortName
     *            the le short name
     * @return the AT trade transfer rule
     */
    public ATTradeTransferRule createTransferRule(final String transferType, final String payRec, final String ccy,
            final String role, final String leShortName) {
        return createTransferRule(transferType, payRec).withCurrency(ccy).withRole(role).withLegalEntity(leShortName);
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
        ATCres.getInstance().deleteCres(trade, eventType);
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
        return ATWorkflows.getInstance().deleteAction(transitionId);
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
        return References.getInstance().generateExternalRef();
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
        return ATCres.getInstance().getCre(trade, creType);
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
        return ATCres.getInstance().getCre(trade, creType, valDate);
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
        return ATCres.getInstance().getCres(trade);
    }

    /**
     * Gets the currency.
     *
     * @param ccyCode
     *            the ccy code
     * @return the currency
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATCurrency getCurrency(final String ccyCode) throws CalypsoServiceException {
        return ATCurrencies.getInstance().get(ccyCode);
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
     * Gets the margin call configs.
     *
     * @param procOrg
     *            the proc org
     * @param cpty
     *            the cpty
     * @return the margin call configs
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATMarginCallConfig> getMarginCallConfigs(final String procOrg, final String cpty)
            throws CalypsoServiceException {
        return ATMarginCallConfigs.getInstance().getContracts(procOrg, cpty);
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
        return ATMessages.getInstance().getMessageByEventType(trade, eventType);
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
        return ATMessages.getInstance().getMessageByMsgType(trade, msgType);
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
        return ATMessages.getInstance().getMessageByTemplateName(trade, templateName);
    }

    /**
     * Gets the messages.
     *
     * @param trade
     *            the trade
     * @return the messages
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATMessage> getMessages(final ATTrade trade) throws CalypsoServiceException {
        return ATMessages.getInstance().getMessages(trade);
    }

    /**
     * Gets the messages.
     *
     * @param transfer
     *            the transfer
     * @return the messages
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATMessage> getMessages(final ATTransfer transfer) throws CalypsoServiceException {
        return ATMessages.getInstance().getMessages(transfer);
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
        return ATMessages.getInstance().getMessagesByEventTypes(trade, eventTypes);
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
        return ATMessages.getInstance().getMessagesByMsgTypes(trade, msgTypes);
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
        return ATMessages.getInstance().getMessagesByTemplateName(trade, templateName);
    }

    /**
     * Gets the transfer.
     *
     * @param trade
     *            the trade
     * @param amount
     *            the amount
     * @param ccy
     *            the ccy
     * @param eventType
     *            the event type
     * @param status
     *            the status
     * @return the transfer
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTransfer getNettedTransfer(final ATTrade trade, final double amount, final String ccy,
            final String eventType, final String status) throws CalypsoServiceException {
        return ATTransfers.getInstance().getNettedTransfer(trade, amount, ccy, eventType, status);
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
        return ATTransfers.getInstance().getNettedTransfers(trade);
    }

    /**
     * Gets the netted transfers.
     *
     * @param trade
     *            the trade
     * @param amount
     *            the amount
     * @param ccy
     *            the ccy
     * @param eventType
     *            the event type
     * @param status
     *            the status
     * @return the netted transfers
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTransfer> getNettedTransfers(final ATTrade trade, final double amount, final String ccy,
            final String eventType, final String status) throws CalypsoServiceException {
        return ATTransfers.getInstance().getNettedTransfers(trade, amount, ccy, eventType, status);
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
        return ATTransfers.getInstance().getNettedTransfersWithStatus(trade, status);
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
        return ATTasks.getInstance().getNonCompletedTasks(trade);
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
    public List<ATTask> getNonCompletedTasksByEventTypes(final ATTrade trade, final List<String> eventTypes)
            throws CalypsoServiceException {
        return ATTasks.getInstance().getNonCompletedTasksByEventTypes(trade, eventTypes);
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
        return ATScheduledTasks.getInstance().getScheduledTask(stExternalRef);
    }

    /**
     * Retrieve a SDI using its reference.
     *
     * @param reference
     *            the reference
     * @return the sdi
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATSdi getSdi(final String reference) throws CalypsoServiceException {
        return ATSdis.getInstance().get(reference);
    }

    /**
     * Gets the SD is by beneficiary.
     *
     * @param legalEntityName
     *            the legal entity name
     * @return the SD is by beneficiary
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATSdi> getSDIsByBeneficiary(final String legalEntityName) throws CalypsoServiceException {
        return ATSdis.getInstance().getSDIsByBeneficiary(legalEntityName);
    }

    /**
     * Gets the SDI is by beneficiary and ccy.
     *
     * @param legalEntityName
     *            the legal entity name
     * @param currency
     *            the currency
     * @return the SD is by beneficiary
     * @throws CalypsoServiceException
     *             the remote exception
     */

    public List<ATSdi> getSDIsByBeneficiaryAndCcy(final String legalEntityName, final String currency)
            throws CalypsoServiceException {
        return ATSdis.getInstance().getSDIsByBeneficiaryAndCcy(legalEntityName, currency);
    }

    /**
     * Gets the tasks.
     *
     * @param msg
     *            the msg
     * @param includeCompleted
     *            the include completed
     * @return the tasks
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasks(final ATMessage msg, final boolean includeCompleted) throws CalypsoServiceException {
        return ATTasks.getInstance().getTasks(msg, includeCompleted);
    }

    /**
     * Gets the tasks.
     *
     * @param trade
     *            the trade
     * @param includeCompleted
     *            the include completed
     * @return the tasks
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasks(final ATTrade trade, final boolean includeCompleted) throws CalypsoServiceException {
        return ATTasks.getInstance().getTasks(trade, includeCompleted);
    }

    /**
     * Gets the tasks.
     *
     * @param xfer
     *            the xfer
     * @param includeCompleted
     *            the include completed
     * @return the tasks
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasks(final ATTransfer xfer, final boolean includeCompleted) throws CalypsoServiceException {
        return ATTasks.getInstance().getTasks(xfer, includeCompleted);
    }

    /**
     * Gets the tasks by event type and int reference.
     *
     * @param trade
     *            the trade
     * @param eventTypes
     *            the event types
     * @param internalReference
     *            the internal reference
     * @param includeCompleted
     *            the include completed
     * @return the tasks by event type and int reference
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasksByEventTypeAndIntReference(final ATTrade trade, final List<String> eventTypes,
            final String internalReference, final boolean includeCompleted) throws CalypsoServiceException {
        return ATTasks.getInstance().getTasksByEventTypeAndIntReference(trade, eventTypes, internalReference,
                includeCompleted);
    }

    /**
     * Gets the tasks by event types.
     *
     * @param msg
     *            the msg
     * @param eventTypes
     *            the event types
     * @param includeCompleted
     *            the include completed
     * @return the tasks by event types
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasksByEventTypes(final ATMessage msg, final List<String> eventTypes,
            final boolean includeCompleted) throws CalypsoServiceException {
        return ATTasks.getInstance().getTasksByEventTypes(msg, eventTypes, includeCompleted);
    }

    /**
     * Gets the tasks by event type.
     *
     * @param trade
     *            the trade
     * @param eventTypes
     *            the event types
     * @param includeCompleted
     *            the include completed
     * @return the tasks by event type
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasksByEventTypes(final ATTrade trade, final List<String> eventTypes,
            final boolean includeCompleted) throws CalypsoServiceException {
        return ATTasks.getInstance().getTasksByEventTypes(trade, eventTypes, includeCompleted);
    }

    /**
     * Gets the tasks by event types.
     *
     * @param xfer
     *            the xfer
     * @param eventTypes
     *            the event types
     * @param includeCompleted
     *            the include completed
     * @return the tasks by event types
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasksByEventTypes(final ATTransfer xfer, final List<String> eventTypes,
            final boolean includeCompleted) throws CalypsoServiceException {
        return ATTasks.getInstance().getTasksByEventTypes(xfer, eventTypes, includeCompleted);
    }

    /**
     * Gets the tasks by object status.
     *
     * @param trade
     *            the trade
     * @param status
     *            the status
     * @param includeCompleted
     *            the include completed
     * @return the tasks by object status
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasksByObjectStatus(final ATTrade trade, final String status, final boolean includeCompleted)
            throws CalypsoServiceException {
        return ATTasks.getInstance().getTasksByObjectStatus(trade, status, includeCompleted);
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
        return ATTrades.getInstance().getTrade(tradeId);
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
        return ATTrades.getInstance().getTrades(extRef);
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
        return ATUsers.getInstance().getUserName(groups);
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
        return DUPImporter.getInstance().insert(this, template, testProperties);
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
        return CMLImporter.getInstance().importTrade(this, template, testProperties);
    }

    /**
     * Removes the SD is by beneficiary.
     *
     * @param legalEntityName
     *            the legal entity name
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public boolean removeSDIsByBeneficiary(final String legalEntityName) throws CalypsoServiceException {
        return ATSdis.getInstance().removeSDIsByBeneficiary(legalEntityName);
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
        return ATEngines.getInstance().waitForEngine(engine, DEFAULT_WAIT_INTERVAL, DEFAULT_CHECK_TIMES);
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
