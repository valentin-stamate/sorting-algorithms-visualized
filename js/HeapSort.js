class HeapSort {
  constructor(size) {
    this.status = new Array();
    this.status = [size];
    this.sleepTime = 10;//(ms)
    for (let i = 0; i < size; i++)
      this.status[i] = 0;

    this.finished = false;
  }

  async Sort(v) {
    let n = this.status.length;

    for (let i = parseInt(n / 2) - 1; i >= 0; i--) {
      await this.heapify(v, n, i);
    }

    for (let i = n - 1; i >= 0; i--) {
      await this.swap(v, 0, i);//

      await this.heapify(v, i, 0);
    }
  }

  async heapify(v, n, i) {
    this.status[n] = 1;

    let largest = i;
    let l = 2 * i + 1
    let r = 2 * i + 2;
    this.status[r] = 3;

    if (l < n && v[l] > v[largest])
      largest = l;

    if (r < n && v[r] > v[largest])
      largest = r;

    if (largest != i) {
      await this.swap(v, i, largest);//
      await this.heapify(v, n, largest);
    }

    this.status[r] = 0;
    this.status[n] = 0;
  }

  async swap(v, i, j) {
    await this.sleep(this.sleepTime);
    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }

  sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

}