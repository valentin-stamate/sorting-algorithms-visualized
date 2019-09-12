class SelectionSort extends SortingAlgorithm{
  SelectionSort(int[] v){
    super(v);
  }

  @Override
  public void run() {
    for(int i = 0; i < v.length - 1; i++){
      for(int j = i + 1; j < v.length; j++){
        if(v[i] > v[j]){

          try{ Thread.sleep(1); }
          catch (Exception e){}

          int aux = v[i];
          v[i] = v[j];
          v[j] = aux;
        }
      }
    }
  }

}
