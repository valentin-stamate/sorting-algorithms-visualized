class RadixSort {
  constructor(v, status) {
    this.v = v;
    this.status = status;
  }

  async Sort(n) {
    let m = this.getMax(n);

    for (let exp = 1; parseInt(m / exp) > 0; exp *= 10)
      await this.countSort(n, exp);
  }

  async countSort(n, exp) {
    let output = [n]; 
    let i;
    let count = [10];
    for (let i = 0; i < 10; i++)
      count[i] = 0;

    for (i = 0; i < n; i++)
      count[(parseInt( this.v[i] / exp) ) % 10]++;

    for (i = 1; i < 10; i++)
      count[i] += count[i - 1];

    for (i = n - 1; i >= 0; i--) {
      output[count[parseInt(this.v[i] / exp) % 10] - 1] = this.v[i];
      count[parseInt(this.v[i] / exp) % 10]--;
    }

    for (i = 0; i < n; i++){

      this.status[i - 1] = 0;
      this.status[i] = 1;

      await sleep();

      this.v[i] = output[i];
    }
    this.status[n-1] = 0;
  }

  getMax(n) {
    let mx = this.v[0];
    
    for (let i = 1; i < n; i++)
      if (this.v[i] > mx)
        mx = this.v[i];
    return mx;
  }

}