package calypsox.buggy.xfer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.LegalEntity;
import com.calypso.tk.refdata.SettleDeliveryInstruction;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.RemoteReferenceData;

/**
 * Search and manipulate Calypso SDIs.
 */
public class ATSdis {

    /** The instance. */
    private static ATSdis instance;

    /** The Constant BENEFICIARY_FIELD. */
    private static final String BENEFICIARY_FIELD = "bene_le = ";

    /**
     * Gets the single instance of ATSdis.
     *
     * @return single instance of ATSdis
     */
    public static synchronized ATSdis getInstance() {
        if (instance == null) {
            instance = new ATSdis();
        }
        return instance;
    }

    /**
     * Instantiates a new AT sdis.
     */
    private ATSdis() {
        // prevent to instantiate this class
    }

    /**
     * Gets the sdi using the reference.
     *
     * @param reference
     *            the reference
     * @return the AT sdi
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATSdi get(final String reference) throws CalypsoServiceException {
        return new ATSdi(reference);
    }

    /**
     * Gets the SDI is by beneficiary.
     *
     * @param legalEntityName
     *            the legal entity name
     * @return the SD is by beneficiary
     * @throws CalypsoServiceException
     *             the remote exception
     */
    @SuppressWarnings("unchecked")
    public List<ATSdi> getSDIsByBeneficiary(final String legalEntityName) throws CalypsoServiceException {
        final LegalEntity legalEntity = DSConnection.getDefault().getRemoteReferenceData()
                .getLegalEntity(legalEntityName);
        final String where = BENEFICIARY_FIELD + legalEntity.getId();
        final List<SettleDeliveryInstruction> sdis = DSConnection.getDefault().getRemoteReferenceData()
                .getSettleDeliveryInstructions(where);
        return getSdisOrdered(sdis);
    }

    /**
     * Gets the SDI is by beneficiary and ccy.
     *
     * @param legalEntityName
     *            the legal entity name
     * @param currency
     *            the currency
     * @return the SD is by beneficiary
     * @throws CalypsoServiceException
     *             the remote exception
     */
    @SuppressWarnings("unchecked")
    public List<ATSdi> getSDIsByBeneficiaryAndCcy(final String legalEntityName, final String currency)
            throws CalypsoServiceException {
        final LegalEntity legalEntity = DSConnection.getDefault().getRemoteReferenceData()
                .getLegalEntity(legalEntityName);

        final StringBuilder where = new StringBuilder(BENEFICIARY_FIELD);
        where.append(legalEntity.getId());
        where.append(" AND currency_list LIKE '%").append(currency).append("%'");

        final List<SettleDeliveryInstruction> sdis = DSConnection.getDefault().getRemoteReferenceData()
                .getSettleDeliveryInstructions(where.toString());

        return getSdisOrdered(sdis);
    }

    /**
     * Removes the SD is by beneficiary.
     *
     * @param legalEntityName
     *            the legal entity name
     * @return true, if successful
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    @SuppressWarnings("unchecked")
    public boolean removeSDIsByBeneficiary(final String legalEntityName) throws CalypsoServiceException {
        final LegalEntity legalEntity = DSConnection.getDefault().getRemoteReferenceData()
                .getLegalEntity(legalEntityName);
        final String where = BENEFICIARY_FIELD + legalEntity.getId();
        final RemoteReferenceData remote = DSConnection.getDefault().getRemoteReferenceData();
        final List<SettleDeliveryInstruction> sdis = remote.getSettleDeliveryInstructions(where);
        boolean result = true;
        for (final SettleDeliveryInstruction sdi : sdis) {
            result = remote.remove(sdi) && result;
        }
        return result;
    }

    /**
     * Gets the sdis ordered.
     *
     * @param sdis
     *            the sdis
     * @return the sdis ordered
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    private List<ATSdi> getSdisOrdered(final List<SettleDeliveryInstruction> sdis) throws CalypsoServiceException {
        final List<ATSdi> result = new ArrayList<>(sdis.size());

        Collections.sort(sdis, new SDIComparator());

        for (final SettleDeliveryInstruction sdi : sdis) {
            result.add(new ATSdi(sdi));
        }

        return result;
    }
}
