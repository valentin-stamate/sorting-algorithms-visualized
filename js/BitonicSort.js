class BitonicSort {
  constructor() {
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
      for (let i = low; i < low + k && isStarted; i++) {

        status[i] = 2;
        status[i + k] = 4;

        await this.compAndSwap(i, i + k, dir);

        status[i] = 0;
        status[i + k] = 0;
        
      }
      await this.bitonicMerge(low, k, dir);
      await this.bitonicMerge(low + k, k, dir);
    }
  }

  async compAndSwap(i, j, dir) {
    await sleep();
    if ((v[i] > v[j] && dir == 1) ||
      (v[i] < v[j] && dir == 0)) {

      let temp = v[i];
      v[i] = v[j];
      v[j] = temp;
    }
  }
  
}