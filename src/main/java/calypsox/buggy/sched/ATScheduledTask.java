package calypsox.buggy.sched;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.mo.TradeFilter;
import com.calypso.tk.scheduling.service.RemoteSchedulingService;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.ScheduledTask;

public class ATScheduledTask {

    private final ScheduledTask scheduledTask;
    private TradeFilter tempTradeFilter;
    private String oldTradeFilter;

    public ATScheduledTask(final ScheduledTask task) {
	scheduledTask = task;
    }

    /**
     * Replace trade filter in a ScheduledTask. This method will save the trade
     * filter and the Scheduled task. To revert the change use the
     * restoreTradeFilter method
     *
     * @param externalReference the external reference
     * @param tradeFilter       the trade filter
     * @throws CalypsoServiceException the remote exception
     */
    public void replaceTradeFilter(final String externalReference, final TradeFilter tradeFilter)
	    throws CalypsoServiceException {
	tempTradeFilter = tradeFilter;

	final DSConnection dscon = DSConnection.getDefault();
	final RemoteSchedulingService service = dscon.getService(RemoteSchedulingService.class);
	dscon.getRemoteReferenceData().saveTradeFilter(tradeFilter);
	oldTradeFilter = scheduledTask.getTradeFilter();
	scheduledTask.setTradeFilter(tradeFilter.getName());
	service.save(scheduledTask);
    }

    /**
     * Restore trade filter.
     *
     * @param externalReference the external reference
     * @throws CalypsoServiceException the remote exception
     */
    public void restoreTradeFilter(final String externalReference) throws CalypsoServiceException {
	final DSConnection dscon = DSConnection.getDefault();
	final RemoteSchedulingService service = dscon.getService(RemoteSchedulingService.class);
	scheduledTask.setTradeFilter(oldTradeFilter);
	service.save(scheduledTask);
	dscon.getRemoteReferenceData().remove(tempTradeFilter);
    }

    public void execute() {
	// TODO: ejecutar la tarea con el ScheduledTaskRunner de calypso
    }

}
