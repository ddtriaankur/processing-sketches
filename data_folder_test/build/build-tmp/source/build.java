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
  public void setup() {

String[] lines = loadStrings ("https://raw.githubusercontent.com/ddtriaankur/processing-sketches/master/notes.txt");
for (int i = 0; i < lines.length; ++i) {
println(lines [i]);
}

// https://raw.githubusercontent.com/ddtriaankur/processing-sketches/master/notes.txt
    noLoop();
  }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
