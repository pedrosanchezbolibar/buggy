package calypsox.buggy.uti;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.calypso.tk.util.email.Base64;

/**
 * Generate HTML code to embed the image into the test result.
 * <p>
 * The image file must be placed into the class path in a subfolder of test
 * package. It will be search in the following order:
 * </p>
 * <ol>
 * <li>A subfolder named as the test's html specification</li>
 * <li>A subfolder named 'data'</li>
 * </ol>
 * <p>
 * Example: a test specification called Test1.html placed in a folder
 * 'src/test/examples/'. The specification Test1.html uses a Test1.png image
 * which can be placed at:
 * </p>
 * <ol>
 * <li>'src/test/examples/Test1/Test1.png'</li>
 * <li>'src/test/examples/data/Test1.png'</li>
 * </ol>
 */
public class ImgResource extends ResourceReader {

    /** The Constant HTML. */
    private static final String HTML = "<img src=\"data:image/gif;base64,%s\" />";

    /** The Constant HTML_SIZE. */
    private static final String HTML_SIZE = "<img width=\"%s\" height=\"%s\" src=\"data:image/gif;base64,%s\" />";

    /**
     * Gets the image with real size.
     *
     * @param owner
     *            the owner
     * @param resource
     *            the resource
     * @return the image
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public String getImage(final Object owner, final String resource) throws IOException {
        return getImage(owner, resource, null, null);
    }

    /**
     * Gets the image with defined dimensions
     *
     * @param owner
     *            the owner
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
    public String getImage(final Object owner, final String resource, final String width, final String height)
            throws IOException {
        final InputStream inputStream = getResourceAsStream(owner, resource);

        if (inputStream == null) {
            throw new FileNotFoundException("Image file not found " + resource);
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
