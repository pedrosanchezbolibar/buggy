package calypsox.buggy.msg;

import com.calypso.tk.bo.BOMessage;
import com.calypso.tk.bo.MessageFormatException;
import com.calypso.tk.bo.SWIFTFormatterUtil;
import com.calypso.tk.bo.document.AdviceDocument;
import com.calypso.tk.bo.swift.SWIFTFormatter;
import com.calypso.tk.bo.swift.SwiftMessage;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.marketdata.PricingEnv;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.MessageArray;

import calypsox.buggy.product.ATTrade;

/**
 * The Class ATMessages.
 */
public class ATMessages {

    /**
     * Gets the trade's message by msg type.
     *
     * @param trade   the trade
     * @param msgType the msg type
     * @return the message by msg type
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATMessage getMessageByMsgType(final ATTrade trade, final String msgType) throws CalypsoServiceException {
	final String where = String.format("trade_id = %d and MESSAGE_TYPE = '%s'", trade.getId(), msgType);
	return new ATMessage(getFirstMessage(where));
    }

    /**
     * Gets the first message.
     *
     * @param where the where clause
     * @return the message
     * @throws CalypsoServiceException the remote exception
     */
    private BOMessage getFirstMessage(final String where) throws CalypsoServiceException {
	final MessageArray messages = DSConnection.getDefault().getRemoteBackOffice().getMessages(where);
	if (!messages.isEmpty()) {
	    return messages.get(0);
	}
	return null;
    }

    public ATSwiftMessage formatSwiftDocument(final ATMessage message, final String pricingEnv)
	    throws CalypsoServiceException, MessageFormatException {
	return new ATSwiftMessage(generateSwiftDocument(message.getBOMessage(), pricingEnv));
    }

    private SwiftMessage generateSwiftDocument(final BOMessage boMessage, final String pricingEnvName)
	    throws CalypsoServiceException, MessageFormatException {
	final SWIFTFormatter swiftFormatter = SWIFTFormatterUtil.findSWIFTFormatter(boMessage);
	final PricingEnv pricingEnv = DSConnection.getDefault().getRemoteMarketData().getPricingEnv(pricingEnvName);
	final AdviceDocument doc = swiftFormatter.generate(pricingEnv, boMessage, true, DSConnection.getDefault());
	final StringBuffer output = doc.getDocument();
	SwiftMessage.stripExtraInfo(output);

	final SwiftMessage result = new SwiftMessage();
	result.parseSwiftText(output.toString(), false);
	return result;
    }

}
