package PhysicsEngine;

/**
* Class holding all the information needed to find the trajectory of a planet
*/
public class Planet
{

	/**
	 *Constructor
	 *@param namePlanet name of the planet to be created
	*/
	public Planet (String namePlanet)
	{
		name = namePlanet;
		step = 0;
	}
	
	/**
	 *Create the vector3d objects.
	*/
	public void vectors ()
	{
		vector3d = new Vector3d(positionX, positionY, positionZ);
		velVector = new Vector3d(velocityX, velocityY, velocityZ);
		accVector = new Vector3d(0,0,0);
	}

	/**
	 * Reset the acceleration of the planet
	 */
	public static void accReset ()
	{
		for (int i = 0; i < planets.length; i++)
		{
			planets[i].accVector = new Vector3d(0,0,0);
		}
	}

	public String name;
	public int step;

	public double mass;
	public double radius;
	public double gravity;

	public double velocityX;
	public double velocityY;
	public double velocityZ;

	public double positionX;
	public double positionY;
	public double positionZ;

	public Vector3d vector3d;
	public Vector3d velVector;
	public Vector3d accVector;

	public static Planet[] planets; //Array of all planets of the solar system
}