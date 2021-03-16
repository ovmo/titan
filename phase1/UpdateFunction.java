import titan.Vector3dInterface;

public class UpdateFunction {

    Planet[] planets;
    Newton newton = new Newton();

    public void gravForces(){
        for(int i = 0; i < planets.length; i++){
            for(int j = 0; j < planets.length; j++){
                if(i!=j){
                    //j.Acc + (Newton.solve(i, j)*j.mass; //this will return a 3d vector F
                    Vector3dInterface F = Newton.solve(planets[i], planets[j]);
                    //add F to acceleration of planet j
                    planets[j].accVector.add(F);
                }
            }
        }
        update();
    }

    public void update(){
        for(int i = 0; i < planets.length; i++){
            //update velocity
            //newV = oldV + i.Acc + h
            //update position
            //newPos = oldPos + (oldV + newV) / 2 * h
        }
    }
}
