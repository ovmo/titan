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
        Vector3dInterface acceleration = new Vector3d(0,0,0);
        if (/*j.name.equalsIgnoreCase("earth") &&*/ i != j)
        {
            // System.out.println(i.vector3d.dist(j.vector3d));
            // System.out.println("j" + j.vector3d.toString());
            // System.out.println("i" + i.vector3d.toString());
            // System.out.println("J-I" + (j.vector3d.sub(i.vector3d).toString()));
            // System.out.println("J_I / r3" + (j.vector3d.sub(i.vector3d)).mul(1/rCube).toString()); 
            // System.out.println("G * j.mass" + G * j.mass);
            acceleration = (((j.vector3d.sub(i.vector3d)).mul(1/rCube))).mul(G * j.mass);
            // System.out.println(acceleration);
        }
        else if (i == j)
        {
            System.out.println("E-E");
        }

        return acceleration;
    }

    public static boolean newtonLoop (Planet[] planets, int stepSize)
    {
        // STEPSIZE IS IN SECONDS!!!!!!


        // Reset the acceleration to 0;
        // planets[0].accReset();
        Planet.accReset();

        for(int i = 0; i < planets.length; i++){
            for(int j = 0; j< planets.length; j++){
                if(i != j){
                    //j.Acc + (Newton.solve(i, j)*j.mass; //this will return a 3d vector F
                    Vector3dInterface acceleration = Newton.solve(planets[i], planets[j]);
                    //add F to acceleration of planet j
                    // System.out.println("TO BE ADDED TO " + planets[i].name + " " + acceleration);
                    planets[i].accVector = (Vector3d)(planets[i].accVector.add(acceleration));
                    // System.out.println(planets[i].name + " " + planets[i].accVector.toString());
                }
            }
        }
        // update the Positon and velocities
        for (int k = 0; k < planets.length; k++)
        {
            // System.out.println(planets[k].name + ": " + planets[k].accVector);
            Vector3dInterface mul = planets[k].velVector.mul(stepSize);
            // System.out.println("Vel * step " + ((Vector3d) (mul)).toString());
            planets[k].vector3d = (Vector3d)(planets[k].vector3d.add(mul));
            // System.out.println(planets[k].name + " pos " + planets[k].vector3d.toString());
            mul = planets[k].accVector.mul(stepSize);
            // System.out.println("Acc * Step" + ((Vector3d) (mul)).toString());
            planets[k].velVector = (Vector3d)(planets[k].velVector.add(mul));
            // System.out.println(planets[k].velVector.toString());
        }

        // if (planets[planets.length - 1].radius + planets[8].radius >= planets[8].vector3d.dist(planets[planets.length-1].vector3d))
        // {
        //     // End the process => 
        //     return true;
        //     // made it to target.
        // }
        // else 
        // {
        //     return false;
        // }

        // System.out.println(planets[0].vector3d.dist(planets[3].vector3d));
        // System.out.println("j" + planets[3].vector3d.toString());
        // System.out.println("i" + planets[0].vector3d.toString());
        // System.out.println("J-I" + (planets[3].vector3d.sub(planets[0].vector3d).toString()));
        // System.out.println("J_I / r3" + (planets[3].vector3d.sub(planets[0].vector3d)).mul(1/rCube).toString()); 
        // System.out.println("G * j.mass" + G * planets[3].mass);
        return false;
    }

}
