package org.example;

public class Quicksort {
    private static int[] sortedArray;

    public static void sort(int[] array) {
        sortedArray = array.clone();
        quicksort(0, sortedArray.length - 1);
    }

    private static void quicksort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quicksort(low, pivotIndex - 1);
            quicksort(pivotIndex + 1, high);
        }
    }

    private static int partition(int low, int high) {
        int pivot = sortedArray[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (sortedArray[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private static void swap(int i, int j) {
        int temp = sortedArray[i];
        sortedArray[i] = sortedArray[j];
        sortedArray[j] = temp;
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }
}
