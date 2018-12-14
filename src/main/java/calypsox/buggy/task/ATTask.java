package calypsox.buggy.task;

import java.util.Map;
import java.util.Vector;

import com.calypso.tk.bo.Task;
import com.calypso.tk.bo.util.ProcessTaskUtil.ObjectDesc;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.Status;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.product.ATTrade;
import calypsox.buggy.refdata.ATBook;
import calypsox.buggy.refdata.ATJDate;
import calypsox.buggy.refdata.ATLegalEntity;

/**
 * The Class ATTask.
 */
public class ATTask {

    /** The task. */
    private final Task task;

    /**
     * Instantiates a new AT task.
     *
     * @param taskId
     *            the task id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTask(final long taskId) throws CalypsoServiceException {
        task = DSConnection.getDefault().getRemoteBackOffice().getTask(taskId);
    }

    /**
     * Instantiates a new AT task.
     *
     * @param task
     *            the task
     */
    public ATTask(final Task task) {
        this.task = task;
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public double getAmount() {
        return task.getAmount();
    }

    /**
     * Gets the attribute.
     *
     * @return the attribute
     */
    public String getAttribute() {
        return task.getAttribute();
    }

    /**
     * Gets the book.
     *
     * @return the book
     */
    public ATBook getBook() {
        return new ATBook(task.getBookId());
    }

    /**
     * Gets the bundle id.
     *
     * @return the bundle id
     */
    public int getBundleId() {
        return task.getBundleId();
    }

    /**
     * Gets the chasing id.
     *
     * @return the chasing id
     */
    public int getChasingId() {
        return task.getChasingId();
    }

    /**
     * Gets the chasing order id.
     *
     * @return the chasing order id
     */
    public int getChasingOrderId() {
        return task.getChasingOrderId();
    }

    /**
     * Gets the comment.
     *
     * @return the comment
     */
    public String getComment() {
        String comment = task.getComment();
        if (comment == null) {
            comment = "";
        }
        return comment;
    }

    /**
     * Gets the completed datetime.
     *
     * @return the completed datetime
     */
    public JDatetime getCompletedDatetime() {
        return task.getCompletedDatetime();
    }

    /**
     * Gets the cost.
     *
     * @return the cost
     */
    public double getCost() {
        return task.getCost();
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return task.getCurrency();
    }

    /**
     * Gets the cut off datetime.
     *
     * @return the cut off datetime
     */
    public JDatetime getCutOffDatetime() {
        return task.getCutOffDatetime();
    }

    /**
     * Gets the datetime.
     *
     * @return the datetime
     */
    public JDatetime getDatetime() {
        return task.getDatetime();
    }

    /**
     * Gets the enrichment fields values.
     *
     * @return the enrichment fields values
     */
    public Object[] getEnrichmentFieldsValues() {
        return task.getEnrichmentFieldsValues();
    }

    /**
     * Gets the event class.
     *
     * @return the event class
     */
    public String getEventClass() {
        return task.getEventClass();
    }

    /**
     * Gets the event type.
     *
     * @return the event type
     */
    public String getEventType() {
        return task.getEventType();
    }

    /**
     * Gets the generic comment B.
     *
     * @return the generic comment B
     */
    public boolean getGenericCommentB() {
        return task.getGenericCommentB();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
        return task.getId();
    }

    /**
     * Gets the internal reference.
     *
     * @return the internal reference
     */
    public String getInternalReference() {
        return task.getInternalReference();
    }

    /**
     * Gets the kick off cut off id.
     *
     * @return the kick off cut off id
     */
    public int getKickOffCutOffId() {
        return task.getKickOffCutOffId();
    }

    /**
     * Gets the kick off datetime.
     *
     * @return the kick off datetime
     */
    public JDatetime getKickOffDatetime() {
        return task.getKickOffDatetime();
    }

    /**
     * Gets the last process datetime.
     *
     * @return the last process datetime
     */
    public JDatetime getLastProcessDatetime() {
        return task.getLastProcessDatetime();
    }

    /**
     * Gets the legal entity.
     *
     * @return the legal entity
     */
    public ATLegalEntity getLegalEntity() {
        return new ATLegalEntity(task.getLegalEntityId());
    }

    /**
     * Gets the link task.
     *
     * @return the link task
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTask getLinkTask() throws CalypsoServiceException {
        return new ATTask(task.getLinkId());
    }

    /**
     * Gets the market location.
     *
     * @return the market location
     */
    public String getMarketLocation() {
        return task.getMarketLocation();
    }

    /**
     * Gets the new datetime.
     *
     * @return the new datetime
     */
    public JDatetime getNewDatetime() {
        return task.getNewDatetime();
    }

    /**
     * Gets the next priority.
     *
     * @return the next priority
     */
    public int getNextPriority() {
        return task.getNextPriority();
    }

    /**
     * Gets the next priority datetime.
     *
     * @return the next priority datetime
     */
    public JDatetime getNextPriorityDatetime() {
        return task.getNextPriorityDatetime();
    }

    /**
     * Gets the object class name.
     *
     * @return the object class name
     */
    public String getObjectClassName() {
        return task.getObjectClassName();
    }

    /**
     * Gets the object date.
     *
     * @return the object date
     */
    public ATJDate getObjectDate() {
        return new ATJDate(task.getObjectDate());
    }

    /**
     * Gets the object desc.
     *
     * @return the object desc
     */
    public ObjectDesc getObjectDesc() {
        return task.getObjectDesc();
    }

    /**
     * Gets the object id.
     *
     * @return the object id
     */
    public long getObjectId() {
        return task.getObjectLongId();
    }

    /**
     * Gets the object status.
     *
     * @return the object status
     */
    public Status getObjectStatus() {
        return task.getObjectStatus();
    }

    /**
     * Gets the owner.
     *
     * @return the owner
     */
    public String getOwner() {
        return task.getOwner();
    }

    /**
     * Gets the previous cut off datetime.
     *
     * @return the previous cut off datetime
     */
    public JDatetime getPreviousCutOffDatetime() {
        return task.getPreviousCutOffDatetime();
    }

    /**
     * Gets the previous kick off datetime.
     *
     * @return the previous kick off datetime
     */
    public JDatetime getPreviousKickOffDatetime() {
        return task.getPreviousKickOffDatetime();
    }

    /**
     * Gets the previous user.
     *
     * @return the previous user
     */
    public String getPreviousUser() {
        return task.getPreviousUser();
    }

    /**
     * Gets the priority.
     *
     * @return the priority
     */
    public int getPriority() {
        return task.getPriority();
    }

    /**
     * Gets the priority as string.
     *
     * @return the priority as string
     */
    public String getPriorityAsString() {
        return task.getPriorityAsString();
    }

    /**
     * Gets the priority domain.
     *
     * @return the priority domain
     */
    public Vector getPriorityDomain() {
        return task.getPriorityDomain();
    }

    /**
     * Gets the priority id.
     *
     * @return the priority id
     */
    public int getPriorityId() {
        return task.getPriorityId();
    }

    /**
     * Gets the priority max.
     *
     * @return the priority max
     */
    public int getPriorityMax() {
        return task.getPriorityMax();
    }

    /**
     * Gets the processing org.
     *
     * @return the processing org
     */
    public ATLegalEntity getProcessingOrg() {
        return new ATLegalEntity(task.getPoId());
    }

    /**
     * Gets the product id.
     *
     * @return the product id
     */
    public int getProductId() {
        return task.getProductId();
    }

    /**
     * Gets the settlement method.
     *
     * @return the settlement method
     */
    public String getSettlementMethod() {
        return task.getSettlementMethod();
    }

    /**
     * Gets the status as string.
     *
     * @return the status as string
     */
    public String getStatus() {
        return task.getStatusAsString();
    }

    /**
     * Gets the status domain.
     *
     * @return the status domain
     */
    public Vector getStatusDomain() {
        return task.getStatusDomain();
    }

    /**
     * Gets the task workflow config id.
     *
     * @return the task workflow config id
     */
    public int getTaskWorkflowConfigId() {
        return task.getTaskWorkflowConfigId();
    }

    /**
     * Gets the trade.
     *
     * @return the trade
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTrade getTrade() throws CalypsoServiceException {
        return new ATTrade(task.getTradeId());
    }

    /**
     * Gets the trade version.
     *
     * @return the trade version
     */
    public int getTradeVersion() {
        return task.getTradeVersion();
    }

    /**
     * Gets the transient book.
     *
     * @return the transient book
     */
    public ATBook getTransientBook() {
        return new ATBook(task.getTransientBook());
    }

    /**
     * Gets the underlying objects.
     *
     * @return the underlying objects
     */
    public Map getUnderlyingObjects() {
        return task.getUnderlyingObjects();
    }

    /**
     * Gets the under processing datetime.
     *
     * @return the under processing datetime
     */
    public JDatetime getUnderProcessingDatetime() {
        return task.getUnderProcessingDatetime();
    }

    /**
     * Gets the undo trade datetime.
     *
     * @return the undo trade datetime
     */
    public JDatetime getUndoTradeDatetime() {
        return task.getUndoTradeDatetime();
    }

    /**
     * Gets the user comment.
     *
     * @return the user comment
     */
    public String getUserComment() {
        return task.getUserComment();
    }

    /**
     * Gets the user lock B.
     *
     * @return the user lock B
     */
    public boolean getUserLockB() {
        return task.getUserLockB();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
        return task.getVersion();
    }

    /**
     * Gets the workflow type.
     *
     * @return the workflow type
     */
    public String getWorkflowType() {
        return task.getWorkflowType();
    }
}
