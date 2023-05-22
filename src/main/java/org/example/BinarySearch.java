package org.example;

import java.util.Arrays;

public class BinarySearch{


    public void mostrar(int[] searchValues, int[] arr){
        //
        Arrays.sort(arr);
        // Valores a buscar
        //seria el searchValues

        // Realizamos la búsqueda binaria para cada valor
        for (int i = 0; i < searchValues.length; i++) {
            int value = searchValues[i];
            int result = binarySearch(arr, value);
            System.out.println("Búsqueda para el valor " + value + ": " + result);
        }

    }

    // Implementación de la búsqueda binaria
    public static int binarySearch(int[] arr, int value) {
        int left = 0;//inicio
        int right = arr.length - 1;//final

        while (left <= right) {
            int mid = left + (right - left) / 2;//obtenemos el centro del array
            System.out.println("Comparando " + value + " con " + arr[mid]);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}