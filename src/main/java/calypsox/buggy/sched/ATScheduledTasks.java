package calypsox.buggy.sched;

import com.calypso.tk.core.CalypsoServiceException;

/**
 * The Class ATScheduledTasks.
 */
public class ATScheduledTasks {

    /** The instance. */
    private static ATScheduledTasks instance;

    /**
     * Gets the single instance of ATScheduledTasks.
     *
     * @return single instance of ATScheduledTasks
     */
    public static synchronized ATScheduledTasks getInstance() {
        if (instance == null) {
            instance = new ATScheduledTasks();
        }
        return instance;
    }

    /**
     * Instantiates a new AT scheduled tasks.
     */
    private ATScheduledTasks() {
        // prevent to instantiate this class
    }

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
