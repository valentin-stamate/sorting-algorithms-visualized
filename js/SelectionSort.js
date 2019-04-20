class SelectionSort{
  constructor(v,status) {
    //this.v = v;
    //this.status = status;
  }
  // sleep() is an external function
  async Sort() {
    let n = v.length;
    for(let i = 0;i < n - 1; i++){
      for(let j = i+1; j<n;j++){
        if(v[i]>v[j]){
          status[i] = 1;
          status[j] = 2;

          await this.swap(i, j);

          status[i] = 0;
          status[j] = 0;
        }
      }
    }
    console.log("Selection Sort : Done");
    return;
  }
  
  async swap(i, j) {
    await sleep();
    
    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }

}