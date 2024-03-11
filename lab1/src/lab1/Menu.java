package lab1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private AssemblyRepository assemblyRepository;
    private Scanner scanner;

    public Menu() {
        assemblyRepository = new AssemblyRepository();
        scanner = new Scanner(System.in);
        initializeAssemblies();
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("Меню:");
            System.out.println("1. Добавить сборку");
            System.out.println("2. Удалить сборку");
            System.out.println("3. Вывести список сборок");
            System.out.println("4. Подсчитать общий вес деталей с одинаковой формой");
            System.out.println("5. Вывести количество сборок");
            System.out.println("6. Выйти из программы");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine();
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
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неверный выбор. Повторите попытку.");
            }
        } while (choice != 6);
    }

    private void addAssembly() {
        System.out.print("Введите имя сборки: ");
        String name = scanner.nextLine();
        Assembly assembly = new Assembly(name);
        assemblyRepository.addAssembly(assembly);
        System.out.println("Сборка добавлена.");
    }

    private void deleteAssembly() {
        System.out.println("Выберите номер сборки для удаления (начиная с 1): ");
        displayAssemblies();
        int index = scanner.nextInt();
        if (index > 0 && index <= assemblyRepository.getAllAssemblies().size()) {
            Assembly toDelete = assemblyRepository.getAllAssemblies().get(index - 1);
            assemblyRepository.deleteAssembly(toDelete.getName());
            System.out.println("Сборка удалена.");
        } else {
            System.out.println("Некорректный номер сборки.");
        }
    }

    private void displayAssemblies() {
        var assemblies = assemblyRepository.getAllAssemblies();
        if (assemblies.isEmpty()) {
            System.out.println("Список сборок пуст.");
            return;
        }
        System.out.println("Список сборок:");
        for (int i = 0; i < assemblies.size(); i++) {
            System.out.println((i + 1) + ". " + assemblies.get(i));
        }
    }

    private void calculateTotalWeightByForm() {
        Map<String, Double> totalWeights = new HashMap<>();
        for (Assembly assembly : assemblyRepository.getAllAssemblies()) {
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
        System.out.println("Общее количество сборок: " + assemblyRepository.getAllAssemblies().size());
    }

    private void initializeAssemblies() {
        assemblyRepository.addAssembly(new Assembly("1"));
        assemblyRepository.addAssembly(new Assembly("2"));
        assemblyRepository.addAssembly(new Assembly("3"));
    }
}
