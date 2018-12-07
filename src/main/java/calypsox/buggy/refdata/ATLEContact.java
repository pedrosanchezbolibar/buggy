package calypsox.buggy.refdata;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.refdata.LEContact;
import com.calypso.tk.service.DSConnection;

public class ATLEContact {
    LEContact lecontact;

    public ATLEContact(final int contactId) {
	lecontact = BOCache.getLegalEntityContact(DSConnection.getDefault(), contactId);
    }
}
