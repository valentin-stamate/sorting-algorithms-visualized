class SelectionSort{
  constructor(v,status) {
    this.v = v;
    this.status = status;
  }

  Sort() {
    let n = this.v.length;
    for(let i = 0;i < n - 1; i++){
      for(let j = i+1; j<n;j++){
        if(this.v[i]>this.v[j])
          swap(i, j);
      }
    }
  }
  
  swap(i, j) {
    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }

}