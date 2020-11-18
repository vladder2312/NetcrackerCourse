package netcracker.sorter.comparators;

import netcracker.contract.Contract;

import java.util.Comparator;

/**
 * Client fullName comparator
 * */
public class ContractClientFioComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        return o1.getClient().getFio().compareTo(o2.getClient().getFio());
    }
}
