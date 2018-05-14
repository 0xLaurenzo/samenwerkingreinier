/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg11;

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
    
    @Override
    public void start(Stage primaryStage) {
        
        Timeline timeLine = new Timeline( new KeyFrame( Duration.seconds(1), this::tickHandler ));
        timeLine.setCycleCount( Timeline.INDEFINITE );
        
        Button startButton = new Button();
        startButton.setText("Start");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Start timeline
            }
        });
        
        Button stopButton = new Button();
        stopButton.setText("Stop");
        stopButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //Stop timeline
            }
        });
        
        Button quitButton = new Button();
        quitButton.setText("Quit");
        quitButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                primaryStage.close();
            }
        });
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(10);
        
        root.add(startButton, 0, 0);
        root.add(stopButton, 0, 1);
        root.add(quitButton, 1, 0);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Time Flies");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
