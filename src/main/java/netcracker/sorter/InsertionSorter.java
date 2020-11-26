package netcracker.sorter;

import netcracker.contract.models.Contract;

import java.util.Comparator;

/**
 * Insertion sorter
 */
public class InsertionSorter implements ISorter {

    @Override
    public Contract[] sort(Contract[] contracts, Comparator<Contract> comparator) {
        for (int j = 1; j < contracts.length; j++) {
            Contract key = contracts[j];
            int i = j - 1;
            while ((i > -1) && (comparator.compare(contracts[i],key) > 0)) {
                contracts[i + 1] = contracts[i];
                i--;
            }
            contracts[i + 1] = key;
        }
        return contracts;
    }
}
