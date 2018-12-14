package calypsox.buggy.refdata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDate.DateComponents;
import com.calypso.tk.core.JDatetime;

/**
 * Access and format JDate objects
 */
public class ATJDate {

    /** The Constant DEFAULT_PATTERN. */
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    /** The jdate. */
    private final JDate jdate;

    /** The time zone. */
    private final TimeZone timeZone;

    /**
     * Instantiates a new ATJ date.
     */
    public ATJDate() {
        jdate = JDate.getNow();
        timeZone = TimeZone.getDefault();
    }

    /**
     * Instantiates a new ATJ date.
     *
     * @param date
     *            the date
     */
    public ATJDate(final JDate date) {
        jdate = date;
        timeZone = TimeZone.getDefault();
    }

    /**
     * Instantiates a new ATJ date.
     *
     * @param date
     *            the date
     * @param timeZoneId
     *            the time zone id
     */
    public ATJDate(final JDate date, final String timeZoneId) {
        jdate = date;
        if (timeZoneId == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = TimeZone.getTimeZone(timeZoneId);
        }
    }

    /**
     * To string.
     *
     * @param pattern
     *            the pattern
     * @return the string
     */
    public String toString(final String pattern) {
        final SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(jdate.getDate(timeZone));
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_PATTERN);
        return formatter.format(jdate.getDate(timeZone));
    }

    public Date getDate() {
        return jdate.getDate();
    }

    public JDatetime getJDatetime() {
        return jdate.getJDatetime();
    }

    public long getJulian() {
        return jdate.getJulian();
    }

    public DateComponents getDateFields() {
        return jdate.getDateFields();
    }

    public int getYear() {
        return jdate.getYear();
    }

    public int getMonth() {
        return jdate.getMonth();
    }

    public int getDayOfMonth() {
        return jdate.getDayOfMonth();
    }

    public int getDayOfWeek() {
        return jdate.getDayOfWeek();
    }

    public String getDayOfWeekAsString() {
        return jdate.getDayOfWeekAsString();
    }

    public int getDayOfYear() {
        return jdate.getDayOfYear();
    }

    public int getMonthLength() {
        return jdate.getMonthLength();
    }

    public ATJDate getEOM() {
        return new ATJDate(jdate.getEOM());
    }

    public int getJulianOffset() {
        return jdate.getJulianOffset();
    }

    public ATJDate getEOQ() {
        return new ATJDate(jdate.getEOQ());
    }

    public ATJDate getBOQ() {
        return new ATJDate(jdate.getBOQ());
    }

}
