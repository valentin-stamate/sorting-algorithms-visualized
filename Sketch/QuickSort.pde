class QuickSort extends SortingAlgorithm{

  @Override
  public void run() {

    algorithmFlag = "Algorithm : Quick Sort";

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
    ArrayColor(r, 4);
    int i = l;
    // put the ellements smaller than pivot int the left side
    for(int j = l; j < r; j++){
      ArrayColor(j, 2);
      ArrayColor(i, 1);
      if(v[j] < pivot){
        comparisons++;

        ArrayColor(i, 1);

        swap(i, j);
        super.sleep();
        ResetArrayColor(i);
        i++;
      }
      ResetArrayColor(j);
    }
    // swap v[i] with pivot -> v[r]
    ResetArrayColor(r);
    swap(i, r);
    return i;
  }

}
