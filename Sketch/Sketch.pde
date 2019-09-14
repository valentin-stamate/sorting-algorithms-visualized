import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import controlP5.*;
import java.util.ArrayList;

// TODO ADD SOUND

int length;
int[] v, status;
SelectionSort selectionSort;

color staticColor, iteratorColor, pivotColor;
ArrayList<Integer> colorArray;
ControlP5 button;

void setup(){
  size(1027, 520);
  background(15);
  frameRate(60);

  initialize();
}

void initialize(){
  length = width / 5;

  colorArray = new ArrayList<Integer>();
  staticColor = color(255);
  iteratorColor = color(229, 57, 53);
  pivotColor = color(0, 121, 107);
  colorArray.add(staticColor);
  colorArray.add(pivotColor);
  colorArray.add(iteratorColor);

  v = new int[length];
  status = new int[length];
  int n = (height - 40) / length;
  println("This is n : " + n);
  for(int i = 0; i < length; i++){
    v[i] = n * i;
    println(v[i]);
  }
  shuffleArray(v);

  selectionSort = new SelectionSort(v);

  button = new ControlP5(this);
  button.addButton("pause")
    .setPosition(10, height - 30)
    .setSize(60, 20)
  ;
  button.addButton("shuffle")
    .setPosition(80, height - 30)
    .setSize(60, 20)
  ;
  button.addButton("selectionsort")
    .setPosition(160, height - 30)
    .setSize(80, 20)
  ;
}

void draw(){
  background(15);
}

void drawDownNav(){
  noStroke();
  fill(color(15));
  rect(0, height - 40, width, 40 );
}

// BUTTONS
void pause(){
  println("pause");
}
void shuffle(){
  println("shuffle");
}
void selectionsort(){
  selectionSort.start();
}

// TODO code taken from :
static void shuffleArray(int[] ar) {
  // If running on Java 6 or older, use `new Random()` on RHS here
  Random rnd = ThreadLocalRandom.current();
  for (int i = ar.length - 1; i > 0; i--)
  {
    int index = rnd.nextInt(i + 1);
    // Simple swap
    int a = ar[index];
    ar[index] = ar[i];
    ar[i] = a;
  }
}
