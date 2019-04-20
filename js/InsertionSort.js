class InsertionSort {
  constructor() {
  }

  async Sort() {
    let n = v.length;
    for (let i = 1; i < n; ++i) {
      let key = v[i];
      let j = i - 1;

      while (j >= 0 && v[j] > key) {
        status[j + 1] = 2;

        await sleep();
        v[j + 1] = v[j];

        status[j + 1] = 0;
        j = j - 1;
      }
      v[j + 1] = key;
    }
    console.log("Insertion Sort : Done");
    return;
  }

  async swap(i, j) {
    await sleep();

    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }

}