package netcracker.sorter.comparators;

import netcracker.contract.InternetContract;

import java.util.Comparator;

public class InternetContractSpeedComparator implements Comparator<InternetContract> {

    @Override
    public int compare(InternetContract o1, InternetContract o2) {
        return Integer.compare(o1.getSpeed(), o2.getSpeed());
    }
}
