class SelectionSort{
  constructor(v,status) {
    //this.v = v;
    //this.status = status;
  }
  // sleep() is an external function
  async Sort() {
    let n = this.v.length;
    for(let i = 0;i < n - 1; i++){
      for(let j = i+1; j<n;j++){
        if(this.v[i]>this.v[j]){
          this.status[i] = 1;
          this.status[j] = 2;

          await this.swap(i, j);

          this.status[i] = 0;
          this.status[j] = 0;
        }
      }
    }
    console.log("Selection Sort : Done");
    return;
  }
  
  async swap(i, j) {
    await sleep();
    
    let aux = this.v[i];
    this.v[i] = this.v[j];
    this.v[j] = aux;
  }

}