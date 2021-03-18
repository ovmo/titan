package PhysicsEngine;

public class SpaceCraft {

    private final double MAX_TAKEOFF = 60000;
    private final double MIN_TAKEOFF = 11.186;
    private final double MIN_REACH = 48000;
    private double mass;            //Mass of the spacecraft
    private double takeoffV;        //Velocity of the spacecraft during the takeoff

    /**
     * Constructor
     * @param massInit initial mass of the spacecraft (15000 kg)
     */
    public SpaceCraft(int massInit) {
        this.mass = massInit;
        takeoffV = 50000;
    }

    public void setMass (double massNew) { mass = massNew; }

    public double getMass () { return mass; }

    public void setTakeOff (double velocity) {
        if (velocity >= MIN_TAKEOFF && velocity <= MAX_TAKEOFF)
        {
            takeoffV = velocity;
        }
        else
        {
            throw new RuntimeException("the TakeOff Velocity does not hold. Please enter a velocity on m/s. ");
        }
    }

    public double getTakeOff () { return takeoffV; }
}