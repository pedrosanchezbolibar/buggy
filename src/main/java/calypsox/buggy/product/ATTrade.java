package calypsox.buggy.product;

import java.util.List;

import com.calypso.tk.bo.Fee;
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
    public com.calypso.tk.core.JDate getSettleDate() {
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return trade.toString();
    }

    /**
     * Gets the Calypso trade.
     *
     * @return the trade
     */
    public Trade getTrade() {
	return trade;
    }

}
