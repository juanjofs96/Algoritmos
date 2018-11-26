/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.File;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.DialogWindow;
import utils.OperationFile;

/**
 *
 * @author Tiffy
 */
public class PrincipalView {

    private BorderPane root;
    private Button seleccionar, comparar;
    private CheckBox quick, merge, insert, stooge;
    private Spinner<Integer> spinner;
    private final int MAX;
    private String ruta = null;
    private FileChooser fileChooser;

    /**
     * Constructor de la clase
     */
    public PrincipalView() {
        this.MAX = Integer.MAX_VALUE;
        root = new BorderPane();
        BackgroundFill fondo = new BackgroundFill(Color.LIGHTSTEELBLUE, new CornerRadii(1),
                new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(fondo));
        inicializarObjetos();
        llamarMetodos();
    }

    /**
     * Método auxiliar que llama a los diversos metodos creados
     */
    private void llamarMetodos() {
        asignarObjetos();
        botonSeleccionar();
        botonComparar();

    }

    /**
     * Método que devuelve el objeto BorderPane creado
     * @return Pane
     */
    public Pane getRoot() {
        return root;
    }

    /**
     *Método que inicializa los principales objetos de la PrincipalView
     */
    private void inicializarObjetos() {
        quick = new CheckBox();
        merge = new CheckBox();
        insert = new CheckBox();
        stooge = new CheckBox();

        quick.setText("QuickSort");
        quick.setStyle("-fx-font-weight: bold");
        quick.setSelected(true);
        merge.setText("MergeSort");
        merge.setStyle("-fx-font-weight: bold");
        merge.setSelected(true);
        insert.setText("InsertSort");
        insert.setStyle("-fx-font-weight: bold");
        insert.setSelected(true);
        stooge.setText("StoogeSort");
        stooge.setStyle("-fx-font-weight: bold");
        stooge.setSelected(true);

        seleccionar = new Button("...");
        seleccionar.setPrefSize(70, 20);
        comparar = new Button("Comparar");

        spinner = new Spinner<>();
        spinner.setEditable(true);
        spinner.setPrefSize(70, 20);
        SpinnerValueFactory<Integer> valueFactory
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, MAX, 1);
        spinner.setValueFactory(valueFactory);

        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("HTML Files", "*.htm")
        );
    }

    /**
     * Método que permite crear la sección de CheckBox
     * @return HBox con un conjunto de Checkbox
     */
    private HBox seccionCheck() {
        HBox hb = new HBox();

        hb.getChildren().addAll(quick, merge, insert, stooge);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 10, 10, 10));
        hb.setSpacing(25);
        return hb;
    }

    /**
     * Método que permite crear la sección de la cabecera del programa
     *
     * @return HBox
     */
    private HBox seccionSeleccion() {
        HBox v1 = new HBox();
        GridPane gp = new GridPane();
        Label l1 = new Label("Seleccionar archivo");
        Label l2 = new Label("Seleccionar cantidad");
        gp.addRow(0, l1, seleccionar, l2, spinner, comparar);
        gp.setHgap(5);
        v1.getChildren().addAll(gp);
        return v1;
    }

    /**
     * Método que permite asignar al BorderPane los objetos que contendrán los
     * principales elementos para interactuar con el programa
     */
    private void asignarObjetos() {
        root.setTop(seccionSeleccion());
        root.setBottom(seccionCheck());
    }

    /**
     * Método que permite leer la ruta del archivo que se utilizará para la comparación
     * @param primaryStage
     * @param fileChooser
     * @return String con la ruta del archivo seleccionado
     */
     private String archivito(Stage primaryStage, FileChooser fileChooser) {
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            return selectedFile.getAbsolutePath();
        } else {
            //System.out.println("File selection cancelled.");
            return null; 
        }
    }
    
     
     /**
     * Metodo que contiene la acción que realiza el boton seleccionar archivo
     */
    private void botonSeleccionar() {
        seleccionar.setOnAction(e -> {
            Stage s = new Stage();
            ruta = archivito(s, fileChooser);
        });
    }

    /**
     * Metodo que contiene la acción que realiza el boton comparar
     */
    private void botonComparar() {
        comparar.setOnAction(e -> {
            if (ruta != null) {
                //prueba de que lee el archivo e imprime en consola
                List<Integer> o = OperationFile.loadData(ruta);
                o.forEach((f) -> {
                    System.out.println(f);
                });
            } else {
                DialogWindow.dialogoAdvertenciaArchivo();
            }

        });
    }
}
