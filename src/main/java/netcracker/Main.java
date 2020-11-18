package netcracker;

import netcracker.contract.*;
import netcracker.sorter.BubbleSorter;
import netcracker.sorter.ISorter;
import netcracker.sorter.InsertionSorter;
import netcracker.sorter.SelectionSorter;
import netcracker.sorter.comparators.ContractClientFioComparator;
import netcracker.sorter.comparators.ContractEndDateComparator;
import netcracker.sorter.comparators.ContractIdComparator;
import netcracker.sorter.comparators.ContractStartDateComparator;

import java.util.*;

/**
 * @author Vladislav_Styazhkin
 * @version 1.1
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
            System.out.print("1. Вывод\n2. Поиск\n3. Сортировка\n4. Выход\n>");
            switch (in.nextInt()) {
                case 1 -> showContracts();
                case 2 -> searchDialog();
                case 3 -> sortDialog();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Ошибка ввода");
            }
        }
    }

    private static void searchDialog() {

    }

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

    private static void showContracts() {
        for (Contract c : repository.getContracts()) {
            System.out.println(c);
        }
    }
}