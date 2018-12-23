package calypsox.buggy.product;

import com.calypso.tk.core.Trade;
import com.calypso.tk.product.MarginCall;
import com.calypso.tk.refdata.MarginCallConfig;

/**
 * The Class ATMarginCall.
 */
public class ATMarginCall extends ATSimpleTransfer {

    /** The margincall. */
    private final MarginCall margincall;

    /**
     * Instantiates a new AT margin call.
     *
     * @param trade
     *            the trade
     */
    public ATMarginCall(final Trade trade) {
        super(trade);
        margincall = (MarginCall) trade.getProduct();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATSimpleTransfer#getDescription()
     */
    @Override
    public String getDescription() {
        return margincall.getDescription();
    }

    /**
     * Gets the margin call config.
     *
     * @return the margin call config
     */
    public MarginCallConfig getMarginCallConfig() {
        return margincall.getMarginCallConfig();
    }

    /**
     * Gets the margin call id.
     *
     * @return the margin call id
     */
    public int getMarginCallId() {
        return margincall.getMarginCallId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATSimpleTransfer#getProductFamily()
     */
    @Override
    public String getProductFamily() {
        return margincall.getProductFamily();
    }
}
