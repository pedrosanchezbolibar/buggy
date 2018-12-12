package calypsox.buggy.cml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.calypso.apps.common.TradeExportImportXMLHandler;
import com.calypso.tk.core.Log;
import com.calypso.tk.core.Trade;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.RemoteTrade;

import calypsox.buggy.prototype.Prototype;

/**
 * The Class CMLImporter.
 */
public class CMLImporter {

    /** The import handler. */
    private static TradeExportImportXMLHandler importHandler;

    /**
     * Import trade.
     *
     * @param owner the owner
     * @param template the template
     * @param params the params
     * @return the list
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public int importTrade(final Object owner, final String template, final Properties params) throws IOException {
	final File tempFile = createTempFile(owner, template, params);
	initTradeAdapter();
	final List<Trade> importedTrades = importHandler.importAllData(tempFile.getAbsolutePath());

	if (importedTrades.size() > 1) {
	    throw new IllegalArgumentException("Error importing CML : more than one Trade was imported");
	}

	final Trade trade = importedTrades.get(0);
	final RemoteTrade remote = DSConnection.getDefault().getRemoteTrade();
	final int tradeId = remote.save(trade);
	Log.info(this, "Trade imported with tradeId = " + tradeId);
	return tradeId;
    }

    /**
     * Creates the temp file.
     *
     * @param owner the owner
     * @param template the template
     * @param params the params
     * @return the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private File createTempFile(final Object owner, final String template, final Properties params) throws IOException {
	final String messageText = new Prototype().getPrototype(owner, template, params);
	final File tempFile = File.createTempFile(template, ".xml");
	tempFile.deleteOnExit();
	try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
	    writer.write(messageText);
	}
	return tempFile;
    }

    /**
     * Inits the trade adapter.
     */
    private static void initTradeAdapter() {
	if (importHandler == null) {
	    importHandler = new TradeExportImportXMLHandler();
	    importHandler.initialize(DSConnection.getDefault());
	}
    }
}
