package calypsox.buggy.product;

import com.calypso.tk.core.Trade;
import com.calypso.tk.product.FXSwap;

/**
 * The Class ATFXSwap.
 */
public class ATFXSwap extends ATTrade {

    /** The fxswap. */
    private final FXSwap fxswap;

    /**
     * Instantiates a new atfx.
     *
     * @param trade the trade
     */
    public ATFXSwap(final Trade trade) {
	super(trade);
	fxswap = (FXSwap) trade.getProduct();
    }

}
