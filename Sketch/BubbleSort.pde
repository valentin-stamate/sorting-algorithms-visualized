class BubbleSort extends SortingAlgorithm {

  @Override
  public void run() {

    algorithmFlag = "Algorithm : Bubble Sort";

    for(int i = 0; i < length; i++){
      for(int j = 0; j < length - 1; j++){
        if(v[j] > v[j + 1]){
          comparisons++;
          arrayAccess+=2;

          arrayColor(j, 1);
          arrayColor(j + 1, 2);
          swap(j, j + 1);

          super.sleep();
          resetArrayColor(j);
          resetArrayColor(j + 1);
        }
      }
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
