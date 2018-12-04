package calypsox.bug;

import org.concordion.api.FullOGNL;
import org.concordion.api.extension.Extensions;
import org.concordion.ext.EmbedExtension;
import org.concordion.ext.TimestampFormatterExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import calypsox.bug.infra.AATEngines;

/**
 * The Class AatTest.
 */
@RunWith(ConcordionRunner.class)
@FullOGNL
@Extensions({ EmbedExtension.class, TimestampFormatterExtension.class })
public class CalypsoAAT {

	/** The Constant DEFAULT_WAIT_INTERVAL. */
	private static final long DEFAULT_WAIT_INTERVAL = 200;

	/** The Constant DEFAULT_CHECK_TIMES. */
	private static final int DEFAULT_CHECK_TIMES = 200;

	public int waitForEngine(final String engine) throws InterruptedException {
		return waitForEngine(engine, DEFAULT_WAIT_INTERVAL, DEFAULT_CHECK_TIMES);
	}

	/**
	 * Wait engine.
	 *
	 * @param engineName
	 *            the engine name
	 * @param millis
	 *            the millis
	 * @param times
	 *            the times
	 * @return number of pending events
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public int waitForEngine(final String engineName, final long millis, final int times) throws InterruptedException {
		return new AATEngines().waitForEngine(engineName, millis, times);
	}
}
