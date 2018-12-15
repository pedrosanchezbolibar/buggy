package calypsox.buggy.msg;

import com.calypso.tk.bo.swift.SwiftFieldMessage;
import com.calypso.tk.bo.swift.SwiftMessage;

/**
 * The Class ATSwiftMessage.
 */
public class ATSwiftMessage {

    /** The swiftmessage. */
    private final SwiftMessage swiftmessage;

    /**
     * Instantiates a new AT swift message.
     *
     * @param swiftMessage
     *            the swift message
     */
    ATSwiftMessage(final SwiftMessage swiftMessage) {
        swiftmessage = swiftMessage;
    }

    /**
     * Gets the swift message.
     *
     * @return the swift message
     */
    public SwiftMessage getSwiftMessage() {
        return swiftmessage;
    }

    /**
     * Gets the swift tag name.
     *
     * @param tag
     *            the tag
     * @return the swift tag name
     */
    public String getSwiftTagName(final String tag) {
        return getSwiftTagValue(tag, 1);
    }

    /**
     * Gets the swift tag name.
     *
     * @param tag
     *            the tag
     * @param count
     *            the count
     * @return the swift tag name
     */
    public String getSwiftTagName(final String tag, final int count) {
        int found = 0;

        if (swiftmessage != null) {
            for (final SwiftFieldMessage field : swiftmessage.getFields()) {
                if ((":" + tag + ":").equals(field.getTAG())) {
                    found++;
                    if (found == count) {
                        return field.getName();
                    }
                }
            }
        }
        return "ERROR TAG " + tag + " NOT FOUND";
    }

    /**
     * Gets the swift tag.
     *
     * @param tag
     *            the tag
     * @return the swift tag
     */
    public String getSwiftTagValue(final String tag) {
        return getSwiftTagValue(tag, 1);
    }

    /**
     * Gets the swift tag.
     *
     * @param tag
     *            the tag
     * @param count
     *            the count
     * @return the swift tag
     */
    public String getSwiftTagValue(final String tag, final int count) {
        int found = 0;

        if (swiftmessage != null) {
            for (final SwiftFieldMessage field : swiftmessage.getFields()) {
                if ((":" + tag + ":").equals(field.getTAG())) {
                    found++;
                    if (found == count) {
                        return field.getValue().replace("\r\n", " \\ ");
                    }
                }
            }
        }
        return "ERROR TAG " + tag + " NOT FOUND";
    }

    /**
     * Gets the text.
     *
     * @return the text
     */
    public String getText() {
        final StringBuffer str = new StringBuffer(swiftmessage.getSwiftText());
        SwiftMessage.stripExtraInfo(str);
        return str.toString();
    }
}
