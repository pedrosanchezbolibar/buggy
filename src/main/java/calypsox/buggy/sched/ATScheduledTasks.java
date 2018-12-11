package calypsox.buggy.sched;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.scheduling.service.RemoteSchedulingService;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.ScheduledTask;

/**
 * The Class ATScheduledTasks.
 */
public class ATScheduledTasks {

    /**
     * Gets the scheduled task.
     *
     * @param externalReference the external reference
     * @return the scheduled task
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATScheduledTask getScheduledTask(final String externalReference) throws CalypsoServiceException {
	final DSConnection dscon = DSConnection.getDefault();
	final RemoteSchedulingService service = dscon.getService(RemoteSchedulingService.class);
	final ScheduledTask scheduledTask = service.getScheduledTaskByExternalReference(externalReference);
	return new ATScheduledTask(scheduledTask);
    }

    public void executeScheduledTask(final String externalReference) throws CalypsoServiceException {
	final ATScheduledTask task = getScheduledTask(externalReference);
	task.execute();
    }
}
