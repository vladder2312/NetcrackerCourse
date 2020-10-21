public class ContractRepository {
    private Contract[] contracts;
    private int amount;

    public ContractRepository() {
        contracts = new Contract[10];
        amount = 0;
    }

    public Contract[] getAllContracts() {
        return contracts;
    }

    public Contract getContractByID(long id) {
        for (Contract c: contracts) {
            if(c.getId()==id){
                return c;
            }
        }
        return null;
    }

    public void addContract(Contract contract){
        if(amount==contracts.length){
            Contract[] biggerMassive = new Contract[contracts.length+5];
            System.arraycopy(contracts, 0, biggerMassive, 0, contracts.length);
            biggerMassive[amount]=contract;
            contracts = biggerMassive;
        } else {
            contracts[amount]=contract;
        }
        amount++;
    }
}
