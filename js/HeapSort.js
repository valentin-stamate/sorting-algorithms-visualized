class HeapSort {
  constructor(v, status) {
    this.v = v;
    this.status = status;

  }

  async Sort() {
    let n = this.v.length;

    for (let i = parseInt(n / 2) - 1; i >= 0; i--) {
      await this.heapify(n, i);
    }

    for (let i = n - 1; i >= 0; i--) {
      await this.swap(0, i);

      await this.heapify(i, 0);
    }
  }

  async heapify(n, i) {
    this.status[n] = 1;

    let largest = i;
    let l = 2 * i + 1
    let r = 2 * i + 2;

    this.status[r] = 2;

    if (l < n && this.v[l] > this.v[largest])
      largest = l;

    if (r < n && v[r] > this.v[largest])
      largest = r;

    if (largest != i) {
      await this.swap(i, largest);

      await this.heapify(n, largest);
    }

    this.status[r] = 0;
    this.status[n] = 0;
  }

  async swap(i, j) {
    await sleep();

    let aux = this.v[i];
    this.v[i] = this.v[j];
    this.v[j] = aux;
  }

}