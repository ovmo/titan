public class Simple 
{
	static final boolean DEBUG = true;
	Planet[] planets;
	public Simple ()
	{
		PlanetStart start = new PlanetStart();
		planets = start.planets;
	}

	public void calc (int stepSize)
	{
		if (DEBUG)
		{
			System.out.println("initial start Earth [3]: " + planets[3].vector3d.toString());
		}
		// Newton.newtonLoop(planets, stepSize);
		// Newton.newtonLoop(planets, stepSize);
		// Newton.newtonLoop(planets, stepSize);
		// Newton.newtonLoop(planets, stepSize);
		// Newton.newtonLoop(planets, stepSize);
		// Newton.newtonLoop(planets, stepSize);
		// Newton.newtonLoop(planets, stepSize);
		// Newton.newtonLoop(planets, stepSize);
		// Newton.newtonLoop(planets, stepSize);
		// Newton.newtonLoop(planets, stepSize);
		int cap = 31536001; // one year in seconds
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
					System.out.print((planets[8].vector3d.sub(planets[7].vector3d)).toString());
					System.out.println (", Norm: " + (planets[8].vector3d.sub(planets[7].vector3d)).norm());
				}
			}
		}
	}


}