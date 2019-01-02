package calypsox.buggy.product;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.Log;
import com.calypso.tk.core.Trade;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.TradeArray;

import calypsox.buggy.uti.CalypsoEnvironment;

/**
 * Retrieve and apply actions over Calypso Trades.
 */
public class ATTrades {

    /** The instance. */
    private static ATTrades instance;

    /**
     * Gets the single instance of ATTrades.
     *
     * @return single instance of ATTrades
     */
    public static synchronized ATTrades getInstance() {
        if (instance == null) {
            instance = new ATTrades();
        }
        return instance;
    }

    /**
     * Instantiates a new AT trades.
     */
    private ATTrades() {
        // prevent to instantiate this class
    }

    /**
     * Creates the trade.
     *
     * @param tradeId
     *            the trade id
     * @return the AT trade
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTrade createTrade(final int tradeId) throws CalypsoServiceException {
        final DSConnection dscon = CalypsoEnvironment.getInstance().getDSConnection();
        final Trade trade = dscon.getRemoteTrade().getTrade(tradeId);
        if (trade == null) {
            throw new IllegalArgumentException("Can't retrive a trade with id = " + tradeId);
        }
        return createTrade(trade);
    }

    /**
     * Creates the trade.
     *
     * @param trade
     *            the trade
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
     * Creates the trades.
     *
     * @param tradeArray
     *            the trades
     * @return the list
     */
    public List<ATTrade> createTrades(final TradeArray tradeArray) {
        final List<ATTrade> tradeList = new ArrayList<>();
        for (int i = 0; i < tradeArray.size(); i++) {
            final Trade trade = tradeArray.get(i);
            final ATTrade atTrade = createTrade(trade);
            tradeList.add(atTrade);
        }
        return tradeList;
    }

    /**
     * Gets the trade.
     *
     * @param tradeId
     *            the trade id
     * @return the trade
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTrade getTrade(final int tradeId) throws CalypsoServiceException {
        return createTrade(tradeId);
    }

    /**
     * Gets the trades.
     *
     * @param extRef
     *            the ext ref
     * @return the trades
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public List<ATTrade> getTrades(final String extRef) throws CalypsoServiceException {
        final DSConnection dscon = CalypsoEnvironment.getInstance().getDSConnection();
        final TradeArray tradeArray = dscon.getRemoteTrade().getTradesByExternalRef(extRef);
        return createTrades(tradeArray);
    }

}
