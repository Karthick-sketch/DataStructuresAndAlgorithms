package algorithms.sort;

public class Sort {

  /* 1. Bubble Sort */
  public static void bubbleSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < array.length - i; j++) {
        if (array[j] > array[j + 1]) {
          int v = array[j];
          array[j] = array[j + 1];
          array[j + 1] = v;
        }
      }
    }
  }

  /* 2. Selection Sort */
  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[min]) {
          min = j;
        }
      }
      int temp = array[min];
      array[min] = array[i];
      array[i] = temp;
    }
  }

  /* 3. Insertion Sort */
  public static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int temp = array[i];
      int j = i - 1;
      for (; j >= 0 && array[j] > temp; j--) {
        array[j + 1] = array[j];
      }
      array[j + 1] = temp;
    }
  }

  /* 4. Merge Sort */
  public static void mergeSort(int[] array) {
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

  private static int[] merge(int[] left, int[] right, int[] array) {
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
    return array;
  }

  /* 5. Quick Sort */
  public static void quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  private static void quickSort(int[] array, int start, int end) {
    if (end <= start) {
      return;
    }
    int pivot = partition(array, start, end);
    quickSort(array, start, pivot - 1);
    quickSort(array, pivot + 1, end);
  }

  private static int partition(int[] array, int start, int end) {
    int pivot = array[end];
    int i = start - 1;
    for (int j = start; j < end; j++) {
      if (array[j] < pivot) {
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    i++;
    int temp = array[i];
    array[i] = array[end];
    array[end] = temp;
    return i;
  }
}
