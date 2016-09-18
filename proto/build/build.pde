float r = 10.0,t, x=0,y=0;


void setup() {
	size(512, 512);
	x = width/2;
	y = height/2;
}

void draw() {
	background(75);
	r= map(noise(t),0,1,12,height);
	t += 0.02;
	
	strokeWeight(r);
	point(x,y);
}