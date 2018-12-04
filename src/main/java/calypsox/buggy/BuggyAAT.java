package calypsox.buggy;

import java.util.Properties;

import org.concordion.api.FullOGNL;
import org.concordion.api.extension.Extensions;
import org.concordion.ext.EmbedExtension;
import org.concordion.ext.TimestampFormatterExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import calypsox.buggy.infra.AATEngines;

/**
 * Parent class for all tests fixtures.
 */
@RunWith(ConcordionRunner.class)
@FullOGNL
@Extensions({ EmbedExtension.class, TimestampFormatterExtension.class })
public class BuggyAAT extends BuggyVersion {

    /** The Constant DEFAULT_WAIT_INTERVAL. */
    private static final long DEFAULT_WAIT_INTERVAL = 200;

    /** The Constant DEFAULT_CHECK_TIMES. */
    private static final int DEFAULT_CHECK_TIMES = 200;

    private final Properties testProperties;

    public BuggyAAT() {
	testProperties = new Properties();
    }

    public void setProperty(final String key, final String value) {
	testProperties.setProperty(key, value);
    }

    public String getProperty(final String key) {
	return testProperties.getProperty(key);
    }

    /**
     * Wait for engine.
     *
     * @param engine the engine
     * @return the int
     * @throws InterruptedException the interrupted exception
     */
    public int waitForEngine(final String engine) throws InterruptedException {
	return waitForEngine(engine, DEFAULT_WAIT_INTERVAL, DEFAULT_CHECK_TIMES);
    }

    /**
     * Wait engine.
     *
     * @param engineName the engine name
     * @param millis     the millis
     * @param times      the times
     * @return number of pending events
     * @throws InterruptedException the interrupted exception
     */
    public int waitForEngine(final String engineName, final long millis, final int times) throws InterruptedException {
	return new AATEngines().waitForEngine(engineName, millis, times);
    }

}
