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
 * The Class ATCres.
 */
public class ATCres {

    /**
     * To AT cre list.
     *
     * @param array the array
     * @return the list
     */
    public static List<ATCre> toATCreList(final CreArray array) {
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

    /**
     * Gets the cres.
     *
     * @param trade the trade
     * @return the cres
     * @throws CalypsoServiceException the calypso service exception
     */
    public List<ATCre> getCres(final ATTrade trade) throws CalypsoServiceException {
	final String from = null;
	final String where = String.format("trade_id = %d", trade.getId());
	final CreArray cres = DSConnection.getDefault().getRemoteBackOffice().getBOCres(from, where);

	return toATCreList(cres);
    }
}
