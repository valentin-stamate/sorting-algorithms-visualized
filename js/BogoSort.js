class BogoSort {
  constructor() {
    
  }

  async Sort() {
    while (!this.isSorted() && isStarted){
      await this.shuffle();
    }
  }

  async shuffle() {
    for (let i = 1; i < v.length && isStarted; i++){
      await this.swap(i, parseInt(random(0, 1) * i));
    }
  }

  isSorted() {
    for (let i = 0; i < v.length - 1; i++)
      if (v[i] > v[i - 1])
        return false;
    return true;
  }

  async swap(i, j) {
    status[i] = 2;
    status[j] = 2;

    await sleep();

    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;

    status[i] = 0;
    status[j] = 0;
  }

}