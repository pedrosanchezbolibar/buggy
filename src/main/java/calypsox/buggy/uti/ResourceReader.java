package calypsox.buggy.uti;

import java.io.InputStream;
import java.net.URL;

/**
 * The Class ResourceReader.
 */
public class ResourceReader {

    /**
     * Gets the context class loader.
     *
     * @return the context class loader
     */
    public ClassLoader getContextClassLoader() {
	return Thread.currentThread().getContextClassLoader();
    }

    /**
     * Gets the resource.
     *
     * @param resource the resource
     * @return the resource
     */
    public URL getResource(final String resource) {
	return getContextClassLoader().getResource(resource);
    }

    /**
     * Gets the resource as stream.
     *
     * @param owner the owner
     * @param resource the resource
     * @return the resource as stream
     */
    public InputStream getResourceAsStream(final Object owner, final String resource) {
	InputStream result = getResourceAsStream("", resource);
	if (result == null) {
	    final String classname = owner.getClass().getName().replace("Fixture", "");
	    String base = replaceDots(classname);
	    result = getResourceAsStream(base, resource);
	    if (result == null) {
		base = replaceDots(owner.getClass().getPackage().getName() + "/data");
		result = getResourceAsStream(base, resource);
	    }
	}

	return result;
    }

    /**
     * Gets the resource as stream.
     *
     * @param base the base
     * @param resource the resource
     * @return the resource as stream
     */
    private InputStream getResourceAsStream(final String base, final String resource) {
	String fullPath;
	if ("".equals(base)) {
	    fullPath = resource;
	} else {
	    fullPath = base + '/' + resource;
	}
	InputStream stream = getContextClassLoader().getResourceAsStream(fullPath);

	if (stream == null) {
	    stream = getClass().getResourceAsStream(fullPath);
	}
	return stream;
    }

    /**
     * Replace dots.
     *
     * @param pkgname the pkgname
     * @return the string
     */
    private String replaceDots(final String pkgname) {
	return pkgname.replace('.', '/');
    }

}
