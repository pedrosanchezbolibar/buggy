package calypsox.buggy.product;

import com.calypso.tk.core.Trade;

/**
 * The Class ATTrade.
 */
public class ATTrade {

    /** The trade. */
    protected Trade trade;

    /**
     * Instantiates a new AT trade.
     *
     * @param trade the trade
     */
    public ATTrade(final Trade trade) {
	if (trade == null) {
	    throw new IllegalArgumentException("Trade is null");
	}
	this.trade = trade;
    }

    /**
     * Gets the accrual.
     *
     * @return the accrual
     */
    public final double getAccrual() {
	return trade.getAccrual();
    }

    /**
     * Gets the action.
     *
     * @return the action
     */
    public final com.calypso.tk.core.Action getAction() {
	return trade.getAction();
    }

    /**
     * Gets the alternate amount.
     *
     * @return the alternate amount
     */
    public final double getAlternateAmount() {
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
    public final String getComment() {
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
    public final com.calypso.tk.core.JDatetime getEnteredDate() {
	return trade.getEnteredDate();
    }

    /**
     * Gets the entered user.
     *
     * @return the entered user
     */
    public final String getEnteredUser() {
	return trade.getEnteredUser();
    }

    /**
     * Gets the exchange id.
     *
     * @return the exchange id
     */
    public final int getExchangeId() {
	return trade.getExchangeId();
    }

    /**
     * Gets the external reference.
     *
     * @return the external reference
     */
    public final String getExternalReference() {
	return trade.getExternalReference();
    }

    /**
     * Gets the fees.
     *
     * @return the fees
     */
    public final java.util.Vector getFees() {
	return trade.getFees();
    }

    /**
     * Gets the fees list.
     *
     * @return the fees list
     */
    public final java.util.Vector<com.calypso.tk.bo.Fee> getFeesList() {
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
    public final String getInternalReference() {
	return trade.getInternalReference();
    }

    /**
     * Gets the keyword value.
     *
     * @param keyword the keyword
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
    public final String getModifiedUser() {
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
    public final String getProductFamily() {
	return trade.getProductFamily();
    }

    /**
     * Gets the product sub type.
     *
     * @return the product sub type
     */
    public final String getProductSubType() {
	return trade.getProductSubType();
    }

    /**
     * Gets the product type.
     *
     * @return the product type
     */
    public final String getProductType() {
	return trade.getProductType();
    }

    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public final double getQuantity() {
	return trade.getQuantity();
    }

    /**
     * Gets the sales person.
     *
     * @return the sales person
     */
    public final String getSalesPerson() {
	return trade.getSalesPerson();
    }

    /**
     * Gets the settle currency.
     *
     * @return the settle currency
     */
    public final String getSettleCurrency() {
	return trade.getSettleCurrency();
    }

    /**
     * Gets the settle date.
     *
     * @return the settle date
     */
    public final com.calypso.tk.core.JDate getSettleDate() {
	return trade.getSettleDate();
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public final com.calypso.tk.core.Status getStatus() {
	return trade.getStatus();
    }

    /**
     * Gets the trade currency.
     *
     * @return the trade currency
     */
    public final String getTradeCurrency() {
	return trade.getTradeCurrency();
    }

    /**
     * Gets the trade date.
     *
     * @return the trade date
     */
    public final com.calypso.tk.core.JDatetime getTradeDate() {
	return trade.getTradeDate();
    }

    /**
     * Gets the trade price.
     *
     * @return the trade price
     */
    public final double getTradePrice() {
	return trade.getTradePrice();
    }

    /**
     * Gets the trader name.
     *
     * @return the trader name
     */
    public final String getTraderName() {
	return trade.getTraderName();
    }

    /**
     * Gets the updated time.
     *
     * @return the updated time
     */
    public final com.calypso.tk.core.JDatetime getUpdatedTime() {
	return trade.getUpdatedTime();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return trade.toString();
    }

}
