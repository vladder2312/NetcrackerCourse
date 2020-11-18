package netcracker.sorter.comparators;

import netcracker.contract.MobileContract;

import java.util.Comparator;

/**
 * MegaBytes comparator
 */
public class MobileContractMegaBytesComparator implements Comparator<MobileContract> {

    @Override
    public int compare(MobileContract o1, MobileContract o2) {
        return Integer.compare(o1.getMegaBytes(), o2.getMegaBytes());
    }
}
