class GnomeSort {
  constructor(size) {
    this.v = v;
    this.status = status;
  }

  async Sort(n) {
    let index = 0;

    while (index < n) {
      if (index == 0)
        index++;  
      if (this.v[index] >= this.v[index - 1])
        index++;
      else {
        this.status[index] = 2;
        await sleep();
        let temp = 0;
        temp = this.v[index];
        this.v[index] = this.v[index - 1];
        this.v[index - 1] = temp;
        this.status[index] = 0;
        index--;
      }
    }
    console.log("Gnome Sort : Done");
    return;
  }

}