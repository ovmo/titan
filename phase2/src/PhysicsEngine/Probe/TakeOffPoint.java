package PhysicsEngine.Probe;

import PhysicsEngine.Planets.Planet;
import PhysicsEngine.Vector3d;

/**
 * Class to calculate optimal initial conditions for the probe to launch
 *
 * @author Oscar, Leo
 */

public class TakeOffPoint {

    public Vector3d unitVector;
    public Vector3d startPos;
    public Vector3d startVel;

    /**
     * Constructor
     * @param initVel initial velocity in m/s
     */
    public TakeOffPoint(double initVel){
       unitVector();
       startPos();
       startVel(initVel);
    }

    /**
     * calculate unitVector from earth to PhysicsEngine.PhysicsEngine.Planets.titan by
     * taking the difference between earth.positionVector and PhysicsEngine.PhysicsEngine.Planets.titan.positionVector and dividing it by
     * the euclidean distance between earth.positionVector and PhysicsEngine.PhysicsEngine.Planets.titan.positionVector
     * @return the unitVector from earth to PhysicsEngine.PhysicsEngine.Planets.titan
     */
    public Vector3d unitVector(){
        unitVector = (Vector3d) Planet.planets[8].posVector.sub(Planet.planets[3].posVector).mul(1/Planet.planets[8].posVector.dist(Planet.planets[3].posVector));
        return unitVector;
    }
    /**
     * positioning the take off point somewhere on earth's surface and configuring take off point
     * so that it is directed towards PhysicsEngine.PhysicsEngine.Planets.titan by
     * multiplying unitVector earth to PhysicsEngine.PhysicsEngine.Planets.titan with radius of earth - this way we get a new vector, with the same direction
     * as the unitVector (so we are pointing towards PhysicsEngine.PhysicsEngine.Planets.titan), but with a different magnitude (so that we are on earth's surface)
     * @return starting positionVector of the probe
     */
    public Vector3d startPos(){
        startPos = (Vector3d) Planet.planets[3].posVector.addMul(Planet.planets[3].radius, unitVector);
        return startPos;
    }

    /**
     * calculating starting velocity of the probe by
     * multiplying unitVector earth to PhysicsEngine.PhysicsEngine.Planets.titan with the (undirected) initialVelocity in m/s
     * this way we get a new (directed) velocityVector towards PhysicsEngine.PhysicsEngine.Planets.titan
     * @param initVel initialVelocity in m/s
     * @return starting (directed) velocityVector of the probe
     */
    public Vector3d startVel(double initVel){
        startVel = (Vector3d) unitVector.mul(initVel);
        return startVel;
    }
}
