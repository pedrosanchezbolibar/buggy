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

    /** The instance. */
    private static ATTransfers instance;

    /** The Constant ORDER_BY. */
    private static final String ORDER_BY = "value_date, event_type, amount_ccy, amount, transfer_status, transfer_id";

    /** The Constant MAX_ROW_COUNT. */
    private static final int MAX_ROW_COUNT = 5000;

    /**
     * Gets the single instance of ATTransfers.
     *
     * @return single instance of ATTransfers
     */
    public static synchronized ATTransfers getInstance() {
        if (instance == null) {
            instance = new ATTransfers();
        }
        return instance;
    }

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
     * Instantiates a new AT transfers.
     */
    private ATTransfers() {
        // prevent to instantiate this class
    }

    /**
     * Gets the netted transfer.
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
     * @return the netted transfer
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTransfer getNettedTransfer(final ATTrade trade, final double amount, final String ccy,
            final String eventType, final String status) throws CalypsoServiceException {
        if (trade != null) {
            final String where = String.format(
                    "trade_id = %d and event_type='%s' and transfer_status = '%s' and amount = %f and amount_ccy = '%s' and netted_transfer_id = 0",
                    trade.getId(), eventType, status, amount, ccy);
            return getFirstBOTransfer(null, where);
        }
        return null;
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
        if (trade != null) {
            final String where = String.format(
                    "trade_id = %d and event_type='%s' and transfer_status = '%s' and amount = %f and amount_ccy = '%s' and netted_transfer_id = 0",
                    trade.getId(), eventType, status, amount, ccy);
            return getBOTransfers(null, where);
        }
        return null;
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
        ATCache.getInstance().clearCache("Transfer");
        final TransferArray array = DSConnection.getDefault().getRemoteBackOffice().getBOTransfers(fromClause,
                whereClause, ORDER_BY, MAX_ROW_COUNT);
        return toATTransferList(array);
    }

    /**
     * Gets the first BO transfer.
     *
     * @param fromClause
     *            the from clause
     * @param whereClause
     *            the where clause
     * @return the first BO transfer
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    private ATTransfer getFirstBOTransfer(final String fromClause, final String whereClause)
            throws CalypsoServiceException {
        final TransferArray array = DSConnection.getDefault().getRemoteBackOffice().getBOTransfers(fromClause,
                whereClause, ORDER_BY, MAX_ROW_COUNT);
        if (array.isEmpty()) {
            return null;
        }
        if (array.size() > 1) {
            throw new IllegalArgumentException("The get method returns more than one element");
        }
        return new ATTransfer(array.get(0));
    }
}
