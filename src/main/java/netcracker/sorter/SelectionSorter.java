package netcracker.sorter;

import netcracker.contract.Contract;

import java.util.Comparator;

/**
 * Selection sorter
 */
public class SelectionSorter implements ISorter {

    @Override
    public Contract[] sort(Contract[] contracts, Comparator<Contract> comparator) {
        for (int i = 0; i < contracts.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < contracts.length; j++){
                if (comparator.compare(contracts[j], contracts[index]) < 0){
                    index = j;
                }
            }
            Contract smaller = contracts[index];
            contracts[index] = contracts[i];
            contracts[i] = smaller;
        }
        return contracts;
    }
}
