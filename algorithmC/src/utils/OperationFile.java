/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Tiffy
 */
public class OperationFile {
    private static final String RUTA = "src/recursos/exportData.txt"; 
    
    private OperationFile() {
    }

    /**
     * Método que permite leer un archivo 
     * @param ruta, direccion del archivo que se utilizará
     * @param cantidad
     * @return  List<Integer> con los datos que contenga el archivo
     */
    public static ArrayList<Integer> loadData(String ruta, int cantidad) {
        ArrayList datos = new ArrayList<>();
        int cont=0;
        try (BufferedReader inputStream = new BufferedReader(new FileReader(ruta))) {
            String line = null;
            while ((line = inputStream.readLine()) != null && cont<cantidad) {
                datos.add(Integer.valueOf(line));
                cont++;
            }
        } catch (FileNotFoundException o) {
            System.out.println(o.getMessage());
            DialogWindow.VentanaProblemasTecnicos();
        } catch (IOException o) {
            System.out.println(o.getMessage());
            DialogWindow.VentanaProblemasTecnicos();
        } catch(NumberFormatException e1){
            System.out.println(e1.getMessage());
            DialogWindow.dialogoArchivoInvalido();
        }
        return datos;
    }
    
    /**
     * Método que permite escribir un archivo con los tiempos obtenidos
     * @param merge, tiempos obtenidos del algoritmo MergeSort
     * @param quick, tiempos obtenidos del algoritmo QuickSort
     * @param insert, tiempos obtenidos del algoritmo InsertionSort
     * @param stooge, tiempos obtenidos del algoritmo StoogeSort
     * @param m, si MergeSort fue seleccionado
     * @param q, si Quicksort fue seleccionado
     * @param i, si InsertionSort fue seleccionado
     * @param s, si StoogeSort fue seleccionado
     * @param datos, arreglo con intervalos 
     */
     public static void exportData(List<Double> merge, List<Double> quick, List<Double> insert, List<Double> stooge, boolean m, boolean q, boolean i, boolean s, List<Integer> datos) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(RUTA))) {
            String line = "Datos" + "\t" + "MergeSort (ms)" + "\t" + "QuickSort (ms)" + "\t" + "InsertionSort (ms)" + "\t" + "StoogeSort (ms)";
            br.write(line);
            br.newLine();

            for (int in = 0; in < datos.size(); in++) {
                String line2 = "";
                line2 = line2 + String.valueOf(datos.get(in)) + "\t \t";
                if (m) {
                    line2 = line2 + String.valueOf(merge.get(in)) + "\t \t";
                } else {
                    line2 = line2 + "\t \t";
                }
                if (q) {
                    line2 = line2 + String.valueOf(quick.get(in)) + "\t \t";
                } else {
                    line2 = line2 + "\t \t";
                }
                if (i) {
                    line2 = line2 + String.valueOf(insert.get(in)) + "\t \t";
                } else {
                    line2 = line2 + "\t \t";
                }
                if (s) {
                    line2 = line2 + String.valueOf(stooge.get(in)) + "\t \t";
                } else {
                    line2 = line2 + "\t \t";
                }

                br.write(line2);
                br.newLine();

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            DialogWindow.VentanaProblemasTecnicos();
        }

    }
}
