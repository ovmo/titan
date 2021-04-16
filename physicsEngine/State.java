import titan.RateInterface;
import titan.StateInterface;
import titan.Vector3dInterface;

public class State implements StateInterface{

    Vector3dInterface[][] matrix;      //2x10 array (9 planets (10 with probe), 2 properties - vel, pos)

    //Constructor
    public State() {
    }

    //Initialize the first state
    public void initializeState() {
        matrix = new Vector3d[10][2];
        PlanetStart p = new PlanetStart();

        for (int i = 0; i < 10; i++) {
            matrix[i][0] = new Vector3d(p.planets[i].velocityX, p.planets[i].velocityY, p.planets[i].velocityZ);    //Initialize positions
            matrix[i][1] = new Vector3d(p.planets[i].positionX, p.planets[i].positionY, p.planets[i].positionZ);    //Initialize velocities
        }
    }

    //Create new state after the update
    // new state newState
    // for (i in state) - loop through planets
    // update vel: state[i][1] = state[i][1].addMul(step, rate[i]
    // update pos: state[i][2] = state[i][2].addMul(step, state[i][1]
    public StateInterface addMul(double step, RateInterface rate) {
        StateInterface newState = new State();

        for (int i = 0; i < 10; i++) {
            matrix[i][0] = matrix[i][0].addMul(step, rate.get(i));      //Update vel
            matrix[i][1] = matrix[i][1].addMul(step, matrix[i][0]);     //Update pos
        }
        return newState;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < 10; i++) {
            str += "Vel: " + matrix[i][0].toString() + " Pos: " + matrix[i][1].toString();
        }
        return str;
    }
}
