class BitonicSort {
  constructor(size) {
    this.status = new Array();
    this.status = [size];
    this.sleepTime = 50;//(ms)
    for (let i = 0; i < size; i++)
      this.status[i] = 0;

    this.finished = false;
  }

  compAndSwap(v, i, j, dir) {
    if ((v[i] > v[j] && dir == 1) ||
      (v[i] < v[j] && dir == 0)) {

      let temp = v[i];
      v[i] = v[j];
      v[j] = temp;
    }
  }

  bitonicMerge(v, low, cnt, dir) {
    if (cnt > 1) {
      let k = parseInt(cnt / 2); ////////////
      for (let i = low; i < low + k; i++)
        this.compAndSwap(v, i, i + k, dir);
      this.bitonicMerge(v, low, k, dir);
      this.bitonicMerge(v, low + k, k, dir);
    }
  }

  bitonicSort(v, low, cnt, dir) {
    if (cnt > 1) {
      let k = parseInt(cnt / 2); /////
      
      this.bitonicSort(v, low, k, 1);

      this.bitonicSort(v, low + k, k, 0);
      this.bitonicMerge(v, low, cnt, dir);
    }
  }

  Sort(v, n, up) {
    this.bitonicSort(v, 0, n, up);
  }

  sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

}