package calypsox.buggy.refdata;

import java.util.Collection;
import java.util.List;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.bo.workflow.WorkFlowConfigKey;
import com.calypso.tk.core.EntityState;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.LegalEntity;
import com.calypso.tk.service.DSConnection;

/**
 * Encapsulate and format the information of a LegalEntity.
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

    /**
     * Gets the auth name.
     *
     * @return the auth name
     */
    public String getAuthName() {
        return legalentity.getAuthName();
    }

    /**
     * Gets the book.
     *
     * @return the book
     */
    public ATBook getBook() {
        return new ATBook(legalentity.getBook());
    }

    /**
     * Gets the classification.
     *
     * @return the classification
     */
    public boolean getClassification() {
        return legalentity.getClassification();
    }

    /**
     * Gets the comment.
     *
     * @return the comment
     */
    public String getComment() {
        return legalentity.getComment();
    }

    /**
     * Gets the common LE role list.
     *
     * @return the common LE role list
     */
    public List getCommonLERoleList() {
        return LegalEntity.getCommonLERoleList();
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return legalentity.getCountry();
    }

    /**
     * Gets the entered date.
     *
     * @return the entered date
     */
    public JDatetime getEnteredDate() {
        return legalentity.getEnteredDate();
    }

    /**
     * Gets the entered user.
     *
     * @return the entered user
     */
    public String getEnteredUser() {
        return legalentity.getEnteredUser();
    }

    /**
     * Gets the entity id.
     *
     * @return the entity id
     */
    public int getEntityId() {
        return legalentity.getEntityId();
    }

    /**
     * Gets the entity state.
     *
     * @return the entity state
     */
    public EntityState getEntityState() {
        return legalentity.getEntityState();
    }

    /**
     * Gets the entity type.
     *
     * @return the entity type
     */
    public String getEntityType() {
        return legalentity.getEntityType();
    }

    /**
     * Gets the external ref.
     *
     * @return the external ref
     */
    public String getExternalRef() {
        return legalentity.getExternalRef();
    }

    /**
     * Gets the holidays.
     *
     * @return the holidays
     */
    public List getHolidays() {
        return legalentity.getHolidays();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return legalentity.getId();
    }

    /**
     * Gets the inactive date.
     *
     * @return the inactive date
     */
    public JDate getInactiveDate() {
        return legalentity.getInactiveDate();
    }

    /**
     * Gets the legal entity attributes.
     *
     * @return the legal entity attributes
     */
    public Collection getLegalEntityAttributes() {
        return legalentity.getLegalEntityAttributes();
    }

    /**
     * Gets the long name.
     *
     * @return the long name
     */
    public String getLongName() {
        return legalentity.getName();
    }

    /**
     * Gets the parent.
     *
     * @return the parent
     */
    public ATLegalEntity getParent() {
        return new ATLegalEntity(legalentity.getParentId());
    }

    /**
     * Gets the processing org.
     *
     * @return the processing org
     */
    public ATLegalEntity getProcessingOrg() {
        return new ATLegalEntity(legalentity.getProcessingOrg());
    }

    /**
     * Gets the restricted role list.
     *
     * @return the restricted role list
     */
    public List getRestrictedRoleList() {
        return legalentity.getRestrictedRoleList();
    }

    /**
     * Gets the role list.
     *
     * @return the role list
     */
    public List getRoleList() {
        return legalentity.getRoleList();
    }

    /**
     * Gets the short name.
     *
     * @return the short name
     */
    public String getShortName() {
        return legalentity.getCode();
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return legalentity.getStatus();
    }

    /**
     * Gets the status domain.
     *
     * @return the status domain
     */
    public List getStatusDomain() {
        return LegalEntity.getStatusDomain();
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public String getUser() {
        return legalentity.getUser();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
        return legalentity.getVersion();
    }

    /**
     * Gets the workflow config key.
     *
     * @return the workflow config key
     */
    public WorkFlowConfigKey getWorkflowConfigKey() {
        return legalentity.getWorkflowConfigKey();
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
