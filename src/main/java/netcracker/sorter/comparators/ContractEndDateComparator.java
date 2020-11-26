package netcracker.sorter.comparators;

import netcracker.contract.models.Contract;

import java.util.Comparator;

/**
 * End date comparator
 */
public class ContractEndDateComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        if (o1.getEndDate().after(o2.getEndDate())) {
            return 1;
        } else if (o1.getEndDate().before(o2.getEndDate())) {
            return -1;
        } else return 0;
    }
}
