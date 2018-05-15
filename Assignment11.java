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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 * @author Reinier Sanders  s4335422
 * @author Laurens Kubat    s4626249
 */
public class Assignment11 extends Application {
    
    ProgressBar progress = new ProgressBar();
    int curTime;
    int totalTime;
    Timeline timeline;
    GridPane root = new GridPane();
    TextField textfield;


    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void tickHandler(ActionEvent event){
        if (curTime == totalTime){
            root.setStyle("-fx-background-color:red;");
        } else {
            curTime++;
            progress.setProgress((double)(totalTime - curTime)/totalTime);
        }
    }
        
    @Override
    public void start(Stage primaryStage) {
        
        timeline = new Timeline( new KeyFrame( Duration.seconds(1), this::tickHandler ));
        timeline.setCycleCount( Timeline.INDEFINITE );
        
        textfield = new TextField();

        
        Button startButton = new Button();
        startButton.setText("Start");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int input = Integer.parseInt(textfield.getCharacters().toString());
                curTime = 0;
                totalTime = input;
                timeline.play();
            }
        });
        
        Button stopButton = new Button();
        stopButton.setText("Stop");
        stopButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                root.setStyle("-fx-background-color:white;");
                timeline.stop();
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
        
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(10);
        
        root.add(startButton, 0, 0);
        root.add(stopButton, 0, 1);
        root.add(quitButton, 1, 0);
        root.add(progress, 0, 2);
        root.add(textfield, 0, 3);
        
        Scene scene = new Scene(root, 300, 250);
        
        
        primaryStage.setTitle("Time Flies");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}