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
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.ResetInfo;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.FwdStartAdjustingtLeg;
import com.calypso.tk.product.Swap;
import com.calypso.tk.product.SwapLeg;
import com.calypso.tk.product.util.quotableReset.QuotableResetContainer;
import com.calypso.tk.refdata.CurrencyPair;
import com.calypso.tk.refdata.RateIndex;

public class ATSwap extends ATTrade {

    private final Swap swap;

    public ATSwap(final Trade trade) {
        super(trade);
        swap = (Swap) trade.getProduct();
    }

    public boolean getAdjustFirstFlowB() {
        return swap.getAdjustFirstFlowB();
    }

    public String getAllocator() {
        return swap.getAllocator();
    }

    public Set getBarrierCurrencyDomain() {
        return swap.getBarrierCurrencyDomain();
    }

    public Vector getCashSettleInfo() {
        return swap.getCashSettleInfo();
    }

    public byte[] getCompressedFlows() {
        return swap.getCompressedFlows();
    }

    public Collection getCurrencies() {
        return swap.getCurrencies();
    }

    public HashMap getCurrenciesAndIndexes() {
        return swap.getCurrenciesAndIndexes();
    }

    public String getCurrency() {
        return swap.getCurrency();
    }

    public CurrencyPair getCurrencyPair() {
        return swap.getCurrencyPair();
    }

    public boolean getCustomFlowsB() {
        return swap.getCustomFlowsB();
    }

    public boolean getDefaultCustomRollingDayB() {
        return swap.getDefaultCustomRollingDayB();
    }

    public DateRoll getDefaultDateRoll() {
        return swap.getDefaultDateRoll();
    }

    public Frequency getDefaultFrequency() {
        return swap.getDefaultFrequency();
    }

    public Vector getDefaultHolidays() {
        return swap.getDefaultHolidays();
    }

    public RateIndex getDefaultRateIndex() {
        return swap.getDefaultRateIndex();
    }

    public int getDefaultRollDay() {
        return swap.getDefaultRollDay();
    }

    public JDate getDeliveryDate() {
        return swap.getDeliveryDate();
    }

    public String getDescription() {
        return swap.getDescription();
    }

    public int getEarliestExerciseTime() {
        return swap.getEarliestExerciseTime();
    }

    public JDate getExercisedDate() {
        return swap.getExercisedDate();
    }

    public Vector getExoticFinancialLegs() {
        return swap.getExoticFinancialLegs();
    }

    public JDatetime getExpiryDatetime() {
        return swap.getExpiryDatetime();
    }

    public int getExpiryTime() {
        return swap.getExpiryTime();
    }

    public TimeZone getExpiryTimeZone() {
        return swap.getExpiryTimeZone();
    }

    public String getExtendedType() {
        return swap.getExtendedType();
    }

    public JDate getExtendibleSwapMaturityDate() {
        return swap.getExtendibleSwapMaturityDate();
    }

    public double getFinalFXRate() {
        return swap.getFinalFXRate();
    }

    public JDate getFinalPaymentMaturityDate() {
        return swap.getFinalPaymentMaturityDate();
    }

    public SwapLeg getFixedLeg() {
        return swap.getFixedLeg();
    }

    public SwapLeg getFloatLeg() {
        return swap.getFloatLeg();
    }

    public CashFlowSet getFlows() {
        return swap.getFlows();
    }

    public FwdStartAdjustingtLeg getFwdStartAdjustingLeg() {
        return swap.getFwdStartAdjustingLeg();
    }

    public int getFwdStartAdjustingLegId() {
        return swap.getFwdStartAdjustingLegId();
    }

    public double getInitialFXRate() {
        return swap.getInitialFXRate();
    }

    public boolean getIsExotic() {
        return swap.getIsExotic();
    }

    public int getLatestExerciseTime() {
        return swap.getLatestExerciseTime();
    }

    public SwapLeg getLeftSideLeg() {
        return swap.getLeftSideLeg();
    }

    public Vector getLegs() {
        return swap.getLegs();
    }

    public boolean getMandatoryTerminationB() {
        return swap.getMandatoryTerminationB();
    }

    public JDate getMaturityDate() {
        return swap.getMaturityDate();
    }

    public Vector getMergedCouponHolidays() {
        return swap.getMergedCouponHolidays();
    }

    public CurrencyPair getNotionalCurrencyPair() {
        return swap.getNotionalCurrencyPair();
    }

    public boolean getOptionCalcBusB() {
        return swap.getOptionCalcBusB();
    }

    public Vector getOptionCalcHolidays() {
        return swap.getOptionCalcHolidays();
    }

    public int getOptionCalcOffset() {
        return swap.getOptionCalcOffset();
    }

    public boolean getOptionCalcOffsetDaysB() {
        return swap.getOptionCalcOffsetDaysB();
    }

    public DateRoll getOptionDateRoll() {
        return swap.getOptionDateRoll();
    }

    public Vector getOptionExpiryHolidays() {
        return swap.getOptionExpiryHolidays();
    }

    public Frequency getOptionFrequency() {
        return swap.getOptionFrequency();
    }

    public JDate getOptionFromDate() {
        return swap.getOptionFromDate();
    }

    public int getOptionRollDay() {
        return swap.getOptionRollDay();
    }

    public boolean getOptionScheduleLock() {
        return swap.getOptionScheduleLock();
    }

    public JDate getOptionToDate() {
        return swap.getOptionToDate();
    }

    public String getOptionType() {
        return swap.getOptionType();
    }

    public SwapLeg getPayLeg() {
        return swap.getPayLeg();
    }

    public CashFlowSet getPayLegFlows() {
        return swap.getPayLegFlows();
    }

    public double getPremium() {
        return swap.getPremium();
    }

    public double getPrincipal() {
        return swap.getPrincipal();
    }

    public CashFlowSet getPrincipalAdjustmentFlows() {
        return swap.getPrincipalAdjustmentFlows();
    }

    public int getPrincipalAdjustmentLegId() {
        return swap.getPrincipalAdjustmentLegId();
    }

    public String getProductClass() {
        return swap.getProductClass();
    }

    @Override
    public String getProductFamily() {
        return swap.getProductFamily();
    }

    public int getProductId() {
        return swap.getProductId();
    }

    public int getPutCall() {
        return swap.getPutCall();
    }

    public QuotableResetContainer getQuotableResets() {
        return swap.getQuotableResets();
    }

    public String getQuoteName() {
        return swap.getQuoteName();
    }

    public RateIndex getRateIndex() {
        return swap.getRateIndex();
    }

    public RateIndex getRateIndex2() {
        return swap.getRateIndex2();
    }

    public SwapLeg getReceiveLeg() {
        return swap.getReceiveLeg();
    }

    public CashFlowSet getReceiveLegFlows() {
        return swap.getReceiveLegFlows();
    }

    public ResetInfo getResetInfo() {
        return swap.getResetInfo();
    }

    public Set getResetTypesNeeded() {
        return swap.getResetTypesNeeded();
    }

    public SwapLeg getRightSideLeg() {
        return swap.getRightSideLeg();
    }

    public Vector getSchedule() {
        return swap.getSchedule();
    }

    public Vector getSpecificResets() {
        return swap.getSpecificResets();
    }

    public JDate getStartDate() {
        return swap.getStartDate();
    }

    public double getStrike() {
        return swap.getStrike();
    }

    public String getSubType() {
        return swap.getSubType();
    }

    public Vector getSubtypes() {
        return swap.getSubtypes();
    }

    public Vector getTerminationDates() {
        return swap.getTerminationDates();
    }

    public String getType() {
        return swap.getType();
    }

    public List getTypes() {
        return Swap.getTypes();
    }

    public String[] getUsedHolidays() {
        return swap.getUsedHolidays();
    }
}
