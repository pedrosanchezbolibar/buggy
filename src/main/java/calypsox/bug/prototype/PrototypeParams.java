package calypsox.bug.prototype;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Class PrototypeParam.
 */
public class PrototypeParams implements Iterable<PrototypeParam> {

	/** The param list. */
	List<PrototypeParam> paramList;

	/**
	 * Instantiates a new prototype params.
	 */
	public PrototypeParams() {
		paramList = new ArrayList<PrototypeParam>();
	}

	/**
	 * Adds a new parameter or update an existing one
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void add(final String key, final String value) {
		final int index = indexOf(key);
		if (index > -1) {
			paramList.get(index).setValue(value);
		} else {
			paramList.add(new PrototypeParam(key, value));
		}
	}

	/**
	 * Returns the position of this parameter inside the list or -1 if not found.
	 *
	 * @param key
	 *            the key
	 * @return the int
	 */
	public int indexOf(final String key) {
		for (int i = 0; i < paramList.size(); i++) {
			if (paramList.get(i).getKey().equals(key)) {
				return i;
			}
		}
		// if not found
		return -1;
	}

	/**
	 * Gets the value of the corresponding parameter or null if not found.
	 *
	 * @param key
	 *            the key
	 * @return the string
	 */
	public String get(final String key) {
		for (final PrototypeParam param : paramList) {
			if (param.getKey().equals(key)) {
				return param.getValue();
			}
		}
		// if not found
		return null;
	}

	/**
	 * Iterator.
	 *
	 * @return the iterator
	 */
	@Override
	public Iterator<PrototypeParam> iterator() {
		return paramList.iterator();
	}

	/**
	 * Clear.
	 */
	public void clear() {
		paramList.clear();
	}

}
