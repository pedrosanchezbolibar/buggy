package calypsox.buggy.xfer;

import com.calypso.tk.core.CalypsoServiceException;

/**
 * Search Calypso SDIs
 */
public class ATSdis {

    /**
     * Gets the sdi using the reference
     *
     * @param reference
     *            the reference
     * @return the AT sdi
     * @throws CalypsoServiceException
     */
    public ATSdi get(final String reference) throws CalypsoServiceException {
        return new ATSdi(reference);
    }
}
