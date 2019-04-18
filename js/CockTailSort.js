class CockTailSort{
    constructor(size) {
      this.status = new Array();
      this.status = [size];
      this.sleepTime = 1;//(ms)
      for(let i = 0; i < size; i++)
          this.status[i] = 3;
      
      this.finished = false;
      
    }
    
    async Sort(v) {
      
      let swapped = true; 
      let start = 0; 
      let end = this.status.length; 
  
      while (swapped) { 
        swapped = false; 
  
               
        for (let i = start; i < end; ++i) {
          this.status[i] = 1;
          if (v[i] > v[i + 1]) { 
            await this.swap(v, i, i + 1);
            swapped = true; 
          } else {
              await this.sleep(this.sleepTime);
          }
          this.status[i] = 3;
         
        } 
        if (!swapped) 
          break; 
  
        swapped = false; 
        this.status[end] = 0;
        --end;
        
  
        

        for (let i = end - 1; i >= start; --i) {
         this.status[i + 1] = 1;
         if (v[i] > v[i + 1]) { 
            await this.swap(v, i, i + 1);
            swapped = true; 
          } else {
            await this.sleep(this.sleepTime);
          }
          this.status[i + 1] = 3;
        } 

        this.status[start] = 0;
        ++start;
        

      } 
      this.finished = true;
      for(let i = 0; i < this.status.length; i++)
          this.status[i] = 0;
      return true;


    }
    
    async swap(v, i, j) {
      await this.sleep(this.sleepTime);
      let aux = v[i];
      v[i] = v[j];
      v[j] = aux;
    }

    sleep(ms){
      return new Promise(resolve => setTimeout(resolve, ms));
    }
  
  }