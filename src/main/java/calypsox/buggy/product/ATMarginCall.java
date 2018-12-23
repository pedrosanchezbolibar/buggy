package calypsox.buggy.product;

import com.calypso.tk.core.Trade;
import com.calypso.tk.product.MarginCall;
import com.calypso.tk.refdata.MarginCallConfig;

public class ATMarginCall extends ATSimpleTransfer {

    /** The interestbearing. */
    private final MarginCall margincall;

    /**
     * Instantiates a new AT interest bearing.
     *
     * @param trade
     *            the trade
     */
    public ATMarginCall(final Trade trade) {
        super(trade);
        margincall = (MarginCall) trade.getProduct();
    }

    @Override
    public String getDescription() {
        return margincall.getDescription();
    }

    public MarginCallConfig getMarginCallConfig() {
        return margincall.getMarginCallConfig();
    }

    public int getMarginCallId() {
        return margincall.getMarginCallId();
    }

    @Override
    public String getProductFamily() {
        return margincall.getProductFamily();
    }
}
