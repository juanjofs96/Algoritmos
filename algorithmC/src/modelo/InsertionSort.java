/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Tony
 */
public class InsertionSort {
    
    /*
        Código fuente tomado de:
        https://www.geeksforgeeks.org/insertion-sort/
    */
    
    /*Function to sort array using insertion sort*/
    public static void sort(Integer arr[]) 
    { 
        int n = arr.length; 
        for (int i=1; i<n; ++i) 
        {
            int key = (int) (arr[i]);
            int j = i-1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && (int)(arr[j]) > key) 
            { 
                
                arr[j+1]=arr[j]; 
                j = j-1; 
            }
            
            arr[j+1]=key; 
        } 
    
    } 
    
    public static void printArray(Integer arr[]) 
    { 
        System.out.println("Insertion sort: ");
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
    
    
}
