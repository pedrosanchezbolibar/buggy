package calypsox.buggy.prototype;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Properties;

import com.calypso.tk.core.Log;

import calypsox.buggy.uti.ResourceReader;

/**
 * The Class Prototype. It is used to read a file template from the resources
 * and replace the keywords between '@'
 */
public class Prototype extends ResourceReader {

    /**
     * Gets the prototype. The filename has to start with '/'
     *
     * @param owner
     *            the owner
     * @param filename
     *            the filename
     * @param params
     *            the params
     * @return the prototype
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public String getPrototype(final Object owner, final String filename, final Properties params) throws IOException {
        final String eol = getEOL(params);

        String output = readResourceEOL(owner, filename, eol).toString();

        for (final Entry<Object, Object> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                final StringBuilder sb = new StringBuilder("@");
                sb.append(entry.getKey());
                sb.append('@');
                output = output.replaceAll(sb.toString(), entry.getValue().toString());
            }
        }

        return output;
    }

    /**
     * Read resource.
     *
     * @param owner
     *            the owner
     * @param filename
     *            the filename
     * @return the string builder
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public StringBuilder readResource(final Object owner, final String filename) throws IOException {
        return readResourceEOL(owner, filename, System.getProperty("line.separator"));
    }

    /**
     * Gets the eol.
     *
     * @param params
     *            the params
     * @return the eol
     */
    private String getEOL(final Properties params) {
        String eol = params.getProperty("EOL");
        if (eol == null) {
            eol = System.getProperty("line.separator");
        }
        return eol;
    }

    /**
     * Read resource EOL.
     *
     * @param owner
     *            the owner
     * @param filename
     *            the filename
     * @param eol
     *            the eol
     * @return the string builder
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private StringBuilder readResourceEOL(final Object owner, final String filename, final String eol)
            throws IOException {
        final InputStream is = getResourceAsStream(owner, filename);
        if (is == null) {
            Log.error(this, "Can not read the template '" + filename + "'");
            throw new FileNotFoundException("Can not read the template '" + filename + "'");
        } else {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            final StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
                out.append(eol);
            }
            reader.close();
            return out;
        }
    }

}
