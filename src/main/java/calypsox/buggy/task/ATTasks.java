package calypsox.buggy.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.calypso.tk.bo.Task;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.TaskArray;

import calypsox.buggy.product.ATTrade;

public class ATTasks {

    /** The Constant ORDER_BY. */
    private static final String ORDER_BY = "event_type, int_reference, object_status, comments, task_status, task_id";

    /**
     * Gets the trade task by event type.
     *
     * @param externalReference
     *            the external reference
     * @param eventTypes
     *            the event type
     * @return the trade task by event type
     * @throws CalypsoServiceException
     *             the remote exception
     */
    public List<ATTask> getTasksByEventType(final ATTrade trade, final List<String> eventTypes)
            throws CalypsoServiceException {

        final String where = String.format("trade_id = %d and event_type in ('%s')", trade.getId(),
                StringUtils.join(eventTypes, "','"));

        final TaskArray tasks = DSConnection.getDefault().getRemoteBackOffice().getTasks(where, null, ORDER_BY);

        return createTasks(tasks);
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

}
