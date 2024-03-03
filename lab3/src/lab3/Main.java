package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends JFrame {
    private JTextField arraySizeField;
    private JTextArea arrayInputArea;
    private JTextField numOfBucketsField;
    private JTextArea outputArea;

    public Main() {
        setTitle("Bucket Sort Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JLabel arraySizeLabel = new JLabel("Enter the number of elements in the array:");
        arraySizeField = new JTextField();

        JLabel arrayInputLabel = new JLabel("Enter integers separated by space:");
        arrayInputArea = new JTextArea(3, 20);
        JScrollPane inputScrollPane = new JScrollPane(arrayInputArea);

        JLabel numOfBucketsLabel = new JLabel("Enter the number of buckets:");
        numOfBucketsField = new JTextField();

        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortButtonClicked();
            }
        });

        outputArea = new JTextArea(5, 20);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);

        add(arraySizeLabel);
        add(arraySizeField);
        add(arrayInputLabel);
        add(inputScrollPane);
        add(numOfBucketsLabel);
        add(numOfBucketsField);
        add(sortButton);
        add(outputScrollPane);
    }

    private void sortButtonClicked() {
        try {
            int n = Integer.parseInt(arraySizeField.getText());
            String[] inputNumbers = arrayInputArea.getText().split("\\s+");
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(inputNumbers[i]);
            }

            int numOfBuckets = Integer.parseInt(numOfBucketsField.getText());
            if (numOfBuckets <= 0) {
                outputArea.setText("Number of buckets should be a positive integer. Please try again.");
                return;
            }

            outputArea.append("\nBefore sorting:\n");
            printArray(array);

            BucketSort.bucketSort(array, numOfBuckets);

            outputArea.append("\nAfter Bucket Sort:\n");
            printArray(array);

        } catch (NumberFormatException | InputMismatchException ex) {
            outputArea.setText("Please enter valid integers. Restart the program and try again.");
        }
    }

    private void printArray(int[] array) {
        for (int num : array) {
            outputArea.append(num + " ");
        }
        outputArea.append("\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
                main.setVisible(true);
            }
        });
    }
}
