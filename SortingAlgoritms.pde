int[] vector;
int line_w = 4;//this is the line width
int v_size = 0;
int sector;

void setup(){
  size(600,400);
  background(20);
  v_size = width / (line_w + 2);
  sector = line_w + 2;
  vector = new int[v_size];
  for(int i = 0; i < v_size; i++){
   vector[i] = (int)(random(height-30)); 
  }
}

void draw(){
  for(int i = 0; i < v_size; i++){
    stroke(255);
    strokeWeight(line_w);
    //all the math behind is having a space between every line
    line(i*sector + line_w/2, height, i*sector + line_w/2, height - vector[i]);
  }
}
