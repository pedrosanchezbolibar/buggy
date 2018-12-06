package calypsox.buggy.acc;

import java.util.Comparator;

import com.calypso.tk.bo.BOCre;

/**
 * Used to sort CREs with the following criteria: effective date, event type,
 * cre type, description, original event type and amount.
 */
public class CreComparator implements Comparator<BOCre> {

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(final BOCre cre1, final BOCre cre2) {
	if (cre1 == null) {
	    return 1;
	}
	if (cre2 == null) {
	    return -1;
	}

	int result = cre1.getEffectiveDate().compareTo(cre2.getEffectiveDate());
	if (result == 0) {
	    result = cre1.getEventType().compareTo(cre2.getEventType());
	    if (result == 0) {
		result = cre1.getCreType().compareTo(cre2.getCreType());
		if (result == 0) {
		    result = cre1.getDescription().compareTo(cre2.getDescription());
		    if (result == 0) {
			result = cre1.getOriginalEventType().compareTo(cre2.getOriginalEventType());
		    }
		    if (result == 0) {
			result = (int) (cre1.getAmount(0) - cre2.getAmount(0));
		    }

		}
	    }
	}

	return result;
    }

}
