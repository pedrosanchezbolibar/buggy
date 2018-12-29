package calypsox.buggy.uti;

/**
 * The Class References.
 */
public class References {

    /** The Constant PREFIX. */
    private static final String PREFIX = "Test-";
    /** The Constant START_TIMESTAMP. */
    public static final long START_TIMESTAMP = 1483488000000L;

    /** The instance. */
    private static References instance;

    /**
     * Gets the single instance of References.
     *
     * @return single instance of References
     */
    public static synchronized References getInstance() {
        if (instance == null) {
            instance = new References();
        }
        return instance;
    }

    /**
     * Instantiates a new references.
     */
    private References() {
        // prevent to instantiate this class
    }

    /**
     * Generate external reference.
     *
     * @return the string
     */
    public String generateExternalRef() {
        return PREFIX + (System.currentTimeMillis() - START_TIMESTAMP);
    }
}
