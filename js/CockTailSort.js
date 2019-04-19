class CockTailSort {
  constructor(v, status) {
    this.v = v;
    this.status = status;
  }

  async Sort() {

    let swapped = true;
    let start = 0;
    let end = this.v.length;

    while (swapped) {
      swapped = false;

      for (let i = start; i < end; ++i) {
        this.status[i] = 4;

        if (this.v[i] > this.v[i + 1]) {
          await this.swap(i, i + 1);
          swapped = true;
        } else 
            await sleep();
        
        this.status[i] = 0;
      }
      if (!swapped)
        break;

      swapped = false;

      --end;

      for (let i = end - 1; i >= start; --i) {
        this.status[i + 1] = 2;

        if (this.v[i] > this.v[i + 1]) {
          await this.swap(i, i + 1);
          swapped = true;
        } else 
            await sleep();
        
        this.status[i + 1] = 0;
      }

      ++start;

    }

    console.log("Cocktail Sort : Done");

    return true;
  }

  async swap(i, j) {
    await sleep();

    let aux = this.v[i];
    this.v[i] = this.v[j];
    this.v[j] = aux;
  }

}