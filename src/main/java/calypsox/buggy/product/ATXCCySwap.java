package calypsox.buggy.product;

import java.util.List;

import com.calypso.tk.core.Trade;
import com.calypso.tk.product.SwapLeg;
import com.calypso.tk.product.XCCySwap;
import com.calypso.tk.refdata.FXReset;

/**
 * The Class ATXCCySwap.
 */
public class ATXCCySwap extends ATTrade {

    /** The xccyswap. */
    private final XCCySwap xccyswap;

    /**
     * Instantiates a new ATXC cy swap.
     *
     * @param trade
     *            the trade
     */
    public ATXCCySwap(final Trade trade) {
        super(trade);
        xccyswap = (XCCySwap) trade.getProduct();
    }

    /**
     * Gets the adjust first flow B.
     *
     * @return the adjust first flow B
     */
    public boolean getAdjustFirstFlowB() {
        return xccyswap.getAdjustFirstFlowB();
    }

    /**
     * Gets the default FX reset B.
     *
     * @return the default FX reset B
     */
    public boolean getDefaultFXResetB() {
        return xccyswap.getDefaultFXResetB();
    }

    /**
     * Gets the FX quote name.
     *
     * @return the FX quote name
     */
    public String getFXQuoteName() {
        return xccyswap.getFXQuoteName();
    }

    /**
     * Gets the fx reset.
     *
     * @return the fx reset
     */
    public FXReset getFxReset() {
        return xccyswap.getFxReset();
    }

    /**
     * Gets the FX reset.
     *
     * @return the FX reset
     */
    public FXReset getFXReset() {
        return xccyswap.getFXReset();
    }

    /**
     * Gets the FX reset B.
     *
     * @return the FX reset B
     */
    public boolean getFXResetB() {
        return xccyswap.getFXResetB();
    }

    /**
     * Gets the FX reset holidays.
     *
     * @return the FX reset holidays
     */
    public List getFXResetHolidays() {
        return xccyswap.getFXResetHolidays();
    }

    /**
     * Gets the FX reset offset.
     *
     * @return the FX reset offset
     */
    public int getFXResetOffset() {
        return xccyswap.getFXResetOffset();
    }

    /**
     * Gets the non principal adjustment leg.
     *
     * @return the non principal adjustment leg
     */
    public SwapLeg getNonPrincipalAdjustmentLeg() {
        return xccyswap.getNonPrincipalAdjustmentLeg();
    }

    /**
     * Gets the pay side FX reset B.
     *
     * @return the pay side FX reset B
     */
    public boolean getPaySideFXResetB() {
        return xccyswap.getPaySideFXResetB();
    }

    /**
     * Gets the principal adjustment leg.
     *
     * @return the principal adjustment leg
     */
    public SwapLeg getPrincipalAdjustmentLeg() {
        return xccyswap.getPrincipalAdjustmentLeg();
    }

    /**
     * Gets the principal adjustment leg id.
     *
     * @return the principal adjustment leg id
     */
    public int getPrincipalAdjustmentLegId() {
        return xccyswap.getPrincipalAdjustmentLegId();
    }

    /**
     * Gets the reset price.
     *
     * @return the reset price
     */
    public double getResetPrice() {
        return xccyswap.getResetPrice();
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return xccyswap.getType();
    }

    /**
     * Gets the use index reset date B.
     *
     * @return the use index reset date B
     */
    public boolean getUseIndexResetDateB() {
        return xccyswap.getUseIndexResetDateB();
    }
}
