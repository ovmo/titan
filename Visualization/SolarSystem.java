import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SolarSystem extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("SolarSystem");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);

        //Add solar system (CENTER) and side pane (RIGHT) to root
        SolarSystemPane planets = new SolarSystemPane();
        SidePane panel = new SidePane();

        Pane center = new Pane();
        Pane right = new Pane();

        center.getChildren().add(planets.getGroup());
        right.getChildren().add(panel.getGroup());

        root.setCenter(center);
        root.setRight(right);

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
