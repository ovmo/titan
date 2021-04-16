import titan.ODEFunctionInterface;
import titan.RateInterface;
import titan.StateInterface;
import titan.Vector3dInterface;

public class ODEFunction implements ODEFunctionInterface{

    public static boolean DEBUG = true;
    private static final double G = 6.6743015e-11;  //Gravitational constant

    /**
     * calculating acceleration of an object using Newton's Law of Gravitation:
     *
     * F = Gm(i)m(j)*(pos(i)-pos(j)/|pos(i)-pos(j)|^3
     * because
     * m(i)a(i) = F(i)
     * we can eliminate m(i), so that
     * a(i) = Gm(j)*(pos(i)-pos(j)/|pos(i)-pos(j)|^3
     *
     * @param t
     * @param y =  state of the system
     *
     * @return rate of change that is acceleration for each objects
     */

    @Override
    public RateInterface call(double t, StateInterface y) {

        //return rate of change that is acceleration
        //apply Newton's Law

        //new Rate (containing acc for all objects)
        Rate rate = new Rate();

        //iterate over all objects
        for(int i = 0; i < Planet.planets.length; i++) {
            //all other objects
            for (int j = 0; j < Planet.planets.length; j++) {
                //if i planet and j planet are not the same
                if (i != j) {
                    //calculate acceleration from the attraction of two objects
                    Vector3d acc = (((y[j][2].sub(y[i][2])).mul(1 / (Math.pow(y[i][2].dist(y[j][2]), 3))))).mul(G * Planet.planets[j].mass);
                    //add calculated acc to total acceleration of object i
                    rate.add(i, acc);
                }
            }
        }
        return rate;
    }
}
