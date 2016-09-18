import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class build extends PApplet {


int[] y; 		//array to store the previous mouse positions

public void setup() {
	
	y = new int[width]; 		//declaring the size of the array
}

public void draw() {
	background(204);

	for (int i = y.length-1; i > 0; i--) {
		y[i] = y[i-1];
	}
	
	y[0] = mouseY ; //ADD new values to the begining

	for (int i = 1; i < y.length; ++i) {
		line(i, y[i], i-1, y[i-1]);
		// point(i, y[i]);
	}

}
  public void settings() { 	size(512, 512); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
