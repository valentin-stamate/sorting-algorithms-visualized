class SelectionSort extends SortingAlgorithm {

  @Override
  public void run() {

    algorithmFlag = "Algorithm : Selection Sort";

    for(int i = 0; i < v.length - 1; i++){

      arrayColor(i, 1);

      for(int j = i + 1; j < v.length; j++){
        if(v[i] > v[j]){
          comparisons++;
          arrayAccess += 2;

          arrayColor(j, 2);

          super.sleep();
          swap(i, j);
        }

        resetArrayColor(j);
      }

      resetArrayColor(i);
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
