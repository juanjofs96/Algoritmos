/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Sort;
import javafx.concurrent.Task;

/**
 *
 * @author Carlos
 */
public class Tarea extends Task<Sort>{
    private Sort s;
    public Tarea(Sort s) {
        this.s=s;
    }
    
    @Override
    protected Sort call() throws Exception {
        this.s.allSort(this);
        return s;
    }
    public void actualizar(int i, int j){
        this.updateProgress(i, j);
    }
    
}
