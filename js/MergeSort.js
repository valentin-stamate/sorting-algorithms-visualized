class MergeSort {
  constructor(v, status) {
    this.v = v;
    this.status = status;
  }

  async Sort(l, r) {
    if (l < r) {
      let m = parseInt((l + r) / 2);
      
      await this.Sort(l, m);
      await this.Sort(m + 1, r);

      await this.merge(l, m, r);
    }
  }

  async merge(l, m, r) {
    this.status[r] = 1;
    let i, j, k;
    let n1 = m - l + 1;
    let n2 = r - m;

    let L = [n1], R = [n2];


    for (i = 0; i < n1; i++)
      L[i] = this.v[l + i];
    for (j = 0; j < n2; j++)
      R[j] = this.v[m + 1 + j];


    i = 0;
    j = 0;
    k = l;
    while (i < n1 && j < n2) {
      this.status[k] = 2;
      if (L[i] <= R[j]) {
        await sleep();
        this.v[k] = L[i];
        i++;
      }
      else {
        await sleep();
        this.v[k] = R[j];
        j++;
      }
      this.status[k] = 0;
      k++;
      
    }
    /* Copy remaining elements of L[] if any */
    while (i < n1) {
      await sleep();//
      this.v[k] = L[i];
      i++;
      k++;
    }
    /* Copy remaining elements of R[] if any */
    while (j < n2) {
      await sleep();
      this.v[k] = R[j];
      j++;
      k++;
    }
    this.status[r] = 0;
  }

}