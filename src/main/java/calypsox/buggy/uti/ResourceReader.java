package calypsox.buggy.uti;

import java.io.InputStream;
import java.net.URL;

/**
 * The Class ResourceReader.
 */
public class ResourceReader {

	/**
	 * Gets the resource as stream.
	 *
	 * @param resource
	 *            the resource
	 * @return the resource as stream
	 */
	public InputStream getResourceAsStream(final String resource) {
		final InputStream in = getContextClassLoader().getResourceAsStream(resource);

		return in == null ? getClass().getResourceAsStream(resource) : in;
	}

	/**
	 * Gets the resource.
	 *
	 * @param resource
	 *            the resource
	 * @return the resource
	 */
	public URL getResource(final String resource) {
		return getContextClassLoader().getResource(resource);
	}

	/**
	 * Gets the context class loader.
	 *
	 * @return the context class loader
	 */
	public ClassLoader getContextClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

}
