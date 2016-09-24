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

public class reading extends PApplet {


int[] data;

// println(lines);
// println(data);

public void setup(){
	String[] lines = loadStrings("notes.txt");
	data = PApplet.parseInt(split(lines[0], ','));
	
	background(50);

	strokeWeight(10);
	stroke(255);
	for(int i=0; i<data.length; i++){
		point(data[i]*4, height/2);
	}

}
  public void settings() { 	size(400,400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "reading" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
