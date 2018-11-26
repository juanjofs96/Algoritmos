/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

/**
 *
 * @author Tiffy
 */
public class DialogWindow {

    private DialogWindow() {
    }

    /**
     * Método que permitirá mostrar una ventana cuando se produzca una excepcion
     */
    public static void VentanaProblemasTecnicos() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos, estamos teniendo inconvenientes técnicos");
        alert.showAndWait();
    }

    /**
     * Método que permitirá mostrar una ventana cuando el usuario deje algún
     * campo vacío
     */
    public static void dialogoAdvertencia() {
        Alert advertencia = new Alert(Alert.AlertType.WARNING);
        advertencia.setTitle("Error");
        advertencia.setContentText("Debe asegurarse de elegir una cantidad de elementos");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }

    /**
     * Método que permitirá mostrar una ventana el usuario no seleccione un
     * archivo
     */
    public static void dialogoAdvertenciaArchivo() {
        Alert advertencia = new Alert(Alert.AlertType.WARNING);
        advertencia.setTitle("Error");
        advertencia.setContentText("Debe asegurarse de seleccionar un archivo antes de iniciar la comparación! ");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }

    /**
     * Método que permitirá saber que la comparación se está realizando
     */
    public static void dialogoAccion() {
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
        advertencia.setTitle("Algorithm C!");
        advertencia.setContentText("");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }
}
