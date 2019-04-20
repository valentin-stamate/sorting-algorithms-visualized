class ShellSort {
  constructor() {
  }

  async Sort() {
    let n = v.length;

    for (let gap = parseInt(n / 2); gap > 0; gap = parseInt(gap / 2)) {
      
      for (let i = gap; i < n && isStarted; i++) {
        let temp = v[i];
        let j;

        for (j = i; j >= gap && v[j - gap] > temp && isStarted; j -= gap) {
          status[j] = 1;
          status[j - gap] = 2;

          await sleep();

          v[j] = v[j - gap];

          status[j] = 0;
          status[j - gap] = 0;
        }
        v[j] = temp;
      }
    }

    console.log("Shell Sort : Done");
    return;

  }

}