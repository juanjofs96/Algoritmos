/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Tiffy
 */
public class OperationFile {

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
     * Método que permite obtener el número de líneas de un archivo 
     * @param ruta, direccion del archivo que se utilizará
     * @return int con el número de líneas que contenga el archivo
     */
//    public static int cantidadElementos(String ruta) {
//
//       int numLines=0; 
//        File f = new File(ruta);
//        try  (Scanner entrada = new Scanner(f)) {
//       while (entrada.hasNextLine()) { //mientras queden enteros por leer
//                //System.out.println(entrada.nextLine());
//                entrada.nextLine();
//                numLines=numLines+1;
//            }            
//        } catch (FileNotFoundException e) {
//            System.out.println(e.toString());
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//        return numLines;   
//    }

    
    /**
     * Método que permite obtener el número de líneas que son enteros
     * @param ruta, direccion del archivo que se utilizará
     * @return  int con la cantidad de líneas que son enteros
     */
//    public static int cantidadLineasEnteros(String ruta){
//        
//        int numeroEntero=0;
//        File f = new File(ruta);
//
//        try  (Scanner entrada = new Scanner(f)) {
//
//            while (entrada.hasNextInt()) { 
//                //System.out.println(entrada.nextInt());
//                entrada.nextInt();
//                numeroEntero=numeroEntero+1;
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println(e.toString());
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//        return numeroEntero;
//    }

}
