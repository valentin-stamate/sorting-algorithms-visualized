class BogoSort {
  constructor(v, status) {
    this.v = v;
    this.status = status;
    
  }

  async Sort() {
    while (!this.isSorted()){
      await this.shuffle();
    }
  }

  async shuffle() {
    for (let i = 1; i < this.v.length; i++){
      await this.swap(i, parseInt(random(0, 1) * i));
    }
  }

  isSorted() {
    for (let i = 0; i < this.v.length - 1; i++)
      if (this.v[i] > this.v[i - 1])
        return false;
    return true;
  }

  async swap(i, j) {
    this.status[i] = 2;
    this.status[j] = 2;

    await sleep();

    let aux = this.v[i];
    this.v[i] = this.v[j];
    this.v[j] = aux;

    this.status[i] = 0;
    this.status[j] = 0;
  }

}