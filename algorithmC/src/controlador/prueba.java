/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import utils.OperationFile;

/**
 *
 * @author Tiffy
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> a = OperationFile.loadData("src/recursos/prueba15.txt");
        Sort f = new Sort(a, true, true, true, true);
        f.allSort();
    }

}
