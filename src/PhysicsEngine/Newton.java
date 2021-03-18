package PhysicsEngine;

import PhysicsEngine.titan.Vector3dInterface;

/**
 * Class implementing Newton's Law of Gravitational Force
*/

public class Newton
{

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
        r = i.vector3d.dist(j.vector3d);
        rCube = Math.pow(r, 3);
        Vector3dInterface acceleration = new Vector3d(0,0,0);
        if (i != j)
        {
            acceleration = (((j.vector3d.sub(i.vector3d)).mul(1/rCube))).mul(G * j.mass);
        }
        else if (i == j)
        {
            System.out.println("E-E");
        }
        return acceleration;
    }

    /**
     * @param planets array containing all the planets of the solar system
     * @param stepSize (seconds)
    */
    public static boolean newtonLoop (Planet[] planets, int stepSize)
    {
        //Reset the acceleration to 0
        Planet.accReset();

        for(int i = 0; i < planets.length; i++)
        {
            for(int j = 0; j< planets.length; j++)
            {
                if(i != j)
                {
                    Vector3dInterface acceleration = Newton.solve(planets[i], planets[j]);
                    //Add F to acceleration of planet j
                    planets[i].accVector = (Vector3d)(planets[i].accVector.add(acceleration));
                }
            }
        }

        //Update the positions and velocities
        for (int k = 0; k < planets.length; k++)
        {
            Vector3dInterface mul = planets[k].accVector.mul(stepSize);
            planets[k].velVector = (Vector3d)(planets[k].velVector.add(mul));

            mul = planets[k].velVector.mul(stepSize);
            planets[k].vector3d = (Vector3d)(planets[k].vector3d.add(mul));
        }
        return false;
    }
}
