import titan.Vector3dInterface;

public class Vector3d implements Vector3dInterface {

    double x;
    double y;
    double z;

    public Vector3d(){
    }

    public Vector3d(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public Vector3dInterface add(Vector3dInterface other) {
        Vector3d sum = new Vector3d();
        sum.setX(this.x + other.getX());
        sum.setY(this.y + other.getY());
        sum.setZ(this.z + other.getZ());
        return sum;
    }

    @Override
    public Vector3dInterface sub(Vector3dInterface other) {
        Vector3d sum = new Vector3d();
        sum.setX(this.x - other.getX());
        sum.setY(this.y - other.getY());
        sum.setZ(this.z - other.getZ());
        return sum;
    }

    @Override
    public Vector3dInterface mul(double scalar) {
        Vector3d product = new Vector3d();
        product.setX(this.x * scalar);
        product.setY(this.y * scalar);
        product.setZ(this.z * scalar);
        return product;
    }

    public Vector3dInterface div(double scalar) {
        Vector3d product = new Vector3d();
        product.setX(this.x * (1/scalar));
        product.setY(this.y * (1/scalar));
        product.setZ(this.z *(1/scalar));
        return product;
    }

    @Override
    public Vector3dInterface addMul(double scalar, Vector3dInterface other) {
        return null;
    }

    @Override
    public double norm() {
        double norm = Math.sqrt((Math.pow((this.x - 0), 2) + Math.pow((this.y - 0), 2) + Math.pow((this.z - 0),2)));
        return norm;
    }

    @Override
    public double dist(Vector3dInterface other) {
        double d = Math.sqrt((Math.pow((this.x - other.getX()), 2) + Math.pow((this.y - other.getY()), 2) + Math.pow(this.z - other.getZ(),2)));
        return d;
    }

    public String toString()
    {
        return "Vector (" + x + ", " + y + ", " + z + ") ";
    }
}
