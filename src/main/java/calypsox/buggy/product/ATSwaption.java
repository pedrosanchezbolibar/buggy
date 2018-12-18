package calypsox.buggy.product;

import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.calypso.tk.core.CashFlowSet;
import com.calypso.tk.core.DateRoll;
import com.calypso.tk.core.Frequency;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.Product;
import com.calypso.tk.core.ProductException;
import com.calypso.tk.core.Tenor;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.Swap;
import com.calypso.tk.product.SwapLeg;
import com.calypso.tk.product.Swaption;
import com.calypso.tk.product.Swaption.ThresholdUnitType;
import com.calypso.tk.refdata.RateIndex;

/**
 * The Class ATSwaption.
 */
public class ATSwaption extends ATTrade {

    /** The swaption. */
    private final Swaption swaption;

    /**
     * Instantiates a new AT swaption.
     *
     * @param trade
     *            the trade
     */
    public ATSwaption(final Trade trade) {
        super(trade);
        swaption = (Swaption) trade.getProduct();
    }

    /**
     * Gets the all flows.
     *
     * @return the all flows
     */
    public CashFlowSet getAllFlows() {
        return swaption.getAllFlows();
    }

    /**
     * Gets the auto exercise B.
     *
     * @return the auto exercise B
     */
    public boolean getAutoExerciseB() {
        return swaption.getAutoExerciseB();
    }

    /**
     * Gets the cash settle info.
     *
     * @return the cash settle info
     */
    public List getCashSettleInfo() {
        return swaption.getCashSettleInfo();
    }

    /**
     * Gets the currencies and indexes.
     *
     * @return the currencies and indexes
     */
    public Map getCurrenciesAndIndexes() {
        return swaption.getCurrenciesAndIndexes();
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return swaption.getCurrency();
    }

    /**
     * Gets the custom flows B.
     *
     * @return the custom flows B
     */
    public boolean getCustomFlowsB() {
        return swaption.getCustomFlowsB();
    }

    /**
     * Gets the default date roll.
     *
     * @return the default date roll
     */
    public DateRoll getDefaultDateRoll() {
        return swaption.getDefaultDateRoll();
    }

    /**
     * Gets the default frequency.
     *
     * @return the default frequency
     */
    public Frequency getDefaultFrequency() {
        return swaption.getDefaultFrequency();
    }

    /**
     * Gets the default holidays.
     *
     * @return the default holidays
     */
    public List getDefaultHolidays() {
        return swaption.getDefaultHolidays();
    }

    /**
     * Gets the default rate index.
     *
     * @return the default rate index
     */
    public RateIndex getDefaultRateIndex() {
        return swaption.getDefaultRateIndex();
    }

    /**
     * Gets the delivery date.
     *
     * @return the delivery date
     */
    public JDate getDeliveryDate() {
        return swaption.getDeliveryDate();
    }

    /**
     * Gets the delivery dates.
     *
     * @return the delivery dates
     * @throws ProductException
     *             the product exception
     */
    public List getDeliveryDates() throws ProductException {
        return swaption.getDeliveryDates();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return swaption.getDescription();
    }

    /**
     * Gets the digital payment type.
     *
     * @return the digital payment type
     */
    public String getDigitalPaymentType() {
        return swaption.getDigitalPaymentType();
    }

    /**
     * Gets the down barrier type.
     *
     * @return the down barrier type
     */
    public String getDownBarrierType() {
        return swaption.getDownBarrierType();
    }

    /**
     * Gets the down barrier value.
     *
     * @return the down barrier value
     */
    public double getDownBarrierValue() {
        return swaption.getDownBarrierValue();
    }

    /**
     * Gets the exercise dates.
     *
     * @return the exercise dates
     * @throws ProductException
     *             the product exception
     */
    public List getExerciseDates() throws ProductException {
        return swaption.getExerciseDates();
    }

    /**
     * Gets the exercised date.
     *
     * @return the exercised date
     */
    public JDate getExercisedDate() {
        return swaption.getExercisedDate();
    }

    /**
     * Gets the exercise fees.
     *
     * @return the exercise fees
     * @throws ProductException
     *             the product exception
     */
    public double[] getExerciseFees() throws ProductException {
        return swaption.getExerciseFees();
    }

    /**
     * Gets the exercise type.
     *
     * @return the exercise type
     */
    public String getExerciseType() {
        return swaption.getExerciseType();
    }

    /**
     * Gets the exercise type domain.
     *
     * @return the exercise type domain
     */
    public List getExerciseTypeDomain() {
        return Swaption.getExerciseTypeDomain();
    }

    /**
     * Gets the exotic financial legs.
     *
     * @return the exotic financial legs
     */
    public List getExoticFinancialLegs() {
        return swaption.getExoticFinancialLegs();
    }

    /**
     * Gets the expiry date.
     *
     * @return the expiry date
     */
    public JDate getExpiryDate() {
        return swaption.getExpiryDate();
    }

    /**
     * Gets the expiry datetime.
     *
     * @return the expiry datetime
     */
    public JDatetime getExpiryDatetime() {
        return swaption.getExpiryDatetime();
    }

    /**
     * Gets the expiry time.
     *
     * @return the expiry time
     */
    public int getExpiryTime() {
        return swaption.getExpiryTime();
    }

    /**
     * Gets the expiry time zone.
     *
     * @return the expiry time zone
     */
    public TimeZone getExpiryTimeZone() {
        return swaption.getExpiryTimeZone();
    }

    /**
     * Gets the extended type.
     *
     * @return the extended type
     */
    public String getExtendedType() {
        return swaption.getExtendedType();
    }

    /**
     * Gets the first exercise date.
     *
     * @return the first exercise date
     */
    public JDate getFirstExerciseDate() {
        return swaption.getFirstExerciseDate();
    }

    /**
     * Gets the first exercise time.
     *
     * @return the first exercise time
     */
    public int getFirstExerciseTime() {
        return swaption.getFirstExerciseTime();
    }

    /**
     * Gets the checks if is exotic.
     *
     * @return the checks if is exotic
     */
    public boolean getIsExotic() {
        return swaption.getIsExotic();
    }

    /**
     * Gets the checks if is premium percentage.
     *
     * @return the checks if is premium percentage
     */
    public boolean getIsPremiumPercentage() {
        return swaption.getIsPremiumPercentage();
    }

    /**
     * Gets the checks if is XC cy.
     *
     * @return the checks if is XC cy
     */
    public boolean getisXCCy() {
        return swaption.getisXCCy();
    }

    /**
     * Gets the last exercise time.
     *
     * @return the last exercise time
     */
    public int getLastExerciseTime() {
        return swaption.getLastExerciseTime();
    }

    /**
     * Gets the legs.
     *
     * @return the legs
     */
    public List getLegs() {
        return swaption.getLegs();
    }

    /**
     * Gets the mandatory termination B.
     *
     * @return the mandatory termination B
     */
    public boolean getMandatoryTerminationB() {
        return swaption.getMandatoryTerminationB();
    }

    /**
     * Gets the maturity date.
     *
     * @return the maturity date
     */
    public JDate getMaturityDate() {
        return swaption.getMaturityDate();
    }

    /**
     * Gets the maximum notional amount.
     *
     * @return the maximum notional amount
     */
    public double getMaximumNotionalAmount() {
        return swaption.getMaximumNotionalAmount();
    }

    /**
     * Gets the minimum notional amount.
     *
     * @return the minimum notional amount
     */
    public double getMinimumNotionalAmount() {
        return swaption.getMinimumNotionalAmount();
    }

    /**
     * Gets the multiple exercise B.
     *
     * @return the multiple exercise B
     */
    public boolean getMultipleExerciseB() {
        return swaption.getMultipleExerciseB();
    }

    /**
     * Gets the only included schedule.
     *
     * @return the only included schedule
     */
    public List getOnlyIncludedSchedule() {
        return swaption.getOnlyIncludedSchedule();
    }

    /**
     * Gets the option calc bus B.
     *
     * @return the option calc bus B
     */
    public boolean getOptionCalcBusB() {
        return swaption.getOptionCalcBusB();
    }

    /**
     * Gets the option calc holidays.
     *
     * @return the option calc holidays
     */
    public List getOptionCalcHolidays() {
        return swaption.getOptionCalcHolidays();
    }

    /**
     * Gets the option calc offset.
     *
     * @return the option calc offset
     */
    public int getOptionCalcOffset() {
        return swaption.getOptionCalcOffset();
    }

    /**
     * Gets the option calc offset days B.
     *
     * @return the option calc offset days B
     */
    public boolean getOptionCalcOffsetDaysB() {
        return swaption.getOptionCalcOffsetDaysB();
    }

    /**
     * Gets the option date roll.
     *
     * @return the option date roll
     */
    public DateRoll getOptionDateRoll() {
        return swaption.getOptionDateRoll();
    }

    /**
     * Gets the option expiry holidays.
     *
     * @return the option expiry holidays
     */
    public List getOptionExpiryHolidays() {
        return swaption.getOptionExpiryHolidays();
    }

    /**
     * Gets the option frequency.
     *
     * @return the option frequency
     */
    public Frequency getOptionFrequency() {
        return swaption.getOptionFrequency();
    }

    /**
     * Gets the option from date.
     *
     * @return the option from date
     */
    public JDate getOptionFromDate() {
        return swaption.getOptionFromDate();
    }

    /**
     * Gets the option roll day.
     *
     * @return the option roll day
     */
    public int getOptionRollDay() {
        return swaption.getOptionRollDay();
    }

    /**
     * Gets the option schedule lock.
     *
     * @return the option schedule lock
     */
    public boolean getOptionScheduleLock() {
        return swaption.getOptionScheduleLock();
    }

    /**
     * Gets the option to date.
     *
     * @return the option to date
     */
    public JDate getOptionToDate() {
        return swaption.getOptionToDate();
    }

    /**
     * Gets the partial exercise B.
     *
     * @return the partial exercise B
     */
    public boolean getPartialExerciseB() {
        return swaption.getPartialExerciseB();
    }

    /**
     * Gets the premium.
     *
     * @return the premium
     */
    public double getPremium() {
        return swaption.getPremium();
    }

    /**
     * Gets the premium as amount.
     *
     * @return the premium as amount
     */
    public double getPremiumAsAmount() {
        return swaption.getPremiumAsAmount();
    }

    /**
     * Gets the premium percentage.
     *
     * @return the premium percentage
     */
    public double getPremiumPercentage() {
        return swaption.getPremiumPercentage();
    }

    /**
     * Gets the principal.
     *
     * @return the principal
     */
    public double getPrincipal() {
        return swaption.getPrincipal();
    }

    /**
     * Gets the product class.
     *
     * @return the product class
     */
    public String getProductClass() {
        return swaption.getProductClass();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATTrade#getProductFamily()
     */
    @Override
    public String getProductFamily() {
        return swaption.getProductFamily();
    }

    /**
     * Gets the put call.
     *
     * @return the put call
     */
    public int getPutCall() {
        return swaption.getPutCall();
    }

    /**
     * Gets the quote rate.
     *
     * @return the quote rate
     */
    public String getQuoteRate() {
        return swaption.getQuoteRate();
    }

    /**
     * Gets the rate index.
     *
     * @return the rate index
     */
    public RateIndex getRateIndex() {
        return swaption.getRateIndex();
    }

    /**
     * Gets the rate source.
     *
     * @return the rate source
     */
    public String getRateSource() {
        return swaption.getRateSource();
    }

    /**
     * Gets the rebate.
     *
     * @return the rebate
     */
    public double getRebate() {
        return swaption.getRebate();
    }

    /**
     * Gets the schedule.
     *
     * @return the schedule
     */
    public List getSchedule() {
        return swaption.getSchedule();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATTrade#getSettleCurrency()
     */
    @Override
    public String getSettleCurrency() {
        return swaption.getSettleCurrency();
    }

    /**
     * Gets the settle currency 2.
     *
     * @return the settle currency 2
     */
    public String getSettleCurrency2() {
        return swaption.getSettleCurrency2();
    }

    /**
     * Gets the settle location.
     *
     * @return the settle location
     */
    public String getSettleLocation() {
        return swaption.getSettleLocation();
    }

    /**
     * Gets the settlement type.
     *
     * @return the settlement type
     */
    public String getSettlementType() {
        return swaption.getSettlementType();
    }

    /**
     * Gets the settle rate.
     *
     * @return the settle rate
     */
    public double getSettleRate() {
        return swaption.getSettleRate();
    }

    /**
     * Gets the settle reference banks.
     *
     * @return the settle reference banks
     */
    public String getSettleReferenceBanks() {
        return swaption.getSettleReferenceBanks();
    }

    /**
     * Gets the straddle B.
     *
     * @return the straddle B
     */
    public boolean getStraddleB() {
        return swaption.getStraddleB();
    }

    /**
     * Gets the strike.
     *
     * @return the strike
     */
    public double getStrike() {
        return swaption.getStrike();
    }

    /**
     * Gets the sub type.
     *
     * @return the sub type
     */
    public String getSubType() {
        return swaption.getSubType();
    }

    /**
     * Gets the termination dates.
     *
     * @return the termination dates
     */
    public List getTerminationDates() {
        return swaption.getTerminationDates();
    }

    /**
     * Gets the threshold.
     *
     * @return the threshold
     */
    public double getThreshold() {
        return swaption.getThreshold();
    }

    /**
     * Gets the threshold unit type.
     *
     * @return the threshold unit type
     */
    public ThresholdUnitType getThresholdUnitType() {
        return swaption.getThresholdUnitType();
    }

    /**
     * Gets the underlying constant maturity B.
     *
     * @return the underlying constant maturity B
     */
    public boolean getUnderlyingConstantMaturityB() {
        return swaption.getUnderlyingConstantMaturityB();
    }

    /**
     * Gets the underlying maturity tenor.
     *
     * @return the underlying maturity tenor
     */
    public Tenor getUnderlyingMaturityTenor() {
        return swaption.getUnderlyingMaturityTenor();
    }

    /**
     * Gets the underlying pay leg.
     *
     * @return the underlying pay leg
     */
    public SwapLeg getUnderlyingPayLeg() {
        return swaption.getUnderlyingPayLeg();
    }

    /**
     * Gets the underlying product.
     *
     * @return the underlying product
     */
    public Product getUnderlyingProduct() {
        return swaption.getUnderlyingProduct();
    }

    /**
     * Gets the underlying receive leg.
     *
     * @return the underlying receive leg
     */
    public SwapLeg getUnderlyingReceiveLeg() {
        return swaption.getUnderlyingReceiveLeg();
    }

    /**
     * Gets the underlying start date offset.
     *
     * @return the underlying start date offset
     */
    public int getUnderlyingStartDateOffset() {
        return swaption.getUnderlyingStartDateOffset();
    }

    /**
     * Gets the underlying swap.
     *
     * @return the underlying swap
     */
    public Swap getUnderlyingSwap() {
        return swaption.getUnderlyingSwap();
    }

    /**
     * Gets the up barrier type.
     *
     * @return the up barrier type
     */
    public String getUpBarrierType() {
        return swaption.getUpBarrierType();
    }

    /**
     * Gets the up barrier value.
     *
     * @return the up barrier value
     */
    public double getUpBarrierValue() {
        return swaption.getUpBarrierValue();
    }

    /**
     * Gets the used holidays.
     *
     * @return the used holidays
     */
    public String[] getUsedHolidays() {
        return swaption.getUsedHolidays();
    }

    /**
     * Gets the valuation business days.
     *
     * @return the valuation business days
     */
    public String getValuationBusinessDays() {
        return swaption.getValuationBusinessDays();
    }

    /**
     * Gets the valuation date.
     *
     * @return the valuation date
     */
    public JDate getValuationDate() {
        return swaption.getValuationDate();
    }
}
