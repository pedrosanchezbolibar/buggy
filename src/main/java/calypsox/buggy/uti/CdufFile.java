package calypsox.buggy.uti;

import java.io.File;

import com.calypso.tk.core.Log;
import com.calypso.tk.publish.jaxb.CalypsoAcknowledgement;
import com.calypso.tk.util.DataUploaderUtil;

import calypsox.buggy.prototype.Prototype;
import calypsox.buggy.uploader.DUPAck;

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
     * Gets the received.
     *
     * @return the received
     */
    public int getReceived() {
        return received;
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
     * Gets the simple name.
     *
     * @return the simple name
     */
    public String getSimpleName() {
        final int startFileName = fileName.lastIndexOf(File.separator) + 1;
        if (startFileName < 0) {
            return fileName;
        } else {
            return fileName.substring(startFileName, fileName.length());
        }
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
     * Import file.
     */
    public void importFile() {
        try {
            final StringBuilder messageText = new Prototype().readResource(this, fileName);
            final CalypsoAcknowledgement ack;
            if (fileName.endsWith(".xml")) {
                ack = DataUploaderUtil.uploadXML(messageText.toString());
            } else {
                final String simpleName = getSimpleName();
                ack = DataUploaderUtil.uploadCSV(messageText.toString(), simpleName, ",", "UTF-8", "UTF-8");
            }

            setRejected(ack.getRejected());
            setUploaded(ack.getUploaded());
            setReceived(ack.getReceived());

            if (ack.getRejected() > 0) {
                final DUPAck aatack = new DUPAck(ack);
                Log.error(this, "NACK inserting referece data in file: " + fileName + "\r\n" + aatack);
            }
        } catch (final Exception ex) {
            Log.error(this, "Exception loading file '" + fileName + "'", ex);
        }
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
     * Sets the received.
     *
     * @param received
     *            the received to set
     */
    public void setReceived(final int received) {
        this.received = received;
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

    /**
     * Sets the uploaded.
     *
     * @param uploaded
     *            the uploaded to set
     */
    public void setUploaded(final int uploaded) {
        this.uploaded = uploaded;
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
