package calypsox.buggy.refdata;

import java.util.Calendar;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.refdata.CurrencyDefault;
import com.calypso.tk.service.DSConnection;

/**
 * Retrieve and manage information of Currencies and CurrencyDefaults.
 *
 */
public class ATCurrency {

    /** The currencydefault. */
    private CurrencyDefault currencydefault;

    /** The original settle cutoff time. */
    private String originalSettleCutoffTime;

    /**
     * Instantiates a new AT currency.
     *
     * @param ccyCode
     *            the ccy code
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATCurrency(final String ccyCode) throws CalypsoServiceException {
        currencydefault = DSConnection.getDefault().getRemoteReferenceData().getCurrencyDefault(ccyCode);
    }

    /**
     * Reload.
     *
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public void reload() throws CalypsoServiceException {
        currencydefault = DSConnection.getDefault().getRemoteReferenceData()
                .getCurrencyDefault(currencydefault.getCode());
    }

    /**
     * Restore settlement cutoff time.
     *
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the calypso service exception
     * @throws CloneNotSupportedException
     *             the clone not supported exception
     */
    public boolean restoreSettlementCutoffTime() throws CalypsoServiceException, CloneNotSupportedException {
        return setSettlementCutoffTime(originalSettleCutoffTime);
    }

    /**
     * Sets the settlement cutoff time.
     *
     * @param cuttOfTime
     *            the cutt of time
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the calypso service exception
     * @throws CloneNotSupportedException
     *             the clone not supported exception
     */
    public boolean setSettlementCutoffTime(final String cuttOfTime)
            throws CalypsoServiceException, CloneNotSupportedException {
        final CurrencyDefault clonedCcyDefault = (CurrencyDefault) currencydefault.clone();
        originalSettleCutoffTime = currencydefault.getSettlementCutoffTime();

        clonedCcyDefault.setSettlementCutoffTime(cuttOfTime);

        final boolean result = DSConnection.getDefault().getRemoteReferenceData().save(clonedCcyDefault);
        reload();
        return result;
    }

    /**
     * Sets the settlement cutoff time to now.
     *
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the calypso service exception
     * @throws CloneNotSupportedException
     *             the clone not supported exception
     */
    public boolean setSettlementCutoffTimeToNow() throws CalypsoServiceException, CloneNotSupportedException {

        final Calendar now = Calendar.getInstance(currencydefault.getSettlementCutoffTimezone());
        final String time = String.format("%02d:%02d:%02d", now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND));
        return setSettlementCutoffTime(time);
    }
}
