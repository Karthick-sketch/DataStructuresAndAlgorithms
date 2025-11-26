package algorithms.sort;

public class MergeSort implements Sort {
  @Override
  public void sort(int[] array) {
    mergeSort(array);
  }

  private void mergeSort(int[] array) {
    int len = array.length;
    if (len <= 1) {
      return;
    }
    int mid = len / 2;
    int[] left = new int[mid];
    int[] right = new int[len - mid];
    int i = 0;
    for (int l = 0; i < mid; l++, i++) {
      left[l] = array[i];
    }
    for (int r = 0; i < len; r++, i++) {
      right[r] = array[i];
    }
    mergeSort(left);
    mergeSort(right);
    merge(left, right, array);
  }

  private void merge(int[] left, int[] right, int[] array) {
    int lSize = array.length / 2;
    int rSize = array.length - lSize;
    int i = 0, l = 0, r = 0;
    for (; l < lSize && r < rSize; i++) {
      if (left[l] < right[r]) {
        array[i] = left[l];
        l++;
      } else {
        array[i] = right[r];
        r++;
      }
    }
    for (; l < left.length; l++, i++) {
      array[i] = left[l];
    }
    for (; r < right.length; r++, i++) {
      array[i] = right[r];
    }
  }
}
