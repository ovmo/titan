import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;

public class SidePane {

    Group sidePaneGroup;
    Pane background;

    public SidePane() {
        sidePaneGroup = new Group();

        background = new Pane();
            background.setStyle("-fx-background-color: gray;");
            background.setPrefSize(350, 1000);
            sidePaneGroup.getChildren().add(background);
    }

    /**
        Add a new button to the pane
        @param x x-coordinate of the button on the pane
        @param y y-coordinate of the button on the pane
     */
    public void addButton(double x, double y) {
        Button button = new Button();

        Image imageButton = new Image(getClass().getResourceAsStream("Resources/Button.png"));
        ImageView imageViewButton = new ImageView(imageButton);

        imageViewButton.setFitHeight(80);
        imageViewButton.setPreserveRatio(true);
        //Setting the location of the button
        button.setTranslateX(x);
        button.setTranslateY(y);
        //Setting the size of the button
        button.setPrefSize(80, 80);
        button.setStyle("-fx-background-color: gray;");
        button.setGraphic(imageViewButton);

        sidePaneGroup.getChildren().add(button);
    }

    /**
     * Add a new label to the pane
     * @param s name of the label
     * @param x x-coordinate of the label
     * @param y y-coordinate of the label
     * @param c colour of the text of the label
     */
    public void addLabel(String s, double x, double y, Color c) {
        Label label = new Label(s);
        /*Add image to label
        Image imageLabel = new Image(getClass().getResourceAsStream("Resources/Label.jpg"));
        ImageView imageViewLabel = new ImageView(imageLabel);
        label.setGraphic(imageViewLabel);*/
        //Setting font to the label
        Font font = Font.font("Times New Romans", FontWeight.BOLD, FontPosture.REGULAR, 25);
        label.setFont(font);
        //Filling color to the label
        label.setTextFill(c);
        //Setting the position
        label.setTranslateX(x);
        label.setTranslateY(y);

        sidePaneGroup.getChildren().add(label);
    }

    public Group getGroup() {
        //addButton(135, 50);
        addLabel("Date: ", 50, 200, Color.RED);
        addLabel("01-04-2020", 50, 250, Color.BLACK);
        addLabel("Distance from Earth: ", 50, 400, Color.RED);
        return sidePaneGroup;
    }
}
