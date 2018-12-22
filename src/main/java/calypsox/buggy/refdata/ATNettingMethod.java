package calypsox.buggy.refdata;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.refdata.NettingMethod;
import com.calypso.tk.service.DSConnection;

public class ATNettingMethod {

    private final NettingMethod nettingmethod;

    public ATNettingMethod(final int nettingMethodId) throws CalypsoServiceException {
        nettingmethod = DSConnection.getDefault().getRemoteReferenceData().getNettingMethod(nettingMethodId);
    }

}
