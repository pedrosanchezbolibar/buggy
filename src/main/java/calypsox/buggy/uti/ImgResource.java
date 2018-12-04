package calypsox.buggy.uti;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.calypso.tk.util.email.Base64;

/**
 * The Class ImgResource.
 */
public class ImgResource extends ResourceReader {
	private static String HTML = "<img src=\"data:image/gif;base64,%s\" />";

	private static String HTML_SIZE = "<img width=\"%s\" height=\"%s\" src=\"data:image/gif;base64,%s\" />";

	/**
	 * Gets the image.
	 *
	 * @param path
	 *            the path
	 * @return the image
	 * @throws IOException
	 */
	public String getImage(final String resource) throws IOException {
		return getImage(resource, null, null);
	}

	/**
	 * Gets the image.
	 *
	 * @param resource
	 *            the resource
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public String getImage(final String resource, final String width, final String height) throws IOException {
		final InputStream inputStream = getResourceAsStream(resource);

		if (inputStream == null) {
			throw new FileNotFoundException("[ERROR] No se ha podido cargar la imagen " + resource);
		} else {
			final byte[] bytes = IOUtils.toByteArray(inputStream);
			final String code = Base64.encodeBytes(bytes);
			if (width == null) {
				return String.format(HTML, code);
			} else {
				return String.format(HTML_SIZE, width, height, resource);
			}
		}
	}
}
