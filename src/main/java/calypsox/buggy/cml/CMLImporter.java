package calypsox.buggy.cml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.calypso.apps.common.TradeExportImportXMLHandler;
import com.calypso.tk.core.Trade;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.product.ATTrade;
import calypsox.buggy.product.ATTrades;
import calypsox.buggy.prototype.Prototype;

/**
 * The Class CMLImporter.
 */
public class CMLImporter {

    private static TradeExportImportXMLHandler importHandler;

    /**
     * Import trade.
     *
     * @param owner
     * @param template
     * @param params
     *
     * @param file     the file
     * @return the list
     * @throws IOException
     */
    public ATTrade importTrade(final Object owner, final String template, final Properties params) throws IOException {
	final File tempFile = createTempFile(owner, template, params);
	initTradeAdapter();
	final List<Trade> importedTrades = importHandler.importAllData(tempFile.getAbsolutePath());

	if (importedTrades.isEmpty()) {
	    return null;
	} else if (importedTrades.size() > 1) {
	    throw new IllegalArgumentException("Error importing CML : more than one Trade was imported");
	}

	return new ATTrades().createTrade(importedTrades.get(0));
    }

    private File createTempFile(final Object owner, final String template, final Properties params) throws IOException {
	final String messageText = new Prototype().getPrototype(owner, template, params);
	final File tempFile = File.createTempFile(template, ".xml");
	try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
	    writer.write(messageText);
	}
	return tempFile;
    }

    private static void initTradeAdapter() {
	if (importHandler == null) {
	    importHandler = new TradeExportImportXMLHandler();
	    importHandler.initialize(DSConnection.getDefault());
	}
    }
}
