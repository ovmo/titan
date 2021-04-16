import titan.ODEFunctionInterface;
import titan.RateInterface;
import titan.StateInterface;
import titan.Vector3dInterface;

public class ODEFunction implements ODEFunctionInterface{

    public static boolean DEBUG = true;
    private static final double G = 6.6743015e-11;  //Gravitational constant

    public static double stepsize = 1; //FOR NOW


    @Override
    public RateInterface call(double t, StateInterface y) {

        //return rate of change that is acceleration
        //apply Newton's Law

        //calculate update of the whole system, but only return update for the probe?
        //print updates of the whole system here?

        //reset the acceleration of all objects to 0
        Planet.accReset();
        // iterate over all objects
        for(int i = 0; i < Planet.planets.length; i++) {
            //all other objects
            for(int j = 0; j < Planet.planets.length; j++) {
                // if i planet and j planet are not the same
                if(i != j) {
                    // calculate acceleration from the attraction of two objects
                    Vector3dInterface acceleration = solve(Planet.planets[i], Planet.planets[j]);
                    //Add the calculated acceleration to acceleration of planet i
                    Planet.planets[i].accVector = (Vector3dInterface)(Planet.planets[i].accVector.add(acceleration));
                }
            }
        }

        return null;
    }

    /**
     * calculating acceleration of an object using Newton's Law of Gravitation:
     *
     * F = Gm(i)m(j)*(pos(i)-pos(j)/|pos(i)-pos(j)|^3
     * because
     * m(i)a(i) = F(i)
     * we can eliminate m(i), so that
     * a(i) = Gm(j)*(pos(i)-pos(j)/|pos(i)-pos(j)|^3
     *
     * @param i first object
     * @param j second object
     *
     * @return acceleration vector acc of object i
     */
    public static Vector3dInterface solve(Planet i, Planet j) {
        if(DEBUG) {
            System.out.println("object1: " + i.name + ", object2: " + j.name);
        }

        Vector3dInterface acc = new Vector3d(0,0,0);
        acc = (((j.posVector.sub(i.posVector)).mul(1/(Math.pow(i.posVector.dist(j.posVector), 3))))).mul(G * j.mass);
        return acc;
    }

    public void update(){
        for(int i = 0; i < Planet.planets.length; i++){
            //update velocity
            Planet.planets[i].velVector = Planet.planets[i].velVector.addMul(stepsize, Planet.planets[i].accVector);
            //update position
            Planet.planets[i].posVector = Planet.planets[i].posVector.addMul(stepsize, Planet.planets[i].velVector);

            //adding this to orbit (for visualization purposes)
            Planet.planets[i].orbit.add(Planet.planets[i].posVector);

        }
    }
}
