/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment11;

import java.util.Set;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import static javafx.scene.paint.Color.RED;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Laurens
 */
public class View extends Application {
    private Model model;
    private Controller controller;
    
    public View(Model model, Controller controller){
        this.model = model;
        this.controller = controller;
    }
    
    public void tickHandler(ActionEvent event){
        controller.tickHandler();
        System.out.println(model.getCurTime());
        
    }
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Timeline timeLine = new Timeline(
                new KeyFrame( Duration.ZERO, new KeyValue( new SimpleIntegerProperty() , 0) ),
                new KeyFrame( Duration.seconds(1), this::tickHandler ));
        timeLine.setCycleCount( Timeline.INDEFINITE );
        
        TextField textfield = new TextField();
        
        
        Button startButton = new Button();
        startButton.setText("Start");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int input = Integer.parseInt(textfield.getCharacters().toString());
                model.setTotalTime(input);
                model.setCurTime(input);
                timeLine.play();
                
            }
        });
        
        
        ProgressBar progress = new ProgressBar();
        progress.setMinWidth(200);
        progress.setMaxWidth(Double.MAX_VALUE);
        
        
        Button stopButton = new Button();
        stopButton.setText("Stop");
        stopButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                timeLine.stop();
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
        root.add(textfield, 2, 2);
        root.add(progress, 0, 3);
        
        Scene scene = new Scene(root, 300, 250);
        
        timeLine.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scene.setFill(RED);
            }
        });
        
        
        
        primaryStage.setTitle("Time Flies");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
