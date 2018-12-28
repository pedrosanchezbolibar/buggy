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
 * Retrieve and manage information for MarginCallConfig.
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

    /**
     * Gets the agreement status.
     *
     * @return the agreement status
     */
    public String getAgreementStatus() {
        return margincallconfig.getAgreementStatus();
    }

    /**
     * Gets the all subtypes.
     *
     * @return the all subtypes
     */
    public List getAllSubtypes() {
        return margincallconfig.getAllSubtypes();
    }

    /**
     * Gets the auth name.
     *
     * @return the auth name
     */
    public String getAuthName() {
        return margincallconfig.getAuthName();
    }

    /**
     * Gets the available currencies.
     *
     * @return the available currencies
     */
    public String getAvailableCurrencies() {
        @SuppressWarnings("unchecked")
        final List<MarginCallConfigCurrencyCore> mcCurrencies = margincallconfig.getAvailableCurrencies();
        return getCurrencies(mcCurrencies);
    }

    /**
     * Gets the book.
     *
     * @return the book
     */
    public ATBook getBook() {
        return new ATBook(margincallconfig.getBook());
    }

    /**
     * Gets the children.
     *
     * @return the children
     */
    public List getChildren() {
        return margincallconfig.getChildren();
    }

    /**
     * Gets the closing date.
     *
     * @return the closing date
     */
    public JDatetime getClosingDate() {
        return margincallconfig.getClosingDate();
    }

    /**
     * Gets the collateral dates.
     *
     * @return the collateral dates
     */
    public List getCollateralDates() {
        return margincallconfig.getCollateralDates();
    }

    /**
     * Gets the collateral policy.
     *
     * @return the collateral policy
     */
    public String getCollateralPolicy() {
        return margincallconfig.getCollateralPolicy();
    }

    /**
     * Gets the comment.
     *
     * @return the comment
     */
    public String getComment() {
        return margincallconfig.getComment();
    }

    /**
     * Gets the compounding B.
     *
     * @return the compounding B
     */
    public boolean getCompoundingB() {
        return margincallconfig.getCompoundingB();
    }

    /**
     * Gets the contract type.
     *
     * @return the contract type
     */
    public String getContractType() {
        return margincallconfig.getContractType();
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return margincallconfig.getCurrency();
    }

    /**
     * Gets the currency list.
     *
     * @return the currency list
     */
    public String getCurrencyList() {
        @SuppressWarnings("unchecked")
        final List<MarginCallConfigCurrencyCore> mcCurrencies = margincallconfig.getCurrencyList();
        return getCurrencies(mcCurrencies);
    }

    /**
     * Gets the date rule.
     *
     * @return the date rule
     */
    public DateRule getDateRule() {
        return margincallconfig.getDateRule();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return margincallconfig.getDescription();
    }

    /**
     * Gets the dispute alt procedure.
     *
     * @return the dispute alt procedure
     */
    public String getDisputeAltProcedure() {
        return margincallconfig.getDisputeAltProcedure();
    }

    /**
     * Gets the dispute method.
     *
     * @return the dispute method
     */
    public String getDisputeMethod() {
        return margincallconfig.getDisputeMethod();
    }

    /**
     * Gets the dispute tolerance amount.
     *
     * @return the dispute tolerance amount
     */
    public double getDisputeToleranceAmount() {
        return margincallconfig.getDisputeToleranceAmount();
    }

    /**
     * Gets the eff date type.
     *
     * @return the eff date type
     */
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

    /**
     * Gets the global deployment identifiers.
     *
     * @return the global deployment identifiers
     */
    public GDIdentifiers getGlobalDeploymentIdentifiers() {
        return margincallconfig.getGlobalDeploymentIdentifiers();
    }

    /**
     * Gets the haircut name.
     *
     * @return the haircut name
     */
    public String getHaircutName() {
        return margincallconfig.getHaircutName();
    }

    /**
     * Gets the haircut type.
     *
     * @return the haircut type
     */
    public String getHaircutType() {
        return margincallconfig.getHaircutType();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return margincallconfig.getId();
    }

    /**
     * Gets the id short name.
     *
     * @return the id short name
     */
    public String getIdShortName() {
        return margincallconfig.getIdShortName();
    }

    /**
     * Gets the implementation.
     *
     * @return the implementation
     */
    public MarginCallConfigInterface getImplementation() {
        return margincallconfig.getImplementation();
    }

    /**
     * Gets the checks if is percentage limit.
     *
     * @return the checks if is percentage limit
     */
    public boolean getIsPercentageLimit() {
        return margincallconfig.getIsPercentageLimit();
    }

    /**
     * Gets the keys.
     *
     * @return the keys
     */
    public Set getKeys() {
        return margincallconfig.getKeys();
    }

    /**
     * Gets the le cash offset.
     *
     * @return the le cash offset
     */
    public int getLeCashOffset() {
        return margincallconfig.getLeCashOffset();
    }

    /**
     * Gets the le coll type.
     *
     * @return the le coll type
     */
    public String getLeCollType() {
        return margincallconfig.getLeCollType();
    }

    /**
     * Gets the legal entity.
     *
     * @return the legal entity
     */
    public LegalEntity getLegalEntity() {
        return margincallconfig.getLegalEntity();
    }

    /**
     * Gets the le IA amount.
     *
     * @return the le IA amount
     */
    public double getLeIAAmount() {
        return margincallconfig.getLeIAAmount();
    }

    /**
     * Gets the le IA applicable to.
     *
     * @return the le IA applicable to
     */
    public String getLeIAApplicableTo() {
        return margincallconfig.getLeIAApplicableTo();
    }

    /**
     * Gets the le IA currency.
     *
     * @return the le IA currency
     */
    public String getLeIACurrency() {
        return margincallconfig.getLeIACurrency();
    }

    /**
     * Gets the le IA percent.
     *
     * @return the le IA percent
     */
    public double getLeIAPercent() {
        return margincallconfig.getLeIAPercent();
    }

    /**
     * Gets the le IA schedule name.
     *
     * @return the le IA schedule name
     */
    public String getLeIAScheduleName() {
        return margincallconfig.getLeIAScheduleName();
    }

    /**
     * Gets the le IA type.
     *
     * @return the le IA type
     */
    public String getLeIAType() {
        return margincallconfig.getLeIAType();
    }

    /**
     * Gets the le MTA amount.
     *
     * @return the le MTA amount
     */
    public double getLeMTAAmount() {
        return margincallconfig.getLeMTAAmount();
    }

    /**
     * Gets the le MTA percentage.
     *
     * @return the le MTA percentage
     */
    public double getLeMTAPercentage() {
        return margincallconfig.getLeMTAPercentage();
    }

    /**
     * Gets the le MTA rating direction.
     *
     * @return the le MTA rating direction
     */
    public String getLeMTARatingDirection() {
        return margincallconfig.getLeMTARatingDirection();
    }

    /**
     * Gets the le MTA type.
     *
     * @return the le MTA type
     */
    public String getLeMTAType() {
        return margincallconfig.getLeMTAType();
    }

    /**
     * Gets the le new threshold amount.
     *
     * @return the le new threshold amount
     */
    public double getLeNewThresholdAmount() {
        return margincallconfig.getLeNewThresholdAmount();
    }

    /**
     * Gets the le new threshold percentage.
     *
     * @return the le new threshold percentage
     */
    public double getLeNewThresholdPercentage() {
        return margincallconfig.getLeNewThresholdPercentage();
    }

    /**
     * Gets the le new threshold type.
     *
     * @return the le new threshold type
     */
    public String getLeNewThresholdType() {
        return margincallconfig.getLeNewThresholdType();
    }

    /**
     * Gets the le return rounding figure.
     *
     * @return the le return rounding figure
     */
    public double getLeReturnRoundingFigure() {
        return margincallconfig.getLeReturnRoundingFigure();
    }

    /**
     * Gets the le return rounding method.
     *
     * @return the le return rounding method
     */
    public String getLeReturnRoundingMethod() {
        return margincallconfig.getLeReturnRoundingMethod();
    }

    /**
     * Gets the le role.
     *
     * @return the le role
     */
    public String getLeRole() {
        return margincallconfig.getLeRole();
    }

    /**
     * Gets the le rounding figure.
     *
     * @return the le rounding figure
     */
    public double getLeRoundingFigure() {
        return margincallconfig.getLeRoundingFigure();
    }

    /**
     * Gets the le rounding method.
     *
     * @return the le rounding method
     */
    public String getLeRoundingMethod() {
        return margincallconfig.getLeRoundingMethod();
    }

    /**
     * Gets the le security offset.
     *
     * @return the le security offset
     */
    public int getLeSecurityOffset() {
        return margincallconfig.getLeSecurityOffset();
    }

    /**
     * Gets the le threshold rating direction.
     *
     * @return the le threshold rating direction
     */
    public String getLeThresholdRatingDirection() {
        return margincallconfig.getLeThresholdRatingDirection();
    }

    /**
     * Gets the limit amount.
     *
     * @return the limit amount
     */
    public double getLimitAmount() {
        return margincallconfig.getLimitAmount();
    }

    /**
     * Gets the master agreement id.
     *
     * @return the master agreement id
     */
    public int getMasterAgreementId() {
        return margincallconfig.getMasterAgreementId();
    }

    /**
     * Gets the max adj threshold amount.
     *
     * @return the max adj threshold amount
     */
    public double getMaxAdjThresholdAmount() {
        return margincallconfig.getMaxAdjThresholdAmount();
    }

    /**
     * Gets the min adj threshold amount.
     *
     * @return the min adj threshold amount
     */
    public double getMinAdjThresholdAmount() {
        return margincallconfig.getMinAdjThresholdAmount();
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return margincallconfig.getName();
    }

    /**
     * Gets the non netted IA contract.
     *
     * @return the non netted IA contract
     */
    public MarginCallConfigInterface getNonNettedIAContract() {
        return margincallconfig.getNonNettedIAContract();
    }

    /**
     * Gets the notification time.
     *
     * @return the notification time
     */
    public JDatetime getNotificationTime() {
        return margincallconfig.getNotificationTime();
    }

    /**
     * Gets the notification time zone.
     *
     * @return the notification time zone
     */
    public TimeZone getNotificationTimeZone() {
        return margincallconfig.getNotificationTimeZone();
    }

    /**
     * Gets the orderer role.
     *
     * @return the orderer role
     */
    public String getOrdererRole() {
        return margincallconfig.getOrdererRole();
    }

    /**
     * Gets the original product list.
     *
     * @return the original product list
     */
    public List getOriginalProductList() {
        return margincallconfig.getOriginalProductList();
    }

    /**
     * Gets the parent id.
     *
     * @return the parent id
     */
    public int getParentId() {
        return margincallconfig.getParentId();
    }

    /**
     * Gets the po cash offset.
     *
     * @return the po cash offset
     */
    public int getPoCashOffset() {
        return margincallconfig.getPoCashOffset();
    }

    /**
     * Gets the po coll type.
     *
     * @return the po coll type
     */
    public String getPoCollType() {
        return margincallconfig.getPoCollType();
    }

    /**
     * Gets the po IA amount.
     *
     * @return the po IA amount
     */
    public double getPoIAAmount() {
        return margincallconfig.getPoIAAmount();
    }

    /**
     * Gets the po IA applicable to.
     *
     * @return the po IA applicable to
     */
    public String getPoIAApplicableTo() {
        return margincallconfig.getPoIAApplicableTo();
    }

    /**
     * Gets the po IA currency.
     *
     * @return the po IA currency
     */
    public String getPoIACurrency() {
        return margincallconfig.getPoIACurrency();
    }

    /**
     * Gets the po IA percent.
     *
     * @return the po IA percent
     */
    public double getPoIAPercent() {
        return margincallconfig.getPoIAPercent();
    }

    /**
     * Gets the po IA schedule name.
     *
     * @return the po IA schedule name
     */
    public String getPoIAScheduleName() {
        return margincallconfig.getPoIAScheduleName();
    }

    /**
     * Gets the po IA type.
     *
     * @return the po IA type
     */
    public String getPoIAType() {
        return margincallconfig.getPoIAType();
    }

    /**
     * Gets the po MTA amount.
     *
     * @return the po MTA amount
     */
    public double getPoMTAAmount() {
        return margincallconfig.getPoMTAAmount();
    }

    /**
     * Gets the po MTA percentage.
     *
     * @return the po MTA percentage
     */
    public double getPoMTAPercentage() {
        return margincallconfig.getPoMTAPercentage();
    }

    /**
     * Gets the po MTA rating direction.
     *
     * @return the po MTA rating direction
     */
    public String getPoMTARatingDirection() {
        return margincallconfig.getPoMTARatingDirection();
    }

    /**
     * Gets the po MTA type.
     *
     * @return the po MTA type
     */
    public String getPoMTAType() {
        return margincallconfig.getPoMTAType();
    }

    /**
     * Gets the po new threshold amount.
     *
     * @return the po new threshold amount
     */
    public double getPoNewThresholdAmount() {
        return margincallconfig.getPoNewThresholdAmount();
    }

    /**
     * Gets the po new threshold percentage.
     *
     * @return the po new threshold percentage
     */
    public double getPoNewThresholdPercentage() {
        return margincallconfig.getPoNewThresholdPercentage();
    }

    /**
     * Gets the po new threshold type.
     *
     * @return the po new threshold type
     */
    public String getPoNewThresholdType() {
        return margincallconfig.getPoNewThresholdType();
    }

    /**
     * Gets the po return rounding figure.
     *
     * @return the po return rounding figure
     */
    public double getPoReturnRoundingFigure() {
        return margincallconfig.getPoReturnRoundingFigure();
    }

    /**
     * Gets the po return rounding method.
     *
     * @return the po return rounding method
     */
    public String getPoReturnRoundingMethod() {
        return margincallconfig.getPoReturnRoundingMethod();
    }

    /**
     * Gets the po rounding figure.
     *
     * @return the po rounding figure
     */
    public double getPoRoundingFigure() {
        return margincallconfig.getPoRoundingFigure();
    }

    /**
     * Gets the po rounding method.
     *
     * @return the po rounding method
     */
    public String getPoRoundingMethod() {
        return margincallconfig.getPoRoundingMethod();
    }

    /**
     * Gets the po security offset.
     *
     * @return the po security offset
     */
    public int getPoSecurityOffset() {
        return margincallconfig.getPoSecurityOffset();
    }

    /**
     * Gets the po threshold rating direction.
     *
     * @return the po threshold rating direction
     */
    public String getPoThresholdRatingDirection() {
        return margincallconfig.getPoThresholdRatingDirection();
    }

    /**
     * Gets the pricing env name.
     *
     * @return the pricing env name
     */
    public String getPricingEnvName() {
        return margincallconfig.getPricingEnvName();
    }

    /**
     * Gets the processing org.
     *
     * @return the processing org
     */
    public ATLegalEntity getProcessingOrg() {
        return new ATLegalEntity(margincallconfig.getProcessingOrg());
    }

    /**
     * Gets the prod static data filter name.
     *
     * @return the prod static data filter name
     */
    public String getProdStaticDataFilterName() {
        return margincallconfig.getProdStaticDataFilterName();
    }

    /**
     * Gets the product list.
     *
     * @return the product list
     */
    public List getProductList() {
        return margincallconfig.getProductList();
    }

    /**
     * Gets the resolution time.
     *
     * @return the resolution time
     */
    public JDatetime getResolutionTime() {
        return margincallconfig.getResolutionTime();
    }

    /**
     * Gets the resolution time zone.
     *
     * @return the resolution time zone
     */
    public TimeZone getResolutionTimeZone() {
        return margincallconfig.getResolutionTimeZone();
    }

    /**
     * Gets the response time.
     *
     * @return the response time
     */
    public JDatetime getResponseTime() {
        return margincallconfig.getResponseTime();
    }

    /**
     * Gets the response time zone.
     *
     * @return the response time zone
     */
    public TimeZone getResponseTimeZone() {
        return margincallconfig.getResponseTimeZone();
    }

    /**
     * Gets the roll interest settle days.
     *
     * @return the roll interest settle days
     */
    public int getRollInterestSettleDays() {
        return margincallconfig.getRollInterestSettleDays();
    }

    /**
     * Gets the settlement cut off.
     *
     * @return the settlement cut off
     */
    public int getSettlementCutOff() {
        return margincallconfig.getSettlementCutOff();
    }

    /**
     * Gets the short name.
     *
     * @return the short name
     */
    public String getShortName() {
        return margincallconfig.getShortName();
    }

    /**
     * Gets the starting date.
     *
     * @return the starting date
     */
    public JDatetime getStartingDate() {
        return margincallconfig.getStartingDate();
    }

    /**
     * Gets the statement date rule.
     *
     * @return the statement date rule
     */
    public DateRule getStatementDateRule() {
        return margincallconfig.getStatementDateRule();
    }

    /**
     * Gets the substitution date option.
     *
     * @return the substitution date option
     */
    public String getSubstitutionDateOption() {
        return margincallconfig.getSubstitutionDateOption();
    }

    /**
     * Gets the substitution time.
     *
     * @return the substitution time
     */
    public JDatetime getSubstitutionTime() {
        return margincallconfig.getSubstitutionTime();
    }

    /**
     * Gets the substitution time zone.
     *
     * @return the substitution time zone
     */
    public TimeZone getSubstitutionTimeZone() {
        return margincallconfig.getSubstitutionTimeZone();
    }

    /**
     * Gets the subtype.
     *
     * @return the subtype
     */
    public String getSubtype() {
        return margincallconfig.getSubtype();
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public String getUser() {
        return margincallconfig.getUser();
    }

    /**
     * Gets the valuation agent id.
     *
     * @return the valuation agent id
     */
    public int getValuationAgentId() {
        return margincallconfig.getValuationAgentId();
    }

    /**
     * Gets the valuation agent type.
     *
     * @return the valuation agent type
     */
    public String getValuationAgentType() {
        return margincallconfig.getValuationAgentType();
    }

    /**
     * Gets the valuation time.
     *
     * @return the valuation time
     */
    public JDatetime getValuationTime() {
        return margincallconfig.getValuationTime();
    }

    /**
     * Gets the valuation time zone.
     *
     * @return the valuation time zone
     */
    public TimeZone getValuationTimeZone() {
        return margincallconfig.getValuationTimeZone();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
        return margincallconfig.getVersion();
    }

    /**
     * Gets the currencies.
     *
     * @param mcCurrencies
     *            the mc currencies
     * @return the currencies
     */
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
