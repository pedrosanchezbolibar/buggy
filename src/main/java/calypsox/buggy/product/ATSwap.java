package calypsox.buggy.product;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.Vector;

import com.calypso.tk.core.CashFlowSet;
import com.calypso.tk.core.DateRoll;
import com.calypso.tk.core.Frequency;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.ResetInfo;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.FwdStartAdjustingtLeg;
import com.calypso.tk.product.Swap;
import com.calypso.tk.product.SwapLeg;
import com.calypso.tk.product.util.quotableReset.QuotableResetContainer;
import com.calypso.tk.refdata.CurrencyPair;
import com.calypso.tk.refdata.RateIndex;

import calypsox.buggy.refdata.ATJDate;

public class ATSwap extends ATTrade {

    private final Swap swap;

    public ATSwap(final Trade trade) {
        super(trade);
        swap = (Swap) trade.getProduct();
    }

    public String getType() {
        return swap.getType();
    }

    public SwapLeg getPayLeg() {
        return swap.getPayLeg();
    }

    public SwapLeg getReceiveLeg() {
        return swap.getReceiveLeg();
    }

    public String getOptionType() {
        return swap.getOptionType();
    }

    public ATJDate getExtendibleSwapMaturityDate() {
        return new ATJDate(swap.getExtendibleSwapMaturityDate());
    }

    public Vector getSchedule() {
        return swap.getSchedule();
    }

    public ATJDate getStartDate() {
        return new ATJDate(swap.getStartDate());
    }

    public SwapLeg getLeftSideLeg() {
        return swap.getLeftSideLeg();
    }

    public SwapLeg getRightSideLeg() {
        return swap.getRightSideLeg();
    }

    public Vector getSubtypes() {
        return swap.getSubtypes();
    }

    public List getTypes() {
        return Swap.getTypes();
    }

    @Override
    public String getProductFamily() {
        return swap.getProductFamily();
    }

    public String getProductClass() {
        return swap.getProductClass();
    }

    public CashFlowSet getFlows() {
        return swap.getFlows();
    }

    public CashFlowSet getPayLegFlows() {
        return swap.getPayLegFlows();
    }

    public CashFlowSet getReceiveLegFlows() {
        return swap.getReceiveLegFlows();
    }

    public boolean getCustomFlowsB() {
        return swap.getCustomFlowsB();
    }

    public String getCurrency() {
        return swap.getCurrency();
    }

    public Collection getCurrencies() {
        return swap.getCurrencies();
    }

    public double getPrincipal() {
        return swap.getPrincipal();
    }

    public ATJDate getMaturityDate() {
        return new ATJDate(swap.getMaturityDate());
    }

    public ATJDate getFinalPaymentMaturityDate() {
        return new ATJDate(swap.getFinalPaymentMaturityDate());
    }

    public RateIndex getRateIndex() {
        return swap.getRateIndex();
    }

    public RateIndex getRateIndex2() {
        return swap.getRateIndex2();
    }

    public Vector getTerminationDates() {
        return swap.getTerminationDates();
    }

    public double getInitialFXRate() {
        return swap.getInitialFXRate();
    }

    public double getFinalFXRate() {
        return swap.getFinalFXRate();
    }

    public int getOptionCalcOffset() {
        return swap.getOptionCalcOffset();
    }

    public boolean getOptionCalcOffsetDaysB() {
        return swap.getOptionCalcOffsetDaysB();
    }

    public boolean getOptionCalcBusB() {
        return swap.getOptionCalcBusB();
    }

    public Vector getOptionCalcHolidays() {
        return swap.getOptionCalcHolidays();
    }

    public Vector getOptionExpiryHolidays() {
        return swap.getOptionExpiryHolidays();
    }

    public boolean getOptionScheduleLock() {
        return swap.getOptionScheduleLock();
    }

    public ATJDate getOptionFromDate() {
        return new ATJDate(swap.getOptionFromDate());
    }

    public ATJDate getOptionToDate() {
        return new ATJDate(swap.getOptionToDate());
    }

    public Frequency getOptionFrequency() {
        return swap.getOptionFrequency();
    }

    public DateRoll getOptionDateRoll() {
        return swap.getOptionDateRoll();
    }

    public int getOptionRollDay() {
        return swap.getOptionRollDay();
    }

    public boolean getMandatoryTerminationB() {
        return swap.getMandatoryTerminationB();
    }

    public SwapLeg getFixedLeg() {
        return swap.getFixedLeg();
    }

    public SwapLeg getFloatLeg() {
        return swap.getFloatLeg();
    }

    public String getDescription() {
        return swap.getDescription();
    }

    public ATJDate getExercisedDate() {
        return new ATJDate(swap.getExercisedDate());
    }

    public String[] getUsedHolidays() {
        return swap.getUsedHolidays();
    }

    public int getExpiryTime() {
        return swap.getExpiryTime();
    }

    public int getEarliestExerciseTime() {
        return swap.getEarliestExerciseTime();
    }

    public int getLatestExerciseTime() {
        return swap.getLatestExerciseTime();
    }

    public TimeZone getExpiryTimeZone() {
        return swap.getExpiryTimeZone();
    }

    public JDatetime getExpiryDatetime() {
        return swap.getExpiryDatetime();
    }

    public ATJDate getDeliveryDate() {
        return new ATJDate(swap.getDeliveryDate());
    }

    public double getPremium() {
        return swap.getPremium();
    }

    public String getSubType() {
        return swap.getSubType();
    }

    public Vector getMergedCouponHolidays() {
        return swap.getMergedCouponHolidays();
    }

    public Vector getCashSettleInfo() {
        return swap.getCashSettleInfo();
    }

    public RateIndex getDefaultRateIndex() {
        return swap.getDefaultRateIndex();
    }

    public Frequency getDefaultFrequency() {
        return swap.getDefaultFrequency();
    }

    public Vector getDefaultHolidays() {
        return swap.getDefaultHolidays();
    }

    public Vector getSpecificResets() {
        return swap.getSpecificResets();
    }

    public int getProductId() {
        return swap.getProductId();
    }

    public int getPutCall() {
        return swap.getPutCall();
    }

    public boolean getDefaultCustomRollingDayB() {
        return swap.getDefaultCustomRollingDayB();
    }

    public int getDefaultRollDay() {
        return swap.getDefaultRollDay();
    }

    public DateRoll getDefaultDateRoll() {
        return swap.getDefaultDateRoll();
    }

    public boolean getIsExotic() {
        return swap.getIsExotic();
    }

    public Vector getExoticFinancialLegs() {
        return swap.getExoticFinancialLegs();
    }

    public Vector getLegs() {
        return swap.getLegs();
    }

    public String getExtendedType() {
        return swap.getExtendedType();
    }

    public String getAllocator() {
        return swap.getAllocator();
    }

    public byte[] getCompressedFlows() {
        return swap.getCompressedFlows();
    }

    public HashMap getCurrenciesAndIndexes() {
        return swap.getCurrenciesAndIndexes();
    }

    public int getPrincipalAdjustmentLegId() {
        return swap.getPrincipalAdjustmentLegId();
    }

    public Set getResetTypesNeeded() {
        return swap.getResetTypesNeeded();
    }

    public QuotableResetContainer getQuotableResets() {
        return swap.getQuotableResets();
    }

    public CurrencyPair getCurrencyPair() {
        return swap.getCurrencyPair();
    }

    public CurrencyPair getNotionalCurrencyPair() {
        return swap.getNotionalCurrencyPair();
    }

    public CashFlowSet getPrincipalAdjustmentFlows() {
        return swap.getPrincipalAdjustmentFlows();
    }

    public boolean getAdjustFirstFlowB() {
        return swap.getAdjustFirstFlowB();
    }

    public double getStrike() {
        return swap.getStrike();
    }

    public String getQuoteName() {
        return swap.getQuoteName();
    }

    public FwdStartAdjustingtLeg getFwdStartAdjustingLeg() {
        return swap.getFwdStartAdjustingLeg();
    }

    public int getFwdStartAdjustingLegId() {
        return swap.getFwdStartAdjustingLegId();
    }

    public Set getBarrierCurrencyDomain() {
        return swap.getBarrierCurrencyDomain();
    }

    public ResetInfo getResetInfo() {
        return swap.getResetInfo();
    }
}
