package calypsox.buggy.product;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.Product;
import com.calypso.tk.core.Trade;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.uploader.DUPAck;
import calypsox.buggy.uti.CalypsoEnvironment;

public class ATTrades {
    public ATTrade getTrade(final DUPAck ack) throws CalypsoServiceException {
	final DSConnection dscon = CalypsoEnvironment.getInstance().getDSConnection();
	final com.calypso.tk.core.Trade trade = dscon.getRemoteTrade().getTrade(ack.getTradeId());
	return createTrade(trade);
    }

    private ATTrade createTrade(final Trade trade) {
	if (Product.FX.equals(trade.getProductType())) {
	    return new ATFx(trade);
	} else {
	    return new ATTrade(trade);
	}
    }
}
