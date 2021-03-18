package PhysicsEngine;

/**
 * Main class
*/
public class StartPhysicsEngine
{
	public static void main(String[] args) {
		PlanetStart start = new PlanetStart(); //?? This variable is never used

		Simple testing = new Simple ();

		//Loop over initV fom 30000 - 60000 in steps of 5000 - increasing velocity by 50 m/s
		testing.calc(8, 60000);
	}
}