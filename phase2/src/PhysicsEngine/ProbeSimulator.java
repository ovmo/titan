package PhysicsEngine;

import PhysicsEngine.Planets.PlanetStart;
import PhysicsEngine.Probe.Probe;
import PhysicsEngine.titan.ProbeSimulatorInterface;
import PhysicsEngine.titan.StateInterface;
import PhysicsEngine.titan.Vector3dInterface;
import PhysicsEngine.Planets.Planet;

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

        //Starting conditions of the spacecraft
        Probe probe = new Probe();
        probe.posVector = p0;
        probe.velVector = p0;

        if(DEBUG){
            System.out.println("probeSimulator - probe at 0 " + Planet.planets[11].posVector);
        }

        //Initial state of the system
        PlanetStart start = new PlanetStart();
        StateInterface y0 = start.getInitState();

        if(DEBUG){
            for(int i = 0; i < Planet.planets.length; i++) {
                System.out.println("probeSimulator " + Planet.planets[i].name + " " + ((State) y0).getPos().get(i));
            }
        }

        //start solver
        ODESolver solver = new ODESolver();
        State[] states = (State[]) solver.solve(new ODEFunction(), y0, ts);

        //extract information
        Vector3d[] trajectory = new Vector3d[ts.length];

        for(int i = 0; i < trajectory.length; i++){
            trajectory[i] = (Vector3d) states[i].getPos().get(11);
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

        //Starting conditions of the spacecraft
        Probe probe = new Probe();
        probe.posVector = p0;
        probe.velVector = p0;

        if(DEBUG){
            System.out.println("probeSimulator - probe at 0 " + Planet.planets[11].posVector);
        }

        //Initial state of the system
        PlanetStart start = new PlanetStart();
        StateInterface y0 = start.getInitState();

        if(DEBUG){
            for(int i = 0; i < Planet.planets.length; i++) {
                System.out.println("probeSimulator " + Planet.planets[i].name + " " + ((State) y0).getPos().get(i));
            }
        }

        //Start solver
        ODESolver solver = new ODESolver();
        State[] states = (State[]) solver.solve(new ODEFunction(), y0, tf, h);

        //Extract information
        Vector3d[] trajectory = new Vector3d[(int) (Math.round(tf/h)+1)];

        for(int i = 0; i < trajectory.length; i++){
            trajectory[i] = (Vector3d) states[i].getPos().get(11);
            if(DEBUG){
                System.out.println("probeSimulator - trajectory " + trajectory[i].toString());
            }
        }
        return trajectory;
    }
}