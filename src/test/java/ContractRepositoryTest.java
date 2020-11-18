import netcracker.Client;
import netcracker.Data;
import netcracker.contract.Contract;
import netcracker.contract.ContractRepository;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Calendar;

/**
 * ContractRepository Tester
 *
 * @author <Authors name>
 * @since <pre>окт. 22, 2020</pre>
 * @version 1.0
 */
public class ContractRepositoryTest {

    /**
     * Method: getContractByID(long id)
     */
    @Test
    public void testGetContractByID(){
        ContractRepository repository = new ContractRepository();
        repository.addContract(new Contract(
                        123,
                        Calendar.getInstance(),
                        Calendar.getInstance(),
                        new Client(111, Calendar.getInstance(), Data.fioList.get(0),"gender", "1234 123456"))
        );
        assertNotNull(repository.getContractByID(123));
    }

    /**
     * Method: addContract(Contract contract)
     */
    @Test
    public void testAddContract(){
        ContractRepository repository = new ContractRepository();
        int amount = repository.getAmount();
        repository.addContract(new Contract(
                123,
                Calendar.getInstance(),
                Calendar.getInstance(),
                new Client(111, Calendar.getInstance(),Data.fioList.get(0),"gender", "1234 123456"))
        );
        assertEquals(1, repository.getAmount() - amount);
    }

    /**
     * Method: deleteContract(long id)
     */
    @Test
    public void testDeleteContractByID(){
        ContractRepository repository = new ContractRepository();
        repository.addContract(new Contract(
                123,
                Calendar.getInstance(),
                Calendar.getInstance(),
                new Client(111, Calendar.getInstance(),Data.fioList.get(0),"gender", "1234 123456"))
        );
        repository.deleteContract(123);
        assertNull(repository.getContractByID(123));
    }
}
