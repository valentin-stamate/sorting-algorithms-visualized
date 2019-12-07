class InsertionSort extends SortingAlgorithm{

  @Override
  public void run() {

    algorithmFlag = "Algorithm : Insertion Sort";

    int n = v.length;

    for(int i = 1; i < n; i++){


      int key = v[i];

      arrayAccess++;

      int j = i - 1;
      while(j >= 0 && key < v[j]){
        comparisons+=2;

        ArrayColor(j, 1);
        super.sleep();
        ResetArrayColor(j);
        v[j + 1] = v[j];
        j--;

        arrayAccess+=3;
      }
      v[j + 1] = key;
      arrayAccess++;

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

}
