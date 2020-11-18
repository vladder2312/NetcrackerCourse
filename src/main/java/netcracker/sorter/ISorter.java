package netcracker.sorter;

import netcracker.contract.Contract;

import java.util.Comparator;

/**
 * Sorter interface
 */
public interface ISorter {
    Contract[] sort(Contract[] contracts, Comparator<Contract> comparator);
}
