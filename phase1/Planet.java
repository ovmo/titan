/**
* this class holds all the information needed find the trajectory of a planet
*/
public class Planet 
{	
	/**
	Initializing the Class
	@param namePlanet - name of the planet to be created 
	(we are God and are creating the universe)
	*/
	public Planet (String namePlanet)
	{
		name = namePlanet;
		step = 0;
	}
	
	/**
	This method gets called at the end of initialization to create the vector3d objects.
	*/
	public void vectors ()
	{
		vector3d = new Vector3d(positionX, positionY, positionZ);
		velVector = new Vector3d(velocityX, velocityY, velocityZ);
		accVector = new Vector3d(0,0,0);
	}

	/**
	Instance fields of the Planet
	*/
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

}


