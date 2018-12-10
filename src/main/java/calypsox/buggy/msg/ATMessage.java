package calypsox.buggy.msg;

import com.calypso.tk.bo.BOMessage;
import com.calypso.tk.core.Action;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.Status;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.product.ATTrade;
import calypsox.buggy.product.ATTrades;
import calypsox.buggy.refdata.ATBook;
import calypsox.buggy.refdata.ATLEContact;
import calypsox.buggy.refdata.ATLegalEntity;
import calypsox.buggy.xfer.ATTransfer;

/**
 * Encapsulate and format the information of a BOMessage
 */
public class ATMessage {

    /** The trade. */
    protected BOMessage bomessage;

    /**
     * Instantiates a new AT trade.
     *
     * @param msg the msg
     */
    public ATMessage(final BOMessage msg) {
	if (msg == null) {
	    throw new IllegalArgumentException("Message is null");
	}
	bomessage = msg;
    }

    /**
     * Instantiates a new AT message.
     *
     * @param id the id
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATMessage(final long id) throws CalypsoServiceException {
	final BOMessage msg = DSConnection.getDefault().getRemoteBackOffice().getMessage(id);
	bomessage = msg;
    }

    /**
     * Gets the language.
     *
     * @return the language
     */
    public String getLanguage() {
	return bomessage.getLanguage();
    }

    /**
     * Gets the attribute.
     *
     * @param name the name
     * @return the attribute
     */
    public String getAttribute(final String name) {
	return bomessage.getAttribute(name);
    }

    /**
     * Gets the book.
     *
     * @return the book
     */
    public ATBook getBook() {
	return new ATBook(bomessage.getBookId());
    }

    /**
     * Gets the trade.
     *
     * @return the trade
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATTrade getTrade() throws CalypsoServiceException {
	return new ATTrades().createTrade(bomessage.getTradeId());
    }

    /**
     * Gets the legal entity.
     *
     * @return the legal entity
     */
    public ATLegalEntity getLegalEntity() {
	return new ATLegalEntity(bomessage.getLegalEntityId());
    }

    /**
     * Gets the update datetime.
     *
     * @return the update datetime
     */
    public JDatetime getUpdateDatetime() {
	return bomessage.getUpdateDatetime();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
	return bomessage.getLongId();
    }

    /**
     * Gets the trade update datetime.
     *
     * @return the trade update datetime
     */
    public JDatetime getTradeUpdateDatetime() {
	return bomessage.getTradeUpdateDatetime();
    }

    /**
     * Gets the event type.
     *
     * @return the event type
     */
    public String getEventType() {
	return bomessage.getEventType();
    }

    /**
     * Gets the product family.
     *
     * @return the product family
     */
    public String getProductFamily() {
	return bomessage.getProductFamily();
    }

    /**
     * Gets the product type.
     *
     * @return the product type
     */
    public String getProductType() {
	return bomessage.getProductType();
    }

    /**
     * Gets the message type.
     *
     * @return the message type
     */
    public String getMessageType() {
	return bomessage.getMessageType();
    }

    /**
     * Gets the sender.
     *
     * @return the sender
     */
    public ATLegalEntity getSender() {
	return new ATLegalEntity(bomessage.getSenderId());
    }

    /**
     * Gets the sender role.
     *
     * @return the sender role
     */
    public String getSenderRole() {
	return bomessage.getSenderRole();
    }

    /**
     * Gets the sender contact type.
     *
     * @return the sender contact type
     */
    public String getSenderContactType() {
	return bomessage.getSenderContactType();
    }

    /**
     * Gets the sender address code.
     *
     * @return the sender address code
     */
    public String getSenderAddressCode() {
	return bomessage.getSenderAddressCode();
    }

    /**
     * Gets the receiver.
     *
     * @return the receiver
     */
    public ATLegalEntity getReceiver() {
	return new ATLegalEntity(bomessage.getReceiverId());
    }

    /**
     * Gets the receiver role.
     *
     * @return the receiver role
     */
    public String getReceiverRole() {
	return bomessage.getReceiverRole();
    }

    /**
     * Gets the receiver contact type.
     *
     * @return the receiver contact type
     */
    public String getReceiverContactType() {
	return bomessage.getReceiverContactType();
    }

    /**
     * Gets the receiver address code.
     *
     * @return the receiver address code
     */
    public String getReceiverAddressCode() {
	return bomessage.getReceiverAddressCode();
    }

    /**
     * Gets the address method.
     *
     * @return the address method
     */
    public String getAddressMethod() {
	return bomessage.getAddressMethod();
    }

    /**
     * Gets the gateway.
     *
     * @return the gateway
     */
    public String getGateway() {
	return bomessage.getGateway();
    }

    /**
     * Gets the creation date.
     *
     * @return the creation date
     */
    public JDatetime getCreationDate() {
	return bomessage.getCreationDate();
    }

    /**
     * Gets the settle date.
     *
     * @return the settle date
     */
    public JDate getSettleDate() {
	return bomessage.getSettleDate();
    }

    /**
     * Gets the sub action.
     *
     * @return the sub action
     */
    public Action getSubAction() {
	return bomessage.getSubAction();
    }

    /**
     * Gets the receiver contact.
     *
     * @return the receiver contact
     */
    public ATLEContact getReceiverContact() {
	return new ATLEContact(bomessage.getReceiverContactId());
    }

    /**
     * Gets the sender contact id.
     *
     * @return the sender contact id
     */
    public ATLEContact getSenderContactId() {
	return new ATLEContact(bomessage.getSenderContactId());
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public Status getStatus() {
	return bomessage.getStatus();
    }

    /**
     * Gets the matching B.
     *
     * @return the matching B
     */
    public boolean getMatchingB() {
	return bomessage.getMatchingB();
    }

    /**
     * Gets the template name.
     *
     * @return the template name
     */
    public String getTemplateName() {
	return bomessage.getTemplateName();
    }

    /**
     * Gets the action.
     *
     * @return the action
     */
    public Action getAction() {
	return bomessage.getAction();
    }

    /**
     * Gets the linked id.
     *
     * @return the linked id
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATMessage getLinkedId() throws CalypsoServiceException {
	return new ATMessage(bomessage.getLinkedLongId());
    }

    /**
     * Gets the transfer.
     *
     * @return the transfer
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATTransfer getTransfer() throws CalypsoServiceException {
	return new ATTransfer(bomessage.getTransferLongId());
    }

    /**
     * Gets the format type.
     *
     * @return the format type
     */
    public String getFormatType() {
	return bomessage.getFormatType();
    }

    /**
     * Gets the kickoff action.
     *
     * @return the kickoff action
     */
    public Action getKickoffAction() {
	return bomessage.getKickoffAction();
    }

    /**
     * Gets the document edited B.
     *
     * @return the document edited B
     */
    public boolean getDocumentEditedB() {
	return bomessage.getDocumentEditedB();
    }

    /**
     * Gets the message class.
     *
     * @return the message class
     */
    public int getMessageClass() {
	return bomessage.getMessageClass();
    }

    /**
     * Gets the advice config id.
     *
     * @return the advice config id
     */
    public int getAdviceConfigId() {
	return bomessage.getAdviceConfigId();
    }

    /**
     * Gets the statement id.
     *
     * @return the statement id
     */
    public int getStatementId() {
	return bomessage.getStatementId();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
	return bomessage.getDescription();
    }

    /**
     * Gets the trade version.
     *
     * @return the trade version
     */
    public int getTradeVersion() {
	return bomessage.getTradeVersion();
    }

    /**
     * Gets the xfer version.
     *
     * @return the xfer version
     */
    public int getXferVersion() {
	return bomessage.getXferVersion();
    }

    /**
     * Gets the external B.
     *
     * @return the external B
     */
    public boolean getExternalB() {
	return bomessage.getExternalB();
    }

    /**
     * Gets the group id.
     *
     * @return the group id
     */
    public long getGroupId() {
	return bomessage.getGroupLongId();
    }

    /**
     * Gets the referrent key.
     *
     * @return the referrent key
     */
    public Object getReferrentKey() {
	return bomessage.getReferrentKey();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
	return bomessage.getVersion();
    }

    /**
     * Gets the entered user.
     *
     * @return the entered user
     */
    public String getEnteredUser() {
	return bomessage.getEnteredUser();
    }

    /**
     * Gets the total group messages.
     *
     * @return the total group messages
     */
    public int getTotalGroupMessages() {
	return bomessage.getTotalGroupMessages();
    }

    /**
     * Gets the BO message.
     *
     * @return the BO message
     */
    public BOMessage getBOMessage() {
	return bomessage;
    }
}
