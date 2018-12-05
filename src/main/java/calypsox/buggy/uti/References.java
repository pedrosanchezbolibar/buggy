package calypsox.buggy.uti;

/**
 * The Class References.
 */
public class References {

    /** The Constant PREFIX. */
    private static final String PREFIX = "Test-";
    /** The Constant START_TIMESTAMP. */
    public static final long START_TIMESTAMP = 1483488000000L;

    /**
     * Generate external reference
     *
     * @return the string
     */
    public String generateExternalRef() {
	return PREFIX + (System.currentTimeMillis() - START_TIMESTAMP);
    }
}
