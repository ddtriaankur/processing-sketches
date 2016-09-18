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

public class proto extends PApplet {



// size(400,400);
// background(0);
// stroke(255);
// line(10,10, width/2,height/2);

// void mousePressed(){
// 	background(#FF0000);
// }

// saveFrame("filename-####");

/*
size(400, 200, P2D)
The P2D renderer uses OpenGL for faster rendering of 2d Graphics

loadImage() and loadStrings() functions each to find a file inside a folder named data

URL.openStream()

loadStrings() array of string object
	String[] lines = loadString("something.txt")
loadImage() reads an image into a PImage object
	PImage image = loadImage("picture.jpg")

Other libraries provide features such as reading images from a camera, sending and receiving MIDI and OSC commands, sophisticated 3D camera control and access to MySQL databases.


*/


// void setup() {
//   size(600, 600);
//   strokeWeight(8);
// }

// void draw() {

//   background(#cccccc);
// if(mouseButton == RIGHT){
//   background(#EE0000);
// }
// else if(mouseButton == LEFT){
//   background(#00EE00);
// }
//   line(mouseX, mouseY, pmouseX, pmouseY);
// }

// void setup() {
//   
//   stroke(0);
// }

// void draw() {
//   if (keyPressed == true) {
//     int x = key - 32;
//     line(x, 0, x, height);
//   }
// }

// float alpha;

// void setup() {
// 	size(400, 400);

// }

// void draw() {
// 	// background(#cccccc);
// 	background(0x112203);

// 	PVector mouse = new PVector(mouseX, mouseY);  
// 	PVector point = new PVector(width/2, height/2);
// 	float dist = PVector.dist(mouse, point);
// 	alpha = map(dist,0,200,50,255);
// 	stroke(#CC0000, alpha);
// 	strokeWeight(1);
// 	line(width/2, height/2, mouseX, mouseY);
	
// 	strokeWeight(110);
// 	point(mouse.x, mouse.y);

// }

// PGraphics tile;

// void setup() {
//   size(700, 100);
//   tile = createGraphics(50, 50);
//   background(0);
// }

// void draw() {
//   runTile();
//   for (int y = 0; y < height; y += tile.height) {
//     for (int x = 0; x < width; x += tile.width) {
//       image(tile, x, y);
//       }
//    }
// }

// void runTile() {
//   float x = random(20, tile.width-20);
//   float y = random(20, tile.height-20);
//   tile.beginDraw();
//   tile.noStroke();
//   tile.fill(0, 20);
//   tile.rect(0, 0, tile.width, tile.height);
//   tile.fill(255);
//   tile.ellipse(x, y, 10, 10);
//   tile.endDraw();
// }

// int[] y;

// void setup() {
//   size(100, 100);
//   y = new int[width];
// }

// void draw() {
//   background(204); // Read the array from the end to the
//   // beginning to avoid overwriting the data
//   for (int i = y.length-1; i > 0; i--) {
//     y[i] = y[i-1];
//   }
//   // Add new values to the beginning
//   y[0] = mouseY;
//   // Display each pair of values as a line
//   for (int i = 1; i < y.length; i++) {
//     line(i, y[i], i-1, y[i-1]);
//   }
// }

int num = 50;
int[] x = new int[num];
int[] y = new int[num];
int indexPosition = 0;

public void setup() {
  size(100, 100);
  noStroke();
  fill(255, 102);
}

public void draw() {
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
}
  public void settings() {  size(100, 100); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "proto" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
