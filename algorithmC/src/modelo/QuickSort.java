/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Carlos
 */
public class QuickSort {

    /**
     * Metodo que divide el arreglo
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(Integer arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    /**
     * Metodo Recursivo de Ordenamiento Referencia:
     * https://www.geeksforgeeks.org/quick-sort/
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void sort(Integer arr[], int low, int high) {
        if (low < high) {
             int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /**
     * Método que imprime el arreglo
     *
     * @param arr
     */
    public static void printArray(Integer arr[]) {
        System.out.println("Quick sort: ");
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
