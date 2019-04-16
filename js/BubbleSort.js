class BubbleSort{
  constructor(size) {
    this.v = new Array();
    this.status = new Array();
    this.v = [size];
    this.status = [size];
    this.i = -1;//don't know why works with -1;
    for(let i = 0; i < size; i++){
        this.v[i] = parseInt( random( height-30 ) );
        this.status[i] = 0;
    }
  }

  Sort() {
    let poz_min = this.i, min = v[this.i];

    for(let j = 0; j<=this.i-1; j++)
      this.status[j] = 0;

    this.status[this.i] = 1;

    for(let j = this.i + 1; j < this.v.length; j++){
      this.status[j] = 3;
      if(min > this.v[j]){
          min = this.v[j];
          poz_min = j;
      }
    }
    
    this.status[poz_min] = 2;

    this.swap(this.v, this.i, poz_min);

    if(this.i<this.v.length-1){
      this.i++;
      return false;
    } else {
      this.status[this.v.length - 1] = 0;
      return true;
    }
  }
  
  swap(v, i, j) {
    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }

}