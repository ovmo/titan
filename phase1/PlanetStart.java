import java.io.*;
import java.util.*;
/**
* this class creates the solar constelation of the system on 01-04-2020
* to kick start the program and find the best path to titian.
*/
public class PlanetStart
{
	public Planet[] planets;

	/**
	Adding the constalation for the sky.
	*/
	public PlanetStart()
	{
		planets = new Planet()[12];
		Planet sun = new Planet("Sun");
		sun.mass = 1.988500e+30;
		sun.radius = 6957e+05;
		sun.gravity = 274;
		sun.positionX = -6.806783239281648e+08;
		sun.positionY = 1.080005533878725e+09;
		sun.positionZ = 6.564012751690170e+06;
		sun.velocityX = -1.420511669610689e+01;
		sun.velocityY = -4.954714716629277e+00;
		sun.velocityZ = 3.994237625449041e-01;

		planets[1] = sun;

		Planet mercury = new Planet("Mercury");
		mercury.mass = 3.302e+23;
		mercury.radius = 2440e+03;
		mercury.gravity = 3.7;
		mercury.positionX = 6.047855986424127e+06;
		mercury.positionY = -6.801800047868888e+10;
		mercury.positionZ = -5.702742359714534e+09;
		mercury.velocityX = 3.892585189044652e+04; 
		mercury.velocityY = 2.978342247012996e+03;
		mercury.velocityZ = -3.327964151414740e+03;

		planets[2] = mercury;

		Planet venus = new Planet("Venus");
		venus.mass = 4.8685e+24;
		venus.radius = 6051e+03;
		venus.gravity = 8.87;
		venus.positionX = -9.435345478592035e+10;
		venus.positionY = 5.350359551033670e+10;
		venus.positionZ = 6.131453014410347e+09;
		venus.velocityX = -1.726404287724406e+04;
		venus.velocityY = -3.073432518238123e+04;
		venus.velocityX = 5.741783385280979e-04;

		planets[3] = venus;

		Planet earth = new Planet("Earth");
		earth.mass = 5.97219e+24;
		earth.radius = 6371e+3;
		earth.gravity = 9.807;
		earth.positionX = -1.471922101663588e+11;
		earth.positionY = -2.860995816266412e+10;
		earth.positionZ = 8.278183193596080e+06;
		earth.velocityX = 5.427193405797901e+03;
		earth.velocityY = -2.931056622265021e+04;
		earth.velocityZ = 6.575428158157592e-01;

		planets[4] = earth;

		Planet moon = new Planet ("Moon");
		moon.mass = 7.349e+22;
		moon.radius = 1737e+03;
		moon.gravity = 1.62;
		moon.positionX = -3.615638921529161e+10;
		moon.positionY = -2.167633037046744e+11;
		moon.positionZ = -3.687670305939779e+09;
		moon.velocityX = 2.481551975121696e+04;
		moon.velocityY = -1.816368005464070e+03;
		moon.velocityZ = -6.467321619018108e+02;

		planets[5] = moon;

		Planet mars = new Planet ("Mars");
		mars.mass = 6.4171e+23;
		mars.radius = 3389e+03;
		mars.gravity = 3.711;
		mars.positionX = -3.615638921529161e+10;
		mars.positionY = -2.167633037046744e+11;
		mars.positionZ = -3.687670305939779e+09;
		mars.velocityX = 2.481551975121696e+04;
		mars.velocityY = -1.816368005464070e+03;
		mars.velocityZ = -6.467321619018108e+02;

		planets[6] = mars;

		Planet jupiter = new Planet("Jupiter");
		jupiter.mass= 1.89813e+27;
		jupiter.radius = 69911e+03;
		jupiter.gravity = 24.79;
		jupiter.postionX = 1.781303138592153e+11; 
		jupiter.positionY =-7.551118436250277e+11;
		jupiter.positionZ =-8.532838524802327e+08;
		jupiter.velocityX = 1.255852555185220e+04; 
		jupiter.velocityY = 3.622680192790968e+03;
		jupiter.velocityZ =-2.958620380112444e+02;

		planets[7] = jupiter;

		Planet saturn = new Planet("Saturn");
		saturn.mass = 5.6834e+26;
		saturn.radius = 8232e+03;
		saturn.gravity = 10.44;
		saturn.velocityX  = 8.220842186554890e+03;
		saturn.velocityY = 4.052137378979608e+03;
		saturn.velocityZ = -3.976224719266916e+02;
		saturn.positonX = 6.328646641500651e+11;
		saturn.positonY = -1.358172804527507e+12;
		saturn.positonZ = -1.578520137930810e+09;

		planets[8] = saturn;

		Planet titan = new Planet("Titan");
		titan.mass = 1.34553e+23;
		titan.radius = 2575000.5;
		titan.gravity = 1.352;
		titan.velocityX  = 3.056877965721629e+03;
		titan.velocityY = 6.125612956428791e+03;
		titan.velocityZ = -9.523587380845593e+02;
		titan.positonX = 6.332873118527889e+11;
		titan.positonY = -1.357175556995868e+12;
		titan.positonZ = -2.134637041453660e+09;

		planets[9] = titan;

		Planet uranus = new Planet("Uranus");
		uranus.mass = 8.6813e+25;
		uranus.radius = 25362e+03;
		uranus.gravity = 8.87;
		uranus.velocityX  = -4.059468635313243e+03;
		uranus.velocityY = 5.187467354884825e+03;
		uranus.velocityZ = 7.182516236837899e+01;
		uranus.positonX = 2.395195786685187e+12;
		uranus.positonY = 1.744450959214586e+12;
		uranus.positonZ = -2.455116324031639e+10;

		planets[10] = uranus;

		Planet neptune = new Planet("Neptune");
		neptune.mass = 1.02413e+26;
		neptune.radius = 24.622e+03;
		neptune.gravity = 11.15;
		neptune.velocityX  = 1.068410720964204e+03;
		neptune.velocityY = 5.354959501569486e+03;
		neptune.velocityZ = -1.343918199987533e+02;
		neptune.positonX = 4.382692942729203e+12;
		neptune.positonY = -9.093501655486243e+11;
		neptune.positonZ = -8.227728929479486e+10;

		planets[11] = neptune;

		Planet spaceCraft = new Planet ("SpaceCraft");
		spaceCraft.mass = 100;
		spaceCraft.radius = 10;
		spaceCraft.gravity = 1e-10;
		spaceCraft.positionX = -1.471922101663588e+11;
		spaceCraft.positionY = -2.860995816266412e+10;
		spaceCraft.positionZ = 8.278183193596080e+06;
		spaceCraft.velocityX = 5.427193405797901e+03;
		spaceCraft.velocityY = -2.931056622265021e+04;
		spaceCraft.velocityZ = 6.575428158157592e-01;

		planets[12] = spaceCraft;

		return planets;
	}
}







