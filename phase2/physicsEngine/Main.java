import titan.Vector3dInterface;

public class Main {

    static boolean PRINT = true;

    public static void main(String args[]){

        //initialize positions of all objects in solarSystem
        PlanetStart planetStart = new PlanetStart();

        //new probeSimulator
        ProbeSimulator probeSimulator = new ProbeSimulator();

        //initial parameters to start the mission
        double tf = 31536000; //final time point of the mission ins seconds (31636000s = one year)
        double h = (86400 / 10000);  //step size with which everything is updated (86400s = 1 day)

        double initVel = 60000; //initial (undirected) velocity of the probe in m/s
        System.out.println("apr 25-19");
        //calculate take off point of the probe
        TakeOffPoint takeOffPoint = new TakeOffPoint(initVel);
        Vector3dInterface p0 = takeOffPoint.startPos; //initial position here
        Vector3dInterface v0 = takeOffPoint.startVel; //initial velocity here

        //calculate trajectory of the probe
        Vector3dInterface[] trajectory = probeSimulator.trajectory(p0, v0, tf, h);

        if(PRINT){


            System.out.println();
            System.out.println("START OF MISSION TO TITAN");
            System.out.println();
            System.out.println();
            System.out.println("tf = " + tf);
            System.out.println("step size = " + h);
            System.out.println();
            System.out.println();
            System.out.println("position of earth at start: " + ODESolver.states[0].getPos(3));
            System.out.println("position of titan at start: " + ODESolver.states[0].getPos(8));
            System.out.println();
            System.out.println();
            System.out.println("probe launched at: \nposition: " + takeOffPoint.startPos.toString() + "\nvelocity: " + initVel + ", " +takeOffPoint.startVel.toString());
            System.out.println();
            System.out.println();
            System.out.println("probe at start: " + trajectory[0].toString());
            System.out.println("titan at start: " + ODESolver.states[0].getPos(8));
            System.out.println("euclidean distance probe to titan at start: " + trajectory[0].dist(ODESolver.states[0].getPos(8)));
            System.out.println("distance vector probe to titan at start: " + trajectory[0].sub(ODESolver.states[0].getPos(8)));
            System.out.println();
            System.out.println();
            System.out.println("probe at end: " + trajectory[trajectory.length-1].toString());
            System.out.println("titan at end: " + ODESolver.states[ODESolver.states.length-1].getPos(8));
            System.out.println("euclidean distance probe to titan at end: " + trajectory[trajectory.length-1].dist(ODESolver.states[ODESolver.states.length-1].getPos(8)));
            System.out.println("distance vector probe to titan at end: " + trajectory[trajectory.length-1].sub(ODESolver.states[ODESolver.states.length-1].getPos(8)));
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("DETAILED TRAJECTORY");
            System.out.println();
            System.out.println();

            for(int i = 0; i < trajectory.length; i++){

                    if (i % 10000 == 0){ //print every 10 days
                        System.out.println("probe at " + i + ": " + trajectory[i].toString());
                        System.out.println("titan at " + i + ": " + ODESolver.states[i].getPos(8));
                        // System.out.println("sun at " + i + ": " + ODESolver.states[i].getPos(8));
                        // ODESolver.states[i].getPos(8)
                        System.out.println("euclidean distance probe to titan: " + ODESolver.states[i].getPos(8).dist(trajectory[i]));
                    }
            }



        }
    }
}
