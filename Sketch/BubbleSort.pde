class BubbleSort extends SortingAlgorithm{

  @Override
  public void run() {

    for(int i = 0; i < length; i++){
      for(int j = 0; j < length - 1; j++){
        if(v[j] > v[j + 1]){
          comparisons++;
          arrayAccess+=2;

          ArrayColor(j, 1);
          ArrayColor(j + 1, 2);
          swap(j, j + 1);

          SoundPlay(j);

          super.sleep();
          ResetArrayColor(j);
          ResetArrayColor(j + 1);
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
