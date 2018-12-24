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

/**
 * Search and manipulates BOMessage and ATMessage.
 */
public class ATMessages {

    /** The Constant ORDER_BY. */
    private static final String ORDER_BY = "MESSAGE_TYPE , EVENT_TYPE , TEMPLATE_NAME , ADDRESS_METHOD , MESSAGE_ID ";

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
        return new ATMessage(getFirstMessage(where));
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
        return new ATMessage(getFirstMessage(where));
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
        return new ATMessage(getFirstMessage(where));
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
     * Gets the first message.
     *
     * @param where
     *            the where clause
     * @return the message
     * @throws CalypsoServiceException
     *             the remote exception
     */
    private BOMessage getFirstMessage(final String where) throws CalypsoServiceException {
        final MessageArray messages = DSConnection.getDefault().getRemoteBackOffice().getMessages(where);
        if (!messages.isEmpty()) {
            return messages.get(0);
        }
        return null;
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
