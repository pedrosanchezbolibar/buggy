package calypsox.buggy.msg;

import com.calypso.tk.bo.swift.SwiftFieldMessage;
import com.calypso.tk.bo.swift.SwiftMessage;

public class ATSwiftMessage {

    private final SwiftMessage swiftmessage;

    ATSwiftMessage(final SwiftMessage swiftMessage) {
	swiftmessage = swiftMessage;
    }

    public String getText() {
	return swiftmessage.getText();
    }

    public SwiftMessage getSwiftMessage() {
	return swiftmessage;
    }

    /**
     * Gets the swift tag.
     *
     * @param atSwiftMessage the at swift message
     * @param tag the tag
     * @param count the count
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
