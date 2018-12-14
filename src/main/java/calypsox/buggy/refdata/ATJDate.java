package calypsox.buggy.refdata;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.calypso.tk.core.JDate;

public class ATJDate {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    private final JDate jdate;

    private final TimeZone timeZone;

    public ATJDate(final JDate date) {
        jdate = date;
        timeZone = TimeZone.getDefault();
    }

    public ATJDate(final JDate date, final String timeZoneId) {
        jdate = date;
        if (timeZoneId == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = TimeZone.getTimeZone(timeZoneId);
        }
    }

    public String toString(final String pattern) {
        final SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(jdate.getDate(timeZone));
    }

    @Override
    public String toString() {
        final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_PATTERN);
        return formatter.format(jdate.getDate(timeZone));
    }
}
