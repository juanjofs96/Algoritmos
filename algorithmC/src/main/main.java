/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import vista.PrincipalView;

/**
 *
 * @author Tiffy
 */
public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
                
       PrincipalView vp = new PrincipalView();
        
        Scene scene = new Scene(vp.getRoot(), 1100, 610);
        
        primaryStage.setTitle("Algorithm C!");
        primaryStage.setScene(scene);
        Image image = new Image("/recursos/graph.png");
        primaryStage.getIcons().add(image);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
