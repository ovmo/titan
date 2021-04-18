import titan.Vector3dInterface;

public class Main {

    static boolean DEBUG = true;

    public static void main(String args[]){

        //initialize solarSystem
        PlanetStart planetStart = new PlanetStart();

        //new probeSimulator
        ProbeSimulator probeSimulator = new ProbeSimulator();

        Vector3dInterface p0 = Planet.planets[11].posVector; //initial position here
        Vector3dInterface v0 = Planet.planets[11].velVector; //initial velocity here

        //calculate trajectory of the probe
        Vector3dInterface[] trajectory = probeSimulator.trajectory(p0, v0, 31536000, (86400 / 10));

        for(int i = 0; i < trajectory.length; i++){
            System.out.println("trajectory " + trajectory[i].toString());
        }

    }
}
