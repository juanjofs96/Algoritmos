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
     * Método que permitirá mostrar una ventana al usuario cuando no seleccione un
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
     * Método que permitirá mostrar una ventana al usuario cuando el archivo de texto
     * contenga tipo de datos caracteres
     */
    public static void dialogoArchivoInvalido() {
        Alert advertencia = new Alert(Alert.AlertType.WARNING);
        advertencia.setTitle("Error");
        advertencia.setContentText("Debe asegurarse de seleccionar un archivo con números enteros! ");
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
    
    /**
     * Este método le indica al usuario que debe seleccionar una cantidad indicada de datos
     */
    public static void dialogoAdvertenciaDatos() {
        Alert advertencia = new Alert(Alert.AlertType.WARNING);
        advertencia.setTitle("Error");
        advertencia.setContentText("Debe asegurarse de seleccionar una cantidad de datos menor o igual a la cantidad de datos del archivo seleccionado! ");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }
    
    /**
     * Este método le indica al usuario que debe seleccionar una minima cantidad de datos
     */
    public static void dialogoAdvertenciaDatosMinimos() {
        Alert advertencia = new Alert(Alert.AlertType.WARNING);
        advertencia.setTitle("Error");
        advertencia.setContentText("Debe asegurarse de seleccionar al menos 10 elementos para realizar la comparación! ");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }
    
    
    /**
     * Este método le indica al usuario que debe ingresar sólo datos numéricos
     */
    public static void dialogoAdvertenciaNumeros() {
        Alert advertencia = new Alert(Alert.AlertType.WARNING);
        advertencia.setTitle("Error");
        advertencia.setContentText("Debe asegurarse de Ingresar datos numéricos positivos! ");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }
    
    /**
     * Este metodo le indica al usuario que no seleccionó un algoritmo de comparación
     */
    public static void dialogoAdvertenciaCheckBox() {
        Alert advertencia = new Alert(Alert.AlertType.WARNING);
        advertencia.setTitle("Error");
        advertencia.setContentText("Debe asegurarse de seleccionar al menos un método de comparación! ");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }
    
     /**
     * Este metodo le indica al usuario que se generó el archivo
     */
    public static void dialogoInformacionArchivo() {
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
        advertencia.setTitle("Archivo exportData.txt generado");
        advertencia.setContentText("Puede encontrar este archivo en src/recursos/ de este proyecto ");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }
    
     /**
     * Este metodo le indica al usuario que se generó el archivo
     */
    public static void dialogoInformacionAleatrio() {
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
        advertencia.setTitle("Archivo generado");
        advertencia.setContentText("Puede encontrar este archivo en src/recursos/ de este proyecto ");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }
}
