class InsertionSort{
    constructor(size) {
      this.v = new Array();
      this.status = new Array();
      this.v = [size];
      this.status = [size];
      this.i = 1;
      this.j = 0;
      for(let i = 0; i < size; i++){
          this.v[i] = parseInt( random( height-30 ) );
          this.status[i] = 0;
      }
      this.key = this.v[1];
    }
  
    Sort() {

      for(let j = 0; j < this.v.length; j++)
        this.status[j] = 0;
        
      this.status[this.i] = 2;
      if(this.j >= 0 && this.v[this.j] > this.key){
        this.v[this.j + 1] = this.v[this.j];
        this.j--;
        this.status[this.j] = 1;
      } else if(this.i < this.v.length){
        this.v[this.j + 1] = this.key;
        this.i++;
        this.key = this.v[this.i];
        this.j = this.i - 1;
      } else 
        return true;


    }
    
    swap(v, i, j) {
      let aux = v[i];
      v[i] = v[j];
      v[j] = aux;
    }
  
  }