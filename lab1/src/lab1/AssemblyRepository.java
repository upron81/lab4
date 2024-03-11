package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssemblyRepository {
    private final List<Assembly> assemblies; // Использование final для неизменяемых полей

    public AssemblyRepository() {
        this.assemblies = new ArrayList<>();
    }

    public void addAssembly(Assembly assembly) {
        this.assemblies.add(assembly);
    }

    public boolean deleteAssembly(String name) {
        return assemblies.removeIf(assembly -> assembly.getName().equals(name));
    }

    public Assembly findAssemblyByName(String name) {
        // Использование Stream API для упрощения поиска
        return assemblies.stream()
                .filter(assembly -> assembly.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Assembly> getAllAssemblies() {
        // Возвращение копии списка для предотвращения изменения исходного списка
        return new ArrayList<>(assemblies);
    }

    public void updateAssembly(String name, Assembly updatedAssembly) {
        // Использование Stream API для оптимизации обновления
        for (int i = 0; i < assemblies.size(); i++) {
            if (assemblies.get(i).getName().equals(name)) {
                assemblies.set(i, updatedAssembly);
                break;
            }
        }
    }
}
