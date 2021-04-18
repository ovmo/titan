import titan.ProbeSimulatorInterface;
import titan.StateInterface;
import titan.Vector3dInterface;

/**
 * class to simulate trajectory of the probe
 *
 * @author Leo
 */

public class ProbeSimulator implements ProbeSimulatorInterface {

    public static boolean DEBUG = false;

    /**
     * calculate trajectory of a probe
     *
     * @param p0 starting position
     * @param v0 starting velocity
     * @param ts time steps at which position is being updated
     * @return positions of the probe over a given time period
     */
    @Override
    public Vector3dInterface[] trajectory(Vector3dInterface p0, Vector3dInterface v0, double[] ts) {

        //starting conditions of the spacecraft
        Planet.planets[11].posVector = p0;
        Planet.planets[11].velVector = v0;

        //initial state of the system
        State y0 = new State();
        y0.initializeState();

        if(DEBUG){
            for(int i = 0; i < Planet.planets.length; i++) {
                System.out.println("probeSimulator " + Planet.planets[i].name + " " + y0.getPos(i));
            }
        }

        //start solver
        ODESolver solver = new ODESolver();
        State[] states = (State[]) solver.solve(new ODEFunction(), y0, ts);

        //extract information
        Vector3d [] trajectory = new Vector3d[ts.length];

        for(int i = 0; i < trajectory.length; i++){
            trajectory[i] = (Vector3d) states[i].getPos(10);
        }

        return trajectory;
    }

    /**
     * calculate trajectory of a probe
     *
     * @param p0 starting position
     * @param v0 starting velocity
     * @param tf final time point
     * @param h step size
     * @return positions of the probe over a given time period
     */
    @Override
    public Vector3dInterface[] trajectory(Vector3dInterface p0, Vector3dInterface v0, double tf, double h) {

        // spacecraft.posVec = p0
        // spacecraft velVec = v0
        // new state y, fill with info from planets
        // new solver -> solve(new f, y, tf, h)

        //starting conditions of the spacecraft
        Planet.planets[11].posVector = p0;
        Planet.planets[11].velVector = v0;

        //initial state of the system
        State y0 = new State();
        y0.initializeState(); // can solve this better?

        if(DEBUG){
            for(int i = 0; i < Planet.planets.length; i++) {
                System.out.println("probeSimulator " + Planet.planets[i].name + " " + y0.getPos(i));
            }
        }

        //start solver
        ODESolver solver = new ODESolver();
        State[] states = (State []) solver.solve(new ODEFunction(), y0, tf, h);

        //extract information
        Vector3d [] trajectory = new Vector3d[(int) (Math.round(tf/h)+1)];

        for(int i = 0; i < trajectory.length; i++){
            trajectory[i] = (Vector3d) states[i].getPos(10);
        }

        return trajectory;
    }
}
