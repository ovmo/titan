import titan.ODEFunctionInterface;
import titan.ODESolverInterface;
import titan.StateInterface;

/**
 * class implementing Euler's method to calculate motion of objects in the solar system
 *
 * @author Leo
 */
public class ODESolver implements ODESolverInterface {

    public static boolean DEBUG = false;
    public static State[] states;

    /**
     * Euler solver
     *
     * @param f ODEFunction implementing Newton's law
     * @param y0 initial state of the system
     * @param ts time steps at which position is being updated
     * @return state of the system at different time points
     */
    @Override
    public StateInterface[] solve(ODEFunctionInterface f, StateInterface y0, double[] ts) {

        //create array storing states at different timestamps
        states = new State[ts.length];
        states[0] = (State) y0;

        for(int i = 1; i < states.length; i++){
            states[i] = (State) step(f, ts[i], states[i-1], (ts[i]-ts[i-1]));
        }

        return states;
    }

    /**
     * Euler solver
     *
     * @param f ODEFunction implementing Newton's law
     * @param y0 initial state of the system
     * @param tf final time point
     * @param h step size
     * @return positions of the probe over a given time period
     */
    @Override
    public StateInterface[] solve(ODEFunctionInterface f, StateInterface y0, double tf, double h) {

        //get array storing separate timestamps
        double[] ts = new double[(int) (Math.round((tf/h)+1))];
        ts[0] = 0;
        for(int i = 1; i < ts.length; i++){
            ts[i] = ts[i-1] + h;
        }

        //create array storing states at different timestamps
        states = new State[(int) (Math.round(tf/h)+1)];
        states[0] = (State) y0;

        if(DEBUG){
            System.out.println("ODESolver - states " + states.length);
            System.out.println("ODESolver - state at 0\n" + y0.toString());
        }

        for(int i = 1; i < states.length; i++){
            states[i] = (State) step(f, ts[i], states[i-1], h);
        }

        if(DEBUG){
            for(int i = 0; i < (states.length); i++){
                if(i % 10 == 0){ //print every day
                    System.out.println("ODESolver - state at " + (i) + "\n" + states[i].toString());
                }
            }
        }

        return states;
    }

    /**
     * calculating one step
     *
     * @param f ODEFunction implementing Newton's law
     * @param t time
     * @param y state
     * @param h step size
     * @return new state of the system after one update step
     */
    @Override
    public StateInterface step(ODEFunctionInterface f, double t, StateInterface y, double h) {

        State newState = (State) y.addMul(h, f.call(h, y));

        return newState;
    }
}
