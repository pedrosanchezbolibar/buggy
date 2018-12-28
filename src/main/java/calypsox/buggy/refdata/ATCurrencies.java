package calypsox.buggy.refdata;

import com.calypso.tk.core.CalypsoServiceException;

/**
 * Retrieve and manage Currencies and CurrencyDefaults.
 */
public class ATCurrencies {

    /**
     * Gets the ATCurrency
     *
     * @param ccyCode
     *            the ccy code
     * @return the AT currency
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATCurrency get(final String ccyCode) throws CalypsoServiceException {
        return new ATCurrency(ccyCode);
    }

}
