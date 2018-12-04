package calypsox.buggy.uti;

/**
 * The Class CdufFile.
 */
public class CdufFile {

	/** The file name. */
	private String fileName;

	/** The received. */
	private int received;

	/** The uploaded. */
	private int uploaded;

	/** The rejected. */
	private int rejected;

	/**
	 * Gets the file name.
	 *
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name.
	 *
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets the received.
	 *
	 * @return the received
	 */
	public int getReceived() {
		return received;
	}

	/**
	 * Sets the received.
	 *
	 * @param received
	 *            the received to set
	 */
	public void setReceived(final int received) {
		this.received = received;
	}

	/**
	 * Gets the uploaded.
	 *
	 * @return the uploaded
	 */
	public int getUploaded() {
		return uploaded;
	}

	/**
	 * Sets the uploaded.
	 *
	 * @param uploaded
	 *            the uploaded to set
	 */
	public void setUploaded(final int uploaded) {
		this.uploaded = uploaded;
	}

	/**
	 * Gets the rejected.
	 *
	 * @return the rejected
	 */
	public int getRejected() {
		return rejected;
	}

	/**
	 * Sets the rejected.
	 *
	 * @param rejected
	 *            the rejected to set
	 */
	public void setRejected(final int rejected) {
		this.rejected = rejected;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder(60);
		builder.append("CdufFile [fileName=");
		builder.append(fileName);
		builder.append(", received=");
		builder.append(received);
		builder.append(", uploaded=");
		builder.append(uploaded);
		builder.append(", rejected=");
		builder.append(rejected);
		builder.append(']');
		return builder.toString();
	}
}
