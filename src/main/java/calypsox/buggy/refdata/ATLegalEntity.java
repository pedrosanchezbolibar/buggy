package calypsox.buggy.refdata;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.core.LegalEntity;
import com.calypso.tk.service.DSConnection;

/**
 * The Class ATLegalEntity.
 */
public class ATLegalEntity {

    /** The legalentity. */
    private final LegalEntity legalentity;

    /**
     * Instantiates a new AT legal entity.
     *
     * @param entityId
     *            the entity id
     */
    public ATLegalEntity(final int entityId) {
        if (entityId == 0) {
            legalentity = createAnyLE();
        } else {
            legalentity = BOCache.getLegalEntity(DSConnection.getDefault(), entityId);
        }
    }

    /**
     * Instantiates a new AT legal entity.
     *
     * @param entity
     *            the entity
     */
    public ATLegalEntity(final LegalEntity entity) {
        if (entity == null) {
            legalentity = createAnyLE();
        } else {
            legalentity = entity;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        if (legalentity == null) {
            return "null";
        }
        return legalentity.toString();
    }

    /**
     * Creates the any LE.
     *
     * @return the legal entity
     */
    private LegalEntity createAnyLE() {
        final LegalEntity legalEntity = new LegalEntity();
        legalEntity.setCode("ANY");
        legalEntity.setName("ANY");
        return legalEntity;
    }
}
