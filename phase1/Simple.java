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
		int cap = 31536001; // one year in seconds
		for (int d = 0; d < cap; d += stepSize)
		{
			if (Newton.newtonLoop(planets, stepSize))
			{
				break;
			}
			else 
			{
				if (DEBUG)
				{
					System.out.print("" + (d/86400) + ", ");
					System.out.print("" + planets[11].vector3d.dist(planets[8].vector3d) + ", ");
					System.out.println(planets[3].vector3d.dist(planets[8].vector3d));
				}
			}
		}
	}


}