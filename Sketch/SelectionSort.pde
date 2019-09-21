class SelectionSort extends SortingAlgorithm{
  SelectionSort(float[] v){
    super(v);
  }

  // TODO make the status thing better
  @Override
  public void run() {
    for(int i = 0; i < v.length - 1; i++){
      status[i] = 1;
      if(i != 0 && status[i - 1] == 1){
        status[i - 1] = 0;
      }
      for(int j = i + 1; j < v.length; j++){
        status[v.length - 1] = 0;
        if(status[j - 1] == 2){
          status[j - 1] = 0;
        }

        super.sleep();

        if(v[i] > v[j]){
          status[j] = 2;
          swap(i, j);
        }
      }
    }

    status[v.length - 1] = 0;
    status[v.length - 2] = 0;
    super.animate();

  }

  public void start(){
    super.start(this);
  }

}
