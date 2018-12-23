package calypsox.buggy.product;

import java.util.List;

import com.calypso.tk.core.CashFlowSet;
import com.calypso.tk.core.DateRule;
import com.calypso.tk.core.DayCount;
import com.calypso.tk.core.DisplayValue;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.Product;
import com.calypso.tk.core.Tenor;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.Cash;
import com.calypso.tk.product.Collateral;
import com.calypso.tk.product.Repo;
import com.calypso.tk.product.flow.CashFlowInterest;
import com.calypso.tk.refdata.LegalAgreement;

public class ATRepo extends ATSimpleMM {

    private final Repo repo;

    public ATRepo(final Trade trade) {
        super(trade);
        repo = (Repo) trade.getProduct();
    }

    public String getAllocationType() {
        return repo.getAllocationType();
    }

    public List getAllSecCollaterals() {
        return repo.getAllSecCollaterals();
    }

    public List getAppliedActionList() {
        return repo.getAppliedActionList();
    }

    public boolean getApplySecurityCurrencyRounding() {
        return repo.getApplySecurityCurrencyRounding();
    }

    public boolean getBSBLiquidationFlag() {
        return Repo.getBSBLiquidationFlag();
    }

    public boolean getBuySellBackB() {
        return repo.getBuySellBackB();
    }

    public Cash getCash() {
        return repo.getCash();
    }

    public List getCashPaymentFrequencyDomainValues() {
        return Repo.getCashPaymentFrequencyDomainValues();
    }

    public List getCashPaymentFrequencyObjectDomainValues() {
        return Repo.getCashPaymentFrequencyObjectDomainValues();
    }

    public long getCfCustomChanges() {
        return repo.getCfCustomChanges();
    }

    public long getCfGenerationLocks() {
        return repo.getCfGenerationLocks();
    }

    public CashFlowSet getCollateralFlows() {
        return repo.getCollateralFlows();
    }

    public List getCollaterals() {
        return repo.getCollaterals();
    }

    public String getCountry() {
        return repo.getCountry();
    }

    @Override
    public String getCurrency() {
        return repo.getCurrency();
    }

    public boolean getCustomFlowsB() {
        return repo.getCustomFlowsB();
    }

    public DayCount getDayCount() {
        return repo.getDayCount();
    }

    public String getDeliveryType() {
        return repo.getDeliveryType();
    }

    @Override
    public String getDescription() {
        return repo.getDescription();
    }

    public String getDirection() {
        return repo.getDirection();
    }

    @Override
    public boolean getDiscountB() {
        return repo.getDiscountB();
    }

    public boolean getDispatchInterestTransfersB() {
        return repo.getDispatchInterestTransfersB();
    }

    public boolean getDispatchTransfersB() {
        return repo.getDispatchTransfersB();
    }

    public List getEligibilityRuleFilterNames() {
        return repo.getEligibilityRuleFilterNames();
    }

    @Override
    public JDate getEndDate() {
        return repo.getEndDate();
    }

    public List getEventTypeActions() {
        return repo.getEventTypeActions();
    }

    public String getFillCategory() {
        return repo.getFillCategory();
    }

    public String getFillType() {
        return repo.getFillType();
    }

    public List getFillTypeDomainValues() {
        return Repo.getFillTypeDomainValues();
    }

    public Collateral getFirstCollateral() {
        return repo.getFirstCollateral();
    }

    @Override
    public double getFixedRate() {
        return repo.getFixedRate();
    }

    @Override
    public CashFlowSet getFlows() {
        return repo.getFlows();
    }

    public boolean getForceDAPFlag() {
        return repo.getForceDAPFlag();
    }

    public boolean getGenerateCashTransfersB() {
        return repo.getGenerateCashTransfersB();
    }

    public boolean getHoldInCustodyB() {
        return repo.getHoldInCustodyB();
    }

    public double getIndemnityRate() {
        return repo.getIndemnityRate();
    }

    public String getInterestDispatchMethod() {
        return repo.getInterestDispatchMethod();
    }

    public List getInterestMethodDomainValues() {
        return Repo.getInterestMethodDomainValues();
    }

    public double getInternalRepoRate() {
        return repo.getInternalRepoRate();
    }

    public double getInternalRepoSpread() {
        return repo.getInternalRepoSpread();
    }

    public JDatetime getIntradayEndTime() {
        return repo.getIntradayEndTime();
    }

    public JDatetime getIntradayStartTime() {
        return repo.getIntradayStartTime();
    }

    public boolean getIsCollateralOnlyB() {
        return repo.getIsCollateralOnlyB();
    }

    public boolean getIsExotic() {
        return repo.getIsExotic();
    }

    public boolean getIsMultiCollateralB() {
        return repo.getIsMultiCollateralB();
    }

    public boolean getIsReratedB() {
        return repo.getIsReratedB();
    }

    public int getIssuePayingAgentId() {
        return repo.getIssuePayingAgentId();
    }

    public int getIssuerId() {
        return repo.getIssuerId();
    }

    public CashFlowInterest getLastInterestFlow() {
        return repo.getLastInterestFlow();
    }

    public JDate getLastSubstitutionDate() {
        return repo.getLastSubstitutionDate();
    }

    public double getLatestPrincipalAmount() {
        return repo.getLatestPrincipalAmount();
    }

    public LegalAgreement getLegalAgreement() {
        return repo.getLegalAgreement();
    }

    public int getLegalAgreementId() {
        return repo.getLegalAgreementId();
    }

    @Override
    public JDate getMaturityDate() {
        return repo.getMaturityDate();
    }

    public double getMinimumParAmount() {
        return repo.getMinimumParAmount();
    }

    @Override
    public int getNoticeDays() {
        return repo.getNoticeDays();
    }

    @Override
    public boolean getOpenTermB() {
        return repo.getOpenTermB();
    }

    public List getPaymentHolidays() {
        return repo.getPaymentHolidays();
    }

    public boolean getPledgeB() {
        return repo.getPledgeB();
    }

    public boolean getPoolB() {
        return repo.getPoolB();
    }

    public DisplayValue getPriceDisplayValue() {
        return repo.getPriceDisplayValue();
    }

    public double getPrincipal() {
        return repo.getPrincipal();
    }

    public String getPrincipalCurrency() {
        return repo.getPrincipalCurrency();
    }

    @Override
    public String getProductClass() {
        return repo.getProductClass();
    }

    @Override
    public String getProductFamily() {
        return repo.getProductFamily();
    }

    public int getProductId() {
        return repo.getProductId();
    }

    public List getRepoTypeChoices() {
        return Repo.getRepoTypeChoices();
    }

    public DateRule getRepriceFrequency() {
        return repo.getRepriceFrequency();
    }

    public boolean getRSLB() {
        return repo.getRSLB();
    }

    @Override
    public double getSalesMargin() {
        return repo.getSalesMargin();
    }

    public Product getSecurity() {
        return repo.getSecurity();
    }

    public int getSign() {
        return repo.getSign();
    }

    public boolean getSingleCollateralB() {
        return repo.getSingleCollateralB();
    }

    @Override
    public double getSpread() {
        return repo.getSpread();
    }

    @Override
    public JDate getStartDate() {
        return repo.getStartDate();
    }

    public boolean getSubstitutionB() {
        return repo.getSubstitutionB();
    }

    public DateRule getSubstitutionFrequency() {
        return repo.getSubstitutionFrequency();
    }

    public int getSubstitutionLimit() {
        return repo.getSubstitutionLimit();
    }

    public Tenor getSubstitutionTenor() {
        return repo.getSubstitutionTenor();
    }

    @Override
    public String getSubType() {
        return repo.getSubType();
    }

    public boolean getTripartyRepoB() {
        return repo.getTripartyRepoB();
    }

    public List getValidActionTypes() {
        return repo.getValidActionTypes();
    }

    public List getValidBulkActionTypes() {
        return repo.getValidBulkActionTypes();
    }

    public boolean getZarB() {
        return repo.getZarB();
    }

}
