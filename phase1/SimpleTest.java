/**
*/
public class SimpleTest 
{
	public static void main(String[] args) {
		PlanetStart start = new PlanetStart();

		Simple testing = new Simple ();

		//loop over initV fom 30000 - 60000 in steps of 5000 - increasing velocity by 50 m/s
		testing.calc(8, 60000);
	}
}