class ShellSort {
  constructor(size) {
    this.status = new Array();
    this.status = [size];
    this.sleepTime = 20;//(ms)
    for (let i = 0; i < size; i++)
      this.status[i] = 0;

    this.finished = false;
  }

  async Sort(v) {
    let n = v.length;

    for (let gap = parseInt(n / 2); gap > 0; gap = parseInt(gap / 2)) {
      for (let i = gap; i < n; i++) {
        let temp = v[i];
        let j;
        for (j = i; j >= gap && v[j - gap] > temp; j -= gap) {
          this.status[j] = 1;
          this.status[j - gap] = 2;
          await this.sleep(this.sleepTime);
          v[j] = v[j - gap];
          this.status[j] = 0;
          this.status[j - gap] = 0;
        }
        v[j] = temp;
      }
    }

    this.finished = true;

  }

  sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

}