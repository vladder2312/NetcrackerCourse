import netcracker.contract.models.Contract;
import netcracker.contract.ContractRepository;
import netcracker.sorter.comparators.ContractClientFioComparator;
import netcracker.sorter.comparators.ContractEndDateComparator;
import netcracker.sorter.comparators.ContractIdComparator;
import netcracker.sorter.comparators.ContractStartDateComparator;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Comparators Tester
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ноя. 18, 2020</pre>
 */
public class ComparatorsTest {

    /**
     * Method: ContractIdComparator.compare(Contract o1, Contract o2)
     */
    @Test
    public void compareId() {
        ContractRepository repository = new ContractRepository();
        Comparator<Contract> comparator = new ContractIdComparator();
        repository.fillRepository(2);
        Contract o1 = repository.getContracts()[0];
        Contract o2 = repository.getContracts()[1];
        if (o1.getId() > o2.getId()) {
            assertEquals(1, comparator.compare(o1, o2));
        } else if (o1.getId() < o2.getId()) {
            assertEquals(-1, comparator.compare(o1, o2));
        } else {
            assertEquals(0, comparator.compare(o1, o2));
        }
    }

    /**
     * Method: ContractStartDateComparator.compare(Contract o1, Contract o2)
     */
    @Test
    public void compareStartDate() {
        ContractRepository repository = new ContractRepository();
        Comparator<Contract> comparator = new ContractStartDateComparator();
        repository.fillRepository(2);
        Contract o1 = repository.getContracts()[0];
        Contract o2 = repository.getContracts()[1];
        if (o1.getStartDate().after(o2.getStartDate())) {
            assertEquals(1, comparator.compare(o1, o2));
        } else if (o1.getStartDate().before(o2.getStartDate())) {
            assertEquals(-1, comparator.compare(o1, o2));
        } else {
            assertEquals(0, comparator.compare(o1, o2));
        }
    }

    /**
     * Method: ContractEndDateComparator.compare(Contract o1, Contract o2)
     */
    @Test
    public void compareEndDate() {
        ContractRepository repository = new ContractRepository();
        Comparator<Contract> comparator = new ContractEndDateComparator();
        repository.fillRepository(2);
        Contract o1 = repository.getContracts()[0];
        Contract o2 = repository.getContracts()[1];
        if (o1.getStartDate().after(o2.getStartDate())) {
            assertEquals(1, comparator.compare(o1, o2));
        } else if (o1.getStartDate().before(o2.getStartDate())) {
            assertEquals(-1, comparator.compare(o1, o2));
        } else {
            assertEquals(0, comparator.compare(o1, o2));
        }
    }

    /**
     * Method: ContractClientFioComparator.compare(Contract o1, Contract o2)
     */
    @Test
    public void compareClientFio() {
        ContractRepository repository = new ContractRepository();
        Comparator<Contract> comparator = new ContractClientFioComparator();
        repository.fillRepository(2);
        Contract o1 = repository.getContracts()[0];
        Contract o2 = repository.getContracts()[1];
        assertEquals(comparator.compare(o1, o2), o1.getClient().getFio().compareTo(o2.getClient().getFio()));
    }
}
