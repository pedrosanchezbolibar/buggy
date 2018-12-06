package calypsox.buggy.product;

import com.calypso.tk.core.Amount;
import com.calypso.tk.core.Trade;
import com.calypso.tk.product.FX;

import calypsox.buggy.ui.ATAmount;

public class ATFx extends ATTrade {

    private final FX fx;

    public ATFx(final Trade trade) {
	super(trade);
	fx = (FX) trade.getProduct();
    }

    public ATAmount getPrimaryAmount() {
	final Amount amount = fx.getPrimaryAmount(trade);
	final String ccy = fx.getPrimaryCurrency();
	return new ATAmount(ccy, amount.get());
    }
}
