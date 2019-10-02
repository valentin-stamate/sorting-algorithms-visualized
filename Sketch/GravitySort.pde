class GravitySort extends SortingAlgorithm{

  @Override
  public void run() {

    gravitySort();

    if(sortStart){
      super.animate();
    }
    super.t = null;
    sortStart = false;
  }

  public void start(){
    super.start(this);
  }

  // code taken from https://www.geeksforgeeks.org/bead-sort-natural-sorting-algorithm/
  private void gravitySort(){

    int max = v[0];
    for (int i = 1; i <v.length; i++)
      if (v[i] > max)
         max = v[i];

    int[] beads = new int[max * v.length];
    for(int i = 0; i < beads.length; i++){
      beads[i] = 0;
    }

    for (int i = 0; i < v.length; i++)
      for (int j = 0; j < v[i]; j++)
        beads[i * max + j] = 1;

    for (int j = 0; j < max; j++){
      int sum = 0;
      for(int i = 0; i < v.length; i++){
        sum += beads[i * max + j];
        beads[i * max + j] = 0;
      }

      for (int i = v.length - sum; i < v.length; i++){
        beads[i * max + j] = 1;
      }
    }

    // Put sorted values in array using beads
    for (int i = 0; i < v.length; i++){
      int j;
      for (j = 0; j < max && beads[i * max + j] != 0; j++){}
      v[i] = j;
    }
  }

}
