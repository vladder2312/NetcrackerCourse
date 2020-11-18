package netcracker.sorter.comparators;

import netcracker.contract.Contract;

import java.util.Comparator;

public class ContractEndDateComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        if (o1.getEndDate().after(o2.getEndDate())) {
            return 1;
        } else if (o2.getStartDate().before(o2.getStartDate())) {
            return -1;
        } else return 0;
    }
}
