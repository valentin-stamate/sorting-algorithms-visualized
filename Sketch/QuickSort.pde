class QuickSort extends SortingAlgorithm{

  @Override
  public void run() {

    boolean isSorted = super.isSorted();

    if(!isSorted)
      sort(0, v.length - 1);

    if(sortStart){
      super.animate();
    }
    super.t = null;
    sortStart = false;
  }

  public void start(){
    super.start(this);
  }

  // QUICKSORT
  private void sort(int l, int r){
    if(l < r){
      int partitionIndex = partition(l, r);

      status[partitionIndex] = 3;

      sort(l, partitionIndex - 1);
      sort(partitionIndex + 1, r);

      status[partitionIndex] = 0;
    }
  }

  private int partition(int l, int r){
    float pivot = v[r];
    status[r] = 4;
    int i = l;
    // put the ellements smaller than pivot int the left side
    for(int j = l; j < r; j++){
      status[j] = 2;
      status[i] = 1;
      if(v[j] < pivot){
        comparisons++;

        status[i] = 1;
        SoundPlay(i);
        swap(i, j);
        super.sleep();
        status[i] = 0;
        i++;
      }
      status[j] = 0;
    }
    // swap v[i] with pivot -> v[r]
    status[r] = 0;
    swap(i, r);
    return i;
  }

}
