package calypsox.buggy.xfer;

import java.util.List;
import java.util.Vector;

import com.calypso.tk.bo.TradeTransferRule;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.CashFlowSet;
import com.calypso.tk.core.JDate;

import calypsox.buggy.product.ATTrade;
import calypsox.buggy.refdata.ATAccount;
import calypsox.buggy.refdata.ATBook;
import calypsox.buggy.refdata.ATLegalEntity;
import calypsox.buggy.refdata.ATNettingMethod;
import calypsox.buggy.ui.ATAmount;

/**
 * The Class ATTradeTransferRule.
 */
public class ATTradeTransferRule {

    /** The tradetransferrule. */
    private final TradeTransferRule tradetransferrule;

    /**
     * Instantiates a new AT trade transfer rule.
     */
    public ATTradeTransferRule() {
        tradetransferrule = new TradeTransferRule();
    }

    /**
     * Instantiates a new AT trade transfer rule.
     *
     * @param transferRule
     *            the transfer rule
     */
    public ATTradeTransferRule(final TradeTransferRule transferRule) {
        tradetransferrule = transferRule;
    }

    /**
     * Gets the account id.
     *
     * @return the account id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATAccount getAccountId() throws CalypsoServiceException {
        return new ATAccount(tradetransferrule.getAccountId());
    }

    /**
     * Gets the book.
     *
     * @return the book
     */
    public ATBook getBook() {
        return new ATBook(tradetransferrule.getBookId());
    }

    /**
     * Gets the cash flows.
     *
     * @return the cash flows
     */
    public CashFlowSet getCashFlows() {
        return tradetransferrule.getCashFlows();
    }

    /**
     * Gets the counter party.
     *
     * @return the counter party
     */
    public ATLegalEntity getCounterParty() {
        return new ATLegalEntity(tradetransferrule.getCounterParty());
    }

    /**
     * Gets the counter party role.
     *
     * @return the counter party role
     */
    public String getCounterPartyRole() {
        return tradetransferrule.getCounterPartyRole();
    }

    /**
     * Gets the counter party SD id.
     *
     * @return the counter party SD id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATSdi getCounterPartySDId() throws CalypsoServiceException {
        return new ATSdi(tradetransferrule.getCounterPartySDId());
    }

    /**
     * Gets the counter party SD status.
     *
     * @return the counter party SD status
     */
    public String getCounterPartySDStatus() {
        return tradetransferrule.getCounterPartySDStatus();
    }

    /**
     * Gets the delivery type.
     *
     * @return the delivery type
     */
    public String getDeliveryType() {
        return tradetransferrule.getDeliveryType();
    }

    /**
     * Gets the do matching between transfer rule and flow.
     *
     * @return the do matching between transfer rule and flow
     */
    public boolean getDoMatchingBetweenTransferRuleAndFlow() {
        return tradetransferrule.getDoMatchingBetweenTransferRuleAndFlow();
    }

    /**
     * Gets the ext SDI version.
     *
     * @return the ext SDI version
     */
    public int getExtSDIVersion() {
        return tradetransferrule.getExtSDIVersion();
    }

    /**
     * Gets the full route.
     *
     * @return the full route
     */
    public List getFullRoute() {
        return tradetransferrule.getFullRoute();
    }

    /**
     * Gets the int SDI version.
     *
     * @return the int SDI version
     */
    public int getIntSDIVersion() {
        return tradetransferrule.getIntSDIVersion();
    }

    /**
     * Gets the manual SD id.
     *
     * @return the manual SD id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATSdi getManualSDId() throws CalypsoServiceException {
        return new ATSdi(tradetransferrule.getManualSDId());
    }

    /**
     * Gets the max date.
     *
     * @return the max date
     */
    public JDate getMaxDate() {
        return tradetransferrule.getMaxDate();
    }

    /**
     * Gets the max date flow.
     *
     * @return the max date flow
     */
    public JDate getMaxDateFlow() {
        return tradetransferrule.getMaxDateFlow();
    }

    /**
     * Gets the max date netting.
     *
     * @return the max date netting
     */
    public JDate getMaxDateNetting() {
        return tradetransferrule.getMaxDateNetting();
    }

    /**
     * Gets the max date SDI.
     *
     * @return the max date SDI
     */
    public JDate getMaxDateSDI() {
        return tradetransferrule.getMaxDateSDI();
    }

    /**
     * Gets the min date.
     *
     * @return the min date
     */
    public JDate getMinDate() {
        return tradetransferrule.getMinDate();
    }

    /**
     * Gets the min date flow.
     *
     * @return the min date flow
     */
    public JDate getMinDateFlow() {
        return tradetransferrule.getMinDateFlow();
    }

    /**
     * Gets the min date netting.
     *
     * @return the min date netting
     */
    public JDate getMinDateNetting() {
        return tradetransferrule.getMinDateNetting();
    }

    /**
     * Gets the min date SDI.
     *
     * @return the min date SDI
     */
    public JDate getMinDateSDI() {
        return tradetransferrule.getMinDateSDI();
    }

    /**
     * Gets the netting method id.
     *
     * @return the netting method id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATNettingMethod getNettingMethodId() throws CalypsoServiceException {
        return new ATNettingMethod(tradetransferrule.getNettingMethodId());
    }

    /**
     * Gets the netting type.
     *
     * @return the netting type
     */
    public String getNettingType() {
        return tradetransferrule.getNettingType();
    }

    /**
     * Gets the opposite rule.
     *
     * @return the opposite rule
     */
    public TradeTransferRule getOppositeRule() {
        return tradetransferrule.getOppositeRule();
    }

    /**
     * Gets the original counter party.
     *
     * @return the original counter party
     */
    public ATLegalEntity getOriginalCounterParty() {
        return new ATLegalEntity(tradetransferrule.getOriginalCounterParty());
    }

    /**
     * Gets the origin payer legal entity.
     *
     * @return the origin payer legal entity
     */
    public ATLegalEntity getOriginPayerLegalEntity() {
        return new ATLegalEntity(tradetransferrule.getOriginPayerLegalEntityId());
    }

    /**
     * Gets the origin receiver legal entity.
     *
     * @return the origin receiver legal entity
     */
    public ATLegalEntity getOriginReceiverLegalEntity() {
        return new ATLegalEntity(tradetransferrule.getOriginReceiverLegalEntityId());
    }

    /**
     * Gets the other rules.
     *
     * @return the other rules
     */
    public List getOtherRules() {
        return tradetransferrule.getOtherRules();
    }

    /**
     * Gets the payer legal entity.
     *
     * @return the payer legal entity
     */
    public ATLegalEntity getPayerLegalEntity() {
        return new ATLegalEntity(tradetransferrule.getPayerLegalEntityId());
    }

    /**
     * Gets the payer legal entity role.
     *
     * @return the payer legal entity role
     */
    public String getPayerLegalEntityRole() {
        return tradetransferrule.getPayerLegalEntityRole();
    }

    /**
     * Gets the payer SD id.
     *
     * @return the payer SD id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATSdi getPayerSDId() throws CalypsoServiceException {
        return new ATSdi(tradetransferrule.getPayerSDId());
    }

    /**
     * Gets the payer SD status.
     *
     * @return the payer SD status
     */
    public String getPayerSDStatus() {
        return tradetransferrule.getPayerSDStatus();
    }

    /**
     * Gets the pay receive.
     *
     * @return the pay receive
     */
    public String getPayReceive() {
        return tradetransferrule.getPayReceive();
    }

    /**
     * Gets the percentage.
     *
     * @return the percentage
     */
    public double getPercentage() {
        return tradetransferrule.getPercentage();
    }

    /**
     * Gets the processing org.
     *
     * @return the processing org
     */
    public ATLegalEntity getProcessingOrg() {
        return new ATLegalEntity(tradetransferrule.getProcessingOrg());
    }

    /**
     * Gets the processing org SD id.
     *
     * @return the processing org SD id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATSdi getProcessingOrgSDId() throws CalypsoServiceException {
        return new ATSdi(tradetransferrule.getProcessingOrgSDId());
    }

    /**
     * Gets the processing org SD status.
     *
     * @return the processing org SD status
     */
    public String getProcessingOrgSDStatus() {
        return tradetransferrule.getProcessingOrgSDStatus();
    }

    /**
     * Gets the product id.
     *
     * @return the product id
     */
    public int getProductId() {
        return tradetransferrule.getProductId();
    }

    /**
     * Gets the product type.
     *
     * @return the product type
     */
    public String getProductType() {
        return tradetransferrule.getProductType();
    }

    /**
     * Gets the receiver legal entity.
     *
     * @return the receiver legal entity
     */
    public ATLegalEntity getReceiverLegalEntity() {
        return new ATLegalEntity(tradetransferrule.getReceiverLegalEntityId());
    }

    /**
     * Gets the receiver legal entity role.
     *
     * @return the receiver legal entity role
     */
    public String getReceiverLegalEntityRole() {
        return tradetransferrule.getReceiverLegalEntityRole();
    }

    /**
     * Gets the receiver SD id.
     *
     * @return the receiver SD id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATSdi getReceiverSDId() throws CalypsoServiceException {
        return new ATSdi(tradetransferrule.getReceiverSDId());
    }

    /**
     * Gets the receiver SD status.
     *
     * @return the receiver SD status
     */
    public String getReceiverSDStatus() {
        return tradetransferrule.getReceiverSDStatus();
    }

    public TradeTransferRule getRelevantTransferRule(final Vector<TradeTransferRule> transferRulesOnTrade) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Gets the SDI security id.
     *
     * @return the SDI security id
     */
    public int getSDISecurityId() {
        return tradetransferrule.getSDISecurityId();
    }

    /**
     * Gets the security id.
     *
     * @return the security id
     */
    public int getSecurityId() {
        return tradetransferrule.getSecurityId();
    }

    /**
     * Gets the seq number.
     *
     * @return the seq number
     */
    public int getSeqNumber() {
        return tradetransferrule.getSeqNumber();
    }

    /**
     * Gets the settle date.
     *
     * @return the settle date
     */
    public JDate getSettleDate() {
        return tradetransferrule.getSettleDate();
    }

    /**
     * Gets the settlement currency.
     *
     * @return the settlement currency
     */
    public String getSettlementCurrency() {
        return tradetransferrule.getSettlementCurrency();
    }

    /**
     * Gets the settlement method.
     *
     * @return the settlement method
     */
    public String getSettlementMethod() {
        return tradetransferrule.getSettlementMethod();
    }

    /**
     * Gets the trade.
     *
     * @return the trade
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTrade getTrade() throws CalypsoServiceException {
        return new ATTrade(tradetransferrule.getTradeId());
    }

    /**
     * Gets the trade cpty.
     *
     * @return the trade cpty
     */
    public ATLegalEntity getTradeCpty() {
        return new ATLegalEntity(tradetransferrule.getTradeCptyId());
    }

    /**
     * Gets the transfer amount.
     *
     * @return the transfer amount
     */
    public ATAmount getTransferAmount() {
        return new ATAmount(tradetransferrule.getTransferCurrency(), tradetransferrule.getTransferAmount());
    }

    /**
     * Gets the transfer currency.
     *
     * @return the transfer currency
     */
    public String getTransferCurrency() {
        return tradetransferrule.getTransferCurrency();
    }

    /**
     * Gets the transfer type.
     *
     * @return the transfer type
     */
    public String getTransferType() {
        return tradetransferrule.getTransferType();
    }

    public ATTradeTransferRule withPayRec(final String payRec) {
        tradetransferrule.setPayReceive(payRec);
        return this;
    }

    public ATTradeTransferRule withTransferType(final String transferType) {
        tradetransferrule.setTransferType(transferType);
        return this;
    }

}
