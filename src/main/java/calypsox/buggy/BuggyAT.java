package calypsox.buggy;

import java.util.Properties;

import org.concordion.api.FullOGNL;
import org.concordion.api.extension.Extensions;
import org.concordion.ext.EmbedExtension;
import org.concordion.ext.TimestampFormatterExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.calypso.tk.util.ConnectException;

import calypsox.buggy.infra.ATEngines;
import calypsox.buggy.uti.CalypsoEnvironment;

/**
 * Parent class for all tests fixtures.
 */
@RunWith(ConcordionRunner.class)
@FullOGNL
@Extensions({ EmbedExtension.class, TimestampFormatterExtension.class })
public class BuggyAT extends BuggyVersion {

    /** The Constant DEFAULT_WAIT_INTERVAL. */
    private static final long DEFAULT_WAIT_INTERVAL = 200;

    /** The Constant DEFAULT_CHECK_TIMES. */
    private static final int DEFAULT_CHECK_TIMES = 200;

    private final Properties testProperties;

    @BeforeClass
    public static void init() throws ConnectException {
	CalypsoEnvironment.getInstance().connect();
	CalypsoEnvironment.getInstance().insertFullTestDataSet();
    }

    public BuggyAT() {
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
	return new ATEngines().waitForEngine(engine, DEFAULT_WAIT_INTERVAL, DEFAULT_CHECK_TIMES);
    }

}
