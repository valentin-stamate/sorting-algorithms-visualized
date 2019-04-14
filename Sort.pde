class Sort{
  Sort() {
   
  }
 
 
 
  void swap(int v[], int i, int j) {
    int aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }
}
