//<<<<<<< HEAD:phase1/SolverInterface.java
/*
 * @author Pieter Collins, Christof Seiler, Katerina Stankova, Nico Roos, Katharina Schueller
 * @version 0.99.0
 *
 * This interface serves as the API for students in phase 1.
 */

package titan;

import titan.StateInterface;
import titan.DifferentialEquationFunctionInterface;

/*
 * A class for solving a general differential equation dy/dt = f(t,y)
 *     y(t) describes the state of the system at time t
 *     f(t,y(t)) defines the derivative of y(t) with respect to time t
 */
public interface SolverInterface {

    /*
     * Solve the differential equation by taking multiple steps.
     *
     * @param   f       the function defining the differential equation dy/dt=f(t,y)
     * @param   y0      the starting state
     * @param   ts      the times at which the states should be output, with ts[0] being the initial time
     * @return  an array of size ts.length with all intermediate states along the path
     */
    public StateInterface[] solve(DifferentialEquationFunctionInterface f, StateInterface y0, double[] ts);

    /*
     * Solve the differential equation by taking multiple steps of equal size, starting at time 0.
     * The final step may have a smaller size, if the step-size does not exactly divide the solution time range
     *
     * @param   f       the function defining the differential equation dy/dt=f(t,y)
     * @param   y0      the starting state
     * @param   tf      the final time
     * @param   h       the size of step to be taken
     * @return  an array of size round(tf/h)+1 including all intermediate states along the path
     */
    public StateInterface[] solve(DifferentialEquationFunctionInterface f, StateInterface y0, double tf, double h);

    /*
     * Update rule for one step.
     *
     * @param   f   the function defining the differential equation dy/dt=f(t,y)
     * @param   t   the time
     * @param   y   the state
     * @param   h   the step size
     * @return  the new state after taking one step
     */
    public StateInterface step(DifferentialEquationFunctionInterface f, double t, StateInterface y, double h);
}
/*
 * @author Pieter Collins, Christof Seiler, Katerina Stankova, Nico Roos, Katharina Schueller
 * @version 0.99.0
 * 
 * This interface serves as the API for students in phase 1.
 */

package titan;

import titan.Vector3dInterface;
import titan.FunctionInterface;

public interface SolverInterface {
    
    /*
     * Update rule for multiple steps. Time will start at zero.
     * 
     * @param   f       the differential equation as defined in the project manual: 
     *                  y(t) describes the position of the system at time t
     *                  f(t, y(t)) describes the derivative of y(t) with respect to time t
     * @param   x0      the starting location
     * @param   h       the step size in seconds
     * @param   nSteps  the total number of time steps
     * @return  an array of size nSteps with all intermediate locations along the path 
     *              
     */
    public Vector3dInterface[] solve(FunctionInterface f, Vector3dInterface x0, double h, int nSteps);
    
    /*
     * Update rule for one step.
     * 
     * @param   f   the differential equation as defined in the project manual: 
     *              y(t) describes the position of the system at time t
     *              f(t, y(t)) describes the derivative of y(t) with respect to time t
     * @param   t   the time
     * @param   x   the location
     * @param   h   the step size in seconds
     * @return  the new location after taking one step 
     *              
     */
    public Vector3dInterface step(FunctionInterface f, double t, Vector3dInterface x, double h);
}
