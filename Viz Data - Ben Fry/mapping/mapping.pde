// http://benfry.com/writing/map/random.tsv
//MAX_FLOAT and MIN_FLOAT

PImage mapImage;
Table locationTable;
int rowCount;

Table dataTable;
float dataMin = MAX_FLOAT;
float dataMax = MIN_FLOAT;

void setup() {
	size(640, 400);
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

}

void draw(){
	background(250);
	image(mapImage,0,0);

	strokeWeight(7);
	stroke(250,0,12);

	for (int row = 0; row < rowCount; row++) {
		String abbrev = dataTable.getRowName(row);
		float x = locationTable.getFloat(row, 1);
		float y = locationTable.getFloat(row, 2);
		point(x,y);
	}
}

void findRange(){
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

