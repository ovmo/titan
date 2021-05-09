package RocketPropulsion;

import PhysicsEngine.SpaceCraft;

public class MachNumber {
    double objectSpeed= SpaceCraft.takeoffV;
    final static double SPEED_OF_SOUND= 330.0;


    public static double calcMachNumber(double objectSpeed,double sound ){
        this.objectSpeed= objectSpeed;
        sound= SPEED_OF_SOUND;

        double answer= objectSpeed/ SPEED_OF_SOUND;

        return answer;
    }
}
