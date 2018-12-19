package calypsox.buggy.product;

import java.util.List;
import java.util.Map;

import com.calypso.tk.core.Accretion;
import com.calypso.tk.core.CashFlowSet;
import com.calypso.tk.core.DateRoll;
import com.calypso.tk.core.DateRule;
import com.calypso.tk.core.DayCount;
import com.calypso.tk.core.Frequency;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.PeriodRule;
import com.calypso.tk.core.StubRule;
import com.calypso.tk.core.Tenor;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.CapFloor;
import com.calypso.tk.product.ManualInitialFixing;
import com.calypso.tk.product.flow.InflationInfo;
import com.calypso.tk.product.util.InterpStyle;
import com.calypso.tk.product.util.PayOutFormula;
import com.calypso.tk.refdata.RateIndex;

/**
 * The Class ATCapFloor.
 */
public class ATCapFloor extends ATTrade {

    /** The capfloor. */
    private final CapFloor capfloor;

    /**
     * Instantiates a new AT cap floor.
     *
     * @param trade
     *            the trade
     */
    public ATCapFloor(final Trade trade) {
        super(trade);
        capfloor = (CapFloor) trade.getProduct();
    }

    /**
     * Gets the accretion.
     *
     * @return the accretion
     */
    public Accretion getAccretion() {
        return capfloor.getAccretion();
    }

    /**
     * Gets the activated flows.
     *
     * @return the activated flows
     */
    public List getActivatedFlows() {
        return capfloor.getActivatedFlows();
    }

    /**
     * Gets the actual amort exchange B.
     *
     * @return the actual amort exchange B
     */
    public boolean getActualAmortExchangeB() {
        return capfloor.getActualAmortExchangeB();
    }

    /**
     * Gets the actual final exchange B.
     *
     * @return the actual final exchange B
     */
    public boolean getActualFinalExchangeB() {
        return capfloor.getActualFinalExchangeB();
    }

    /**
     * Gets the actual initial exchange B.
     *
     * @return the actual initial exchange B
     */
    public boolean getActualInitialExchangeB() {
        return capfloor.getActualInitialExchangeB();
    }

    /**
     * Gets the allocator.
     *
     * @return the allocator
     */
    public String getAllocator() {
        return capfloor.getAllocator();
    }

    /**
     * Gets the amort amount.
     *
     * @return the amort amount
     */
    public double getAmortAmount() {
        return capfloor.getAmortAmount();
    }

    /**
     * Gets the amort day count.
     *
     * @return the amort day count
     */
    public DayCount getAmortDayCount() {
        return capfloor.getAmortDayCount();
    }

    /**
     * Gets the amort frequency.
     *
     * @return the amort frequency
     */
    public Frequency getAmortFrequency() {
        return capfloor.getAmortFrequency();
    }

    /**
     * Gets the amort rate.
     *
     * @return the amort rate
     */
    public double getAmortRate() {
        return capfloor.getAmortRate();
    }

    /**
     * Gets the amort schedule.
     *
     * @return the amort schedule
     */
    public List getAmortSchedule() {
        return capfloor.getAmortSchedule();
    }

    /**
     * Gets the ATM pay off B.
     *
     * @return the ATM pay off B
     */
    public boolean getATMPayOffB() {
        return capfloor.getATMPayOffB();
    }

    /**
     * Gets the averaging reset B.
     *
     * @return the averaging reset B
     */
    public boolean getAveragingResetB() {
        return capfloor.getAveragingResetB();
    }

    /**
     * Gets the averaging reset method.
     *
     * @return the averaging reset method
     */
    public String getAveragingResetMethod() {
        return capfloor.getAveragingResetMethod();
    }

    /**
     * Gets the barrier.
     *
     * @return the barrier
     */
    public double getBarrier() {
        return capfloor.getBarrier();
    }

    /**
     * Gets the barrier type.
     *
     * @return the barrier type
     */
    public String getBarrierType() {
        return capfloor.getBarrierType();
    }

    /**
     * Gets the cap floor type.
     *
     * @return the cap floor type
     */
    public String getCapFloorType() {
        return capfloor.getCapFloorType();
    }

    /**
     * Gets the cap strike.
     *
     * @return the cap strike
     */
    public double getCapStrike() {
        return capfloor.getCapStrike();
    }

    /**
     * Gets the cap strike schedule.
     *
     * @return the cap strike schedule
     */
    public List getCapStrikeSchedule() {
        return capfloor.getCapStrikeSchedule();
    }

    /**
     * Gets the cash settle info.
     *
     * @return the cash settle info
     */
    public List getCashSettleInfo() {
        return capfloor.getCashSettleInfo();
    }

    /**
     * Gets the cf custom changes.
     *
     * @return the cf custom changes
     */
    public long getCfCustomChanges() {
        return capfloor.getCfCustomChanges();
    }

    /**
     * Gets the cf generation locks.
     *
     * @return the cf generation locks
     */
    public long getCfGenerationLocks() {
        return capfloor.getCfGenerationLocks();
    }

    /**
     * Gets the coupon currency.
     *
     * @return the coupon currency
     */
    public String getCouponCurrency() {
        return capfloor.getCouponCurrency();
    }

    /**
     * Gets the coupon date roll.
     *
     * @return the coupon date roll
     */
    public DateRoll getCouponDateRoll() {
        return capfloor.getCouponDateRoll();
    }

    /**
     * Gets the coupon date rule.
     *
     * @return the coupon date rule
     */
    public DateRule getCouponDateRule() {
        return capfloor.getCouponDateRule();
    }

    /**
     * Gets the coupon day count.
     *
     * @return the coupon day count
     */
    public DayCount getCouponDayCount() {
        return capfloor.getCouponDayCount();
    }

    /**
     * Gets the coupon frequency.
     *
     * @return the coupon frequency
     */
    public Frequency getCouponFrequency() {
        return capfloor.getCouponFrequency();
    }

    /**
     * Gets the coupon frequency domain.
     *
     * @return the coupon frequency domain
     */
    public List getCouponFrequencyDomain() {
        return CapFloor.getCouponFrequencyDomain();
    }

    /**
     * Gets the coupon holidays.
     *
     * @return the coupon holidays
     */
    public List getCouponHolidays() {
        return capfloor.getCouponHolidays();
    }

    /**
     * Gets the coupon offset.
     *
     * @return the coupon offset
     */
    public int getCouponOffset() {
        return capfloor.getCouponOffset();
    }

    /**
     * Gets the coupon offset bus day B.
     *
     * @return the coupon offset bus day B
     */
    public boolean getCouponOffsetBusDayB() {
        return capfloor.getCouponOffsetBusDayB();
    }

    /**
     * Gets the coupon payment at end B.
     *
     * @return the coupon payment at end B
     */
    public boolean getCouponPaymentAtEndB() {
        return capfloor.getCouponPaymentAtEndB();
    }

    /**
     * Gets the coupon stub rule.
     *
     * @return the coupon stub rule
     */
    public StubRule getCouponStubRule() {
        return capfloor.getCouponStubRule();
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return capfloor.getCurrency();
    }

    /**
     * Gets the custom flows B.
     *
     * @return the custom flows B
     */
    public boolean getCustomFlowsB() {
        return capfloor.getCustomFlowsB();
    }

    /**
     * Gets the custom rolling day B.
     *
     * @return the custom rolling day B
     */
    public boolean getCustomRollingDayB() {
        return capfloor.getCustomRollingDayB();
    }

    /**
     * Gets the day count.
     *
     * @return the day count
     */
    public DayCount getDayCount() {
        return capfloor.getDayCount();
    }

    /**
     * Gets the default date roll.
     *
     * @return the default date roll
     */
    public DateRoll getDefaultDateRoll() {
        return capfloor.getDefaultDateRoll();
    }

    /**
     * Gets the default frequency.
     *
     * @return the default frequency
     */
    public Frequency getDefaultFrequency() {
        return capfloor.getDefaultFrequency();
    }

    /**
     * Gets the default holidays.
     *
     * @return the default holidays
     */
    public List getDefaultHolidays() {
        return capfloor.getDefaultHolidays();
    }

    /**
     * Gets the default rate index.
     *
     * @return the default rate index
     */
    public RateIndex getDefaultRateIndex() {
        return capfloor.getDefaultRateIndex();
    }

    /**
     * Gets the default reset offset B.
     *
     * @return the default reset offset B
     */
    public boolean getDefaultResetOffsetB() {
        return capfloor.getDefaultResetOffsetB();
    }

    /**
     * Gets the default rounding.
     *
     * @return the default rounding
     */
    public String getDefaultRounding() {
        return capfloor.getDefaultRounding();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return capfloor.getDescription();
    }

    /**
     * Gets the digital factor.
     *
     * @return the digital factor
     */
    public double getDigitalFactor() {
        return capfloor.getDigitalFactor();
    }

    /**
     * Gets the discount method.
     *
     * @return the discount method
     */
    public int getDiscountMethod() {
        return capfloor.getDiscountMethod();
    }

    /**
     * Gets the discount method as string.
     *
     * @return the discount method as string
     */
    public String getDiscountMethodAsString() {
        return capfloor.getDiscountMethodAsString();
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public JDate getEndDate() {
        return capfloor.getEndDate();
    }

    /**
     * Gets the final payment maturity date.
     *
     * @return the final payment maturity date
     */
    public JDate getFinalPaymentMaturityDate() {
        return capfloor.getFinalPaymentMaturityDate();
    }

    /**
     * Gets the first reset rate.
     *
     * @return the first reset rate
     */
    public double getFirstResetRate() {
        return capfloor.getFirstResetRate();
    }

    /**
     * Gets the first stub custom idx B.
     *
     * @return the first stub custom idx B
     */
    public boolean getFirstStubCustomIdxB() {
        return capfloor.getFirstStubCustomIdxB();
    }

    /**
     * Gets the first stub date.
     *
     * @return the first stub date
     */
    public JDate getFirstStubDate() {
        return capfloor.getFirstStubDate();
    }

    /**
     * Gets the first stub idx tenor 1.
     *
     * @return the first stub idx tenor 1
     */
    public Tenor getFirstStubIdxTenor1() {
        return capfloor.getFirstStubIdxTenor1();
    }

    /**
     * Gets the first stub idx tenor 2.
     *
     * @return the first stub idx tenor 2
     */
    public Tenor getFirstStubIdxTenor2() {
        return capfloor.getFirstStubIdxTenor2();
    }

    /**
     * Gets the floor strike.
     *
     * @return the floor strike
     */
    public double getFloorStrike() {
        return capfloor.getFloorStrike();
    }

    /**
     * Gets the floor strike schedule.
     *
     * @return the floor strike schedule
     */
    public List getFloorStrikeSchedule() {
        return capfloor.getFloorStrikeSchedule();
    }

    /**
     * Gets the flows.
     *
     * @return the flows
     */
    public CashFlowSet getFlows() {
        return capfloor.getFlows();
    }

    /**
     * Gets the include first B.
     *
     * @return the include first B
     */
    public boolean getIncludeFirstB() {
        return capfloor.getIncludeFirstB();
    }

    /**
     * Gets the include first day B.
     *
     * @return the include first day B
     */
    public boolean getIncludeFirstDayB() {
        return capfloor.getIncludeFirstDayB();
    }

    /**
     * Gets the include last day B.
     *
     * @return the include last day B
     */
    public boolean getIncludeLastDayB() {
        return capfloor.getIncludeLastDayB();
    }

    /**
     * Gets the increment.
     *
     * @return the increment
     */
    public double getIncrement() {
        return capfloor.getIncrement();
    }

    /**
     * Gets the increment schedule.
     *
     * @return the increment schedule
     */
    public List getIncrementSchedule() {
        return capfloor.getIncrementSchedule();
    }

    /**
     * Gets the index day count.
     *
     * @return the index day count
     */
    public DayCount getIndexDayCount() {
        return capfloor.getIndexDayCount();
    }

    /**
     * Gets the index factor.
     *
     * @return the index factor
     */
    public double getIndexFactor() {
        return capfloor.getIndexFactor();
    }

    /**
     * Gets the inflation calc method.
     *
     * @return the inflation calc method
     */
    public String getInflationCalcMethod() {
        return capfloor.getInflationCalcMethod();
    }

    /**
     * Gets the inflation first ref date.
     *
     * @return the inflation first ref date
     */
    public JDate getInflationFirstRefDate() {
        return capfloor.getInflationFirstRefDate();
    }

    /**
     * Gets the inflation info.
     *
     * @return the inflation info
     */
    public InflationInfo getInflationInfo() {
        return capfloor.getInflationInfo();
    }

    /**
     * Gets the interp style.
     *
     * @return the interp style
     */
    public InterpStyle getInterpStyle() {
        return capfloor.getInterpStyle();
    }

    /**
     * Gets the checks if is digital B.
     *
     * @return the checks if is digital B
     */
    public boolean getIsDigitalB() {
        return capfloor.getIsDigitalB();
    }

    /**
     * Gets the checks if is end of month.
     *
     * @return the checks if is end of month
     */
    public boolean getIsEndOfMonth() {
        return capfloor.getIsEndOfMonth();
    }

    /**
     * Gets the checks if is exotic.
     *
     * @return the checks if is exotic
     */
    public boolean getIsExotic() {
        return capfloor.getIsExotic();
    }

    /**
     * Gets the last stub custom idx B.
     *
     * @return the last stub custom idx B
     */
    public boolean getLastStubCustomIdxB() {
        return capfloor.getLastStubCustomIdxB();
    }

    /**
     * Gets the last stub date.
     *
     * @return the last stub date
     */
    public JDate getLastStubDate() {
        return capfloor.getLastStubDate();
    }

    /**
     * Gets the last stub idx tenor 1.
     *
     * @return the last stub idx tenor 1
     */
    public Tenor getLastStubIdxTenor1() {
        return capfloor.getLastStubIdxTenor1();
    }

    /**
     * Gets the last stub idx tenor 2.
     *
     * @return the last stub idx tenor 2
     */
    public Tenor getLastStubIdxTenor2() {
        return capfloor.getLastStubIdxTenor2();
    }

    /**
     * Gets the leg id.
     *
     * @return the leg id
     */
    public int getLegId() {
        return capfloor.getLegId();
    }

    /**
     * Gets the leg type.
     *
     * @return the leg type
     */
    public String getLegType() {
        return capfloor.getLegType();
    }

    /**
     * Gets the leveraged factor.
     *
     * @return the leveraged factor
     */
    public double getLeveragedFactor() {
        return capfloor.getLeveragedFactor();
    }

    /**
     * Gets the leveraged factor schedule.
     *
     * @return the leveraged factor schedule
     */
    public List getLeveragedFactorSchedule() {
        return capfloor.getLeveragedFactorSchedule();
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public double getLimit() {
        return capfloor.getLimit();
    }

    /**
     * Gets the mandatory termination B.
     *
     * @return the mandatory termination B
     */
    public boolean getMandatoryTerminationB() {
        return capfloor.getMandatoryTerminationB();
    }

    /**
     * Gets the manual first ref date B.
     *
     * @return the manual first ref date B
     */
    public boolean getManualFirstRefDateB() {
        return capfloor.getManualFirstRefDateB();
    }

    /**
     * Gets the manual init fixing.
     *
     * @return the manual init fixing
     */
    public ManualInitialFixing getManualInitFixing() {
        return capfloor.getManualInitFixing();
    }

    /**
     * Gets the maturity date.
     *
     * @return the maturity date
     */
    public JDate getMaturityDate() {
        return capfloor.getMaturityDate();
    }

    /**
     * Gets the notional.
     *
     * @return the notional
     */
    public double getNotional() {
        return capfloor.getNotional();
    }

    /**
     * Gets the number of activated flows.
     *
     * @return the number of activated flows
     */
    public int getNumberOfActivatedFlows() {
        return capfloor.getNumberOfActivatedFlows();
    }

    /**
     * Gets the number of activations.
     *
     * @return the number of activations
     */
    public int getNumberOfActivations() {
        return capfloor.getNumberOfActivations();
    }

    /**
     * Gets the number of activations left.
     *
     * @return the number of activations left
     */
    public int getNumberOfActivationsLeft() {
        return capfloor.getNumberOfActivationsLeft();
    }

    /**
     * Gets the option type.
     *
     * @return the option type
     */
    public String getOptionType() {
        return capfloor.getOptionType();
    }

    /**
     * Gets the option type domain.
     *
     * @return the option type domain
     */
    public List getOptionTypeDomain() {
        return CapFloor.getOptionTypeDomain();
    }

    /**
     * Gets the option type domain for ratchet.
     *
     * @return the option type domain for ratchet
     */
    public List getOptionTypeDomainForRatchet() {
        return CapFloor.getOptionTypeDomainForRatchet();
    }

    /**
     * Gets the pay out formula.
     *
     * @return the pay out formula
     */
    public PayOutFormula getPayOutFormula() {
        return capfloor.getPayOutFormula();
    }

    /**
     * Gets the pay out formula parameters map.
     *
     * @return the pay out formula parameters map
     */
    public Map getPayOutFormulaParametersMap() {
        return capfloor.getPayOutFormulaParametersMap();
    }

    /**
     * Gets the period rule.
     *
     * @return the period rule
     */
    public PeriodRule getPeriodRule() {
        return capfloor.getPeriodRule();
    }

    /**
     * Gets the pmt date rule.
     *
     * @return the pmt date rule
     */
    public DateRule getPmtDateRule() {
        return capfloor.getPmtDateRule();
    }

    /**
     * Gets the principal.
     *
     * @return the principal
     */
    public double getPrincipal() {
        return capfloor.getPrincipal();
    }

    /**
     * Gets the principal actual B.
     *
     * @return the principal actual B
     */
    public boolean getPrincipalActualB() {
        return capfloor.getPrincipalActualB();
    }

    /**
     * Gets the principal currency.
     *
     * @return the principal currency
     */
    public String getPrincipalCurrency() {
        return capfloor.getPrincipalCurrency();
    }

    /**
     * Gets the principal structure.
     *
     * @return the principal structure
     */
    public String getPrincipalStructure() {
        return capfloor.getPrincipalStructure();
    }

    /**
     * Gets the prior reset flag.
     *
     * @return the prior reset flag
     */
    public boolean getPriorResetFlag() {
        return capfloor.getPriorResetFlag();
    }

    /**
     * Gets the product class.
     *
     * @return the product class
     */
    public String getProductClass() {
        return capfloor.getProductClass();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATTrade#getProductFamily()
     */
    @Override
    public String getProductFamily() {
        return capfloor.getProductFamily();
    }

    /**
     * Gets the product id.
     *
     * @return the product id
     */
    public int getProductId() {
        return capfloor.getProductId();
    }

    /**
     * Gets the rate index.
     *
     * @return the rate index
     */
    public RateIndex getRateIndex() {
        return capfloor.getRateIndex();
    }

    /**
     * Gets the reset cut off.
     *
     * @return the reset cut off
     */
    public int getResetCutOff() {
        return capfloor.getResetCutOff();
    }

    /**
     * Gets the reset cut off bus day B.
     *
     * @return the reset cut off bus day B
     */
    public boolean getResetCutOffBusDayB() {
        return capfloor.getResetCutOffBusDayB();
    }

    /**
     * Gets the reset date roll.
     *
     * @return the reset date roll
     */
    public DateRoll getResetDateRoll() {
        return capfloor.getResetDateRoll();
    }

    /**
     * Gets the reset date rule.
     *
     * @return the reset date rule
     */
    public DateRule getResetDateRule() {
        return capfloor.getResetDateRule();
    }

    /**
     * Gets the reset holidays.
     *
     * @return the reset holidays
     */
    public List getResetHolidays() {
        return capfloor.getResetHolidays();
    }

    /**
     * Gets the reset offset.
     *
     * @return the reset offset
     */
    public int getResetOffset() {
        return capfloor.getResetOffset();
    }

    /**
     * Gets the reset offset bus day B.
     *
     * @return the reset offset bus day B
     */
    public boolean getResetOffsetBusDayB() {
        return capfloor.getResetOffsetBusDayB();
    }

    /**
     * Gets the reset timing.
     *
     * @return the reset timing
     */
    public String getResetTiming() {
        return capfloor.getResetTiming();
    }

    /**
     * Gets the rolling day.
     *
     * @return the rolling day
     */
    public int getRollingDay() {
        return capfloor.getRollingDay();
    }

    /**
     * Gets the sample day of week.
     *
     * @return the sample day of week
     */
    public int getSampleDayOfWeek() {
        return capfloor.getSampleDayOfWeek();
    }

    /**
     * Gets the sample frequency.
     *
     * @return the sample frequency
     */
    public Frequency getSampleFrequency() {
        return capfloor.getSampleFrequency();
    }

    /**
     * Gets the sample frequency domain.
     *
     * @return the sample frequency domain
     */
    public List getSampleFrequencyDomain() {
        return CapFloor.getSampleFrequencyDomain();
    }

    /**
     * Gets the sample period rule.
     *
     * @return the sample period rule
     */
    public String getSamplePeriodRule() {
        return capfloor.getSamplePeriodRule();
    }

    /**
     * Gets the sample period start offset.
     *
     * @return the sample period start offset
     */
    public int getSamplePeriodStartOffset() {
        return capfloor.getSamplePeriodStartOffset();
    }

    /**
     * Gets the specific resets.
     *
     * @return the specific resets
     */
    public List getSpecificResets() {
        return capfloor.getSpecificResets();
    }

    /**
     * Gets the spread.
     *
     * @return the spread
     */
    public double getSpread() {
        return capfloor.getSpread();
    }

    /**
     * Gets the spread schedule.
     *
     * @return the spread schedule
     */
    public List getSpreadSchedule() {
        return capfloor.getSpreadSchedule();
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public JDate getStartDate() {
        return capfloor.getStartDate();
    }

    /**
     * Gets the strike.
     *
     * @return the strike
     */
    public double getStrike() {
        return capfloor.getStrike();
    }

    /**
     * Gets the sub type.
     *
     * @return the sub type
     */
    public String getSubType() {
        return capfloor.getSubType();
    }

    /**
     * Gets the subtypes.
     *
     * @return the subtypes
     */
    public List getSubtypes() {
        return capfloor.getSubtypes();
    }

    /**
     * Gets the target.
     *
     * @return the target
     */
    public double getTarget() {
        return capfloor.getTarget();
    }

    /**
     * Gets the target schedule.
     *
     * @return the target schedule
     */
    public List getTargetSchedule() {
        return capfloor.getTargetSchedule();
    }

    /**
     * Gets the termination dates.
     *
     * @return the termination dates
     */
    public List getTerminationDates() {
        return capfloor.getTerminationDates();
    }

    /**
     * Gets the types.
     *
     * @return the types
     */
    public List getTypes() {
        return CapFloor.getTypes();
    }

    /**
     * Gets the used holidays.
     *
     * @return the used holidays
     */
    public String[] getUsedHolidays() {
        return capfloor.getUsedHolidays();
    }

}
