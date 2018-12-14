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
     * Gets the text.
     *
     * @return the text
     */
    public String getText() {
        return swiftmessage.getText();
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
     * Gets the swift tag.
     *
     * @param tag
     *            the tag
     * @return the swift tag
     */
    public String getSwiftTag(final String tag) {
        return getSwiftTag(tag, 1);
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
    public String getSwiftTag(final String tag, final int count) {
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
}
