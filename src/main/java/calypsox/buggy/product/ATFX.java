package calypsox.buggy.product;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.Vector;

import com.calypso.tk.core.CallInfo;
import com.calypso.tk.core.CashFlowSet;
import com.calypso.tk.core.CreditContingencyInfo;
import com.calypso.tk.core.DisplayValue;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.ProductCustomData;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.FX;
import com.calypso.tk.refdata.CurrencyPair;
import com.calypso.tk.refdata.PreciousMetalForm;
import com.calypso.tk.refdata.RateIndex;

import calypsox.buggy.refdata.ATJDate;
import calypsox.buggy.ui.ATAmount;

/**
 * The Class ATFX.
 */
public class ATFX extends ATTrade {

    /** The fx. */
    private final FX fx;

    /**
     * Instantiates a new atfx.
     *
     * @param trade
     *            the trade
     */
    public ATFX(final Trade trade) {
        super(trade);
        fx = (FX) trade.getProduct();
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return fx.getCurrency();
    }

    /**
     * Gets the currency pair.
     *
     * @return the currency pair
     */
    public CurrencyPair getCurrencyPair() {
        return fx.getCurrencyPair();
    }

    /**
     * Gets the precious metal form.
     *
     * @return the precious metal form
     */
    public PreciousMetalForm getPreciousMetalForm() {
        return fx.getPreciousMetalForm();
    }

    /**
     * Gets the principal currency.
     *
     * @return the principal currency
     */
    public String getPrincipalCurrency() {
        return fx.getPrincipalCurrency();
    }

    /**
     * Gets the quoting currency.
     *
     * @return the quoting currency
     */
    public String getQuotingCurrency() {
        return fx.getQuotingCurrency();
    }

    /**
     * Gets the principal amount.
     *
     * @return the principal amount
     */
    public ATAmount getPrincipalAmount() {
        return new ATAmount(fx.getPrincipalCurrency(), fx.getPrincipal());
    }

    /**
     * Gets the principal amount.
     *
     * @return the principal amount
     */
    public ATAmount getPrimaryAmount() {
        return new ATAmount(fx.getPrincipalCurrency(), fx.getPrimaryAmount(trade).get());
    }

    /**
     * Gets the quoting amount.
     *
     * @return the quoting amount
     */
    public ATAmount getQuotingAmount() {
        return new ATAmount(fx.getQuotingCurrency(), fx.getQuoteAmount(trade).get());
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return fx.getDescription();
    }

    /**
     * Gets the quote name.
     *
     * @return the quote name
     */
    public String getQuoteName() {
        return fx.getQuoteName();
    }

    /**
     * Gets the primary currency.
     *
     * @return the primary currency
     */
    public String getPrimaryCurrency() {
        return fx.getPrimaryCurrency();
    }

    /**
     * Gets the sub type.
     *
     * @return the sub type
     */
    public String getSubType() {
        return fx.getSubType();
    }

    /**
     * Gets the used holidays.
     *
     * @return the used holidays
     */
    public String[] getUsedHolidays() {
        return fx.getUsedHolidays();
    }

    /**
     * Gets the price display value.
     *
     * @return the price display value
     */
    public DisplayValue getPriceDisplayValue() {
        return fx.getPriceDisplayValue();
    }

    /**
     * Gets the quote type.
     *
     * @return the quote type
     */
    public String getQuoteType() {
        return fx.getQuoteType();
    }

    /**
     * Gets the allocator.
     *
     * @return the allocator
     */
    public String getAllocator() {
        return fx.getAllocator();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATTrade#getComment()
     */
    @Override
    public String getComment() {
        return fx.getComment();
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return fx.getName();
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return fx.getType();
    }

    /**
     * Gets the final payment maturity date.
     *
     * @return the final payment maturity date
     */
    public ATJDate getFinalPaymentMaturityDate() {
        return new ATJDate(fx.getFinalPaymentMaturityDate());
    }

    /**
     * Gets the custom description.
     *
     * @return the custom description
     */
    public String getCustomDescription() {
        return fx.getCustomDescription();
    }

    /**
     * Gets the custom quote name.
     *
     * @return the custom quote name
     */
    public String getCustomQuoteName() {
        return fx.getCustomQuoteName();
    }

    /**
     * Gets the auth name.
     *
     * @return the auth name
     */
    public String getAuthName() {
        return fx.getAuthName();
    }

    /**
     * Gets the entered datetime.
     *
     * @return the entered datetime
     */
    public JDatetime getEnteredDatetime() {
        return fx.getEnteredDatetime();
    }

    /**
     * Gets the x prod config id.
     *
     * @return the x prod config id
     */
    public int getXProdConfigId() {
        return fx.getXProdConfigId();
    }

    /**
     * Gets the extended type.
     *
     * @return the extended type
     */
    public String getExtendedType() {
        return fx.getExtendedType();
    }

    /**
     * Gets the pricer override key.
     *
     * @return the pricer override key
     */
    public String getPricerOverrideKey() {
        return fx.getPricerOverrideKey();
    }

    /**
     * Gets the mdi override key.
     *
     * @return the mdi override key
     */
    public String getMdiOverrideKey() {
        return fx.getMdiOverrideKey();
    }

    /**
     * Gets the market place id.
     *
     * @return the market place id
     */
    public int getMarketPlaceId() {
        return fx.getMarketPlaceId();
    }

    /**
     * Gets the sec codes.
     *
     * @return the sec codes
     */
    public Map getSecCodes() {
        return fx.getSecCodes();
    }

    /**
     * Gets the custom flows B.
     *
     * @return the custom flows B
     */
    public boolean getCustomFlowsB() {
        return fx.getCustomFlowsB();
    }

    /**
     * Gets the schedule.
     *
     * @return the schedule
     */
    public List getSchedule() {
        return fx.getSchedule();
    }

    /**
     * Gets the maturity date.
     *
     * @return the maturity date
     */
    public ATJDate getMaturityDate() {
        return new ATJDate(fx.getMaturityDate());
    }

    /**
     * Gets the flows.
     *
     * @return the flows
     */
    public CashFlowSet getFlows() {
        return fx.getFlows();
    }

    /**
     * Gets the spot days.
     *
     * @return the spot days
     */
    public int getSpotDays() {
        return fx.getSpotDays();
    }

    /**
     * Gets the rate index.
     *
     * @return the rate index
     */
    public RateIndex getRateIndex() {
        return fx.getRateIndex();
    }

    /**
     * Gets the rate index 2.
     *
     * @return the rate index 2
     */
    public RateIndex getRateIndex2() {
        return fx.getRateIndex2();
    }

    /**
     * Gets the rate indexes.
     *
     * @return the rate indexes
     */
    @SuppressWarnings("unchecked")
    public Collection<RateIndex> getRateIndexes() {
        return fx.getRateIndexes();
    }

    /**
     * Gets the currencies.
     *
     * @return the currencies
     */
    @SuppressWarnings("unchecked")
    public Collection<String> getCurrencies() {
        return fx.getCurrencies();
    }

    /**
     * Gets the custom data.
     *
     * @return the custom data
     */
    public ProductCustomData getCustomData() {
        return fx.getCustomData();
    }

    /**
     * Gets the subtypes.
     *
     * @return the subtypes
     */
    public Vector getSubtypes() {
        return fx.getSubtypes();
    }

    /**
     * Gets the extended types.
     *
     * @return the extended types
     */
    public Vector getExtendedTypes() {
        return fx.getExtendedTypes();
    }

    /**
     * Gets the custom sub type.
     *
     * @return the custom sub type
     */
    public String getCustomSubType() {
        return fx.getCustomSubType();
    }

    /**
     * Gets the holidays.
     *
     * @return the holidays
     */
    public Vector getHolidays() {
        return fx.getHolidays();
    }

    /**
     * Gets the underlying security id.
     *
     * @return the underlying security id
     */
    public int getUnderlyingSecurityId() {
        return fx.getUnderlyingSecurityId();
    }

    /**
     * Gets the underlying security ids.
     *
     * @return the underlying security ids
     */
    public List getUnderlyingSecurityIds() {
        return fx.getUnderlyingSecurityIds();
    }

    /**
     * Gets the all flows.
     *
     * @return the all flows
     */
    public CashFlowSet getAllFlows() {
        return fx.getAllFlows();
    }

    /**
     * Gets the associated quote names.
     *
     * @return the associated quote names
     */
    public Vector getAssociatedQuoteNames() {
        return fx.getAssociatedQuoteNames();
    }

    /**
     * Gets the entity id.
     *
     * @return the entity id
     */
    public int getEntityId() {
        return fx.getEntityId();
    }

    /**
     * Gets the entity type.
     *
     * @return the entity type
     */
    public String getEntityType() {
        return fx.getEntityType();
    }

    /**
     * Gets the call info.
     *
     * @return the call info
     */
    public CallInfo getCallInfo() {
        return fx.getCallInfo();
    }

    /**
     * Gets the credit contingency info.
     *
     * @return the credit contingency info
     */
    public CreditContingencyInfo getCreditContingencyInfo() {
        return fx.getCreditContingencyInfo();
    }

    /**
     * Gets the issuer ids.
     *
     * @return the issuer ids
     */
    public Vector getIssuerIds() {
        return fx.getIssuerIds();
    }

    /**
     * Gets the reference entities.
     *
     * @return the reference entities
     */
    public Vector getReferenceEntities() {
        return fx.getReferenceEntities();
    }

    /**
     * Gets the supported credit event protocol types.
     *
     * @return the supported credit event protocol types
     */
    public List getSupportedCreditEventProtocolTypes() {
        return fx.getSupportedCreditEventProtocolTypes();
    }

    /**
     * Gets the exercised date.
     *
     * @return the exercised date
     */
    public ATJDate getExercisedDate() {
        return new ATJDate(fx.getExercisedDate());
    }

    /**
     * Gets the exercised datetime.
     *
     * @return the exercised datetime
     */
    public JDatetime getExercisedDatetime() {
        return fx.getExercisedDatetime();
    }

    /**
     * Gets the strike.
     *
     * @return the strike
     */
    public double getStrike() {
        return fx.getStrike();
    }

    /**
     * Gets the up barrier value.
     *
     * @return the up barrier value
     */
    public double getUpBarrierValue() {
        return fx.getUpBarrierValue();
    }

    /**
     * Gets the down barrier value.
     *
     * @return the down barrier value
     */
    public double getDownBarrierValue() {
        return fx.getDownBarrierValue();
    }

    /**
     * Gets the up barrier type.
     *
     * @return the up barrier type
     */
    public String getUpBarrierType() {
        return fx.getUpBarrierType();
    }

    /**
     * Gets the down barrier type.
     *
     * @return the down barrier type
     */
    public String getDownBarrierType() {
        return fx.getDownBarrierType();
    }

    /**
     * Gets the first barrier value.
     *
     * @return the first barrier value
     */
    public double getFirstBarrierValue() {
        return fx.getFirstBarrierValue();
    }

    /**
     * Gets the second barrier value.
     *
     * @return the second barrier value
     */
    public double getSecondBarrierValue() {
        return fx.getSecondBarrierValue();
    }

    /**
     * Gets the first barrier type.
     *
     * @return the first barrier type
     */
    public String getFirstBarrierType() {
        return fx.getFirstBarrierType();
    }

    /**
     * Gets the second barrier type.
     *
     * @return the second barrier type
     */
    public String getSecondBarrierType() {
        return fx.getSecondBarrierType();
    }

    /**
     * Gets the first barrier way.
     *
     * @return the first barrier way
     */
    public String getFirstBarrierWay() {
        return fx.getFirstBarrierWay();
    }

    /**
     * Gets the second barrier way.
     *
     * @return the second barrier way
     */
    public String getSecondBarrierWay() {
        return fx.getSecondBarrierWay();
    }

    /**
     * Gets the rebate.
     *
     * @return the rebate
     */
    public double getRebate() {
        return fx.getRebate();
    }

    /**
     * Gets the exp date.
     *
     * @return the exp date
     */
    public ATJDate getExpDate() {
        return new ATJDate(fx.getExpDate());
    }

    /**
     * Gets the expiry time.
     *
     * @return the expiry time
     */
    public int getExpiryTime() {
        return fx.getExpiryTime();
    }

    /**
     * Gets the expiry time zone.
     *
     * @return the expiry time zone
     */
    public TimeZone getExpiryTimeZone() {
        return fx.getExpiryTimeZone();
    }

    /**
     * Gets the put call.
     *
     * @return the put call
     */
    public int getPutCall() {
        return fx.getPutCall();
    }

    /**
     * Gets the exercise type.
     *
     * @return the exercise type
     */
    public String getExerciseType() {
        return fx.getExerciseType();
    }

    /**
     * Gets the checks if is exotic.
     *
     * @return the checks if is exotic
     */
    public boolean getIsExotic() {
        return fx.getIsExotic();
    }

    /**
     * Gets the exotic financial legs.
     *
     * @return the exotic financial legs
     */
    public Vector getExoticFinancialLegs() {
        return fx.getExoticFinancialLegs();
    }

    /**
     * Gets the x prod config name.
     *
     * @return the x prod config name
     */
    public String getXProdConfigName() {
        return fx.getXProdConfigName();
    }

    /**
     * Gets the use post processor.
     *
     * @return the use post processor
     */
    public boolean getUsePostProcessor() {
        return fx.getUsePostProcessor();
    }

}
