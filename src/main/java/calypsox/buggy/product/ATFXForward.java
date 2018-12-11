package calypsox.buggy.product;

import java.util.List;

import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.FXForward;
import com.calypso.tk.product.NonDeliverableCcyLeg;
import com.calypso.tk.refdata.FXReset;

/**
 * The Class ATFXForward.
 */
public class ATFXForward extends ATFX {

    /** The fx. */
    private final FXForward fxforward;

    /**
     * Instantiates a new atfxndf.
     *
     * @param trade the trade
     */
    public ATFXForward(final Trade trade) {
	super(trade);
	fxforward = (FXForward) trade.getProduct();
    }

    /**
     * Gets the spot rate.
     *
     * @return the spot rate
     */
    public double getSpotRate() {
	return fxforward.getSpotRate();
    }

    /**
     * Gets the base forward rate.
     *
     * @return the base forward rate
     */
    public double getBaseForwardRate() {
	return fxforward.getBaseForwardRate();
    }

    /**
     * Gets the quoting forward rate.
     *
     * @return the quoting forward rate
     */
    public double getQuotingForwardRate() {
	return fxforward.getQuotingForwardRate();
    }

    /**
     * Gets the book forward rate.
     *
     * @return the book forward rate
     */
    public double getBookForwardRate() {
	return fxforward.getBookForwardRate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATFX#getDescription()
     */
    @Override
    public String getDescription() {
	return fxforward.getDescription();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATFX#getSubType()
     */
    @Override
    public String getSubType() {
	return fxforward.getSubType();
    }

    /**
     * Gets the spot rate mkt.
     *
     * @return the spot rate mkt
     */
    public double getSpotRateMkt() {
	return fxforward.getSpotRateMkt();
    }

    /**
     * Gets the FX based.
     *
     * @return the FX based
     */
    public List getFXBased() {
	return fxforward.getFXBased();
    }

    /**
     * Gets the non deliverable ccy legs.
     *
     * @return the non deliverable ccy legs
     */
    public List getNonDeliverableCcyLegs() {
	return fxforward.getNonDeliverableCcyLegs();
    }

    /**
     * Gets the non deliverable ccy legs quanto.
     *
     * @return the non deliverable ccy legs quanto
     */
    public List getNonDeliverableCcyLegsQuanto() {
	return fxforward.getNonDeliverableCcyLegsQuanto();
    }

    /**
     * Gets the non deliverable ccy leg.
     *
     * @return the non deliverable ccy leg
     */
    public NonDeliverableCcyLeg getNonDeliverableCcyLeg() {
	return fxforward.getNonDeliverableCcyLeg();
    }

    /**
     * Gets the non deliverable ccy leg quanto.
     *
     * @return the non deliverable ccy leg quanto
     */
    public NonDeliverableCcyLeg getNonDeliverableCcyLegQuanto() {
	return fxforward.getNonDeliverableCcyLegQuanto();
    }

    /**
     * Gets the FX reset based.
     *
     * @return the FX reset based
     */
    public List getFXResetBased() {
	return fxforward.getFXResetBased();
    }

    /**
     * Gets the fx reset.
     *
     * @return the fx reset
     */
    public FXReset getFxReset() {
	return fxforward.getFxReset();
    }

    /**
     * Gets the settlement amount currency.
     *
     * @return the settlement amount currency
     */
    public String getSettlementAmountCurrency() {
	return fxforward.getSettlementAmountCurrency();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATTrade#getSettleCurrency()
     */
    @Override
    public String getSettleCurrency() {
	return fxforward.getSettleCurrency();
    }

    /**
     * Gets the reset date time.
     *
     * @return the reset date time
     */
    public JDatetime getResetDateTime() {
	return fxforward.getResetDateTime();
    }

    /**
     * Gets the reset price.
     *
     * @return the reset price
     */
    public double getResetPrice() {
	return fxforward.getResetPrice();
    }
}
