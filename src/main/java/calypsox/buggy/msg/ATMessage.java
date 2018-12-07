package calypsox.buggy.msg;

import com.calypso.tk.bo.BOMessage;
import com.calypso.tk.core.Action;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.Status;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.product.ATTrade;
import calypsox.buggy.refdata.ATBook;
import calypsox.buggy.refdata.ATLEContact;
import calypsox.buggy.refdata.ATLegalEntity;
import calypsox.buggy.xfer.ATTransfer;

/**
 * The Class ATTrade.
 */
public class ATMessage {

    /** The trade. */
    protected BOMessage bomessage;

    /**
     * Instantiates a new AT trade.
     *
     * @param trade the trade
     */
    public ATMessage(final BOMessage msg) {
	if (msg == null) {
	    throw new IllegalArgumentException("Message is null");
	}
	bomessage = msg;
    }

    public ATMessage(final long id) throws CalypsoServiceException {
	final BOMessage msg = DSConnection.getDefault().getRemoteBackOffice().getMessage(id);
	bomessage = msg;
    }

    public String getLanguage() {
	return bomessage.getLanguage();
    }

    public String getAttribute(final String name) {
	return bomessage.getAttribute(name);
    }

    public ATBook getBook() {
	return new ATBook(bomessage.getBookId());
    }

    public ATTrade getTrade() throws CalypsoServiceException {
	return new ATTrade(bomessage.getTradeId());
    }

    public ATLegalEntity getLegalEntity() {
	return new ATLegalEntity(bomessage.getLegalEntityId());
    }

    public JDatetime getUpdateDatetime() {
	return bomessage.getUpdateDatetime();
    }

    public long getId() {
	return bomessage.getLongId();
    }

    public JDatetime getTradeUpdateDatetime() {
	return bomessage.getTradeUpdateDatetime();
    }

    public String getEventType() {
	return bomessage.getEventType();
    }

    public String getProductFamily() {
	return bomessage.getProductFamily();
    }

    public String getProductType() {
	return bomessage.getProductType();
    }

    public String getMessageType() {
	return bomessage.getMessageType();
    }

    public ATLegalEntity getSender() {
	return new ATLegalEntity(bomessage.getSenderId());
    }

    public String getSenderRole() {
	return bomessage.getSenderRole();
    }

    public String getSenderContactType() {
	return bomessage.getSenderContactType();
    }

    public String getSenderAddressCode() {
	return bomessage.getSenderAddressCode();
    }

    public ATLegalEntity getReceiver() {
	return new ATLegalEntity(bomessage.getReceiverId());
    }

    public String getReceiverRole() {
	return bomessage.getReceiverRole();
    }

    public String getReceiverContactType() {
	return bomessage.getReceiverContactType();
    }

    public String getReceiverAddressCode() {
	return bomessage.getReceiverAddressCode();
    }

    public String getAddressMethod() {
	return bomessage.getAddressMethod();
    }

    public String getGateway() {
	return bomessage.getGateway();
    }

    public JDatetime getCreationDate() {
	return bomessage.getCreationDate();
    }

    public JDate getSettleDate() {
	return bomessage.getSettleDate();
    }

    public Action getSubAction() {
	return bomessage.getSubAction();
    }

    public ATLEContact getReceiverContact() {
	return new ATLEContact(bomessage.getReceiverContactId());
    }

    public ATLEContact getSenderContactId() {
	return new ATLEContact(bomessage.getSenderContactId());
    }

    public Status getStatus() {
	return bomessage.getStatus();
    }

    public boolean getMatchingB() {
	return bomessage.getMatchingB();
    }

    public String getTemplateName() {
	return bomessage.getTemplateName();
    }

    public Action getAction() {
	return bomessage.getAction();
    }

    public ATMessage getLinkedId() throws CalypsoServiceException {
	return new ATMessage(bomessage.getLinkedLongId());
    }

    public ATTransfer getTransfer() throws CalypsoServiceException {
	return new ATTransfer(bomessage.getTransferLongId());
    }

    public String getFormatType() {
	return bomessage.getFormatType();
    }

    public Action getKickoffAction() {
	return bomessage.getKickoffAction();
    }

    public boolean getDocumentEditedB() {
	return bomessage.getDocumentEditedB();
    }

    public int getMessageClass() {
	return bomessage.getMessageClass();
    }

    public int getAdviceConfigId() {
	return bomessage.getAdviceConfigId();
    }

    public int getStatementId() {
	return bomessage.getStatementId();
    }

    public String getDescription() {
	return bomessage.getDescription();
    }

    public int getTradeVersion() {
	return bomessage.getTradeVersion();
    }

    public int getXferVersion() {
	return bomessage.getXferVersion();
    }

    public boolean getExternalB() {
	return bomessage.getExternalB();
    }

    public long getGroupId() {
	return bomessage.getGroupLongId();
    }

    public Object getReferrentKey() {
	return bomessage.getReferrentKey();
    }

    public int getVersion() {
	return bomessage.getVersion();
    }

    public String getEnteredUser() {
	return bomessage.getEnteredUser();
    }

    public int getTotalGroupMessages() {
	return bomessage.getTotalGroupMessages();
    }

    public BOMessage getBOMessage() {
	return bomessage;
    }
}
