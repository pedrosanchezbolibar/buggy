package calypsox.buggy.devel;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;

import calypsox.buggy.prototype.Prototype;

/**
 * The Class CreatePom.
 */
public class CreatePom {

    /** The calypso home. */
    private static String CALYPSO_HOME = "../../calypso_home";

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException {
        final CreatePom app = new CreatePom();
        app.run();
    }

    /**
     * Creates the dependency.
     *
     * @param jar
     *            the jar
     * @return the string builder
     */
    private StringBuilder createDependency(final String jar) {
        final StringBuilder str = new StringBuilder("\t\t<dependency>\n");
        str.append("\t\t\t<groupId>calypso</groupId>\n");
        str.append("\t\t\t<artifactId>");
        str.append(jar);
        str.append("</artifactId>\n");
        str.append("\t\t\t<version>1</version>\n");
        str.append("\t\t\t<scope>system</scope>\n");
        str.append("\t\t\t<systemPath>${calypso.home}/client/lib/");
        str.append(jar);
        str.append("</systemPath>\n");
        str.append("\t\t</dependency>\n\n");
        return str;
    }

    /**
     * Gets the calypso dependencies.
     *
     * @return the calypso dependencies
     */
    private String getCalypsoDependencies() {
        final File calypsoHome = new File(CALYPSO_HOME + "/client/lib");
        final FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(final File dir, final String name) {
                return name.endsWith(".jar");
            }
        };
        final String[] jars = calypsoHome.list(filter);

        final StringBuilder result = new StringBuilder();

        for (final String jar : jars) {
            result.append(createDependency(jar));
        }

        return result.toString();
    }

    /**
     * Gets the jboss version.
     *
     * @return the jboss version
     */
    private String getJbossVersion() {
        final File calypsoHome = new File(CALYPSO_HOME + "/jboss");
        final FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(final File dir, final String name) {
                return name.startsWith("jboss-eap-");
            }
        };
        final String[] dirs = calypsoHome.list(filter);
        if (dirs.length != 1) {
            throw new AssertionError("ERROR: can't locate jboss dir in " + calypsoHome.getAbsolutePath()
                    + " directories found: " + dirs);
        }
        return dirs[0];
    }

    /**
     * Run.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void run() throws IOException {
        final Prototype prototype = new Prototype();
        final Properties params = new Properties();
        params.setProperty("CALYPSO_HOME", CALYPSO_HOME);
        params.setProperty("JBOSS_VERSION", getJbossVersion());
        final String dependencies = Matcher.quoteReplacement(getCalypsoDependencies());
        params.setProperty("CALYPSO_DEPENDENCIES", dependencies);
        final String xml = prototype.getPrototype(this, "pom.xml", params);
        try (FileWriter writer = new FileWriter("new_pom.xml")) {
            writer.write(xml);
        }
        System.out.println(xml);
    }

}
