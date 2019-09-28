import controlP5.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

SortingSound ss;
Sound s;

int length, minLength, maxLength, DELAY = 5, newALength, newDELAY = 5, arrayAccess = 0, comparisons = 0;
float[] v;
int[] status;
int navSize = 80;
boolean pause = false, sortStart = false;

ShuffleArray shuffleArray;
SelectionSort selectionSort;
BubbleSort bubbleSort;
QuickSort quickSort;

ArrayList<Integer> colorArray;
ControlP5 cp5;

void setup(){
  size(1602, 520, P2D);
  background(15);
  frameRate(60);
  strokeCap(ROUND);

  s = new Sound(this);
  s.volume(0.5);

  minLength = 200;
  maxLength = width - navSize;
  initialize();
}

void initialize(){
  length = minLength; // let's say that
  newALength = length;

  colorArray = new ArrayList<Integer>();
  colorArray.add(color(255));          // white
  colorArray.add(color(0, 121, 107));  // green
  colorArray.add(color(229, 57, 53));  // red
  colorArray.add(color(3, 169, 244));  // blue
  colorArray.add(color(230, 74, 25));  // orange
  newArray();

  selectionSort = new SelectionSort();
  bubbleSort = new BubbleSort();
  shuffleArray = new ShuffleArray();
  quickSort = new QuickSort();

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
  cp5.addButton("quick")
    .setPosition(bxPoz, 140)
    .setSize(60, 20)
  ;

  cp5.addSlider("asize")
    .setRange(minLength, maxLength)
    .setPosition(bxPoz, height - 60)
    .setSize(25, 20)
  ;
  cp5.addSlider("delay")
    .setValue(DELAY)
    .setRange(0, 20)
    .setPosition(bxPoz, height - 30)
    .setSize(25, 20)
  ;

  ss = new SortingSound(this);
}
// DRAW FUNCTIONS
void draw(){
  background(15);
  drawArray();
  drawRightNav();
  drawScore();
}

void drawRightNav(){
  noStroke();
  fill(color(10));
  rect(width - navSize, 0, width, height);
}

void drawArray(){
  int strokeWeight = (width - navSize) / length / 2;
  if(strokeWeight < 1){
    strokeWeight = 1;
  }
  strokeWeight(strokeWeight);
  //stroke(255);
  beginShape(LINES);
  for(int i = 0; i < length; i++){

    float lineWidth = 1.0;
    float dist = (width - navSize) * 1.0 / length;

    int lOffset = 2;
    stroke(colorArray.get(status[i]));
    vertex(i * 1.0 * dist + lOffset, height + lOffset);
    vertex(i * 1.0 * dist + lOffset, height * 1.0 - v[i] + lOffset);
  }
  endShape();
}

void drawScore(){
  textSize(12);
  fill(255);
  text("comparisons: " + comparisons, 10, 20);
  text("array access: " + arrayAccess, 180, 20);
}


void newArray(){
  comparisons = 0;
  arrayAccess = 0;
  v = new float[length];
  status = new int[length];
  float n = (height - 20) * 1.0 / length;

  for(int i = 0; i < length; i++){
    v[i] = i * n;
    status[i] = 0;
  }
}

// BUTTONS & OTHER
void pause(){
  pause = !pause;
}
void shuffle(){
  sortStart = false;
  shuffleArray.start();
}
void selection(){
  selectionSort.start();
}
void bubble(){
  bubbleSort.start();
}
void quick(){
  quickSort.start();
}
void asize(int value){
  newALength = value;
}

void delay(int delay){
  newDELAY = delay;
}
//
void mouseReleased() {
  if(newALength != length){
    // FINISH THE SEARCH AND AFTER CREATES A NEW ARRAY
    sortStart = false;
    sleep(100);

    length = newALength;
    newArray();
  }
  if(newDELAY != DELAY){
    DELAY = newDELAY;
  }
}

//
void swap(int i, int j){
  arrayAccess+=3;
  float aux = v[i];
  v[i] = v[j];
  v[j] = aux;
}

void sleep(int time){
  try{ Thread.sleep(time); }
  catch (Exception e){}
}

void SoundPlay(int n){
  //ss.play(n);
}
