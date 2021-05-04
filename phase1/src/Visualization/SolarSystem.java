package Visualization;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.input.ScrollEvent;

public class SolarSystem extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("SolarSystem");

        Pane center = new Pane();
        center.setStyle("-fx-background-color:black");
        Pane right = new Pane();

        BorderPane root = new BorderPane();             //Border layout
        Scene scene = new Scene(root, Color.BLACK);
        SolarSystemPane planets = new SolarSystemPane();
        SidePane panel = new SidePane();

        //Add solar system (CENTER) and side pane (RIGHT) to root
        //center.getChildren().add(planets);
        center.getChildren().add(planets.getPane());
        right.getChildren().add(panel.getPane());

        root.setCenter(center);
        root.setRight(right);

        //Control mouse movements on pane
        SceneGestures sceneGestures = new SceneGestures(planets.getZoomPane(), planets);
        center.addEventFilter(ScrollEvent.ANY, sceneGestures.getOnScrollEventHandler());
        center.setOnMousePressed(sceneGestures.getOnEnteredEventHandler());
        center.setOnMouseDragged(sceneGestures.getOnDragEventHandler());

        planets.movement.move();

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

}
