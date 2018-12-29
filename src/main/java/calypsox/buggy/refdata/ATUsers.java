package calypsox.buggy.refdata;

import java.util.List;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.refdata.User;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.RemoteAccess;

/**
 * Search and manipulates Calypso Users.
 */
public class ATUsers {

    /** The instance. */
    private static ATUsers instance;

    /**
     * Gets the single instance of ATUsers.
     *
     * @return single instance of ATUsers
     */
    public static synchronized ATUsers getInstance() {
        if (instance == null) {
            instance = new ATUsers();
        }
        return instance;
    }

    /**
     * Instantiates a new AT users.
     */
    private ATUsers() {
        // prevent to instantiate this class
    }

    /**
     * Gets an user belonging to a list of groups.
     *
     * @param groups
     *            relevant groups
     * @return user_name
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public String getUserName(final List<String> groups) throws CalypsoServiceException {
        String userSelected = "";
        final RemoteAccess remoteAccess = DSConnection.getDefault().getRemoteAccess();

        final List<String> userNames = remoteAccess.getUserNames();

        boolean found = false;
        for (int i = 0; i < userNames.size() && !found; i++) {
            final String userName = userNames.get(i);
            final User user = remoteAccess.getUser(userName);

            if (isValidUser(user, groups)) {
                userSelected = userName;
                found = true;
            }
        }

        return userSelected;
    }

    /**
     * Checks if is valid user.
     *
     * @param user
     *            the user
     * @param groups
     *            the groups
     * @return true, if is valid user
     */
    @SuppressWarnings("unchecked")
    private boolean isValidUser(final User user, final List<String> groups) {
        return !user.getName().startsWith("ref_") && user.getGroups().containsAll(groups)
                && user.getAccountLockedDatetime() == null;
    }
}
