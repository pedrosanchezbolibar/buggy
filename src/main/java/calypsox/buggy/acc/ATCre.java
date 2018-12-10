package calypsox.buggy.acc;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.bo.BOCre;
import com.calypso.tk.bo.BOTransfer;
import com.calypso.tk.core.AccountingBook;
import com.calypso.tk.core.Book;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.Trade;
import com.calypso.tk.refdata.AccountingEventConfig;
import com.calypso.tk.refdata.AccountingRule;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.product.ATTrade;
import calypsox.buggy.ui.ATAmount;
import calypsox.buggy.xfer.ATTransfer;

/**
 * Encapsulate and format the information of a BOCre
 */
public class ATCre {

    /** The bocre. */
    private final BOCre bocre;

    /**
     * Instantiates a new AT cre.
     *
     * @param bocre the bocre
     */
    public ATCre(final BOCre bocre) {
	this.bocre = bocre;
    }

    /**
     * Instantiates a new AT cre.
     *
     * @param linkedId the linked id
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATCre(final long linkedId) throws CalypsoServiceException {
	bocre = DSConnection.getDefault().getRemoteBackOffice().getBOCre(linkedId);
    }

    /**
     * Gets the accounting book.
     *
     * @return the accounting book
     */
    public AccountingBook getAccountingBook() {
	return BOCache.getAccountingBook(DSConnection.getDefault(), bocre.getAccountingBookId());
    }

    /**
     * Gets the accounting book name.
     *
     * @return the accounting book name
     */
    public String getAccountingBookName() {
	return bocre.getAccountingBookName();
    }

    /**
     * Gets the accounting rule id.
     *
     * @return the accounting rule id
     * @throws CalypsoServiceException the calypso service exception
     */
    public AccountingRule getAccountingRuleId() throws CalypsoServiceException {
	final int id = bocre.getAccountingRuleId();
	return DSConnection.getDefault().getRemoteAccounting().getAccountingRule(id);
    }

    /**
     * Gets the AT trade.
     *
     * @param id the id
     * @return the AT trade
     * @throws CalypsoServiceException the calypso service exception
     */
    private ATTrade getATTrade(final int id) throws CalypsoServiceException {
	final Trade trade = DSConnection.getDefault().getRemoteTrade().getTrade(id);
	return new ATTrade(trade);
    }

    /**
     * Gets the AT transfer.
     *
     * @param id the id
     * @return the AT transfer
     * @throws CalypsoServiceException the calypso service exception
     */
    private ATTransfer getATTransfer(final long id) throws CalypsoServiceException {
	final BOTransfer xfer = DSConnection.getDefault().getRemoteBackOffice().getBOTransfer(id);
	return new ATTransfer(xfer);
    }

    /**
     * Gets the attribute.
     *
     * @param name the name
     * @return the attribute
     */
    public String getAttribute(final String name) {
	return bocre.getAttributeValue(name);
    }

    /**
     * Gets the book id.
     *
     * @return the book id
     */
    public Book getBookId() {
	return BOCache.getBook(DSConnection.getDefault(), bocre.getBookId());
    }

    /**
     * Gets the booking date.
     *
     * @return the booking date
     */
    public JDate getBookingDate() {
	return bocre.getBookingDate();
    }

    /**
     * Gets the cre amount.
     *
     * @param index the index
     * @return the cre amount
     */
    public ATAmount getCreAmount(final int index) {
	return new ATAmount(bocre.getCurrency(index), bocre.getAmount(index));
    }

    /**
     * Gets the creation date.
     *
     * @return the creation date
     */
    public JDatetime getCreationDate() {
	return bocre.getCreationDate();
    }

    /**
     * Gets the cre type.
     *
     * @return the cre type
     */
    public String getCreType() {
	return bocre.getCreType();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
	return bocre.getDescription();
    }

    /**
     * Gets the effective date.
     *
     * @return the effective date
     */
    public JDate getEffectiveDate() {
	return bocre.getEffectiveDate();
    }

    /**
     * Gets the event config id.
     *
     * @return the event config id
     * @throws CalypsoServiceException the calypso service exception
     */
    public AccountingEventConfig getEventConfigId() throws CalypsoServiceException {
	final int id = bocre.getEventConfigId();
	return DSConnection.getDefault().getRemoteAccounting().getEventConfig(id);
    }

    /**
     * Gets the event type.
     *
     * @return the event type
     */
    public String getEventType() {
	return bocre.getEventType();
    }

    /**
     * Gets the hedge id.
     *
     * @return the hedge id
     */
    public int getHedgeId() {
	return bocre.getHedgeId();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
	return bocre.getId();
    }

    /**
     * Gets the linked id.
     *
     * @return the linked id
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATCre getLinkedId() throws CalypsoServiceException {
	return new ATCre(bocre.getLinkedId());
    }

    /**
     * Gets the linked trade id.
     *
     * @return the linked trade id
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATTrade getLinkedTradeId() throws CalypsoServiceException {
	return getATTrade(bocre.getLinkedTradeId());
    }

    /**
     * Gets the matching process.
     *
     * @return the matching process
     */
    public boolean getMatchingProcess() {
	return bocre.getMatchingProcess();
    }

    /**
     * Gets the netted transfer.
     *
     * @return the netted transfer
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATTransfer getNettedTransfer() throws CalypsoServiceException {
	return getATTransfer(bocre.getNettedTransferLongId());
    }

    /**
     * Gets the original event type.
     *
     * @return the original event type
     */
    public String getOriginalEventType() {
	return bocre.getOriginalEventType();
    }

    /**
     * Gets the posting comment.
     *
     * @return the posting comment
     */
    public String getPostingComment() {
	return bocre.getPostingComment();
    }

    /**
     * Gets the posting type.
     *
     * @return the posting type
     */
    public String getPostingType() {
	return bocre.getPostingType();
    }

    /**
     * Gets the sent date.
     *
     * @return the sent date
     */
    public JDatetime getSentDate() {
	return bocre.getSentDate();
    }

    /**
     * Gets the sent status.
     *
     * @return the sent status
     */
    public String getSentStatus() {
	return bocre.getSentStatus();
    }

    /**
     * Gets the settlement date.
     *
     * @return the settlement date
     */
    public JDate getSettlementDate() {
	return bocre.getSettlementDate();
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
	return bocre.getStatus();
    }

    /**
     * Gets the sub id.
     *
     * @return the sub id
     */
    public long getSubId() {
	return bocre.getSubId();
    }

    /**
     * Gets the trade.
     *
     * @return the trade
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATTrade getTrade() throws CalypsoServiceException {
	return getATTrade(bocre.getTradeId());
    }

    /**
     * Gets the trade date.
     *
     * @return the trade date
     */
    public JDate getTradeDate() {
	return bocre.getTradeDate();
    }

    /**
     * Gets the trade version.
     *
     * @return the trade version
     */
    public int getTradeVersion() {
	return bocre.getTradeVersion();
    }

    /**
     * Gets the transfer.
     *
     * @return the transfer
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATTransfer getTransfer() throws CalypsoServiceException {
	final long id = bocre.getTransferLongId();
	return getATTransfer(id);
    }

    /**
     * Gets the update time.
     *
     * @return the update time
     */
    public JDatetime getUpdateTime() {
	return bocre.getUpdateTime();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
	return bocre.getVersion();
    }

    /**
     * Gets the xfer version.
     *
     * @return the xfer version
     */
    public int getXferVersion() {
	return bocre.getXferVersion();
    }
}
