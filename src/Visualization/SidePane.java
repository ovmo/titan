package Visualization;

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

/**
 * Side pane where data is shown
*/
public class SidePane
{

    Group sidePaneGroup;
    Pane background;
    int height;
    int width;

    /**
     * Constructor
    */
    public SidePane()
    {
        sidePaneGroup = new Group();

        width = 300;
        height = 10000;

        background = new Pane();
            background.setStyle("-fx-background-color: gray;");
            background.setPrefSize(width, height);
            sidePaneGroup.getChildren().add(background);
    }

    /**
     * Add a new label to the pane
     * @param s name of the label
     * @param x x-coordinate of the label
     * @param y y-coordinate of the label
     * @param c colour of the text of the label
     */
    public void addLabel(String s, double x, double y, Color c)
    {
        Label label = new Label(s);

        //Set font of the text
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20);
        label.setFont(font);
        //Add text to label
        label.setTextFill(c);
        //Setting the position
        label.setTranslateX(x);
        label.setTranslateY(y);

        sidePaneGroup.getChildren().add(label);
    }

    /**
     * Add labels and buttons to the side pane
    */
    public Group getPane()
    {
        addLabel("Date: ", 40, 200, Color.RED);
        addLabel("01-04-2020", 40, 225, Color.BLACK);
        addLabel("Distance from Earth: ", 40, 400, Color.RED);
        addLabel("0 m", 40, 425, Color.BLACK);
        addLabel("Distance from Titan: ", 40, 600, Color.RED);
        addLabel("143350707,46 m", 40, 625, Color.BLACK);
        addLabel("□ 1 unit = 1 AU", 70, 850, Color.WHITE);
        return sidePaneGroup;
    }
}
