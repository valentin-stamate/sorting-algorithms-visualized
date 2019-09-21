class BubbleSort extends SortingAlgorithm{
  BubbleSort(float[] v){
    super(v);
  }

  // TODO make the status thing better
  @Override
  public void run() {

    super.animate();
  }

  public void start(){
    super.t = new Thread(this);

    super.t.start();
  }

}
