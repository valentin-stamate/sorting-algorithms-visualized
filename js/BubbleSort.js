class BubbleSort{
    constructor(size) {
      this.v = new Array();
      this.status = new Array();
      this.v = [size];
      this.status = [size];
      this.i = 0;
      this.j = 0;
      for(let i = 0; i < size; i++){
          this.v[i] = parseInt( random( height-30 ) );
          this.status[i] = 0;
      }
    }
  
    Sort() {

      for(let j = 0; j < this.v.length; j++)
        this.status[j] = 0;
  

      if(this.j < this.v.length - this.i - 1){
        
        if(this.v[this.j] > this.v[this.j + 1])
            this.swap(this.v, this.j, this.j + 1);

        this.status[this.j] = 1;
        this.status[this.j+1] = 1;
        this.j++;

      } else if(this.i < this.v.length - 1){
          this.i++;
          this.j = 0;
      } else {
          return true;
      }

    }
    
    swap(v, i, j) {
      let aux = v[i];
      v[i] = v[j];
      v[j] = aux;
    }
  
  }