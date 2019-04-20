class RadixSort {
  constructor() {
  }

  async Sort(n) {
    let m = this.getMax(n);

    for (let exp = 1; parseInt(m / exp) > 0  && isStarted; exp *= 10)
      await this.countSort(n, exp);
  }

  async countSort(n, exp) {
    let output = [n]; 
    let i;
    let count = [10];
    for (let i = 0; i < 10; i++)
      count[i] = 0;

    for (i = 0; i < n && isStarted; i++)
      count[(parseInt( v[i] / exp) ) % 10]++;

    for (i = 1; i < 10; i++)
      count[i] += count[i - 1];

    for (i = n - 1; i >= 0 && isStarted; i--) {
      output[count[parseInt(v[i] / exp) % 10] - 1] = v[i];
      count[parseInt(v[i] / exp) % 10]--;
    }

    for (i = 0; i < n && isStarted; i++){

      status[i - 1] = 0;
      status[i] = 1;

      await sleep();

      v[i] = output[i];
    }
    status[n-1] = 0;
  }

  getMax(n) {
    let mx = v[0];
    
    for (let i = 1; i < n && isStarted; i++)
      if (v[i] > mx)
        mx = v[i];
    return mx;
  }

}