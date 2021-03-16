public class Simple 
{
	static final boolean DEBUG = true;
	Planet[] planets;
	public Simple ()
	{
		PlanetStart start = new PlanetStart();
		planets = start.planets;
		calc(1);
	}

	public void calc (int stepSize)
	{
		int cap = 365; // days
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
					System.out.print("" +d + ", ");
				}
			}
		}
	}


}