class ShellSort {
  constructor(v, status) {
    this.v = v;
    this.status = status;
  }

  async Sort() {
    let n = this.v.length;

    for (let gap = parseInt(n / 2); gap > 0; gap = parseInt(gap / 2)) {
      
      for (let i = gap; i < n; i++) {
        let temp = this.v[i];
        let j;

        for (j = i; j >= gap && this.v[j - gap] > temp; j -= gap) {
          this.status[j] = 1;
          this.status[j - gap] = 2;

          await sleep();

          this.v[j] = this.v[j - gap];

          this.status[j] = 0;
          this.status[j - gap] = 0;
        }
        this.v[j] = temp;
      }
    }

    console.log("Shell Sort : Done");
    return;

  }

}