package calypsox.buggy.refdata;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.core.LegalEntity;
import com.calypso.tk.service.DSConnection;

public class ATLegalEntity {
    private final LegalEntity legalentity;

    public ATLegalEntity(final int entityId) {
	legalentity = BOCache.getLegalEntity(DSConnection.getDefault(), entityId);
    }

    public ATLegalEntity(final LegalEntity entity) {
	legalentity = entity;
    }

    @Override
    public String toString() {
	if (legalentity == null) {
	    return "null";
	}
	return legalentity.toString();
    }
}
