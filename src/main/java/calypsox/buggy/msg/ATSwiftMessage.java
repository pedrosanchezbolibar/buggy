package calypsox.buggy.msg;

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
}
