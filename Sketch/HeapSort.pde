class HeapSort extends SortingAlgorithm {

  @Override
  public void run() {

    algorithmFlag = "Algorithm : Heap Sort";

    boolean isSorted = super.isSorted();

    if(!isSorted) {
      sort(v.length);
    }

    if(sortStart){
      super.animate();
    }

    super.t = null;
    sortStart = false;

  }

  public void start(){
    super.start(this);
  }

// TODO array access

  // RADIX SORT
  private void sort(int n){

    for(int i = n / 2 - 1; i >= 0; i--){
      heapify(n, i);
    }

    for(int i = n - 1; i >= 0; i--){
      arrayColor(i, 1);
      super.sleep();
      swap(i, 0);
      heapify(i, 0);
      resetArrayColor(i);
    }

  }

  private void heapify(int n, int i){
    int root = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    super.sleep();

    // CHANGE THE ROOT WITH THE SMALLEST VALUE
    if(left < n && v[root] < v[left]){
      root = left;
    }
    
    if(right < n && v[root] < v[right]){
      root = right;
    }

    comparisons += 4;

    // IF THE ROOT CHAMGES:
    if(root != i){
      arrayColor(i, 2);

      super.sleep();
      
      swap(root, i);
      heapify(n, root);
      resetArrayColor(i);
    }

    comparisons++;
  }

}
