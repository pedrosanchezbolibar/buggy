package calypsox.buggy.xfer;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.GDIdentifiers;
import com.calypso.tk.core.JDate;
import com.calypso.tk.refdata.PartySDI;
import com.calypso.tk.refdata.SettleDeliveryInstruction;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.refdata.ATLegalEntity;

/**
 * Retrieve information and apply actions to Calypso SDI.
 */
public class ATSdi {

    /** The sdi. */
    final SettleDeliveryInstruction sdi;

    /**
     * Instantiates a new AT sdi.
     *
     * @param settleDeliveryId
     *            the settle delivery id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATSdi(final int settleDeliveryId) throws CalypsoServiceException {
        sdi = DSConnection.getDefault().getRemoteReferenceData().getSettleDeliveryInstruction(settleDeliveryId);
    }

    /**
     * Instantiates a new AT sdi.
     *
     * @param reference
     *            the reference
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATSdi(final String reference) throws CalypsoServiceException {
        sdi = DSConnection.getDefault().getRemoteReferenceData().getSettleDeliveryInstruction(reference);
    }

    /**
     * Gets the addressee id.
     *
     * @return the addressee id
     */
    public ATLegalEntity getAddressee() {
        return new ATLegalEntity(sdi.getAddresseeId());
    }

    /**
     * Gets the agent.
     *
     * @return the agent
     */
    public PartySDI getAgent() {
        return sdi.getAgent();
    }

    /**
     * Gets the agent account.
     *
     * @return the agent account
     */
    public String getAgentAccount() {
        return sdi.getAgentAccount();
    }

    /**
     * Gets the agent contact type.
     *
     * @return the agent contact type
     */
    public String getAgentContactType() {
        return sdi.getAgentContactType();
    }

    /**
     * Gets the agent identifier.
     *
     * @return the agent identifier
     */
    public String getAgentIdentifier() {
        return sdi.getAgentIdentifier();
    }

    /**
     * Gets the agent id.
     *
     * @return the agent id
     */
    public ATLegalEntity getAgentLE() {
        return new ATLegalEntity(sdi.getAgentId());
    }

    /**
     * Gets the agent name.
     *
     * @return the agent name
     */
    public String getAgentName() {
        return sdi.getAgentName();
    }

    /**
     * Gets the agent sub account.
     *
     * @return the agent sub account
     */
    public String getAgentSubAccount() {
        return sdi.getAgentSubAccount();
    }

    /**
     * Gets the attributes.
     *
     * @return the attributes
     */
    public List getAttributes() {
        return sdi.getAttributes();
    }

    /**
     * Gets the auth name.
     *
     * @return the auth name
     */
    public String getAuthName() {
        return sdi.getAuthName();
    }

    /**
     * Gets the beneficiary.
     *
     * @return the beneficiary
     */
    public PartySDI getBeneficiary() {
        return sdi.getBeneficiary();
    }

    /**
     * Gets the beneficiary contact type.
     *
     * @return the beneficiary contact type
     */
    public String getBeneficiaryContactType() {
        return sdi.getBeneficiaryContactType();
    }

    /**
     * Gets the beneficiary identifier.
     *
     * @return the beneficiary identifier
     */
    public String getBeneficiaryIdentifier() {
        return sdi.getBeneficiaryIdentifier();
    }

    /**
     * Gets the beneficiary id.
     *
     * @return the beneficiary id
     */
    public ATLegalEntity getBeneficiaryLE() {
        return new ATLegalEntity(sdi.getBeneficiaryId());
    }

    /**
     * Gets the beneficiary name.
     *
     * @return the beneficiary name
     */
    public String getBeneficiaryName() {
        return sdi.getBeneficiaryName();
    }

    /**
     * Gets the client SDI validation.
     *
     * @return the client SDI validation
     */
    public boolean getClientSDIValidation() {
        return sdi.getClientSDIValidation();
    }

    /**
     * Gets the comments.
     *
     * @return the comments
     */
    public String getComments() {
        return sdi.getComments();
    }

    /**
     * Gets the currencies.
     *
     * @return the currencies
     */
    public String getCurrencies() {
        final List<String> ccyList = getCurrencyList();
        Collections.sort(ccyList);
        return StringUtils.join(ccyList, ", ");
    }

    /**
     * Gets the currency list.
     *
     * @return the currency list
     */
    @SuppressWarnings("unchecked")
    public List<String> getCurrencyList() {
        return sdi.getCurrencyList();
    }

    /**
     * Gets the default description.
     *
     * @return the default description
     */
    public String getDefaultDescription() {
        return sdi.getDefaultDescription();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return sdi.getDescription();
    }

    /**
     * Gets the direct relationship.
     *
     * @return the direct relationship
     */
    public boolean getDirectRelationship() {
        return sdi.getDirectRelationship();
    }

    /**
     * Gets the effective date from.
     *
     * @return the effective date from
     */
    public JDate getEffectiveDateFrom() {
        return sdi.getEffectiveDateFrom();
    }

    /**
     * Gets the effective date to.
     *
     * @return the effective date to
     */
    public JDate getEffectiveDateTo() {
        return sdi.getEffectiveDateTo();
    }

    /**
     * Gets the effective from.
     *
     * @return the effective from
     */
    public JDate getEffectiveFrom() {
        return sdi.getEffectiveFrom();
    }

    /**
     * Gets the effective to.
     *
     * @return the effective to
     */
    public JDate getEffectiveTo() {
        return sdi.getEffectiveTo();
    }

    /**
     * Gets the filter set.
     *
     * @return the filter set
     */
    public String getFilterSet() {
        return sdi.getFilterSet();
    }

    /**
     * Gets the general ledger account.
     *
     * @return the general ledger account
     */
    public int getGeneralLedgerAccount() {
        return sdi.getGeneralLedgerAccount();
    }

    /**
     * Gets the global deployment identifiers.
     *
     * @return the global deployment identifiers
     */
    public GDIdentifiers getGlobalDeploymentIdentifiers() {
        return sdi.getGlobalDeploymentIdentifiers();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return sdi.getId();
    }

    /**
     * Gets the intermediary.
     *
     * @return the intermediary
     */
    public PartySDI getIntermediary() {
        return sdi.getIntermediary();
    }

    /**
     * Gets the intermediary 2.
     *
     * @return the intermediary 2
     */
    public PartySDI getIntermediary2() {
        return sdi.getIntermediary2();
    }

    /**
     * Gets the intermediary 2 account.
     *
     * @return the intermediary 2 account
     */
    public String getIntermediary2Account() {
        return sdi.getIntermediary2Account();
    }

    /**
     * Gets the intermediary 2 contact type.
     *
     * @return the intermediary 2 contact type
     */
    public String getIntermediary2ContactType() {
        return sdi.getIntermediary2ContactType();
    }

    /**
     * Gets the intermediary 2 identifier.
     *
     * @return the intermediary 2 identifier
     */
    public String getIntermediary2Identifier() {
        return sdi.getIntermediary2Identifier();
    }

    /**
     * Gets the intermediary 2 id.
     *
     * @return the intermediary 2 id
     */
    public ATLegalEntity getIntermediary2LE() {
        return new ATLegalEntity(sdi.getIntermediary2Id());
    }

    /**
     * Gets the intermediary 2 sub account.
     *
     * @return the intermediary 2 sub account
     */
    public String getIntermediary2SubAccount() {
        return sdi.getIntermediary2SubAccount();
    }

    /**
     * Gets the intermediary account.
     *
     * @return the intermediary account
     */
    public String getIntermediaryAccount() {
        return sdi.getIntermediaryAccount();
    }

    /**
     * Gets the intermediary contact type.
     *
     * @return the intermediary contact type
     */
    public String getIntermediaryContactType() {
        return sdi.getIntermediaryContactType();
    }

    /**
     * Gets the intermediary general ledger account.
     *
     * @return the intermediary general ledger account
     */
    public int getIntermediaryGeneralLedgerAccount() {
        return sdi.getIntermediaryGeneralLedgerAccount();
    }

    /**
     * Gets the intermediary identifier.
     *
     * @return the intermediary identifier
     */
    public String getIntermediaryIdentifier() {
        return sdi.getIntermediaryIdentifier();
    }

    /**
     * Gets the intermediary id.
     *
     * @return the intermediary id
     */
    public ATLegalEntity getIntermediaryLE() {
        return new ATLegalEntity(sdi.getIntermediaryId());
    }

    /**
     * Gets the intermediary name.
     *
     * @return the intermediary name
     */
    public String getIntermediaryName() {
        return sdi.getIntermediaryName();
    }

    /**
     * Gets the intermediary sub account.
     *
     * @return the intermediary sub account
     */
    public String getIntermediarySubAccount() {
        return sdi.getIntermediarySubAccount();
    }

    /**
     * Gets the checks if is by trade date.
     *
     * @return the checks if is by trade date
     */
    public boolean getIsByTradeDate() {
        return sdi.getIsByTradeDate();
    }

    /**
     * Gets the LE audit tag.
     *
     * @return the LE audit tag
     */
    public String getLEAuditTag() {
        return sdi.getLEAuditTag();
    }

    /**
     * Gets the legal entity.
     *
     * @return the legal entity
     */
    public ATLegalEntity getLegalEntity() {
        return new ATLegalEntity(sdi.getLegalEntityId());
    }

    /**
     * Gets the link id.
     *
     * @return the link id
     */
    public int getLinkId() {
        return sdi.getLinkId();
    }

    /**
     * Gets the message to agent.
     *
     * @return the message to agent
     */
    public boolean getMessageToAgent() {
        return sdi.getMessageToAgent();
    }

    /**
     * Gets the message to intermediary.
     *
     * @return the message to intermediary
     */
    public boolean getMessageToIntermediary() {
        return sdi.getMessageToIntermediary();
    }

    /**
     * Gets the message to intermediary 2.
     *
     * @return the message to intermediary 2
     */
    public boolean getMessageToIntermediary2() {
        return sdi.getMessageToIntermediary2();
    }

    /**
     * Gets the original product list.
     *
     * @return the original product list
     */
    @SuppressWarnings("unchecked")
    public List<String> getOriginalProductList() {
        return sdi.getOriginalProductList();
    }

    /**
     * Gets the pay receive.
     *
     * @return the pay receive
     */
    public String getPayReceive() {
        return sdi.payRecToString();
    }

    /**
     * Gets the preferred B.
     *
     * @return the preferred B
     */
    public boolean getPreferredB() {
        return sdi.getPreferredB();
    }

    /**
     * Gets the priority.
     *
     * @return the priority
     */
    public int getPriority() {
        return sdi.getPriority();
    }

    /**
     * Gets the processing org.
     *
     * @return the processing org
     */
    public ATLegalEntity getProcessingOrg() {
        return new ATLegalEntity(sdi.getProcessingOrg());
    }

    /**
     * Gets the processing org based id.
     *
     * @return the processing org based id
     */
    public ATLegalEntity getProcessingOrgBased() {
        return new ATLegalEntity(sdi.getProcessingOrgBasedId());
    }

    /**
     * Gets the processing org instruction B.
     *
     * @return the processing org instruction B
     */
    public boolean getProcessingOrgInstructionB() {
        return sdi.getProcessingOrgInstructionB();
    }

    /**
     * Gets the processing org party.
     *
     * @return the processing org party
     */
    public PartySDI getProcessingOrgParty() {
        return sdi.getProcessingOrgParty();
    }

    /**
     * Gets the product list.
     *
     * @return the product list
     */
    @SuppressWarnings("unchecked")
    public List<String> getProductList() {
        return sdi.getProductList();
    }

    /**
     * Gets the products.
     *
     * @return the products
     */
    public String getProducts() {
        final List<String> prodList = getProductList();
        if (prodList.isEmpty()) {
            return "ANY";
        }
        Collections.sort(prodList);
        return StringUtils.join(prodList, ", ");
    }

    /**
     * Gets the reference.
     *
     * @return the reference
     */
    public String getReference() {
        return sdi.getReference();
    }

    /**
     * Gets the registration list.
     *
     * @return the registration list
     */
    public List getRegistrationList() {
        return sdi.getRegistrationList();
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    public String getRole() {
        return sdi.getRole();
    }

    /**
     * Gets the sensible changes.
     *
     * @return the sensible changes
     */
    public List getSensibleChanges() {
        return SettleDeliveryInstruction.getSensibleChanges();
    }

    /**
     * Gets the settlement method.
     *
     * @return the settlement method
     */
    public String getSettlementMethod() {
        return sdi.getSettlementMethod();
    }

    /**
     * Gets the static filter set.
     *
     * @return the static filter set
     */
    public String getStaticFilterSet() {
        return sdi.getStaticFilterSet();
    }

    /**
     * Gets the tool typ.
     *
     * @return the tool typ
     */
    public String getToolTyp() {
        return sdi.getToolTyp();
    }

    /**
     * Gets the trade counter party id.
     *
     * @return the trade counter party id
     */
    public ATLegalEntity getTradeCounterParty() {
        return new ATLegalEntity(sdi.getTradeCounterPartyId());
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return sdi.typeToString();
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public String getUser() {
        return sdi.getUser();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
        return sdi.getVersion();
    }

    /**
     * Removes the calypso SDI
     * 
     * @return
     *
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public boolean remove() throws CalypsoServiceException {
        return DSConnection.getDefault().getRemoteReferenceData().remove(sdi);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return sdi.toString();
    }
}
