package calypsox.buggy.refdata;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.DayCount;
import com.calypso.tk.core.Tenor;
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
     * Gets the attributes.
     *
     * @return the attributes
     */
    public Map getAttributes() {
        return currencydefault.getAttributes();
    }

    /**
     * Gets the auth name.
     *
     * @return the auth name
     */
    public String getAuthName() {
        return currencydefault.getAuthName();
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return currencydefault.getCode();
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return currencydefault.getCountry();
    }

    /**
     * Gets the currency pairs.
     *
     * @return the currency pairs
     */
    public List getCurrencyPairs() {
        return currencydefault.getCurrencyPairs();
    }

    /**
     * Gets the default day count.
     *
     * @return the default day count
     */
    public DayCount getDefaultDayCount() {
        return currencydefault.getDefaultDayCount();
    }

    /**
     * Gets the default holidays.
     *
     * @return the default holidays
     */
    public List<String> getDefaultHolidays() {
        return currencydefault.getDefaultHolidays();
    }

    /**
     * Gets the default index.
     *
     * @return the default index
     */
    public String getDefaultIndex() {
        return currencydefault.getDefaultIndex();
    }

    /**
     * Gets the default spot days.
     *
     * @return the default spot days
     */
    public int getDefaultSpotDays() {
        return currencydefault.getDefaultSpotDays();
    }

    /**
     * Gets the default tenor.
     *
     * @return the default tenor
     */
    public Tenor getDefaultTenor() {
        return currencydefault.getDefaultTenor();
    }

    /**
     * Gets the default time zone.
     *
     * @return the default time zone
     */
    public TimeZone getDefaultTimeZone() {
        return currencydefault.getDefaultTimeZone();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return currencydefault.getDescription();
    }

    /**
     * Gets the external reference.
     *
     * @return the external reference
     */
    public String getExternalReference() {
        return currencydefault.getExternalReference();
    }

    /**
     * Gets the group list.
     *
     * @return the group list
     */
    public List getGroupList() {
        return currencydefault.getGroupList();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return currencydefault.getId();
    }

    /**
     * Gets the ISO code.
     *
     * @return the ISO code
     */
    public String getISOCode() {
        return currencydefault.getISOCode();
    }

    /**
     * Gets the checks if is precious metal.
     *
     * @return the checks if is precious metal
     */
    public boolean getIsPreciousMetal() {
        return currencydefault.getIsPreciousMetal();
    }

    /**
     * Gets the nb attributes.
     *
     * @return the nb attributes
     */
    public int getNbAttributes() {
        return currencydefault.getNbAttributes();
    }

    /**
     * Gets the rate decimals.
     *
     * @return the rate decimals
     */
    public int getRateDecimals() {
        return currencydefault.getRateDecimals();
    }

    /**
     * Gets the rounding.
     *
     * @return the rounding
     */
    public double getRounding() {
        return currencydefault.getRounding();
    }

    /**
     * Gets the rounding method.
     *
     * @return the rounding method
     */
    public String getRoundingMethod() {
        return currencydefault.getRoundingMethod();
    }

    /**
     * Gets the settlement cutoff time.
     *
     * @return the settlement cutoff time
     */
    public String getSettlementCutoffTime() {
        return currencydefault.getSettlementCutoffTime();
    }

    /**
     * Gets the settlement cutoff timezone.
     *
     * @return the settlement cutoff timezone
     */
    public TimeZone getSettlementCutoffTimezone() {
        return currencydefault.getSettlementCutoffTimezone();
    }

    /**
     * Gets the trade cutoff time.
     *
     * @return the trade cutoff time
     */
    public String getTradeCutoffTime() {
        return currencydefault.getTradeCutoffTime();
    }

    /**
     * Gets the trade cutoff timezone.
     *
     * @return the trade cutoff timezone
     */
    public TimeZone getTradeCutoffTimezone() {
        return currencydefault.getTradeCutoffTimezone();
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public String getUser() {
        return currencydefault.getUser();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
        return currencydefault.getVersion();
    }

    /**
     * Gets the warning threshold.
     *
     * @return the warning threshold
     */
    public double getWarningThreshold() {
        return currencydefault.getWarningThreshold();
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
