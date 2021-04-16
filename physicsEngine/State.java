import titan.RateInterface;
import titan.StateInterface;

public class State implements StateInterface {

    // 2x2 array (9 planets (10 with probe), 2 properties - vel, pos)

    @Override
    public StateInterface addMul(double step, RateInterface rate) {

        //new state newState
        // for (i in state) - loop through planets
        // update vel: state[i][1] = state[i][1].addMul(step, rate[i]
        // update pos: state[i][2] = state[i][2].addMul(step, state[i][1]
        // return newState

        return null;
    }
}
