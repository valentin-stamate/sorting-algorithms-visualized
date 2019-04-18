class BogoSort {
  constructor(size) {
    this.status = new Array();
    this.status = [size];
    this.sleepTime = 1;//(ms)
    for (let i = 0; i < size; i++)
      this.status[i] = 0;

    this.finished = false;
  }

  async Sort(v) {

    while (!this.isSorted(v)){
      await this.shuffle(v);
    }
  }

  async shuffle(v) {
    for (let i = 1; i <= v.length - 1; i++){
      await this.swap(v, i, parseInt(random(0, 1) * i));
    }
  }

  isSorted(v) {
    for (let i = 0; i < v.length - 1; i++)
      if (v[i] > v[i - 1])
        return false;
    return true;
  }

  async swap(v, i, j) {
    this.status[i] = 2;
    this.status[j] = 2;
    await this.sleep(this.sleepTime);
    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;
    this.status[i] = 0;
    this.status[j] = 0;
  }

  sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

}