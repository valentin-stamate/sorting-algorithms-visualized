class MergeSort {
  constructor(size) {
    this.status = new Array();
    this.status = [size];
    this.sleepTime = 10;//(ms)
    for (let i = 0; i < size; i++)
      this.status[i] = 0;

    this.finished = false;
  }

  async Sort(v, l, r) {
    if (l < r) {
      let m = parseInt((l + r) / 2);
      
      await this.Sort(v, l, m);
      await this.Sort(v, m + 1, r);

      await this.merge(v, l, m, r);
    }
  }

  async merge(v, l, m, r) {
    this.status[r] = 1;
    let i, j, k;
    let n1 = m - l + 1;
    let n2 = r - m;

    let L = [n1], R = [n2];


    for (i = 0; i < n1; i++)
      L[i] = v[l + i];
    for (j = 0; j < n2; j++)
      R[j] = v[m + 1 + j];


    i = 0;
    j = 0;
    k = l;
    while (i < n1 && j < n2) {
      this.status[k] = 2;
      if (L[i] <= R[j]) {
        await this.sleep(this.sleepTime);//
        v[k] = L[i];
        i++;
      }
      else {
        await this.sleep(this.sleepTime);//
        v[k] = R[j];
        j++;
      }
      this.status[k] = 0;
      k++;
      
    }
    /* Copy remaining elements of L[] if any */
    while (i < n1) {
      await this.sleep(this.sleepTime);//
      v[k] = L[i];
      i++;
      k++;
    }
    /* Copy remaining elements of R[] if any */
    while (j < n2) {
      await this.sleep(this.sleepTime);//
      v[k] = R[j];
      j++;
      k++;
    }
    this.status[r] = 0;
    this.status[r] = 0;
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