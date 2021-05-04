package Visualization;

import PhysicsEngine.Planet;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;


public class SolarSystemPane extends Pane {

    DoubleProperty myScale = new SimpleDoubleProperty(2.0); //to enable zooming also here

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

    Rectangle spacecraft;

    Circle[] circles;

    Planet [] planets;

    //Constructor
    public SolarSystemPane() {

        solarSystem = new Group();

        this.getChildren().add(solarSystem);

        height = 1000;
        width = 1150;

        space = new ZoomablePane();
        space.setPrefSize(width, height);
        space.setStyle("-fx-background-color:black;");

        solarSystem.getChildren().add(space);

        //Coordinates of the center
        xCenter = space.getPrefWidth()/2;   //xCenter = 575.0
        yCenter = space.getPrefHeight()/2;  //yCenter = 500.0

        circles = new Circle[9];

        planets = Planet.planets;

        //init movement class with duration of each movement and pane
        movement = new MovingPlanets(200, this);
    }

    /**
     * Add a grid to the canvas (1 unit = 1 AU)
     * SCALING PURPOSES ONLY (can be deleted later)
     */
    //20 x 23 = measurements of the grid in units
    public void addGrid() {

        grid = new Canvas(width*2, height*2);

        //Set the graphics of the grid
        GraphicsContext gc = grid.getGraphicsContext2D();
        gc.setLineWidth(0.5);
        gc.setStroke(Color.GRAY);

        //Draw grid lines
        unitSize = 50;
        for( double i=unitSize; i < width*2; i+=unitSize) {
            gc.strokeLine( i, 0, i, height*2); //Vertical lines = 40
            gc.strokeLine( 0, i, width*2, i);  //Horizontal lines = 46
        }

        solarSystem.getChildren().add(grid);
    }

    public Canvas getGrid() { return grid; }

    /**
     * Method to convert km into AU - change into m to AU
     */
    public double fromMToAU(double m) {
        double AU = m*6.6846e-12;
        return AU;
    }

    //Add planets to solar system
    //1 unit of the grid = 50 pixels = 1 AU
    //Coordinates of the planets = 50 * planet's distance from the sun (AU)
    /**
     * Add 'planet name'
     * Add -/+ depending on the quadrant of the cartesian plane the planet is in
     * @param x x-coordinate of the planet = AU from sun
     * @param y y-coordinate of the planet = AU from sun
     */
   public void addSun(double x, double y) {
       double xSun = xCenter + x;
       double ySun = yCenter + y;
       sun = new Circle(xSun, ySun, 10);
       Image imageSun = new Image(getClass().getResourceAsStream("Resources/Sun.png"));
       ImagePattern imagePatternSun = new ImagePattern(imageSun);
       sun.setFill(imagePatternSun);

       Label labelSun = new Label("Sun");
       Font font = Font.font("Verdana", FontPosture.REGULAR, 3); //Set font of the text
       labelSun.setFont(font);
       labelSun.setTextFill(Color.WHITE);           //Set label color
       labelSun.setTranslateX(xSun - 3);            //Setting the position
       labelSun.setTranslateY(ySun - 15);


       solarSystem.getChildren().add(sun);
       circles[0] = sun;
   }

   //0.39 AU
   public void addMercury(double x, double y) {
       double xMercury = xCenter + unitSize * x;
       double yMercury = yCenter + unitSize * y;
       Circle mercury = new Circle(xMercury, yMercury, 2);
       Image imageMercury = new Image(getClass().getResourceAsStream("Resources/Mercury.png"));
       ImagePattern imagePatternMercury = new ImagePattern(imageMercury);
       mercury.setFill(imagePatternMercury);

       Label labelMercury = new Label("Mercury");
       Font font = Font.font("Verdana", FontPosture.REGULAR, 3); //Set font of the text
       labelMercury.setFont(font);
       labelMercury.setTextFill(Color.WHITE);           //Set label color
       labelMercury.setTranslateX(xMercury - 5);        //Setting the position
       labelMercury.setTranslateY(yMercury - 7);

       solarSystem.getChildren().add(mercury);
       circles[1] = mercury;
   }

   public Circle getMercury() {return mercury; }

   //0.72 AU
   public void addVenus(double x, double y) {
       double xVenus = xCenter + unitSize * x;
       double yVenus = yCenter + unitSize * y;
       Circle venus = new Circle(xVenus, yVenus, 4);
       Image imageVenus = new Image(getClass().getResourceAsStream("Resources/Venus.png"));
       ImagePattern imagePatternVenus = new ImagePattern(imageVenus);
       venus.setFill(imagePatternVenus);

       solarSystem.getChildren().add(venus);
       circles[2] = venus;

   }

   public Circle getVenus() {return venus; }

   //1 AU
   public void addEarth(double x, double y) {
       double xEarth = xCenter + unitSize * x;
       double yEarth = yCenter + unitSize * y;
       System.out.println(xEarth);
       System.out.println(yEarth);
       Circle earth = new Circle(xEarth, yEarth, 2);
       Image imageEarth = new Image(getClass().getResourceAsStream("Resources/Earth.png"));
       ImagePattern imagePatternEarth = new ImagePattern(imageEarth);
       earth.setFill(imagePatternEarth);

       solarSystem.getChildren().add(earth);
       circles[3] = earth;
   }

//   public Circle getEarth() {return earth; }

   public void addMoon(double x, double y) {
       double xMoon = xCenter + unitSize * x;
       double yMoon = yCenter + unitSize * y;
       Circle moon = new Circle(xMoon, yMoon, 1);
       Image imageMoon = new Image(getClass().getResourceAsStream("Resources/Moon.png"));
       ImagePattern imagePatternMoon = new ImagePattern(imageMoon);
       moon.setFill(imagePatternMoon);

       solarSystem.getChildren().add(moon);
       circles[4] = moon;
   }

    public Circle getMoon() {return moon; }

   //1.52 AU
   public void addMars(double x, double y) {
       double xMars = xCenter + unitSize * x;
       double yMars = yCenter + unitSize * y;
       Circle mars = new Circle(xMars, yMars, 2);
       Image imageMars = new Image(getClass().getResourceAsStream("Resources/Mars.png"));
       ImagePattern imagePatternMars = new ImagePattern(imageMars);
       mars.setFill(imagePatternMars);

       solarSystem.getChildren().add(mars);
       circles[5] = mars;
   }

    public Circle getMars() {return mars; }

   //5.2 AU
   public void addJupiter(double x, double y) {
       double xJupiter = xCenter + unitSize * x;
       double yJupiter = yCenter + unitSize * y;
       jupiter = new Circle(xJupiter, yJupiter, 7);
       Image imageJupiter = new Image(getClass().getResourceAsStream("Resources/Jupiter.png"));
       ImagePattern imagePatternJupiter = new ImagePattern(imageJupiter);
       jupiter.setFill(imagePatternJupiter);

       solarSystem.getChildren().add(jupiter);
       circles[6] = jupiter;
   }

   public Circle getJupiter() {return jupiter; }

   //9.54 AU
   public void addSaturn(double x, double y) {
       double xSaturn = xCenter + unitSize * x;
       double ySaturn = yCenter + unitSize * y;
       saturn = new Circle(xSaturn, ySaturn, 5);
       Image imageSaturn = new Image(getClass().getResourceAsStream("Resources/Saturn.png"));
       ImagePattern imagePatternSaturn = new ImagePattern(imageSaturn);
       saturn.setFill(imagePatternSaturn);

       System.out.println("saturn x " + xSaturn + " saturn y " + ySaturn);

       solarSystem.getChildren().add(saturn);
       circles[7] = saturn;
   }

    public Circle getSaturn() {return saturn; }

   public void addTitan(double x, double y) {
       double xTitan = xCenter + unitSize * x;
       double yTitan = yCenter + unitSize * y;
       titan = new Circle(xTitan, yTitan, 1);
       Image imageTitan = new Image(getClass().getResourceAsStream("Resources/Titan.png"));
       ImagePattern imagePatternTitan = new ImagePattern(imageTitan);
       titan.setFill(imagePatternTitan);

       System.out.println("titan x " + xTitan + " titan y " + yTitan);

       solarSystem.getChildren().add(titan);
       circles[8] = titan;
   }

   public void addSpacecraft(double x, double y){
       double xSpacecraft = xCenter + unitSize * x;
       double ySpacecraft = yCenter + unitSize * y;

       System.out.println("spacecraft " + x + " " + y);
       System.out.println("spacecraft " + xSpacecraft + " " + ySpacecraft);

       spacecraft = new Rectangle(xSpacecraft, ySpacecraft, 3.0, 5.0);
       Image imageSpacecraft = new Image(getClass().getResourceAsStream("/Visualization/Resources/Spacecraft.png"));
       ImagePattern imagePatternSpacecraft = new ImagePattern(imageSpacecraft);
       spacecraft.setFill(imagePatternSpacecraft);

       solarSystem.getChildren().add(spacecraft);

   }

    public Circle getTitan() {return titan; }

   //Returns all the planets to the solar system
   public SolarSystemPane getPane() {
        addGrid();
        addSun(0, 0); //addSun(fromKMToAU(physics.sun.getX()), fromKmToAU(physics.sun.getY()));
        addMercury(planets[1].getInitX(), planets[1].getInitY());
        addVenus(planets[2].getInitX(), planets[2].getInitY());
        addEarth(planets[3].getInitX(), planets[3].getInitY());
        addMoon((planets[4].getInitX()+0.05), (planets[4].getInitY()+0.05)); //Add the distance from the earth to the moon
        addMars(planets[5].getInitX(), planets[5].getInitY());
        addJupiter(planets[6].getInitX(), planets[6].getInitY());
        addSaturn(planets[7].getInitX(), planets[7].getInitY());
        addTitan((planets[8].getInitX()+0.05), (planets[8].getInitY()+0.05)); //Add the distance from Saturn to Titan
        addSpacecraft(planets[11].getInitX(), planets[11].getInitY());
        return this;
   }

   public ZoomablePane getZoomPane(){

       return space;
   }

    /**
     * Set x/y pivot points
     * @param x x-coordinate of the pivot point
     * @param y y-coordinate of the pivot point
     */
    public void setPivot( double x, double y) {
        setTranslateX(getTranslateX()-x);
        setTranslateY(getTranslateY()-y);
    }

    /**
     * Set x/y scale
     * @param scale
     */
    public void setScale( double scale) {
        myScale.set(scale);
    }

    public double getScale() {
        return myScale.get();
    }



}
