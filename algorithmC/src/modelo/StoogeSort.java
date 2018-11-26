/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

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
    public void sort(ArrayList<Integer> arr, Integer l, Integer h) {
        if (l >= h) {
            return;
        }
        // if (arr[l] > arr[h]) { 
        if (arr.get(l) > arr.get(h)) {
            // Integer t = arr[l]; 
            int t = arr.get(l);
            //  arr[l] = arr[h]; 

            arr.set(l, arr.get(h));
            // arr[h] = t; 
            arr.set(h, t);
        }

        if (h - l + 1 > 2) {
            Integer t = (h - l + 1) / 3;
            sort(arr, l, h - t);
            sort(arr, l + t, h);
            sort(arr, l, h - t);
        }
    }
}
