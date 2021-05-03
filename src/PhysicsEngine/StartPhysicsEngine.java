package PhysicsEngine;

import Visualization.StartVisuals;

/**
 * Main class
*/
public class StartPhysicsEngine
{
	public static void main(String[] args) {

		PlanetStart start = new PlanetStart();


		//Launch spacecraft
		Simulator launch = new Simulator();
		// with 64 km s is the only way i can currently reach titan
		// with step size 1 i got in e8 but that is super inefficient.
		if(launch.launch(8, 64000)){

			//Start visual simulation
			 StartVisuals.start();
		}
	}
}
