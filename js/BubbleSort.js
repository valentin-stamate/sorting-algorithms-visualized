class BubbleSort {
  constructor(v, status) {
    this.v = v;
    this.status = status;
  }

  async Sort() {
    let n = this.v.length;
    for (let i = 0; i < n - 1; i++) {
      for (let j = 0; j < n - i - 1; j++) {
        if (this.v[j] > this.v[j + 1]) {
          this.status[j] = 2;
          await this.swap(j, j + 1);
          this.status[j] = 0;
        }
      }
    }
    console.log("Bubble Sort : Done");
    return;
  }

  async swap(i, j) {
    await sleep();
    
    let aux = this.v[i];
    this.v[i] = this.v[j];
    this.v[j] = aux;
  }

}