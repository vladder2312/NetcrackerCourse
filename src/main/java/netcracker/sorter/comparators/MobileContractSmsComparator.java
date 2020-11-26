package netcracker.sorter.comparators;

import netcracker.contract.models.MobileContract;

import java.util.Comparator;

/**
 * SMS quantity comparator
 */
public class MobileContractSmsComparator implements Comparator<MobileContract> {

    @Override
    public int compare(MobileContract o1, MobileContract o2) {
        return Integer.compare(o1.getSms(), o2.getSms());
    }
}
