package menu;

import command.*;
import io.NecklaceIO;
import stones.Stone;
import necklace.Necklace;
import stones.PreciousStone;
import stones.SemiPreciousStone;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private MenuInvoker invoker = new MenuInvoker();
    private Necklace necklace = new Necklace();
    private static final String FILE_NAME = "C:/Users/proko/Desktop/log.txt";

    public Menu() {
        invoker.setCommand(1, new AddPreciousStoneCommand(this));
        invoker.setCommand(2, new AddSemiPreciousStoneCommand(this));
        invoker.setCommand(3, new CalculateTotalWeightCommand(this));
        invoker.setCommand(4, new CalculateTotalCostCommand(this));
        invoker.setCommand(5, new SortStonesByCostCommand(this));
        invoker.setCommand(6, new LoadNecklaceCommand(this));
        invoker.setCommand(7, new SaveNecklaceCommand(this));
        invoker.setCommand(8, new FindStonesByTransparencyCommand(this));
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати дорогоцінний камінь");
            System.out.println("2. Додати напівкоштовний камінь");
            System.out.println("3. Підрахувати загальну вагу");
            System.out.println("4. Підрахувати загальну вартість");
            System.out.println("5. Сортувати камені за вартістю");
            System.out.println("6. Завантажити з файлу");
            System.out.println("7. Зберегти у файл");
            System.out.println("8. Знайти камені за прозорістю");
            System.out.println("0. Вийти");
            System.out.print("Ваш вибір: ");

            int choice = getValidInput(scanner);
            if (choice == 0) {
                break;
            }
            invoker.executeCommand(choice);
        }
    }

    int getValidInput(Scanner scanner) {
        int choice = -1;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice < 0 || choice > 8) {
                    System.out.println("Помилка: Введіть число від 0 до 8.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Помилка: Введіть ціле число.");
                scanner.next();
            }
        }
        return choice;
    }

    public void addStone(boolean isPrecious) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Назва каменя: ");
        String name = scanner.nextLine();
        System.out.print("Вага в каратах: ");
        double weight = getValidDoubleInput(scanner);
        System.out.print("Вартість: ");
        double cost = getValidDoubleInput(scanner);
        System.out.print("Прозорість (0.0 - 1.0): ");
        double transparency = getValidDoubleInput(scanner);

        if (isPrecious) {
            necklace.addStone(new PreciousStone(name, weight, cost, transparency));
        } else {
            necklace.addStone(new SemiPreciousStone(name, weight, cost, transparency));
        }
    }

    double getValidDoubleInput(Scanner scanner) {
        double value = -1;
        while (true) {
            try {
                value = scanner.nextDouble();
                if (value <= 0) {
                    System.out.println("Помилка: Введіть позитивне число.");
                    System.out.print("Повторіть введення: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Помилка: Введіть дійсне число.");
                System.out.print("Повторіть введення: ");
                scanner.next();
            }
        }
        return value;
    }

    public Necklace getNecklace() {
        return necklace;
    }

    public void saveNecklace() {
        try {
            NecklaceIO.saveToFile(necklace, FILE_NAME);
            System.out.println("Збережено успішно у файл: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Помилка при збереженні файлу: " + e.getMessage());
        }
    }

    public void loadNecklace() {
        try {
            NecklaceIO.loadFromFile(necklace, FILE_NAME);
            System.out.println("Завантажено успішно з файлу: " + FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка при завантаженні файлу: " + e.getMessage());
        }
    }

    public void displaySortedStones() {
        necklace.sortStonesByCost();
        System.out.println("Камені відсортовані за вартістю:");
        for (Stone stone : necklace.getStones()) {
            System.out.println(stone.getName() + " - Вартість: " + stone.getCost());
        }
    }

    public void findStonesByTransparency() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Мінімальна прозорість (0.0 - 1.0): ");
        double minTransparency = getValidDoubleInput(scanner);
        System.out.print("Максимальна прозорість (0.0 - 1.0): ");
        double maxTransparency = getValidDoubleInput(scanner);

        System.out.println("Камені з прозорістю від " + minTransparency + " до " + maxTransparency + ":");
        for (Stone stone : necklace.findStonesByTransparency(minTransparency, maxTransparency)) {
            System.out.println(stone.getName() + " - Прозорість: " + stone.getTransparency());
        }
    }
}
