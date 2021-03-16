import titan.Vector3dInterface;

/**
 * class implementing Newton's Law of Gravitational Force
 *
*/

public class Newton {

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

        r = i.vector3d.dist(j.vector3d);
        rCube = Math.pow(r, 3);

        Vector3dInterface F = ((i.vector3d.sub(j.vector3d).mul(1/rCube))).mul(G * i.mass * j.mass);

        return F;
    }

}
