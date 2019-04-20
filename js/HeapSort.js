class HeapSort {
  constructor() {
  }

  async Sort() {
    let n = v.length;

    for (let i = parseInt(n / 2) - 1; i >= 0 && isStarted; i--) {
      await this.heapify(n, i);
    }

    for (let i = n - 1; i >= 0 && isStarted; i--) {
      await this.swap(0, i);

      await this.heapify(i, 0);
    }
  }

  async heapify(n, i) {
    status[n] = 1;

    let largest = i;
    let l = 2 * i + 1
    let r = 2 * i + 2;

    status[r] = 2;

    if (l < n && v[l] > v[largest])
      largest = l;

    if (r < n && v[r] > v[largest])
      largest = r;

    if (largest != i) {
      await this.swap(i, largest);

      await this.heapify(n, largest);
    }

    status[r] = 0;
    status[n] = 0;
  }

  async swap(i, j) {
    await sleep();

    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }

}