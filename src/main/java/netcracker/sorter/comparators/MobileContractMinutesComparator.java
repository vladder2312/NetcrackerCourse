package netcracker.sorter.comparators;

import netcracker.contract.models.MobileContract;

import java.util.Comparator;

/**
 * Minutes comparator
 */
public class MobileContractMinutesComparator implements Comparator<MobileContract> {

    @Override
    public int compare(MobileContract o1, MobileContract o2) {
        return Integer.compare(o1.getMinutes(), o2.getMinutes());
    }
}
