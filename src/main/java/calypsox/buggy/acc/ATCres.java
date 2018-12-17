package calypsox.buggy.acc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.calypso.tk.bo.BOCre;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.CreArray;

import calypsox.buggy.product.ATTrade;

/**
 * Retrieve and apply actions on CRE
 */
public class ATCres {

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
    public void deleteCres(final ATTrade trade, final String eventType) throws CalypsoServiceException {
        final String where = String.format("bo_cre_type = '%s' and trade_id = %s", eventType, trade.getId());
        DSConnection.getDefault().getRemoteBackOffice().deleteCres(where, false);
    }

    /**
     * Gets the cre.
     *
     * @param trade
     *            the trade
     * @param creType
     *            the cre type
     * @return the cre
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATCre getCre(final ATTrade trade, final String creType) throws CalypsoServiceException {
        final String from = null;
        final String where = String.format("bo_cre_type = '%s' and trade_id = %d", creType, trade.getId());
        return getOnlyOneCre(from, where);
    }

    /**
     * Gets one CRE based on the cre type and valuation date
     *
     * @param trade
     *            the trade
     * @param creType
     *            the CRE type
     * @param valDate
     *            the valuation date
     * @return the trade's Cre
     * @throws CalypsoServiceException
     *             the Calypso service exception
     */
    public ATCre getCre(final ATTrade trade, final String creType, final String valDate)
            throws CalypsoServiceException {
        final String from = null;
        final String where = String.format(
                "bo_cre_type = '%s' and trade_id = %d and effective_date = to_date('%s', 'dd/mm/yyyy')", creType,
                trade.getId(), valDate);
        return getOnlyOneCre(from, where);
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
        final String from = null;
        final String where = String.format("trade_id = %d", trade.getId());
        final CreArray cres = DSConnection.getDefault().getRemoteBackOffice().getBOCres(from, where);

        return toATCreList(cres);
    }

    /**
     * Gets the only one cre.
     *
     * @param from
     *            the from
     * @param where
     *            the where
     * @return the only one cre
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    private ATCre getOnlyOneCre(final String from, final String where) throws CalypsoServiceException {
        final CreArray cres = DSConnection.getDefault().getRemoteBackOffice().getBOCres(from, where);
        if (cres.size() == 1) {
            return new ATCre(cres.get(0));
        } else {
            throw new IllegalArgumentException("Method getCre returned more than one cre");
        }
    }

    /**
     * To ATCre list.
     *
     * @param array
     *            the array
     * @return the list
     */
    private List<ATCre> toATCreList(final CreArray array) {
        final List<ATCre> list = new ArrayList<>();

        final int size = array.size();
        final BOCre[] result = array.getCres();
        Arrays.sort(result, new CreComparator());
        // The CreArray contains more elements than size, then the result variable can
        // have empty values that should be removed
        for (int i = 0; i < size; i++) {
            list.add(new ATCre(result[i]));
        }
        return list;
    }

}
