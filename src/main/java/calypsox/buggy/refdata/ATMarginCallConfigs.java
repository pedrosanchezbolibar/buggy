package calypsox.buggy.refdata;

import java.util.ArrayList;
import java.util.List;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.LegalEntity;
import com.calypso.tk.refdata.MarginCallConfig;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.RemoteReferenceData;

/**
 * Retrieve and manage information for MarginCallConfig.
 */
public class ATMarginCallConfigs {

    /** The instance. */
    private static ATMarginCallConfigs instance;

    /**
     * Gets the single instance of ATMarginCallConfigs.
     *
     * @return single instance of ATMarginCallConfigs
     */
    public static synchronized ATMarginCallConfigs getInstance() {
        if (instance == null) {
            instance = new ATMarginCallConfigs();
        }
        return instance;
    }

    /**
     * Instantiates a new AT margin call configs.
     */
    private ATMarginCallConfigs() {
        // prevent to instantiate this class
    }

    /**
     * Gets the contracts between PO and cpty.
     *
     * @param procOrgName
     *            the processing organization name
     * @param cptyName
     *            the counterparty name
     * @return the contracts
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    @SuppressWarnings("unchecked")
    public List<ATMarginCallConfig> getContracts(final String procOrgName, final String cptyName)
            throws CalypsoServiceException {
        final RemoteReferenceData remoteRefData = DSConnection.getDefault().getRemoteReferenceData();
        final LegalEntity cpty = remoteRefData.getLegalEntity(cptyName);
        final LegalEntity prOrg = remoteRefData.getLegalEntity(procOrgName);

        final List<MarginCallConfig> contracts = remoteRefData.getAllMarginCallConfig(prOrg.getId(), cpty.getId());

        return toATMarginCallConfigList(contracts);

    }

    /**
     * To AT margin call config list.
     *
     * @param contracts
     *            the contracts
     * @return the list
     */
    private List<ATMarginCallConfig> toATMarginCallConfigList(final List<MarginCallConfig> contracts) {
        final List<ATMarginCallConfig> info = new ArrayList<ATMarginCallConfig>(contracts.size());
        for (final MarginCallConfig contract : contracts) {
            info.add(new ATMarginCallConfig(contract));
        }
        return info;
    }
}
