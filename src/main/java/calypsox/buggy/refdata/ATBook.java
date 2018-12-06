package calypsox.buggy.refdata;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.core.Book;
import com.calypso.tk.service.DSConnection;

public class ATBook {
    private final Book book;

    public ATBook(final int bookId) {
	book = BOCache.getBook(DSConnection.getDefault(), bookId);
    }

    public ATBook(final Book entity) {
	book = entity;
    }

    @Override
    public String toString() {
	if (book == null) {
	    return "null";
	}
	return book.toString();
    }
}
