package calypsox.buggy.refdata;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import com.calypso.tk.core.DateRule;
import com.calypso.tk.core.GDIdentifiers;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.LegalEntity;
import com.calypso.tk.refdata.MarginCallConfig;
import com.calypso.tk.refdata.MarginCallConfigInterface;
import com.calypso.tk.refdata.collateral.impl.MarginCallConfigCurrencyCore;

/**
 * Retrieve and manage information for MarginCallConfig
 */
public class ATMarginCallConfig {

    /** The contract. */
    MarginCallConfig margincallconfig;

    /**
     * Instantiates a new AAT margin call config.
     *
     * @param contract
     *            the contract
     */
    public ATMarginCallConfig(final MarginCallConfig contract) {
        margincallconfig = contract;
    }

    public String getAgreementStatus() {
        return margincallconfig.getAgreementStatus();
    }

    public List getAllSubtypes() {
        return margincallconfig.getAllSubtypes();
    }

    public String getAuthName() {
        return margincallconfig.getAuthName();
    }

    public String getAvailableCurrencies() {
        @SuppressWarnings("unchecked")
        final List<MarginCallConfigCurrencyCore> mcCurrencies = margincallconfig.getAvailableCurrencies();
        return getCurrencies(mcCurrencies);
    }

    public ATBook getBook() {
        return new ATBook(margincallconfig.getBook());
    }

    public List getChildren() {
        return margincallconfig.getChildren();
    }

    public JDatetime getClosingDate() {
        return margincallconfig.getClosingDate();
    }

    public List getCollateralDates() {
        return margincallconfig.getCollateralDates();
    }

    public String getCollateralPolicy() {
        return margincallconfig.getCollateralPolicy();
    }

    public String getComment() {
        return margincallconfig.getComment();
    }

    public boolean getCompoundingB() {
        return margincallconfig.getCompoundingB();
    }

    public String getContractType() {
        return margincallconfig.getContractType();
    }

    public String getCurrency() {
        return margincallconfig.getCurrency();
    }

    public String getCurrencyList() {
        @SuppressWarnings("unchecked")
        final List<MarginCallConfigCurrencyCore> mcCurrencies = margincallconfig.getCurrencyList();
        return getCurrencies(mcCurrencies);
    }

    public DateRule getDateRule() {
        return margincallconfig.getDateRule();
    }

    public String getDescription() {
        return margincallconfig.getDescription();
    }

    public String getDisputeAltProcedure() {
        return margincallconfig.getDisputeAltProcedure();
    }

    public String getDisputeMethod() {
        return margincallconfig.getDisputeMethod();
    }

    public double getDisputeToleranceAmount() {
        return margincallconfig.getDisputeToleranceAmount();
    }

    public String getEffDateType() {
        return margincallconfig.getEffDateType();
    }

    /**
     * Gets the eligible currencies.
     *
     * @return the eligible currencies
     */
    public String getEligibleCurrencies() {
        @SuppressWarnings("unchecked")
        final List<MarginCallConfigCurrencyCore> mcCurrencies = margincallconfig.getEligibleCurrencies();
        return getCurrencies(mcCurrencies);
    }

    public GDIdentifiers getGlobalDeploymentIdentifiers() {
        return margincallconfig.getGlobalDeploymentIdentifiers();
    }

    public String getHaircutName() {
        return margincallconfig.getHaircutName();
    }

    public String getHaircutType() {
        return margincallconfig.getHaircutType();
    }

    public int getId() {
        return margincallconfig.getId();
    }

    public String getIdShortName() {
        return margincallconfig.getIdShortName();
    }

    public MarginCallConfigInterface getImplementation() {
        return margincallconfig.getImplementation();
    }

    public boolean getIsPercentageLimit() {
        return margincallconfig.getIsPercentageLimit();
    }

    public Set getKeys() {
        return margincallconfig.getKeys();
    }

    public int getLeCashOffset() {
        return margincallconfig.getLeCashOffset();
    }

    public String getLeCollType() {
        return margincallconfig.getLeCollType();
    }

    public LegalEntity getLegalEntity() {
        return margincallconfig.getLegalEntity();
    }

    public double getLeIAAmount() {
        return margincallconfig.getLeIAAmount();
    }

    public String getLeIAApplicableTo() {
        return margincallconfig.getLeIAApplicableTo();
    }

    public String getLeIACurrency() {
        return margincallconfig.getLeIACurrency();
    }

    public double getLeIAPercent() {
        return margincallconfig.getLeIAPercent();
    }

    public String getLeIAScheduleName() {
        return margincallconfig.getLeIAScheduleName();
    }

    public String getLeIAType() {
        return margincallconfig.getLeIAType();
    }

    public double getLeMTAAmount() {
        return margincallconfig.getLeMTAAmount();
    }

    public double getLeMTAPercentage() {
        return margincallconfig.getLeMTAPercentage();
    }

    public String getLeMTARatingDirection() {
        return margincallconfig.getLeMTARatingDirection();
    }

    public String getLeMTAType() {
        return margincallconfig.getLeMTAType();
    }

    public double getLeNewThresholdAmount() {
        return margincallconfig.getLeNewThresholdAmount();
    }

    public double getLeNewThresholdPercentage() {
        return margincallconfig.getLeNewThresholdPercentage();
    }

    public String getLeNewThresholdType() {
        return margincallconfig.getLeNewThresholdType();
    }

    public double getLeReturnRoundingFigure() {
        return margincallconfig.getLeReturnRoundingFigure();
    }

    public String getLeReturnRoundingMethod() {
        return margincallconfig.getLeReturnRoundingMethod();
    }

    public String getLeRole() {
        return margincallconfig.getLeRole();
    }

    public double getLeRoundingFigure() {
        return margincallconfig.getLeRoundingFigure();
    }

    public String getLeRoundingMethod() {
        return margincallconfig.getLeRoundingMethod();
    }

    public int getLeSecurityOffset() {
        return margincallconfig.getLeSecurityOffset();
    }

    public String getLeThresholdRatingDirection() {
        return margincallconfig.getLeThresholdRatingDirection();
    }

    public double getLimitAmount() {
        return margincallconfig.getLimitAmount();
    }

    public int getMasterAgreementId() {
        return margincallconfig.getMasterAgreementId();
    }

    public double getMaxAdjThresholdAmount() {
        return margincallconfig.getMaxAdjThresholdAmount();
    }

    public double getMinAdjThresholdAmount() {
        return margincallconfig.getMinAdjThresholdAmount();
    }

    public String getName() {
        return margincallconfig.getName();
    }

    public MarginCallConfigInterface getNonNettedIAContract() {
        return margincallconfig.getNonNettedIAContract();
    }

    public JDatetime getNotificationTime() {
        return margincallconfig.getNotificationTime();
    }

    public TimeZone getNotificationTimeZone() {
        return margincallconfig.getNotificationTimeZone();
    }

    public String getOrdererRole() {
        return margincallconfig.getOrdererRole();
    }

    public List getOriginalProductList() {
        return margincallconfig.getOriginalProductList();
    }

    public int getParentId() {
        return margincallconfig.getParentId();
    }

    public int getPoCashOffset() {
        return margincallconfig.getPoCashOffset();
    }

    public String getPoCollType() {
        return margincallconfig.getPoCollType();
    }

    public double getPoIAAmount() {
        return margincallconfig.getPoIAAmount();
    }

    public String getPoIAApplicableTo() {
        return margincallconfig.getPoIAApplicableTo();
    }

    public String getPoIACurrency() {
        return margincallconfig.getPoIACurrency();
    }

    public double getPoIAPercent() {
        return margincallconfig.getPoIAPercent();
    }

    public String getPoIAScheduleName() {
        return margincallconfig.getPoIAScheduleName();
    }

    public String getPoIAType() {
        return margincallconfig.getPoIAType();
    }

    public double getPoMTAAmount() {
        return margincallconfig.getPoMTAAmount();
    }

    public double getPoMTAPercentage() {
        return margincallconfig.getPoMTAPercentage();
    }

    public String getPoMTARatingDirection() {
        return margincallconfig.getPoMTARatingDirection();
    }

    public String getPoMTAType() {
        return margincallconfig.getPoMTAType();
    }

    public double getPoNewThresholdAmount() {
        return margincallconfig.getPoNewThresholdAmount();
    }

    public double getPoNewThresholdPercentage() {
        return margincallconfig.getPoNewThresholdPercentage();
    }

    public String getPoNewThresholdType() {
        return margincallconfig.getPoNewThresholdType();
    }

    public double getPoReturnRoundingFigure() {
        return margincallconfig.getPoReturnRoundingFigure();
    }

    public String getPoReturnRoundingMethod() {
        return margincallconfig.getPoReturnRoundingMethod();
    }

    public double getPoRoundingFigure() {
        return margincallconfig.getPoRoundingFigure();
    }

    public String getPoRoundingMethod() {
        return margincallconfig.getPoRoundingMethod();
    }

    public int getPoSecurityOffset() {
        return margincallconfig.getPoSecurityOffset();
    }

    public String getPoThresholdRatingDirection() {
        return margincallconfig.getPoThresholdRatingDirection();
    }

    public String getPricingEnvName() {
        return margincallconfig.getPricingEnvName();
    }

    public ATLegalEntity getProcessingOrg() {
        return new ATLegalEntity(margincallconfig.getProcessingOrg());
    }

    public String getProdStaticDataFilterName() {
        return margincallconfig.getProdStaticDataFilterName();
    }

    public List getProductList() {
        return margincallconfig.getProductList();
    }

    public JDatetime getResolutionTime() {
        return margincallconfig.getResolutionTime();
    }

    public TimeZone getResolutionTimeZone() {
        return margincallconfig.getResolutionTimeZone();
    }

    public JDatetime getResponseTime() {
        return margincallconfig.getResponseTime();
    }

    public TimeZone getResponseTimeZone() {
        return margincallconfig.getResponseTimeZone();
    }

    public int getRollInterestSettleDays() {
        return margincallconfig.getRollInterestSettleDays();
    }

    public int getSettlementCutOff() {
        return margincallconfig.getSettlementCutOff();
    }

    public String getShortName() {
        return margincallconfig.getShortName();
    }

    public JDatetime getStartingDate() {
        return margincallconfig.getStartingDate();
    }

    public DateRule getStatementDateRule() {
        return margincallconfig.getStatementDateRule();
    }

    public String getSubstitutionDateOption() {
        return margincallconfig.getSubstitutionDateOption();
    }

    public JDatetime getSubstitutionTime() {
        return margincallconfig.getSubstitutionTime();
    }

    public TimeZone getSubstitutionTimeZone() {
        return margincallconfig.getSubstitutionTimeZone();
    }

    public String getSubtype() {
        return margincallconfig.getSubtype();
    }

    public String getUser() {
        return margincallconfig.getUser();
    }

    public int getValuationAgentId() {
        return margincallconfig.getValuationAgentId();
    }

    public String getValuationAgentType() {
        return margincallconfig.getValuationAgentType();
    }

    public JDatetime getValuationTime() {
        return margincallconfig.getValuationTime();
    }

    public TimeZone getValuationTimeZone() {
        return margincallconfig.getValuationTimeZone();
    }

    public int getVersion() {
        return margincallconfig.getVersion();
    }

    private String getCurrencies(final List<MarginCallConfigCurrencyCore> mcCurrencies) {
        final List<String> currencies = new ArrayList<String>();
        for (final Object currency : mcCurrencies) {
            final MarginCallConfigCurrencyCore ccyCore = (MarginCallConfigCurrencyCore) currency;
            currencies.add(ccyCore.getCurrency());
        }
        Collections.sort(currencies, Collator.getInstance());
        return currencies.toString();
    }
}
