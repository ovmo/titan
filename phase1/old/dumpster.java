 // Oscar Physics

	// public int hitOrMiss () 
	// private static String[] solarObjects;
	// private static int masses;
	// private static int velocity;
	// private static int radius;
	// static
	// {
	// solarObjects = {"Sun", "Mercury", "Venus", "Earth", "Luna", "Mars", "Jupiter", "Saturn","Titan", "Uranus", "Neptune", "SpaceCraft"};
	// 	masses = {1989100000000000000000000000000, }

	// 	radius ={4370005600}
	// }

// Pscar PlanetStart
		// LinkedList<Planet> planets = new LinkedList<Planet>;
		// if( args.length < 1 ){
		// 	throw new RuntimeException("Please give the starting Solar State.")

		// }
		// else
		// {
		// 	String inputfile = args[0];

		// 	boolean seen[] = null;


		// 	try{
		// 		FileReader fr = new FileReader(inputfile);
		// 		BufferedReader br = new BufferedReader(fr);

		// 		String record = new String();

  //               //! THe first few lines of the file are allowed to be comments, staring with a // symbol.
  //               //! These comments are only allowed at the top of the file.

  //               //! -----------------------------------------
		// 		while ((record = br.readLine()) != null){
		// 			if( record.startsWith("//") ) continue;
  //                   break; // Saw a line that did not start with a comment -- time to start reading the data in!
  //               }	
  //               String[] records = record.split(" ");
  //               String name = records[0].substring(0, str.length() - 1);
  //               planet = new Planet()
  //               for (int i = 0; )

  //           }
  //           catch (IOException ex){
  //               // catch possible io errors from readLine()
  //           	System.out.println("Error! Problem reading file "+inputfile);
  //           	System.exit(0);
  //           }

// Leo Visual
	/*// //each radius is represented in metres.
	// final double rSUN=695700000.00;
	// final double rMERCURY=2440000.00;
	// final double rVENUS=6051000.84;
	// final double rEARTH=6378000.137;
	// final double rMOON=1737000.53;
	// final double rMARS=3389000.92;
	// final double rJUPITER=69911000.00;
	// final double rSATURN=58232000.00;
	// final double rTITAN=2575000.5;
	// }*/

	// Function old 
		// import titan.FunctionInterface;
		// import titan.Vector3dInterface;

		// public class Function implements FunctionInterface {

		//     @Override
		//     public Vector3dInterface call(double t, Vector3dInterface s) {
		//         return null;
		//     }
		// }

	// newton loop
	// for (int i = 0; i < planets.length; i ++)
        // {
        //     // HERE
        //     for (int j = 1; j + i < planets.length; i++)
        //     {
        //         // HERE
        //         Vector3DInterface acceleration = solve(planets[i], planets[j + i]);
        //         // Need If around this
        //         if (/*Somethign here*/ false)
        //         {
        //             planets[i].accVector = planets[i].accVector.add(acceleration);
        //             planets[i+j].accVector = planets[i+j].accVector.add(acceleration);
        //         }
        //     } 
        // }
        // for (int k = 0; k < planets.length; k++)
        // {
        //     // need to update the position and velocity;
        //     planets[k].vector3d = planets[k].vector3d.add(planets[k].velVector);
        //     // planets[i+j].vector3d = planets[i+j].vector3d.add(planets[i+j].velVector);
        //     planets[k].velVector = planets[k].velVector.add(acceleration);
        //     // planets[i+j].velVector = planets[i+j].velVector.add(acceleration);
        // }