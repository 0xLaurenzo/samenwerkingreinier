package assignment.pkg12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author Reinier Sanders  s4335422
 * @author Laurens Kubat    s4626249
 */
public class Assignment12 extends Application {
    
    private final int sceneX = 400;
    private final int sceneY = 300;
    private final int circleRadius = 10;
    private final Circle bead = new Circle(sceneX/2, sceneY/2, circleRadius);
    private final Line line = new Line();
    private int beadCount = 1;
    
    @Override
    public void start(Stage primaryStage) {
        
        bead.setFill(Color.BLUE);
        line.setStartX(0);
        line.setStartY(0);
        line.setEndX(bead.getCenterX());
        line.setEndY(bead.getCenterY());
        
        Pane root = new Pane(line, bead);
 
        root.setOnMouseClicked((MouseEvent event) -> {
            beadCount++;
            Circle newBead = new Circle(bead.getCenterX()/beadCount, bead.getCenterY()/beadCount, circleRadius);
            newBead.setFill(Color.rgb(255 - (256/beadCount), 0 , 256/beadCount));
            root.getChildren().add(newBead);
        });
        
        root.setOnMouseMoved((MouseEvent event) -> {
            bead.setCenterX(event.getSceneX());
            bead.setCenterY(event.getSceneY());
            line.setEndX(bead.getCenterX());
            line.setEndY(bead.getCenterY());
        });
        
        Scene scene = new Scene(root, sceneX, sceneY);
        
        primaryStage.setTitle("Line With Beads");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
