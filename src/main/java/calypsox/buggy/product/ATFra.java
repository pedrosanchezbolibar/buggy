package calypsox.buggy.product;

import java.util.List;

import com.calypso.tk.core.CashFlowSet;
import com.calypso.tk.core.DateRoll;
import com.calypso.tk.core.DayCount;
import com.calypso.tk.core.Frequency;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.FRA;
import com.calypso.tk.refdata.RateIndex;

/**
 * The Class ATFra.
 */
public class ATFra extends ATTrade {

    /** The fra. */
    private final FRA fra;

    /**
     * Instantiates a new AT fra.
     *
     * @param trade
     *            the trade
     */
    public ATFra(final Trade trade) {
        super(trade);
        fra = (FRA) trade.getProduct();
    }

    /**
     * Gets the cash settle info.
     *
     * @return the cash settle info
     */
    public List getCashSettleInfo() {
        return fra.getCashSettleInfo();
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return fra.getCurrency();
    }

    /**
     * Gets the day count.
     *
     * @return the day count
     */
    public DayCount getDayCount() {
        return fra.getDayCount();
    }

    /**
     * Gets the default date roll.
     *
     * @return the default date roll
     */
    public DateRoll getDefaultDateRoll() {
        return fra.getDefaultDateRoll();
    }

    /**
     * Gets the default frequency.
     *
     * @return the default frequency
     */
    public Frequency getDefaultFrequency() {
        return fra.getDefaultFrequency();
    }

    /**
     * Gets the default holidays.
     *
     * @return the default holidays
     */
    public List getDefaultHolidays() {
        return fra.getDefaultHolidays();
    }

    /**
     * Gets the default rate index.
     *
     * @return the default rate index
     */
    public RateIndex getDefaultRateIndex() {
        return fra.getDefaultRateIndex();
    }

    /**
     * Gets the default reset offset B.
     *
     * @return the default reset offset B
     */
    public boolean getDefaultResetOffsetB() {
        return fra.getDefaultResetOffsetB();
    }

    /**
     * Gets the default rounding.
     *
     * @return the default rounding
     */
    public String getDefaultRounding() {
        return fra.getDefaultRounding();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return fra.getDescription();
    }

    /**
     * Gets the discount method.
     *
     * @return the discount method
     */
    public String getDiscountMethod() {
        return fra.getDiscountMethod();
    }

    /**
     * Gets the final payment maturity date.
     *
     * @return the final payment maturity date
     */
    public JDate getFinalPaymentMaturityDate() {
        return fra.getFinalPaymentMaturityDate();
    }

    /**
     * Gets the fixed rate.
     *
     * @return the fixed rate
     */
    public double getFixedRate() {
        return fra.getFixedRate();
    }

    /**
     * Gets the flows.
     *
     * @return the flows
     */
    public CashFlowSet getFlows() {
        return fra.getFlows();
    }

    /**
     * Gets the interp from index.
     *
     * @return the interp from index
     */
    public RateIndex getInterpFromIndex() {
        return fra.getInterpFromIndex();
    }

    /**
     * Gets the interpolated B.
     *
     * @return the interpolated B
     */
    public boolean getInterpolatedB() {
        return fra.getInterpolatedB();
    }

    /**
     * Gets the interp to index.
     *
     * @return the interp to index
     */
    public RateIndex getInterpToIndex() {
        return fra.getInterpToIndex();
    }

    /**
     * Gets the maturity date.
     *
     * @return the maturity date
     */
    public JDate getMaturityDate() {
        return fra.getMaturityDate();
    }

    /**
     * Gets the notional.
     *
     * @return the notional
     */
    public double getNotional() {
        return fra.getNotional();
    }

    /**
     * Gets the payment begin date.
     *
     * @return the payment begin date
     */
    public JDate getPaymentBeginDate() {
        return fra.getPaymentBeginDate();
    }

    /**
     * Gets the payment begin date roll.
     *
     * @return the payment begin date roll
     */
    public DateRoll getPaymentBeginDateRoll() {
        return fra.getPaymentBeginDateRoll();
    }

    /**
     * Gets the payment begin holidays.
     *
     * @return the payment begin holidays
     */
    public List getPaymentBeginHolidays() {
        return fra.getPaymentBeginHolidays();
    }

    /**
     * Gets the payment date.
     *
     * @return the payment date
     */
    public JDate getPaymentDate() {
        return fra.getPaymentDate();
    }

    /**
     * Gets the payment date roll.
     *
     * @return the payment date roll
     */
    public DateRoll getPaymentDateRoll() {
        return fra.getPaymentDateRoll();
    }

    /**
     * Gets the payment end date.
     *
     * @return the payment end date
     */
    public JDate getPaymentEndDate() {
        return fra.getPaymentEndDate();
    }

    /**
     * Gets the payment end date roll.
     *
     * @return the payment end date roll
     */
    public DateRoll getPaymentEndDateRoll() {
        return fra.getPaymentEndDateRoll();
    }

    /**
     * Gets the payment end holidays.
     *
     * @return the payment end holidays
     */
    public List getPaymentEndHolidays() {
        return fra.getPaymentEndHolidays();
    }

    /**
     * Gets the payment holidays.
     *
     * @return the payment holidays
     */
    public List getPaymentHolidays() {
        return fra.getPaymentHolidays();
    }

    /**
     * Gets the principal.
     *
     * @return the principal
     */
    public double getPrincipal() {
        return fra.getPrincipal();
    }

    /**
     * Gets the product class.
     *
     * @return the product class
     */
    public String getProductClass() {
        return fra.getProductClass();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATTrade#getProductFamily()
     */
    @Override
    public String getProductFamily() {
        return fra.getProductFamily();
    }

    /**
     * Gets the rate index.
     *
     * @return the rate index
     */
    public RateIndex getRateIndex() {
        return fra.getRateIndex();
    }

    /**
     * Gets the reset date.
     *
     * @return the reset date
     */
    public JDate getResetDate() {
        return fra.getResetDate();
    }

    /**
     * Gets the reset offset.
     *
     * @return the reset offset
     */
    public int getResetOffset() {
        return fra.getResetOffset();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATTrade#getSettleDate()
     */
    @Override
    public JDate getSettleDate() {
        return fra.getSettleDate();
    }

    /**
     * Gets the settle in arrears.
     *
     * @return the settle in arrears
     */
    public boolean getSettleInArrears() {
        return fra.getSettleInArrears();
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public JDate getStartDate() {
        return fra.getStartDate();
    }

    /**
     * Gets the sub type.
     *
     * @return the sub type
     */
    public String getSubType() {
        return fra.getSubType();
    }

    /**
     * Gets the used holidays.
     *
     * @return the used holidays
     */
    public String[] getUsedHolidays() {
        return fra.getUsedHolidays();
    }
}
