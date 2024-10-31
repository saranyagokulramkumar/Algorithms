/*
Quick sort implementation:
1. Find a pivot and partition the array with elements < pivot on the left and elements > pivot on the right
2. recursively call quickSort on the left subarray of pivot and right subarray of pivot.

Time complexity = O(NlogN)
Space complexity = O(1), not computing the recursive stack space needed for the recursive calls
 */

public class QuickSort {
    public int[] quickSort(int[] arr, int low, int high){
        if(low < high){
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
        return arr;
    }

    private int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i < j){
            while(arr[i] <= pivot && i < high){
                i++;
            }

            while(arr[j] > pivot && j > low){
                j--;
            }

            if(i < j){
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
