package calypsox.buggy.xfer;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.refdata.SettleDeliveryInstruction;
import com.calypso.tk.service.DSConnection;

/**
 * Retrieve information and apply actions to Calypso SDI
 */
public class ATSdi {

    /** The sdi. */
    final SettleDeliveryInstruction sdi;

    /**
     * Instantiates a new AT sdi.
     *
     * @param settleDeliveryId
     *            the settle delivery id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATSdi(final int settleDeliveryId) throws CalypsoServiceException {
        sdi = DSConnection.getDefault().getRemoteReferenceData().getSettleDeliveryInstruction(settleDeliveryId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return sdi.toString();
    }
}
