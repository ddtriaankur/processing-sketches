import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.pdf.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class build extends PApplet {



float n, t, res = 6 ;

public void setup() {
	
		beginRecord(PDF, "fn-##.pdf");

	n = width/res;

background(0);
	float rad, g,b;	
	for (int i = 1; i < n; i++) {
		for (int j = 1; j < n; j++) {
			rad = noise(t)* res;
			b = noise(t)* 255;
			g = noise(t)* 255;
			dc(i*res,j*res, rad,g,b);	
			t+=20;
		}
	}

		endRecord();
}//


public void dc(float x , float y, float size, float g, float b){
	fill(random(0, 255), g, b);
	// stroke(200);
	noStroke();
	// strokeWeight();
	ellipse(x,y,size,size);
}//


  public void settings() { 	size(600, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
