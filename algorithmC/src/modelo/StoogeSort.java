/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Tiffy
 */
public class StoogeSort {

    /**
     * Constructor de la clase
     */
    public StoogeSort() {
    }

    /**
     * Metodo que implementa StoogeSort. Referencias:
     * https://www.geeksforgeeks.org/stooge-sort/
     *
     * @param arr, arreglo a ordenar
     * @param l, parametro desde donde iniciar
     * @param h el tamaño del arreglo,
     */
    public static void sort(Integer arr[], Integer l, Integer h) {
        if (l >= h) {
            return;
        }
         if (arr[l] > arr[h]) { 
            int t = arr[l];
            arr[l] = arr[h]; 
            arr[h] = t; 
        }

        if (h - l + 1 > 2) {
            Integer t = (h - l + 1) / 3;
            sort(arr, l, h - t);
            sort(arr, l + t, h);
            sort(arr, l, h - t);
        }
    }
    
    /**
     * Método que imprime el arreglo
     * @param arr 
     */
    public static void printArray(Integer arr[]) 
    { 
        System.out.println("Stooge sort: ");
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
    
}
