package calypsox.buggy.product;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.calypso.tk.core.CalypsoException;
import com.calypso.tk.core.CashFlowSet;
import com.calypso.tk.core.DateRoll;
import com.calypso.tk.core.DateRule;
import com.calypso.tk.core.DayCount;
import com.calypso.tk.core.DisplayValue;
import com.calypso.tk.core.FlowGenerationException;
import com.calypso.tk.core.Frequency;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.PeriodRule;
import com.calypso.tk.core.Product;
import com.calypso.tk.core.StubRule;
import com.calypso.tk.core.Tenor;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.Bond;
import com.calypso.tk.product.Bond.NotionalGuaranteedEnum;
import com.calypso.tk.product.BondInfo;
import com.calypso.tk.product.FutureContract;
import com.calypso.tk.product.LotteryWinnerRedemption;
import com.calypso.tk.product.PutCallDate;
import com.calypso.tk.product.eXSPSwapLeg;
import com.calypso.tk.product.eXSP.component.CalypsoComponent;
import com.calypso.tk.product.eXSP.compute.eXSPComputeEnvironment;
import com.calypso.tk.product.eXSP.schedule.PeriodSchedule;
import com.calypso.tk.product.eXSP.typing.ConfigurableType;
import com.calypso.tk.product.eXSP.util.XSPUtil;
import com.calypso.tk.product.flow.IndexCalculator;
import com.calypso.tk.product.util.InterpStyle;
import com.calypso.tk.refdata.CurrencyPair;
import com.calypso.tk.refdata.FXReset;
import com.calypso.tk.refdata.RateIndex;
import com.calypso.tk.refdata.eXSP.variable.array.ArrayVariable;

import calypsox.buggy.refdata.ATLegalEntity;
import calypsox.buggy.ui.ATAmount;

/**
 * The Class ATBond.
 */
public class ATBond extends ATTrade {

    /** The bond. */
    private final Bond bond;

    /**
     * Instantiates a new AT bond.
     *
     * @param trade
     *            the trade
     */
    public ATBond(final Trade trade) {
        super(trade);
        bond = (Bond) trade.getProduct();
    }

    /**
     * Gets the accrual daycount.
     *
     * @return the accrual daycount
     */
    public DayCount getAccrualDaycount() {
        return bond.getAccrualDaycount();
    }

    /**
     * Gets the accrual rounding.
     *
     * @return the accrual rounding
     */
    public int getAccrualRounding() {
        return bond.getAccrualRounding();
    }

    /**
     * Gets the accrual rounding method.
     *
     * @return the accrual rounding method
     */
    public String getAccrualRoundingMethod() {
        return bond.getAccrualRoundingMethod();
    }

    /**
     * Gets the accrual rounding method code.
     *
     * @return the accrual rounding method code
     */
    public int getAccrualRoundingMethodCode() {
        return bond.getAccrualRoundingMethodCode();
    }

    /**
     * Gets the active date.
     *
     * @return the active date
     */
    public JDate getActiveDate() {
        return bond.getActiveDate();
    }

    /**
     * Gets the actual amort exchange B.
     *
     * @return the actual amort exchange B
     */
    public boolean getActualAmortExchangeB() {
        return bond.getActualAmortExchangeB();
    }

    /**
     * Gets the actual final exchange B.
     *
     * @return the actual final exchange B
     */
    public boolean getActualFinalExchangeB() {
        return bond.getActualFinalExchangeB();
    }

    /**
     * Gets the actual initial exchange B.
     *
     * @return the actual initial exchange B
     */
    public boolean getActualInitialExchangeB() {
        return bond.getActualInitialExchangeB();
    }

    /**
     * Gets the allocator.
     *
     * @return the allocator
     */
    public String getAllocator() {
        return bond.getAllocator();
    }

    /**
     * Gets the allowed redemption type.
     *
     * @return the allowed redemption type
     */
    public String getAllowedRedemptionType() {
        return bond.getAllowedRedemptionType();
    }

    /**
     * Gets the amort amount.
     *
     * @return the amort amount
     */
    public double getAmortAmount() {
        return bond.getAmortAmount();
    }

    /**
     * Gets the amort day count.
     *
     * @return the amort day count
     */
    public DayCount getAmortDayCount() {
        return bond.getAmortDayCount();
    }

    /**
     * Gets the amort frequency.
     *
     * @return the amort frequency
     */
    public Frequency getAmortFrequency() {
        return bond.getAmortFrequency();
    }

    /**
     * Gets the amortizing B.
     *
     * @return the amortizing B
     */
    public boolean getAmortizingB() {
        return bond.getAmortizingB();
    }

    /**
     * Gets the amortizing face value B.
     *
     * @return the amortizing face value B
     */
    public boolean getAmortizingFaceValueB() {
        return bond.getAmortizingFaceValueB();
    }

    /**
     * Gets the amort rate.
     *
     * @return the amort rate
     */
    public double getAmortRate() {
        return bond.getAmortRate();
    }

    /**
     * Gets the amort schedule.
     *
     * @return the amort schedule
     */
    public List getAmortSchedule() {
        return bond.getAmortSchedule();
    }

    /**
     * Gets the amort structure.
     *
     * @return the amort structure
     */
    public String getAmortStructure() {
        return bond.getAmortStructure();
    }

    /**
     * Gets the announce date.
     *
     * @return the announce date
     */
    public JDate getAnnounceDate() {
        return bond.getAnnounceDate();
    }

    /**
     * Gets the apply reset dates beginning at first coupon B.
     *
     * @return the apply reset dates beginning at first coupon B
     */
    public boolean getApplyResetDatesBeginningAtFirstCouponB() {
        return bond.getApplyResetDatesBeginningAtFirstCouponB();
    }

    /**
     * Gets the apply withholding tax B.
     *
     * @return the apply withholding tax B
     */
    public boolean getApplyWithholdingTaxB() {
        return bond.getApplyWithholdingTaxB();
    }

    /**
     * Gets the array variables.
     *
     * @return the array variables
     */
    public Map getArrayVariables() {
        return bond.getArrayVariables();
    }

    /**
     * Gets the assimilation date.
     *
     * @return the assimilation date
     */
    public JDate getAssimilationDate() {
        return bond.getAssimilationDate();
    }

    /**
     * Gets the assimilation product id.
     *
     * @return the assimilation product id
     */
    public int getAssimilationProductId() {
        return bond.getAssimilationProductId();
    }

    /**
     * Gets the associated quote names.
     *
     * @return the associated quote names
     */
    public List getAssociatedQuoteNames() {
        return bond.getAssociatedQuoteNames();
    }

    /**
     * Gets the auction date.
     *
     * @return the auction date
     */
    public JDate getAuctionDate() {
        return bond.getAuctionDate();
    }

    /**
     * Gets the basket id.
     *
     * @return the basket id
     */
    public int getBasketId() {
        return bond.getBasketId();
    }

    /**
     * Gets the basket time series variables.
     *
     * @return the basket time series variables
     */
    public Map getBasketTimeSeriesVariables() {
        return bond.getBasketTimeSeriesVariables();
    }

    /**
     * Gets the benchmark.
     *
     * @return the benchmark
     */
    public Product getBenchmark() {
        return bond.getBenchmark();
    }

    /**
     * Gets the benchmark name.
     *
     * @return the benchmark name
     */
    public String getBenchmarkName() {
        return bond.getBenchmarkName();
    }

    /**
     * Gets the benchmark prod id.
     *
     * @return the benchmark prod id
     */
    public int getBenchmarkProdId() {
        return bond.getBenchmarkProdId();
    }

    /**
     * Gets the bond benchmark name.
     *
     * @return the bond benchmark name
     */
    public String getBondBenchmarkName() {
        return bond.getBondBenchmarkName();
    }

    /**
     * Gets the bond info.
     *
     * @return the bond info
     */
    public BondInfo getBondInfo() {
        return bond.getBondInfo();
    }

    /**
     * Gets the bond status.
     *
     * @return the bond status
     */
    public String getBondStatus() {
        return bond.getBondStatus();
    }

    /**
     * Gets the bond type.
     *
     * @return the bond type
     */
    public String getBondType() {
        return bond.getBondType();
    }

    /**
     * Gets the calculator agent id.
     *
     * @return the calculator agent id
     */
    public int getCalculatorAgentId() {
        return bond.getCalculatorAgentId();
    }

    /**
     * Gets the call date.
     *
     * @return the call date
     */
    public JDate getCallDate() {
        return bond.getCallDate();
    }

    /**
     * Gets the calypso components.
     *
     * @return the calypso components
     * @throws CalypsoException
     *             the calypso exception
     */
    public CalypsoComponent[] getCalypsoComponents() throws CalypsoException {
        return bond.getCalypsoComponents();
    }

    /**
     * Gets the capitalization factor rounding.
     *
     * @return the capitalization factor rounding
     */
    public int getCapitalizationFactorRounding() {
        return bond.getCapitalizationFactorRounding();
    }

    /**
     * Gets the capitalization factor rounding method.
     *
     * @return the capitalization factor rounding method
     */
    public String getCapitalizationFactorRoundingMethod() {
        return bond.getCapitalizationFactorRoundingMethod();
    }

    /**
     * Gets the capitalization factor rounding method code.
     *
     * @return the capitalization factor rounding method code
     */
    public int getCapitalizationFactorRoundingMethodCode() {
        return bond.getCapitalizationFactorRoundingMethodCode();
    }

    /**
     * Gets the cap strike.
     *
     * @return the cap strike
     */
    public double getCapStrike() {
        return bond.getCapStrike();
    }

    /**
     * Gets the cf custom changes.
     *
     * @return the cf custom changes
     */
    public long getCfCustomChanges() {
        return bond.getCfCustomChanges();
    }

    /**
     * Gets the cf generation locks.
     *
     * @return the cf generation locks
     */
    public long getCfGenerationLocks() {
        return bond.getCfGenerationLocks();
    }

    /**
     * Gets the compound B.
     *
     * @return the compound B
     */
    public boolean getCompoundB() {
        return bond.getCompoundB();
    }

    /**
     * Gets the compound frequency.
     *
     * @return the compound frequency
     */
    public Frequency getCompoundFrequency() {
        return bond.getCompoundFrequency();
    }

    /**
     * Gets the compound frequency style.
     *
     * @return the compound frequency style
     */
    public String getCompoundFrequencyStyle() {
        return bond.getCompoundFrequencyStyle();
    }

    /**
     * Gets the compound method.
     *
     * @return the compound method
     */
    public String getCompoundMethod() {
        return bond.getCompoundMethod();
    }

    /**
     * Gets the configurable type.
     *
     * @return the configurable type
     */
    public ConfigurableType getConfigurableType() {
        return bond.getConfigurableType();
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return bond.getCountry();
    }

    /**
     * Gets the coupon.
     *
     * @return the coupon
     */
    public double getCoupon() {
        return bond.getCoupon();
    }

    /**
     * Gets the coupon currency.
     *
     * @return the coupon currency
     */
    public String getCouponCurrency() {
        return bond.getCouponCurrency();
    }

    /**
     * Gets the coupon date roll.
     *
     * @return the coupon date roll
     */
    public DateRoll getCouponDateRoll() {
        return bond.getCouponDateRoll();
    }

    /**
     * Gets the coupon date rule.
     *
     * @return the coupon date rule
     */
    public DateRule getCouponDateRule() {
        return bond.getCouponDateRule();
    }

    /**
     * Gets the coupon day count.
     *
     * @return the coupon day count
     */
    public DayCount getCouponDayCount() {
        return bond.getCouponDayCount();
    }

    /**
     * Gets the coupon frequency.
     *
     * @return the coupon frequency
     */
    public Frequency getCouponFrequency() {
        return bond.getCouponFrequency();
    }

    /**
     * Gets the coupon holidays.
     *
     * @return the coupon holidays
     */
    public List getCouponHolidays() {
        return bond.getCouponHolidays();
    }

    /**
     * Gets the coupon offset.
     *
     * @return the coupon offset
     */
    public int getCouponOffset() {
        return bond.getCouponOffset();
    }

    /**
     * Gets the coupon offset bus day B.
     *
     * @return the coupon offset bus day B
     */
    public boolean getCouponOffsetBusDayB() {
        return bond.getCouponOffsetBusDayB();
    }

    /**
     * Gets the coupon payment at end B.
     *
     * @return the coupon payment at end B
     */
    public boolean getCouponPaymentAtEndB() {
        return bond.getCouponPaymentAtEndB();
    }

    /**
     * Gets the coupon period rule.
     *
     * @return the coupon period rule
     */
    public PeriodRule getCouponPeriodRule() {
        return bond.getCouponPeriodRule();
    }

    /**
     * Gets the coupon rate rounding method.
     *
     * @return the coupon rate rounding method
     */
    public String getCouponRateRoundingMethod() {
        return bond.getCouponRateRoundingMethod();
    }

    /**
     * Gets the coupon rolling day.
     *
     * @return the coupon rolling day
     */
    public int getCouponRollingDay() {
        return bond.getCouponRollingDay();
    }

    /**
     * Gets the coupon schedule.
     *
     * @return the coupon schedule
     */
    public List getCouponSchedule() {
        return bond.getCouponSchedule();
    }

    /**
     * Gets the coupon stub rule.
     *
     * @return the coupon stub rule
     */
    public StubRule getCouponStubRule() {
        return bond.getCouponStubRule();
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return bond.getCurrency();
    }

    /**
     * Gets the currency pair.
     *
     * @return the currency pair
     */
    public CurrencyPair getCurrencyPair() {
        return bond.getCurrencyPair();
    }

    /**
     * Gets the custom flows.
     *
     * @return the custom flows
     */
    public CashFlowSet getCustomFlows() {
        return bond.getCustomFlows();
    }

    /**
     * Gets the custom flows B.
     *
     * @return the custom flows B
     */
    public boolean getCustomFlowsB() {
        return bond.getCustomFlowsB();
    }

    /**
     * Gets the dated date.
     *
     * @return the dated date
     */
    public JDate getDatedDate() {
        return bond.getDatedDate();
    }

    /**
     * Gets the date roll.
     *
     * @return the date roll
     */
    public DateRoll getDateRoll() {
        return bond.getDateRoll();
    }

    /**
     * Gets the daycount.
     *
     * @return the daycount
     */
    public DayCount getDaycount() {
        return bond.getDaycount();
    }

    /**
     * Gets the default date.
     *
     * @return the default date
     */
    public JDate getDefaultDate() {
        return bond.getDefaultDate();
    }

    /**
     * Gets the default lottery winner redemption.
     *
     * @return the default lottery winner redemption
     */
    public LotteryWinnerRedemption getDefaultLotteryWinnerRedemption() {
        return bond.getDefaultLotteryWinnerRedemption();
    }

    /**
     * Gets the default period schedule.
     *
     * @return the default period schedule
     * @throws FlowGenerationException
     *             the flow generation exception
     */
    public PeriodSchedule getDefaultPeriodSchedule() throws FlowGenerationException {
        return bond.getDefaultPeriodSchedule();
    }

    /**
     * Gets the default put call date.
     *
     * @return the default put call date
     */
    public PutCallDate getDefaultPutCallDate() {
        return bond.getDefaultPutCallDate();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return bond.getDescription();
    }

    /**
     * Gets the dirty price base.
     *
     * @return the dirty price base
     */
    public int getDirtyPriceBase() {
        return bond.getDirtyPriceBase();
    }

    /**
     * Gets the dirty price display value.
     *
     * @return the dirty price display value
     */
    public DisplayValue getDirtyPriceDisplayValue() {
        return bond.getDirtyPriceDisplayValue();
    }

    /**
     * Gets the disc margin rounding method.
     *
     * @return the disc margin rounding method
     */
    public String getDiscMarginRoundingMethod() {
        return bond.getDiscMarginRoundingMethod();
    }

    /**
     * Gets the disc margin rounding method code.
     *
     * @return the disc margin rounding method code
     */
    public int getDiscMarginRoundingMethodCode() {
        return bond.getDiscMarginRoundingMethodCode();
    }

    /**
     * Gets the discount margin dec.
     *
     * @return the discount margin dec
     */
    public int getDiscountMarginDec() {
        return bond.getDiscountMarginDec();
    }

    /**
     * Gets the discount method.
     *
     * @return the discount method
     */
    public int getDiscountMethod() {
        return bond.getDiscountMethod();
    }

    /**
     * Gets the discount method as string.
     *
     * @return the discount method as string
     */
    public String getDiscountMethodAsString() {
        return bond.getDiscountMethodAsString();
    }

    /**
     * Gets the discount spread quote name.
     *
     * @return the discount spread quote name
     */
    public String getDiscountSpreadQuoteName() {
        return bond.getDiscountSpreadQuoteName();
    }

    /**
     * Gets the effective call.
     *
     * @return the effective call
     */
    public String getEffectiveCall() {
        return bond.getEffectiveCall();
    }

    /**
     * Gets the effective call date.
     *
     * @return the effective call date
     */
    public JDate getEffectiveCallDate() {
        return bond.getEffectiveCallDate();
    }

    /**
     * Gets the effective call types.
     *
     * @return the effective call types
     */
    public List getEffectiveCallTypes() {
        return bond.getEffectiveCallTypes();
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public JDate getEndDate() {
        return bond.getEndDate();
    }

    /**
     * Gets the end stub end tenor.
     *
     * @return the end stub end tenor
     */
    public Tenor getEndStubEndTenor() {
        return bond.getEndStubEndTenor();
    }

    /**
     * Gets the end stub start tenor.
     *
     * @return the end stub start tenor
     */
    public Tenor getEndStubStartTenor() {
        return bond.getEndStubStartTenor();
    }

    /**
     * Gets the exchange codes.
     *
     * @return the exchange codes
     */
    public List getExchangeCodes() {
        return bond.getExchangeCodes();
    }

    /**
     * Gets the exdividend day bus B.
     *
     * @return the exdividend day bus B
     */
    public boolean getExdividendDayBusB() {
        return bond.getExdividendDayBusB();
    }

    /**
     * Gets the exdividend days.
     *
     * @return the exdividend days
     */
    public int getExdividendDays() {
        return bond.getExdividendDays();
    }

    /**
     * Gets the ex div schedule.
     *
     * @return the ex div schedule
     */
    public List getExDivSchedule() {
        return bond.getExDivSchedule();
    }

    /**
     * Gets the exercise date.
     *
     * @return the exercise date
     */
    public JDate getExerciseDate() {
        return bond.getExerciseDate();
    }

    /**
     * Gets the exotic basket variables.
     *
     * @return the exotic basket variables
     */
    public Map getExoticBasketVariables() {
        return bond.getExoticBasketVariables();
    }

    /**
     * Gets the exotic capitals.
     *
     * @return the exotic capitals
     */
    public ArrayVariable getExoticCapitals() {
        return bond.getExoticCapitals();
    }

    /**
     * Gets the exotic coupons.
     *
     * @return the exotic coupons
     */
    public ArrayVariable getExoticCoupons() {
        return bond.getExoticCoupons();
    }

    /**
     * Gets the exotic financial leg.
     *
     * @return the exotic financial leg
     */
    public eXSPSwapLeg getExoticFinancialLeg() {
        return bond.getExoticFinancialLeg();
    }

    /**
     * Gets the exotic financial legs.
     *
     * @return the exotic financial legs
     */
    public List getExoticFinancialLegs() {
        return bond.getExoticFinancialLegs();
    }

    /**
     * Gets the exotic redemptions.
     *
     * @return the exotic redemptions
     */
    public ArrayVariable getExoticRedemptions() {
        return bond.getExoticRedemptions();
    }

    /**
     * Gets the extended type.
     *
     * @return the extended type
     */
    public String getExtendedType() {
        return bond.getExtendedType();
    }

    /**
     * Gets the external cash flow set.
     *
     * @return the external cash flow set
     */
    public CashFlowSet getExternalCashFlowSet() {
        return bond.getExternalCashFlowSet();
    }

    /**
     * Gets the external cash flow source.
     *
     * @return the external cash flow source
     */
    public String getExternalCashFlowSource() {
        return bond.getExternalCashFlowSource();
    }

    /**
     * Gets the ext flows last download datetime.
     *
     * @return the ext flows last download datetime
     */
    public JDatetime getExtFlowsLastDownloadDatetime() {
        return bond.getExtFlowsLastDownloadDatetime();
    }

    /**
     * Gets the face value.
     *
     * @return the face value
     */
    public double getFaceValue() {
        return bond.getFaceValue();
    }

    /**
     * Gets the first coupon date.
     *
     * @return the first coupon date
     */
    public JDate getFirstCouponDate() {
        return bond.getFirstCouponDate();
    }

    /**
     * Gets the fixed B.
     *
     * @return the fixed B
     */
    public boolean getFixedB() {
        return bond.getFixedB();
    }

    /**
     * Gets the flipper date.
     *
     * @return the flipper date
     */
    public JDate getFlipperDate() {
        return bond.getFlipperDate();
    }

    /**
     * Gets the flipper description.
     *
     * @return the flipper description
     */
    public String getFlipperDescription() {
        return bond.getFlipperDescription();
    }

    /**
     * Gets the flipper frequency.
     *
     * @return the flipper frequency
     */
    public Frequency getFlipperFrequency() {
        return bond.getFlipperFrequency();
    }

    /**
     * Gets the floater B.
     *
     * @return the floater B
     */
    public boolean getFloaterB() {
        return bond.getFloaterB();
    }

    /**
     * Gets the floor strike.
     *
     * @return the floor strike
     */
    public double getFloorStrike() {
        return bond.getFloorStrike();
    }

    /**
     * Gets the flows.
     *
     * @return the flows
     */
    public CashFlowSet getFlows() {
        return bond.getFlows();
    }

    /**
     * Gets the folio variables.
     *
     * @return the folio variables
     */
    public Map getFolioVariables() {
        return bond.getFolioVariables();
    }

    /**
     * Gets the future contract.
     *
     * @return the future contract
     */
    public FutureContract getFutureContract() {
        return bond.getFutureContract();
    }

    /**
     * Gets the FX date roll.
     *
     * @return the FX date roll
     */
    public DateRoll getFXDateRoll() {
        return bond.getFXDateRoll();
    }

    /**
     * Gets the fx rate.
     *
     * @return the fx rate
     */
    public double getFxRate() {
        return bond.getFxRate();
    }

    /**
     * Gets the fx reset.
     *
     * @return the fx reset
     */
    public FXReset getFxReset() {
        return bond.getFxReset();
    }

    /**
     * Gets the holidays.
     *
     * @return the holidays
     */
    public List getHolidays() {
        return bond.getHolidays();
    }

    /**
     * Gets the inactive date.
     *
     * @return the inactive date
     */
    public JDate getInactiveDate() {
        return bond.getInactiveDate();
    }

    /**
     * Gets the index calculator.
     *
     * @return the index calculator
     */
    public IndexCalculator getIndexCalculator() {
        return bond.getIndexCalculator();
    }

    /**
     * Gets the index factor.
     *
     * @return the index factor
     */
    public double getIndexFactor() {
        return bond.getIndexFactor();
    }

    /**
     * Gets the inflation protected B.
     *
     * @return the inflation protected B
     */
    public boolean getInflationProtectedB() {
        return bond.getInflationProtectedB();
    }

    /**
     * Gets the inflation rounding.
     *
     * @return the inflation rounding
     */
    public int getInflationRounding() {
        return bond.getInflationRounding();
    }

    /**
     * Gets the inflation rounding method.
     *
     * @return the inflation rounding method
     */
    public String getInflationRoundingMethod() {
        return bond.getInflationRoundingMethod();
    }

    /**
     * Gets the inflation rounding method code.
     *
     * @return the inflation rounding method code
     */
    public int getInflationRoundingMethodCode() {
        return bond.getInflationRoundingMethodCode();
    }

    /**
     * Gets the initial level.
     *
     * @return the initial level
     */
    public String getInitialLevel() {
        return bond.getInitialLevel();
    }

    /**
     * Gets the interest flows.
     *
     * @return the interest flows
     */
    public List getInterestFlows() {
        return bond.getInterestFlows();
    }

    /**
     * Gets the interp style.
     *
     * @return the interp style
     */
    public InterpStyle getInterpStyle() {
        return bond.getInterpStyle();
    }

    /**
     * Gets the checks if is end of month.
     *
     * @return the checks if is end of month
     */
    public boolean getIsEndOfMonth() {
        return bond.getIsEndOfMonth();
    }

    /**
     * Gets the checks if is exotic.
     *
     * @return the checks if is exotic
     */
    public boolean getIsExotic() {
        return bond.getIsExotic();
    }

    /**
     * Gets the checks if is exotic capital ignored.
     *
     * @return the checks if is exotic capital ignored
     */
    public boolean getIsExoticCapitalIgnored() {
        return bond.getIsExoticCapitalIgnored();
    }

    /**
     * Gets the checks if is name valid.
     *
     * @return the checks if is name valid
     */
    public boolean getIsNameValid() {
        return bond.getIsNameValid();
    }

    /**
     * Gets the checks if is pay.
     *
     * @return the checks if is pay
     */
    public boolean getIsPay() {
        return bond.getIsPay();
    }

    /**
     * Gets the issue date.
     *
     * @return the issue date
     */
    public JDate getIssueDate() {
        return bond.getIssueDate();
    }

    /**
     * Gets the issue paying agent id.
     *
     * @return the issue paying agent id
     */
    public int getIssuePayingAgentId() {
        return bond.getIssuePayingAgentId();
    }

    /**
     * Gets the issue price.
     *
     * @return the issue price
     */
    public double getIssuePrice() {
        return bond.getIssuePrice();
    }

    /**
     * Gets the issuer id.
     *
     * @return the issuer id
     */
    public ATLegalEntity getIssuerId() {
        return new ATLegalEntity(bond.getIssuerId());
    }

    /**
     * Gets the issue yield.
     *
     * @return the issue yield
     */
    public double getIssueYield() {
        return bond.getIssueYield();
    }

    /**
     * Gets the checks if is uncustomized redemption formula.
     *
     * @return the checks if is uncustomized redemption formula
     */
    public boolean getIsUncustomizedRedemptionFormula() {
        return bond.getIsUncustomizedRedemptionFormula();
    }

    /**
     * Gets the last trading date.
     *
     * @return the last trading date
     */
    public JDate getLastTradingDate() {
        return bond.getLastTradingDate();
    }

    /**
     * Gets the leg id.
     *
     * @return the leg id
     */
    public int getLegId() {
        return bond.getLegId();
    }

    /**
     * Gets the leg ID.
     *
     * @return the leg ID
     */
    public int getLegID() {
        return bond.getLegID();
    }

    /**
     * Gets the leg type.
     *
     * @return the leg type
     */
    public String getLegType() {
        return bond.getLegType();
    }

    /**
     * Gets the lockout days.
     *
     * @return the lockout days
     */
    public int getLockoutDays() {
        return bond.getLockoutDays();
    }

    /**
     * Gets the lockout rolling convention.
     *
     * @return the lockout rolling convention
     */
    public DateRoll getLockoutRollingConvention() {
        return bond.getLockoutRollingConvention();
    }

    /**
     * Gets the lottery winner schedule.
     *
     * @return the lottery winner schedule
     */
    public TreeSet getLotteryWinnerSchedule() {
        return bond.getLotteryWinnerSchedule();
    }

    /**
     * Gets the maturity date.
     *
     * @return the maturity date
     */
    public JDate getMaturityDate() {
        return bond.getMaturityDate();
    }

    /**
     * Gets the maturity tenor.
     *
     * @return the maturity tenor
     */
    public Tenor getMaturityTenor() {
        return bond.getMaturityTenor();
    }

    /**
     * Gets the min purchase amt.
     *
     * @return the min purchase amt
     */
    public double getMinPurchaseAmt() {
        return bond.getMinPurchaseAmt();
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return bond.getName();
    }

    /**
     * Gets the nominal decimals.
     *
     * @return the nominal decimals
     */
    public int getNominalDecimals() {
        return bond.getNominalDecimals();
    }

    /**
     * Gets the notification date roll.
     *
     * @return the notification date roll
     */
    public DateRoll getNotificationDateRoll() {
        return bond.getNotificationDateRoll();
    }

    /**
     * Gets the notification holidays.
     *
     * @return the notification holidays
     */
    public List getNotificationHolidays() {
        return bond.getNotificationHolidays();
    }

    /**
     * Gets the notification offset.
     *
     * @return the notification offset
     */
    public int getNotificationOffset() {
        return bond.getNotificationOffset();
    }

    /**
     * Gets the notional.
     *
     * @return the notional
     */
    public double getNotional() {
        return bond.getNotional();
    }

    /**
     * Gets the notional calc method.
     *
     * @return the notional calc method
     */
    public String getNotionalCalcMethod() {
        return bond.getNotionalCalcMethod();
    }

    /**
     * Gets the notional factor index.
     *
     * @return the notional factor index
     */
    public RateIndex getNotionalFactorIndex() {
        return bond.getNotionalFactorIndex();
    }

    /**
     * Gets the notional guaranteed type.
     *
     * @return the notional guaranteed type
     */
    public NotionalGuaranteedEnum getNotionalGuaranteedType() {
        return bond.getNotionalGuaranteedType();
    }

    /**
     * Gets the notional index.
     *
     * @return the notional index
     */
    public RateIndex getNotionalIndex() {
        return bond.getNotionalIndex();
    }

    /**
     * Gets the notional index date.
     *
     * @return the notional index date
     */
    public JDate getNotionalIndexDate() {
        return bond.getNotionalIndexDate();
    }

    /**
     * Gets the notional index lag.
     *
     * @return the notional index lag
     */
    public int getNotionalIndexLag() {
        return bond.getNotionalIndexLag();
    }

    /**
     * Gets the notional index value.
     *
     * @return the notional index value
     */
    public double getNotionalIndexValue() {
        return bond.getNotionalIndexValue();
    }

    /**
     * Gets the notional interp method.
     *
     * @return the notional interp method
     */
    public String getNotionalInterpMethod() {
        return bond.getNotionalInterpMethod();
    }

    /**
     * Gets the notional type.
     *
     * @return the notional type
     */
    public String getNotionalType() {
        return bond.getNotionalType();
    }

    /**
     * Gets the odd first coupon B.
     *
     * @return the odd first coupon B
     */
    public boolean getOddFirstCouponB() {
        return bond.getOddFirstCouponB();
    }

    /**
     * Gets the odd last coupon B.
     *
     * @return the odd last coupon B
     */
    public boolean getOddLastCouponB() {
        return bond.getOddLastCouponB();
    }

    /**
     * Gets the option type.
     *
     * @return the option type
     */
    public String getOptionType() {
        return bond.getOptionType();
    }

    /**
     * Gets the original quote name.
     *
     * @return the original quote name
     */
    public String getOriginalQuoteName() {
        return bond.getOriginalQuoteName();
    }

    /**
     * Gets the penultimate coupon date.
     *
     * @return the penultimate coupon date
     */
    public JDate getPenultimateCouponDate() {
        return bond.getPenultimateCouponDate();
    }

    /**
     * Gets the period rule.
     *
     * @return the period rule
     */
    public PeriodRule getPeriodRule() {
        return bond.getPeriodRule();
    }

    /**
     * Gets the PIK date.
     *
     * @return the PIK date
     */
    public JDate getPIKDate() {
        return bond.getPIKDate();
    }

    /**
     * Gets the PIK day count.
     *
     * @return the PIK day count
     */
    public DayCount getPIKDayCount() {
        return bond.getPIKDayCount();
    }

    /**
     * Gets the PIK rate.
     *
     * @return the PIK rate
     */
    public double getPIKRate() {
        return bond.getPIKRate();
    }

    /**
     * Gets the PIK schedule.
     *
     * @return the PIK schedule
     */
    public List getPIKSchedule() {
        return bond.getPIKSchedule();
    }

    /**
     * Gets the pre paid B.
     *
     * @return the pre paid B
     */
    public boolean getPrePaidB() {
        return bond.getPrePaidB();
    }

    /**
     * Gets the pre payment speed quote name.
     *
     * @return the pre payment speed quote name
     */
    public String getPrePaymentSpeedQuoteName() {
        return bond.getPrePaymentSpeedQuoteName();
    }

    /**
     * Gets the price decimals.
     *
     * @return the price decimals
     */
    public int getPriceDecimals() {
        return bond.getPriceDecimals();
    }

    /**
     * Gets the price display value.
     *
     * @return the price display value
     */
    public DisplayValue getPriceDisplayValue() {
        return bond.getPriceDisplayValue();
    }

    /**
     * Gets the price rounding method.
     *
     * @return the price rounding method
     */
    public String getPriceRoundingMethod() {
        return bond.getPriceRoundingMethod();
    }

    /**
     * Gets the price rounding method code.
     *
     * @return the price rounding method code
     */
    public int getPriceRoundingMethodCode() {
        return bond.getPriceRoundingMethodCode();
    }

    /**
     * Gets the principal.
     *
     * @return the principal
     */
    public ATAmount getPrincipal() {
        return new ATAmount(bond.getCurrency(), bond.getPrincipal());
    }

    /**
     * Gets the principal currency.
     *
     * @return the principal currency
     */
    public String getPrincipalCurrency() {
        return bond.getPrincipalCurrency();
    }

    /**
     * Gets the principal flows.
     *
     * @return the principal flows
     */
    public List getPrincipalFlows() {
        return bond.getPrincipalFlows();
    }

    /**
     * Gets the principal guarantee amount.
     *
     * @return the principal guarantee amount
     */
    public double getPrincipalGuaranteeAmount() {
        return bond.getPrincipalGuaranteeAmount();
    }

    /**
     * Gets the principal percentage.
     *
     * @return the principal percentage
     */
    public double getPrincipalPercentage() {
        return bond.getPrincipalPercentage();
    }

    /**
     * Gets the principal structure.
     *
     * @return the principal structure
     */
    public String getPrincipalStructure() {
        return bond.getPrincipalStructure();
    }

    /**
     * Gets the product.
     *
     * @return the product
     */
    public Product getProduct() {
        return bond.getProduct();
    }

    /**
     * Gets the product class.
     *
     * @return the product class
     */
    public String getProductClass() {
        return bond.getProductClass();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATTrade#getProductFamily()
     */
    @Override
    public String getProductFamily() {
        return bond.getProductFamily();
    }

    /**
     * Gets the product variables.
     *
     * @return the product variables
     */
    public Map getProductVariables() {
        return bond.getProductVariables();
    }

    /**
     * Gets the p var overrides.
     *
     * @return the p var overrides
     */
    public List getPVarOverrides() {
        return bond.getPVarOverrides();
    }

    /**
     * Gets the quotable variables.
     *
     * @return the quotable variables
     */
    public Map getQuotableVariables() {
        return bond.getQuotableVariables();
    }

    /**
     * Gets the quote base.
     *
     * @return the quote base
     */
    public int getQuoteBase() {
        return bond.getQuoteBase();
    }

    /**
     * Gets the quote name.
     *
     * @return the quote name
     */
    public String getQuoteName() {
        return bond.getQuoteName();
    }

    /**
     * Gets the quote type.
     *
     * @return the quote type
     */
    public String getQuoteType() {
        return bond.getQuoteType();
    }

    /**
     * Gets the quoting currency.
     *
     * @return the quoting currency
     */
    public String getQuotingCurrency() {
        return bond.getQuotingCurrency();
    }

    /**
     * Gets the q var overrides.
     *
     * @return the q var overrides
     */
    public List getQVarOverrides() {
        return bond.getQVarOverrides();
    }

    /**
     * Gets the rate index.
     *
     * @return the rate index
     */
    public RateIndex getRateIndex() {
        return bond.getRateIndex();
    }

    /**
     * Gets the rate index spread.
     *
     * @return the rate index spread
     */
    public double getRateIndexSpread() {
        return bond.getRateIndexSpread();
    }

    /**
     * Gets the reconventioning date.
     *
     * @return the reconventioning date
     */
    public JDate getReconventioningDate() {
        return bond.getReconventioningDate();
    }

    /**
     * Gets the reconventioning day count.
     *
     * @return the reconventioning day count
     */
    public DayCount getReconventioningDayCount() {
        return bond.getReconventioningDayCount();
    }

    /**
     * Gets the record days.
     *
     * @return the record days
     */
    public int getRecordDays() {
        return bond.getRecordDays();
    }

    /**
     * Gets the redeem days.
     *
     * @return the redeem days
     */
    public int getRedeemDays() {
        return bond.getRedeemDays();
    }

    /**
     * Gets the redem currency.
     *
     * @return the redem currency
     */
    public String getRedemCurrency() {
        return bond.getRedemCurrency();
    }

    /**
     * Gets the redemption currency.
     *
     * @return the redemption currency
     */
    public String getRedemptionCurrency() {
        return bond.getRedemptionCurrency();
    }

    /**
     * Gets the redemption fx rate.
     *
     * @return the redemption fx rate
     */
    public double getRedemptionFxRate() {
        return bond.getRedemptionFxRate();
    }

    /**
     * Gets the redemption fx reset.
     *
     * @return the redemption fx reset
     */
    public FXReset getRedemptionFxReset() {
        return bond.getRedemptionFxReset();
    }

    /**
     * Gets the redemption price.
     *
     * @return the redemption price
     */
    public double getRedemptionPrice() {
        return bond.getRedemptionPrice();
    }

    /**
     * Gets the reference entities.
     *
     * @return the reference entities
     */
    public List getReferenceEntities() {
        return bond.getReferenceEntities();
    }

    /**
     * Gets the reopening dates.
     *
     * @return the reopening dates
     */
    public List getReopeningDates() {
        return bond.getReopeningDates();
    }

    /**
     * Gets the reset bus lag B.
     *
     * @return the reset bus lag B
     */
    public boolean getResetBusLagB() {
        return bond.getResetBusLagB();
    }

    /**
     * Gets the reset date roll.
     *
     * @return the reset date roll
     */
    public DateRoll getResetDateRoll() {
        return bond.getResetDateRoll();
    }

    /**
     * Gets the reset days.
     *
     * @return the reset days
     */
    public int getResetDays() {
        return bond.getResetDays();
    }

    /**
     * Gets the reset decimals.
     *
     * @return the reset decimals
     */
    public int getResetDecimals() {
        return bond.getResetDecimals();
    }

    /**
     * Gets the reset frequency.
     *
     * @return the reset frequency
     */
    public Frequency getResetFrequency() {
        return bond.getResetFrequency();
    }

    /**
     * Gets the reset holidays.
     *
     * @return the reset holidays
     */
    public List getResetHolidays() {
        return bond.getResetHolidays();
    }

    /**
     * Gets the reset in arrear B.
     *
     * @return the reset in arrear B
     */
    public boolean getResetInArrearB() {
        return bond.getResetInArrearB();
    }

    /**
     * Gets the reset price.
     *
     * @return the reset price
     */
    public double getResetPrice() {
        return bond.getResetPrice();
    }

    /**
     * Gets the reset rounding method.
     *
     * @return the reset rounding method
     */
    public String getResetRoundingMethod() {
        return bond.getResetRoundingMethod();
    }

    /**
     * Gets the reset sampling cut off lag.
     *
     * @return the reset sampling cut off lag
     */
    public int getResetSamplingCutOffLag() {
        return bond.getResetSamplingCutOffLag();
    }

    /**
     * Gets the reset sampling cut off lag B.
     *
     * @return the reset sampling cut off lag B
     */
    public boolean getResetSamplingCutOffLagB() {
        return bond.getResetSamplingCutOffLagB();
    }

    /**
     * Gets the reset sampling day of week.
     *
     * @return the reset sampling day of week
     */
    public int getResetSamplingDayOfWeek() {
        return bond.getResetSamplingDayOfWeek();
    }

    /**
     * Gets the reset sampling method.
     *
     * @return the reset sampling method
     */
    public String getResetSamplingMethod() {
        return bond.getResetSamplingMethod();
    }

    /**
     * Gets the reset timing.
     *
     * @return the reset timing
     */
    public String getResetTiming() {
        return bond.getResetTiming();
    }

    /**
     * Gets the rolling day.
     *
     * @return the rolling day
     */
    public int getRollingDay() {
        return bond.getRollingDay();
    }

    /**
     * Gets the rounding rules.
     *
     * @return the rounding rules
     */
    public Map getRoundingRules() {
        return bond.getRoundingRules();
    }

    /**
     * Gets the rounding unit.
     *
     * @return the rounding unit
     */
    public int getRoundingUnit() {
        return bond.getRoundingUnit();
    }

    /**
     * Gets the sample frequency domains.
     *
     * @return the sample frequency domains
     */
    public List getSampleFrequencyDomains() {
        return bond.getSampleFrequencyDomains();
    }

    /**
     * Gets the schedule.
     *
     * @return the schedule
     */
    public List getSchedule() {
        return bond.getSchedule();
    }

    /**
     * Gets the security.
     *
     * @return the security
     */
    public Product getSecurity() {
        return bond.getSecurity();
    }

    /**
     * Gets the settle days.
     *
     * @return the settle days
     */
    public int getSettleDays() {
        return bond.getSettleDays();
    }

    /**
     * Gets the settlement type domain.
     *
     * @return the settlement type domain
     */
    public List getSettlementTypeDomain() {
        return bond.getSettlementTypeDomain();
    }

    /**
     * Gets the spread calc mtd.
     *
     * @return the spread calc mtd
     */
    public String getSpreadCalcMtd() {
        return bond.getSpreadCalcMtd();
    }

    /**
     * Gets the spread schedule.
     *
     * @return the spread schedule
     */
    public List getSpreadSchedule() {
        return bond.getSpreadSchedule();
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public JDate getStartDate() {
        return bond.getStartDate();
    }

    /**
     * Gets the start stub end tenor.
     *
     * @return the start stub end tenor
     */
    public Tenor getStartStubEndTenor() {
        return bond.getStartStubEndTenor();
    }

    /**
     * Gets the start stub start tenor.
     *
     * @return the start stub start tenor
     */
    public Tenor getStartStubStartTenor() {
        return bond.getStartStubStartTenor();
    }

    /**
     * Gets the stub rule.
     *
     * @return the stub rule
     */
    public StubRule getStubRule() {
        return bond.getStubRule();
    }

    /**
     * Gets the sub type.
     *
     * @return the sub type
     */
    public String getSubType() {
        return bond.getSubType();
    }

    /**
     * Gets the supported credit event protocol types.
     *
     * @return the supported credit event protocol types
     */
    public List getSupportedCreditEventProtocolTypes() {
        return bond.getSupportedCreditEventProtocolTypes();
    }

    /**
     * Gets the template variables.
     *
     * @return the template variables
     */
    public Map getTemplateVariables() {
        return bond.getTemplateVariables();
    }

    /**
     * Gets the template variable settings.
     *
     * @return the template variable settings
     */
    public Map getTemplateVariableSettings() {
        return bond.getTemplateVariableSettings();
    }

    /**
     * Gets the tenor.
     *
     * @return the tenor
     */
    public Tenor getTenor() {
        return bond.getTenor();
    }

    /**
     * Gets the tick size.
     *
     * @return the tick size
     */
    public String getTickSize() {
        return bond.getTickSize();
    }

    /**
     * Gets the time series variables.
     *
     * @return the time series variables
     */
    public Map getTimeSeriesVariables() {
        return bond.getTimeSeriesVariables();
    }

    /**
     * Gets the total issued.
     *
     * @return the total issued
     */
    public double getTotalIssued() {
        return bond.getTotalIssued();
    }

    /**
     * Gets the trading flat as of.
     *
     * @return the trading flat as of
     */
    public JDate getTradingFlatAsOf() {
        return bond.getTradingFlatAsOf();
    }

    /**
     * Gets the transient quote name.
     *
     * @return the transient quote name
     */
    public String getTransientQuoteName() {
        return bond.getTransientQuoteName();
    }

    /**
     * Gets the trustee id.
     *
     * @return the trustee id
     */
    public int getTrusteeId() {
        return bond.getTrusteeId();
    }

    /**
     * Gets the underlying security id.
     *
     * @return the underlying security id
     */
    public int getUnderlyingSecurityId() {
        return bond.getUnderlyingSecurityId();
    }

    /**
     * Gets the used holidays.
     *
     * @return the used holidays
     */
    public String[] getUsedHolidays() {
        return bond.getUsedHolidays();
    }

    /**
     * Gets the valid option schedule.
     *
     * @return the valid option schedule
     */
    public List getValidOptionSchedule() {
        return bond.getValidOptionSchedule();
    }

    /**
     * Gets the valid quoting currency.
     *
     * @return the valid quoting currency
     */
    public String getValidQuotingCurrency() {
        return bond.getValidQuotingCurrency();
    }

    /**
     * Gets the value days.
     *
     * @return the value days
     */
    public int getValueDays() {
        return bond.getValueDays();
    }

    /**
     * Gets the variable overrides.
     *
     * @return the variable overrides
     */
    public Map getVariableOverrides() {
        return bond.getVariableOverrides();
    }

    /**
     * Gets the WAL quote name.
     *
     * @return the WAL quote name
     */
    public String getWALQuoteName() {
        return bond.getWALQuoteName();
    }

    /**
     * Gets the XSP compute environment.
     *
     * @return the XSP compute environment
     */
    public eXSPComputeEnvironment getXSPComputeEnvironment() {
        return bond.getXSPComputeEnvironment();
    }

    /**
     * Gets the XSP util.
     *
     * @return the XSP util
     */
    public XSPUtil getXSPUtil() {
        return bond.getXSPUtil();
    }

    /**
     * Gets the yield decimals.
     *
     * @return the yield decimals
     */
    public int getYieldDecimals() {
        return bond.getYieldDecimals();
    }

    /**
     * Gets the yield method.
     *
     * @return the yield method
     */
    public String getYieldMethod() {
        return bond.getYieldMethod();
    }

    /**
     * Gets the yield rounding method.
     *
     * @return the yield rounding method
     */
    public String getYieldRoundingMethod() {
        return bond.getYieldRoundingMethod();
    }

    /**
     * Gets the yield rounding method code.
     *
     * @return the yield rounding method code
     */
    public int getYieldRoundingMethodCode() {
        return bond.getYieldRoundingMethodCode();
    }
}
