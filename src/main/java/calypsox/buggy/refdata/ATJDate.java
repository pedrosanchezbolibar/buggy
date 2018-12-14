package calypsox.buggy.refdata;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.calypso.tk.core.JDate;

public class ATJDate {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    private final JDate jdate;

    private final String pattern;

    private final TimeZone timeZone;

    public ATJDate(final JDate date) {
        jdate = date;
        pattern = DEFAULT_PATTERN;
        timeZone = TimeZone.getDefault();
    }

    public ATJDate(final JDate date, final String pattern) {
        jdate = date;
        this.pattern = pattern;
        timeZone = TimeZone.getDefault();
    }

    public ATJDate(final JDate date, final String pattern, final String timeZone) {
        jdate = date;
        this.pattern = pattern;
        this.timeZone = TimeZone.getTimeZone(timeZone);
    }

    @Override
    public String toString() {
        final SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(jdate.getDate(timeZone));
    }
}
