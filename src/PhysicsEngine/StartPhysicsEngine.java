package PhysicsEngine;

import Visualization.StartVisuals;

/**
 * Main class
*/
public class StartPhysicsEngine
{
	public static void main(String[] args) {

		PlanetStart start = new PlanetStart();
		
		/*
		 * Testing
		 * Simple testing = new Simple ();
		 * testing.calc(8, 60000);
		*/

		//Launch spacecraft
		Simulator launch = new Simulator();

		if(launch.launch(8, 57000)){

			//Start visual simulation
			StartVisuals.start();
		};
	}
}
