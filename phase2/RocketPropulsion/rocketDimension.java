package RocketPropulsion;

public class rocketDimension {

    final static double SHUTTLE_LENGTH= 37.237;
    final static double SHUTTLE_WINGSPAN= 23.79;
    final static double SHUTTLE_WIDTH= 17.86;
    final static int DRY_MASS= 78000;
    final static int LANDER_MASS= 6000;
    final static double EXHAUST_V= 20000;

    /** There are 3 RS-25 rocket engines in total
    @param dimensions for rocket engine nozzle
    */
    final static double THROAT_DIAMETER=
    final static double EXIT_DIAMETER=


    double totalHeight;
    double cone;
    double thrusterHeight;
    double nozzleDiameter;
    double rocketDiameter;
    static double area;
    static double initial_pressure;
    static double total_pressure;
    static double total_temperature;
    static double specific_heat_ratio;
    static double mach;
    static double gas_constant;




    public rocketDimension( double height, double diameter, double ){
        //...ret
    }

    public static double calcMassFlowRate(){
        double first_fraction = (area * total_pressure) / math.sqrt(total_temperature);
        double sqrt_gamma_over_gasConstant = math.sqrt(specific_heat_ratio/gas_constant);
        double final_part = math.pow((specific_heat_ratio +1) /2 ,-1 *((specific_heat_ratio + 1)/(2*(specific_heat_ratio-1))) );
        double answer = first_fraction* sqrt_gamma_over_gasConstant* final_part;
        return answer;
    }

    public static double exit_temperature(){
        return math.pow( 1 + (((specific_heat_ratio - 1)/2)*mach*mach) , -1 ) * total_temperature;
    }

    public static double exit_velocity(){
        return mach * math.sqrt(specific_heat_ratio*gas_constant* exit_temperature());
    }

    public static double exit_pressure(){
        return math.pow(1 + (((specific_heat_ratio - 1)/2)*mach*mach), -1 * (specific_heat_ratio/ (specific_heat_ratio - 1)) ) * total_pressure;
    }

    public static double getExitMach( ){
        double area ratio= calcArea(THROAT_DIAMETER)/ calcArea(EXIT_DIAMETER);
        //calculates the ratio of the nozzle.

    }

    public static double calcArea( double diameter){
        double answer= math.PI* math.pow((diameter/2), 2);
        return answer;
    }

    public static double force(){
        return (calcMassFlowRate() * exit_velocity()) + (exit_pressure() - initial_pressure)*calcArea()
    }












    final static int DRY_MASS= 78000;
    final static int LANDER_MASS= 6000;
    final static double EXHAUST_V= 20000;





}
