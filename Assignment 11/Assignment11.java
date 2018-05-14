/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment11;

import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 * @author Reinier Sanders  s4335422
 * @author Laurens Kubat    s4626249
 */
public class Assignment11 extends Application {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(model, controller);
        view.start(primaryStage);
    }

    
}