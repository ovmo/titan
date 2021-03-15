public class SpaceCraft
{
	private final int MAX_TAKEOFF = 60000;
	private final int MIN_TAKEOFF = 11200;
	private int mass;
	private int takeoffV;

	public SpaceCraft(int massInit)
	{
		this.mass = massInit;
		takeoffV = 50000;
	}

	public void setMass (int massNew)
	{
		mass = massNew;
	}

	public int getMass ()
	{
		return mass;
	}

	public void setTakeOff (int velocity)
	{
		if (velocity >= MIN_TAKEOFF && velocity <= MAX_TAKEOFF)
		{
			takeoffV = velocity;
		}
		else
		{
			throw new RuntimeException("the TakeOff Velocity does not hold. Please enter a velocity on m/s. ");
		}
	}

	public int getTakeOff ()
	{
		return takeoffV;
	}
}