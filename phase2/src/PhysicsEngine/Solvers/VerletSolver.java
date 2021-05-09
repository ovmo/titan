package PhysicsEngine.Solvers;

import PhysicsEngine.State;
import PhysicsEngine.Planets.PlanetStart;
import PhysicsEngine.VectorOperations;
import PhysicsEngine.titan.StateInterface;
import PhysicsEngine.titan.Vector3dInterface;

import java.util.ArrayList;

/**
 * VERLET SOLVER
 *
 * @author Chiara
 */
public class VerletSolver {

    private final PlanetStart p = new PlanetStart();                                //Only used to get information about planets
    private double[] masses;                                                        //Array storing the masses of all planets
    private final double grav = 6.674E-11;                                          //Gravitational force

    private final ArrayList<StateInterface> states = new ArrayList<>();             //Arraylist storing all states throughout a year
    private final ArrayList<Vector3dInterface> positions = new ArrayList<>();
    private final ArrayList<Vector3dInterface> prevPositions = new ArrayList<>();
    private final ArrayList<Vector3dInterface> velocities= new ArrayList<>();
    private final Vector3dInterface[] acceleration;

    private final double ts;
    private final double numOfSteps;

    /**
     * CONSTRUCTOR
     *
     * @param y0 is the initial state
     * @param timeSteps  is timestep that should be added at each change of scene (Should be 86400 / 10 because 1 day = 86400 seconds and the scenes must be updated every 10 days)
     * @param numOfSteps is the amount of timesteps to be taken (Should be 3144960 because the final time tf = 3153600 i.e tf/timeStep = 3153600/(86400 / 10) = 3144960)
     */
    public VerletSolver(StateInterface y0, double timeSteps, double numOfSteps) {
        this.states.add(y0);            //Add first state to array of all states
        masses = p.getInitMasses();     //Initialize array with initial masses of all planets

        //Initialize both positions and previousPositions arraylists with the initial positions of all planets
        for (int i = 0; i < p.planets.length; i++) {
            positions.add(p.planets[i].posVector);
            prevPositions.add(p.planets[i].posVector);
        }

        //Initialize the velocity arraylist with the initial velocity of all planets
        for (int i = 0; i < p.planets.length; i++) {
            velocities.add(p.planets[i].velVector);
        }

        //Initialize acceleration vector
        acceleration = new Vector3dInterface[positions.size()];

        //Update accelerations
        updateAcceleration();

        //Initialize timeStep and numOfSteps
        this.ts = timeSteps;
        this.numOfSteps = numOfSteps;
    }

    /**
     * THIS METHOD ACTUALLY PERFORMS THE VERLET SOLVER
     *
     * Use velocity Verlet on first step to get previous and present position
     * (See formulas backward and forward formulas result in the PhysicsEngine.PhysicsEngine.Planets.Solvers.Verlet formula)
     *
     * @return array with all the different states
     */
    public ArrayList<StateInterface> solve() {
        nextPosVelocityVerlet();            //First update of the positions with Velocity Verlet
        addNewState(1);                //This is the first state to be added

        for (int i = 2; i < numOfSteps; i++) {
            nextPosPositionVerlet();
            addNewState(i * ts);
        }
        return this.states;
    }

    /**
     *  SIMPLE POSITION VERLET
     *
     *  1. The current positions are stored in the ArrayList storing the previous positions
     *  2. The current positions are updated
     *  3. The acceleration is updated
     */
    public void nextPosPositionVerlet() {
        for (int i = 0; i < positions.size(); i++) {

            Vector3dInterface pos = positions.get(i).mul(2);
            Vector3dInterface prevPos = prevPositions.get(i).mul(-1);
            Vector3dInterface acc = acceleration[i].mul(ts * ts);

            ArrayList<Vector3dInterface> vs = new ArrayList<>();
            vs.add(pos);
            vs.add(prevPos);
            vs.add(acc);

            prevPositions.set(i, positions.get(i));             //ArrayList of previous positions becomes equal to the current positions
            positions.set(i, VectorOperations.sumAll(vs));      //ArrayList of current positions is updated with updated positions
        }
        updateAcceleration();
    }

    /**
     *  VELOCITY VERLET
     *
     *  1. The current positions are stored in the ArrayList storing the previous positions
     *  2. The current positions are updated
     *  3. The acceleration is updated
     *
     */
    public void nextPosVelocityVerlet() {

        //Update position
        for (int i = 0; i < positions.size(); i++) {

            Vector3dInterface pos = positions.get(i);
            Vector3dInterface vel = velocities.get(i).mul(ts);
            Vector3dInterface acc = acceleration[i].mul(ts * ts * (0.5));

            ArrayList<Vector3dInterface> vs = new ArrayList<>();
            vs.add(pos);
            vs.add(vel);
            vs.add(acc);

            positions.set(i, VectorOperations.sumAll(vs));
        }
        updateAcceleration();
    }

    /**
     * The acceleration is updated
     */
    public void updateAcceleration() {

        for (int i = 0; i < positions.size(); i++) {

            Vector3dInterface body1 = positions.get(i);
            double mass1 = masses[i];                       //Copy array of masses

            ArrayList<Vector3dInterface> forces = new ArrayList<>();

            for (int j = 0; j < positions.size(); j++) {
                if (j != i) {
                    Vector3dInterface body2 = positions.get(j);
                    double mass2 = masses[j];
                    forces.add(gravitationalForce(mass1, mass2, body1, body2));
                }
            }
            acceleration[i] = VectorOperations.sumAll(forces).mul(1/mass1);
        }
    }

    /**
     * Evaluate the change in the direction of the objects due to the forces that act on them
     *
     * Forces taken into account:
     * - force that one object performs on the other (evaluated by the directionVector(p1, p2) method)
     * - gravitational force
     *
     * @param m1 is the mass of the first object
     * @param m2 is the mass of the second object
     * @param v1 is the direction represented by the vector with the position of the first object
     * @param v2 is the direction represented by the vector with the positions of the second object
     * @return positions after all the forces influenced it
     */
    private Vector3dInterface gravitationalForce(double m1, double m2, Vector3dInterface v1, Vector3dInterface v2) {
        double distance = v2.dist(v1);
        Vector3dInterface forceDirection = VectorOperations.approximateDirection(v1, v2);       //Direction of force resulting from the two vectors
        double force = grav * m1 * m2 / Math.pow(distance, 2);                                  //Actual force resulting from the two vectors
        return forceDirection.mul(force);
    }

    /**
     *  Add new state to the array of states
     *
     *  @param time is the time of the new state
     */
    private void addNewState(double time) {
        State newState = new State(time, new ArrayList<>(this.positions), this.velocities);
        states.add(newState);
    }
}