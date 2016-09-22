
void setup() {
	size(500, 500);
	background(50);

	stroke(250);
	noFill();

	float reso = 30;
	float interval = width/reso ; 
	float x,y,angle,t =0;
	beginShape();
	curveTightness(1);
	for (int i = 1; i < reso; ++i) {
			x = i * interval ;
			y = width/2 ;

			angle = radians(6.24*random(1,60));
			angle += noise(t);
			y += 150*sin(-angle) ; 
			stroke(25);
			strokeWeight(6);
			point(x, y);
			//X and Y axis
			strokeWeight(3);
			point(x, width/2);
			point(width/10, 10*i);

			stroke(250);
			strokeWeight(0.5);
			curveVertex(x, y);


			t += 16;
	}
	endShape();
}

