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

public class curve extends PApplet {


public void setup() {
	
	background(50);

	stroke(250);
	noFill();

	float reso = 30;
	float interval = width/reso ; 
	float x,y,angle,t =0;
	beginShape();
	curveTightness(1);
	for (int i = 1; i < reso; ++i) {
			x = i * interval ;
			y = width/2 ;

			angle = radians(6.24f*random(1,60));
			angle += noise(t);
			y += 150*sin(-angle) ; 
			stroke(25);
			strokeWeight(6);
			point(x, y);
			//X and Y axis
			strokeWeight(3);
			point(x, width/2);
			point(width/10, 10*i);

			stroke(250);
			strokeWeight(0.5f);
			curveVertex(x, y);


			t += 16;
	}
	endShape();
}

  public void settings() { 	size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "curve" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
