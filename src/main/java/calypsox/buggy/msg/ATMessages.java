package calypsox.buggy.msg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.calypso.tk.bo.BOMessage;
import com.calypso.tk.core.Action;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.refdata.AccessUtil;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.RemoteBackOffice;
import com.calypso.tk.util.MessageArray;

import calypsox.buggy.infra.ATDSConnection;
import calypsox.buggy.product.ATTrade;

/**
 * Search and manipulates BOMessage and ATMessage
 */
public class ATMessages {

    /** The Constant ORDER_BY. */
    private static final String ORDER_BY = "MESSAGE_TYPE , EVENT_TYPE , TEMPLATE_NAME , ADDRESS_METHOD , MESSAGE_ID ";;

    /**
     * Apply action to a message.
     *
     * @param msg the msg
     * @param action the action
     * @param userName the username
     * @return true, if successful
     * @throws CalypsoServiceException the calypso service exception
     * @throws CloneNotSupportedException the clone not supported exception
     */
    public boolean applyActionToMessage(final ATMessage msg, final String action, final String userName)
	    throws CalypsoServiceException, CloneNotSupportedException {
	boolean rst = false;

	String userNameParam = userName;
	if (userNameParam == null) {
	    userNameParam = "calypso_user";
	}

	final ATDSConnection dsconn = new ATDSConnection(userNameParam);

	final BOMessage clonedMsg = (BOMessage) msg.getBOMessage().clone();

	final StringBuilder errorText = new StringBuilder();
	if (AccessUtil.isAuthorized(clonedMsg, action, errorText)) {
	    clonedMsg.setAction(Action.valueOf(action));
	    clonedMsg.setEnteredUser(userNameParam);

	    dsconn.getRemoteBackOffice().save(clonedMsg, 0, null);

	    rst = true;
	} else {
	    dsconn.restoreRealConnection();

	    throw new SecurityException("Action can't be performed with user " + userNameParam);
	}

	dsconn.restoreRealConnection();

	return rst;
    }

    /**
     * Gets the message by event types.
     *
     * @param trade the trade
     * @param msgTypes the msg types
     * @return the message by event types
     * @throws CalypsoServiceException the calypso service exception
     */
    public List<ATMessage> getMessageByEventTypes(final ATTrade trade, final List<String> msgTypes)
	    throws CalypsoServiceException {
	final String where = String.format("trade_id = %d and event_type in ('%s')", trade.getId(),
		StringUtils.join(msgTypes, "','"));
	return getMessagesOrdered(where);
    }

    /**
     * Gets the trade's message by msg type.
     *
     * @param trade the trade
     * @param msgType the msg type
     * @return the message by msg type
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATMessage getMessageByMsgType(final ATTrade trade, final String msgType) throws CalypsoServiceException {
	final String where = String.format("trade_id = %d and MESSAGE_TYPE = '%s'", trade.getId(), msgType);
	return new ATMessage(getFirstMessage(where));
    }

    /**
     * Gets the message by msg types.
     *
     * @param trade the trade
     * @param msgTypes the msg types
     * @return the message by msg types
     * @throws CalypsoServiceException the calypso service exception
     */
    public List<ATMessage> getMessageByMsgTypes(final ATTrade trade, final List<String> msgTypes)
	    throws CalypsoServiceException {
	final String where = String.format("trade_id = %d and message_type in ('%s')", trade.getId(),
		StringUtils.join(msgTypes, "','"));
	return getMessagesOrdered(where);
    }

    /**
     * Reload a message from database
     *
     * @param msg the msg
     * @return the AT message
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATMessage reload(final ATMessage msg) throws CalypsoServiceException {
	return new ATMessage(msg.getId());
    }

    /**
     * Gets the first message.
     *
     * @param where the where clause
     * @return the message
     * @throws CalypsoServiceException the remote exception
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
     * @param where the where
     * @return the messages sortered
     * @throws CalypsoServiceException the remote exception
     */
    private List<ATMessage> getMessagesOrdered(final String where) throws CalypsoServiceException {

	if (!where.isEmpty()) {
	    final RemoteBackOffice remoteBO = DSConnection.getDefault().getRemoteBackOffice();
	    final MessageArray array = remoteBO.getMessages(null, where, ORDER_BY);
	    return toATMessageList(array);
	} else {
	    return null;
	}
    }

    /**
     * To AT message list.
     *
     * @param array the array
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
