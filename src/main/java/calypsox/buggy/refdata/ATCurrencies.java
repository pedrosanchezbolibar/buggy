/*
 *
 */
package calypsox.buggy.refdata;

import com.calypso.tk.core.CalypsoServiceException;

/**
 * Retrieve and manage Currencies and CurrencyDefaults.
 */
public class ATCurrencies {

    /** The instance. */
    private static ATCurrencies instance;

    /**
     * Gets the single instance of ATCurrencies.
     *
     * @return single instance of ATCurrencies
     */
    public static synchronized ATCurrencies getInstance() {
        if (instance == null) {
            instance = new ATCurrencies();
        }
        return instance;
    }

    /**
     * Instantiates a new AT currencies.
     */
    private ATCurrencies() {
        // prevent to instantiate this class
    }

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
