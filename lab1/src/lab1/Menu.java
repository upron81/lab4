package lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private List<Assembly> assemblies;
    private Scanner scanner;

    public Menu() {
        assemblies = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeAssemblies(); // Инициализация списка сборок при создании объекта меню
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("Меню:");
            System.out.println("1. Добавить сборку");
            System.out.println("2. Удалить сборку");
            System.out.println("3. Вывести список сборок");
            System.out.println("4. Подсчитать общий вес деталей с одинаковой формой");
            System.out.println("5. Вывести количество деталей");
            System.out.println("6. Вывести деталь, которая отличается своей формой");
            System.out.println("7. Выйти из программы");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addAssembly();
                    break;
                case 2:
                    deleteAssembly();
                    break;
                case 3:
                    displayAssemblies();
                    break;
                case 4:
                    calculateTotalWeightByForm();
                    break;
                case 5:
                    displayTotalAssemblyCount();
                    break;
                case 6:
                    displayDistinctAssembly();
                    break;
                case 7:
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неверный выбор. Повторите попытку.");
            }
        } while (choice != 7);
    }

    private void addAssembly() {
        System.out.print("Введите имя сборки: ");
        String name = scanner.nextLine();
        Assembly assembly = new Assembly(name);
        assemblies.add(assembly);
        System.out.println("Сборка добавлена.");
    }

    private void deleteAssembly() {
        if (assemblies.isEmpty()) {
            System.out.println("Список сборок пуст.");
            return;
        }
        System.out.println("Выберите номер сборки для удаления (начиная с 1): ");
        displayAssemblies();
        int index = scanner.nextInt();
        if (index > 0 && index <= assemblies.size()) {
            assemblies.remove(index - 1);
            System.out.println("Сборка удалена.");
        } else {
            System.out.println("Некорректный номер сборки.");
        }
    }

    private void displayAssemblies() {
        if (assemblies.isEmpty()) {
            System.out.println("Список сборок пуст.");
            return;
        }
        System.out.println("Список сборок:");
        for (int i = 0; i < assemblies.size(); i++) {
            System.out.println((i + 1) + ". " + assemblies.get(i));
        }
    }

    private void initializeAssemblies() {
        assemblies.add(new Assembly("1"));
        assemblies.add(new Assembly("2"));
        assemblies.add(new Assembly("3"));
        // Добавьте остальные сборки сюда
    }

    private void calculateTotalWeightByForm() {
        Map<String, Double> totalWeights = new HashMap<>();
        for (Assembly assembly : assemblies) {
            Bolt bolt = assembly.getBolt();
            Gear gear = assembly.getGear();

            String boltForm = bolt.getForm();
            double boltWeight = bolt.getWeight();
            totalWeights.put(boltForm, totalWeights.getOrDefault(boltForm, 0.0) + boltWeight);

            String gearForm = gear.getForm();
            double gearWeight = gear.getWeight();
            totalWeights.put(gearForm, totalWeights.getOrDefault(gearForm, 0.0) + gearWeight);
        }
        for (Map.Entry<String, Double> entry : totalWeights.entrySet()) {
            System.out.println("Форма: " + entry.getKey() + ", Общий вес: " + entry.getValue());
        }
    }




    private void displayTotalAssemblyCount() {
        System.out.println("Общее количество сборок: " + assemblies.size());
    }

    private void displayDistinctAssembly() {
        // Предположим, что у нас есть метод для вывода сборки, отличающейся своим именем
        // или просто выведем первую сборку из списка
        if (!assemblies.isEmpty()) {
            Assembly distinctAssembly = assemblies.get(0);
            System.out.println("Сборка с отличающимся именем: " + distinctAssembly.getName());
        } else {
            System.out.println("Список сборок пуст.");
        }
    }
}
