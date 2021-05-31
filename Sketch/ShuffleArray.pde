class ShuffleArray extends SortingAlgorithm {

  @Override
  public void run() {

    algorithmFlag = "Shuffling";

    // END THE RUNNING SORTING THREAD
    sortStart = false;


    try{ Thread.sleep(100); }
    catch (Exception e){}

    sortStart = true;
    // code taken from : http://bit.ly/2knN9Mh

    Random rnd = ThreadLocalRandom.current();

    int sleepTime = 2 * height / length;
    sleepTime = sleepTime < 1 ? 1 : sleepTime;

    for (int i = 0; i < v.length; i++) {

      int index = rnd.nextInt(i + 1);

      arrayColor(i, 2);
      arrayColor(index, 3);

      try{ Thread.sleep(sleepTime); }
      catch (Exception e){}

      resetArrayColor(i);
      resetArrayColor(index);

      swap(index, i);
    }
    super.t = null;
    sortStart = false;
    comparisons = 0;
    arrayAccess = 0;
    algorithmFlag = "";
    return;
  }

  public void start(){
    super.start(this);
  }

}
