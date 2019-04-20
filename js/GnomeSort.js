class GnomeSort {
  constructor() {
  }

  async Sort(n) {
    let index = 0;

    while (index < n && isStarted) {
      if (index == 0)
        index++;  
      if (v[index] >= v[index - 1])
        index++;
      else {
        status[index] = 2;
        await sleep();
        let temp = 0;
        temp = v[index];
        v[index] = v[index - 1];
        v[index - 1] = temp;
        status[index] = 0;
        index--;
      }
    }
    console.log("Gnome Sort : Done");
    return;
  }

}