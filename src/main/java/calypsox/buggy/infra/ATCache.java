package calypsox.buggy.infra;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.LocalCache;

public class ATCache {
    /**
     * Clear the especific cache plus BOCache and LocalCache.
     *
     * @throws RemoteException
     */
    public void clearCache(final String cache) throws CalypsoServiceException {
	DSConnection.getDefault().getRemoteAccess().clearCache(cache);
	DSConnection.getDefault().getRemoteBackOffice().clearCache();
	BOCache.clear();
	LocalCache.clear();
    }
}
