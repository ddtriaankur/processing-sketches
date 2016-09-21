
PVector target;
float theta,r, radius;

void setup() {
	size(600, 600);
	background(50);
	target= new PVector(0,0);
	// frameRate(30);
	smooth();
	radius = 100;
	// theta = 0.9;
}

void draw() {
	r = radius * cos(theta*18);
	translate(width/2, height/2);

	stroke(250);
	strokeWeight(9);
	target.x = r* cos(theta);
	target.y = r* sin(theta*4);
	point(target.x, target.y);
	
	theta += 0.021725;
	// radius += 0.03;
}

void mousePressed(){
	background(50);
	// radius = radius * random(1,2);
	// noLoop();
}