
int[] y; 		//array to store the previous mouse positions

void setup() {
	size(512, 512);
	y = new int[width]; 		//declaring the size of the array
}

void draw() {
	background(204);

	for (int i = y.length-1; i > 0; i--) {
		y[i] = y[i-1];
	}
	
	y[0] = mouseY ; //ADD new values to the begining

	for (int i = 1; i < y.length; ++i) {
		line(i, y[i], i-1, y[i-1]);
		// point(i, y[i]);
	}

}