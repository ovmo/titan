import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class SolarSystemPane {

    Group solarSystem;
    Pane background;
    PannableZoomablePane zoom;
    double xCenter;
    double yCenter;
    Circle sun;
    Circle mercury;
    Circle venus;
    Circle earth;
    Circle moon;
    Circle mars;
    Circle jupiter;
    Circle saturn;
    Circle titan;

    //Constructor
    public SolarSystemPane() {
        solarSystem = new Group();

        background = new Pane();
            background.setPrefSize(1100, 1000);
            background.setStyle("-fx-background-color:black;");

        zoom = new PannableZoomablePane(background);

        background.getChildren().add(zoom);
        solarSystem.getChildren().add(background);

        //Coordinates of the center
        xCenter = background.getPrefWidth()/2;
        yCenter = background.getPrefHeight()/2;
        //System.out.println(xCenter);
        //System.out.println(yCenter);
   }

   //Add planets to solar system
    /**
     * Add Sun
     * @param x x-coordinate of the sun (origin)
     * @param y y-coordinate of the sun (origin)
     */
   public void addSun(double x, double y) {
       //sun = new Circle( 0, 0, 0.08);     //Actual size: 4.65e-03
       double xSun = xCenter + x;
       double ySun = yCenter + y;
       sun = new Circle(xSun, ySun, 8);
       Image imageSun = new Image(getClass().getResourceAsStream("Resources/Sun.png"));
       ImagePattern imagePatternSun = new ImagePattern(imageSun);
       sun.setFill(imagePatternSun);

       zoom.getChildren().add(sun);
   }

    /**
     * Add Mercury
     * @param x x-coordinate of Mercury
     * @param y y-coordinate of Mercury
     */
   public void addMercury(double x, double y) {
       //mercury = new Circle(4.04e-05, -4.55e-01, 0.01);   //Actual size: 1.63e-05
       double xMercury = xCenter + x;//6.047855986424127e+06
       double yMercury = yCenter + y;//6.801800047868888e+10;
       //System.out.println(xMercury);
       //System.out.println(yMercury);
       mercury = new Circle(xMercury, yMercury, 1);
       Image imageMercury = new Image(getClass().getResourceAsStream("Resources/Mercury.png"));
       ImagePattern imagePatternMercury = new ImagePattern(imageMercury);
       mercury.setFill(imagePatternMercury);

       zoom.getChildren().add(mercury);
   }

    /**
     * Add Venus
     * @param x x-coordinate of Venus
     * @param y y-coordinate of Venus
     */
   public void addVenus(double x, double y) {
       //venus = new Circle(-6.31e-03, 3.58e-01, 0.03);     //Actual size:4.05e-05
       double xVenus = xCenter + x;//-9.435345478592035e+10
       double yVenus = yCenter + y;//5.350359551033670e+10
       venus = new Circle(xVenus, yVenus, 3);
       Image imageVenus = new Image(getClass().getResourceAsStream("Resources/Venus.png"));
       ImagePattern imagePatternVenus = new ImagePattern(imageVenus);
       venus.setFill(imagePatternVenus);

       zoom.getChildren().add(venus);
   }

    /**
     * Add Earth
     * @param x x-coordinate of the Earth
     * @param y y-coordinate of the Earth
     */
   public void addEarth(double x, double y) {
       //earth = new Circle(-9.84e-01, -1.69e-01, 0.02);    //Actual size: 4.26e-05
       double xEarth = xCenter + x;//-1.471922101663588e+11
       double yEarth = yCenter + y;//-2.860995816266412e+10
       earth = new Circle(xEarth, yEarth, 2);
       Image imageEarth = new Image(getClass().getResourceAsStream("Resources/Earth.png"));
       ImagePattern imagePatternEarth = new ImagePattern(imageEarth);
       earth.setFill(imagePatternEarth);

       zoom.getChildren().add(earth);
   }

    /**
     * Add Moon
     * @param x x-coordinate of the Moon
     * @param y y-coordinate of the Moon
     */
   public void addMoon(double x, double y) {
       //moon = new Circle(-9.84e-01, -1.89e-01, 0.005);    //Actual size: 1.16e-05
       double xMoon = xCenter + x;//-1.472343904597218e+11
       double yMoon = yCenter + y;//-2.822578361503422e+10
       moon = new Circle(xMoon, yMoon, 0.5);
       Image imageMoon = new Image(getClass().getResourceAsStream("Resources/Moon.png"));
       ImagePattern imagePatternMoon = new ImagePattern(imageMoon);
       moon.setFill(imagePatternMoon);

       zoom.getChildren().add(moon);
   }

    /**
     * Add Mars
     * @param x x-coordinate of Mars
     * @param y y-coordinate of Mars
     */
   public void addMars(double x, double y) {
       //mars = new Circle(-9.84e-01, -1.89e-01, 0.01);     //Actual size: 2.27-05
       double xMars = xCenter + x;//-3.615638921529161e+10
       double yMars = yCenter + y;//-2.167633037046744e+11
       mars = new Circle(xMars, yMars, 1);
       Image imageMars = new Image(getClass().getResourceAsStream("Resources/Mars.png"));
       ImagePattern imagePatternMars = new ImagePattern(imageMars);
       mars.setFill(imagePatternMars);

       zoom.getChildren().add(mars);
   }

    /**
     * Add Jupiter
     * @param x x-coordinate of Jupiter
     * @param y y-coordinate of Jupiter
     */
   public void addJupiter(double x, double y) {
       //jupiter = new Circle(1.19e+00/2, -5.05e+00/2, 0.05);     //Actual size: 4.67e-04
       double xJupiter = xCenter + x; //1.781303138592153e+11
       double yJupiter = yCenter + y;//-7.551118436250277e+11
       jupiter = new Circle(xJupiter, yJupiter, 5);
       Image imageJupiter = new Image(getClass().getResourceAsStream("Resources/Jupiter_.png"));
       ImagePattern imagePatternJupiter = new ImagePattern(imageJupiter);
       jupiter.setFill(imagePatternJupiter);

       zoom.getChildren().add(jupiter);
   }

    /**
     * Add Saturn
     * @param x x-coordinate of Saturn
     * @param y y-coordinate of Saturn
     */
   public void addSaturn(double x, double y) {
       //saturn = new Circle(4.23e+00/2,-9.08e+00/2, 0.05);     //Actual size: 3.89e-04
       double xSaturn = xCenter + x;//6.328646641500651e+11  (-150 added just to fit the screen)
       double ySaturn = yCenter + y;//-1.358172804527507e+12
       //System.out.println(xSaturn);
       //System.out.println(ySaturn);
       saturn = new Circle(xSaturn, ySaturn, 5);
       Image imageSaturn = new Image(getClass().getResourceAsStream("Resources/Saturn.png"));
       ImagePattern imagePatternSaturn = new ImagePattern(imageSaturn);
       saturn.setFill(imagePatternSaturn);

       zoom.getChildren().add(saturn);
   }

    /**
     * Add Titan
     * @param x x-coordinate of Titan
     * @param y y-coordinate of Titan
     */
   public void addTitan(double x, double y) {
       //titan = new Circle(4.23e+00/2,-9.07e+00/2,0.01);     //Actual size: 1.72e-05
       double xTitan = xCenter + x;//6.332873118527889e+11 (-150 added just to fit the screen)
       double yTitan = yCenter + y;//-1.357175556995868e+12
       titan = new Circle(xTitan, yTitan, 1);
       Image imageTitan = new Image(getClass().getResourceAsStream("Resources/Titan_.png"));
       ImagePattern imagePatternTitan = new ImagePattern(imageTitan);
       titan.setFill(imagePatternTitan);

       zoom.getChildren().add(titan);
   }

   //Returns all the planets to the solar system
   public Group getGroup() {
        addSun(0, 0);
        addMercury(6.0, - 6.8);
        addVenus( - 9.4, 5.4);
        addEarth(- 15.0, -28.6);
        addMoon(-14.7, -28.2);
        addMars(-36.1, -21.6);
        addJupiter(178, -75.5);
        addSaturn(632 -150, -136);
        addTitan(633 - 15, -135);
        return solarSystem;
   }
}
