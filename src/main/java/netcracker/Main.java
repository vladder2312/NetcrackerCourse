package netcracker;

import netcracker.contract.*;

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
        for (Contract c : repository.getContracts()) {
            System.out.println(c);
        }
        while (true){
            System.out.println("1. Поиск\n2. Сортировка\n3. Выход\n>");
            int selected = in.nextInt();
            switch (selected){
                case 1 -> searchDialog();
                case 2 -> sortDialog();
                case 3 -> { return; }
                default -> System.out.println("Ошибка ввода");
            }
        }
    }

    private static void searchDialog() {

    }

    private static void sortDialog() {

    }
}