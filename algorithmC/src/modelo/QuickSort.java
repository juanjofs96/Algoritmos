/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class QuickSort {
    /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
    
    /** 
     * Metodo que divide el arreglo
     * @param arr
     * @param low
     * @param high
     * @return 
     */
    private static int partition( Integer arr[], int low, int high) 
    { 
            int pivot = arr[high];
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot)
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp =arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    
    /** 
     * Metodo Recursivo de Ordenamiento
     * Referencia: https://www.geeksforgeeks.org/quick-sort/
     * @param arr
     * @param low
     * @param high
     */
    public static void sort(Integer arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
  
    /* A utility function to print array of size n */
    public static void printArray(Integer arr[]) 
    { 
        System.out.println("Quick sort: ");
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
}
