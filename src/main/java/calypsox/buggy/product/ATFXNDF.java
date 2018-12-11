package calypsox.buggy.product;

import java.util.List;
import java.util.Vector;

import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.FXNDF;
import com.calypso.tk.product.NonDeliverableCcyLeg;
import com.calypso.tk.refdata.FXReset;

/**
 * The Class ATFX.
 */
public class ATFXNDF extends ATFXForward {

    /** The fx. */
    private final FXNDF fxndf;

    /**
     * Instantiates a new atfxndf.
     *
     * @param trade the trade
     */
    public ATFXNDF(final Trade trade) {
	super(trade);
	fxndf = (FXNDF) trade.getProduct();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getSettleCurrency()
     */
    @Override
    public String getSettleCurrency() {
	return fxndf.getSettleCurrency();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getResetPrice()
     */
    @Override
    public double getResetPrice() {
	return fxndf.getResetPrice();
    }

    /**
     * Gets the reset primary price.
     *
     * @return the reset primary price
     */
    public double getResetPrimaryPrice() {
	return fxndf.getResetPrimaryPrice();
    }

    /**
     * Gets the reset quoting price.
     *
     * @return the reset quoting price
     */
    public double getResetQuotingPrice() {
	return fxndf.getResetQuotingPrice();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getResetDateTime()
     */
    @Override
    public JDatetime getResetDateTime() {
	return fxndf.getResetDateTime();
    }

    /**
     * Gets the ref banks.
     *
     * @return the ref banks
     */
    public Vector getRefBanks() {
	return fxndf.getRefBanks();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getFxReset()
     */
    @Override
    public FXReset getFxReset() {
	return fxndf.getFxReset();
    }

    /**
     * Gets the split currency.
     *
     * @return the split currency
     */
    public String getSplitCurrency() {
	return fxndf.getSplitCurrency();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getDescription()
     */
    @Override
    public String getDescription() {
	return fxndf.getDescription();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getSettlementAmountCurrency()
     */
    @Override
    public String getSettlementAmountCurrency() {
	return fxndf.getSettlementAmountCurrency();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getSubType()
     */
    @Override
    public String getSubType() {
	return fxndf.getSubType();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFX#getUsedHolidays()
     */
    @Override
    public String[] getUsedHolidays() {
	return fxndf.getUsedHolidays();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getFXResetBased()
     */
    @Override
    public List getFXResetBased() {
	return fxndf.getFXResetBased();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getNonDeliverableCcyLegs()
     */
    @Override
    public List getNonDeliverableCcyLegs() {
	return fxndf.getNonDeliverableCcyLegs();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getNonDeliverableCcyLegsQuanto()
     */
    @Override
    public List getNonDeliverableCcyLegsQuanto() {
	return fxndf.getNonDeliverableCcyLegsQuanto();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getNonDeliverableCcyLeg()
     */
    @Override
    public NonDeliverableCcyLeg getNonDeliverableCcyLeg() {
	return fxndf.getNonDeliverableCcyLeg();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getFXBased()
     */
    @Override
    public List getFXBased() {
	return fxndf.getFXBased();
    }

    /*
     * (non-Javadoc)
     *
     * @see calypsox.buggy.product.ATFXForward#getNonDeliverableCcyLegQuanto()
     */
    @Override
    public NonDeliverableCcyLeg getNonDeliverableCcyLegQuanto() {
	return fxndf.getNonDeliverableCcyLegQuanto();
    }
}
