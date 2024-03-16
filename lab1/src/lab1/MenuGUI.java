package lab1;

import javax.swing.*;
import java.awt.*;

public class MenuGUI extends JFrame {
    private final AssemblyRepository assemblyRepository;
    private final JPanel assemblyPanel;
    private final JTextField assemblyNameField, boltFormField, boltMaterialField, gearFormField, gearMaterialField;
    private final JButton addAssemblyButton;

    public MenuGUI() {
        assemblyRepository = new AssemblyRepository();
        assemblyPanel = new JPanel();
        assemblyPanel.setLayout(new BoxLayout(assemblyPanel, BoxLayout.Y_AXIS));
        assemblyNameField = new JTextField(20);
        boltFormField = new JTextField(20);
        boltMaterialField = new JTextField(20);
        gearFormField = new JTextField(20);
        gearMaterialField = new JTextField(20);
        addAssemblyButton = new JButton("Добавить");

        setupUI();
    }

    private void setupUI() {
        setTitle("Управление сборками");
        setSize(600, 400); // Adjusted for additional fields
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2)); // Use GridLayout for structured layout
        inputPanel.add(new JLabel("Название сборки:"));
        inputPanel.add(assemblyNameField);
        inputPanel.add(new JLabel("Форма болта:"));
        inputPanel.add(boltFormField);
        inputPanel.add(new JLabel("Материал болта:"));
        inputPanel.add(boltMaterialField);
        inputPanel.add(new JLabel("Форма шестерни:"));
        inputPanel.add(gearFormField);
        inputPanel.add(new JLabel("Материал шестерни:"));
        inputPanel.add(gearMaterialField);
        inputPanel.add(addAssemblyButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(assemblyPanel), BorderLayout.CENTER);

        addAssemblyButton.addActionListener(e -> addAssembly());

        setVisible(true);
    }

    private void addAssembly() {
        String name = assemblyNameField.getText();
        String boltForm = boltFormField.getText();
        String boltMaterial = boltMaterialField.getText();
        String gearForm = gearFormField.getText();
        String gearMaterial = gearMaterialField.getText();

        if (!name.isEmpty() && !boltForm.isEmpty() && !boltMaterial.isEmpty() && !gearForm.isEmpty() && !gearMaterial.isEmpty()) {
            Assembly assembly = new Assembly(name, boltForm, boltMaterial, gearForm, gearMaterial); // Adjusted constructor call
            assemblyRepository.addAssembly(assembly);

            // Adjusted to include form and material in the button label
            String buttonLabel = String.format("%s (болт: %s, %s; шестерня: %s, %s)", name, boltForm, boltMaterial, gearForm, gearMaterial);

            JButton assemblyButton = new JButton(buttonLabel);
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
            // Clear the form and material fields
            boltFormField.setText("");
            boltMaterialField.setText("");
            gearFormField.setText("");
            gearMaterialField.setText("");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuGUI::new);
    }
}
