import titan.Vector3dInterface;

/**
 * class implementing Newton's Law of Gravitational Force
 *
*/

public class Newton {

    private static final boolean DEBUG = false;
    private static final double G = 6.6743015e-11; //gravitational constant
    private static double r; //Euclidian distance between i and j
    private static double rCube; //distance cubed

    /**
     * implementing NLG as F = Gm(i)m(j)*(pos(i)-pos(j)/|pos(i)-pos(j)|^3
     *
     * @param i first planet
     * @param j second planet
     *
     * @return F gravitational force acting on i and j
     */
    public static Vector3dInterface solve(Planet i, Planet j){
        if(DEBUG)
        {
            System.out.println("Planet1: " + i.name + ", Planet2: " + j.name);
        }
        r = i.vector3d.dist(j.vector3d);
        rCube = Math.pow(r, 3);

        Vector3dInterface F = ((i.vector3d.sub(j.vector3d).mul(1/rCube))).mul(G * i.mass);

        return F;
    }

    public static boolean newtonLoop (Planet[] planets, int stepSize)
    {
        // STEPSIZE IS IN SECONDS!!!!!!


        // Reset the acceleration to 0;
            // planets[0].accReset();

        for(int i = 0; i < planets.length; i++){
            for(int j = 0; j < planets.length; j++){
                if(i != j){
                    //j.Acc + (Newton.solve(i, j)*j.mass; //this will return a 3d vector F
                    Vector3dInterface F = Newton.solve(planets[i], planets[j]);
                    //add F to acceleration of planet j
                    planets[i].accVector.add(F);
                }
            }
        }
        // update the Positon and velocities
        for (int k = 0; k < planets.length; k++)
        {
            planets[k].vector3d = (Vector3d)(planets[k].vector3d.add(planets[k].velVector.mul(stepSize)));
            planets[k].velVector = (Vector3d)(planets[k].velVector.add(planets[k].accVector.mul(stepSize)));
        }

        if (planets[planets.length - 1].radius + planets[8].radius >= planets[8].vector3d.dist(planets[planets.length-1].vector3d))
        {
            // End the process => 
            return true;
            // made it to target.
        }
        else 
        {
            return false;
        }
    }

}
