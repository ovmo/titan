package Visualization;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.input.ScrollEvent;

public class SolarSystem extends Application
{

    @Override
    public void start(Stage stage)
    {

        stage.setTitle("Visualization.SolarSystem");

        BorderPane root = new BorderPane();             //Set border layout to the root
        Scene scene = new Scene(root, Color.BLACK);

        SolarSystemPane planets = new SolarSystemPane();
        SidePane panel = new SidePane();

        //Add solar system (CENTER) and side pane (RIGHT) to root
        Pane center = new Pane();
            center.setStyle("-fx-background-color:black");
            center.getChildren().add(planets.getPane());
            root.setCenter(center);

        Pane right = new Pane();
            right.getChildren().add(panel.getPane());
            root.setRight(right);

        //Control mouse events on pane
        SceneGestures sceneGestures = new SceneGestures(planets.getPane());
        center.addEventFilter(ScrollEvent.ANY, sceneGestures.getOnScrollEventHandler());
        center.setOnMousePressed(sceneGestures.getOnEnteredEventHandler());
        center.setOnMouseDragged(sceneGestures.getOnDragEventHandler());

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}