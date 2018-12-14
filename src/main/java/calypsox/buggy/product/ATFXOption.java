package calypsox.buggy.product;

import java.util.List;
import java.util.TimeZone;
import java.util.Vector;

import com.calypso.tk.core.DateRoll;
import com.calypso.tk.core.DisplayValue;
import com.calypso.tk.core.Frequency;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.Product;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.AsianParameter;
import com.calypso.tk.product.FXOption;
import com.calypso.tk.product.FXResetFixing;
import com.calypso.tk.product.options.ForexHandler;
import com.calypso.tk.product.options.OptionFlavor;
import com.calypso.tk.product.util.BasicStrikeInputStyle;
import com.calypso.tk.product.util.FXResetSampleDate;
import com.calypso.tk.refdata.CurrencyPair;
import com.calypso.tk.refdata.FXReset;
import com.calypso.tk.refdata.RateIndex;

public class ATFXOption extends ATTrade {

    private final FXOption fxoption;

    public ATFXOption(final Trade trade) {
        super(trade);
        fxoption = (FXOption) trade.getProduct();
    }

    public String getABType() {
        return fxoption.getABType();
    }

    public boolean getAdjusted() {
        return fxoption.getAdjusted();
    }

    public Vector getAsianHolidays() {
        return fxoption.getAsianHolidays();
    }

    public AsianParameter getAsianParameter() {
        return fxoption.getAsianParameter();
    }

    public AsianParameter getAsianParameter1() {
        return fxoption.getAsianParameter1();
    }

    public List getAsianParameters() {
        return fxoption.getAsianParameters();
    }

    public FXResetSampleDate[] getAsianSchedule() {
        return fxoption.getAsianSchedule();
    }

    public String getAsianType() {
        return fxoption.getAsianType();
    }

    public boolean getAutoExercise() {
        return fxoption.getAutoExercise();
    }

    public List getBarrierDescriptors() {
        return fxoption.getBarrierDescriptors();
    }

    public String getBarrierDurationType() {
        return fxoption.getBarrierDurationType();
    }

    public Vector getBarrierDurationTypeDomain() {
        return FXOption.getBarrierDurationTypeDomain();
    }

    public ForexHandler getCashConversion() {
        return fxoption.getCashConversion();
    }

    public Vector getCashSettleInfo() {
        return fxoption.getCashSettleInfo();
    }

    public String getCurrency() {
        return fxoption.getCurrency();
    }

    public CurrencyPair getCurrencyPair() {
        return fxoption.getCurrencyPair();
    }

    public boolean getCustom() {
        return fxoption.getCustom();
    }

    public String getCustomerFeeCcyPair() {
        return fxoption.getCustomerFeeCcyPair();
    }

    public int getDayToRollOn() {
        return fxoption.getDayToRollOn();
    }

    public DateRoll getDefaultDateRoll() {
        return fxoption.getDefaultDateRoll();
    }

    public Frequency getDefaultFrequency() {
        return fxoption.getDefaultFrequency();
    }

    public Vector getDefaultHolidays() {
        return fxoption.getDefaultHolidays();
    }

    public RateIndex getDefaultRateIndex() {
        return fxoption.getDefaultRateIndex();
    }

    public Vector getDeliveryHolidays() {
        return fxoption.getDeliveryHolidays();
    }

    public String getDescription() {
        return fxoption.getDescription();
    }

    public String getDigitalPaymentType() {
        return fxoption.getDigitalPaymentType();
    }

    public int getDispOptionType() {
        return fxoption.getDispOptionType();
    }

    public String getDispOptionTypeAsString() {
        return fxoption.getDispOptionTypeAsString();
    }

    public JDate getDownBarrierEndDate() {
        return fxoption.getDownBarrierEndDate();
    }

    public JDatetime getDownBarrierEndDatetime() {
        return fxoption.getDownBarrierEndDatetime();
    }

    public int getDownBarrierEndTime() {
        return fxoption.getDownBarrierEndTime();
    }

    public TimeZone getDownBarrierEndTimeZone() {
        return fxoption.getDownBarrierEndTimeZone();
    }

    public JDate getDownBarrierStartDate() {
        return fxoption.getDownBarrierStartDate();
    }

    public JDatetime getDownBarrierStartDatetime() {
        return fxoption.getDownBarrierStartDatetime();
    }

    public int getDownBarrierStartTime() {
        return fxoption.getDownBarrierStartTime();
    }

    public TimeZone getDownBarrierStartTimeZone() {
        return fxoption.getDownBarrierStartTimeZone();
    }

    public String getDownBarrierType() {
        return fxoption.getDownBarrierType();
    }

    public double getDownBarrierValue() {
        return fxoption.getDownBarrierValue();
    }

    public double getDownRangeValue() {
        return fxoption.getDownRangeValue();
    }

    public JDate getEndDate() {
        return fxoption.getEndDate();
    }

    public JDate getExercisedDate() {
        return fxoption.getExercisedDate();
    }

    public String getExerciseType() {
        return fxoption.getExerciseType();
    }

    public JDate getExpiryDate() {
        return fxoption.getExpiryDate();
    }

    public JDate getExpiryDateInTime() {
        return fxoption.getExpiryDateInTime();
    }

    public JDatetime getExpiryDatetime() {
        return fxoption.getExpiryDatetime();
    }

    public Vector getExpiryHolidays() {
        return fxoption.getExpiryHolidays();
    }

    public int getExpiryTime() {
        return fxoption.getExpiryTime();
    }

    public TimeZone getExpiryTimeZone() {
        return fxoption.getExpiryTimeZone();
    }

    public double getFaderHighTriggerValue() {
        return fxoption.getFaderHighTriggerValue();
    }

    public double getFaderLowTriggerValue() {
        return fxoption.getFaderLowTriggerValue();
    }

    public String getFaderRangeType() {
        return fxoption.getFaderRangeType();
    }

    public String getFaderType() {
        return fxoption.getFaderType();
    }

    public JDate getFirstExerciseDate() {
        return fxoption.getFirstExerciseDate();
    }

    public Frequency getFrequency() {
        return fxoption.getFrequency();
    }

    public JDate getFwdStartFixingDate() {
        return fxoption.getFwdStartFixingDate();
    }

    public FXReset getFwdStartFXReset() {
        return fxoption.getFwdStartFXReset();
    }

    public FXResetFixing getFwdStartFxResetFixing() {
        return fxoption.getFwdStartFxResetFixing();
    }

    public double getFwdStartStrike() {
        return fxoption.getFwdStartStrike();
    }

    public BasicStrikeInputStyle getFwdStartStrikeStyle() {
        return fxoption.getFwdStartStrikeStyle();
    }

    public double getFwdVol() {
        return fxoption.getFwdVol();
    }

    public FXReset getFxReset() {
        return fxoption.getFxReset();
    }

    public FXReset getFXReset() {
        return fxoption.getFXReset();
    }

    public FXResetFixing getFXResetFixing() {
        return fxoption.getFXResetFixing();
    }

    public Vector getHolidays() {
        return fxoption.getHolidays();
    }

    public String getLookbackType() {
        return fxoption.getLookbackType();
    }

    public JDate getMaturityDate() {
        return fxoption.getMaturityDate();
    }

    public FXReset getNonAsianFXReset() {
        return fxoption.getNonAsianFXReset();
    }

    public FXResetFixing getNonAsianFxResetFixing() {
        return fxoption.getNonAsianFxResetFixing();
    }

    public boolean getOptionCalcBusB() {
        return fxoption.getOptionCalcBusB();
    }

    public int getOptionCalcOffset() {
        return fxoption.getOptionCalcOffset();
    }

    public boolean getOptionCalcOffsetDaysB() {
        return fxoption.getOptionCalcOffsetDaysB();
    }

    public OptionFlavor getOptionFlavor() {
        return fxoption.getOptionFlavor();
    }

    public int getOptionSide() {
        return fxoption.getOptionSide();
    }

    public String getOptionSideAsString() {
        return fxoption.getOptionSideAsString();
    }

    public String getOptionStyle() {
        return fxoption.getOptionStyle();
    }

    public String getOptionSubType() {
        return fxoption.getOptionSubType();
    }

    public int getOptionType() {
        return fxoption.getOptionType();
    }

    public String getOptionTypeAsString() {
        return fxoption.getOptionTypeAsString();
    }

    public FXReset getOptionTypeFXReset() {
        return fxoption.getOptionTypeFXReset();
    }

    public FXResetFixing getOptionTypeFXResetFixing() {
        return fxoption.getOptionTypeFXResetFixing();
    }

    public double getPayOut() {
        return fxoption.getPayOut();
    }

    public String getPremiumBaseCcyPair() {
        return fxoption.getPremiumBaseCcyPair();
    }

    public double getPremiumRateToBase() {
        return fxoption.getPremiumRateToBase();
    }

    public double getPremiumRateToOption() {
        return fxoption.getPremiumRateToOption();
    }

    public DisplayValue getPriceDisplayValue() {
        return fxoption.getPriceDisplayValue();
    }

    public double getPrimaryAmount() {
        return fxoption.getPrimaryAmount();
    }

    public String getPrimaryCurrency() {
        return fxoption.getPrimaryCurrency();
    }

    public double getPrincipal() {
        return fxoption.getPrincipal();
    }

    public String getProductClass() {
        return fxoption.getProductClass();
    }

    @Override
    public String getProductFamily() {
        return fxoption.getProductFamily();
    }

    public int getPutCall() {
        return fxoption.getPutCall();
    }

    public CurrencyPair getQuantoCrossCurrenyPair() {
        return fxoption.getQuantoCrossCurrenyPair();
    }

    public CurrencyPair getQuantoCurrencyPair() {
        return fxoption.getQuantoCurrencyPair();
    }

    public double getQuantoFactor() {
        return fxoption.getQuantoFactor();
    }

    public String getQuoteName() {
        return fxoption.getQuoteName();
    }

    public double getQuotingAmount() {
        return fxoption.getQuotingAmount();
    }

    public String getQuotingCurrency() {
        return fxoption.getQuotingCurrency();
    }

    public int getQuotingOptionType() {
        return fxoption.getQuotingOptionType();
    }

    public String getQuotingOptionTypeAsString() {
        return fxoption.getQuotingOptionTypeAsString();
    }

    public String getRangeType() {
        return fxoption.getRangeType();
    }

    public double getRebate() {
        return fxoption.getRebate();
    }

    public String getRebateCondition() {
        return fxoption.getRebateCondition();
    }

    public String getRebateCurrency() {
        return fxoption.getRebateCurrency();
    }

    public String getRebatePayRec() {
        return fxoption.getRebatePayRec();
    }

    public String getRebateTiming() {
        return fxoption.getRebateTiming();
    }

    public JDate getResetDate() {
        return fxoption.getResetDate();
    }

    public double getResetPrice() {
        return fxoption.getResetPrice();
    }

    public boolean getRollOnDay() {
        return fxoption.getRollOnDay();
    }

    public boolean getRollOnEndDate() {
        return fxoption.getRollOnEndDate();
    }

    public Vector getSchedule() {
        return fxoption.getSchedule();
    }

    @Override
    public JDate getSettleDate() {
        return fxoption.getSettleDate();
    }

    public String getSettlementCurrency() {
        return fxoption.getSettlementCurrency();
    }

    public String getSettlementType() {
        return fxoption.getSettlementType();
    }

    public Vector getSettlementTypeDomain() {
        return fxoption.getSettlementTypeDomain();
    }

    public JDate getSpotDate() {
        return fxoption.getSpotDate();
    }

    public JDate getSpotDateFromExpiry() {
        return fxoption.getSpotDateFromExpiry();
    }

    public JDate getStartDate() {
        return fxoption.getStartDate();
    }

    public double getStrike() {
        return fxoption.getStrike();
    }

    public String getSubType() {
        return fxoption.getSubType();
    }

    public String getTermType() {
        return fxoption.getTermType();
    }

    public String getTimingType() {
        return fxoption.getTimingType();
    }

    public Product getUnderlyingProduct() {
        return fxoption.getUnderlyingProduct();
    }

    public JDate getUndrlExpDate() {
        return fxoption.getUndrlExpDate();
    }

    public JDatetime getUndrlExpDatetime() {
        return fxoption.getUndrlExpDatetime();
    }

    public int getUndrlExpTime() {
        return fxoption.getUndrlExpTime();
    }

    public TimeZone getUndrlExpTimeZone() {
        return fxoption.getUndrlExpTimeZone();
    }

    public JDate getUpBarrierEndDate() {
        return fxoption.getUpBarrierEndDate();
    }

    public JDatetime getUpBarrierEndDatetime() {
        return fxoption.getUpBarrierEndDatetime();
    }

    public int getUpBarrierEndTime() {
        return fxoption.getUpBarrierEndTime();
    }

    public TimeZone getUpBarrierEndTimeZone() {
        return fxoption.getUpBarrierEndTimeZone();
    }

    public JDate getUpBarrierStartDate() {
        return fxoption.getUpBarrierStartDate();
    }

    public JDatetime getUpBarrierStartDatetime() {
        return fxoption.getUpBarrierStartDatetime();
    }

    public int getUpBarrierStartTime() {
        return fxoption.getUpBarrierStartTime();
    }

    public TimeZone getUpBarrierStartTimeZone() {
        return fxoption.getUpBarrierStartTimeZone();
    }

    public String getUpBarrierType() {
        return fxoption.getUpBarrierType();
    }

    public double getUpBarrierValue() {
        return fxoption.getUpBarrierValue();
    }

    public double getUpRangeValue() {
        return fxoption.getUpRangeValue();
    }

    public String[] getUsedHolidays() {
        return fxoption.getUsedHolidays();
    }

    public Vector getValidTouchTypes() {
        return fxoption.getValidTouchTypes();
    }

    public double getVega() {
        return fxoption.getVega();
    }

    public boolean getWeighted() {
        return fxoption.getWeighted();
    }
}
