package assignment.pkg12;

import java.util.ArrayList;
import java.util.List;
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
    private int beadCount = 0;
    private double lineLength = Math.sqrt(Math.pow(line.getEndX(), 2) + Math.pow(line.getEndY(), 2));
    private List<Circle> beads = new ArrayList<Circle>();
    
    //Returns the distance to the origin of the line between a value of 0 and 1.
    private double distanceToOrigin(double x, double y){
        return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))) / lineLength;
    }
    
    //Returns the value of red color based on the distance to the origin of the line.
    private int redColor(double distance){
        Double buffer = 255 - (255 * distance);
        Integer result = buffer.intValue();
        return result;
    }
    
    //Returns the value of blue color based on the distance to the origin of the line.
    private int blueColor(double distance){
        Double buffer = 255 * distance;
        Integer result = buffer.intValue();
        return result;
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        bead.setFill(Color.BLUE);
        line.setStartX(0);
        line.setStartY(0);
        line.setEndX(bead.getCenterX());
        line.setEndY(bead.getCenterY());
        
        Pane root = new Pane(line, bead);
 
        root.setOnMouseClicked((MouseEvent event) -> {
            Circle newBead = new Circle(circleRadius);
            beads.add(newBead);
            beadCount++;
            for(int i = 0; i < beadCount; i++){
                beads.get(i).setCenterX((i+1.0) / (beadCount+1.0) * bead.getCenterX());
                beads.get(i).setCenterY((i+1.0) / (beadCount+1.0) * bead.getCenterY());
                beads.get(i).setFill(Color.rgb(redColor(distanceToOrigin(beads.get(i).getCenterX(), beads.get(i).getCenterY())), 0, blueColor(distanceToOrigin(beads.get(i).getCenterX(), beads.get(i).getCenterY()))));
            }
            root.getChildren().add(newBead);
        });
        
        root.setOnMouseMoved((MouseEvent event) -> {
            bead.setCenterX(event.getSceneX());
            bead.setCenterY(event.getSceneY());
            line.setEndX(bead.getCenterX());
            line.setEndY(bead.getCenterY());
            lineLength = Math.sqrt(Math.pow(line.getEndX(), 2) + Math.pow(line.getEndY(), 2));
            for(int i = 0; i < beadCount; i++){
                beads.get(i).setCenterX((i+1.0) / (beadCount+1.0) * bead.getCenterX());
                beads.get(i).setCenterY((i+1.0) / (beadCount+1.0) * bead.getCenterY());
            }
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
