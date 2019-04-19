class InsertionSort {
  constructor(v, status) {
    this.v = v;
    this.status = status;
  }

  async Sort() {
    let n = this.v.length;
    for (let i = 1; i < n; ++i) {
      let key = this.v[i];
      let j = i - 1;

      while (j >= 0 && this.v[j] > key) {
        this.status[j + 1] = 2;

        await sleep();
        this.v[j + 1] = this.v[j];

        this.status[j + 1] = 0;
        j = j - 1;
      }
      this.v[j + 1] = key;
    }
    console.log("Insertion Sort : Done");
    return;
  }

  async swap(i, j) {
    await sleep();

    let aux = this.v[i];
    this.v[i] = this.v[j];
    this.v[j] = aux;
  }

}