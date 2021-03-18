import java.lang.Math;
import titan.Vector3dInterface;
public class Simple 
{
	static final boolean DEBUG = true;
	Planet[] planets;
	Planet[] spacePlanets;
	public Simple ()
	{
		PlanetStart start = new PlanetStart();
		planets = start.planets;
	}

	public void calc (int stepSize, int initV)
	{
		if (DEBUG)
		{
			System.out.println("initial start Titan [8]: " + planets[8].vector3d.toString());
			System.out.println("initial start SpaceCraft [11]: " + planets[11].vector3d.toString());
		}
		
		spacePlanets = planets.clone();
		
		int cap = 31536001; // one year in seconds
		int cap1 = 31536001; // one year in seconds
		for (int d = 0; d < cap1; d += stepSize)
		{
			if (Newton.newtonLoop(spacePlanets, stepSize))
			{
			// break;
				throw new RuntimeException("END");
			}
			else 
			{
				if (DEBUG && (d % 864000) == 0)
				{
					// System.out.print("" + (d/86400) + ", ");
					// System.out.print("SpaceCraft " + planets[11].vector3d.dist(planets[8].vector3d) + ", Earth ");
					// System.out.println(planets[3].vector3d.dist(planets[8].vector3d));
					System.out.print((spacePlanets[8].vector3d.sub(spacePlanets[11].vector3d)).toString());
					System.out.println (", Norm: " + (spacePlanets[8].vector3d.sub(spacePlanets[11].vector3d)).norm());
				}
			}
		}
		spaceFlight (initV);

		if (DEBUG)
		{
			System.out.println("initial start Titan [8]: " + planets[8].vector3d.toString());
			System.out.println("initial start SpaceCraft [11]: " + planets[11].vector3d.toString());
		}
		for (int d = 0; d < cap; d += stepSize)
		{
			if (Newton.newtonLoop(planets, stepSize))
			{
			// break;
				throw new RuntimeException("END");
			}
			else 
			{
				if (DEBUG && (d % 864000) == 0)
				{
					// System.out.print("" + (d/86400) + ", ");
					// System.out.print("SpaceCraft " + planets[11].vector3d.dist(planets[8].vector3d) + ", Earth ");
					// System.out.println(planets[3].vector3d.dist(planets[8].vector3d));
					System.out.print((planets[8].vector3d.sub(planets[11].vector3d)).toString());
					System.out.println (", Norm: " + (planets[8].vector3d.sub(planets[11].vector3d)).norm());
				}
			}
		}
	}
	public void spaceFlight (int initV)
	{
		// call once the takeoff point
		Vector3dInterface unitVector = takeOffPoint();
		// Vsc = C * unitVectorET -> fly away direction
		// C <= 60km/s -> speed

		planets[11].velVector = (Vector3d)(unitVector.mul(initV));

	}

	// Space Craft take off point
	public Vector3dInterface takeOffPoint ()
	{
		// calculate the Unit vector for position to fly to titan
		System.out.println("Earth at 0" +planets[3].vector3d.toString());
		System.out.println("Titian " + spacePlanets[8].vector3d.toString());
		Vector3d sub = (Vector3d)(spacePlanets[8].vector3d.sub(planets[3].vector3d)); 

		Vector3dInterface unitVectorET = sub.div(Math.abs((spacePlanets[8].vector3d.sub(planets[3].vector3d)).norm()));
		planets[11].vector3d = (Vector3d)((unitVectorET.mul(planets[3].radius)).add(planets[3].vector3d));
		return unitVectorET;
	}


}