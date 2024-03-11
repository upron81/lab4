package lab1;

import java.util.ArrayList;
import java.util.List;

public class AssemblyRepository {
    private List<Assembly> assemblies;

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
        for (Assembly assembly : assemblies) {
            if (assembly.getName().equals(name)) {
                return assembly;
            }
        }
        return null;
    }

    public List<Assembly> getAllAssemblies() {
        return new ArrayList<>(assemblies);
    }

    public void updateAssembly(String name, Assembly updatedAssembly) {
        for (int i = 0; i < assemblies.size(); i++) {
            if (assemblies.get(i).getName().equals(name)) {
                assemblies.set(i, updatedAssembly);
                break;
            }
        }
    }
}
