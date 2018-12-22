package calypsox.buggy.product;

import java.util.List;
import java.util.Vector;

import com.calypso.tk.bo.BOProductHandler;
import com.calypso.tk.bo.Fee;
import com.calypso.tk.bo.SDISelector;
import com.calypso.tk.bo.SDISelectorUtil;
import com.calypso.tk.bo.TradeTransferRule;
import com.calypso.tk.core.Action;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.Trade;
import com.calypso.tk.refdata.AccessUtil;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.infra.ATDSConnection;
import calypsox.buggy.xfer.ATSdi;
import calypsox.buggy.xfer.ATTradeTransferRule;

/**
 * The Class ATTrade.
 */
public class ATTrade {

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
        boolean rst = false;

        String userNameParam = userName;
        if (userNameParam == null) {
            // TODO: calypso_user debe leerse de configuración
            userNameParam = "calypso_user";
        }

        final ATDSConnection aatDsConn = new ATDSConnection(userNameParam);

        final Trade tradeChange = trade.clone();
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
     * Assign SDI.
     *
     * @param sdi
     *            the sdi
     * @param userName
     *            the user name
     * @return true, if successful
     * @throws CalypsoServiceException
     */
    public void assignSDI(final ATSdi sdi, final ATTradeTransferRule transferRule, final String actionToApply,
            final String userName) throws CalypsoServiceException {
        // TODO: AQUI
        final ATDSConnection dsCon = new ATDSConnection(userName);

        final Trade clonedTrade = trade.clone();
        final Vector<String> exceptions = new Vector<>();
        @SuppressWarnings("unchecked")
        final Vector<TradeTransferRule> transferRulesOnTrade = BOProductHandler.buildTransferRules(clonedTrade,
                exceptions, dsCon, false);

        final TradeTransferRule relevantTransferRule = transferRule.getRelevantTransferRule(transferRulesOnTrade);
        final SDISelector sdiSelector = SDISelectorUtil.find(clonedTrade, relevantTransferRule);

        final Vector<String> settleMethods = new Vector<>();
        settleMethods.add(sdi.getSettlementMethod());
        relevantTransferRule.setSettlementMethod(sdi.getSettlementMethod());
        sdiSelector.selectSDIs(clonedTrade, relevantTransferRule, JDate.getNow(), exceptions, settleMethods, dsCon);

        if ("REC".equalsIgnoreCase("")) {
            relevantTransferRule.setPayerSDStatus("Assigned");
            relevantTransferRule.setReceiverSDStatus("Assigned");
            relevantTransferRule.setReceiverSDId(sdi.getId());

        } else {
            relevantTransferRule.setPayerSDStatus("Assigned");
            relevantTransferRule.setReceiverSDStatus("Assigned");
            relevantTransferRule.setPayerSDId(sdi.getId());
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

    public ATTradeTransferRule createTransferRule(final String transferType, final String payRec) {
        return new ATTradeTransferRule().withTransferType(transferType).withPayRec(payRec);
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

    private TradeTransferRule getRelevantTransferRule(final ATSdi sdi,
            final List<TradeTransferRule> transferRulesOnTrade) {
        // TODO Auto-generated method stub
        return null;
    }

}
