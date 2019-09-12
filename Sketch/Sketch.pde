import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

int length;
int[] v;
SelectionSort selectionSort;

void setup(){
  size(1027, 480);
  background(15);
  frameRate(60);

  initialize();
}

void initialize(){
  length = width / 5;

  v = new int[length];
  int n = height / length;
  for(int i = 0; i < length; i++){
    v[i] = n * i;
  }
  shuffleArray(v);

  selectionSort = new SelectionSort(v);
  selectionSort.start();
}

void draw(){
  background(15);


}

static void shuffleArray(int[] ar)
  {
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
