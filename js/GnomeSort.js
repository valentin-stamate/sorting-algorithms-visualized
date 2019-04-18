class GnomeSort {
  constructor(size) {
    this.status = new Array();
    this.status = [size];
    this.sleepTime = 50;//(ms)
    for (let i = 0; i < size; i++)
      this.status[i] = 0;

    this.finished = false;
  }

  async Sort(v, n) {
    let index = 0;

    while (index < n) {
      if (index == 0)
        index++;  
      if (v[index] >= v[index - 1])
        index++;
      else {
        this.status[index] = 1;
        await this.sleep(this.sleepTime);
        let temp = 0;
        temp = v[index];
        v[index] = v[index - 1];
        v[index - 1] = temp;
        this.status[index] = 0;
        index--;
      }
    }
    this.finished = true;
    return;
  }

  sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

}