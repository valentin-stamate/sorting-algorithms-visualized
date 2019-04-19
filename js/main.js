'use strict';
let v = new Array();
let status = new Array();
// 0 - normal , 1 - pivot, 2 - line to switch, 3 - where it goes?
let line_w = 4; //line width
let arraySize, sector;
let algorithmType = 'none';
let isStarted = false;
let isSorted = false;
sector = line_w + 2;
let sleepTime = 1;

let sort;//sort object

function setup() {
  let canvas = createCanvas(800, 400);
  canvas.parent('screen');
  background(20);
  frameRate(60);

  reset();
}

function draw() {
  background(20);

  for (let i = 0; i < arraySize; i++) {
    switch (status[i]) {
      case 0:
        stroke(255); break;
      case 1:
        stroke(63, 237, 124); break;
      case 2:
        stroke(237, 64, 64); break;
      case 3:
        stroke(74, 163, 247); break;
      case 4:
        stroke("#f789ff"); break;
    }
    strokeWeight(line_w);
    line(i * sector + 4 * line_w, height - line_w, i * sector + 4 * line_w, height - v[i] - line_w);
  }

}

function checkAlgorithm(type) {
  if (type === 'selection') {//done

    if (!isStarted) {
      sort = new SelectionSort(v, status);
      sort.Sort();

      isStarted = true;
    }

  } else if (type === 'bubble') {//done
    if (!isStarted) {
      sort = new BubbleSort(v, status);
      sort.Sort();

      isStarted = true;
    }

  } else if (type === 'insertion') {//done
    if (!isStarted) {
      sort = new InsertionSort(v, status);
      sort.Sort();

      isStarted = true;
    }
  } else if (type === 'quick') {//done
    if (!isStarted) {
      sort = new QuickSort(v, status);
      sort.Sort(0, arraySize - 1);

      isStarted = true;
    }
  } else if (type === 'cocktail') {//done
    if (!isStarted) {
      sort = new CockTailSort(v, status);
      isStarted = true;

      sort.Sort();
    }
    if (sort.finished)
      alg_finished = true;

  } else if (type === 'merge') {//merge
    if (!isStarted) {
      sort = new MergeSort(v, status);
      isStarted = true;

      sort.Sort(0, arraySize - 1);
    }

  } else if (type === 'heap') {//done
    if (!isStarted) {
      sort = new HeapSort(v, status);
      isStarted = true;

      sort.Sort();
    }
    if (sort.finished)
      alg_finished = true;

  } else if (type === 'radix') {//done
    if (!isStarted) {
      sort = new RadixSort(v, status);
      isStarted = true;

      sort.Sort(arraySize);
    }

  } else if (type === 'shell') {//done
    if (!isStarted) {
      sort = new ShellSort(v, status);
      isStarted = true;

      sort.Sort();
    }

  } else if (type === 'gnome') {//done
    if (!isStarted) {
      sort = new GnomeSort(v, status);
      isStarted = true;

      sort.Sort(arraySize);
    }
    if (sort.finished)
      alg_finished = true;
  } else if (type === 'bitonic') {//done
    //must use a power of 2
    if (!isStarted) {
      sort = new BitonicSort(v, status);
      isStarted = true;

      sort.Sort(arraySize, 1);
    }
    if (sort.finished)
      alg_finished = true;

  } else if (type === 'bogo') {
    if (!isStarted) {
      sort = new BogoSort(v, status);
      isStarted = true;

      sort.Sort();
    }

  } else if (type === 'none') {
    if (!isStarted) {
      console.log("Select Algorithm");
      isStarted = true;
    }
  } else {
    if (!isStarted) {
      console.log("Don't try to hack me ;)");
      isStarted = true;
    }
  }

}

function sleep() {
  return new Promise(resolve => setTimeout(resolve, sleepTime));
}

function setAlgorithm(id) {
  algorithmType = id;
  console.log(id);
}
// fun stuff

function start() {
  reset();

  if (!isStarted) {
    sort = new SelectionSort(v, status);
    sort.Sort();
    console.log('ceva');

  }

}

function simulate() {
  if (!isStarted) {
    sort = new QuickSort(v, status);
    sort.Sort(0, arraySize - 1);

    isStarted = true;
  }
}

function reset() {
  arraySize = 0;

  arraySize = parseInt(width / sector) - 2;
  for (let i = 0; i < arraySize; i++) {
    v[i] = parseInt(random(height - 30));
    status[i] = 0;
  }


  // for (let i = 0; i < arraySize; i++) {
  //   v[i] = parseInt(random(height - 30));
  //   status[i] = 0;
  // }

  // sleepTime = 0;
}