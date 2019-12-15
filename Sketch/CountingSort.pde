class CountingSort extends SortingAlgorithm{

  @Override
  public void run() {

    algorithmFlag = "Algorithm : Counting Sort";

    int n = v.length;
    int sorted[] = new int[n];

    int k = 0;
    for(int i = 0; i < n; i++){
      if(k < v[i])
        k = v[i];

      arrayAccess++;
    }

    int c[] = new int[k + 1];

    for(int i = 0; i <= k; i++){
      c[i] = 0;
    }

    for(int i = 0; i < n; i++){
      ArrayColor(i, 3);
      super.sleep();

      c[ v[i] ] ++;

      arrayAccess++;
      ResetArrayColor(i);
    }

    for(int i = 2; i <= k; i++){
      c[i] += c[i - 1];
    }

    for(int i = n - 1; i >= 0; i--){
      ArrayColor(i, 4);

      sorted[ c[ v[i] ] ] = v[i];
      c[ v[i] ]--;

      arrayAccess++;
      super.sleep();
      ResetArrayColor(i);
    }

    for(int i = 0; i < n; i++){
      ArrayColor(i, 1);

      v[i] = sorted[i];

      arrayAccess++;
      super.sleep();
      ResetArrayColor(i);
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
