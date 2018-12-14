package calypsox.buggy.refdata;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import com.calypso.tk.core.JDate;
import com.calypso.tk.core.Tenor;

/**
 * Manage and calculate holidays.
 */
public class ATJDate {

    /** The Constant DEFAULT_PATTERN. */
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    /**
     * Calculate date by Tenor.
     *
     * @param tenorString
     *            the tenor string
     * @param holidays
     *            the holidays
     * @param timeZone
     *            the time zone
     * @return the string
     */
    public JDate calculateDateByTenor(final String tenorString, final List<String> holidays, final String timeZone) {
        final JDate rstDate = JDate.getNow();
        final Tenor tenor = Tenor.valueOf(tenorString.replace("+", ""));
        return rstDate.addBusinessDays(tenor.getCode(), holidays);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString(final JDate jdate, final TimeZone timeZone) {
        final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_PATTERN);
        return formatter.format(jdate.getDate(timeZone));
    }

    /**
     * To string.
     *
     * @param pattern
     *            the pattern
     * @return the string
     */
    public String toString(final JDate jdate, final TimeZone timeZone, final String pattern) {
        final SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(jdate.getDate(timeZone));
    }
}
