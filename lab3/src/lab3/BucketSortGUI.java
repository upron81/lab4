import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSortGUI extends JFrame {
    private JTextField bucketNumberField;
    private JTextField numberField;
    private JPanel sortedArrayPanel;

    private ArrayList<Integer> array = new ArrayList<>();
    private ArrayList<JButton> sortedButtons = new ArrayList<>();

    public BucketSortGUI() {
        setTitle("Bucket Sort Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel bucketNumberLabel = new JLabel("Bucket Number:");
        bucketNumberField = new JTextField(5);

        JLabel numberLabel = new JLabel("Number:");
        numberField = new JTextField(5);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber();
            }
        });

        inputPanel.add(bucketNumberLabel);
        inputPanel.add(bucketNumberField);
        inputPanel.add(numberLabel);
        inputPanel.add(numberField);
        inputPanel.add(addButton);

        sortedArrayPanel = new JPanel();
        sortedArrayPanel.setLayout(new FlowLayout());

        add(inputPanel);
        add(sortedArrayPanel);
    }

    private void addNumber() {
        try {
            int bucketNumber = Integer.parseInt(bucketNumberField.getText());
            int number = Integer.parseInt(numberField.getText());
            array.add(number);
            Collections.sort(array);
            updateSortedButtons();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid integers.");
        }
    }

    private void updateSortedButtons() {
        sortedArrayPanel.removeAll();
        sortedButtons.clear();
        for (int num : array) {
            JButton button = new JButton(String.valueOf(num));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeNumber(num);
                }
            });
            sortedButtons.add(button);
            sortedArrayPanel.add(button);
        }
        sortedArrayPanel.revalidate();
        sortedArrayPanel.repaint();
    }

    private void removeNumber(int number) {
        array.remove(Integer.valueOf(number));
        updateSortedButtons();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BucketSortGUI gui = new BucketSortGUI();
                gui.setVisible(true);
            }
        });
    }
}
