package PhysicsEngine;

import PhysicsEngine.titan.RateInterface;
import PhysicsEngine.titan.StateInterface;
import PhysicsEngine.titan.Vector3dInterface;

import java.util.ArrayList;

/**
 * Data structure to store the state of the solar system
 *
 * @author Leo, Chiara
 */
public class State implements StateInterface {

    public final double h = (86400 / 10);               //step size with which everything is updated (86400s = 1 day)
    public double time;                                 //Time of given state (in seconds)
    public ArrayList<Vector3dInterface> positions;      //Positions of all planets at given state
    public ArrayList<Vector3dInterface> velocities;     //Velocities of all planets at given state


    /**
     * CONSTRUCTOR
     *
     * @param t is the time of current state
     * @param p are the positions of all objects at current state
     * @param v are the velocities of all objects at current state
     *
     */
    public State(double t, ArrayList<Vector3dInterface> p, ArrayList<Vector3dInterface> v) {
        this.time = t;              //Set time of given state
        this.positions = p;         //Set positions of given state
        this.velocities = v;        //Set velocities of given state
    }

    /**
     * Update time, positions and velocities of current state
     * @param step   The time-step of the update
     * @param rate   The average rate-of-change over the time-step. Has dimensions of [state]/[time].
     * @return updated state
     */
    public StateInterface addMul(double step, RateInterface rate) {

        ArrayList<Vector3dInterface> newVelocities = new ArrayList<>();
        ArrayList<Vector3dInterface> newPositions = new ArrayList<>();

        //Update velocities
        for (int i = 0; i < velocities.size(); i++) {
            newVelocities.add(i, velocities.get(i).addMul(step, ((Rate) rate).get(i)));
        }

        //Update positions
        for (int j = 0; j < positions.size(); j++) {
            newPositions.add(j, positions.get(j).addMul(step, newVelocities.get(j)));
        }

        //Update time
        double t = this.time + h;

        //Create new state
        State newState = new State(t, newPositions, newVelocities);

        return newState;
    }

    /**
     * @return positions of all planet at this state
     */
    public ArrayList<Vector3dInterface> getPos(){ return positions; }

    /**
     * @return velocities of all planets at this state
     */
    public ArrayList<Vector3dInterface> getVel(){ return velocities; }

    /**
     * @return information of this state as String
     */
    public String toString() {
        String str = "";
        str += " Time: " + "\n" + time + "\n" + " Vel: " + "\n" + velocities.toString() + " Pos: " + "\n" + positions.toString() + "\n";
        return str;
    }
}
