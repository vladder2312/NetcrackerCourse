package netcracker.contract;

import netcracker.Client;
import netcracker.Data;
import netcracker.contract.models.*;
import netcracker.sorter.ISorter;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.function.Predicate;

/**
 * Repository for storing contracts
 */
public class ContractRepository {

    /**
     * Array of contracts
     */
    private Contract[] contracts;
    private final ContractParser parser = new ContractParser();

    /**
     * Amount of contracts in repository
     */
    private int amount;

    public ContractRepository() {
        contracts = new Contract[10];
        amount = 0;
    }

    public Contract[] getContracts() {
        return contracts;
    }

    public int getAmount() {
        return amount;
    }

    /**
     * Fills the contracts repository
     *
     * @param amount amount of contracts
     */
    public void fillRepository(int amount) {
        for (int i = 0; i < amount; i++) {
            addContract(createRandomContract());
        }
    }

    /**
     * Get a contract by its ID
     *
     * @param id contract ID
     * @return contract with a specified ID
     */
    public Contract getContractByID(long id) {
        for (Contract c : contracts) {
            if (c != null && c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    /**
     * Add a contract to repository
     *
     * @param contract new contract
     */
    public void addContract(Contract contract) {
        if (amount == contracts.length) {
            Contract[] biggerMassive = new Contract[contracts.length + 5];
            System.arraycopy(contracts, 0, biggerMassive, 0, contracts.length);
            biggerMassive[amount] = contract;
            contracts = biggerMassive;
        } else {
            contracts[amount] = contract;
        }
        amount++;
    }

    /**
     * Remove a contract from repository
     *
     * @param id id of contract that need to be removed
     */
    public void deleteContract(long id) {
        for (Contract c : contracts) {
            if (c != null && c.getId() == id) {
                contracts = ArrayUtils.removeElement(contracts, c);
                return;
            }
        }
    }

    public void sort(ISorter sorter, Comparator<Contract> comparator) {
        sorter.sort(getContracts(), comparator);
    }

    /**
     * Creates new randomly generated contract
     *
     * @return new contract
     */
    private static Contract createRandomContract() {
        Contract contract = null;
        int id = UUID.randomUUID().hashCode();
        Calendar start = new GregorianCalendar(2000 + (int) (Math.random() * 20), (int) (Math.random() * 12), (int) (Math.random() * 29));
        Calendar end = (Calendar) start.clone();
        end.add(Calendar.YEAR, (int) (1 + Math.random() * 10));
        end.add(Calendar.MONTH, (int) (1 + Math.random() * 12));
        end.add(Calendar.DAY_OF_MONTH, (int) (1 + (Math.random() * 31)));
        Client client = new Client(
                UUID.randomUUID().hashCode(),
                new GregorianCalendar(1950 + (int) (Math.random() * 50), (int) (Math.random() * 12), (int) (Math.random() * 29)),
                Data.fioList.get((int) (Math.random() * Data.fioList.size())),
                Math.random() * 2 > 1 ? "Male" : "Female",
                (1000 + (int) (Math.random() * 9000)) + " " + (100000 + (int) (Math.random() * 900000))
        );

        switch ((int) (Math.random() * 3)) {
            case 0 -> contract = new MobileContract(
                    id,
                    start,
                    end,
                    client,
                    100 + (int) (Math.random() * 1000),
                    1024 + (int) (Math.random() * 10000),
                    100 + (int) (Math.random() * 1000)
            );
            case 1 -> contract = new TeleContract(
                    id,
                    start,
                    end,
                    client,
                    ChannelPackage.values()[(int) (Math.random() * ChannelPackage.values().length)]
            );
            case 2 -> contract = new InternetContract(
                    id,
                    start,
                    end,
                    client,
                    (int) (20 + Math.random() * 300)
            );
        }
        return contract;
    }

    public List<Contract> searchContract(List<Predicate<Contract>> predicates) {
        List<Contract> foundContracts = new ArrayList<>();
        boolean found;
        for (Contract c : contracts) {
            found = true;
            for (Predicate<Contract> p : predicates) {
                if (!p.test(c)) found = false;
            }
            if (found) foundContracts.add(c);
        }
        return foundContracts;
    }

    public ContractParser getParser() {
        return parser;
    }
}
