package PhysicsEngine;

import PhysicsEngine.titan.Vector3dInterface;

/**
* This class implements the ideas of Vector3dInterface and 
* adapts it so that we can use it for the titan project
*/
public class Vector3d implements Vector3dInterface {
    // instance Vars
    double x;
    double y;
    double z;

    public Vector3d(){
    }
    /** 
    Creating the Vector
    @param x Xcoordinate of the vecotr
    @param y Ycoordinate
    @param z Zcoordinate
    */
    public Vector3d(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
    @return the Xcoordinate
    */
    @Override
    public double getX() {
        return x;
    }

    /**
    @param x update the Xcoordinate
    */
    @Override
    public void setX(double x) {
        this.x = x;
    }

    /**
    @return the Ycoordinate
    */
    @Override
    public double getY() {
        return y;
    }

    /**
    @param y update the Xcoordinate
    */
    @Override
    public void setY(double y) {
        this.y = y;
    }

    /**
    @return the Zcoordinate
    */
    @Override
    public double getZ() {
        return z;
    }

    /**
    @param z update the Xcoordinate
    */
    @Override
    public void setZ(double z) {
        this.z = z;
    }

    /**
    Adding one Vector to another - to increase the Acceleration for example
    @param other -> the one to be added on top
    @return the sum of both vetors (otehr and This)
    */
    @Override
    public Vector3dInterface add(Vector3dInterface other) {
        Vector3d sum = new Vector3d();
        sum.setX(this.x + other.getX());
        sum.setY(this.y + other.getY());
        sum.setZ(this.z + other.getZ());
        return sum;
    }
    
    /**
    Substractiong one Vector from another
    @param other -> the one to be taken off
    @return the result of substraction of both vetors (otehr and This)
    */
    @Override
    public Vector3dInterface sub(Vector3dInterface other) {
        Vector3d sum = new Vector3d();
        sum.setX(this.x - other.getX());
        sum.setY(this.y - other.getY());
        sum.setZ(this.z - other.getZ());
        return sum;
    }
    
    /**
    multiplying one Vector with another
    @param scalar -> the one to be multiplied by
    @return the sum of both vetors (otehr and This)
    */
    @Override
    public Vector3dInterface mul(double scalar) {
        Vector3d product = new Vector3d();
        product.setX(this.x * scalar);
        product.setY(this.y * scalar);
        product.setZ(this.z * scalar);
        return product;
    }
    
    /**
    dividing one Vector by another
    @param scalar -> the one to be divided by
    @return the sum of both vectors (other and this)
    */
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

    //Euclidean form of the vector
    /**
    eucledian form of the vector
    @return the euclidean form (as double)
    */
    @Override
    public double norm() {
        return Math.sqrt((Math.pow((this.x - 0), 2) + Math.pow((this.y - 0), 2) + Math.pow((this.z - 0),2)));
    }

    //Euclidean Distance of the 2 objects
    /**
    distance of the two vectors
    @param other -> the other vector
    @return the euclidean distance between this and other
    */
    @Override
    public double dist(Vector3dInterface other) {
        return Math.sqrt((Math.pow((this.x - other.getX()), 2) + Math.pow((this.y - other.getY()), 2) + Math.pow(this.z - other.getZ(),2)));
    }

    public Vector3d crossProduct(Vector3d other){
        Vector3d crossProduct = new Vector3d();
        crossProduct.setX(this.y * other.z - this.z * other.x);
        crossProduct.setY(this.z * other.x - this.x * other.y);
        crossProduct.setZ(this.x * other.y - this.y * other.x);
        return crossProduct;
    }
    
    /**
    a string representation of the Vector
    @return the String representation of the vecotr
    */
    @Override
    public String toString()
    {
        return "Vector (" + x + ", " + y + ", " + z + ") ";
    }
}
