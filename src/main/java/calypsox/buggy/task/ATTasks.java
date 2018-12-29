package calypsox.buggy.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.calypso.tk.bo.Task;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.TaskArray;

import calypsox.buggy.msg.ATMessage;
import calypsox.buggy.product.ATTrade;
import calypsox.buggy.xfer.ATTransfer;

/**
 * Retrieve and manipulate Calypso Tasks.
 */
public class ATTasks {

    /** The Constant ORDER_BY. */
    private static final String ORDER_BY = "event_type, int_reference, object_status, comments, task_status, task_id";

    /** The instance. */
    private static ATTasks instance;

    /**
     * Gets the single instance of ATTasks.
     *
     * @return single instance of ATTasks
     */
    public static synchronized ATTasks getInstance() {
        if (instance == null) {
            instance = new ATTasks();
        }
        return instance;
    }

    /**
     * Instantiates a new AT tasks.
     */
    private ATTasks() {
        // prevent to instantiate this class
    }

    /**
     * Gets the non completed tasks.
     *
     * @param trade
     *            the trade
     * @return the non completed tasks
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getNonCompletedTasks(final ATTrade trade) throws CalypsoServiceException {
        return getTasks(trade, false);
    }

    /**
     * Gets the non completed tasks.
     *
     * @param xfer
     *            the xfer
     * @return the non completed tasks
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getNonCompletedTasks(final ATTransfer xfer) throws CalypsoServiceException {
        return getTasks(xfer, false);
    }

    /**
     * Gets the non completed tasks by event type.
     *
     * @param trade
     *            the trade
     * @param eventTypes
     *            the event types
     * @return the non completed tasks by event type
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getNonCompletedTasksByEventTypes(final ATTrade trade, final List<String> eventTypes)
            throws CalypsoServiceException {
        return getTasksByEventTypes(trade, eventTypes, false);
    }

    /**
     * Gets the tasks.
     *
     * @param msg
     *            the msg
     * @param includeCompleted
     *            the include completed
     * @return the tasks
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasks(final ATMessage msg, final boolean includeCompleted) throws CalypsoServiceException {
        final String where = String.format("event_class = 'PSEventMessage' and object_id = %d", msg.getId());
        return getTasksFromDS(where, includeCompleted);
    }

    /**
     * Get non completed tasks associated to the trade with external reference
     * ordered by event type.
     *
     * @param trade
     *            the trade
     * @param includeCompleted
     *            the include completed
     * @return trade tasks list
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasks(final ATTrade trade, final boolean includeCompleted) throws CalypsoServiceException {
        final String where = String.format("trade_id = %d", trade.getId());
        return getTasksFromDS(where, includeCompleted);
    }

    /**
     * Gets the tasks.
     *
     * @param xfer
     *            the xfer
     * @param includeCompleted
     *            the include completed
     * @return the tasks
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasks(final ATTransfer xfer, final boolean includeCompleted) throws CalypsoServiceException {
        final String where = String.format("event_class = 'PSEventTransfer' and object_id = %d", xfer.getId());
        return getTasksFromDS(where, includeCompleted);
    }

    /**
     * Gets the trade tasks by event type and int reference.
     *
     * @param trade
     *            the trade
     * @param eventTypes
     *            the event types
     * @param internalReference
     *            the internal reference
     * @param includeCompleted
     *            the include completed
     * @return the trade tasks by event type and int reference
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasksByEventTypeAndIntReference(final ATTrade trade, final List<String> eventTypes,
            final String internalReference, final boolean includeCompleted) throws CalypsoServiceException {
        final String where = String.format("trade_id = %d and event_type in ('%s') and internal_reference = '%s'",
                trade.getId(), StringUtils.join(eventTypes, "','"), internalReference);
        return getTasksFromDS(where, includeCompleted);
    }

    /**
     * Gets the tasks by event types.
     *
     * @param msg
     *            the msg
     * @param eventTypes
     *            the event types
     * @param includeCompleted
     *            the include completed
     * @return the tasks by event types
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasksByEventTypes(final ATMessage msg, final List<String> eventTypes,
            final boolean includeCompleted) throws CalypsoServiceException {
        final String where = String.format("event_class = 'PSEventMessage' and object_id = %d and event_type in ('%s')",
                msg.getId(), StringUtils.join(eventTypes, "','"));
        return getTasksFromDS(where, includeCompleted);
    }

    /**
     * Gets the trade task by event type.
     *
     * @param trade
     *            the trade
     * @param eventTypes
     *            the event type
     * @param includeCompleted
     *            the include completed
     * @return the trade task by event type
     * @throws CalypsoServiceException
     *             the remote exception
     */
    public List<ATTask> getTasksByEventTypes(final ATTrade trade, final List<String> eventTypes,
            final boolean includeCompleted) throws CalypsoServiceException {
        final String where = String.format("trade_id = %d and event_type in ('%s')", trade.getId(),
                StringUtils.join(eventTypes, "','"));
        return getTasksFromDS(where, includeCompleted);
    }

    /**
     * Gets the tasks by event types.
     *
     * @param xfer
     *            the xfer
     * @param eventTypes
     *            the event types
     * @param includeCompleted
     *            the include completed
     * @return the tasks by event types
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasksByEventTypes(final ATTransfer xfer, final List<String> eventTypes,
            final boolean includeCompleted) throws CalypsoServiceException {
        final String where = String.format(
                "event_class = 'PSEventTransfer' and object_id = %d and event_type in ('%s')", xfer.getId(),
                StringUtils.join(eventTypes, "','"));
        return getTasksFromDS(where, includeCompleted);
    }

    /**
     * Gets the tasks by object status.
     *
     * @param trade
     *            the trade
     * @param status
     *            the status
     * @param includeCompleted
     *            the include completed
     * @return the tasks by object status
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTask> getTasksByObjectStatus(final ATTrade trade, final String status, final boolean includeCompleted)
            throws CalypsoServiceException {
        final String where = String.format("trade_id = %d and object_status = '%s'", trade.getId(), status);
        return getTasksFromDS(where, includeCompleted);
    }

    /**
     * Creates the tasks.
     *
     * @param tasks
     *            the tasks
     * @return the list
     */
    private List<ATTask> createTasks(final TaskArray tasks) {
        final List<ATTask> tradeTasks = new ArrayList<>();
        for (final Task task : tasks) {
            tradeTasks.add(new ATTask(task));
        }
        return tradeTasks;
    }

    /**
     * Gets the tasks from DS.
     *
     * @param where
     *            the where
     * @param includeCompleted
     *            the include completed
     * @return the tasks from DS
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    private List<ATTask> getTasksFromDS(final String where, final boolean includeCompleted)
            throws CalypsoServiceException {
        String whereClause = where;
        if (!includeCompleted) {
            whereClause = where + " and task_status != " + Task.COMPLETED;
        }
        final TaskArray tasks = DSConnection.getDefault().getRemoteBackOffice().getTasks(whereClause, null, ORDER_BY);
        return createTasks(tasks);
    }
}
