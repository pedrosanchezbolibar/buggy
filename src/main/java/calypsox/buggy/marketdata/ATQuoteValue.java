package calypsox.buggy.marketdata;

import java.util.List;

import com.calypso.tk.core.DisplayValue;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.marketdata.EntitlementCheckStatus;
import com.calypso.tk.marketdata.QuoteValue;

/**
 * The Class ATQuoteValue.
 */
public class ATQuoteValue {

    /** The quotevalue. */
    private final QuoteValue quotevalue;

    /**
     * Instantiates a new AT quote value.
     *
     * @param quoteValue
     *            the quote value
     */
    public ATQuoteValue(final QuoteValue quoteValue) {
        quotevalue = quoteValue;
    }

    /**
     * Gets the ask.
     *
     * @return the ask
     */
    public double getAsk() {
        return quotevalue.getAsk();
    }

    /**
     * Gets the ask adjustment.
     *
     * @return the ask adjustment
     */
    public double getAskAdjustment() {
        return quotevalue.getAskAdjustment();
    }

    /**
     * Gets the ask as object.
     *
     * @return the ask as object
     */
    public Object getAskAsObject() {
        return quotevalue.getAskAsObject();
    }

    /**
     * Gets the asset type.
     *
     * @return the asset type
     */
    public String getAssetType() {
        return quotevalue.getAssetType();
    }

    /**
     * Gets the auth name.
     *
     * @return the auth name
     */
    public String getAuthName() {
        return quotevalue.getAuthName();
    }

    /**
     * Gets the bid.
     *
     * @return the bid
     */
    public double getBid() {
        return quotevalue.getBid();
    }

    /**
     * Gets the bid adjustment.
     *
     * @return the bid adjustment
     */
    public double getBidAdjustment() {
        return quotevalue.getBidAdjustment();
    }

    /**
     * Gets the bid ask spread.
     *
     * @return the bid ask spread
     */
    public double getBidAskSpread() {
        return quotevalue.getBidAskSpread();
    }

    /**
     * Gets the bid as object.
     *
     * @return the bid as object
     */
    public Object getBidAsObject() {
        return quotevalue.getBidAsObject();
    }

    /**
     * Gets the close.
     *
     * @return the close
     */
    public double getClose() {
        return quotevalue.getClose();
    }

    /**
     * Gets the close as object.
     *
     * @return the close as object
     */
    public Object getCloseAsObject() {
        return quotevalue.getCloseAsObject();
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public JDate getDate() {
        return quotevalue.getDate();
    }

    /**
     * Gets the datetime.
     *
     * @return the datetime
     */
    public JDatetime getDatetime() {
        return quotevalue.getDatetime();
    }

    /**
     * Gets the decimals.
     *
     * @return the decimals
     */
    public int getDecimals() {
        return quotevalue.getDecimals();
    }

    /**
     * Gets the domain.
     *
     * @return the domain
     */
    public List getDomain() {
        return quotevalue.getDomain();
    }

    /**
     * Gets the entered date.
     *
     * @return the entered date
     */
    public JDatetime getEnteredDate() {
        return quotevalue.getEnteredDate();
    }

    /**
     * Gets the entered user.
     *
     * @return the entered user
     */
    public String getEnteredUser() {
        return quotevalue.getEnteredUser();
    }

    /**
     * Gets the entitlement check status.
     *
     * @return the entitlement check status
     */
    public EntitlementCheckStatus getEntitlementCheckStatus() {
        return quotevalue.getEntitlementCheckStatus();
    }

    /**
     * Gets the high.
     *
     * @return the high
     */
    public double getHigh() {
        return quotevalue.getHigh();
    }

    /**
     * Gets the high as object.
     *
     * @return the high as object
     */
    public Object getHighAsObject() {
        return quotevalue.getHighAsObject();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return quotevalue.getId();
    }

    /**
     * Gets the checks if is estimated B.
     *
     * @return the checks if is estimated B
     */
    public boolean getIsEstimatedB() {
        return quotevalue.getIsEstimatedB();
    }

    /**
     * Gets the known date.
     *
     * @return the known date
     */
    public JDate getKnownDate() {
        return quotevalue.getKnownDate();
    }

    /**
     * Gets the last.
     *
     * @return the last
     */
    public double getLast() {
        return quotevalue.getLast();
    }

    /**
     * Gets the last as object.
     *
     * @return the last as object
     */
    public Object getLastAsObject() {
        return quotevalue.getLastAsObject();
    }

    /**
     * Gets the low.
     *
     * @return the low
     */
    public double getLow() {
        return quotevalue.getLow();
    }

    /**
     * Gets the low as object.
     *
     * @return the low as object
     */
    public Object getLowAsObject() {
        return quotevalue.getLowAsObject();
    }

    /**
     * Gets the mid.
     *
     * @return the mid
     */
    public double getMid() {
        return quotevalue.getMid();
    }

    /**
     * Gets the mid as object.
     *
     * @return the mid as object
     */
    public Object getMidAsObject() {
        return quotevalue.getMidAsObject();
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return quotevalue.getName();
    }

    /**
     * Gets the null value.
     *
     * @return the null value
     */
    public double getNullValue() {
        return QuoteValue.getNullValue();
    }

    /**
     * Gets the open.
     *
     * @return the open
     */
    public double getOpen() {
        return quotevalue.getOpen();
    }

    /**
     * Gets the open as object.
     *
     * @return the open as object
     */
    public Object getOpenAsObject() {
        return quotevalue.getOpenAsObject();
    }

    /**
     * Gets the persistent ask.
     *
     * @return the persistent ask
     */
    public double getPersistentAsk() {
        return quotevalue.getPersistentAsk();
    }

    /**
     * Gets the persistent bid.
     *
     * @return the persistent bid
     */
    public double getPersistentBid() {
        return quotevalue.getPersistentBid();
    }

    /**
     * Gets the price source name.
     *
     * @return the price source name
     */
    public String getPriceSourceName() {
        return quotevalue.getPriceSourceName();
    }

    /**
     * Gets the quote set name.
     *
     * @return the quote set name
     */
    public String getQuoteSetName() {
        return quotevalue.getQuoteSetName();
    }

    /**
     * Gets the quote type.
     *
     * @return the quote type
     */
    public String getQuoteType() {
        return quotevalue.getQuoteType();
    }

    /**
     * Gets the source name.
     *
     * @return the source name
     */
    public String getSourceName() {
        return quotevalue.getSourceName();
    }

    /**
     * Gets the true known date.
     *
     * @return the true known date
     */
    public JDate getTrueKnownDate() {
        return quotevalue.getTrueKnownDate();
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public DisplayValue getType() {
        return quotevalue.getType();
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public String getUser() {
        return quotevalue.getUser();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
        return quotevalue.getVersion();
    }

}
