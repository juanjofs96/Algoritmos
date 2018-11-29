/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Tarea;
import org.controlsfx.dialog.ProgressDialog;
import controlador.Sort;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Button seleccionar, comparar, escribir;
    private CheckBox quick, merge, insert, stooge;
    private Spinner<Integer> spinner;
    private Spinner<Integer> spinner2;
    private final int MAX;
    private String ruta = null;
    private String name = null;
    private FileChooser fileChooser;
    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
    public static Font fuente = new Font("Broadway", 22);

    private Image imageFile = new Image("/recursos/folder.png", 25, 25, false, false);
    private int exceso = 0;

    /**
     * Constructor de la clase
     */
    public PrincipalView() {
        this.MAX = Integer.MAX_VALUE;
        root = new BorderPane();
        BackgroundFill fondo = new BackgroundFill(Color.HONEYDEW, new CornerRadii(1),
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
        botonEscribir();
    }

    /**
     * Método que devuelve el objeto BorderPane creado
     *
     * @return Pane
     */
    public Pane getRoot() {
        return root;
    }

    /**
     * Método que inicializa los principales objetos de la PrincipalView
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

        escribir = new Button("Generación de datos");
        escribir.setPrefSize(200, 20);

        seleccionar = new Button();
        seleccionar.setGraphic(new ImageView(imageFile));
        seleccionar.setPrefSize(200, 20);
        comparar = new Button("Comparar");

        spinner = new Spinner<>();
        spinner.setEditable(true);
        spinner.setPrefSize(100, 20);
        SpinnerValueFactory<Integer> valueFactory
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, MAX, 1);
        spinner.setValueFactory(valueFactory);

        spinner2 = new Spinner<>();
        spinner2.setEditable(true);
        spinner2.setPrefSize(100, 20);
        SpinnerValueFactory<Integer> valueFactory2
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, MAX, 1);
        spinner2.setValueFactory(valueFactory2);

        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );
        lineChart.setTitle("Comparación de Algoritmos");
        xAxis.setLabel("Cantidad de Elementos");
        yAxis.setLabel("Tiempo de Ejecución (ms)");
    }

    /**
     * Método que permite crear la sección de CheckBox
     *
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
        gp.addRow(0, l1, seleccionar, l2, spinner, comparar, escribir, spinner2);
        gp.setHgap(20);
        v1.getChildren().addAll(gp);
        v1.setAlignment(Pos.CENTER);

        return v1;

    }

    /**
     * Método auxiliar que permite agregar la data al Objeto tipo XYXChart para
     * poder graficar
     *
     * @param lineChart
     * @param arr
     * @param algoritmo
     */
    private void AuxGraficar(LineChart<Number, Number> lineChart, List<Double> arr, String algoritmo, int escala) {
        XYChart.Series series = new XYChart.Series();
        series.setName(algoritmo);
        series.getData().add(new XYChart.Data(0, 0));
        int i = 0;
        for (Double x : arr) {
            i += escala;
            if (this.exceso != 0 && arr.size() * 10 == i && (escala == 10 || escala == 100)) {
                i += this.exceso;
            }
            series.getData().add(new XYChart.Data(i, x));
        }
        lineChart.getData().add(series);
    }

    /**
     * Método que permitirá realizar las curvas en la gráfica
     *
     * @param s
     */
    private void Graficar(Sort s, int escala) {
        if (s.isM()) {
            this.AuxGraficar(lineChart, s.getTimeMerge(), "MergeSort", escala);
        }
        if (s.isI()) {
            this.AuxGraficar(lineChart, s.getTimeInsert(), "InsertionSort", escala);
        }
        if (s.isQ()) {
            this.AuxGraficar(lineChart, s.getTimeQuick(), "QuickSort", escala);
        }
        if (s.isS()) {

            this.AuxGraficar(lineChart, s.getTimeStooge(), "StoogeSort", escala);

        }

    }

    /**
     * Método que permite asignar al BorderPane los objetos que contendrán los
     * principales elementos para interactuar con el programa
     */
    private void asignarObjetos() {
        root.setTop(seccionSeleccion());
        root.setBottom(seccionCheck());
        root.setCenter(this.lineChart);
    }

    /**
     * Método que permite leer la ruta del archivo que se utilizará para la
     * comparación
     *
     * @param primaryStage
     * @param fileChooser
     * @return String con la ruta del archivo seleccionado
     */
    private String archivito(Stage primaryStage, FileChooser fileChooser) {
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            name = selectedFile.getName();
            return selectedFile.getAbsolutePath();

        } else {
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
            seleccionar.setText(name);
        });
    }

    /**
     * Metodo que contiene la acción que realiza el boton comparar
     */
    private int validarNumero(String numero) {
        int valor;
        try {
            valor = Integer.parseInt(numero);
            return valor;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Acción que realiza el boton Comparar
     */
    private void botonComparar() {
        comparar.setOnAction(e -> {

            try {
                int valorAnalizar = this.validarNumero(spinner.getEditor().getText());
                if (ruta == null) {
                    DialogWindow.dialogoAdvertenciaArchivo();
                } else if (valorAnalizar <= 0) {
                    DialogWindow.dialogoAdvertenciaNumeros();
                } else if (notChecked()) {
                    DialogWindow.dialogoAdvertenciaCheckBox();
                } else if (valorAnalizar < 10) {
                    DialogWindow.dialogoAdvertenciaDatosMinimos();
                } else {
                    this.exceso = valorAnalizar % 10;
                    lineChart.getData().clear();
                    List<Integer> arraylist = OperationFile.loadData(ruta, valorAnalizar);

                    if (valorAnalizar > arraylist.size()) {
                        DialogWindow.dialogoAdvertenciaDatos();
                    } else {
                        Sort prueba = new Sort(arraylist, this.merge.isSelected(), this.quick.isSelected(), this.insert.isSelected(), this.stooge.isSelected(), this.exceso);

                        Tarea t = new Tarea(prueba);

                        ProgressDialog popup = new ProgressDialog(t);
                        popup.setTitle("Ejecucion En Proceso");
                        popup.setContentText("Espere un momento por favor...");
                        popup.setHeaderText("Comparación de Algoritmos");
                        Stage stage = (Stage) popup.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image(this.getClass().getResource("/recursos/graph.png").toString()));
                        t.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                                new EventHandler<WorkerStateEvent>() {

                            @Override
                            public void handle(WorkerStateEvent t1) {
                                Sort p2 = t.getValue();
                                int o = escala(p2.getCantidad_elementos());
                                Graficar(p2, o);
                                OperationFile.exportData(p2.getTimeMerge(), p2.getTimeQuick(), p2.getTimeInsert(), p2.getTimeStooge(), p2.isM(), p2.isQ(), p2.isI(), p2.isS(), p2.getForFile());
                                DialogWindow.dialogoInformacionArchivo();

                            }
                        });

                        new Thread(t).start();
                    }
                }
            } catch (Exception r) {
                DialogWindow.VentanaProblemasTecnicos();
            }
        });
    }

    private void botonEscribir() {
        escribir.setOnAction(e -> {

            File f;
            try {
                int cantidad =Integer.parseInt(spinner.getEditor().getText());              
                Date date = new Date();
                DateFormat hourdateFormat = new SimpleDateFormat("HH.mm.ss dd-MM-yyyy");
                String f1 = hourdateFormat.format(date);
                f = new File("src/recursos/archivogenerado" + f1 + "(" + cantidad + "datos).txt");
                //Escritura

                FileWriter w = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(w);
                PrintWriter wr = new PrintWriter(bw);
                for (int i = 0; i <= cantidad; i++) {
                    wr.write("" + (int) (Math.random() * 1000) + 1 + "\n");//escribimos en el archivo
                }
                wr.close();
                bw.close();
                DialogWindow.dialogoInformacionAleatrio();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                DialogWindow.VentanaProblemasTecnicos();
            } catch (NumberFormatException ee) {
                DialogWindow.dialogoAdvertenciaNumeros();
            }

        });

    }

    /**
     * Permite verificar si el usuario no selecionó ningún método para comparar
     *
     * @return
     */
    public boolean notChecked() {
        return !this.merge.isSelected() && !this.insert.isSelected() && !this.quick.isSelected() && !this.stooge.isSelected();
    }

    /**
     * Método permite ajustar la escala
     *
     * @param datos, cantidad de datos a ordenar
     * @return int
     */
    public static int escala(int datos) {
        if (datos > 50 && datos <= 500) {
            return 10;
        }
        if (datos <= 50 && datos > 0) {
            return 1;
        }
        return 100;
    }
}
