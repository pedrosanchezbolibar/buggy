package calypsox.buggy.product;

import java.util.Map;

import com.calypso.tk.core.Accretion;
import com.calypso.tk.core.CashFlowSet;
import com.calypso.tk.core.DayCount;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.RoundingMethod;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.SimpleMM;
import com.calypso.tk.refdata.RateIndex;

import calypsox.buggy.ui.ATAmount;

/**
 * The Class ATTSimpleMM.
 */
public class ATSimpleMM extends ATTrade {

    /** The simplemm. */
    private final SimpleMM simplemm;

    /**
     * Instantiates a new ATT simple MM.
     *
     * @param trade
     *            the trade
     */
    public ATSimpleMM(final Trade trade) {
        super(trade);
        simplemm = (SimpleMM) trade.getProduct();
    }

    /**
     * Gets the accretion.
     *
     * @return the accretion
     */
    public Accretion getAccretion() {
        return simplemm.getAccretion();
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return simplemm.getCurrency();
    }

    /**
     * Gets the default rounding.
     *
     * @return the default rounding
     */
    public String getDefaultRounding() {
        return simplemm.getDefaultRounding();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return simplemm.getDescription();
    }

    /**
     * Gets the discount B.
     *
     * @return the discount B
     */
    public boolean getDiscountB() {
        return simplemm.getDiscountB();
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public JDate getEndDate() {
        return simplemm.getEndDate();
    }

    /**
     * Gets the fixed day count.
     *
     * @return the fixed day count
     */
    public DayCount getFixedDayCount() {
        return simplemm.getFixedDayCount();
    }

    /**
     * Gets the fixed rate.
     *
     * @return the fixed rate
     */
    public double getFixedRate() {
        return simplemm.getFixedRate();
    }

    /**
     * Gets the fixed rate B.
     *
     * @return the fixed rate B
     */
    public boolean getFixedRateB() {
        return simplemm.getFixedRateB();
    }

    /**
     * Gets the flows.
     *
     * @return the flows
     */
    public CashFlowSet getFlows() {
        return simplemm.getFlows();
    }

    /**
     * Gets the include first B.
     *
     * @return the include first B
     */
    public boolean getIncludeFirstB() {
        return simplemm.getIncludeFirstB();
    }

    /**
     * Gets the include last B.
     *
     * @return the include last B
     */
    public boolean getIncludeLastB() {
        return simplemm.getIncludeLastB();
    }

    /**
     * Gets the maturity date.
     *
     * @return the maturity date
     */
    public JDate getMaturityDate() {
        return simplemm.getMaturityDate();
    }

    /**
     * Gets the notice days.
     *
     * @return the notice days
     */
    public int getNoticeDays() {
        return simplemm.getNoticeDays();
    }

    /**
     * Gets the open term B.
     *
     * @return the open term B
     */
    public boolean getOpenTermB() {
        return simplemm.getOpenTermB();
    }

    /**
     * Gets the params.
     *
     * @return the params
     */
    @SuppressWarnings("unchecked")
    public Map<String, String> getParams() {
        return simplemm.getParams();
    }

    /**
     * Gets the principal amount.
     *
     * @return the principal amount
     */
    public ATAmount getPrincipalAmount() {
        return new ATAmount(simplemm.getCurrency(), simplemm.getPrincipal());
    }

    /**
     * Gets the product class.
     *
     * @return the product class
     */
    public String getProductClass() {
        return simplemm.getProductClass();
    }

    /**
     * Gets the rate index.
     *
     * @return the rate index
     */
    public RateIndex getRateIndex() {
        return simplemm.getRateIndex();
    }

    /**
     * Gets the rounding method.
     *
     * @return the rounding method
     */
    public RoundingMethod getRoundingMethod() {
        return simplemm.getRoundingMethod();
    }

    /**
     * Gets the sales margin.
     *
     * @return the sales margin
     */
    public double getSalesMargin() {
        return simplemm.getSalesMargin();
    }

    /**
     * Gets the spread.
     *
     * @return the spread
     */
    public double getSpread() {
        return simplemm.getSpread();
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public JDate getStartDate() {
        return simplemm.getStartDate();
    }

    /**
     * Gets the sub type.
     *
     * @return the sub type
     */
    public String getSubType() {
        return simplemm.getSubType();
    }

    /**
     * Gets the used holidays.
     *
     * @return the used holidays
     */
    public String[] getUsedHolidays() {
        return simplemm.getUsedHolidays();
    }

}
