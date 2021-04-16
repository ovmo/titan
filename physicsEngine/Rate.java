import titan.RateInterface;

public class Rate implements RateInterface {

    //storing acc values for all objects
    Vector3d[] rate;

    public Rate(){
        rate = new Vector3d[10];
    }

    public void add(int i, Vector3d other){
        rate[i].add(other);
    }
    public Vector3d get(int i){
        return rate[i];
    }

}
