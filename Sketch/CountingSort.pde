class CountingSort extends SortingAlgorithm {

  @Override
  public void run() {

    algorithmFlag = "Algorithm : Counting Sort";

    int n = v.length;
    int sorted[] = new int[n];

    int maxValue = 0;
    for(int i = 0; i < n; i++){
      if(maxValue < v[i]) {
        maxValue = v[i];
      }

      arrayAccess++;
    }

    int c[] = new int[maxValue + 1];

    for(int i = 0; i <= maxValue; i++){
      c[i] = 0;
    }

    for(int i = 0; i < n; i++){
      arrayColor(i, 3);
      super.sleep();

      c[v[i]] ++;

      arrayAccess++;
      resetArrayColor(i);
    }

    for(int i = 2; i <= maxValue; i++){
      c[i] += c[i - 1];
    }

    for(int i = n - 1; i >= 0; i--){
      arrayColor(i, 4);

      sorted[ c[v[i]]] = v[i];
      c[v[i]]--;

      arrayAccess++;
      super.sleep();
      
      resetArrayColor(i);
    }

    for(int i = 0; i < n; i++){
      arrayColor(i, 1);

      v[i] = sorted[i];

      arrayAccess++;
      super.sleep();

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
