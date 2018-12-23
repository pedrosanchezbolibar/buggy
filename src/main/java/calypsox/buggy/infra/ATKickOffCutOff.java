package calypsox.buggy.infra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.calypso.tk.bo.workflow.KickOffCutOffConfig;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.Log;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.RemoteBackOffice;

/**
 * Manipulate KickOff and CutOff.
 */
public class ATKickOffCutOff {

    /** The original ko co by ccy. */
    private static Map<String, KickOffCutOffConfig> originalKoCoByCcy = new HashMap<>();

    /**
     * Modify kick off for a list of currencies.
     *
     * @param currencies
     *            the currencies which kick off must be updated
     * @param strTime
     *            the kickOff time in format hh:mm
     * @throws CalypsoServiceException
     *             the calypso service exception
     * @throws CloneNotSupportedException
     *             the clone not supported exception
     */
    public void modifyKickOff(final List<String> currencies, final String strTime)
            throws CalypsoServiceException, CloneNotSupportedException {
        final RemoteBackOffice remote = DSConnection.getDefault().getRemoteBackOffice();
        final Map<KickOffCutOffConfig, KickOffCutOffConfig> kocoConfigMap = remote.getKickOffCutOffConfig();
        for (final KickOffCutOffConfig kocoConfig : kocoConfigMap.keySet()) {
            final String kocoCcy = kocoConfig.getCurrency();
            if (currencies.contains(kocoCcy)) {
                addConfigIfNotStored(kocoConfig, kocoCcy);
            }
            final int newTime = getTime(strTime);
            if (kocoConfig.getKickOffTime() != newTime) {
                final KickOffCutOffConfig clonedKocoConfig = (KickOffCutOffConfig) kocoConfig.clone();
                clonedKocoConfig.setKickOffTime(newTime);
                remote.save(clonedKocoConfig);
                Log.info(this, "KickOff for ccy " + kocoCcy + " has been updated to " + strTime);
            } else {
                Log.info(this, "KickOff for ccy " + kocoCcy + " is already setup to " + strTime);
            }
        }
    }

    /**
     * Restore all kick off.
     *
     * @throws CloneNotSupportedException
     *             the clone not supported exception
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public void restoreAllKickOff() throws CloneNotSupportedException, CalypsoServiceException {
        for (final KickOffCutOffConfig aConfig : originalKoCoByCcy.values()) {
            final KickOffCutOffConfig clonedConfig = (KickOffCutOffConfig) aConfig.clone();
            DSConnection.getDefault().getRemoteBackOffice().save(clonedConfig);
            Log.info(this, "KickOff for ccy " + clonedConfig.getCurrency() + " has been restored to "
                    + clonedConfig.getKickOffTime());
        }
    }

    /**
     * Adds the config if not stored.
     *
     * @param kocoConfig
     *            the koco config
     * @param kocoCcy
     *            the koco ccy
     */
    private void addConfigIfNotStored(final KickOffCutOffConfig kocoConfig, final String kocoCcy) {
        final KickOffCutOffConfig originalKoCo = originalKoCoByCcy.get(kocoCcy);
        if (originalKoCo == null) {
            originalKoCoByCcy.put(kocoCcy, kocoConfig);
        }
    }

    /**
     * Gets the time.
     *
     * @param strTime
     *            the str time
     * @return the time
     */
    private int getTime(final String strTime) {
        return Integer.parseInt(strTime.replaceAll(":", ""));
    }
}
