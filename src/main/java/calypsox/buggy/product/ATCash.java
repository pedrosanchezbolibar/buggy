package calypsox.buggy.product;

import java.util.List;
import java.util.Vector;

import com.calypso.tk.core.CashFlowSet;
import com.calypso.tk.core.DateRoll;
import com.calypso.tk.core.DateRule;
import com.calypso.tk.core.DayCount;
import com.calypso.tk.core.Frequency;
import com.calypso.tk.core.PeriodRule;
import com.calypso.tk.core.RoundingMethod;
import com.calypso.tk.core.StubRule;
import com.calypso.tk.core.Tenor;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.Cash;
import com.calypso.tk.product.EventTypeAction;
import com.calypso.tk.product.flow.CashFlowInterest;
import com.calypso.tk.product.flow.IndexCalculator;
import com.calypso.tk.product.util.InterpStyle;

import calypsox.buggy.refdata.ATJDate;
import calypsox.buggy.ui.ATAmount;

/**
 * The Class ATCash.
 */
public class ATCash extends ATTSimpleMM {

    /** The product cash. */
    private final Cash cash;

    /**
     * Instantiates a new atcash.
     *
     * @param trade
     *            the trade
     */
    public ATCash(final Trade trade) {
        super(trade);
        cash = (Cash) trade.getProduct();
    }

    /**
     * Gets the payment holidays.
     *
     * @return the payment holidays
     */
    @SuppressWarnings("unchecked")
    public List<String> getPaymentHolidays() {
        return cash.getPaymentHolidays();
    }

    /**
     * Gets the roll over B.
     *
     * @return the roll over B
     */
    public boolean getRollOverB() {
        return cash.getRollOverB();
    }

    /**
     * Gets the payment frequency.
     *
     * @return the payment frequency
     */
    public Frequency getPaymentFrequency() {
        return cash.getPaymentFrequency();
    }

    /**
     * Gets the compound frequency.
     *
     * @return the compound frequency
     */
    public Frequency getCompoundFrequency() {
        return cash.getCompoundFrequency();
    }

    /**
     * Gets the amort rate.
     *
     * @return the amort rate
     */
    public double getAmortRate() {
        return cash.getAmortRate();
    }

    /**
     * Gets the amort frequency.
     *
     * @return the amort frequency
     */
    public Frequency getAmortFrequency() {
        return cash.getAmortFrequency();
    }

    /**
     * Gets the date roll.
     *
     * @return the date roll
     */
    public DateRoll getDateRoll() {
        return cash.getDateRoll();
    }

    /**
     * Gets the interest rule.
     *
     * @return the interest rule
     */
    public PeriodRule getInterestRule() {
        return cash.getInterestRule();
    }

    /**
     * Gets the stub rule.
     *
     * @return the stub rule
     */
    public StubRule getStubRule() {
        return cash.getStubRule();
    }

    /**
     * Gets the start stub date.
     *
     * @return the start stub date
     */
    public ATJDate getStartStubDate() {
        return new ATJDate(cash.getStartStubDate());
    }

    /**
     * Gets the end stub date.
     *
     * @return the end stub date
     */
    public ATJDate getEndStubDate() {
        return new ATJDate(cash.getEndStubDate());
    }

    /**
     * Gets the rolling day.
     *
     * @return the rolling day
     */
    public int getRollingDay() {
        return cash.getRollingDay();
    }

    /**
     * Gets the linked id.
     *
     * @return the linked id
     */
    public int getLinkedId() {
        return cash.getLinkedId();
    }

    /**
     * Gets the roll over amount.
     *
     * @return the roll over amount
     */
    public double getRollOverAmount() {
        return cash.getRollOverAmount();
    }

    /**
     * Gets the capitalize int B.
     *
     * @return the capitalize int B
     */
    public boolean getCapitalizeIntB() {
        return cash.getCapitalizeIntB();
    }

    /**
     * Gets the roll over date.
     *
     * @return the roll over date
     */
    public ATJDate getRollOverDate() {
        return new ATJDate(cash.getRollOverDate());
    }

    /**
     * Gets the amortizing B.
     *
     * @return the amortizing B
     */
    public boolean getAmortizingB() {
        return cash.getAmortizingB();
    }

    /**
     * Gets the amort amount.
     *
     * @return the amort amount
     */
    public ATAmount getAmortAmount() {
        return new ATAmount(cash.getCurrency(), cash.getAmortAmount());
    }

    /**
     * Gets the amort type.
     *
     * @return the amort type
     */
    public String getAmortType() {
        return cash.getAmortType();
    }

    /**
     * Gets the principal actual B.
     *
     * @return the principal actual B
     */
    public boolean getPrincipalActualB() {
        return cash.getPrincipalActualB();
    }

    /**
     * Gets the pmt offset.
     *
     * @return the pmt offset
     */
    public int getPmtOffset() {
        return cash.getPmtOffset();
    }

    /**
     * Gets the pmt offset bus day B.
     *
     * @return the pmt offset bus day B
     */
    public boolean getPmtOffsetBusDayB() {
        return cash.getPmtOffsetBusDayB();
    }

    /**
     * Gets the use custom reset offset B.
     *
     * @return the use custom reset offset B
     */
    public boolean getUseCustomResetOffsetB() {
        return cash.getUseCustomResetOffsetB();
    }

    /**
     * Gets the reset offset bus day B.
     *
     * @return the reset offset bus day B
     */
    public boolean getResetOffsetBusDayB() {
        return cash.getResetOffsetBusDayB();
    }

    /**
     * Gets the reset offset.
     *
     * @return the reset offset
     */
    public int getResetOffset() {
        return cash.getResetOffset();
    }

    /**
     * Gets the reset holidays.
     *
     * @return the reset holidays
     */
    @SuppressWarnings("unchecked")
    public List<String> getResetHolidays() {
        return cash.getResetHolidays();
    }

    /**
     * Gets the coupon period date rule.
     *
     * @return the coupon period date rule
     */
    public DateRule getCouponPeriodDateRule() {
        return cash.getCouponPeriodDateRule();
    }

    /**
     * Gets the amort schedule.
     *
     * @return the amort schedule
     */
    public Vector getAmortSchedule() {
        // TODO: check the rigth return type
        return cash.getAmortSchedule();
    }

    /**
     * Gets the compounding method.
     *
     * @return the compounding method
     */
    public String getCompoundingMethod() {
        return cash.getCompoundingMethod();
    }

    /**
     * Gets the cf generation locks.
     *
     * @return the cf generation locks
     */
    public long getCfGenerationLocks() {
        return cash.getCfGenerationLocks();
    }

    /**
     * Gets the cf custom changes.
     *
     * @return the cf custom changes
     */
    public long getCfCustomChanges() {
        return cash.getCfCustomChanges();
    }

    /**
     * Gets the amort day count.
     *
     * @return the amort day count
     */
    public DayCount getAmortDayCount() {
        return cash.getAmortDayCount();
    }

    /**
     * Gets the first stub custom idx B.
     *
     * @return the first stub custom idx B
     */
    public boolean getFirstStubCustomIdxB() {
        return cash.getFirstStubCustomIdxB();
    }

    /**
     * Gets the first stub idx tenor 1.
     *
     * @return the first stub idx tenor 1
     */
    public Tenor getFirstStubIdxTenor1() {
        return cash.getFirstStubIdxTenor1();
    }

    /**
     * Gets the first stub idx tenor 2.
     *
     * @return the first stub idx tenor 2
     */
    public Tenor getFirstStubIdxTenor2() {
        return cash.getFirstStubIdxTenor2();
    }

    /**
     * Gets the last stub custom idx B.
     *
     * @return the last stub custom idx B
     */
    public boolean getLastStubCustomIdxB() {
        return cash.getLastStubCustomIdxB();
    }

    /**
     * Gets the last stub idx tenor 1.
     *
     * @return the last stub idx tenor 1
     */
    public Tenor getLastStubIdxTenor1() {
        return cash.getLastStubIdxTenor1();
    }

    /**
     * Gets the last stub idx tenor 2.
     *
     * @return the last stub idx tenor 2
     */
    public Tenor getLastStubIdxTenor2() {
        return cash.getLastStubIdxTenor2();
    }

    /**
     * Gets the termination dates.
     *
     * @return the termination dates
     */
    public Vector getTerminationDates() {
        // TODO: check the rigth return type
        return cash.getTerminationDates();
    }

    /**
     * Gets the mandatory termination B.
     *
     * @return the mandatory termination B
     */
    public boolean getMandatoryTerminationB() {
        return cash.getMandatoryTerminationB();
    }

    /**
     * Gets the reset date rule.
     *
     * @return the reset date rule
     */
    public DateRule getResetDateRule() {
        return cash.getResetDateRule();
    }

    /**
     * Gets the pmt date rule.
     *
     * @return the pmt date rule
     */
    public DateRule getPmtDateRule() {
        return cash.getPmtDateRule();
    }

    /**
     * Gets the pmt date rule int.
     *
     * @return the pmt date rule int
     */
    public DateRule getPmtDateRuleInt() {
        return cash.getPmtDateRuleInt();
    }

    /**
     * Gets the coupon date rule.
     *
     * @return the coupon date rule
     */
    public DateRule getCouponDateRule() {
        return cash.getCouponDateRule();
    }

    /**
     * Gets the index factor.
     *
     * @return the index factor
     */
    public double getIndexFactor() {
        return cash.getIndexFactor();
    }

    /**
     * Gets the cap strike.
     *
     * @return the cap strike
     */
    public double getCapStrike() {
        return cash.getCapStrike();
    }

    /**
     * Gets the floor strike.
     *
     * @return the floor strike
     */
    public double getFloorStrike() {
        return cash.getFloorStrike();
    }

    /**
     * Gets the option type.
     *
     * @return the option type
     */
    public String getOptionType() {
        return cash.getOptionType();
    }

    /**
     * Gets the floater B.
     *
     * @return the floater B
     */
    public boolean getFloaterB() {
        return cash.getFloaterB();
    }

    /**
     * Gets the withholding tax rate.
     *
     * @return the withholding tax rate
     */
    public double getWithholdingTaxRate() {
        return cash.getWithholdingTaxRate();
    }

    /**
     * Gets the averaging reset B.
     *
     * @return the averaging reset B
     */
    public boolean getAveragingResetB() {
        return cash.getAveragingResetB();
    }

    /**
     * Gets the averaging reset method.
     *
     * @return the averaging reset method
     */
    public String getAveragingResetMethod() {
        return cash.getAveragingResetMethod();
    }

    /**
     * Gets the sample frequency.
     *
     * @return the sample frequency
     */
    public Frequency getSampleFrequency() {
        return cash.getSampleFrequency();
    }

    /**
     * Gets the sample period start offset.
     *
     * @return the sample period start offset
     */
    public int getSamplePeriodStartOffset() {
        return cash.getSamplePeriodStartOffset();
    }

    /**
     * Gets the sample period rule.
     *
     * @return the sample period rule
     */
    public String getSamplePeriodRule() {
        return cash.getSamplePeriodRule();
    }

    /**
     * Gets the sample day of week.
     *
     * @return the sample day of week
     */
    public int getSampleDayOfWeek() {
        return cash.getSampleDayOfWeek();
    }

    /**
     * Gets the reset timing.
     *
     * @return the reset timing
     */
    public String getResetTiming() {
        return cash.getResetTiming();
    }

    /**
     * Gets the discount method.
     *
     * @return the discount method
     */
    public int getDiscountMethod() {
        return cash.getDiscountMethod();
    }

    /**
     * Gets the discount method as string.
     *
     * @return the discount method as string
     */
    public String getDiscountMethodAsString() {
        return cash.getDiscountMethodAsString();
    }

    /**
     * Gets the payment timing end per B.
     *
     * @return the payment timing end per B
     */
    public boolean getPaymentTimingEndPerB() {
        return cash.getPaymentTimingEndPerB();
    }

    /**
     * Gets the crystallization days.
     *
     * @return the crystallization days
     */
    public int getCrystallizationDays() {
        return cash.getCrystallizationDays();
    }

    /**
     * Gets the interp style.
     *
     * @return the interp style
     */
    public InterpStyle getInterpStyle() {
        return cash.getInterpStyle();
    }

    /**
     * Gets the reset range.
     *
     * @return the reset range
     */
    public String getResetRange() {
        return cash.getResetRange();
    }

    /**
     * Gets the spread calc mtd.
     *
     * @return the spread calc mtd
     */
    public String getSpreadCalcMtd() {
        return cash.getSpreadCalcMtd();
    }

    /**
     * Gets the rate factor rounding method.
     *
     * @return the rate factor rounding method
     */
    public RoundingMethod getRateFactorRoundingMethod() {
        return cash.getRateFactorRoundingMethod();
    }

    /**
     * Gets the rate factor rounding dec.
     *
     * @return the rate factor rounding dec
     */
    public Integer getRateFactorRoundingDec() {
        return cash.getRateFactorRoundingDec();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    @Override
    public String getDescription() {
        return cash.getDescription();
    }

    /**
     * Gets the custom flows B.
     *
     * @return the custom flows B
     */
    public boolean getCustomFlowsB() {
        return cash.getCustomFlowsB();
    }

    /**
     * Gets the sub type.
     *
     * @return the sub type
     */
    @Override
    public String getSubType() {
        return cash.getSubType();
    }

    /**
     * Gets the period rule.
     *
     * @return the period rule
     */
    public PeriodRule getPeriodRule() {
        return cash.getPeriodRule();
    }

    /**
     * Gets the custom rolling day B.
     *
     * @return the custom rolling day B
     */
    public boolean getCustomRollingDayB() {
        return cash.getCustomRollingDayB();
    }

    /**
     * Gets the coupon date roll.
     *
     * @return the coupon date roll
     */
    public DateRoll getCouponDateRoll() {
        return cash.getCouponDateRoll();
    }

    /**
     * Gets the coupon holidays.
     *
     * @return the coupon holidays
     */
    @SuppressWarnings("unchecked")
    public List<String> getCouponHolidays() {
        return cash.getCouponHolidays();
    }

    /**
     * Gets the fixed rate schedule.
     *
     * @return the fixed rate schedule
     */
    public Vector getFixedRateSchedule() {
        // TODO: check the rigth return type
        return cash.getFixedRateSchedule();
    }

    /**
     * Gets the spread schedule.
     *
     * @return the spread schedule
     */
    public Vector getSpreadSchedule() {
        // TODO: check the rigth return type
        return cash.getSpreadSchedule();
    }

    /**
     * Gets the used holidays.
     *
     * @return the used holidays
     */
    @Override
    public String[] getUsedHolidays() {
        return cash.getUsedHolidays();
    }

    /**
     * Gets the flows.
     *
     * @return the flows
     */
    @Override
    public CashFlowSet getFlows() {
        // TODO: poner aquí la formula para calcular los flujos sui no están
        // customizados
        return cash.getFlows();
    }

    /**
     * Gets the specific resets.
     *
     * @return the specific resets
     */
    public Vector getSpecificResets() {
        // TODO: check the rigth return type
        return cash.getSpecificResets();
    }

    /**
     * Gets the product id.
     *
     * @return the product id
     */
    public int getProductId() {
        return cash.getProductId();
    }

    /**
     * Gets the manual first reset B.
     *
     * @return the manual first reset B
     */
    public boolean getManualFirstResetB() {
        return cash.getManualFirstResetB();
    }

    /**
     * Gets the first reset rate.
     *
     * @return the first reset rate
     */
    public double getFirstResetRate() {
        return cash.getFirstResetRate();
    }

    /**
     * Gets the latest principal amount.
     *
     * @return the latest principal amount
     */
    public ATAmount getLatestPrincipalAmount() {
        return new ATAmount(cash.getCurrency(), cash.getLatestPrincipalAmount());
    }

    /**
     * Gets the current fixed rate.
     *
     * @return the current fixed rate
     */
    public double getCurrentFixedRate() {
        return cash.getCurrentFixedRate();
    }

    /**
     * Gets the event type actions.
     *
     * @return the event type actions
     */
    @SuppressWarnings("unchecked")
    public Vector<EventTypeAction> getEventTypeActions() {
        return cash.getEventTypeActions();
    }

    /**
     * Gets the valid bulk action types.
     *
     * @return the valid bulk action types
     */
    public Vector getValidBulkActionTypes() {
        // TODO: check the rigth return type
        return cash.getValidBulkActionTypes();
    }

    /**
     * Gets the applied action list.
     *
     * @return the applied action list
     */
    @SuppressWarnings("unchecked")
    public Vector<String> getAppliedActionList() {
        return cash.getAppliedActionList();
    }

    /**
     * Gets the applicable event type actions.
     *
     * @return the applicable event type actions
     */
    public Vector getApplicableEventTypeActions() {
        // TODO: check the rigth return type
        return cash.getApplicableEventTypeActions();
    }

    /**
     * Gets the checks if is collateral only B.
     *
     * @return the checks if is collateral only B
     */
    public boolean getIsCollateralOnlyB() {
        return cash.getIsCollateralOnlyB();
    }

    /**
     * Gets the collaterals.
     *
     * @return the collaterals
     */
    public Vector getCollaterals() {
        // TODO: check the rigth return type
        return cash.getCollaterals();
    }

    /**
     * Gets the valid action types.
     *
     * @return the valid action types
     */
    public Vector getValidActionTypes() {
        // TODO: check the rigth return type
        return cash.getValidActionTypes();
    }

    /**
     * Gets the last interest flow.
     *
     * @return the last interest flow
     */
    public CashFlowInterest getLastInterestFlow() {
        return cash.getLastInterestFlow();
    }

    /**
     * Gets the reset period dates.
     *
     * @return the reset period dates
     */
    public Vector getResetPeriodDates() {
        // TODO: check the rigth return type
        return cash.getResetPeriodDates();
    }

    /**
     * Gets the direction.
     *
     * @return the direction
     */
    public String getDirection() {
        return cash.getDirection();
    }

    /**
     * Gets the sign.
     *
     * @return the sign
     */
    public int getSign() {
        return cash.getSign();
    }

    /**
     * Gets the allocator.
     *
     * @return the allocator
     */
    public String getAllocator() {
        return cash.getAllocator();
    }

    /**
     * Gets the event type actions list.
     *
     * @return the event type actions list
     */
    public Vector getEventTypeActionsList() {
        // TODO: check the rigth return type
        return cash.getEventTypeActionsList();
    }

    /**
     * Gets the rate type.
     *
     * @return the rate type
     */
    public String getRateType() {
        return cash.getRateType();
    }

    /**
     * Gets the reset date roll.
     *
     * @return the reset date roll
     */
    public DateRoll getResetDateRoll() {
        return cash.getResetDateRoll();
    }

    /**
     * Gets the index calculator.
     *
     * @return the index calculator
     */
    public IndexCalculator getIndexCalculator() {
        return cash.getIndexCalculator();
    }

    /**
     * Gets the funding currency.
     *
     * @return the funding currency
     */
    public String getFundingCurrency() {
        return cash.getFundingCurrency();
    }

}
