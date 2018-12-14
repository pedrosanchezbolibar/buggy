package calypsox.buggy.refdata;

import java.util.List;

import com.calypso.tk.core.JDate;
import com.calypso.tk.core.Tenor;

/**
 * Manage and calculate holidays.
 */
public class ATHolidays {

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
    public ATJDate calculateDateByTenor(final String tenorString, final List<String> holidays, final String timeZone) {
        JDate rstDate = JDate.getNow();
        final Tenor tenor = Tenor.valueOf(tenorString.replace("+", ""));
        rstDate = rstDate.addBusinessDays(tenor.getCode(), holidays);
        return new ATJDate(rstDate);
    }
}
