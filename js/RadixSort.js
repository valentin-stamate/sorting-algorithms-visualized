class RadixSort {
  constructor(size) {
    this.status = new Array();
    this.status = [size];
    this.sleepTime = 15;//(ms)
    for (let i = 0; i < size; i++)
      this.status[i] = 0;

    this.finished = false;
  }

  async Sort(v, n) {
    let m = this.getMax(v, n);

    for (let exp = 1; parseInt(m / exp) > 0; exp *= 10)
      await this.countSort(v, n, exp);
  }

  async countSort(v, n, exp) {
    let output = [n]; // output array 
    let i;
    let count = [10];
    for (let i = 0; i < 10; i++)
      count[i] = 0;

    for (i = 0; i < n; i++)
      count[(parseInt( v[i] / exp) ) % 10]++;

    for (i = 1; i < 10; i++)
      count[i] += count[i - 1];

    for (i = n - 1; i >= 0; i--) {
      output[count[parseInt(v[i] / exp) % 10] - 1] = v[i];
      count[parseInt(v[i] / exp) % 10]--;
    }

    for (i = 0; i < n; i++){
      this.status[i - 1] = 0;
      this.status[i] = 1;
      await this.sleep(this.sleepTime);
      v[i] = output[i];
    }
    this.status[n-1] = 0;
  }

  getMax(v, n) {
    let mx = v[0];
    for (let i = 1; i < n; i++)
      if (v[i] > mx)
        mx = v[i];
    return mx;
  }

  sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

}