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

Spot[] spots; // Declare array
public void setup() {
  

  int numSpots = 140;                  // Number of objects
  int dia = width/numSpots;           // Calculate diameter

  spots = new Spot[numSpots];         // Create array
  for (int i = 0; i < spots.length; i++) {
    float x = dia/2 + i*dia;
    float rate = random(0.1f, 2.0f);
    // Create each object
    spots[i] = new Spot(x, 50, dia, rate);
  }
  noStroke();
}//

public void draw() {
  if(record){
    beginRecord(PDF, "filename-####.pdf");
  }
  // background(0);

  // fill(0, 12);
  fill(0,5);
  rect(0, 0, width, height);

  // fill(255);
  stroke(255);
  for (int i=0; i < spots.length; i++) {
    spots[i].move(); // Move each object
    spots[i].display(); // Display each object
  }

  if(record){
    endRecord();
    record = false;
  }

}

public void mousePressed(){
  record = true;
}
class Spot {
  float x, y;         // X-coordinate, y-coordinate
  float diameter;     // Diameter of the circle
  float speed;        // Distance moved each frame
  int direction = 1;  // Direction of motion (1 is down, -1 is up)
  
  // Constructor
  Spot(float xpos, float ypos, float dia, float sp) {
    x = xpos;
    y = ypos;
    diameter = dia;
    speed = sp;
  }
    
  public void move() {
    y += (speed * direction); 
    if ((y > (height - diameter/2)) || (y < diameter/2)) { 
      direction *= -1; 
    } 
  }
  
  public void display() {
    point(x, y);
    // ellipse(x, y, diameter, diameter);
  }
}
  public void settings() {  size(700, 100); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
