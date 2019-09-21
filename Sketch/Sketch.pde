import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import controlP5.*;
import java.util.ArrayList;

// TODO ADD SOUND

int length, minLength, maxLength;
float[] v;
int[] status;
int navSize = 80;
SelectionSort selectionSort;
BubbleSort bubbleSort;
ShuffleArray shuffleArray;
boolean pause = false;

color staticColor, iteratorColor, pivotColor;
ArrayList<Integer> colorArray;
ControlP5 cp5;

void setup(){
  size(1602, 520);
  background(15);
  frameRate(60);

  minLength = 200;
  maxLength = width;
  initialize();
}

void initialize(){
  length = minLength + 20; // let's say that

  colorArray = new ArrayList<Integer>();
  staticColor = color(255);
  iteratorColor = color(229, 57, 53);
  pivotColor = color(0, 121, 107);
  colorArray.add(staticColor);
  colorArray.add(pivotColor);
  colorArray.add(iteratorColor);

  v = new float[length];
  status = new int[length];
  float n = height * 1.0 / length;

  for(int i = 0; i < length; i++){
    v[i] = i * n;
  }

  selectionSort = new SelectionSort(v);
  bubbleSort = new BubbleSort(v);
  shuffleArray = new ShuffleArray(v);

  int bxPoz = width - navSize + 10;
  cp5 = new ControlP5(this);
  cp5.addButton("pause")
    .setPosition(bxPoz, 10)
    .setSize(60, 20)
  ;
  cp5.addButton("shuffle")
    .setPosition(bxPoz, 40)
    .setSize(60, 20)
  ;
  cp5.addButton("selection")
    .setPosition(bxPoz, 80)
    .setSize(60, 20)
  ;
  cp5.addButton("bubble")
    .setPosition(bxPoz, 110)
    .setSize(60, 20)
  ;
  cp5.addSlider("asize")
    .setRange(minLength, maxLength)
    .setPosition(bxPoz, 140)
    .setSize(25, 20)
  ;
}

void draw(){
  background(15);
  drawArray();
  drawRightNav();
}

void drawRightNav(){
  noStroke();
  fill(color(10));
  rect(width - navSize, 0, width, height);
}

void drawArray(){
  for(int i = 0; i < length; i++){

    float lineWidth = 1.0;
    float dist = (width - navSize) * 1.0 / length;

    stroke(colorArray.get(status[i]));
    strokeWeight(1);
    int lOffset = 2;
    line(i * 1.0 * dist + lOffset, height + lOffset, i * 1.0 * dist + lOffset, height * 1.0 - v[i] + lOffset);
  }
}

// BUTTONS & OTHER
void pause(){
  pause = !pause;
}
void shuffle(){
  shuffleArray.start();
}
void selection(){
  selectionSort.start();
}
void bubble(){
  bubbleSort.start();
}
void asize(int value){

}

//
void swap(int i, int j){
  float aux = v[i];
  v[i] = v[j];
  v[j] = aux;
}
