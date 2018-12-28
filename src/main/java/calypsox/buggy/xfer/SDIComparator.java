package calypsox.buggy.xfer;

import java.util.Comparator;

import com.calypso.tk.refdata.SettleDeliveryInstruction;

/**
 * Used to sort a list of SDI by description and reference.
 */
public class SDIComparator implements Comparator<SettleDeliveryInstruction> {

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(final SettleDeliveryInstruction sdi1, final SettleDeliveryInstruction sdi2) {
        if (sdi1 == null) {
            return 1;
        }
        if (sdi2 == null) {
            return -1;
        }

        final String desc1 = sdi1.getDescription().toUpperCase();
        final String desc2 = sdi2.getDescription().toUpperCase();
        int result = desc1.compareTo(desc2);
        if (result == 0) {
            result = sdi1.getReference().compareTo(sdi2.getReference());
        }
        return result;
    }

}
