'use strict';
let vector = new Array();
let line_w = 4; //this is the line width
let v_size = 0;
let sector;
let i = 0, j = 0;

function setup(){
    createCanvas(800,400);
    background(20);
    sector = line_w + 2;
    v_size = width / sector; // a sector must be bigger than the line width in order to have a space betweel lines
    vector = [v_size];
    for(let i = 0; i < v_size; i++){ // assign random values
      vector[i] = parseInt( random( height-30 ) );
      console.log(vector[i]);
    }

}

function draw(){
    background(20);
  //do the thing "manually"
  let a = i, b = j,min = vector[a];//finds the minimum number and after swaps it
  if(i<v_size - 1){

     for(let o = a + 1; o<v_size; o++){
       if(min>vector[o]){
         min = vector[o];
         b = o;
       }
     }
       if(b!=j) // this means that it finds ome minumum , ele v[i] is the minumum and doesn't need to change
        swap(vector, a, b); 
     i++;
     j = i;
    
  } else {
      console.log("Vector Size: " + v_size);
      noLoop();
  }
  
  for(let l = 0; l < v_size; l++){
    //all the math behind is having a space between every line
    
    if(l == a){ // highlight the selected one , hope is working
    
      stroke(244,66,66);//red
      strokeWeight(line_w);
      line(l*sector + line_w/2, height, l*sector + line_w/2, height - vector[l]);
      
    } else if(l == b){ // highlight the minumim , hope is working
    
      stroke(66,244,98);//green
      strokeWeight(line_w);
      line(l*sector + line_w/2, height, l*sector + line_w/2, height - vector[l]);
      
    } else {
      
      stroke(255);
      strokeWeight(line_w);
      line(l*sector + line_w/2, height, l*sector + line_w/2, height - vector[l]);
      
    }
  }
}

function swap(v, i, j){
    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;
}