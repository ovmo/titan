import titan.ODEFunctionInterface;
import titan.ODESolverInterface;
import titan.StateInterface;

public class ODESolver implements ODESolverInterface {

    public static boolean debug = true;

    @Override
    public StateInterface[] solve(ODEFunctionInterface f, StateInterface y0, double[] ts) {

        return new StateInterface[0];
    }

    @Override
    public StateInterface[] solve(ODEFunctionInterface f, StateInterface y0, double tf, double h) {

        // new state[tf/h]
        // for i in state[]
        // state[i] = step(f, t, y, h)
        //return state[]

        return new StateInterface[0];
    }

    @Override
    public StateInterface step(ODEFunctionInterface f, double t, StateInterface y, double h) {

        // new state = y.addMul(h, f(h, y)
        // return state

        return null;
    }
}
