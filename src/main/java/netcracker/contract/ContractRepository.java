package netcracker.contract;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Repository for storing contracts
 */
public class ContractRepository {

    /**
     * Array of contracts
     */
    private Contract[] contracts;

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
     * Get a netcracker.contract by its ID
     *
     * @param id netcracker.contract ID
     * @return netcracker.contract with a specified ID
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
     * Add a netcracker.contract to repository
     *
     * @param contract new netcracker.contract
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
     * Remove a netcracker.contract from repository
     *
     * @param id id of netcracker.contract that need to be removed
     */
    public void deleteContract(long id) {
        for (Contract c : contracts) {
            if (c != null && c.getId() == id) {
                contracts = ArrayUtils.removeElement(contracts, c);
                return;
            }
        }
    }
}
