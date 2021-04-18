import titan.RateInterface;
import titan.Vector3dInterface;

/**
 * data structure to store the rate of change (acceleration) for all objects in the system
 * used to update the state of the system
 *
 * @author Leo
 */
public class Rate implements RateInterface {

    public static boolean DEBUG = false;
    //storing acc values for all objects
    Vector3d[] rate = new Vector3d[Planet.planets.length];


    public Rate(){
        for(int i = 0; i < rate.length; i++){
            rate[i] = new Vector3d();
        }
    }

    public void add(int i, Vector3d other){
        if(DEBUG){
            System.out.println("rate - i " + i);
            System.out.println("rate - other " + other.toString());
            System.out.println("rate - before adding " + rate[i].toString());
        }

        rate[i] = (Vector3d) rate[i].add(other);

        if(DEBUG){
            System.out.println("rate - after adding " + rate[i].toString());
        }
    }

    public Vector3d get(int i){
        return rate[i];
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < rate.length; i++){
            str += i + " " + rate[i] + "\n";
        }
        return str;
    }

}
