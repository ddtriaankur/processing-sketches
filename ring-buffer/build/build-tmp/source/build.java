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


boolean record = false;

int num = 50;
int[] x = new int[num];
int[] y = new int[num];
int indexPosition = 0;

public void setup() {
  
  
}

public void draw() {
	if(record){
		beginRecord(PDF, "fn-##.pdf");
	}
	noStroke();
  fill(255, 102);
  background(0);
  x[indexPosition] = mouseX;
  y[indexPosition] = mouseY;
  // Cycle between 0 and the number of elements
  indexPosition = (indexPosition + 1) % num;
  for (int i = 0; i < num; i++) {
    // Set the array position to read
    int pos = (indexPosition + i) % num;
    float radius = (num-i) / 2.0f;
    ellipse(x[pos], y[pos], radius, radius);
  }

  if(record){
  	endRecord();
  	record = false;
  }
}

public void mousePressed(){
	record = true;
}

  public void settings() {  size(100, 100); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
