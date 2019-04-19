class QuickSort {
  constructor(v, status) {
    this.v = v;
    this.status = status;
  }
  // weird stuff going here
  async Sort(low, high) {
    if (low < high) {
      let pi = await this.partition(low, high);

      await this.Sort(low, pi - 1);
      await this.Sort(pi + 1, high);
    }
  }

  async partition(low, high) {
    let pivot = this.v[high];
    let i = (low - 1);
    for (let j = low; j < high; j++) {

      if (this.v[j] <= pivot) {

        for (let l = i + 1; l < j; l++)
          this.status[l] = 3;

        this.status[i] = 1;
        this.status[j] = 2;
        i++;
        
        await this.swap(i, j);

        for (let l = i; l < j; l++)
          this.status[l] = 0;
        this.status[i - 1] = 0;
        this.status[j] = 0;
      }

    }

    let temp = this.v[i + 1];
    this.v[i + 1] = this.v[high];
    this.v[high] = temp;

    return i + 1;
  }

  async swap(i, j) {
    await sleep();

    let aux = this.v[i];
    this.v[i] = this.v[j];
    this.v[j] = aux;
  }

}