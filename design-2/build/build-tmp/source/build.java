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


float yoff = 0;
float t =0;
PVector center, location;

public void setup() {
	
	background(10);	

	center = new PVector(width/2, height/2);
}

public void draw() {
	// clear();
	location = new PVector(width/2, height/2 + yoff);
	float dist = PVector.dist(center, location);
	dist = map(dist, 0, height/2, 50,255);
	stroke(200, dist);
	strokeWeight(16);
	point(location.x, location.y);

	t += 1;
	yoff = noise(t) ;
	yoff = map(yoff, 0,1, -height/2 , height/2);


}

public void mousePressed(){
		background(10);	

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
