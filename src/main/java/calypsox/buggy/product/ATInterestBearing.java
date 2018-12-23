package calypsox.buggy.product;

import java.util.List;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.Trade;
import com.calypso.tk.marketdata.PricingEnv;
import com.calypso.tk.product.InterestBearing;

import calypsox.buggy.refdata.ATAccount;
import calypsox.buggy.ui.ATAmount;

/**
 * The Class ATInterestBearing.
 */
public class ATInterestBearing extends ATSimpleTransfer {

    /** The interestbearing. */
    private final InterestBearing interestbearing;

    /**
     * Instantiates a new AT interest bearing.
     *
     * @param trade
     *            the trade
     */
    public ATInterestBearing(final Trade trade) {
        super(trade);
        interestbearing = (InterestBearing) trade.getProduct();
    }

    /**
     * Gets the account.
     *
     * @return the account
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATAccount getAccount() throws CalypsoServiceException {
        return new ATAccount(interestbearing.getAccountId());
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    @Override
    public String getCurrency() {
        return interestbearing.getCurrency();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    @Override
    public String getDescription() {
        return interestbearing.getDescription();
    }

    /**
     * Gets the dest account id.
     *
     * @return the dest account id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATAccount getDestAccountId() throws CalypsoServiceException {
        return new ATAccount(interestbearing.getDestAccountId());
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public JDate getEndDate() {
        return interestbearing.getEndDate();
    }

    /**
     * Gets the entries.
     *
     * @return the entries
     */
    public List getEntries() {
        return interestbearing.getEntries();
    }

    /**
     * Gets the interests.
     *
     * @return the interests
     */
    public ATAmount getInterests() {
        return new ATAmount(interestbearing.getSettleCurrency(), interestbearing.getInterests());
    }

    /**
     * Gets the maturity date.
     *
     * @return the maturity date
     */
    public JDate getMaturityDate() {
        return interestbearing.getMaturityDate();
    }

    /**
     * Gets the payment date.
     *
     * @return the payment date
     */
    public JDate getPaymentDate() {
        return interestbearing.getPaymentDate();
    }

    /**
     * Gets the pricing env.
     *
     * @return the pricing env
     */
    public PricingEnv getPricingEnv() {
        return interestbearing.getPricingEnv();
    }

    /**
     * Gets the rounding method.
     *
     * @return the rounding method
     */
    public String getRoundingMethod() {
        return interestbearing.getRoundingMethod();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATTrade#getSettleCurrency()
     */
    @Override
    public String getSettleCurrency() {
        return interestbearing.getSettleCurrency();
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public JDate getStartDate() {
        return interestbearing.getStartDate();
    }

    /**
     * Gets the threshold.
     *
     * @return the threshold
     */
    public double getThreshold() {
        return interestbearing.getThreshold();
    }
}
