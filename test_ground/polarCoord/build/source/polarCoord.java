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

public class polarCoord extends PApplet {

float radius = 50 ,angle = 0;
PVector target = new PVector (0,0);
public void setup(){
	
	frameRate(30);
	radius = width/2;
	// size(600);
}

public void draw(){
	smooth();
	// background(145, 100);
	translate(width/2, height/2);
	target.x = radius*cos(radians(angle)) ;
	target.y = radius*sin(radians(angle));
	stroke(50, 20);
	line(0,0, target.x, target.y);

	println(angle + "sin :" + sin(radians(angle)) );
	angle += 90/16;
	if (angle > 360){
		angle = 0;
	}

}
  public void settings() { 	size(600,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "polarCoord" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
