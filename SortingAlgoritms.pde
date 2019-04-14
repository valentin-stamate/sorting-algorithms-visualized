int[] vector;
int line_w = 4;//this is the line width
int v_size = 0;

void setup(){
  size(600,400);
  background(20);
  v_size = width/line_w;
  vector = new int[v_size];
  for(int i = 0; i < v_size; i++){
   vector[i] = (int)(random(height-30)); 
  }
}

void draw(){
  for(int i = 0; i < v_size; i++){
    stroke(255);
    strokeWeight(line_w);
    line(i*line_w, height, i*line_w, height - vector[i]);
  }
}
