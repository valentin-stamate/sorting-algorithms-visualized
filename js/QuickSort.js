class QuickSort {
  constructor() {
  }
  // weird stuff going here
  async Sort(low, high) {
    if (low < high) {
      let pi = await this.partition(low, high);

      await this.Sort(low, pi - 1);
      await this.Sort(pi + 1, high);
    }
  }

  async partition(low, high) {
    let pivot = v[high];
    let i = (low - 1);
    for (let j = low; j < high; j++) {

      if (v[j] <= pivot) {

        for (let l = i + 1; l < j; l++)
          status[l] = 3;

        status[i] = 1;
        status[j] = 2;
        i++;
        
        await this.swap(i, j);

        for (let l = i; l < j; l++)
          status[l] = 0;
        status[i - 1] = 0;
        status[j] = 0;
      }

    }

    let temp = v[i + 1];
    v[i + 1] = v[high];
    v[high] = temp;

    return i + 1;
  }

  async swap(i, j) {
    await sleep();

    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }

}