class BitonicSort {
  constructor(v, status) {
    this.v = v;
    this.status = status;
  }

  async Sort(n, up) {
    await this.bitonicSort(0, n, up);
  }

  async bitonicSort(low, cnt, dir) {
    if (cnt > 1) {
      let k = parseInt(cnt / 2);

      await this.bitonicSort(low, k, 1);

      await this.bitonicSort(low + k, k, 0);
      await this.bitonicMerge(low, cnt, dir);
    }
  }

  async bitonicMerge(low, cnt, dir) {
    if (cnt > 1) {
      let k = parseInt(cnt / 2);
      for (let i = low; i < low + k; i++) {

        this.status[i] = 2;
        this.status[i + k] = 4;

        await this.compAndSwap(i, i + k, dir);

        this.status[i] = 0;
        this.status[i + k] = 0;
        
      }
      await this.bitonicMerge(low, k, dir);
      await this.bitonicMerge(low + k, k, dir);
    }
  }

  async compAndSwap(i, j, dir) {
    await sleep();
    if ((this.v[i] > this.v[j] && dir == 1) ||
      (this.v[i] < this.v[j] && dir == 0)) {

      let temp = this.v[i];
      this.v[i] = this.v[j];
      this.v[j] = temp;
    }
  }
  
}