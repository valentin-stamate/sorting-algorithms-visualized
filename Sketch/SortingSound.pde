import processing.sound.*;
public class SortingSound implements Runnable{
  Thread t;
  private int DELAY = 100;
  int index;
  Sketch sketch;

  SortingSound(Sketch sketch){
    this.sketch = sketch;
  }

  @Override
  void run(){

    try{ Thread.sleep(this.DELAY); }
    catch(Exception e){}

  }

  void play(int n){
    index = n;
    t = new Thread(this);
    t.start();
  }

}
