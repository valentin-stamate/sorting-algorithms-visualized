class QuickSort{
    constructor(size) {
      this.status = new Array();
      this.status = [size];
      this.i = 0;
      this.j = 0;
      for(let i = 0; i < size; i++){
          this.status[i] = 0;
      }
      this.low = 0;
      this.high = size -1;
    }
    // weird stuff going here
    async Sort(arr, start, end) {
      if(start>=end)
        return true;

      let index = await this.partition(arr, start, end);

      this.status[index] = 0;
      await Promise.all([//this for wating both of them to finish(i don't know what i am writing about)
          await this.Sort(arr, start, index - 1),
          await this.Sort(arr, index + 1, end
      )]);


    }

    async partition(arr, start, end){
      let pivotIndex = start;
      let pivotValue = arr[end];

      for(let i = start;i < end;i++){
        this.status[i] = 3;
      }

      this.status[pivotIndex] = 1;

      for(let i = start; i < end; i++){
        if(arr[i] < pivotValue) {
            await this.swap(arr, i, pivotIndex);
            this.status[pivotIndex] = 0;
            pivotIndex++;
            this.status[pivotIndex] = 1;
        }
      }
      await this.swap(arr, pivotIndex, end);

      for(let i = start;i< end;i++){
        if(i!= pivotIndex)
          this.status[i] = 0;
      }
      return pivotIndex;
    }

    async swap(v, i, j) {
      await this.sleep(10);
      let aux = v[i];
      v[i] = v[j];
      v[j] = aux;
    }

    sleep(ms){
      return new Promise(resolve => setTimeout(resolve, ms));
    }
  
  }