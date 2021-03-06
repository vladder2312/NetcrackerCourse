package netcracker.sorter.comparators;

import netcracker.contract.models.Contract;

import java.util.Comparator;

/**
 * Id comparator
 */
public class ContractIdComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
