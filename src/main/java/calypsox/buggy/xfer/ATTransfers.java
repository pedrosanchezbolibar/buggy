package calypsox.buggy.xfer;

import java.util.ArrayList;
import java.util.List;

import com.calypso.tk.bo.BOTransfer;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.TransferArray;

import calypsox.buggy.infra.ATCache;
import calypsox.buggy.product.ATTrade;

/**
 * The Class ATTransfers.
 */
public class ATTransfers {

    /** The Constant ORDER_BY. */
    private static final String ORDER_BY = "value_date, event_type, amount_ccy, amount, transfer_status, transfer_id";

    /** The Constant MAX_ROW_COUNT. */
    private static final int MAX_ROW_COUNT = 5000;

    /**
     * To AT transfer list.
     *
     * @param array
     *            the array
     * @return the list
     */
    public static List<ATTransfer> toATTransferList(final TransferArray array) {
        final List<ATTransfer> list = new ArrayList<>();
        for (final BOTransfer xfer : array) {
            list.add(new ATTransfer(xfer));
        }
        return list;
    }

    /**
     * Gets the BO transfers.
     *
     * @param fromClause
     *            the from clause
     * @param whereClause
     *            the where clause
     * @return the BO transfers
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    private List<ATTransfer> getBOTransfers(final String fromClause, final String whereClause)
            throws CalypsoServiceException {
        new ATCache().clearCache("Transfer");
        final TransferArray array = DSConnection.getDefault().getRemoteBackOffice().getBOTransfers(fromClause,
                whereClause, ORDER_BY, MAX_ROW_COUNT);
        return toATTransferList(array);
    }

    /**
     * Gets the BO transfers.
     *
     * @param trade
     *            the trade
     * @return the BO transfers
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTransfer> getNettedTransfers(final ATTrade trade) throws CalypsoServiceException {
        if (trade != null) {
            final String where = String.format("trade_id = %d and netted_transfer_id = 0", trade.getId());
            return getBOTransfers(null, where);
        }
        return new ArrayList<>();
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
        if (trade != null) {
            final String where = String.format("trade_id = %d and netted_transfer_id = 0 and transfer_status = '%s'",
                    trade.getId(), status);
            return getBOTransfers(null, where);
        }
        return new ArrayList<>();
    }
}
