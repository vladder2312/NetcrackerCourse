package netcracker.sorter;

import netcracker.contract.models.Contract;

import java.util.Comparator;

/**
 * Bubble sorter
 */
public class BubbleSorter implements ISorter {

    @Override
    public Contract[] sort(Contract[] contracts, Comparator<Contract> comparator) {
        for (int i = 0; i < contracts.length - 1; i++) {
            for (int j = 0; j < contracts.length - i - 1; j++) {
                if (comparator.compare(contracts[j], contracts[j + 1]) > 0) {
                    Contract temp = contracts[j];
                    contracts[j] = contracts[j + 1];
                    contracts[j + 1] = temp;
                }
            }
        }
        return contracts;
    }
}
