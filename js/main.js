'use strict';
let v = new Array();
let status = new Array();

let lineWidth = 2;
let sector = lineWidth + 1;
let arraySize = 256;
let algorithmType = 'none';
let isStarted = false;
let sleepTime = 10;

let sort;//sort object

function setup() {
  let canvas = createCanvas(772, 400);
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
    strokeWeight(lineWidth);
    line((i + 1) * sector, height - 3, (i + 1) * sector, height - v[i] - 3);
  }

}

function checkAlgorithm(type) {
  if (type === 'selection') {

    if (!isStarted) {
      sort = new SelectionSort();
      sort.Sort();
      isStarted = true;
    }

  } else if (type === 'bubble') {
    if (!isStarted) {
      sort = new BubbleSort(v, status);
      sort.Sort();

      isStarted = true;
    }

  } else if (type === 'insertion') {
    if (!isStarted) {
      sort = new InsertionSort(v, status);
      sort.Sort();

      isStarted = true;
    }
  } else if (type === 'quick') {
    if (!isStarted) {
      sort = new QuickSort();
      sort.Sort(0, arraySize - 1);

      isStarted = true;
    }
  } else if (type === 'cocktail') {
    if (!isStarted) {
      sort = new CockTailSort();
      isStarted = true;

      sort.Sort();
    }
    if (sort.finished)
      alg_finished = true;

  } else if (type === 'merge') {
    if (!isStarted) {
      sort = new MergeSort();
      isStarted = true;

      sort.Sort(0, arraySize - 1);
    }

  } else if (type === 'heap') {
    if (!isStarted) {
      sort = new HeapSort();
      isStarted = true;

      sort.Sort();
    }

  } else if (type === 'radix') {
    if (!isStarted) {
      sort = new RadixSort();
      isStarted = true;

      sort.Sort(arraySize);
    }

  } else if (type === 'shell') {
    if (!isStarted) {
      sort = new ShellSort(v, status);
      isStarted = true;

      sort.Sort();
    }

  } else if (type === 'gnome') {
    if (!isStarted) {
      sort = new GnomeSort(v, status);
      isStarted = true;

      sort.Sort(arraySize);
    }
    if (sort.finished)
      alg_finished = true;
  } else if (type === 'bitonic') {
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
    }
  } else {
    if (!isStarted) {
      console.log("Don't try to hack me ;)");
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

function start() {
  if (!isStarted) {
    
    sleepTime = parseInt(document.getElementById('duration').value);
    
    if (sleepTime > 1000 && sleepTime <= 0) {
      sleepTime = 10;
    }

    checkAlgorithm(algorithmType);
  }
}

async function reset() {
  isStarted = false;
  v = [0];

  await sleep();
  await sleep();

  //arraySize = parseInt(width / sector) - 1;
  v = [arraySize];

  for (let i = 0; i < arraySize; i++) {
    v[i] = parseInt(random(height - 30));
    status[i] = 0;
  }

}