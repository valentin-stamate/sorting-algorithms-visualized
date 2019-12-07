public class SortingAlgorithm implements Runnable{
  private Thread t;

  @Override
  public void run(){
    // look into subclass
  }
  private void start(SortingAlgorithm sa){
    if(t == null && !sortStart){
      comparisons = 0;
      arrayAccess = 0;
      t = new Thread(sa);
      t.start();
      sortStart = true;
    }
  }

  private void animate(){
    int sleepTime = 2 * height / length;
    sleepTime = sleepTime < 1 ? 1 : sleepTime;

    for(int i = 0; i < status.length; i++){
      try{ Thread.sleep(sleepTime); }
      catch (Exception e){}
      status[i] = 1;
    }
    t = null;
    algorithmFlag = "";
  }

  private void sleep(){
    try{ if(sortStart) { Thread.sleep(DELAY); }}
    catch (Exception e){}

    try{ while(pause){ Thread.sleep(100); }}
    catch (Exception e){}
  }

  private void sleep(int t){
    try{ if(sortStart) { Thread.sleep(t); }}
    catch (Exception e){}

    try{while(pause){ Thread.sleep(100); }}
    catch (Exception e){}
  }

  private boolean isSorted(){
    int n = 0;
    for(int i = 0; i < v.length - 1; i++){
      if(v[i] > v[i + 1])
        n++;
    }
    return (n == 0);
  }

}
