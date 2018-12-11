package calypsox.buggy.product;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.calypso.tk.core.Action;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.Log;
import com.calypso.tk.core.Trade;
import com.calypso.tk.refdata.AccessUtil;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.infra.ATDSConnection;
import calypsox.buggy.uploader.DUPAck;
import calypsox.buggy.uti.CalypsoEnvironment;

/**
 * Retrieve and apply actions over Calypso Trades
 */
public class ATTrades {

    /**
     * Apply action to trade.
     *
     * @param trade    the trade
     * @param action   the action
     * @param userName the user name
     * @return true, if successful
     * @throws CalypsoServiceException the calypso service exception
     */
    public boolean applyActionToTrade(final ATTrade trade, final String action, final String userName)
	    throws CalypsoServiceException {
	boolean rst = false;

	String userNameParam = userName;
	if (userNameParam == null) {
	    userNameParam = "calypso_user";
	}

	final ATDSConnection aatDsConn = new ATDSConnection(userNameParam);

	final Trade tradeChange = trade.getTrade().clone();
	if (AccessUtil.isAuthorized(tradeChange, action)) {
	    tradeChange.setAction(Action.valueOf(action));
	    tradeChange.setEnteredUser(userNameParam);

	    DSConnection.getDefault().getRemoteTrade().save(tradeChange);
	    rst = true;

	} else {
	    aatDsConn.restoreRealConnection();
	    throw new SecurityException("Action can't be performed with user " + userNameParam);
	}

	aatDsConn.restoreRealConnection();
	return rst;
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

    /**
     * Creates the trades.
     *
     * @param trades the trades
     * @return the list
     */
    public List<ATTrade> createTrades(final List<Trade> trades) {
	final List<ATTrade> tradeList = new ArrayList<>();
	for (final Trade trade : trades) {
	    final ATTrade atTrade = createTrade(trade);
	    tradeList.add(atTrade);
	}
	return tradeList;
    }

}
