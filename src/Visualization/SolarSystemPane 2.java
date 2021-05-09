package Visualization;


import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.control.Label;

/**
 * Pane containing the solar system
*/
public class SolarSystemPane
{

    Group solarSystem;
    ZoomablePane space;
    Canvas grid;
    MovingPlanets movement;
    int height;
    int width;
    double xCenter;
    double yCenter;
    double unitSize;
    Circle sun;
    Circle mercury;
    Circle venus;
    Circle earth;
    Circle moon;
    Circle mars;
    Circle jupiter;
    Circle saturn;
    Circle titan;
    Spacecraft spacecraft;

    /**
     * Constructor
     */
    public SolarSystemPane()
    {
        solarSystem = new Group();

        height = 1000;
        width = 1150;

        space = new ZoomablePane();
            space.setPrefSize(width, height);
            space.setStyle("-fx-background-color:black;");

        solarSystem.getChildren().add(space);

        //Coordinates of the center
        xCenter = space.getPrefWidth()/2;   //xCenter = 575.0
        yCenter = space.getPrefHeight()/2;  //yCenter = 500.0

        spacecraft = new Spacecraft();

        movement = new MovingPlanets();
    }

    /**
     * Add a grid to the canvas (1 unit = 1 AU)
     * 20 x 23 = units of the grid
     */
    public void addGrid()
    {
        grid = new Canvas(width, height);

        //Set the graphics of the grid
        GraphicsContext gc = grid.getGraphicsContext2D();
        gc.setLineWidth(0.5);
        gc.setStroke(Color.GRAY);

        //Draw grid lines
        unitSize = 50;
        for( double i=unitSize; i < width; i+=unitSize)
        {
            gc.strokeLine( i, 0, i, height); //Vertical lines = 40
            gc.strokeLine( 0, i, width, i);  //Horizontal lines = 46
        }

        space.getChildren().add(grid);
    }

    public Canvas getGrid() { return grid; }

    /**
     * Method to convert km into AU
     */
    public double fromKmToAU(double km)
    {
        return km/1.496e+8;
    }

    /**
     * Add 'planet name' to the solar system
     * Add -/+ depending on the quadrant of the cartesian plane the planet is in
     * Coordinates of the planets = 50 (1 unit of the grid = 50 pixels = 1 AU) * planet's distance from the sun (AU)
     * The planets are initialized with their coordinates on 01-04-2020
     * @param x x-coordinate of the planet = AU from sun
     * @param y y-coordinate of the planet = AU from sun
     */
   public void addSun(double x, double y)
   {
       double xSun = xCenter + x;
       double ySun = yCenter + y;
       sun = new Circle(xSun, ySun, 10);
       Image imageSun = new Image(getClass().getResourceAsStream("/Visualization/Resources/Sun.png"));
       ImagePattern imagePatternSun = new ImagePattern(imageSun);
       sun.setFill(imagePatternSun);

       Label labelSun = new Label("Sun");
       Font font = Font.font("Verdana", FontPosture.REGULAR, 3); //Set font of the text
       labelSun.setFont(font);
       labelSun.setTextFill(Color.WHITE);           //Set label color
       labelSun.setTranslateX(xSun - 3);            //Setting the position
       labelSun.setTranslateY(ySun - 15);

       space.getChildren().add(labelSun);
       space.getChildren().add(sun);
   }

   //0.39 AU
   public void addMercury(double x, double y)
   {
       double xMercury = xCenter + unitSize * x;
       double yMercury = yCenter + unitSize * y;
       mercury = new Circle(xMercury, yMercury, 2);
       Image imageMercury = new Image(getClass().getResourceAsStream("/Visualization/Resources/Mercury.png"));
       ImagePattern imagePatternMercury = new ImagePattern(imageMercury);
       mercury.setFill(imagePatternMercury);

       Label labelMercury = new Label("Mercury");
       Font font = Font.font("Verdana", FontPosture.REGULAR, 3); //Set font of the text
       labelMercury.setFont(font);
       labelMercury.setTextFill(Color.WHITE);           //Set label color
       labelMercury.setTranslateX(xMercury - 5);        //Setting the position
       labelMercury.setTranslateY(yMercury - 7);

       space.getChildren().add(labelMercury);
       space.getChildren().add(mercury);
   }

   public Circle getMercury() {return mercury; }

   //0.72 AU
   public void addVenus(double x, double y)
   {
       double xVenus = xCenter + unitSize * x;
       double yVenus = yCenter + unitSize * y;
       venus = new Circle(xVenus, yVenus, 4);
       Image imageVenus = new Image(getClass().getResourceAsStream("/Visualization/Resources/Venus.png"));
       ImagePattern imagePatternVenus = new ImagePattern(imageVenus);
       venus.setFill(imagePatternVenus);

       space.getChildren().add(venus);
   }

   public Circle getVenus() {return venus; }

   //1 AU
   public void addEarth(double x, double y)
   {
       double xEarth = xCenter + unitSize * x;
       double yEarth = yCenter + unitSize * y;
       System.out.println(xEarth);
       System.out.println(yEarth);
       earth = new Circle(xEarth, yEarth, 2);
       Image imageEarth = new Image(getClass().getResourceAsStream("/Visualization/Resources/Earth.png"));
       ImagePattern imagePatternEarth = new ImagePattern(imageEarth);
       earth.setFill(imagePatternEarth);

       space.getChildren().add(earth);
   }

   public Circle getEarth() {return earth; }

   public void addMoon(double x, double y)
   {
       double xMoon = xCenter + unitSize * x;
       double yMoon = yCenter + unitSize * y;
       moon = new Circle(xMoon, yMoon, 1);
       Image imageMoon = new Image(getClass().getResourceAsStream("/Visualization/Resources/Moon.png"));
       ImagePattern imagePatternMoon = new ImagePattern(imageMoon);
       moon.setFill(imagePatternMoon);

       space.getChildren().add(moon);
   }

    public Circle getMoon() {return moon; }

   //1.52 AU
   public void addMars(double x, double y)
   {
       double xMars = xCenter + unitSize * x;
       double yMars = yCenter + unitSize * y;
       mars = new Circle(xMars, yMars, 2);
       Image imageMars = new Image(getClass().getResourceAsStream("/Visualization/Resources/Mars.png"));
       ImagePattern imagePatternMars = new ImagePattern(imageMars);
       mars.setFill(imagePatternMars);

       space.getChildren().add(mars);
   }

    public Circle getMars() {return mars; }

   //5.2 AU
   public void addJupiter(double x, double y)
   {
       double xJupiter = xCenter + unitSize * x;
       double yJupiter = yCenter + unitSize * y;
       jupiter = new Circle(xJupiter, yJupiter, 7);
       Image imageJupiter = new Image(getClass().getResourceAsStream("/Visualization/Resources/Jupiter.png"));
       ImagePattern imagePatternJupiter = new ImagePattern(imageJupiter);
       jupiter.setFill(imagePatternJupiter);

       space.getChildren().add(jupiter);
   }

   public Circle getJupiter() {return jupiter; }

   //9.54 AU
   public void addSaturn(double x, double y)
   {
       double xSaturn = xCenter + unitSize * x;
       double ySaturn = yCenter + unitSize * y;
       saturn = new Circle(xSaturn, ySaturn, 5);
       Image imageSaturn = new Image(getClass().getResourceAsStream("/Visualization/Resources/Saturn.png"));
       ImagePattern imagePatternSaturn = new ImagePattern(imageSaturn);
       saturn.setFill(imagePatternSaturn);

       space.getChildren().add(saturn);
   }

    public Circle getSaturn() {return saturn; }

   public void addTitan(double x, double y)
   {
       double xTitan = xCenter + unitSize * x;
       double yTitan = yCenter + unitSize * y;
       titan = new Circle(xTitan, yTitan, 1);
       Image imageTitan = new Image(getClass().getResourceAsStream("/Visualization/Resources/Titan.png"));
       ImagePattern imagePatternTitan = new ImagePattern(imageTitan);
       titan.setFill(imagePatternTitan);

       space.getChildren().add(titan);
   }

    public Circle getTitan() {return titan; }

    /**
     * @return the ZoomablePane containing all the planets of the solar system
     */
   public ZoomablePane getPane()
   {
        addGrid();
        addSun(0, 0);
        addMercury(0.39, -0.39);
        addVenus( -0.72, 0.72);
        addEarth(-1, -1);
        addMoon(-1 + fromKmToAU(384.400), -1.2 + fromKmToAU(384.400)); //Add the distance from the earth to the moon
        addMars(1.52, -1.52);
        addJupiter(5.2, -5.2);
        addSaturn(9.54, -9.54);
        addTitan(11, -11);  //Add the distance from Saturn to Titan
        spacecraft.addSpacecraft(xCenter - 51.5, yCenter - 56);
        return space;
   }
}