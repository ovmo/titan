package PhysicsEngine;

import Visualization.StartVisuals;

/**
 * Main class
*/
public class StartPhysicsEngine
{
	public static void main(String[] args) {

		PlanetStart start = new PlanetStart();

		//testing
		//Simple testing = new Simple ();
		//testing.calc(8, 60000);

		//launching
		Simulator launch = new Simulator();

		if(launch.launch(8, 60000)){

//			System.out.println(Planet.planets[1].orbit.size());
//			System.out.println(Planet.planets[1].orbit.get(1));
//			System.out.println(Planet.planets[1].getOrbitX()[1]);

			//starting visual simulation
			StartVisuals.start();
		};

	}
}
