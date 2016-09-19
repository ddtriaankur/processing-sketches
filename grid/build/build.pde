import processing.pdf.*;

float n, t, res = 6 ;

void setup() {
	size(600, 600);
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


void dc(float x , float y, float size, float g, float b){
	fill(random(0, 255), g, b);
	// stroke(200);
	noStroke();
	// strokeWeight();
	ellipse(x,y,size,size);
}//


