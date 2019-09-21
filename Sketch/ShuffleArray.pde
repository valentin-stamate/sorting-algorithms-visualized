class ShuffleArray extends SortingAlgorithm{
  ShuffleArray(float[] v){
    super(v);
  }

  @Override
  public void run() {

    // code taken from : http://bit.ly/2knN9Mh

    Random rnd = ThreadLocalRandom.current();
    for (int i = 0; i < v.length; i++) {

      try{ Thread.sleep(3); }
      catch (Exception e){}

      status[i] = 0;

      int index = rnd.nextInt(i + 1);
      swap(index, i);
    }

    super.t = null;
    return;
  }

  public void start(){
    super.start(this);
  }

}
