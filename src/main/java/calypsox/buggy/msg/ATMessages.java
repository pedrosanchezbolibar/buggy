package calypsox.buggy.msg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.calypso.tk.bo.BOMessage;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.RemoteBackOffice;
import com.calypso.tk.util.MessageArray;

import calypsox.buggy.product.ATTrade;
import calypsox.buggy.xfer.ATTransfer;

/**
 * Search and manipulates BOMessage and ATMessage.
 */
public class ATMessages {

    /** The instance. */
    private static ATMessages instance;

    /** The Constant ORDER_BY. */
    private static final String ORDER_BY = "MESSAGE_TYPE , EVENT_TYPE , TEMPLATE_NAME , ADDRESS_METHOD , MESSAGE_ID ";

    /**
     * Gets the single instance of ATMessages.
     *
     * @return single instance of ATMessages
     */
    public static synchronized ATMessages getInstance() {
        if (instance == null) {
            instance = new ATMessages();
        }
        return instance;
    }

    /**
     * Instantiates a new AT messages.
     */
    private ATMessages() {
        // prevent to instantiate this class
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
        final String where = String.format("trade_id = %d and event_type = '%s'", trade.getId(), eventType);
        return getMessage(where);
    }

    /**
     * Gets the message by event type address method.
     *
     * @param trade
     *            the trade
     * @param eventTypes
     *            the event types
     * @param addCode
     *            the add code
     * @return the message by event type address method
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATMessage getMessageByEventTypeAddressMethod(final ATTrade trade, final String eventTypes,
            final String addCode) throws CalypsoServiceException {
        final String where = String.format("trade_id = %d and event_type = '%s' and address_method = '%s'",
                trade.getId(), eventTypes, addCode);
        return getMessage(where);
    }

    /**
     * Gets the message by event type and template.
     *
     * @param trade
     *            the trade
     * @param templateName
     *            the template name
     * @param eventType
     *            the event type
     * @return the message by event type and template
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATMessage getMessageByEventTypeAndTemplate(final ATTrade trade, final String templateName,
            final String eventType) throws CalypsoServiceException {
        final String where = String.format("trade_id = %d and template_name = '%s' and EVENT_TYPE = '%s'",
                trade.getId(), templateName, eventType);
        return getMessage(where);
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
        final String where = String.format("trade_id = %d and MESSAGE_TYPE = '%s'", trade.getId(), msgType);
        return getMessage(where);
    }

    /**
     * Gets the message by template and receiver.
     *
     * @param trade
     *            the trade
     * @param templateName
     *            the template name
     * @param receiver
     *            the receiver
     * @return the message by template and receiver
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATMessage getMessageByTemplateAndReceiver(final ATTrade trade, final String templateName,
            final String receiver) throws CalypsoServiceException {
        final String where = String.format(
                "trade_id = %d and template_name = '%s' and receiver_id = (select LEGAL_ENTITY.LEGAL_ENTITY_ID from LEGAL_ENTITY where short_name = '%s')",
                trade.getId(), templateName, receiver);
        return getMessage(where);
    }

    /**
     * Gets the message by template and receiver and status.
     *
     * @param trade
     *            the trade
     * @param templateName
     *            the template name
     * @param receiver
     *            the receiver
     * @param msgStatus
     *            the msg status
     * @return the message by template and receiver and status
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATMessage getMessageByTemplateAndReceiverAndStatus(final ATTrade trade, final String templateName,
            final String receiver, final String msgStatus) throws CalypsoServiceException {
        final String where = String.format(
                "trade_id = %d and template_name = '%s' and receiver_id = (select LEGAL_ENTITY.LEGAL_ENTITY_ID from LEGAL_ENTITY where short_name = '%s' and message_status='%s')",
                trade.getId(), templateName, receiver, msgStatus);
        return getMessage(where);
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
        final String where = String.format("trade_id = %d and template_name = '%s'", trade.getId(), templateName);
        return getMessage(where);
    }

    /**
     * Gets the message by template name.
     *
     * @param transfer
     *            the transfer
     * @param templateName
     *            the template name
     * @return the message by template name
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATMessage getMessageByTemplateName(final ATTransfer transfer, final String templateName)
            throws CalypsoServiceException {
        final String where = String.format("transfer_id = '%s' and template_name = '%s' ", transfer.getId(),
                templateName);
        return getMessage(where);
    }

    /**
     * Gets the trade messages.
     *
     * @param trade
     *            the trade
     * @return the messages
     * @throws CalypsoServiceException
     */
    public List<ATMessage> getMessages(final ATTrade trade) throws CalypsoServiceException {
        final String where = String.format("trade_id = '%s'", trade.getId());
        return getMessagesOrdered(where);
    }

    /**
     * Gets the transfer messages.
     *
     * @param transfer
     *            the transfer
     * @return the messages
     * @throws CalypsoServiceException
     */
    public List<ATMessage> getMessages(final ATTransfer transfer) throws CalypsoServiceException {
        final String where = String.format("transfer_id = '%s'", transfer.getId());
        return getMessagesOrdered(where);
    }

    /**
     * Gets the message by event types.
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
        final String where = String.format("trade_id = %d and event_type in ('%s')", trade.getId(),
                StringUtils.join(eventTypes, "','"));
        return getMessagesOrdered(where);
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
        final String where = String.format("trade_id = %d and message_type in ('%s')", trade.getId(),
                StringUtils.join(msgTypes, "','"));
        return getMessagesOrdered(where);
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
        final String where = String.format("trade_id = %d and template_name in ('%s')", trade.getId(),
                StringUtils.join(templateName, "','"));
        return getMessagesOrdered(where);
    }

    /**
     * Gets the messages by template name.
     *
     * @param transfer
     *            the transfer
     * @param templateName
     *            the template name
     * @return the messages by template name
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATMessage> getMessagesByTemplateName(final ATTransfer transfer, final List<String> templateName)
            throws CalypsoServiceException {
        final String where = String.format("transfer_id = '%s' and template_name = '%s' ", transfer.getId(),
                templateName);
        return getMessagesOrdered(where);
    }

    /**
     * Gets the first message.
     *
     * @param where
     *            the where clause
     * @return the message
     * @throws CalypsoServiceException
     *             the remote exception
     */
    private ATMessage getMessage(final String where) throws CalypsoServiceException {
        final MessageArray messages = DSConnection.getDefault().getRemoteBackOffice().getMessages(where);
        if (messages.size() > 1 || messages.isEmpty()) {
            throw new IllegalArgumentException(
                    "Can't get one message, search returns " + messages.size() + " elements");
        }
        return new ATMessage(messages.get(0));
    }

    /**
     * Gets the messages sortered.
     *
     * @param where
     *            the where
     * @return the messages sortered
     * @throws CalypsoServiceException
     *             the remote exception
     */
    private List<ATMessage> getMessagesOrdered(final String where) throws CalypsoServiceException {

        if (!where.isEmpty()) {
            final RemoteBackOffice remoteBO = DSConnection.getDefault().getRemoteBackOffice();
            final MessageArray array = remoteBO.getMessages(null, where, ORDER_BY);
            return toATMessageList(array);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * To AT message list.
     *
     * @param array
     *            the array
     * @return the list
     */
    private List<ATMessage> toATMessageList(final MessageArray array) {
        final List<ATMessage> result = new ArrayList<>();

        final Iterator<BOMessage> iterator = array.iterator();
        while (iterator.hasNext()) {
            final BOMessage msg = iterator.next();
            result.add(new ATMessage(msg));
        }

        return result;
    }
}
