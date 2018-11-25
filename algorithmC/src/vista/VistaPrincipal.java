/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Tiffy
 */
public class VistaPrincipal {

    private BorderPane root;
    private Button seleccionar, comparar;
    private CheckBox quick, merge, insert, stooge;
    private Spinner<Integer> spinner;
    private final int MAX;

    public VistaPrincipal() {
        this.MAX = Integer.MAX_VALUE;
        root = new BorderPane();
        BackgroundFill fondo = new BackgroundFill(Color.LIGHTSTEELBLUE, new CornerRadii(1),
                new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(fondo));
        inicializarObjetos();
        llamarMetodos();
    }

    private void llamarMetodos() {
        asignarObjetos();

    }

    public Pane getRoot() {
        return root;
    }

    private void inicializarObjetos() {
        quick = new CheckBox();
        merge = new CheckBox();
        insert = new CheckBox();
        stooge = new CheckBox();
        
        quick.setText("QuickSort");
        quick.setStyle("-fx-font-weight: bold");
        merge.setText("MergeSort");
        merge.setStyle("-fx-font-weight: bold");
        insert.setText("InsertSort");
        insert.setStyle("-fx-font-weight: bold");
        stooge.setText("StoogeSort");
        stooge.setStyle("-fx-font-weight: bold"); 
        
        seleccionar = new Button("...");
        seleccionar.setPrefSize(70, 20);
        comparar = new Button("Comparar");
        
        
        spinner = new Spinner<>();
        spinner.setEditable(true);
        spinner.setPrefSize(70, 20);
        SpinnerValueFactory<Integer> valueFactory
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, MAX, 1);
        spinner.setValueFactory(valueFactory);
    }

    private VBox seccionSeleccion() {
        VBox v1 = new VBox();
        GridPane gp = new GridPane();
        Label l1 = new Label("Seleccionar archivo");
        Label l2 = new Label("Seleccionar cantidad");
        
        gp.addRow(0, l1, seleccionar);
        gp.addRow(1, l2, spinner);
        gp.add(comparar, 1, 2);
        gp.setVgap(4);
        gp.setHgap(5);
        v1.getChildren().addAll(gp);
        return v1;
    }

    private HBox label() {
        HBox hbox = new HBox();
        Label titleLbl = new Label("Algorithm Comparison!");
        titleLbl.setFont(new Font("Segoe Print", 25));
        titleLbl.setStyle("-fx-text-fill: #E6F8F1; -fx-font-weight: bold");
        hbox.getChildren().add(titleLbl); 
        hbox.setAlignment(Pos.BOTTOM_CENTER); 
        //hbox.setPadding(new Insets(50, 10, 0, 10));
        return hbox;
    }

    private HBox seccionCheck() {
        HBox hb = new HBox();
        
        hb.getChildren().addAll(quick, merge, insert, stooge);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 10, 10, 10));
        hb.setSpacing(25);
        return hb;
    }

    private VBox seccionEncabezado() {
        VBox gp = new VBox();
        gp.getChildren().addAll(label(), seccionSeleccion());
        gp.setAlignment(Pos.CENTER);
        gp.setSpacing(15);
        return gp;
    }

    private void asignarObjetos() {
        root.setTop(seccionEncabezado());
        root.setBottom(seccionCheck());
    }

}
