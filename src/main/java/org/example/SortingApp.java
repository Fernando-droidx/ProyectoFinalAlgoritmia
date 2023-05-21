package org.example;

import javax.swing.*;
import java.util.Objects;

public class SortingApp extends JFrame {

    private JButton button100;
    private JButton button1000;
    private JButton button10000;
    private JButton button100000;
    private JTextArea originalArrayTextArea;
    private JTextArea sortedArrayTextArea;
    private JLabel labelTime;
    private JComboBox<String> algorithmComboBox;

    public SortingApp() {
        initializeUI();
        setListeners();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(440, 650);
        setLayout(null);

        button100 = new JButton("Sort 100");
        button100.setBounds(50, 30, 100, 30);
        add(button100);

        button1000 = new JButton("Sort 1000");
        button1000.setBounds(160, 30, 100, 30);
        add(button1000);

        button10000 = new JButton("Sort 10000");
        button10000.setBounds(270, 30, 100, 30);
        add(button10000);

        button100000 = new JButton("Sort 100000");
        button100000.setBounds(120, 80, 150, 30);
        add(button100000);

        originalArrayTextArea = new JTextArea();
        JScrollPane originalScrollPane = new JScrollPane(originalArrayTextArea);
        originalScrollPane.setBounds(50, 130, 320, 200);
        add(originalScrollPane);

        sortedArrayTextArea = new JTextArea();
        JScrollPane sortedScrollPane = new JScrollPane(sortedArrayTextArea);
        sortedScrollPane.setBounds(50, 350, 320, 200);
        add(sortedScrollPane);

        labelTime = new JLabel("Tiempo de ejecucion: ");
        labelTime.setBounds(50, 570, 300, 30);
        add(labelTime);

        JLabel algorithmLabel = new JLabel("Algoritmo de Ordenamiento:");
        algorithmLabel.setBounds(60, 10, 160, 20);
        add(algorithmLabel);

        algorithmComboBox = new JComboBox<>();
        algorithmComboBox.addItem("Bubble Sort");
        algorithmComboBox.addItem("Selection Sort");
        algorithmComboBox.addItem("Insertion Sort");
        algorithmComboBox.addItem("Count Sort");
        algorithmComboBox.addItem("Merge Sort");
        algorithmComboBox.addItem("Heap Sort"); // Agregado el algoritmo Heap Sort al menú desplegable
        algorithmComboBox.setBounds(230, 10, 150, 20);
        add(algorithmComboBox);

        setResizable(false);
        setVisible(true);
    }

    private void setListeners() {
        button100.addActionListener(e -> {
            int[] array = generateRandomArray(100);
            long startTime = System.nanoTime();
            sortArray(array);
            long endTime = System.nanoTime();
            long executionTimeMs = (endTime - startTime) / 1_000_000;
            long executionTimeNs = endTime - startTime;

            labelTime.setText("Tiempo de ejecucion: " + executionTimeMs + " ms, " + executionTimeNs + " ns");
            displayArrays(array);
        });

        button1000.addActionListener(e -> {
            int[] array = generateRandomArray(1000);
            long startTime = System.nanoTime();
            sortArray(array);
            long endTime = System.nanoTime();
            long executionTimeMs = (endTime - startTime) / 1_000_000;
            long executionTimeNs = endTime - startTime;

            labelTime.setText("Tiempo de ejecucion: " + executionTimeMs + " ms, " + executionTimeNs + " ns");
            displayArrays(array);
        });

        button10000.addActionListener(e -> {
            int[] array = generateRandomArray(10000);
            long startTime = System.nanoTime();
            sortArray(array);
            long endTime = System.nanoTime();
            long executionTimeMs = (endTime - startTime) / 1_000_000;
            long executionTimeNs = endTime - startTime;

            labelTime.setText("Tiempo de ejecucion: " + executionTimeMs + " ms, " + executionTimeNs + " ns");
            displayArrays(array);
        });

        button100000.addActionListener(e -> {
            int[] array = generateRandomArray(100000);
            long startTime = System.nanoTime();
            sortArray(array);
            long endTime = System.nanoTime();
            long executionTimeMs = (endTime - startTime) / 1_000_000;
            long executionTimeNs = endTime - startTime;

            labelTime.setText("Tiempo de ejecucion: " + executionTimeMs + " ms, " + executionTimeNs + " ns");
            displayArrays(array);
        });
    }

    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }

    private void sortArray(int[] array) {
        String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
        switch (Objects.requireNonNull(selectedAlgorithm)) {
            case "Bubble Sort" -> BubbleSort.sort(array);
            case "Selection Sort" -> SelectionSort.sort(array);
            case "Insertion Sort" -> InsertionSort.sort(array);
            case "Count Sort" -> CountSort.sort(array);
            case "Merge Sort" -> MergeSort.sort(array);
            case "Heap Sort" -> HeapSort.sort(array); // Agregado el caso para el algoritmo Heap Sort
            default ->
                // Default to Bubble Sort
                    BubbleSort.sort(array);
        }
    }

    private void displayArrays(int[] array) {
        StringBuilder originalArrayString = new StringBuilder();
        StringBuilder sortedArrayString = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            originalArrayString.append(array[i]).append(" ");
            if ((i + 1) % 13 == 0) {
                originalArrayString.append("\n");
            }
        }

        int[] sortedArray = getSortedArray();
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArrayString.append(sortedArray[i]).append(" ");
            if ((i + 1) % 13 == 0) {
                sortedArrayString.append("\n");
            }
        }

        originalArrayTextArea.setText("Arreglo Original:\n" + originalArrayString);
        sortedArrayTextArea.setText("Arreglo ordenado:\n" + sortedArrayString);
    }

    private int[] getSortedArray() {
        String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
        assert selectedAlgorithm != null;
        return switch (selectedAlgorithm) {
            case "Bubble Sort" -> BubbleSort.getSortedArray();
            case "Selection Sort" -> SelectionSort.getSortedArray();
            case "Insertion Sort" -> InsertionSort.getSortedArray();
            case "Count Sort" -> CountSort.getSortedArray();
            case "Merge Sort" -> MergeSort.getSortedArray();
            case "Heap Sort" -> HeapSort.getSortedArray(); // Agregado el caso para el algoritmo Heap Sort
            default -> new int[0];
        };
    }

    public static void main(String[] args) {
        new SortingApp();
    }
}
