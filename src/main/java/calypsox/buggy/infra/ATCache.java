package calypsox.buggy.infra;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.LocalCache;

/**
 * Clear and manipulates the Calypso Cache.
 */
public class ATCache {

    /**
     * Clear the specific cache plus BOCache and LocalCache.
     *
     * @param cache
     *            the cache
     * @throws CalypsoServiceException
     *             the Calypso service exception
     */
    public void clearCache(final String cache) throws CalypsoServiceException {
        DSConnection.getDefault().getRemoteAccess().clearCache(cache);
        DSConnection.getDefault().getRemoteBackOffice().clearCache();
        BOCache.clear();
        LocalCache.clear();
    }
}
