/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.InsertionSort;
import modelo.MergeSort;
import modelo.QuickSort;
import modelo.StoogeSort;

/**
 *
 * @author Tiffy
 */
public class Sort {
    private Integer[] arr_forMerge;
    private Integer[] arr_forInsert;
    private Integer[] arr_forQuick;
    private Integer[] arr_forStooge;
    private ArrayList<Double> timeMerge;
    private ArrayList<Double> timeInsert;
    private ArrayList<Double> timeQuick;
    private ArrayList<Double> timeStooge;
    private int cantidad_elementos;
    private boolean m, q, i, s;
    private List<Integer> arraylist;

    /**
     * Constructor de la clase
     * @param arraylist, Arreglo con los elementos del archivo
     * @param m, boolean ,indica si el usuario quiere comparar el Algoritmo Mergesort
     * @param q, boolean ,indica si el usuario quiere comparar el Algoritmo Quicksort
     * @param i,  boolean ,indica si el usuario quiere comparar el Algoritmo Insertionsort
     * @param s,  boolean ,indica si el usuario quiere comparar el Algoritmo Stoogesort
     */
    public Sort(List<Integer> arraylist, boolean m, boolean q, boolean i, boolean s) {
        this.cantidad_elementos = arraylist.size();
        //this.arraylist = new ArrayList<>();//
        this.arraylist = arraylist;
        //variables booleanas
        this.m = m;
        this.q = q;
        this.i = i;
        this.s = s;

        //inicializa los arreglos que contendrán el tiempo
        timeStooge = new ArrayList<>();
        timeQuick = new ArrayList<>();
        timeMerge = new ArrayList<>();
        timeInsert = new ArrayList<>();
    }

    /**
     * Método que permite tomar los tiempos de ejecución
     */
    public void allSort() {
        //size es la cantidad de elementos que se van a ir ordenando, no está a escala
        //y no está validado para que funcione con la interfaz aun
        for (int size = 10; size <= this.cantidad_elementos;) {
            if (s) {
                readForStooge(size);
                System.out.println("\n StoogeSort cantidad de elementos: " + size);
                double timeStart = System.currentTimeMillis();
                StoogeSort.sort(arr_forStooge, 0, size - 1);
                StoogeSort.printArray(arr_forStooge);
                double timeEnd = System.currentTimeMillis();
                timeStooge.add((timeEnd - timeStart));
            }
            if (q) {
                System.out.println("QUICKSORT cantidad de elementos " + size);
                readForQuick(size);
                double timeStart1 = System.currentTimeMillis();
                QuickSort.sort(arr_forQuick, 0, size - 1);
                QuickSort.printArray(arr_forQuick);
                double timeEnd1 = System.currentTimeMillis();
                timeQuick.add((timeEnd1 - timeStart1));
            }
            if (m) {
                System.out.println("MergeSORT cantidad de elementos: " + size);
                readForMerge(size);
                double timeStart2 = System.currentTimeMillis();
                MergeSort.sort(arr_forMerge, 0, size - 1);
                MergeSort.printArray(arr_forMerge);
                double timeEnd2 = System.currentTimeMillis();
                timeMerge.add((timeEnd2 - timeStart2));
            }
            if (i) {
                System.out.println("InsertSort cantidad de elementos: " + size);
                readForInsert(size);
                double timeStart3 = System.currentTimeMillis();
                InsertionSort.sort(arr_forInsert);
                InsertionSort.printArray(arr_forInsert);
                double timeEnd3 = System.currentTimeMillis();
                timeInsert.add((timeEnd3 - timeStart3));
            }
            size = size + 10;
        }

        System.out.println("tiempos de StoogeSort: " + timeStooge.toString());
        System.out.println("tiempos de QuickSort: " + timeQuick.toString());
        System.out.println("tiempos de MergeSort: " + timeMerge.toString());
        System.out.println("tiempos de InsertionSort: " + timeInsert.toString());
    }

    /**
     * Método que permite copiar los elementos del archivo al arreglo de un determinado tamaño
     * @param size 
     */
    private void readForInsert(int size) {
        arr_forInsert = new Integer[size];
        for (int i = 0; i < size; i++) {
            this.arr_forInsert[i] = this.arraylist.get(i);
        }
    }

    /**
     *  Método que permite copiar los elementos del archivo al arreglo de un determinado tamaño
     * @param size 
     */
    private void readForQuick(int size) {
        arr_forQuick = new Integer[size];
        for (int i = 0; i < size; i++) {
            this.arr_forQuick[i] = this.arraylist.get(i);
        }
    }

    /** Método que permite copiar los elementos del archivo al arreglo de un determinado tamaño
     * 
     * @param size 
     */
    private void readForMerge(int size) {
        arr_forMerge = new Integer[size];
        for (int i = 0; i < size; i++) {
            this.arr_forMerge[i] = this.arraylist.get(i);
        }
    }

    /**
     *  Método que permite copiar los elementos del archivo al arreglo de un determinado tamaño
     * @param size 
     */
    private void readForStooge(int size) {
        arr_forStooge = new Integer[size];
        for (int i = 0; i < size; i++) {
            this.arr_forStooge[i] = this.arraylist.get(i);
        }
    }
    
    public ArrayList<Double> getTimeMerge() {
        return timeMerge;
    }

    public ArrayList<Double> getTimeInsert() {
        return timeInsert;
    }

    public ArrayList<Double> getTimeQuick() {
        return timeQuick;
    }

    public ArrayList<Double> getTimeStooge() {
        return timeStooge;
    }

    public List<Integer> getArraylist() {
        return arraylist;
    }

    public boolean isM() {
        return m;
    }

    public boolean isQ() {
        return q;
    }

    public boolean isI() {
        return i;
    }

    public boolean isS() {
        return s;
    }
    
}
