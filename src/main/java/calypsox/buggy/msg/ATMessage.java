package calypsox.buggy.msg;

import com.calypso.tk.bo.BOMessage;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.service.DSConnection;

/**
 * The Class ATTrade.
 */
public class ATMessage {

    /** The trade. */
    protected BOMessage bomessage;

    /**
     * Instantiates a new AT trade.
     *
     * @param trade the trade
     */
    public ATMessage(final BOMessage msg) {
	if (msg == null) {
	    throw new IllegalArgumentException("Message is null");
	}
	bomessage = msg;
    }

    public ATMessage(final long id) throws CalypsoServiceException {
	final BOMessage msg = DSConnection.getDefault().getRemoteBackOffice().getMessage(id);
	bomessage = msg;
    }

    public long getId() {
	return bomessage.getLongId();
    }
}
