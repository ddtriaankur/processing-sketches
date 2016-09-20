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

public class mapping extends PApplet {

// http://benfry.com/writing/map/random.tsv
//MAX_FLOAT and MIN_FLOAT

PImage mapImage;
Table locationTable;
int rowCount;

Table dataTable;
float dataMin = MAX_FLOAT;
float dataMax = MIN_FLOAT;

public void setup() {
	
	//loading from data folder
		// mapImage = loadImage("map.png");
		// locationTable = new Table("locations.tsv");

	// loading from web
	mapImage = loadImage("http://benfry.com/writing/map/map.png");
	locationTable = new Table("http://benfry.com/writing/map/locations.tsv");

	rowCount = locationTable.getRowCount();

	//Read the data table
	dataTable = new Table("http://benfry.com/writing/map/random.tsv");
	findRange();

	background(250);
	image(mapImage,0,0);

	strokeWeight(7);
	stroke(250,0,12);

	for (int row = 0; row < rowCount; row++) {
		float x = locationTable.getFloat(row, 1);
		float y = locationTable.getFloat(row, 2);
		point(x,y);
	}

}

public void findRange(){
	for (int i = 0; i < rowCount; i++) {
		float value = dataTable.getFloat(i, 1);
		if(value > dataMax){
			dataMax = value;
		}
		if(value < dataMin){
			dataMin = value;
		}
	}

}

class Table {
  String[][] data;
  int rowCount;
  
  
  Table() {
    data = new String[10][10];
  }

  
  Table(String filename) {
    String[] rows = loadStrings(filename);
    data = new String[rows.length][];
    
    for (int i = 0; i < rows.length; i++) {
      if (trim(rows[i]).length() == 0) {
        continue; // skip empty rows
      }
      if (rows[i].startsWith("#")) {
        continue;  // skip comment lines
      }
      
      // split the row on the tabs
      String[] pieces = split(rows[i], TAB);
      // copy to the table array
      data[rowCount] = pieces;
      rowCount++;
      
      // this could be done in one fell swoop via:
      //data[rowCount++] = split(rows[i], TAB);
    }
    // resize the 'data' array as necessary
    data = (String[][]) subset(data, 0, rowCount);
  }


  public int getRowCount() {
    return rowCount;
  }
  
  
  // find a row by its name, returns -1 if no row found
  public int getRowIndex(String name) {
    for (int i = 0; i < rowCount; i++) {
      if (data[i][0].equals(name)) {
        return i;
      }
    }
    println("No row named '" + name + "' was found");
    return -1;
  }
  
  
  public String getRowName(int row) {
    return getString(row, 0);
  }


  public String getString(int rowIndex, int column) {
    return data[rowIndex][column];
  }

  
  public String getString(String rowName, int column) {
    return getString(getRowIndex(rowName), column);
  }

  
  public int getInt(String rowName, int column) {
    return parseInt(getString(rowName, column));
  }

  
  public int getInt(int rowIndex, int column) {
    return parseInt(getString(rowIndex, column));
  }

  
  public float getFloat(String rowName, int column) {
    return parseFloat(getString(rowName, column));
  }

  
  public float getFloat(int rowIndex, int column) {
    return parseFloat(getString(rowIndex, column));
  }
  
  
  public void setRowName(int row, String what) {
    data[row][0] = what;
  }


  public void setString(int rowIndex, int column, String what) {
    data[rowIndex][column] = what;
  }

  
  public void setString(String rowName, int column, String what) {
    int rowIndex = getRowIndex(rowName);
    data[rowIndex][column] = what;
  }

  
  public void setInt(int rowIndex, int column, int what) {
    data[rowIndex][column] = str(what);
  }

  
  public void setInt(String rowName, int column, int what) {
    int rowIndex = getRowIndex(rowName);
    data[rowIndex][column] = str(what);
  }

  
  public void setFloat(int rowIndex, int column, float what) {
    data[rowIndex][column] = str(what);
  }


  public void setFloat(String rowName, int column, float what) {
    int rowIndex = getRowIndex(rowName);
    data[rowIndex][column] = str(what);
  }
  
  
  // Write this table as a TSV file
  public void write(PrintWriter writer) {
    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < data[i].length; j++) {
        if (j != 0) {
          writer.print(TAB);
        }
        if (data[i][j] != null) {
          writer.print(data[i][j]);
        }
      }
      writer.println();
    }
    writer.flush();
  }
}
  public void settings() { 	size(640, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "mapping" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
