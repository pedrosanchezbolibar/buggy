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
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.ProductCustomData;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.FX;
import com.calypso.tk.product.xprod.ProductXMLData;
import com.calypso.tk.refdata.CurrencyPair;
import com.calypso.tk.refdata.PreciousMetalForm;
import com.calypso.tk.refdata.RateIndex;

import calypsox.buggy.ui.ATAmount;

public class ATFX extends ATTrade {

    private final FX fx;

    public ATFX(final Trade trade) {
	super(trade);
	fx = (FX) trade.getProduct();
    }

    public String getCurrency() {
	return fx.getCurrency();
    }

    public CurrencyPair getCurrencyPair() {
	return fx.getCurrencyPair();
    }

    public PreciousMetalForm getPreciousMetalForm() {
	return fx.getPreciousMetalForm();
    }

    public String getPrincipalCurrency() {
	return fx.getPrincipalCurrency();
    }

    public String getQuotingCurrency() {
	return fx.getQuotingCurrency();
    }

    public ATAmount getPrincipal() {
	return new ATAmount(fx.getPrincipalCurrency(), fx.getPrincipal());
    }

    public String getDescription() {
	return fx.getDescription();
    }

    public String getQuoteName() {
	return fx.getQuoteName();
    }

    public String getPrimaryCurrency() {
	return fx.getPrimaryCurrency();
    }

    public String getSubType() {
	return fx.getSubType();
    }

    public String[] getUsedHolidays() {
	return fx.getUsedHolidays();
    }

    public DisplayValue getPriceDisplayValue() {
	return fx.getPriceDisplayValue();
    }

    public String getQuoteType() {
	return fx.getQuoteType();
    }

    public String getAllocator() {
	return fx.getAllocator();
    }

    @Override
    public String getComment() {
	return fx.getComment();
    }

    public String getName() {
	return fx.getName();
    }

    public String getType() {
	return fx.getType();
    }

    public JDate getFinalPaymentMaturityDate() {
	return fx.getFinalPaymentMaturityDate();
    }

    public String getCustomDescription() {
	return fx.getCustomDescription();
    }

    public String getCustomQuoteName() {
	return fx.getCustomQuoteName();
    }

    public String getAuthName() {
	return fx.getAuthName();
    }

    public JDatetime getEnteredDatetime() {
	return fx.getEnteredDatetime();
    }

    public int getXProdConfigId() {
	return fx.getXProdConfigId();
    }

    public String getExtendedType() {
	return fx.getExtendedType();
    }

    public String getPricerOverrideKey() {
	return fx.getPricerOverrideKey();
    }

    public String getMdiOverrideKey() {
	return fx.getMdiOverrideKey();
    }

    public int getMarketPlaceId() {
	return fx.getMarketPlaceId();
    }

    public Map getSecCodes() {
	return fx.getSecCodes();
    }

    public boolean getCustomFlowsB() {
	return fx.getCustomFlowsB();
    }

    public List getSchedule() {
	return fx.getSchedule();
    }

    public JDate getMaturityDate() {
	return fx.getMaturityDate();
    }

    public CashFlowSet getFlows() {
	return fx.getFlows();
    }

    public int getSpotDays() {
	return fx.getSpotDays();
    }

    public RateIndex getRateIndex() {
	return fx.getRateIndex();
    }

    public RateIndex getRateIndex2() {
	return fx.getRateIndex2();
    }

    @SuppressWarnings("unchecked")
    public Collection<RateIndex> getRateIndexes() {
	return fx.getRateIndexes();
    }

    @SuppressWarnings("unchecked")
    public Collection<String> getCurrencies() {
	return fx.getCurrencies();
    }

    public ProductCustomData getCustomData() {
	return fx.getCustomData();
    }

    public Vector getSubtypes() {
	return fx.getSubtypes();
    }

    public Vector getExtendedTypes() {
	return fx.getExtendedTypes();
    }

    public String getCustomSubType() {
	return fx.getCustomSubType();
    }

    public Vector getHolidays() {
	return fx.getHolidays();
    }

    public int getUnderlyingSecurityId() {
	return fx.getUnderlyingSecurityId();
    }

    public List getUnderlyingSecurityIds() {
	return fx.getUnderlyingSecurityIds();
    }

    public CashFlowSet getAllFlows() {
	return fx.getAllFlows();
    }

    public Vector getAssociatedQuoteNames() {
	return fx.getAssociatedQuoteNames();
    }

    public int getEntityId() {
	return fx.getEntityId();
    }

    public String getEntityType() {
	return fx.getEntityType();
    }

    public CallInfo getCallInfo() {
	return fx.getCallInfo();
    }

    public CreditContingencyInfo getCreditContingencyInfo() {
	return fx.getCreditContingencyInfo();
    }

    public Vector getIssuerIds() {
	return fx.getIssuerIds();
    }

    public Vector getReferenceEntities() {
	return fx.getReferenceEntities();
    }

    public List getSupportedCreditEventProtocolTypes() {
	return fx.getSupportedCreditEventProtocolTypes();
    }

    public JDate getExercisedDate() {
	return fx.getExercisedDate();
    }

    public JDatetime getExercisedDatetime() {
	return fx.getExercisedDatetime();
    }

    public double getStrike() {
	return fx.getStrike();
    }

    public double getUpBarrierValue() {
	return fx.getUpBarrierValue();
    }

    public double getDownBarrierValue() {
	return fx.getDownBarrierValue();
    }

    public String getUpBarrierType() {
	return fx.getUpBarrierType();
    }

    public String getDownBarrierType() {
	return fx.getDownBarrierType();
    }

    public double getFirstBarrierValue() {
	return fx.getFirstBarrierValue();
    }

    public double getSecondBarrierValue() {
	return fx.getSecondBarrierValue();
    }

    public String getFirstBarrierType() {
	return fx.getFirstBarrierType();
    }

    public String getSecondBarrierType() {
	return fx.getSecondBarrierType();
    }

    public String getFirstBarrierWay() {
	return fx.getFirstBarrierWay();
    }

    public String getSecondBarrierWay() {
	return fx.getSecondBarrierWay();
    }

    public double getRebate() {
	return fx.getRebate();
    }

    public JDate getExpDate() {
	return fx.getExpDate();
    }

    public int getExpiryTime() {
	return fx.getExpiryTime();
    }

    public TimeZone getExpiryTimeZone() {
	return fx.getExpiryTimeZone();
    }

    public int getPutCall() {
	return fx.getPutCall();
    }

    public String getExerciseType() {
	return fx.getExerciseType();
    }

    public boolean getIsExotic() {
	return fx.getIsExotic();
    }

    public Vector getExoticFinancialLegs() {
	return fx.getExoticFinancialLegs();
    }

    public ProductXMLData getXMLData() {
	return fx.getXMLData();
    }

    public String getXProdConfigName() {
	return fx.getXProdConfigName();
    }

    public boolean getUsePostProcessor() {
	return fx.getUsePostProcessor();
    }

}
