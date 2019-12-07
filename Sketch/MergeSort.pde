class MergeSort extends SortingAlgorithm{

  @Override
  public void run() {

    algorithmFlag = "Algorithm : Merge Sort";

    mergeSort(0, v.length - 1);

    if(sortStart){
      super.animate();
    }
    super.t = null;
    sortStart = false;
  }

  public void start(){
    super.start(this);
  }

  void mergeSort(int l, int r){
    if(l < r){
      comparisons++;
      int m = (l + r) / 2;
      ArrayColor(m, 3);

      mergeSort(l, m);
      mergeSort(m + 1, r);

      merge(l, m, r);

      ResetArrayColor(m);
    }
  }

  void merge(int l, int m, int r){
    int n1 = m - l + 1;
    int n2 = r - m;

    int[] L = new int[n1];
    int[] R = new int[n2];

    for(int i = l; i <= m; i++){
      L[i - l] = v[i];
      arrayAccess++;
    }
    for(int i = m + 1; i <= r; i++){
      R[i - (m + 1)] = v[i];
      arrayAccess++;
    }

    // Merge these arrays

    int k = l, i = 0, j = 0;
    while(i < n1 && j < n2){
      if(L[i] < R[j]){
        v[k] = L[i++];
        arrayAccess++;
      } else {
        v[k] = R[j++];
        arrayAccess++;
      }

      comparisons+=3;

      ArrayColor(k, 2);

      super.sleep();
      ResetArrayColor(k);
      k++;
    }

    while(i < n1){
      v[k] = L[i++];
      k++;
      comparisons++;
      arrayAccess++;
    }
    while(j < n2){
      v[k] = R[j++];
      k++;
      comparisons++;
      arrayAccess++;
    }

  }

}
