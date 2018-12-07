package calypsox.buggy.msg;

import com.calypso.tk.bo.BOMessage;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.MessageArray;

import calypsox.buggy.product.ATTrade;

/**
 * The Class ATMessages.
 */
public class ATMessages {

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
}
