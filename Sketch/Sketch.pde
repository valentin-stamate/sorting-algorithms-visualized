import controlP5.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;


int length, minLength, maxLength, DELAY = 5, newALength, newDELAY = 5, arrayAccess = 0, comparisons = 0;
int[] v;
int[] status;
int navSize = 80;
boolean pause = false, sortStart = false;

String algorithmFlag = "";

ShuffleArray shuffleArray;
BubbleSort bubbleSort;
InsertionSort insertionSort;
SelectionSort selectionSort;
QuickSort quickSort;
RadixSort radixSort;
MergeSort mergeSort;
PigeonholeSort pigSort;
GravitySort gravitySort;
HeapSort heapSort;

ArrayList<Integer> colorArray;
ControlP5 cp5;

void setup(){
  size(1602, 520, P2D);
  background(15);
  frameRate(60);
  strokeCap(ROUND);

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
  Ascending();

  bubbleSort = new BubbleSort();
  insertionSort = new InsertionSort();
  selectionSort = new SelectionSort();
  shuffleArray = new ShuffleArray();
  quickSort = new QuickSort();
  radixSort = new RadixSort();
  mergeSort = new MergeSort();
  pigSort = new PigeonholeSort();
  gravitySort = new GravitySort();
  heapSort = new HeapSort();

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
  cp5.addButton("ascending")
    .setPosition(bxPoz, 80)
    .setSize(60, 20)
  ;
  cp5.addButton("descending")
    .setPosition(bxPoz, 110)
    .setSize(60, 20)
  ;
  cp5.addButton("bubble")
    .setPosition(bxPoz, 150)
    .setSize(60, 20)
  ;
  cp5.addButton("insertion")
    .setPosition(bxPoz, 180)
    .setSize(60, 20)
  ;
  cp5.addButton("selection")
    .setPosition(bxPoz, 210)
    .setSize(60, 20)
  ;
  cp5.addButton("quick")
    .setPosition(bxPoz, 240)
    .setSize(60, 20)
  ;
  cp5.addButton("radix")
    .setPosition(bxPoz, 270)
    .setSize(60, 20)
  ;
  cp5.addButton("merge")
    .setPosition(bxPoz, 300)
    .setSize(60, 20)
  ;
  cp5.addButton("heap")
    .setPosition(bxPoz, 330)
    .setSize(60, 20)
  ;
  cp5.addButton("pigeonhole")
    .setPosition(bxPoz, 360)
    .setSize(60, 20)
  ;
  // ISSUE WITH VISUALIZASON
  // cp5.addButton("gravity")
  //   .setPosition(bxPoz, 200)
  //   .setSize(60, 20)
  // ;


  cp5.addSlider("asize")
    .setRange(minLength, maxLength)
    .setPosition(bxPoz, height - 60)
    .setSize(25, 20)
  ;
  cp5.addSlider("delay")
    .setValue(DELAY)
    .setRange(1, 50)
    .setPosition(bxPoz, height - 30)
    .setSize(25, 20)
  ;

}
// DRAW FUNCTIONS
void draw(){
  background(15);
  drawArray();
  drawRightNav();
  drawInfo();
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

  beginShape(LINES);
  for(int i = 0; i < length; i++){

    float lineWidth = 1.0;
    float dist = (width - navSize) * 1.0 / length;

    int lOffset = 2;
    stroke(colorArray.get(status[i]));
    vertex(i * 1.0 * dist + lOffset, height + lOffset);
    vertex(i * 1.0 * dist + lOffset, height * 1.0 - v[i] * 1.0 / 10 + lOffset);
  }
  endShape();
}

void drawInfo(){
  textSize(12);
  fill(255);
  text("comparisons: " + comparisons, 10, 20);
  text("array access: " + arrayAccess, 180, 20);
  text(algorithmFlag, 350, 20);
}

void Ascending(){
  comparisons = 0;
  arrayAccess = 0;
  v = new int[length];
  status = new int[length];
  float n = (height - 20) * 1.0 / length;

  for(int i = 0; i < length; i++){
    v[i] = (int)( (n * i) * 10 );
    status[i] = 0;
  }
}

void Descending(){
  comparisons = 0;
  arrayAccess = 0;
  v = new int[length];
  status = new int[length];
  float n = (height - 20) * 1.0 / length;

  for(int i = length - 1; i >= 0; i--){
    v[i] = (int)( (n * (length - 1 - i)) * 10 );
    status[i] = 0;
  }
}

// BUTTONS & OTHER
void pause(){
  pause = !pause;
}
void shuffle(){
  if(!pause){
    sortStart = false;
    shuffleArray.start();
  }
}
void ascending(){
  if(!pause){
    sortStart = false;
    sleep(100);
    algorithmFlag = "";

    Ascending();
  }
}
void descending(){
  if(!pause){
    sortStart = false;
    sleep(100);
    algorithmFlag = "";

    Descending();
  }
}
void bubble(){
  bubbleSort.start();
}
void insertion(){
  insertionSort.start();
}
void selection(){
  selectionSort.start();
}
void quick(){
  quickSort.start();
}
void radix(){
  radixSort.start();
}
void merge(){
  mergeSort.start();
}
void pigeonhole(){
  pigSort.start();
}
void heap(){
  heapSort.start();
}
void gravity(){
  gravitySort.start();
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
    pause = false;
    sortStart = false;
    sleep(100);
    length = newALength;
    Ascending();
  }
  if(newDELAY != DELAY){
    DELAY = newDELAY;
  }
}

//
void ArrayColor(int index, int col){
  status[index] = col;
}
void ResetArrayColor(int index){
  status[index] = 0;
}

void swap(int i, int j){
  arrayAccess+=3;
  int aux = v[i];
  v[i] = v[j];
  v[j] = aux;
}

void sleep(int time){
  try{ Thread.sleep(time); }
  catch (Exception e){}
}
