public class SortingAlgorithm implements Runnable{
  private int[] v;
  private Thread t;

  SortingAlgorithm(int[] v){
    this.v = v;
    registerMethod("draw", this);
  }

  @Override
  public void run(){
    
  }

  public void start(){
    if(t == null){
      t = new Thread(this, "thred");
    }
    t.start();
  }

  void draw(){
    for(int i = 0; i < length; i++){
      stroke(255);
      strokeWeight(3);
      line(i * 5 + 3, height, i * 5 + 3, height - v[i] * 0.95);
    }
  }

}
