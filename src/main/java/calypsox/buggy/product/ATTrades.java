package calypsox.buggy.product;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.Log;
import com.calypso.tk.core.Trade;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.uploader.DUPAck;
import calypsox.buggy.uti.CalypsoEnvironment;

/**
 * Retrieve and apply actions over Calypso Trades
 */
public class ATTrades {

    /**
     * Gets the trade.
     *
     * @param ack the ack
     * @return the trade
     * @throws CalypsoServiceException the calypso service exception
     */
    public ATTrade getTrade(final DUPAck ack) throws CalypsoServiceException {
	return createTrade(ack.getTradeId());
    }

    public ATTrade createTrade(final int tradeId) throws CalypsoServiceException {
	final DSConnection dscon = CalypsoEnvironment.getInstance().getDSConnection();
	final Trade trade = dscon.getRemoteTrade().getTrade(tradeId);
	return createTrade(trade);
    }

    /**
     * Creates the trade.
     *
     * @param trade the trade
     * @return the AT trade
     */
    @SuppressWarnings("unchecked")
    public ATTrade createTrade(final Trade trade) {
	final String className = "calypsox.buggy.product.AT" + trade.getProductType();

	Class<ATTrade> clazz;
	try {
	    clazz = (Class<ATTrade>) Class.forName(className);
	} catch (final ClassNotFoundException e) {
	    Log.error(this, "Can't find class '" + className + "'");
	    return new ATTrade(trade);
	}

	try {
	    final Constructor<ATTrade> constructor = clazz.getConstructor(Trade.class);
	    return constructor.newInstance(trade);
	} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
		| IllegalArgumentException | InvocationTargetException e) {
	    Log.error(this, "Can't findcproper constructor for class '" + className + "'", e);
	    return new ATTrade(trade);
	}
    }
}
