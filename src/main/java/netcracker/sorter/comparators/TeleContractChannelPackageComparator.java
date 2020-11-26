package netcracker.sorter.comparators;

import netcracker.contract.models.TeleContract;

import java.util.Comparator;

/**
 * ChannelPackage comparator
 */
public class TeleContractChannelPackageComparator implements Comparator<TeleContract> {

    @Override
    public int compare(TeleContract o1, TeleContract o2) {
        return o1.getChanelKit().toString().compareTo(o2.getChanelKit().toString());
    }
}
