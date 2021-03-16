
public class ODEFunction implements ODEFunctionInterface 
{
	public RateInterface call (double t, StateInterface y)
	{
		// dy/dt = f(t, y(t));
		// dy[0]/dt = y[1]; -> f(t,y) = (y[1], cos(t) - sin(y[0])).
		// return y.step + h * (f(t(h*y.step), y(y.step*h)))

		double velFinal = y.rate + (y.acc * )
	}
}