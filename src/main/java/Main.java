import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    private static final ContractRepository repository = new ContractRepository();

    public static void main(String[] args) {
        fillRepository(50);
        for (Contract c: repository.getAllContracts()) {
            System.out.println(c);
        }
    }

    private static Contract createRandomContract() {
        Contract contract = null;
        long id = System.currentTimeMillis();
        Calendar start = new GregorianCalendar(2000 + (int) (Math.random() * 20), (int) (Math.random() * 12), (int) (Math.random() * 29));
        Calendar end = (Calendar) start.clone();
        end.add(Calendar.YEAR, (int) (Math.random() * 10));
        end.add(Calendar.MONTH, (int) (Math.random() * 12));
        end.add(Calendar.DAY_OF_MONTH, (int) (Math.random() * 31));
        Client client = new Client(
                System.currentTimeMillis(),
                new GregorianCalendar(2000 + (int) (Math.random() * 20), (int) (Math.random() * 12), (int) (Math.random() * 29)),
                Data.fioList.get((int) (Math.random() * Data.fioList.size())),
                Math.random() * 2 > 1 ? "Мужской" : "Женский",
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
                    ChanelKit.values()[(int) (Math.random() * ChanelKit.values().length)]
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

    private static void fillRepository(int count) {
        for (int i = 0; i < count; i++) {
            repository.addContract(createRandomContract());
        }
    }
}