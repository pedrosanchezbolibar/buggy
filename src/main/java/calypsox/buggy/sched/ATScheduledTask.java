package calypsox.buggy.sched;

import com.calypso.apps.startup.StartQuartzTaskRunner;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.mo.TradeFilter;
import com.calypso.tk.scheduling.service.RemoteSchedulingService;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.ScheduledTask;

import calypsox.buggy.product.ATTrade;
import calypsox.buggy.uti.AvoidSystemExitSecurityManager;
import calypsox.buggy.uti.CalypsoEnvironment;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * Execute a Scheduled task using StartQuartzTaskRunner.
 * </p>
 *
 * <p>
 * StartQuartzTaskRunner have the following parameters
 * </p>
 * <ul>
 * <li>-currDate – Execution date. Format: mm/dd/yy</li>
 * <li>–env – Environment properties file to be run with.</li>
 * <li>–log – To write to the log file.</li>
 * <li>–password – Password of the user.</li>
 * <li>–task – Task ID given by the system when the scheduled task is
 * configured. You can view the task IDs in the Scheduled Task Definition and
 * Scheduling window.</li>
 * <li>-taskExtRef – Task external reference given by the user. It is the
 * recommended approach as it is a business key that is consistent across
 * systems.</li>
 * <li>–user – User name who runs the scheduled task.</li>
 * <li>-valTime – Execution time. Format: HHMM (HH is in 24 hour format).</li>
 */
public class ATScheduledTask {

    /** The scheduled task. */
    private ScheduledTask scheduledTask;

    /** The temp trade filter. */
    private TradeFilter tempTradeFilter;

    /** The old trade filter. */
    private String oldTradeFilter;

    /**
     * Instantiates a new AT scheduled task.
     *
     * @param task
     *            the task
     */
    public ATScheduledTask(final ScheduledTask task) {
        scheduledTask = task;
    }

    /**
     * Instantiates a new AT scheduled task.
     *
     * @param externalReference
     *            the external reference
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATScheduledTask(final String externalReference) throws CalypsoServiceException {
        scheduledTask = load(externalReference);
    }

    /**
     * Creates the params.
     *
     * @param valDate
     *            the val date
     * @return the string[]
     */
    private String[] createParams(final String valDate) {

        final String[] params = new String[9];

        params[0] = "-nogui";
        params[1] = "-env";
        params[2] = CalypsoEnvironment.getInstance().getEnvName();
        params[3] = "-user";
        params[4] = CalypsoEnvironment.getInstance().getUser();
        params[5] = "-password";
        params[6] = CalypsoEnvironment.getInstance().getPassword();
        params[7] = "-taskExtRef";
        params[8] = scheduledTask.getExternalReference();

        return params;
    }

    /**
     * Creates the trade filter.
     *
     * @param trade
     *            the trade
     * @return the trade filter
     */
    private TradeFilter createTradeFilter(final ATTrade trade) {
        final TradeFilter tradeFilter = new TradeFilter();
        tradeFilter.setName("_Trade_" + trade.getId());
        tradeFilter.setSQLWhereClause("trade_id = " + trade.getId());
        return tradeFilter;
    }

    /**
     * Execute a Scheduled task.
     *
     * @param trade
     *            it this parameter is present, the Scheduled Task's trade filter
     *            will be temporally updated to add only this trade
     * @param valDate
     *            the valuation date in format yyyy-mm-dd
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public void execute(final ATTrade trade, final String valDate) throws CalypsoServiceException {
        if (trade != null) {
            final TradeFilter tradeFilter = createTradeFilter(trade);
            replaceTradeFilter(tradeFilter);
        }
        final SecurityManager prevSecManager = System.getSecurityManager();
        System.setSecurityManager(new AvoidSystemExitSecurityManager());
        try {
            StartQuartzTaskRunner.main(createParams(valDate));
        } catch (final SecurityException ex) {
            // please, don't write to log.
        }
        System.setSecurityManager(prevSecManager);

        if (trade != null) {
            restoreTradeFilter();
        }
    }

    /**
     * Execute a Scheduled Task.
     *
     * @param valDate
     *            the valuation date
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public void execute(final String valDate) throws CalypsoServiceException {
        execute(null, valDate);
    }

    /**
     * Load.
     *
     * @param extRef
     *            the ext ref
     * @return the scheduled task
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    private ScheduledTask load(final String extRef) throws CalypsoServiceException {
        final DSConnection dscon = DSConnection.getDefault();
        final RemoteSchedulingService service = dscon.getService(RemoteSchedulingService.class);
        final ScheduledTask schedTask = service.getScheduledTaskByExternalReference(extRef);
        if (schedTask == null) {
            throw new IllegalArgumentException(
                    "Can't retrieve a scheduled task with external referernce = '" + extRef + "'");
        }
        return schedTask;
    }

    /**
     * Reload.
     *
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public void reload() throws CalypsoServiceException {
        scheduledTask = load(scheduledTask.getExternalReference());
    }

    /**
     * Replace trade filter in a ScheduledTask. This method will save the trade
     * filter and the Scheduled task. To revert the change use the
     * restoreTradeFilter method
     *
     * @param tradeFilter
     *            the trade filter
     * @throws CalypsoServiceException
     *             the remote exception
     */
    private void replaceTradeFilter(final TradeFilter tradeFilter) throws CalypsoServiceException {
        tempTradeFilter = tradeFilter;

        final DSConnection dscon = DSConnection.getDefault();
        final RemoteSchedulingService service = dscon.getService(RemoteSchedulingService.class);
        dscon.getRemoteReferenceData().saveTradeFilter(tradeFilter);
        oldTradeFilter = scheduledTask.getTradeFilter();
        scheduledTask.setTradeFilter(tradeFilter.getName());
        service.save(scheduledTask);

        reload();
    }

    /**
     * Restore trade filter.
     *
     * @throws CalypsoServiceException
     *             the remote exception
     */
    private void restoreTradeFilter() throws CalypsoServiceException {
        final DSConnection dscon = DSConnection.getDefault();
        final RemoteSchedulingService service = dscon.getService(RemoteSchedulingService.class);
        reload();
        scheduledTask.setTradeFilter(oldTradeFilter);
        service.save(scheduledTask);
        dscon.getRemoteReferenceData().remove(tempTradeFilter);
    }
}
