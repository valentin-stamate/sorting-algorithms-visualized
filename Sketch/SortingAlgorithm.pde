public class SortingAlgorithm implements Runnable{
  private int[] v;
  private Thread t;

  SortingAlgorithm(int[] v){
    this.v = v;
    registerMethod("draw", this);
  }

  @Override
  public void run(){}

  public void start(){
    if(t == null){
      t = new Thread(this, "thred");
    }
    t.start();
  }

  private void animate(){
    for(int i = 0; i < v.length; i++){
      try{ Thread.sleep(5); }
      catch (Exception e){}
      status[i] = 1;
    }
  }

  void draw(){
    for(int i = 0; i < length; i++){
      stroke(colorArray.get(status[i]));
      strokeWeight(3);
      line(i * 5 + 3, (height - 40), i * 5 + 3, (height - 40) - v[i]);
    }
  }

}
