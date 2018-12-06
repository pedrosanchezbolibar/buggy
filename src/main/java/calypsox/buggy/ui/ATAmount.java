package calypsox.buggy.ui;

import java.text.DecimalFormat;

import com.calypso.tk.refdata.CurrencyDefault;
import com.calypso.tk.service.LocalCache;

public class ATAmount {
    String currency;
    double value;

    public ATAmount(final String currency, final double value) {
	super();
	this.currency = currency;
	this.value = value;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
	return currency;
    }

    /**
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
