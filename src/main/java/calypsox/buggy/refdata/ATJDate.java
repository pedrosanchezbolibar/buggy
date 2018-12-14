package calypsox.buggy.refdata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDate.DateComponents;
import com.calypso.tk.core.JDatetime;

/**
 * Access and format JDate objects.
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

    /**
     * Gets the date.
     *
     * @return the date
     */
    public Date getDate() {
        return jdate.getDate();
    }

    /**
     * Gets the j datetime.
     *
     * @return the j datetime
     */
    public JDatetime getJDatetime() {
        return jdate.getJDatetime();
    }

    /**
     * Gets the julian.
     *
     * @return the julian
     */
    public long getJulian() {
        return jdate.getJulian();
    }

    /**
     * Gets the date fields.
     *
     * @return the date fields
     */
    public DateComponents getDateFields() {
        return jdate.getDateFields();
    }

    /**
     * Gets the year.
     *
     * @return the year
     */
    public int getYear() {
        return jdate.getYear();
    }

    /**
     * Gets the month.
     *
     * @return the month
     */
    public int getMonth() {
        return jdate.getMonth();
    }

    /**
     * Gets the day of month.
     *
     * @return the day of month
     */
    public int getDayOfMonth() {
        return jdate.getDayOfMonth();
    }

    /**
     * Gets the day of week.
     *
     * @return the day of week
     */
    public int getDayOfWeek() {
        return jdate.getDayOfWeek();
    }

    /**
     * Gets the day of week as string.
     *
     * @return the day of week as string
     */
    public String getDayOfWeekAsString() {
        return jdate.getDayOfWeekAsString();
    }

    /**
     * Gets the day of year.
     *
     * @return the day of year
     */
    public int getDayOfYear() {
        return jdate.getDayOfYear();
    }

    /**
     * Gets the month length.
     *
     * @return the month length
     */
    public int getMonthLength() {
        return jdate.getMonthLength();
    }

    /**
     * Gets the eom.
     *
     * @return the eom
     */
    public ATJDate getEOM() {
        return new ATJDate(jdate.getEOM());
    }

    /**
     * Gets the julian offset.
     *
     * @return the julian offset
     */
    public int getJulianOffset() {
        return jdate.getJulianOffset();
    }

    /**
     * Gets the eoq.
     *
     * @return the eoq
     */
    public ATJDate getEOQ() {
        return new ATJDate(jdate.getEOQ());
    }

    /**
     * Gets the boq.
     *
     * @return the boq
     */
    public ATJDate getBOQ() {
        return new ATJDate(jdate.getBOQ());
    }

}
