
package RocketPropulsion;
import PhysicsEngine.PlanetStart;
import PhysicsEngine.SpaceCraft;

import java.lang.Math;

public class ThrustEquation {

    //find the value of pressure
    private double pressure;
    private double velocity;
    //Assuming the probe itself is a sphere
    private final double AREA= (4*Math.PI* Math.pow(SpaceCraft.radius,2));

    //Initial takeoffV
    private double machNumber= 50000/320;


    public static double calcMassFlowRate( ){
        double massFlowRate;
        //must find temperature variable first
        double temperature;
        double calcATimesP= AREA * pressure;
        double calcTempDenom= Math.sqrt(temperature);

    }

    public static double calcSpecificHeatRatio( ){
        final double R= 8.1345;
        final double n= 6.02* Math.pow(10, 23);





    }










}


