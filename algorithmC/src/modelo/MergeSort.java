/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author JuanJose FS
 */
public class MergeSort {
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 

    public static void merge(Integer arr[], int l, int m, int r) 

    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        ArrayList<Integer> L=new ArrayList<>(n1);
        ArrayList<Integer> R=new ArrayList<>(n2); 
        
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L.set(i, l+i); 
        for (int j=0; j<n2; ++j) 
            L.set(j, m+l+j); 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L.get(i)<=R.get(j)) 
            { 
                arr.set(k, L.get(i)); 
                i++; 
            } 
            else
            { 
                arr.set(k, R.get(j)); 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr.set(k, L.get(i)); 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr.set(k,R.get(j));
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 

    public static void sort(Integer arr[], int l, int r) 
    {

        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r);  
        } 
    } 
    
    public static void printArray(Integer arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 

}
