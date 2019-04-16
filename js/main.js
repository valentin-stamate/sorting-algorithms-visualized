'use strict';
let v = new Array();
// 0 - normal , 1 - pivot, 2 - line to switch, 3 - where it goes?
let line_w = 4; //line width
let v_size, sector;

let bubble;

function setup(){
  createCanvas(800,400);
  background(20);
  frameRate(60);
  sector = line_w + 2;
  v_size = width / sector - 2;  // a sector must be bigger than the line width in order to have a space betweel lines // -2 is for letting a space between canvas and lines

  bubble = new BubbleSort(v_size);
  
}

function draw(){
  background(20);

  if(bubble.Sort()){
    noLoop();
    console.log("Done");
  }

  v = bubble.v;


  for(let i = 0; i<v_size; i++){
    switch(bubble.status[i]){
      case 0:
        stroke(255); break;
      case 1:
        stroke(237, 64, 64); break;
      case 2:
        stroke(63, 237, 124); break;
      case 3:
        stroke(74, 163, 247); break;
    }
    strokeWeight(line_w);
    line(i*sector + line_w/2 + line_w, height - line_w, i*sector + line_w/2 + line_w, height - v[i] - line_w);
  }



}