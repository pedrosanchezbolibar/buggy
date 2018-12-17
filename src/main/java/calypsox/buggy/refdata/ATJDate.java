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

    /** The jdate. */
    private final JDate jdate;

    /**
     * Instantiates a new ATJ date.
     */
    public ATJDate() {
        jdate = JDate.getNow();
    }

    /**
     * Instantiates a new ATJ date.
     *
     * @param date
     *            the date
     */
    public ATJDate(final JDate date) {
        jdate = date;
    }

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
        final Tenor tenor = Tenor.valueOf(tenorString.replace("+", ""));
        return jdate.addBusinessDays(tenor.getCode(), holidays);
    }

    /**
     * To sched task runner format.
     *
     * @return the string
     */
    public String toSchedTaskRunnerFormat() {
        final StringBuilder str = new StringBuilder();
        str.append(jdate.getMonth());
        str.append('/');
        str.append(jdate.getDayOfMonth());
        str.append('/');
        str.append(jdate.getYear() - 1900);
        return str.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return toString(jdate);
    }

    /**
     * To string.
     *
     * @param jdate
     *            the jdate
     * @return the string
     */
    public String toString(final JDate jdate) {
        final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_PATTERN);
        return formatter.format(jdate.getDate(TimeZone.getDefault()));
    }

    /**
     * To string.
     *
     * @param jdate
     *            the jdate
     * @param pattern
     *            the pattern
     * @param timeZone
     *            the time zone
     * @return the string
     */
    public String toString(final JDate jdate, final String pattern, final TimeZone timeZone) {
        final SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(jdate.getDate(timeZone));
    }

    /**
     * To string.
     *
     * @param jdate
     *            the jdate
     * @param timeZone
     *            the time zone
     * @return the string
     */
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString(final JDate jdate, final TimeZone timeZone) {
        final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_PATTERN);
        return formatter.format(jdate.getDate(timeZone));
    }
}
