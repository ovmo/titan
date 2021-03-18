package Visualization;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.transform.Rotate;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Class of the spacecraft to be launched
 */
public class Spacecraft
{

    Rectangle spacecraft;
    ZoomablePane pane;
    double velocity;           //Velocity of the spacecraft

    /**
     * Constructor
     */
    public Spacecraft()
    {
        pane = new ZoomablePane();
    }

    /**
     * Add spacecraft to space
     * @param x x-coordinate of the spacecraft into space
     * @param y y-coordinate of the spacecraft into space
    */
     public void addSpacecraft(double x, double y)
     {
        spacecraft = new Rectangle (x, y, 3.0, 5.0);
        Image imageSpacecraft = new Image(getClass().getResourceAsStream("/Visualization/Resources/Spacecraft.png"));
        ImagePattern imagePatternSpacecraft = new ImagePattern(imageSpacecraft);
        spacecraft.setFill(imagePatternSpacecraft);

        //Rotation of the spacecraft
        Rotate rotate = new Rotate();
        rotate.setAngle(30);                //Angle for the rotation
        rotate.setPivotX(x - 2);            //Setting pivot points for the rotation (The coordinates are shifted to fit the rotation)
        rotate.setPivotY(y + 5);

        spacecraft.getTransforms().add(rotate);

        pane.getChildren().add(spacecraft);
    }

    /**
     * Launch spacecraft into space
     */
    public void fly()
    {
        TranslateTransition fly = new TranslateTransition();
        fly.setToX(4.23e+00 - (-9.84e-01));
        fly.setToY(-9.08e+00 - (-1.69e-01));
        fly.setDuration(Duration.seconds(10));
        fly.setCycleCount(100);
        fly.setAutoReverse(true);
        fly.setNode(spacecraft);
        fly.play();
    }
}
