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
    void sort(ArrayList array) 
    { 
        int n = array.size(); 
        for (int i=1; i<n; ++i) 
        {
            int key = (int) (array.get(i));
            //Integer a=array.get(i);
            int j = i-1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && (int)(array.get(j)) > key) 
            { 
                
                array.set(j+1,array.get(j)); 
                j = j-1; 
            }
            
            array.set(j+1,key); 
        } 
    
    } 
    
    
    
}
