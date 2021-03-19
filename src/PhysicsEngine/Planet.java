package PhysicsEngine;

import java.util.ArrayList;

/**
* Class holding all the information needed to find the trajectory of a planet
*/
public class Planet
{

	//the following variables represent all of the required variables to store velocity, position and acceleration values for each solar system object.
	public String name;
	public int step;

	public double mass;
	public double radius;
	public double gravity;
	//variables store the velocity in terms of a 3D model. These variables are only initialized and called  once.
	public double velocityX;
	public double velocityY;
	public double velocityZ;
	//variables store position in terms of a 3D model. these variables are also initialized and called once.
	public double positionX;
	public double positionY;
	public double positionZ;
	//variables store vectors in terms of a 3D model. These variables are then used in the vectors method.
	public Vector3d vector3d;
	public Vector3d velVector;
	public Vector3d accVector;

	//arrayList to store positions over time
	ArrayList<Vector3d> orbit = new ArrayList<Vector3d>();

	ArrayList distances = new ArrayList<>();

	//array to store x-Coordinates over time
	double[] orbitX;

	//array to store y-Coordinates over time
	double[] orbitY;

	public static Planet[] planets; //Array of all planets of the solar system


	/**
	 *Constructor
	 *@param namePlanet represents the name of the planet to be created
	*/
	public Planet (String namePlanet)
	{
		name = namePlanet;
		step = 0;
	}
	
	/**
	 * Create the vector3d objects.
	*/
	public void vectors ()
	{
		vector3d = new Vector3d(positionX, positionY, positionZ);
		velVector = new Vector3d(velocityX, velocityY, velocityZ);
		accVector = new Vector3d(0,0,0);

		orbit.add(vector3d);
	}

	/**
	 *  Resets the acceleration of the planet
	 */
	public static void accReset ()
	{
		for (int i = 0; i < planets.length; i++)
		{
			planets[i].accVector = new Vector3d(0,0,0);
		}
	}

	public double fromMToAU(double m) {
		double AU = m*6.6846e-12;
		return AU;
	}

	/**
	 * @return array holding x-coordinates over time (in AU, important for visualization!)
	 */
	public double[] getOrbitX(){

		orbitX = new double[orbit.size()];

		for(int i = 0; i < orbit.size(); i++){
			orbitX[i] = fromMToAU(orbit.get(i).getX());
		}
		return orbitX;
	}

	/**
	 * @return array holding y-coordinates over time (in AU, important for visualization!)
	 */
	public double[] getOrbitY(){

		orbitY = new double[orbit.size()];

		for(int i = 0; i < orbit.size(); i++){
			orbitY[i] = fromMToAU(orbit.get(i).getY());
		}
		return orbitY;
	}

	public double getInitX(){

		return fromMToAU(orbit.get(1).getX());
	}

	public double getInitY(){

		return fromMToAU(orbit.get(1).getY());
	}
}
