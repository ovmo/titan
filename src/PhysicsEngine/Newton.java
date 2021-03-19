package PhysicsEngine;

import PhysicsEngine.titan.Vector3dInterface;

/**
 * Class implementing Newton's Law of Gravitational Force
*/

public class Newton
{
    /**
    Instance Variables to make it easy to run
    */
    private static final boolean DEBUG = false;
    private static final double G = 6.6743015e-11;  //Gravitational constant
    private static double r;                        //Euclidean distance between i and j
    private static double rCube;                    //Distance cubed

    /**
     * implementing NLG as F = Gm(i)m(j)*(pos(i)-pos(j)/|pos(i)-pos(j)|^3
     *
     * @param i first planet
     * @param j second planet
     *
     * @return F gravitational force acting on i and j
     */
    public static Vector3dInterface solve(Planet i, Planet j)
    {
        if(DEBUG)
        {
            System.out.println("Planet1: " + i.name + ", Planet2: " + j.name);
        }
        // finding the bottom of the division
        r = i.vector3d.dist(j.vector3d);
        rCube = Math.pow(r, 3);
        Vector3dInterface acceleration = new Vector3d(0,0,0);
        if (i != j)
        {
            // acceleration that is created by
            acceleration = (((j.vector3d.sub(i.vector3d)).mul(1/rCube))).mul(G * j.mass);
        }
        else if (i == j && DEBUG)
        {
            System.out.println("E-E");
        }
        return acceleration;
    }

    /**
    This method is the calculation of one step on the planets and add the 
     * @param planets array containing all the planets of the solar system
     * @param stepSize (seconds)
    */
    public static boolean newtonLoop (Planet[] planets, int stepSize)
    {
        //Reset the acceleration to 0
        Planet.accReset();
        // iterate over all the planets
        for(int i = 0; i < planets.length; i++)
        {
            // all other planets
            for(int j = 0; j< planets.length; j++)
            {
                // if i planet and j planet are the NOT same  
                if(i != j)
                {
                    // calculate the acceleration from the attraction of the two objects
                    Vector3dInterface acceleration = Newton.solve(planets[i], planets[j]);
                    //Add the calculated acceleration to acceleration of planet i
                    planets[i].accVector = (Vector3d)(planets[i].accVector.add(acceleration));
                }
            }
        }

        //Update the positions and velocities
        for (int k = 0; k < planets.length; k++)
        {
            // the Velocity vector is first in line
            Vector3dInterface mul = planets[k].accVector.mul(stepSize);
            planets[k].velVector = (Vector3d)(planets[k].velVector.add(mul));
            // followed by the position vector using the updated velocity
            mul = planets[k].velVector.mul(stepSize);
            Vector3d posVector = (Vector3d)(planets[k].vector3d.add(mul));
            //updating current posVector of planets
            planets[k].vector3d = posVector;
        }
        
        if (planets[11].vector3d.dist(planets[8].vector3d) <= planets[8].radius)
        {
            // this case hits if the spacecraft has plowed into titan - since we are updating
            // the intervals very frequently I assume that we will notice a hit.
            return true;
        }
        else
        {
            // we currently return false since SpaceCraft and Titan have not crashed.
            return false;
        }
    }
}
