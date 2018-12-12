package calypsox.buggy.xfer;

import java.util.List;

import com.calypso.tk.bo.BOTransfer;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.refdata.ATBook;
import calypsox.buggy.refdata.ATLegalEntity;
import calypsox.buggy.ui.ATAmount;

/**
 * The Class ATTransfer.
 */
public class ATTransfer {

    /** The botransfer. */
    private final BOTransfer botransfer;

    /**
     * Instantiates a new AT transfer.
     *
     * @param boTransfer the bo transfer
     */
    public ATTransfer(final BOTransfer boTransfer) {
	botransfer = boTransfer;
    }

    public ATTransfer(final long transferLongId) throws CalypsoServiceException {
	botransfer = DSConnection.getDefault().getRemoteBackOffice().getBOTransfer(transferLongId);
    }

    /**
     * Gets the action.
     *
     * @return the action
     */
    public String getAction() {
	return botransfer.getAction().toString();
    }

    /**
     * Gets the attribute.
     *
     * @param attribute the attribute
     * @return the attribute
     */
    public String getAttribute(final String attribute) {
	final Object value = botransfer.getAttributesMap().get(attribute);
	if (value == null) {
	    return "null";
	}
	return value.toString();
    }

    /**
     * Gets the attribute removed.
     *
     * @return the attribute removed
     */
    public boolean getAttributeRemoved() {
	return botransfer.getAttributeRemoved();
    }

    /**
     * Gets the available B.
     *
     * @return the available B
     */
    public boolean getAvailableB() {
	return botransfer.getAvailableB();
    }

    /**
     * Gets the available date.
     *
     * @return the available date
     */
    public JDate getAvailableDate() {
	return botransfer.getAvailableDate();
    }

    /**
     * Gets the book.
     *
     * @return the book
     */
    public ATBook getBook() {
	return new ATBook(botransfer.getBookId());
    }

    /**
     * Gets the booking date.
     *
     * @return the booking date
     */
    public JDate getBookingDate() {
	return botransfer.getBookingDate();
    }

    /**
     * Gets the BO transfer.
     *
     * @return the BO transfer
     */
    public BOTransfer getBOTransfer() {
	return botransfer;
    }

    /**
     * Gets the bundle id.
     *
     * @return the bundle id
     */
    public int getBundleId() {
	return botransfer.getBundleId();
    }

    /**
     * Gets the business reason.
     *
     * @return the business reason
     */
    public String getBusinessReason() {
	return botransfer.getBusinessReason();
    }

    /**
     * Gets the callable date.
     *
     * @return the callable date
     */
    public JDate getCallableDate() {
	return botransfer.getCallableDate();
    }

    /**
     * Gets the cash account number.
     *
     * @return the cash account number
     */
    public int getCashAccountNumber() {
	return botransfer.getCashAccountNumber();
    }

    /**
     * Gets the cash transfer.
     *
     * @return the cash transfer
     */
    public BOTransfer getCashTransfer() {
	return botransfer.getCashTransfer();
    }

    /**
     * Gets the delivery method.
     *
     * @return the delivery method
     */
    public String getDeliveryMethod() {
	return botransfer.getDeliveryMethod();
    }

    /**
     * Gets the delivery type.
     *
     * @return the delivery type
     */
    public String getDeliveryType() {
	return botransfer.getDeliveryType();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
	return botransfer.getDescription();
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public JDate getEndDate() {
	return botransfer.getEndDate();
    }

    /**
     * Gets the entered date.
     *
     * @return the entered date
     */
    public JDatetime getEnteredDate() {
	return botransfer.getEnteredDate();
    }

    /**
     * Gets the entered user.
     *
     * @return the entered user
     */
    public String getEnteredUser() {
	return botransfer.getEnteredUser();
    }

    /**
     * Gets the event code.
     *
     * @return the event code
     */
    public int getEventCode() {
	return botransfer.getEventCode();
    }

    /**
     * Gets the event type.
     *
     * @return the event type
     */
    public String getEventType() {
	return botransfer.getEventType();
    }

    /**
     * Gets the external agent.
     *
     * @return the external agent
     */
    public ATLegalEntity getExternalAgent() {
	return new ATLegalEntity(botransfer.getExternalAgentId());
    }

    /**
     * Gets the external cash sd id.
     *
     * @return the external cash sd id
     */
    public int getExternalCashSdId() {
	return botransfer.getExternalCashSdId();
    }

    /**
     * Gets the external legal entity.
     *
     * @return the external legal entity
     */
    public ATLegalEntity getExternalLegalEntity() {
	return new ATLegalEntity(botransfer.getExternalLegalEntityId());
    }

    /**
     * Gets the external role.
     *
     * @return the external role
     */
    public String getExternalRole() {
	return botransfer.getExternalRole();
    }

    /**
     * Gets the external SD status.
     *
     * @return the external SD status
     */
    public String getExternalSDStatus() {
	return botransfer.getExternalSDStatus();
    }

    /**
     * Gets the external settle delivery id.
     *
     * @return the external settle delivery id
     */
    public int getExternalSettleDeliveryId() {
	return botransfer.getExternalSettleDeliveryId();
    }

    /**
     * Gets the ext SDI version.
     *
     * @return the ext SDI version
     */
    public int getExtSDIVersion() {
	return botransfer.getExtSDIVersion();
    }

    /**
     * Gets the full description.
     *
     * @return the full description
     */
    public String getFullDescription() {
	return botransfer.getFullDescription();
    }

    /**
     * Gets the GL account number.
     *
     * @return the GL account number
     */
    public int getGLAccountNumber() {
	return botransfer.getGLAccountNumber();
    }

    /**
     * Gets the inits the settle date.
     *
     * @return the inits the settle date
     */
    public JDate getInitSettleDate() {
	return botransfer.getInitSettleDate();
    }

    /**
     * Gets the internal agent.
     *
     * @return the internal agent
     */
    public ATLegalEntity getInternalAgent() {
	return new ATLegalEntity(botransfer.getInternalAgentId());
    }

    /**
     * Gets the internal cash agent id.
     *
     * @return the internal cash agent id
     */
    public int getInternalCashAgentId() {
	return botransfer.getInternalCashAgentId();
    }

    /**
     * Gets the internal cash sd id.
     *
     * @return the internal cash sd id
     */
    public int getInternalCashSdId() {
	return botransfer.getInternalCashSdId();
    }

    /**
     * Gets the internal legal entity.
     *
     * @return the internal legal entity
     */
    public ATLegalEntity getInternalLegalEntity() {
	return new ATLegalEntity(botransfer.getInternalLegalEntityId());
    }

    /**
     * Gets the internal role.
     *
     * @return the internal role
     */
    public String getInternalRole() {
	return botransfer.getInternalRole();
    }

    /**
     * Gets the internal SD status.
     *
     * @return the internal SD status
     */
    public String getInternalSDStatus() {
	return botransfer.getInternalSDStatus();
    }

    /**
     * Gets the internal settle delivery id.
     *
     * @return the internal settle delivery id
     */
    public int getInternalSettleDeliveryId() {
	return botransfer.getInternalSettleDeliveryId();
    }

    /**
     * Gets the int SDI version.
     *
     * @return the int SDI version
     */
    public int getIntSDIVersion() {
	return botransfer.getIntSDIVersion();
    }

    /**
     * Gets the checks if is fixed B.
     *
     * @return the checks if is fixed B
     */
    public boolean getIsFixedB() {
	return botransfer.getIsFixedB();
    }

    /**
     * Gets the checks if is known B.
     *
     * @return the checks if is known B
     */
    public boolean getIsKnownB() {
	return botransfer.getIsKnownB();
    }

    /**
     * Gets the checks if is return B.
     *
     * @return the checks if is return B
     */
    public boolean getIsReturnB() {
	return botransfer.getIsReturnB();
    }

    /**
     * Gets the kickoff action.
     *
     * @return the kickoff action
     */
    public String getKickoffAction() {
	return botransfer.getKickoffAction().toString();
    }

    /**
     * Gets the linked long id.
     *
     * @return the linked long id
     */
    public long getLinkedLongId() {
	return botransfer.getLinkedLongId();
    }

    /**
     * Gets the manual cash SD id.
     *
     * @return the manual cash SD id
     */
    public int getManualCashSDId() {
	return botransfer.getManualCashSDId();
    }

    /**
     * Gets the manual SD id.
     *
     * @return the manual SD id
     */
    public int getManualSDId() {
	return botransfer.getManualSDId();
    }

    /**
     * Gets the netted trade id.
     *
     * @return the netted trade id
     */
    public int getNettedTradeId() {
	return botransfer.getNettedTradeId();
    }

    /**
     * Gets the netted transfer.
     *
     * @return the netted transfer
     */
    public boolean getNettedTransfer() {
	return botransfer.getNettedTransfer();
    }

    /**
     * Gets the netted transfer long id.
     *
     * @return the netted transfer long id
     */
    public long getNettedTransferLongId() {
	return botransfer.getNettedTransferLongId();
    }

    /**
     * Gets the netted transfers.
     *
     * @return the netted transfers
     */
    public List<ATTransfer> getNettedTransfers() {
	return ATTransfers.toATTransferList(botransfer.getNettedTransfers());
    }

    /**
     * Gets the netting group.
     *
     * @return the netting group
     */
    public int getNettingGroup() {
	return botransfer.getNettingGroup();
    }

    /**
     * Gets the netting type.
     *
     * @return the netting type
     */
    public String getNettingType() {
	return botransfer.getNettingType();
    }

    /**
     * Gets the nominal amount.
     *
     * @return the nominal amount
     */
    public ATAmount getNominalAmount() {
	return new ATAmount(botransfer.getTradeCurrency(), botransfer.getNominalAmount());
    }

    /**
     * Gets the old version.
     *
     * @return the old version
     */
    public int getOldVersion() {
	return botransfer.getOldVersion();
    }

    /**
     * Gets the orderer processing org.
     *
     * @return the orderer processing org
     */
    public ATLegalEntity getOrdererProcessingOrg() {
	return new ATLegalEntity(botransfer.getOrdererProcessingOrg());
    }

    /**
     * Gets the original action.
     *
     * @return the original action
     */
    public String getOriginalAction() {
	return botransfer.getOriginalAction().toString();
    }

    /**
     * Gets the original cpty.
     *
     * @return the original cpty
     */
    public ATLegalEntity getOriginalCpty() {
	return new ATLegalEntity(botransfer.getOriginalCptyId());
    }

    /**
     * Gets the other amount.
     *
     * @return the other amount
     */
    public double getOtherAmount() {
	return botransfer.getOtherAmount();
    }

    /**
     * Gets the pair off from.
     *
     * @return the pair off from
     */
    public String getPairOffFrom() {
	return botransfer.getPairOffFrom();
    }

    /**
     * Gets the pair off to.
     *
     * @return the pair off to
     */
    public String getPairOffTo() {
	return botransfer.getPairOffTo();
    }

    /**
     * Gets the parent long id.
     *
     * @return the parent long id
     */
    public long getParentLongId() {
	return botransfer.getParentLongId();
    }

    /**
     * Gets the payer SD id.
     *
     * @return the payer SD id
     */
    public int getPayerSDId() {
	return botransfer.getPayerSDId();
    }

    /**
     * Gets the payer SD status.
     *
     * @return the payer SD status
     */
    public String getPayerSDStatus() {
	return botransfer.getPayerSDStatus();
    }

    /**
     * Gets the pay receive.
     *
     * @return the pay receive
     */
    public String getPayReceive() {
	return botransfer.getPayReceive();
    }

    /**
     * Gets the pay receive type.
     *
     * @return the pay receive type
     */
    public String getPayReceiveType() {
	return botransfer.getPayReceiveType();
    }

    /**
     * Gets the pay receive type with reverse.
     *
     * @return the pay receive type with reverse
     */
    public String getPayReceiveTypeWithReverse() {
	return botransfer.getPayReceiveTypeWithReverse();
    }

    /**
     * Gets the position aggregation id.
     *
     * @return the position aggregation id
     */
    public int getPositionAggregationId() {
	return botransfer.getPositionAggregationId();
    }

    /**
     * Gets the processing org.
     *
     * @return the processing org
     */
    public ATLegalEntity getProcessingOrg() {
	return new ATLegalEntity(botransfer.getProcessingOrg());
    }

    /**
     * Gets the product family.
     *
     * @return the product family
     */
    public String getProductFamily() {
	return botransfer.getProductFamily();
    }

    /**
     * Gets the product id.
     *
     * @return the product id
     */
    public int getProductId() {
	return botransfer.getProductId();
    }

    /**
     * Gets the product type.
     *
     * @return the product type
     */
    public String getProductType() {
	return botransfer.getProductType();
    }

    /**
     * Gets the projected amount.
     *
     * @return the projected amount
     */
    public double getProjectedAmount() {
	return botransfer.getProjectedAmount();
    }

    /**
     * Gets the real cash amount.
     *
     * @return the real cash amount
     */
    public double getRealCashAmount() {
	return botransfer.getRealCashAmount();
    }

    /**
     * Gets the real settlement amount.
     *
     * @return the real settlement amount
     */
    public ATAmount getRealSettlementAmount() {
	return new ATAmount(botransfer.getSettlementCurrency(), botransfer.getRealSettlementAmount());
    }

    /**
     * Gets the receiver SD id.
     *
     * @return the receiver SD id
     */
    public int getReceiverSDId() {
	return botransfer.getReceiverSDId();
    }

    /**
     * Gets the receiver SD status.
     *
     * @return the receiver SD status
     */
    public String getReceiverSDStatus() {
	return botransfer.getReceiverSDStatus();
    }

    /**
     * Gets the SDI value date.
     *
     * @return the SDI value date
     */
    public JDate getSDIValueDate() {
	return botransfer.getSDIValueDate();
    }

    /**
     * Gets the settle date.
     *
     * @return the settle date
     */
    public JDate getSettleDate() {
	return botransfer.getSettleDate();
    }

    /**
     * Gets the settlement amount.
     *
     * @return the settlement amount
     */
    public ATAmount getSettlementAmount() {
	return new ATAmount(botransfer.getSettlementCurrency(), botransfer.getSettlementAmount());
    }

    /**
     * Gets the settlement currency.
     *
     * @return the settlement currency
     */
    public String getSettlementCurrency() {
	return botransfer.getSettlementCurrency();
    }

    /**
     * Gets the settlement method.
     *
     * @return the settlement method
     */
    public String getSettlementMethod() {
	return botransfer.getSettlementMethod();
    }

    /**
     * Gets the s id.
     *
     * @return the s id
     */
    public long getId() {
	return botransfer.getLongId();
    }

    /**
     * Gets the sign.
     *
     * @return the sign
     */
    public double getSign() {
	return botransfer.getSign();
    }

    /**
     * Gets the split key.
     *
     * @return the split key
     */
    public String getSplitKey() {
	return botransfer.getSplitKey();
    }

    /**
     * Gets the split reason from.
     *
     * @return the split reason from
     */
    public String getSplitReasonFrom() {
	return botransfer.getSplitReasonFrom();
    }

    /**
     * Gets the split reason to.
     *
     * @return the split reason to
     */
    public String getSplitReasonTo() {
	return botransfer.getSplitReasonTo();
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
	return botransfer.getStatus().toString();
    }

    /**
     * Gets the trade currency.
     *
     * @return the trade currency
     */
    public String getTradeCurrency() {
	return botransfer.getTradeCurrency();
    }

    /**
     * Gets the trade date.
     *
     * @return the trade date
     */
    public JDate getTradeDate() {
	return botransfer.getTradeDate();
    }

    /**
     * Gets the trade id.
     *
     * @return the trade id
     */
    public int getTradeId() {
	return botransfer.getTradeId();
    }

    /**
     * Gets the trade transfers.
     *
     * @return the trade transfers
     */
    public List<ATTransfer> getTradeTransfers() {
	return ATTransfers.toATTransferList(botransfer.getTradeTransfers());
    }

    /**
     * Gets the trade version.
     *
     * @return the trade version
     */
    public int getTradeVersion() {
	return botransfer.getTradeVersion();
    }

    /**
     * Gets the transfer type.
     *
     * @return the transfer type
     */
    public String getTransferType() {
	return botransfer.getTransferType();
    }

    /**
     * Gets the unavailability quantity.
     *
     * @return the unavailability quantity
     */
    public double getUnavailabilityQuantity() {
	return botransfer.getUnavailabilityQuantity();
    }

    /**
     * Gets the underlying transfer.
     *
     * @return the underlying transfer
     */
    public ATTransfer getUnderlyingTransfer() {
	return new ATTransfer(botransfer.getUnderlyingTransfer());
    }

    /**
     * Gets the underlying transfers.
     *
     * @return the underlying transfers
     */
    public List<ATTransfer> getUnderlyingTransfers() {
	return ATTransfers.toATTransferList(botransfer.getUnderlyingTransfers());
    }

    /**
     * Gets the value date.
     *
     * @return the value date
     */
    public JDate getValueDate() {
	return botransfer.getValueDate();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
	return botransfer.getVersion();
    }

    @Override
    public String toString() {
	if (botransfer == null) {
	    return "";
	}
	return botransfer.toString();
    }
}
