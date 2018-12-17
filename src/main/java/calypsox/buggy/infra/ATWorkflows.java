package calypsox.buggy.infra;

import com.calypso.tk.bo.TaskWorkflowConfig;
import com.calypso.tk.core.Action;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.Status;
import com.calypso.tk.service.DSConnection;

/**
 * Manipulate Calypso Workflows
 */
public class ATWorkflows {

    /**
     * Adds an Action between two statuses. This can be useful to skip some
     * validations or ko/co
     *
     * @param fromStatus
     *            from status
     * @param action
     *            action to include
     * @param toStatus
     *            to status
     * @param eventClass
     *            wf type (PSEventMessage, ...)
     * @param productType
     *            the product type
     * @param wfSubType
     *            wf subtype (PAPERCONFIRM, ...)
     * @return OK if everything was fine
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public int addManualAction(final String fromStatus, final String action, final String toStatus, final String eventClass,
            final String productType, final String wfSubType) throws CalypsoServiceException {
        final TaskWorkflowConfig taskWfConfig = new TaskWorkflowConfig();
        taskWfConfig.setId(9999);
        taskWfConfig.setVersion(1);
        taskWfConfig.setStatus(Status.valueOf(fromStatus));
        taskWfConfig.setPossibleAction(Action.valueOf(action));
        taskWfConfig.setComment("AT Action");
        taskWfConfig.setProductType(productType);
        taskWfConfig.setType(wfSubType);
        taskWfConfig.setEventClass(eventClass);
        taskWfConfig.setResultingStatus(Status.valueOf(toStatus));
        taskWfConfig.setUseSTPB(false);

        return DSConnection.getDefault().getRemoteBackOffice().save(taskWfConfig);
    }

    /**
     * delete action in a workflow
     *
     * @param transitionId
     *            transition to delete
     * @return OK if everything was fine
     * @throws CalypsoServiceException
     */
    public boolean deleteAction(final String transitionId) throws CalypsoServiceException {
        final TaskWorkflowConfig transitionToDelete = DSConnection.getDefault().getRemoteBackOffice()
                .getTaskWorkflowConfig(Integer.valueOf(transitionId));

        return DSConnection.getDefault().getRemoteBackOffice().remove(transitionToDelete);
    }
}
