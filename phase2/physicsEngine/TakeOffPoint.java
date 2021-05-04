/**
 * class to calculate optimal initial conditions for the probe to launch
 *
 * @author Oscar, Leo
 */

public class TakeOffPoint {

    Vector3d unitVector;
    Vector3d startPos;
    Vector3d startVel;

    /**
     * constructor
     * @param initVel initial velocity in m/s
     */
    public TakeOffPoint(double initVel){
        unitVector();
        startPos();
        startVel(initVel);
    }

    /**
     * calculate unitVector from earth to titan by
     * taking the difference between earth.positionVector and titan.positionVector and dividing it by
     * the euclidean distance between earth.positionVector and titan.positionVector
     * @return the unitVector from earth to titan
     */
    public Vector3d unitVector(){
        Planet titanReach = new Planet("TITAN AT 183");
        titanReach.gravity = 8978.14E+03;
        titanReach.mass = 13455.3E+19;
        titanReach.radius = 2575.5E+03;
        // X = 3.803247214809294E+08 Y =-1.455031224264102E+09 Z = 1.069955579090142E+07
        // X = 6.332873118527889E+08 Y =-1.357175556995868E+09 Z =-2.134637041453660E+06
        titanReach.positionX = 3.803247214809294E+11;
        titanReach.positionY = -1.455031224264102E+12;
        titanReach.positionZ = 1.069955579090142E+10;
        titanReach.velocityX = 0;
        titanReach.velocityY = 0;
        titanReach.velocityZ = 0;
        titanReach.vectors();
        unitVector = (Vector3d) Planet.planets[8].posVector.sub(Planet.planets[3].posVector).mul(1/Planet.planets[8].posVector.dist(Planet.planets[3].posVector));
        // unitVector = (Vector3d) Planet.planets[8].posVector.sub(Planet.planets[3].posVector).mul(1/titanReach.posVector.dist(Planet.planets[3].posVector));
        return unitVector;
    }
    /**
     * positioning the take off point somewhere on earth's surface and configuring take off point
     * so that it is directed towards titan by
     * multiplying unitVector earth to titan with radius of earth - this way we get a new vector, with the same direction
     * as the unitVector (so we are pointing towards titan), but with a different magnitude (so that we are on earth's surface)
     * @return starting positionVector of the probe
     */
    public Vector3d startPos(){
        startPos = (Vector3d) Planet.planets[3].posVector.addMul(Planet.planets[3].radius, unitVector);
        return startPos;
    }

    /**
     * calculating starting velocity of the probe by
     * multiplying unitVector earth to titan with the (undirected) initialVelocity in m/s
     * this way we get a new (directed) velocityVector towards titan
     * @param initVel initialVelocity in m/s
     * @return starting (directed) velocityVector of the probe
     */
    public Vector3d startVel(double initVel){
        startVel = (Vector3d) unitVector.mul(initVel);
        return startVel;
    }
}
