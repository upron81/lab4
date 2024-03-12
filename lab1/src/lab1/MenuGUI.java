package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private final AssemblyRepository assemblyRepository;
    private final JPanel assemblyPanel;
    private final JTextField assemblyNameField;
    private final JButton addAssemblyButton;

    public Menu() {
        assemblyRepository = new AssemblyRepository();
        assemblyPanel = new JPanel();
        assemblyPanel.setLayout(new BoxLayout(assemblyPanel, BoxLayout.Y_AXIS));
        assemblyNameField = new JTextField(20);
        addAssemblyButton = new JButton("Добавить");

        setupUI();
        initializeAssemblies();
    }

    private void setupUI() {
        setTitle("Управление сборками");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Название сборки:"));
        inputPanel.add(assemblyNameField);
        inputPanel.add(addAssemblyButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(assemblyPanel), BorderLayout.CENTER);

        addAssemblyButton.addActionListener(e -> addAssembly());

        setVisible(true);
    }

    private void addAssembly() {
        String name = assemblyNameField.getText();
        if (!name.isEmpty()) {
            Assembly assembly = new Assembly(name);
            assemblyRepository.addAssembly(assembly);
            JButton assemblyButton = new JButton(name);
            assemblyButton.addActionListener(e -> {
                assemblyRepository.deleteAssembly(name);
                assemblyPanel.remove(assemblyButton);
                assemblyPanel.revalidate();
                assemblyPanel.repaint();
            });
            assemblyPanel.add(assemblyButton);
            assemblyPanel.revalidate();
            assemblyPanel.repaint();
            assemblyNameField.setText("");
        }
    }

    private void initializeAssemblies() {
        // Можно добавить начальные сборки, если это необходимо
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}
