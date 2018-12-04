package calypsox.bug.uti;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Instantiate JAXBContext is time consuming. Therefore, they are instantiated
 * once only (or one by Thread if multithreading enabled)
 */
public class JAXBContextBinder {

	/** The map. */
	private final Map<String, JAXBContext> map;

	/**
	 * Instantiates a new jAXB context binder.
	 */
	private JAXBContextBinder() {
		map = new HashMap<String, JAXBContext>();
	}

	/**
	 * The Class LazyHolder.
	 */
	private static final class LazyHolder {

		/** The Constant INSTANCE. */
		private static final JAXBContextBinder INSTANCE = new JAXBContextBinder();

	}

	/**
	 * Gets the single INSTANCE of JAXBContextBinder.
	 *
	 * @return single INSTANCE of JAXBContextBinder
	 */
	public static JAXBContextBinder getInstance() {
		return LazyHolder.INSTANCE;
	}

	/**
	 * Gets the.
	 *
	 * @param packageName
	 *            the package name
	 * @return the jAXB context
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public JAXBContext get(final String packageName) throws JAXBException {
		JAXBContext context = map.get(packageName);
		if (context == null) {

			context = JAXBContext.newInstance(packageName);

			map.put(packageName, context);
		}
		return context;
	}

}
