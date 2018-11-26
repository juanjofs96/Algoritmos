/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
     * @return  List<Integer> con los datos que contenga el archivo
     */
    public static ArrayList<Integer> loadData(String ruta) {
        ArrayList datos = new ArrayList<>();
        try (BufferedReader inputStream = new BufferedReader(new FileReader(ruta))) {
            String line = null;
            while ((line = inputStream.readLine()) != null) {
                datos.add(Integer.valueOf(line));
            }
        } catch (FileNotFoundException o) {
            System.out.println(o.getMessage());
        } catch (IOException o) {

            System.out.println(o.getMessage());
        }
        return datos;
    }

}
