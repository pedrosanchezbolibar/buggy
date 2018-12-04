package calypsox.bug.prototype;

import java.util.Map.Entry;

/**
 * The Class PrototypeParam.
 */
public class PrototypeParam implements Entry<String, String> {

	/** The key. */
	String key;

	/** The value. */
	String value;

	/**
	 * Instantiates a new prototype param.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public PrototypeParam(final String key, final String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map.Entry#getKey()
	 */
	@Override
	public String getKey() {
		return key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map.Entry#getValue()
	 */
	@Override
	public String getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map.Entry#setValue(java.lang.Object)
	 */
	@Override
	public String setValue(final String value) {
		this.value = value;
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("'%s' = '%s'", key, value);
	}
}