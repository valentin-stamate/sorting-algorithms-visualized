int[] vector;
int line_w = 4;//this is the line width
int v_size = 0;
int sector;
int i = 0, j = 0;
void setup(){
  size(300,200);
  frameRate(30);
  background(20);
  sector = line_w + 2;
  v_size = width / sector; // a sector must be biggre than line width in order to have a space betweel lines
  vector = new int[v_size];
  for(int i = 0; i < v_size; i++){
   vector[i] = (int)(random(height-30)); 
  }
}


void draw(){
  background(20);
  //do the thing "manually"
  if(i<v_size - 1){
    if(vector[i]>vector[j]){
     swap(vector, i, j); 
    }
    j++;
    if(j==v_size){
      i++;
      j = i + 1;
    }
  } else {
   println("Done");
   noLoop();
  }
  
  for(int l = 0; l<v_size; l++){
    stroke(255);
    strokeWeight(line_w);
    //all the math behind is having a space between every line
   line(l*sector + line_w/2, height, l*sector + line_w/2, height - vector[l]);
  }
  
  
}

void BubbleSort(int v[]){
  for(int i = 0; i<v_size-1; i++){
   for(int j = i+1; j<v_size; j++){
    if(v[j]<v[i]){
      stroke(255);
      strokeWeight(line_w);
      line(i*sector + line_w/2, height, i*sector + line_w/2, height - vector[i]);
      swap(v, i, j);
     } else {
      stroke(255);
      strokeWeight(line_w);
      line(i*sector + line_w/2, height, i*sector + line_w/2, height - vector[i]); 
     }
    }
  }
  return;
}








void swap(int v[], int i, int j){
 int aux = v[i];
 v[i] = v[j];
 v[j] = aux;
}
//stroke(255);
//strokeWeight(line_w);
//all the math behind is having a space between every line
// line(i*sector + line_w/2, height, i*sector + line_w/2, height - vector[i]);
