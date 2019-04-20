class BubbleSort {
  constructor() {
  }

  async Sort() {
    let n = v.length;
    for (let i = 0; i < n - 1; i++) {
      for (let j = 0; j < n - i - 1; j++) {
        if (v[j] > v[j + 1]) {
          status[j] = 2;
          await this.swap(j, j + 1);
          status[j] = 0;
        }
      }
    }
    console.log("Bubble Sort : Done");
    return;
  }

  async swap(i, j) {
    await sleep();
    
    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }

}