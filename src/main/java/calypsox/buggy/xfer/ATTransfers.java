package calypsox.buggy.xfer;

import java.util.ArrayList;
import java.util.List;

import com.calypso.tk.bo.BOTransfer;
import com.calypso.tk.core.Action;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.Status;
import com.calypso.tk.refdata.AccessUtil;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.RemoteBackOffice;
import com.calypso.tk.util.TransferArray;

import calypsox.buggy.infra.ATCache;
import calypsox.buggy.infra.ATDSConnection;
import calypsox.buggy.product.ATTrade;

/**
 * The Class ATTransfers.
 */
public class ATTransfers {

    /** The Constant XFER_ASSIGNED. */
    private static final String XFER_ASSIGNED = "Xfer Assigned";

    /** The Constant ASSIGNED. */
    private static final String ASSIGNED = "Assigned";

    /** The Constant ORDER_BY. */
    private static final String ORDER_BY = "value_date, event_type, amount_ccy, amount, transfer_status, transfer_id";

    /** The Constant MAX_ROW_COUNT. */
    private static final int MAX_ROW_COUNT = 5000;

    /**
     * Apply action to transfer.
     *
     * @param transfer the transfer
     * @param action   the action
     * @param username the username
     * @return true, if successful
     * @throws CloneNotSupportedException the clone not supported exception
     * @throws CalypsoServiceException    the calypso service exception
     */
    public boolean applyActionToTransfer(final ATTransfer transfer, final String action, final String username)
	    throws CloneNotSupportedException, CalypsoServiceException {
	final ATDSConnection dsCon = new ATDSConnection(username);

	final RemoteBackOffice remoteBo = dsCon.getRemoteBackOffice();

	boolean rst = false;
	if (transfer != null) {

	    final BOTransfer clonedTransfer = (BOTransfer) transfer.getBOTransfer().clone();

	    if (AccessUtil.isAuthorized(clonedTransfer, action)) {

		if (Action.S_ASSIGN.equals(action)) {
		    final BOTransfer newTransfer = (BOTransfer) clonedTransfer.clone();

		    clonedTransfer.setAttribute("PayerStatus", ASSIGNED);
		    clonedTransfer.setAttribute("ReceiverStatus", ASSIGNED);
		    clonedTransfer.setExternalSDStatus(ASSIGNED);
		    clonedTransfer.setInternalSDStatus(ASSIGNED);

		    newTransfer.setAction(Action.NEW);
		    newTransfer.setStatus(Status.S_NONE);
		    newTransfer.setParentLongId(clonedTransfer.getLongId());
		    newTransfer.setEnteredUser(username);

		    newTransfer.setLongId(0);
		    newTransfer.setAttribute("PayerStatus", XFER_ASSIGNED);
		    newTransfer.setAttribute("ReceiverStatus", XFER_ASSIGNED);
		    newTransfer.setExternalSDStatus(XFER_ASSIGNED);
		    newTransfer.setInternalSDStatus(XFER_ASSIGNED);
		    newTransfer.setAttribute("BusinessReason", Action.S_ASSIGN);

		    remoteBo.save(newTransfer, 0, null);
		}
		clonedTransfer.setAction(Action.valueOf(action));
		clonedTransfer.setEnteredUser(username);
		remoteBo.save(clonedTransfer, 0, null);
		rst = true;
	    } else {
		dsCon.restoreRealConnection();
		throw new SecurityException("Action " + action + " can't be performed with user " + username
			+ " on transfer " + clonedTransfer.getLongId());
	    }
	}
	dsCon.restoreRealConnection();
	return rst;
    }

    /**
     * Gets the BO transfers.
     *
     * @param trade the trade
     * @return the BO transfers
     * @throws CalypsoServiceException the calypso service exception
     */
    public List<ATTransfer> getNettedTransfers(final ATTrade trade) throws CalypsoServiceException {
	if (trade != null) {
	    final String where = String.format("trade_id = %d and netted_transfer_id = 0", trade.getId());
	    return getBOTransfers(null, where);
	}
	return new ArrayList<>();
    }

    /**
     * Gets the BO transfers.
     *
     * @param fromClause  the from clause
     * @param whereClause the where clause
     * @return the BO transfers
     * @throws CalypsoServiceException the calypso service exception
     */
    private List<ATTransfer> getBOTransfers(final String fromClause, final String whereClause)
	    throws CalypsoServiceException {
	new ATCache().clearCache("Transfer");
	final TransferArray array = DSConnection.getDefault().getRemoteBackOffice().getBOTransfers(fromClause,
		whereClause, ORDER_BY, MAX_ROW_COUNT);
	return toATTransferList(array);
    }

    /**
     * To AT transfer list.
     *
     * @param array the array
     * @return the list
     */
    public static List<ATTransfer> toATTransferList(final TransferArray array) {
	final List<ATTransfer> list = new ArrayList<>();
	for (final BOTransfer xfer : array) {
	    list.add(new ATTransfer(xfer));
	}
	return list;
    }
}
