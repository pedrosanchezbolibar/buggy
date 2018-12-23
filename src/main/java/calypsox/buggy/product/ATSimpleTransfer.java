package calypsox.buggy.product;

import java.util.List;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.Product;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.SimpleTransfer;

import calypsox.buggy.refdata.ATLegalEntity;
import calypsox.buggy.ui.ATAmount;
import calypsox.buggy.xfer.ATTransfer;

/**
 * The Class ATSimpleTransfer.
 */
public class ATSimpleTransfer extends ATTrade {

    /** The bond. */
    private final SimpleTransfer simpletransfer;

    /**
     * Instantiates a new AT bond.
     *
     * @param trade
     *            the trade
     */
    public ATSimpleTransfer(final Trade trade) {
        super(trade);
        simpletransfer = (SimpleTransfer) trade.getProduct();
    }

    /**
     * Gets the available date.
     *
     * @return the available date
     */
    public JDate getAvailableDate() {
        return simpletransfer.getAvailableDate();
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return simpletransfer.getCountry();
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return simpletransfer.getCurrency();
    }

    /**
     * Gets the currency cash.
     *
     * @return the currency cash
     */
    public String getCurrencyCash() {
        return simpletransfer.getCurrencyCash();
    }

    /**
     * Gets the DAP cash amount.
     *
     * @return the DAP cash amount
     */
    public ATAmount getDAPCashAmount() {
        return new ATAmount(simpletransfer.getCurrencyCash(), simpletransfer.getDAPCashAmount());
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return simpletransfer.getDescription();
    }

    /**
     * Gets the flow type.
     *
     * @return the flow type
     */
    public String getFlowType() {
        return simpletransfer.getFlowType();
    }

    /**
     * Gets the checks if is DAP.
     *
     * @return the checks if is DAP
     */
    public boolean getIsDAP() {
        return simpletransfer.getIsDAP();
    }

    /**
     * Gets the checks if is pledge movement B.
     *
     * @return the checks if is pledge movement B
     */
    public boolean getIsPledgeMovementB() {
        return simpletransfer.getIsPledgeMovementB();
    }

    /**
     * Gets the checks if is return B.
     *
     * @return the checks if is return B
     */
    public boolean getIsReturnB() {
        return simpletransfer.getIsReturnB();
    }

    /**
     * Gets the issue paying agent.
     *
     * @return the issue paying agent
     */
    public ATLegalEntity getIssuePayingAgent() {
        return new ATLegalEntity(simpletransfer.getIssuePayingAgentId());
    }

    /**
     * Gets the issuer.
     *
     * @return the issuer
     */
    public ATLegalEntity getIssuer() {
        return new ATLegalEntity(simpletransfer.getIssuerId());
    }

    /**
     * Gets the linked id.
     *
     * @return the linked id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTransfer getLinkedId() throws CalypsoServiceException {
        return new ATTransfer(simpletransfer.getLinkedLongId());
    }

    /**
     * Gets the orderer le.
     *
     * @return the orderer le
     */
    public ATLegalEntity getOrdererLe() {
        return new ATLegalEntity(simpletransfer.getOrdererLeId());
    }

    /**
     * Gets the orderer role.
     *
     * @return the orderer role
     */
    public String getOrdererRole() {
        return simpletransfer.getOrdererRole();
    }

    /**
     * Gets the principal amount.
     *
     * @return the principal amount
     */
    public ATAmount getPrincipalAmount() {
        return new ATAmount(simpletransfer.getCurrency(), simpletransfer.getPrincipal());
    }

    /**
     * Gets the product class.
     *
     * @return the product class
     */
    public String getProductClass() {
        return simpletransfer.getProductClass();
    }

    /*
     * (non-Javadoc)
     * 
     * @see calypsox.buggy.product.ATTrade#getProductFamily()
     */
    @Override
    public String getProductFamily() {
        return simpletransfer.getProductFamily();
    }

    /**
     * Gets the reference entities.
     *
     * @return the reference entities
     */
    public List getReferenceEntities() {
        return simpletransfer.getReferenceEntities();
    }

    /**
     * Gets the security.
     *
     * @return the security
     */
    public Product getSecurity() {
        return simpletransfer.getSecurity();
    }

    /**
     * Gets the security id.
     *
     * @return the security id
     */
    public int getSecurityId() {
        return simpletransfer.getSecurityId();
    }

    /**
     * Gets the sub type.
     *
     * @return the sub type
     */
    public String getSubType() {
        return simpletransfer.getSubType();
    }

    /**
     * Gets the underlying product.
     *
     * @return the underlying product
     */
    public Product getUnderlyingProduct() {
        return simpletransfer.getUnderlyingProduct();
    }

    /**
     * Gets the underlying security id.
     *
     * @return the underlying security id
     */
    public int getUnderlyingSecurityId() {
        return simpletransfer.getUnderlyingSecurityId();
    }
}
