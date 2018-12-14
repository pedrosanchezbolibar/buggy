package calypsox.buggy.product;

import java.util.List;
import java.util.TimeZone;
import java.util.Vector;

import com.calypso.tk.core.DateRoll;
import com.calypso.tk.core.DisplayValue;
import com.calypso.tk.core.Frequency;
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

import calypsox.buggy.refdata.ATJDate;

public class ATFXOption extends ATTrade {

    public ATFXOption(final Trade trade) {
        super(trade);
        fxoption = (FXOption) trade.getProduct();
    }

    private final FXOption fxoption;

    public int getOptionSide() {
        return fxoption.getOptionSide();
    }

    public String getOptionStyle() {
        return fxoption.getOptionStyle();
    }

    public Vector getHolidays() {
        return fxoption.getHolidays();
    }

    public Vector getExpiryHolidays() {
        return fxoption.getExpiryHolidays();
    }

    public Vector getDeliveryHolidays() {
        return fxoption.getDeliveryHolidays();
    }

    public CurrencyPair getCurrencyPair() {
        return fxoption.getCurrencyPair();
    }

    public int getOptionType() {
        return fxoption.getOptionType();
    }

    public int getQuotingOptionType() {
        return fxoption.getQuotingOptionType();
    }

    public String getQuotingOptionTypeAsString() {
        return fxoption.getQuotingOptionTypeAsString();
    }

    public double getPrimaryAmount() {
        return fxoption.getPrimaryAmount();
    }

    public double getQuotingAmount() {
        return fxoption.getQuotingAmount();
    }

    public String getPrimaryCurrency() {
        return fxoption.getPrimaryCurrency();
    }

    public String getQuotingCurrency() {
        return fxoption.getQuotingCurrency();
    }

    public String getDescription() {
        return fxoption.getDescription();
    }

    @Override
    public String getProductFamily() {
        return fxoption.getProductFamily();
    }

    public String getProductClass() {
        return fxoption.getProductClass();
    }

    public String getOptionSideAsString() {
        return fxoption.getOptionSideAsString();
    }

    public String getOptionTypeAsString() {
        return fxoption.getOptionTypeAsString();
    }

    public Vector getSchedule() {
        return fxoption.getSchedule();
    }

    public double getPrincipal() {
        return fxoption.getPrincipal();
    }

    public ATJDate getMaturityDate() {
        return new ATJDate(fxoption.getMaturityDate());
    }

    public String getCurrency() {
        return fxoption.getCurrency();
    }

    public double getQuantoFactor() {
        return fxoption.getQuantoFactor();
    }

    public CurrencyPair getQuantoCurrencyPair() {
        return fxoption.getQuantoCurrencyPair();
    }

    public CurrencyPair getQuantoCrossCurrenyPair() {
        return fxoption.getQuantoCrossCurrenyPair();
    }

    public JDatetime getExpiryDatetime() {
        return fxoption.getExpiryDatetime();
    }

    public ATJDate getExpiryDateInTime() {
        return new ATJDate(fxoption.getExpiryDateInTime());
    }

    public ATJDate getUndrlExpDate() {
        return new ATJDate(fxoption.getUndrlExpDate());
    }

    public int getUndrlExpTime() {
        return fxoption.getUndrlExpTime();
    }

    public TimeZone getUndrlExpTimeZone() {
        return fxoption.getUndrlExpTimeZone();
    }

    public JDatetime getUndrlExpDatetime() {
        return fxoption.getUndrlExpDatetime();
    }

    public double getFwdVol() {
        return fxoption.getFwdVol();
    }

    public double getVega() {
        return fxoption.getVega();
    }

    public Frequency getFrequency() {
        return fxoption.getFrequency();
    }

    public boolean getAdjusted() {
        return fxoption.getAdjusted();
    }

    public boolean getWeighted() {
        return fxoption.getWeighted();
    }

    public boolean getRollOnEndDate() {
        return fxoption.getRollOnEndDate();
    }

    public boolean getCustom() {
        return fxoption.getCustom();
    }

    public ATJDate getStartDate() {
        return new ATJDate(fxoption.getStartDate());
    }

    public ATJDate getSpotDateFromExpiry() {
        return new ATJDate(fxoption.getSpotDateFromExpiry());
    }

    public ATJDate getEndDate() {
        return new ATJDate(fxoption.getEndDate());
    }

    public FXReset getFXReset() {
        return fxoption.getFXReset();
    }

    public FXResetFixing getFXResetFixing() {
        return fxoption.getFXResetFixing();
    }

    public FXResetFixing getOptionTypeFXResetFixing() {
        return fxoption.getOptionTypeFXResetFixing();
    }

    public FXReset getOptionTypeFXReset() {
        return fxoption.getOptionTypeFXReset();
    }

    public FXReset getNonAsianFXReset() {
        return fxoption.getNonAsianFXReset();
    }

    public FXReset getFxReset() {
        return fxoption.getFxReset();
    }

    public Vector getAsianHolidays() {
        return fxoption.getAsianHolidays();
    }

    public boolean getRollOnDay() {
        return fxoption.getRollOnDay();
    }

    public int getDayToRollOn() {
        return fxoption.getDayToRollOn();
    }

    public String getAsianType() {
        return fxoption.getAsianType();
    }

    public String getLookbackType() {
        return fxoption.getLookbackType();
    }

    public FXResetSampleDate[] getAsianSchedule() {
        return fxoption.getAsianSchedule();
    }

    public double getUpBarrierValue() {
        return fxoption.getUpBarrierValue();
    }

    public double getDownBarrierValue() {
        return fxoption.getDownBarrierValue();
    }

    public double getDownRangeValue() {
        return fxoption.getDownRangeValue();
    }

    public double getUpRangeValue() {
        return fxoption.getUpRangeValue();
    }

    public String getRangeType() {
        return fxoption.getRangeType();
    }

    public String getUpBarrierType() {
        return fxoption.getUpBarrierType();
    }

    public String getDownBarrierType() {
        return fxoption.getDownBarrierType();
    }

    public double getPayOut() {
        return fxoption.getPayOut();
    }

    public double getRebate() {
        return fxoption.getRebate();
    }

    public String getRebateCondition() {
        return fxoption.getRebateCondition();
    }

    public String getRebatePayRec() {
        return fxoption.getRebatePayRec();
    }

    public String getRebateCurrency() {
        return fxoption.getRebateCurrency();
    }

    public String getRebateTiming() {
        return fxoption.getRebateTiming();
    }

    public String getTermType() {
        return fxoption.getTermType();
    }

    public String getTimingType() {
        return fxoption.getTimingType();
    }

    public String getBarrierDurationType() {
        return fxoption.getBarrierDurationType();
    }

    public Vector getBarrierDurationTypeDomain() {
        return FXOption.getBarrierDurationTypeDomain();
    }

    public ATJDate getUpBarrierStartDate() {
        return new ATJDate(fxoption.getUpBarrierStartDate());
    }

    public ATJDate getUpBarrierEndDate() {
        return new ATJDate(fxoption.getUpBarrierEndDate());
    }

    public int getUpBarrierStartTime() {
        return fxoption.getUpBarrierStartTime();
    }

    public int getUpBarrierEndTime() {
        return fxoption.getUpBarrierEndTime();
    }

    public TimeZone getUpBarrierStartTimeZone() {
        return fxoption.getUpBarrierStartTimeZone();
    }

    public TimeZone getUpBarrierEndTimeZone() {
        return fxoption.getUpBarrierEndTimeZone();
    }

    public ATJDate getDownBarrierStartDate() {
        return new ATJDate(fxoption.getDownBarrierStartDate());
    }

    public ATJDate getDownBarrierEndDate() {
        return new ATJDate(fxoption.getDownBarrierEndDate());
    }

    public int getDownBarrierStartTime() {
        return fxoption.getDownBarrierStartTime();
    }

    public int getDownBarrierEndTime() {
        return fxoption.getDownBarrierEndTime();
    }

    public TimeZone getDownBarrierStartTimeZone() {
        return fxoption.getDownBarrierStartTimeZone();
    }

    public TimeZone getDownBarrierEndTimeZone() {
        return fxoption.getDownBarrierEndTimeZone();
    }

    public ATJDate getExercisedDate() {
        return new ATJDate(fxoption.getExercisedDate());
    }

    public FXResetFixing getFwdStartFxResetFixing() {
        return fxoption.getFwdStartFxResetFixing();
    }

    public FXResetFixing getNonAsianFxResetFixing() {
        return fxoption.getNonAsianFxResetFixing();
    }

    public double getResetPrice() {
        return fxoption.getResetPrice();
    }

    public String[] getUsedHolidays() {
        return fxoption.getUsedHolidays();
    }

    public ATJDate getSpotDate() {
        return new ATJDate(fxoption.getSpotDate());
    }

    public int getDispOptionType() {
        return fxoption.getDispOptionType();
    }

    public String getDispOptionTypeAsString() {
        return fxoption.getDispOptionTypeAsString();
    }

    public int getPutCall() {
        return fxoption.getPutCall();
    }

    public int getOptionCalcOffset() {
        return fxoption.getOptionCalcOffset();
    }

    public boolean getOptionCalcOffsetDaysB() {
        return fxoption.getOptionCalcOffsetDaysB();
    }

    public boolean getOptionCalcBusB() {
        return fxoption.getOptionCalcBusB();
    }

    public String getABType() {
        return fxoption.getABType();
    }

    public Vector getSettlementTypeDomain() {
        return fxoption.getSettlementTypeDomain();
    }

    public AsianParameter getAsianParameter() {
        return fxoption.getAsianParameter();
    }

    public AsianParameter getAsianParameter1() {
        return fxoption.getAsianParameter1();
    }

    public Vector getValidTouchTypes() {
        return fxoption.getValidTouchTypes();
    }

    public String getFaderType() {
        return fxoption.getFaderType();
    }

    public String getFaderRangeType() {
        return fxoption.getFaderRangeType();
    }

    public double getFaderLowTriggerValue() {
        return fxoption.getFaderLowTriggerValue();
    }

    public double getFaderHighTriggerValue() {
        return fxoption.getFaderHighTriggerValue();
    }

    public double getFwdStartStrike() {
        return fxoption.getFwdStartStrike();
    }

    public BasicStrikeInputStyle getFwdStartStrikeStyle() {
        return fxoption.getFwdStartStrikeStyle();
    }

    public ATJDate getFwdStartFixingDate() {
        return new ATJDate(fxoption.getFwdStartFixingDate());
    }

    public FXReset getFwdStartFXReset() {
        return fxoption.getFwdStartFXReset();
    }

    public String getOptionSubType() {
        return fxoption.getOptionSubType();
    }

    public List getAsianParameters() {
        return fxoption.getAsianParameters();
    }

    public OptionFlavor getOptionFlavor() {
        return fxoption.getOptionFlavor();
    }

    public double getStrike() {
        return fxoption.getStrike();
    }

    public boolean getAutoExercise() {
        return fxoption.getAutoExercise();
    }

    public ATJDate getExpiryDate() {
        return new ATJDate(fxoption.getExpiryDate());
    }

    public int getExpiryTime() {
        return fxoption.getExpiryTime();
    }

    public TimeZone getExpiryTimeZone() {
        return fxoption.getExpiryTimeZone();
    }

    public ATJDate getFirstExerciseDate() {
        return new ATJDate(fxoption.getFirstExerciseDate());
    }

    public String getSettlementType() {
        return fxoption.getSettlementType();
    }

    public String getSettlementCurrency() {
        return fxoption.getSettlementCurrency();
    }

    public Product getUnderlyingProduct() {
        return fxoption.getUnderlyingProduct();
    }

    @Override
    public ATJDate getSettleDate() {
        return new ATJDate(fxoption.getSettleDate());
    }

    public String getSubType() {
        return fxoption.getSubType();
    }

    public String getExerciseType() {
        return fxoption.getExerciseType();
    }

    public JDatetime getUpBarrierEndDatetime() {
        return fxoption.getUpBarrierEndDatetime();
    }

    public JDatetime getUpBarrierStartDatetime() {
        return fxoption.getUpBarrierStartDatetime();
    }

    public JDatetime getDownBarrierEndDatetime() {
        return fxoption.getDownBarrierEndDatetime();
    }

    public JDatetime getDownBarrierStartDatetime() {
        return fxoption.getDownBarrierStartDatetime();
    }

    public List getBarrierDescriptors() {
        return fxoption.getBarrierDescriptors();
    }

    public String getDigitalPaymentType() {
        return fxoption.getDigitalPaymentType();
    }

    public String getCustomerFeeCcyPair() {
        return fxoption.getCustomerFeeCcyPair();
    }

    public double getPremiumRateToOption() {
        return fxoption.getPremiumRateToOption();
    }

    public String getPremiumBaseCcyPair() {
        return fxoption.getPremiumBaseCcyPair();
    }

    public double getPremiumRateToBase() {
        return fxoption.getPremiumRateToBase();
    }

    public ATJDate getResetDate() {
        return new ATJDate(fxoption.getResetDate());
    }

    public Vector getCashSettleInfo() {
        return fxoption.getCashSettleInfo();
    }

    public RateIndex getDefaultRateIndex() {
        return fxoption.getDefaultRateIndex();
    }

    public Frequency getDefaultFrequency() {
        return fxoption.getDefaultFrequency();
    }

    public Vector getDefaultHolidays() {
        return fxoption.getDefaultHolidays();
    }

    public DateRoll getDefaultDateRoll() {
        return fxoption.getDefaultDateRoll();
    }

    public DisplayValue getPriceDisplayValue() {
        return fxoption.getPriceDisplayValue();
    }

    public ForexHandler getCashConversion() {
        return fxoption.getCashConversion();
    }

    public String getQuoteName() {
        return fxoption.getQuoteName();
    }
}
