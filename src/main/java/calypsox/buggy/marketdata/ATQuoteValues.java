package calypsox.buggy.marketdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.Util;
import com.calypso.tk.marketdata.QuoteValue;
import com.calypso.tk.service.DSConnection;

/**
 * The Class AATQuotes.
 */
public class ATQuoteValues {

    /** The instance. */
    private static ATQuoteValues instance;

    /**
     * Gets the single instance of ATQuoteValues.
     *
     * @return single instance of ATQuoteValues
     */
    public static synchronized ATQuoteValues getInstance() {
        if (instance == null) {
            instance = new ATQuoteValues();
        }
        return instance;
    }

    /** The uploaded quotes. */
    private final List<QuoteValue> uploadedQuotes;

    /**
     * Instantiates a new AT quote values.
     */
    private ATQuoteValues() {
        uploadedQuotes = new ArrayList<>();
    }

    /**
     * Change format date.
     *
     * @param date
     *            the date
     * @return the string
     */
    public String changeFormatDate(final JDate date) {

        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String result = "";

        result = sdf.format(date.getDate(TimeZone.getDefault()));

        return result;
    }

    /**
     * Delete previously uploaded quotes.
     *
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the remote exception
     */
    public boolean deleteUploadedQuotes() throws CalypsoServiceException {
        boolean result = true;
        for (final QuoteValue quote : uploadedQuotes) {
            result &= DSConnection.getDefault().getRemoteMarketData().remove(quote);
        }
        return result;
    }

    /**
     * Gets the quote.
     *
     * @param quoteSet
     *            the quote set
     * @param quoteName
     *            the quote name
     * @param quoteDate
     *            the quote date
     * @return the quote
     * @throws CalypsoServiceException
     *             the remote exception
     */
    @SuppressWarnings("unchecked")
    public ATQuoteValue getQuote(final String quoteSet, final String quoteName, final String quoteDate)
            throws CalypsoServiceException {
        ATQuoteValue result = null;

        if (!Util.isEmpty(quoteName)) {
            final List<QuoteValue> quotes = DSConnection.getDefault().getRemoteMarketData()
                    .getQuoteValues("quote_name = '" + quoteName + "' AND quote_set_name = '" + quoteSet + "'"
                            + " AND quote_date = to_date('" + quoteDate + "','dd/MM/yyyy')");

            if (!Util.isEmpty(quotes)) {
                result = new ATQuoteValue(quotes.get(0));
            }
        }

        return result;
    }

    /**
     * Gets the quote.
     *
     * @param quoteDate
     *            the quote date in format dd/MM/yyyy
     * @param quoteNames
     *            the quote names
     * @return the quote
     * @throws CalypsoServiceException
     *             the remote exception
     */
    @SuppressWarnings("unchecked")
    public List<ATQuoteValue> getQuotes(final String quoteDate, final List<String> quoteNames)
            throws CalypsoServiceException {
        final String where = String.format("quote_name in ('%s') AND quote_date = to_date('%s', 'dd/MM/yyyy')",
                StringUtils.join(quoteNames, "','"), quoteDate);

        final List<QuoteValue> quotes = DSConnection.getDefault().getRemoteMarketData().getQuoteValues(where);

        return createQuotes(quotes);
    }

    /**
     * Upload a quote.
     *
     * @param quoteSet
     *            the quote set
     * @param quoteName
     *            the quote name
     * @param date
     *            the date in format dd/MM/yyyy
     * @param close
     *            the close
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the remote exception
     */
    public boolean uploadQuote(final String quoteSet, final String quoteName, final String date, final String close)
            throws CalypsoServiceException {
        final QuoteValue quote = new QuoteValue();
        quote.setName(quoteName);
        quote.setClose(Double.parseDouble(close));
        quote.setDate(getJDate(date));
        quote.setQuoteSetName(quoteSet);
        uploadedQuotes.add(quote);

        return DSConnection.getDefault().getRemoteMarketData().save(quote);
    }

    /**
     * Creates the quotes.
     *
     * @param quotes
     *            the quotes
     * @return the list
     */
    private List<ATQuoteValue> createQuotes(final List<QuoteValue> quotes) {
        final List<ATQuoteValue> result = new ArrayList<>(quotes.size());
        for (final QuoteValue quote : quotes) {
            result.add(new ATQuoteValue(quote));
        }
        return result;
    }

    /**
     * Gets the jdate.
     *
     * @param date
     *            the date
     * @return the j date
     */
    private JDate getJDate(final String date) {
        final String[] fields = date.split("/");
        final int day = Integer.parseInt(fields[0]);
        final int month = Integer.parseInt(fields[1]);
        final int year = Integer.parseInt(fields[2]);

        return JDate.valueOf(year, month, day);
    }
}
