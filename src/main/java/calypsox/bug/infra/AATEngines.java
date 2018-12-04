package calypsox.bug.infra;

import java.util.Enumeration;
import java.util.Hashtable;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.Log;
import com.calypso.tk.core.SerializationException;
import com.calypso.tk.event.ESStarter;
import com.calypso.tk.event.PSConnection;
import com.calypso.tk.event.PSEventEngineRequest;
import com.calypso.tk.event.PSException;
import com.calypso.tk.event.PSSubscriber;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.ConnectException;

/**
 * Manage calypso engines.
 */
public class AATEngines {

	/**
	 * Restart an engine
	 *
	 * @param engineName
	 *            the engine name
	 * @param wait
	 *            time in milliseconds between stop an start the engine
	 * @throws InterruptedException
	 *             the interrupted exception
	 * @throws ConnectException
	 *             the connect exception
	 * @throws PSException
	 *             the PS exception
	 * @throws SerializationException
	 *             the serialization exception
	 */
	public void restart(final String engineName, final long wait)
			throws InterruptedException, ConnectException, PSException, SerializationException {
		final PSEventEngineRequest ad = new PSEventEngineRequest();
		ad.setType(PSEventEngineRequest.SUSPEND);
		ad.setMessage(engineName);
		final PSConnection psConnection = ESStarter.startConnection((PSSubscriber) null, (Class[]) null);
		psConnection.publish(ad);

		Thread.sleep(wait);

		ad.setType(PSEventEngineRequest.REQUEST_RESTART);
		psConnection.publish(ad);
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
		int count = 0;
		for (int i = 0; i < times; i++) {
			count = countPendingProcessing(DSConnection.getDefault(), engineName);
			if (count == 0) {
				return 0;
			}
			Thread.sleep(millis);
		}
		return count;
	}

	/**
	 * Count pending processing.
	 *
	 * @param ds
	 *            the ds
	 * @param engineName
	 *            the engine name
	 * @return the int
	 */
	private int countPendingProcessing(final DSConnection ds, final String engineName) {
		Hashtable<String, Integer> h;
		try {
			h = ds.getRemoteAccess().getPendingProcessingCount(engineName);

			if (h == null || h.size() == 0) {
				return 0;
			}

			int count = 0;
			final Enumeration<Integer> e = h.elements();
			while (e.hasMoreElements()) {
				final Integer it = e.nextElement();
				if (it.intValue() > 0) {
					count += it.intValue();
				}
			}
			return count;

		} catch (final CalypsoServiceException exception) {
			Log.error(this, exception);
			return -1;
		}
	}

}
