package calypsox.buggy.refdata;

import java.util.List;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDate;
import com.calypso.tk.refdata.NettingMethod;
import com.calypso.tk.service.DSConnection;

/**
 * Encapsulates and format the information of a netting method
 */
public class ATNettingMethod {

    /** The nettingmethod. */
    private final NettingMethod nettingmethod;

    /**
     * Instantiates a new AT netting method.
     *
     * @param nettingMethodId
     *            the netting method id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATNettingMethod(final int nettingMethodId) throws CalypsoServiceException {
        nettingmethod = DSConnection.getDefault().getRemoteReferenceData().getNettingMethod(nettingMethodId);
    }

    /**
     * Gets the auth name.
     *
     * @return the auth name
     */
    public String getAuthName() {
        return nettingmethod.getAuthName();
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return nettingmethod.getCurrency();
    }

    /**
     * Gets the effective from.
     *
     * @return the effective from
     */
    public JDate getEffectiveFrom() {
        return nettingmethod.getEffectiveFrom();
    }

    /**
     * Gets the effective to.
     *
     * @return the effective to
     */
    public JDate getEffectiveTo() {
        return nettingmethod.getEffectiveTo();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return nettingmethod.getId();
    }

    /**
     * Gets the LE audit tag.
     *
     * @return the LE audit tag
     */
    public String getLEAuditTag() {
        return nettingmethod.getLEAuditTag();
    }

    /**
     * Gets the legal entity.
     *
     * @return the legal entity
     */
    public ATLegalEntity getLegalEntity() {
        return new ATLegalEntity(nettingmethod.getLegalEntityId());
    }

    /**
     * Gets the legal entity role.
     *
     * @return the legal entity role
     */
    public String getLegalEntityRole() {
        return nettingmethod.getLegalEntityRole();
    }

    /**
     * Gets the netting group.
     *
     * @return the netting group
     */
    public int getNettingGroup() {
        return nettingmethod.getNettingGroup();
    }

    /**
     * Gets the netting type.
     *
     * @return the netting type
     */
    public String getNettingType() {
        return nettingmethod.getNettingType();
    }

    /**
     * Gets the original product type list.
     *
     * @return the original product type list
     */
    @SuppressWarnings("unchecked")
    public List<String> getOriginalProductTypeList() {
        return nettingmethod.getOriginalProductTypeList();
    }

    /**
     * Gets the processing org.
     *
     * @return the processing org
     */
    public ATLegalEntity getProcessingOrg() {
        return new ATLegalEntity(nettingmethod.getProcessingOrgId());
    }

    /**
     * Gets the processing org based.
     *
     * @return the processing org based
     */
    public ATLegalEntity getProcessingOrgBased() {
        return new ATLegalEntity(nettingmethod.getProcessingOrgBasedId());
    }

    /**
     * Gets the product type list.
     *
     * @return the product type list
     */
    @SuppressWarnings("unchecked")
    public List<String> getProductTypeList() {
        return nettingmethod.getProductTypeList();
    }

    /**
     * Gets the settle method.
     *
     * @return the settle method
     */
    public String getSettleMethod() {
        return nettingmethod.getSettleMethod();
    }

    /**
     * Gets the static data filter.
     *
     * @return the static data filter
     */
    public String getStaticDataFilter() {
        return nettingmethod.getStaticDataFilter();
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public String getUser() {
        return nettingmethod.getUser();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
        return nettingmethod.getVersion();
    }
}
