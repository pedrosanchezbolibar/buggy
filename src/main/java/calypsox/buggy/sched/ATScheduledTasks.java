package calypsox.buggy.sched;

import com.calypso.tk.core.CalypsoServiceException;

/**
 * The Class ATScheduledTasks.
 */
public class ATScheduledTasks {

    /**
     * Gets the scheduled task.
     *
     * @param externalReference
     *            the external reference
     * @return the scheduled task
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATScheduledTask getScheduledTask(final String externalReference) throws CalypsoServiceException {
        return new ATScheduledTask(externalReference);
    }
}
