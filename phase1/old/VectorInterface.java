/*
 * @author Pieter Collins, Christof Seiler, Katerina Stankova, Nico Roos, Katharina Schueller
 * @version 0.99.0
 * 
 * This interface serves as the API for students in phase 1.
 */

package titan;

public interface VectorInterface {
    
    public double getX();
    public void setX(double x);
    public double getY();
    public void setY(double y);
    public Vector3dInterface add(VectorInterface other);
    public Vector3dInterface sub(VectorInterface other);
    public Vector3dInterface mul(double scalar);
    
    /**
     * Scalar x vector multiplication, followed by an addition
     * 
    * @param scalar the double used in the multiplication step
    * @param other  the vector used in the multiplication step
    * @return the result of the multiplication step added to this vector,
    * for example:
    * 
    *       Vector3d a = Vector();
    *       double h = 2;
    *       Vector3d b = Vector();
    *       ahb = a.addMul(h, b);
    *       
    * ahb should now contain the result of this mathematical operation:
    *       a+h*b
    */
    public VectorInterface addMul(double scalar, VectorInterface other);
    
    /**
    * @return the Euclidean norm of a vector
    */
    public double norm();
    
    /**
     * @return the Euclidean distance between two vectors
     */
    public double dist(VectorInterface other);
    
    /**
    * @return A string in this format: 
    * Vector3d(-1.0, 2, -3.0) should print out (-1.0,2.0,-3.0)
    */
    public String toString();
    
}
