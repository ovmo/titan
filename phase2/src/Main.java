import PhysicsEngine.State;
import PhysicsEngine.Planets.PlanetStart;
import PhysicsEngine.ProbeSimulator;
import PhysicsEngine.ODESolver;
import PhysicsEngine.Probe.TakeOffPoint;
import PhysicsEngine.Solvers.RungeKuttaSolver;
import PhysicsEngine.Solvers.VerletSolver;
import PhysicsEngine.titan.StateInterface;
import PhysicsEngine.titan.Vector3dInterface;

import java.util.ArrayList;

public class Main {

    static boolean PRINT = true;

    public static void main(String args[]){

        //Get initial state
        PlanetStart planetStart = new PlanetStart();
        StateInterface initState = planetStart.getInitState();

        //New probeSimulator
        ProbeSimulator probeSimulator = new ProbeSimulator();

        //Initial parameters to start the mission
        double tf = 31536000;       //final time point of the mission ins seconds (31636000s = one year)
        double h = (86400 / 10);    //step size with which everything is updated (86400s = 1 day)

        double initVelProbe = 60000;     //initial (undirected) velocity of the probe in m/s

        //Calculate take off point of the probe
        TakeOffPoint takeOffPoint = new TakeOffPoint(initVelProbe);
        Vector3dInterface p0 = takeOffPoint.startPos; //initial position here
        Vector3dInterface v0 = takeOffPoint.startVel; //initial velocity here

        //Solvers
        VerletSolver verlet = new VerletSolver(initState, h, tf/h);
        RungeKuttaSolver rungeKutta = new RungeKuttaSolver(); //To be added!!!

        ArrayList<StateInterface> verletStates = verlet.solve();

        //Calculate trajectory of the probe
        Vector3dInterface[] trajectory = probeSimulator.trajectory(p0, v0, tf, h);

        if(PRINT){

            System.out.println();
            System.out.println();
            System.out.println("START OF MISSION TO TITAN");
            System.out.println();
            System.out.println();
            System.out.println("tf = " + tf);
            System.out.println("step size = " + h);
            System.out.println();
            System.out.println();
            System.out.println("position of earth at start: " + ODESolver.states[0].getPos().get(3));
            System.out.println("position of titan at start: " + ODESolver.states[0].getPos().get(8));
            System.out.println();
            System.out.println();
            System.out.println("probe launched at: \nposition: " + takeOffPoint.startPos.toString() + "\nvelocity: " + initVelProbe + ", " +takeOffPoint.startVel.toString());
            System.out.println();
            System.out.println();
            System.out.println("probe at start: " + trajectory[0].toString());
            System.out.println("titan at start: " + ODESolver.states[0].getPos().get(8));
            System.out.println("euclidean distance probe to titan at start: " + trajectory[0].dist(ODESolver.states[0].getPos().get(8)));
            System.out.println("verlet distance probe to titan at start: " + trajectory[0].dist(((State)(verletStates.get(0))).getPos().get(8)));
            System.out.println();
            System.out.println("distance vector probe to titan at start: " + trajectory[0].sub(ODESolver.states[0].getPos().get(8)));
            System.out.println();
            System.out.println();
            System.out.println("probe at end: " + trajectory[trajectory.length-1].toString());
            System.out.println("titan at end: " + ODESolver.states[ODESolver.states.length-1].getPos().get(8));
            System.out.println("euclidean distance probe to titan at end: " + trajectory[trajectory.length-1].dist(ODESolver.states[ODESolver.states.length-1].getPos().get(8)));
            System.out.println("verlet distance probe to titan at start: " + trajectory[trajectory.length-1].dist(((State)(verletStates.get(verletStates.size()-1))).getPos().get(8)));
            System.out.println("distance vector probe to titan at end: " + trajectory[trajectory.length-1].sub(ODESolver.states[ODESolver.states.length-1].getPos().get(8)));
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("DETAILED TRAJECTORY");
            System.out.println();
            System.out.println();

            for(int i = 0; i < trajectory.length; i++){

                if (i % 100 == 0){ //print every 10 days
                    System.out.println("probe at " + i + ": " + trajectory[i].toString());
                    System.out.println("titan at " + i + ": " + ODESolver.states[i].getPos().get(8));
                    System.out.println("euclidean distance probe to titan: " + trajectory[i].dist(ODESolver.states[i].getPos().get(8)));
                    System.out.println("verlet distance probe to titan: " + trajectory[i].dist(((State) verletStates.get(i)).getPos().get(8)));
                    System.out.println();
                }
            }
        }
    }
}
