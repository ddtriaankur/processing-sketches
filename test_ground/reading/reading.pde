
int[] data;

// println(lines);
// println(data);

void setup(){
	String[] lines = loadStrings("notes.txt");
	data = int(split(lines[0], ','));
	size(400,400);
	background(50);

	strokeWeight(10);
	stroke(255);
	for(int i=0; i<data.length; i++){
		point(data[i]*4, height/2);
	}

}
