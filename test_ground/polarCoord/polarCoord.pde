float radius = 50 ,angle = 0;
PVector target = new PVector (0,0);
void setup(){
	size(600,600);
	frameRate(30);
	radius = width/2;
	// size(600);
}

void draw(){
	smooth();
	// background(145, 100);
	translate(width/2, height/2);
	target.x = radius*cos(radians(angle)) ;
	target.y = radius*sin(radians(angle));
	stroke(50, 20);
	line(0,0, target.x, target.y);

	println(angle + "sin :" + sin(radians(angle)) );
	angle += 90/16;
	if (angle > 360){
		angle = 0;
	}

}
