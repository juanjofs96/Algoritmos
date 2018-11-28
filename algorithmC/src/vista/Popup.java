/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import javafx.scene.control.Label;
import javafx.scene.control.PopupControl;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author Carlos
 */
public class Popup extends PopupControl{
    

  
    public Popup() {
        getStyleClass().add("popup"); // not working!?

        StackPane pane = new StackPane();
        pane.getStyleClass().add("pane");
        Rectangle rectangle = new Rectangle(250, 250);
        rectangle.getStyleClass().add("rect");
        Label text = new Label("popup test");
        text.getStyleClass().add("text");
        pane.getChildren().addAll(rectangle, text);

        // how to display to pane when the popup is shown?
        //getContent().addAll(pane);
        //getScene().setRoot(pane);
    }

}
