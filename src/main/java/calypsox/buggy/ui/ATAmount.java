package calypsox.buggy.ui;

import java.text.DecimalFormat;

import com.calypso.tk.refdata.CurrencyDefault;
import com.calypso.tk.service.LocalCache;

/**
 * Represent an amount with the corresponding currency. Using the toString()
 * method tThe number is represented with the number of decimals indicated in
 * the currency configuration.
 * <p>
 * Example: 1,000,000 USD
 * </p>
 */
public class ATAmount {

    /** The currency. */
    String currency;

    /** The value. */
    double value;

    /**
     * Instantiates a new AT amount.
     *
     * @param currency
     *            the currency
     * @param value
     *            the value
     */
    public ATAmount(final String currency, final double value) {
        super();
        this.currency = currency;
        this.value = value;
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        if (currency == null) {
            return "EMPTY";
        }
        int decimals = 2;
        final CurrencyDefault ccyDefault = LocalCache.getCurrencyDefault(currency);
        if (ccyDefault != null) {
            decimals = (int) ccyDefault.getRounding();
        }

        final DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(decimals);
        format.setMinimumFractionDigits(decimals);

        final StringBuilder builder = new StringBuilder();
        builder.append(format.format(value));
        builder.append(' ');
        builder.append(currency);
        return builder.toString();
    }

}
