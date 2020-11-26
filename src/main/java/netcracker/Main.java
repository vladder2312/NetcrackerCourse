package netcracker;

import netcracker.contract.*;
import netcracker.contract.models.Contract;
import netcracker.sorter.BubbleSorter;
import netcracker.sorter.ISorter;
import netcracker.sorter.InsertionSorter;
import netcracker.sorter.SelectionSorter;
import netcracker.sorter.comparators.ContractClientFioComparator;
import netcracker.sorter.comparators.ContractEndDateComparator;
import netcracker.sorter.comparators.ContractIdComparator;
import netcracker.sorter.comparators.ContractStartDateComparator;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author Vladislav_Styazhkin
 * @version 1.2
 */
public class Main {

    private static final ContractRepository repository = new ContractRepository();
    private static final Scanner in = new Scanner(System.in);

    /**
     * Start point of the program
     *
     * @param args command line values
     */
    public static void main(String[] args) {
        repository.fillRepository(50);
        while (true) {
            System.out.print("1. Вывод\n2. Поиск\n3. Сортировка\n4. Добавить из файла\n5. Выход\n>");
            switch (in.nextInt()) {
                case 1 -> showContracts();
                case 2 -> searchDialog();
                case 3 -> sortDialog();
                case 4 -> fromFileDialog();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Ошибка ввода");
            }
        }
    }

    /**
     * Dialog with user to get file path. Adding contracts from a file to the repository.
     */
    private static void fromFileDialog() {
        System.out.print("Введите полный путь к файлу > ");
        try {
            for(Contract contract : repository.getParser().readFile(new FileReader(in.next()))){
                repository.addContract(contract);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Dialog with the user to initialize the search parameters
     * */
    private static void searchDialog() {
        List<Predicate<Contract>> predicates = new ArrayList<>();
        int select;
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date date;

        do {
            System.out.print("Выбрите критерии поиска:\n1. ID\n2. Дата начала\n3. Дата конца\n4. ФИО клиента\n5. Готово\n>");
            select = in.nextInt();
            if(select==5) break;
            System.out.print("Введите значение >");
            switch (select) {
                case 1 -> {
                    long id = in.nextLong();
                    predicates.add(contract -> contract.getId() == id);
                }
                case 2 -> {
                    try {
                        date = df.parse(in.next());
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("Ошибка ввода");
                        return;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    predicates.add(contract -> contract.getStartDate().equals(calendar));
                }
                case 3 -> {
                    try {
                        date = df.parse(in.next());
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("Ошибка ввода");
                        return;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    predicates.add(contract -> contract.getEndDate().equals(calendar));
                }
                case 4 -> {
                    in.nextLine();
                    String fio = in.nextLine();
                    predicates.add(contract -> contract.getClient().getFio().toLowerCase().contains(fio.toLowerCase()));
                }
                default -> System.out.println("Ошибка ввода");
            }
        } while (true);
        System.out.println("Найденные контракты: ");
        for(Contract c : repository.searchContract(predicates)){
            System.out.println(c);
        }
    }

    /**
     * Dialog with the user to initialize the sort parameters
     * */
    private static void sortDialog() {
        ISorter sorter;
        Comparator<Contract> comparator;
        System.out.print("Метод сортировки:\n1. Пузырьковый\n2. Вставками\n3. Выбором\n>");
        switch (in.nextInt()) {
            case 1 -> sorter = new BubbleSorter();
            case 2 -> sorter = new InsertionSorter();
            case 3 -> sorter = new SelectionSorter();
            default -> {
                System.out.println("Ошибка ввода");
                return;
            }
        }
        System.out.print("Выбрите критерий сортировки:\n1. ID\n2. Дата начала\n3. Дата конца\n4. ФИО клиента\n>");
        switch (in.nextInt()) {
            case 1 -> comparator = new ContractIdComparator();
            case 2 -> comparator = new ContractStartDateComparator();
            case 3 -> comparator = new ContractEndDateComparator();
            case 4 -> comparator = new ContractClientFioComparator();
            default -> {
                System.out.println("Ошибка ввода");
                return;
            }
        }
        repository.sort(sorter, comparator);
    }

    /**
     * Print all contracts to console
     */
    private static void showContracts() {
        for (Contract c : repository.getContracts()) {
            System.out.println(c);
        }
    }
}