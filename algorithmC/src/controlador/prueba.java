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
        ArrayList<Integer> a20 = OperationFile.loadData("src/recursos/prueba20.txt");
        Sort f = new Sort(a20, true, true, true, true);
        f.allSort();
        System.out.println("-------------------------------------------------");
        ArrayList<Integer> b250 = OperationFile.loadData("src/recursos/prueba250.txt");
        Sort g = new Sort(b250, true, true, true, true);
        g.allSort();
        System.out.println("-------------------------------------------------");
        ArrayList<Integer> c1000 = OperationFile.loadData("src/recursos/prueba1000.txt");
        Sort h = new Sort(c1000, true, true, true, true);
        h.allSort();
        
    }

}
