package calypsox.buggy.infra;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.LocalCache;

/**
 * Clear and manipulates the Calypso Cache.
 */
public class ATCache {

    /** The instance. */
    private static ATCache instance;

    /**
     * Gets the single instance of ATCache.
     *
     * @return single instance of ATCache
     */
    public static synchronized ATCache getInstance() {
        if (instance == null) {
            instance = new ATCache();
        }
        return instance;
    }

    /**
     * Instantiates a new AT cache.
     */
    private ATCache() {
        // prevent to instantiate this class
    }

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
