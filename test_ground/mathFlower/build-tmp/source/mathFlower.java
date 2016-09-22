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

public class mathFlower extends PApplet {


PVector target;
float theta,r, radius;

public void setup() {
	
	background(50);
	target= new PVector(0,0);
	// frameRate(30);
	
	radius = 100;
	// theta = 0.9;
}

public void draw() {
	r = radius * cos(theta*18);
	translate(width/2, height/2);

	stroke(250);
	strokeWeight(9);
	target.x = r* cos(theta);
	target.y = r* sin(theta*4);
	point(target.x, target.y);
	
	theta += 0.021725f;
	// radius += 0.03;
}

public void mousePressed(){
	background(50);
	// radius = radius * random(1,2);
	// noLoop();
}
  public void settings() { 	size(600, 600); 	smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "mathFlower" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
