package PhysicsEngine;

import PhysicsEngine.titan.Vector3dInterface;
import java.lang.Math;

public class Simulator
{
	static final boolean DEBUG = true;
	Planet[] planets;

	/**
	 * Constructor
	*/
	public Simulator()
	{
		PlanetStart start = new PlanetStart();
		planets = start.planets;
	}

	/**
	 * method to test best possible initial velocity and position of the spacecraft
	 * just for testing purposes
	 * @param stepSize
	 * @param initV
	 */

//	public void calc (int stepSize, int initV) {
//		if (DEBUG) {
//			//Initial position of PhysicsEngine.titan
//			System.out.println("initial start Titan [8]: " + planets[8].vector3d.toString());
//			System.out.println("initial start SpaceCraft [11]: " + planets[11].vector3d.toString());
//		}
//
//
//
//		int cap = 31536001; //One year in seconds
//		int cap1 = 31536001; //One year in seconds
//
////		//This loop gets the position of PhysicsEngine.titan
//
////		for (int d = 0; d < cap1; d += stepSize)
////		{
////			if (Newton.newtonLoop(spacePlanets, stepSize))
////			{
////				throw new RuntimeException("END");
////			}
////			else
////			{
////				if(DEBUG && (d == 0)) //position at beginning
////				{
////					System.out.println("PhysicsEngine/titan " + spacePlanets[8].vector3d.toString());
////					//position of earth at half a year
////					System.out.println("earth " + spacePlanets[3].vector3d.toString());
////					//Euclidean distance between earth and PhysicsEngine.titan
////					System.out.println("dist vect " + spacePlanets[8].vector3d.dist(spacePlanets[3].vector3d));
////				}
////				else if (DEBUG && (d % (cap1/2)) == 0) //getting position at half a year
////				{
////
////					//Position of PhysicsEngine.titan at half a year
////					System.out.println("PhysicsEngine/titan " + spacePlanets[8].vector3d.toString());
////					//Position of earth at half a year
////					System.out.println("earth " + spacePlanets[3].vector3d.toString());
////					//Euclidean distance between earth and PhysicsEngine.titan
////					System.out.println("dist vect " + spacePlanets[8].vector3d.dist(spacePlanets[3].vector3d));
////				}
////				else if(DEBUG && (d % (cap1)) == 0) //getting position after one year
////				{
////					//position of PhysicsEngine.titan at half a year
////					System.out.println("PhysicsEngine/titan " + spacePlanets[8].vector3d.toString());
////					//position of earth at half a year
////					System.out.println("earth " + spacePlanets[3].vector3d.toString());
////					//Euclidean distance between earth and PhysicsEngine.titan
////					System.out.println("dist vect " + spacePlanets[8].vector3d.dist(spacePlanets[3].vector3d));
////				}
////			}
////		}
//
//	}

	public boolean launch(int stepSize, int initV) {

		spaceFlight (initV);
		int cap = 31536001; //One year in seconds

		if (DEBUG)
		{
			System.out.println("initial start Titan [8]: " + planets[8].vector3d.toString());
			System.out.println("initial start SpaceCraft [11]: " + planets[11].vector3d.toString());

		}
		for (int d = 0; d < cap; d += stepSize)
		{
			//here the probe is launched
			if (Newton.newtonLoop(planets, stepSize))
			{
				System.out.println("Probe has successfully reached Titan");
				return true;
			}
			else
			{
				if (DEBUG && (d % 864000/2) == 0) // 864000 represents an interval of 10 days, in terms of seconds. getting an update for the position
				{
					//position of the spacecraft and distance to titan
					System.out.print("position of the probe " + (planets[11].vector3d.toString()));
					System.out.println (", euclidean distance: " + planets[11].vector3d.dist(planets[8].vector3d));

					//adding positions to orbits
					for(int i = 0; i < planets.length; i++){
						planets[i].orbit.add(planets[i].vector3d);
					}

					planets[11].distances.add(planets[11].vector3d.dist(planets[8].vector3d));
				}
			}
		}

		System.out.println("The probe did not reach titan within one year");
		return true;
	}


	/**
	 * @param initV
	 */
	public void spaceFlight (int initV)
	{
		//Call once the takeoff point
		Vector3dInterface unitVector = takeOffPoint();
		planets[11].velVector = (Vector3d)(unitVector.mul(initV));
	}

	/**
	 * Space Craft take off point
	 * @return
	 */
	public Vector3dInterface takeOffPoint ()
	{
		//Calculate the Unit vector for position to fly to PhysicsEngine.titan
		System.out.println("Earth at 0" + planets[3].vector3d.toString());
		System.out.println("Titan " + planets[8].vector3d.toString());
		Vector3d sub = (Vector3d)(planets[8].vector3d.sub(planets[3].vector3d));

		Vector3dInterface unitVectorET = sub.div(Math.abs((planets[8].vector3d.sub(planets[3].vector3d)).norm()));
		planets[11].vector3d = (Vector3d)((unitVectorET.mul(planets[3].radius)).add(planets[3].vector3d));


		return unitVectorET;
	}
}
