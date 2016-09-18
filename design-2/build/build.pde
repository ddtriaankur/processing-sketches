
float yoff = 0;
float t =0;
PVector center, location;

void setup() {
	size(512, 512);
	background(10);	

	center = new PVector(width/2, height/2);
}

void draw() {
	// clear();
	location = new PVector(width/2, height/2 + yoff);
	float dist = PVector.dist(center, location);
	dist = map(dist, 0, height/2, 50,255);
	stroke(200, dist);
	strokeWeight(16);
	point(location.x, location.y);

	t += 1;
	yoff = noise(t) ;
	yoff = map(yoff, 0,1, -height/2 , height/2);


}

void mousePressed(){
		background(10);	

}