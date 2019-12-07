class RadixSort extends SortingAlgorithm{

  @Override
  public void run() {

    algorithmFlag = "Algorithm : Radix Sort";

    radixSort();

    if(sortStart){
      super.animate();
    }
    super.t = null;
    sortStart = false;
  }

  public void start(){
    super.start(this);
  }

  private void radixSort(){
    int max = getMax();

    for(int pow = 1; max / pow > 0; pow *= 10){
      countSort(pow);
    }
  }

  private void countSort(int pow){
    int[] output = new int[v.length];
    int[] count = new int[10];

    for(int i = 0; i < 10; i++){
      count[i] = 0;
    }

    for(int i = 0; i < v.length; i++){
      status[i] = 2;

      int sleepTime = 2 * height / length;
      sleepTime = sleepTime < 1 ? 1 : sleepTime;
      super.sleep(sleepTime);

      count[ (v[i] / pow) % 10 ] ++;
      arrayAccess++;
      status[i] = 0;
    }

    for(int i = 1; i < 10; i++){
      count[i] += count[i - 1];
    }

    for(int i = v.length - 1; i >= 0; i--){
      int index = (v[i] / pow) % 10;
      output[ --count[index] ] = v[i];
      arrayAccess+=2;
    }

    for(int i = 0; i < v.length; i++){
      v[i] = output[i];
      status[i] = 1;
      super.sleep();
      status[i] = 0;
    }

  }

  private int getMax(){
    int max = v[0];
    for(int i = 1; i < v.length; i++){
      if(v[i] > max)
        max = v[i];
    }
    return max;
  }

}
