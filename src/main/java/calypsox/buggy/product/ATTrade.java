package calypsox.buggy.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import com.calypso.tk.bo.BOProductHandler;
import com.calypso.tk.bo.BOTransfer;
import com.calypso.tk.bo.Fee;
import com.calypso.tk.bo.SDISelector;
import com.calypso.tk.bo.SDISelectorUtil;
import com.calypso.tk.bo.TradeTransferRule;
import com.calypso.tk.core.Action;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.Status;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.Cash;
import com.calypso.tk.refdata.AccessUtil;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.TransferArray;

import calypsox.buggy.infra.ATDSConnection;
import calypsox.buggy.xfer.ATSdi;
import calypsox.buggy.xfer.ATTradeTransferRule;

/**
 * The Class ATTrade.
 */
public class ATTrade {

    /** The Constant SD_STATUS_ASSIGNED. */
    private static final String SD_STATUS_ASSIGNED = "Assigned";
    /** The Constant ASSIGNED_STATUS. */
    private static final String ASSIGNED_STATUS = "Xfer Assigned";

    /** The trade. */
    protected Trade trade;

    /**
     * Instantiates a new AT trade.
     *
     * @param tradeId
     *            the trade id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTrade(final long tradeId) throws CalypsoServiceException {
        trade = DSConnection.getDefault().getRemoteTrade().getTrade((int) tradeId);
    }

    /**
     * Instantiates a new AT trade.
     *
     * @param trade
     *            the trade
     */
    public ATTrade(final Trade trade) {
        if (trade == null) {
            throw new IllegalArgumentException("Trade is null");
        }
        this.trade = trade;
    }

    /**
     * Apply action.
     *
     * @param action
     *            the action
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public boolean applyAction(final String action) throws CalypsoServiceException {
        return applyAction(action, null);
    }

    /**
     * Apply action to trade.
     *
     * @param action
     *            the action
     * @param userName
     *            the user name
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public boolean applyAction(final String action, final String userName) throws CalypsoServiceException {
        final Trade tradeCloned = trade.clone();

        return applyAction(tradeCloned, action, userName);
    }

    /**
     * Assign sdi on trade.
     *
     * @param sdi
     *            the sdi
     * @param transferRules
     *            the transfer rules
     * @param actionToApply
     *            the action to apply
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public void assignSdiOnTrade(final ATSdi sdi, final List<ATTradeTransferRule> transferRules,
            final String actionToApply) throws CalypsoServiceException {
        assignSdiOnTrade(sdi, transferRules, actionToApply, null);
    }

    /**
     * Assign SDI.
     *
     * @param sdi
     *            the sdi
     * @param transferRule
     *            the transfer rule
     * @param actionToApply
     *            the action to apply
     * @param userName
     *            the user name
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public void assignSdiOnTrade(final ATSdi sdi, final List<ATTradeTransferRule> transferRules,
            final String actionToApply, final String userName) throws CalypsoServiceException {
        final ATDSConnection dsCon = new ATDSConnection(userName);
        final Trade clonedTrade = trade.clone();
        final Vector<String> exceptions = new Vector<>();
        @SuppressWarnings("unchecked")
        final Vector<TradeTransferRule> transferRulesOnTrade = BOProductHandler.buildTransferRules(clonedTrade,
                exceptions, dsCon, false);

        for (final ATTradeTransferRule transferRule : transferRules) {
            final TradeTransferRule relevantTransferRule = transferRule.getRelevantTransferRule(transferRulesOnTrade);

            final Vector<String> settleMethods = new Vector<>();
            settleMethods.add(sdi.getSettlementMethod());
            relevantTransferRule.setSettlementMethod(sdi.getSettlementMethod());
            final SDISelector sdiSelector = SDISelectorUtil.find(clonedTrade, relevantTransferRule);
            sdiSelector.selectSDIs(clonedTrade, relevantTransferRule, JDate.getNow(), exceptions, settleMethods, dsCon);
            relevantTransferRule.setReceiverSDStatus(SD_STATUS_ASSIGNED);
            relevantTransferRule.setPayerSDStatus(SD_STATUS_ASSIGNED);

            if (transferRule.getDirection().startsWith("REC")) {
                relevantTransferRule.setReceiverSDId(sdi.getId());
            } else if (transferRule.getDirection().startsWith("PAY")) {
                relevantTransferRule.setPayerSDId(sdi.getId());
            } else if (transferRule.getDirection().startsWith("BOTH")) {
                relevantTransferRule.setReceiverSDId(sdi.getId());
                relevantTransferRule.setPayerSDId(sdi.getId());
            }
        }

        final Action action = Action.valueOf(actionToApply);

        if (AccessUtil.isAuthorized(clonedTrade, actionToApply)) {
            clonedTrade.setCustomTransferRuleB(true);
            clonedTrade.setTransferRules(transferRulesOnTrade);
            clonedTrade.setAction(action);

            clonedTrade.setEnteredUser(dsCon.getUser());

            dsCon.getRemoteTrade().save(clonedTrade);
        } else {
            dsCon.restoreRealConnection();
            throw new CalypsoServiceException("Action cant be performed with user: " + userName);
        }

        dsCon.restoreRealConnection();
    }

    /**
     * Assign one sdi on transfer.
     *
     * @param sdi
     *            the sdi
     * @param transferRule
     *            the transfer rule
     * @param actionToApply
     *            the action to apply
     * @param userName
     *            the user name
     * @throws CalypsoServiceException
     *             the calypso service exception
     * @throws CloneNotSupportedException
     *             the clone not supported exception
     */
    public void assignSdiOnTransfer(final ATSdi sdi, final ATTradeTransferRule transferRule, final String actionToApply,
            final String userName) throws CalypsoServiceException, CloneNotSupportedException {
        if ("PAY".equals(transferRule.getPayReceive())) {
            assignSdisOnTransfer(sdi, null, transferRule, actionToApply, userName);
        } else {
            assignSdisOnTransfer(null, sdi, transferRule, actionToApply, userName);
        }
    }

    /**
     * Assign both sdis on transfer.
     *
     * @param payerSdi
     *            the payer sdi
     * @param receiverSdi
     *            the receiver sdi
     * @param transferRule
     *            the transfer rule
     * @param actionToApply
     *            the action to apply
     * @param userName
     *            the user name
     * @throws CalypsoServiceException
     *             the calypso service exception
     * @throws CloneNotSupportedException
     *             the clone not supported exception
     */
    public void assignSdisOnTransfer(final ATSdi payerSdi, final ATSdi receiverSdi,
            final ATTradeTransferRule transferRule, final String actionToApply, final String userName)
            throws CalypsoServiceException, CloneNotSupportedException {
        final ATDSConnection dsCon = new ATDSConnection(userName);

        final BOTransfer transferToCancel = getRelevantTransfer(transferRule);
        final BOTransfer amendedTransfer = assignSdi(dsCon, payerSdi, receiverSdi, transferToCancel);

        final List<BOTransfer> underlyingTranfers = modifyUnderlying(transferToCancel, amendedTransfer);

        if (AccessUtil.isAuthorized(transferToCancel, actionToApply)) {
            final long newTransferId = dsCon.getRemoteBackOffice().save(amendedTransfer, 0, null);
            dsCon.getRemoteBackOffice().save(transferToCancel, 0, null);

            final BOTransfer nettedTransfer = dsCon.getRemoteBackOffice().getBOTransfer(newTransferId);

            for (final BOTransfer currentAmendedTransfer : underlyingTranfers) {
                currentAmendedTransfer.setNettedTransferLongId(newTransferId);
                currentAmendedTransfer.setStatus(nettedTransfer.getStatus());

                dsCon.getRemoteBackOffice().save(currentAmendedTransfer, 0, null);
            }
        } else {
            dsCon.restoreRealConnection();
            throw new CalypsoServiceException("Action can't be performed with user: " + userName);
        }

        dsCon.restoreRealConnection();
    }

    /**
     * Gets the accrual.
     *
     * @return the accrual
     */
    public double getAccrual() {
        return trade.getAccrual();
    }

    /**
     * Gets the action.
     *
     * @return the action
     */
    public com.calypso.tk.core.Action getAction() {
        return trade.getAction();
    }

    /**
     * Gets the alternate amount.
     *
     * @return the alternate amount
     */
    public double getAlternateAmount() {
        return trade.getAlternateAmount();
    }

    /**
     * Gets the book.
     *
     * @return the book
     */
    public com.calypso.tk.core.Book getBook() {
        return trade.getBook();
    }

    /**
     * Gets the comment.
     *
     * @return the comment
     */
    public String getComment() {
        return trade.getComment();
    }

    /**
     * Gets the counter party.
     *
     * @return the counter party
     */
    public com.calypso.tk.core.LegalEntity getCounterParty() {
        return trade.getCounterParty();
    }

    /**
     * Gets the entered date.
     *
     * @return the entered date
     */
    public com.calypso.tk.core.JDatetime getEnteredDate() {
        return trade.getEnteredDate();
    }

    /**
     * Gets the entered user.
     *
     * @return the entered user
     */
    public String getEnteredUser() {
        return trade.getEnteredUser();
    }

    /**
     * Gets the exchange id.
     *
     * @return the exchange id
     */
    public int getExchangeId() {
        return trade.getExchangeId();
    }

    /**
     * Gets the external reference.
     *
     * @return the external reference
     */
    public String getExternalReference() {
        return trade.getExternalReference();
    }

    /**
     * Gets the fees.
     *
     * @return the fees
     */
    @SuppressWarnings("unchecked")
    public List<Fee> getFees() {
        return trade.getFees();
    }

    /**
     * Gets the fees list.
     *
     * @return the fees list
     */
    public List<Fee> getFeesList() {
        return trade.getFeesList();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return trade.getId();
    }

    /**
     * Gets the internal reference.
     *
     * @return the internal reference
     */
    public String getInternalReference() {
        return trade.getInternalReference();
    }

    /**
     * Gets the keyword value.
     *
     * @param keyword
     *            the keyword
     * @return the keyword value
     */
    public String getKeywordValue(final String keyword) {
        return trade.getKeywordValue(keyword);
    }

    /**
     * Gets the modified user.
     *
     * @return the modified user
     */
    public String getModifiedUser() {
        return trade.getModifiedUser();
    }

    /**
     * Gets the product description.
     *
     * @return the product description
     */
    public String getProductDescription() {
        return trade.getProduct().getDescription();
    }

    /**
     * Gets the product family.
     *
     * @return the product family
     */
    public String getProductFamily() {
        return trade.getProductFamily();
    }

    /**
     * Gets the product sub type.
     *
     * @return the product sub type
     */
    public String getProductSubType() {
        return trade.getProductSubType();
    }

    /**
     * Gets the product type.
     *
     * @return the product type
     */
    public String getProductType() {
        return trade.getProductType();
    }

    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public double getQuantity() {
        return trade.getQuantity();
    }

    /**
     * Gets the sales person.
     *
     * @return the sales person
     */
    public String getSalesPerson() {
        return trade.getSalesPerson();
    }

    /**
     * Gets the settle currency.
     *
     * @return the settle currency
     */
    public String getSettleCurrency() {
        return trade.getSettleCurrency();
    }

    /**
     * Gets the settle date.
     *
     * @return the settle date
     */
    public JDate getSettleDate() {
        return trade.getSettleDate();
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public com.calypso.tk.core.Status getStatus() {
        return trade.getStatus();
    }

    /**
     * Gets the Calypso trade.
     *
     * @return the trade
     */
    public Trade getTrade() {
        return trade;
    }

    /**
     * Gets the trade currency.
     *
     * @return the trade currency
     */
    public String getTradeCurrency() {
        return trade.getTradeCurrency();
    }

    /**
     * Gets the trade date.
     *
     * @return the trade date
     */
    public com.calypso.tk.core.JDatetime getTradeDate() {
        return trade.getTradeDate();
    }

    /**
     * Gets the trade price.
     *
     * @return the trade price
     */
    public double getTradePrice() {
        return trade.getTradePrice();
    }

    /**
     * Gets the trader name.
     *
     * @return the trader name
     */
    public String getTraderName() {
        return trade.getTraderName();
    }

    /**
     * Builds the transfer rules.
     *
     * @return the list
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    @SuppressWarnings("unchecked")
    public List<ATTradeTransferRule> getTransferRules() throws CalypsoServiceException {
        final List<ATTradeTransferRule> result = new ArrayList<>();
        Vector<TradeTransferRule> transferRules = trade.getTransferRules();
        if (transferRules == null) {
            transferRules = BOProductHandler.buildTransferRules(trade, new Vector<String>(), DSConnection.getDefault());
        }
        Collections.sort(transferRules);
        for (final TradeTransferRule rule : transferRules) {
            result.add(new ATTradeTransferRule(rule));
        }
        return result;
    }

    /**
     * Gets the updated time.
     *
     * @return the updated time
     */
    public com.calypso.tk.core.JDatetime getUpdatedTime() {
        return trade.getUpdatedTime();
    }

    /**
     * Reload.
     *
     * @return the AT trade
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTrade reload() throws CalypsoServiceException {
        trade = DSConnection.getDefault().getRemoteTrade().getTrade(trade.getId());
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return trade.toString() + " / " + trade.getProduct().getDescription();
    }

    /**
     * Update amount.
     *
     * @param trade
     *            the trade
     * @param amount
     *            the amount
     * @param action
     *            the action
     * @param username
     *            the username
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public boolean updateAmount(final Trade trade, final Double amount, final String action, final String username)
            throws CalypsoServiceException {

        final Trade clonedTrade = trade.clone();
        clonedTrade.getProduct().setPrincipal(amount);

        return applyAction(clonedTrade, action, username);
    }

    /**
     * Update comment.
     *
     * @param trade
     *            the trade
     * @param comment
     *            the comment
     * @param action
     *            the action
     * @param username
     *            the username
     * @return the string
     * @throws CalypsoServiceException
     *             the remote exception
     */
    public boolean updateComment(final Trade trade, final String comment, final String action, final String username)
            throws CalypsoServiceException {

        final Trade clonedTrade = trade.clone();
        clonedTrade.setComment(comment);
        return applyAction(clonedTrade, action, username);
    }

    /**
     * Update quantity.
     *
     * @param quantity
     *            the quantity
     * @param action
     *            the action
     * @param username
     *            the username
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public boolean updateQuantity(final double quantity, final String action, final String username)
            throws CalypsoServiceException {

        final Trade clonedTrade = trade.clone();
        if (clonedTrade.getProduct() instanceof Cash) {
            final Cash cash = (Cash) clonedTrade.getProduct();
            cash.setPrincipal(quantity);
        } else {
            clonedTrade.setQuantity(quantity);
        }
        return applyAction(clonedTrade, action, username);
    }

    /**
     * Update settle date.
     *
     * @param setDate
     *            the set date
     * @param action
     *            the action
     * @param username
     *            the username
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public boolean updateSettleDate(final JDate setDate, final String action, final String username)
            throws CalypsoServiceException {

        final Trade clonedTrade = trade.clone();
        clonedTrade.setSettleDate(setDate);

        return applyAction(clonedTrade, action, username);
    }

    /**
     * Apply action.
     *
     * @param tradeChange
     *            the trade change
     * @param action
     *            the action
     * @param userName
     *            the user name
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    protected boolean applyAction(final Trade tradeChange, final String action, final String userName)
            throws CalypsoServiceException {
        boolean rst = false;

        String userNameParam = userName;
        if (userNameParam == null) {
            userNameParam = DSConnection.getDefault().getUser();
        }

        final ATDSConnection aatDsConn = new ATDSConnection(userNameParam);

        if (AccessUtil.isAuthorized(tradeChange, action)) {
            tradeChange.setAction(Action.valueOf(action));
            tradeChange.setEnteredUser(userNameParam);

            DSConnection.getDefault().getRemoteTrade().save(tradeChange);
            rst = true;

        } else {
            aatDsConn.restoreRealConnection();
            throw new SecurityException("Action can't be performed with user " + userNameParam);
        }

        aatDsConn.restoreRealConnection();
        return rst;
    }

    /**
     * Assign sdi.
     *
     * @param dsCon
     *            the ds con
     * @param payerSdi
     *            the payer sdi
     * @param recSdi
     *            the rec sdi
     * @param transferToCancel
     *            the transfer to cancel
     * @return the BO transfer
     * @throws CloneNotSupportedException
     *             the clone not supported exception
     */
    private BOTransfer assignSdi(final ATDSConnection dsCon, final ATSdi payerSdi, final ATSdi recSdi,
            final BOTransfer transferToCancel) throws CloneNotSupportedException {
        final BOTransfer amendedTransfer = (BOTransfer) transferToCancel.clone();
        final TradeTransferRule transferRule = amendedTransfer.toTradeTransferRule();

        final SDISelector sdiSelector = SDISelectorUtil.find(trade, transferRule);

        if (payerSdi != null) {
            final Vector<String> settleMethods = new Vector<>();
            settleMethods.add(payerSdi.getSettlementMethod());
            sdiSelector.selectSDIs(trade, transferRule, JDate.getNow(), new Vector<String>(), settleMethods, dsCon);
            amendedTransfer.setPayerSDId(payerSdi.getId());
            amendedTransfer.setPayerSDStatus(ASSIGNED_STATUS);
        }

        if (recSdi != null) {
            final Vector<String> settleMethods = new Vector<>();
            settleMethods.add(recSdi.getSettlementMethod());
            sdiSelector.selectSDIs(trade, transferRule, JDate.getNow(), new Vector<String>(), settleMethods, dsCon);
            amendedTransfer.setReceiverSDId(recSdi.getId());
            amendedTransfer.setReceiverSDStatus(ASSIGNED_STATUS);
        }

        amendedTransfer.setExternalSDStatus(ASSIGNED_STATUS);
        amendedTransfer.setInternalSDStatus(ASSIGNED_STATUS);

        amendedTransfer.setAction(Action.NEW);
        amendedTransfer.setStatus(Status.S_NONE);
        amendedTransfer.setParentLongId(amendedTransfer.getLongId());
        amendedTransfer.setLongId(0);
        amendedTransfer.setOtherAmount(0.0D);
        amendedTransfer.setRealCashAmount(0.0D);
        amendedTransfer.setCashAccountNumber(0);
        amendedTransfer.setNettedTransferLongId(0);
        amendedTransfer.setBusinessReason(Action.S_ASSIGN);

        transferToCancel.setAction(Action.ASSIGN);

        return amendedTransfer;
    }

    /**
     * Gets the relevant transfer.
     *
     * @param transferRule
     *            the transfer rule
     * @return the relevant transfer
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    private BOTransfer getRelevantTransfer(final ATTradeTransferRule transferRule) throws CalypsoServiceException {
        final TransferArray transferArray = DSConnection.getDefault().getRemoteBackOffice()
                .getBOTransfers(trade.getId());
        for (int i = 0; i < transferArray.size(); i++) {
            final BOTransfer xfer = transferArray.get(i);
            if (xfer.getTransferType().equals(transferRule.getTransferType())
                    && xfer.getPayReceive().equals(transferRule.getPayReceive())) {
                return xfer;
            }
        }
        throw new IllegalArgumentException("Can't find a transfer to assign this transfer rule: " + transferRule);
    }

    /**
     * Modify underlying.
     *
     * @param transferToCancel
     *            the transfer to cancel
     * @param amendedTransfer
     *            the amended transfer
     * @return the list
     * @throws CloneNotSupportedException
     *             the clone not supported exception
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    private List<BOTransfer> modifyUnderlying(final BOTransfer transferToCancel, final BOTransfer amendedTransfer)
            throws CloneNotSupportedException, CalypsoServiceException {
        final TransferArray underlyingTransfers = DSConnection.getDefault().getRemoteBackOffice()
                .getBOTransfers("netted_transfer_id = " + transferToCancel.getLongId());
        final List<BOTransfer> amendedUnderTransfers = new ArrayList<>(underlyingTransfers.size());

        for (final BOTransfer underTransfer : underlyingTransfers) {
            final BOTransfer amendedUndTransfer = (BOTransfer) underTransfer.clone();

            updateRelevantInfo(amendedUndTransfer, amendedTransfer, transferToCancel);

            amendedUnderTransfers.add(amendedUndTransfer);

        }

        return amendedUnderTransfers;
    }

    /**
     * Update relevant info.
     *
     * @param underliying
     *            the underliying
     * @param amendedTransfer
     *            the amended transfer
     * @param canceledTransfer
     *            the canceled transfer
     */
    private void updateRelevantInfo(final BOTransfer underliying, final BOTransfer amendedTransfer,
            final BOTransfer canceledTransfer) {
        final TradeTransferRule rule = underliying.toTradeTransferRule();

        final SDISelector sdiSelector = SDISelectorUtil.find(trade, rule);

        final Vector<String> settleMethods = new Vector<>();
        settleMethods.add(rule.getSettlementMethod());

        sdiSelector.selectSDIs(trade, rule, JDate.getNow(), new Vector<String>(), settleMethods,
                DSConnection.getDefault());

        underliying.setPayerSDId(amendedTransfer.getPayerSDId());
        underliying.setReceiverSDId(amendedTransfer.getReceiverSDId());
        underliying.setPayerSDStatus(ASSIGNED_STATUS);
        underliying.setReceiverSDStatus(ASSIGNED_STATUS);
        underliying.setExternalSDStatus(ASSIGNED_STATUS);
        underliying.setInternalSDStatus(ASSIGNED_STATUS);

        underliying.setAction(Action.NEW);
        underliying.setStatus(Status.S_NONE);
        underliying.setParentLongId(canceledTransfer.getLongId());
        underliying.setLongId(0);
        underliying.setOtherAmount(0.0D);
        underliying.setRealCashAmount(0.0D);
        underliying.setCashAccountNumber(0);
    }

}
