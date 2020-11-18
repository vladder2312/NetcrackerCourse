package netcracker.sorter;

import netcracker.contract.Contract;

import java.util.Comparator;

public interface ISorter {
    Contract[] sort(Contract[] contracts, Comparator<Contract> comparator);
}
