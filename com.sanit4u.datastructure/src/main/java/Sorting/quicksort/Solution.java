package Sorting.quicksort;

/**
 * Quicksort main thing is to find the pivot element
 * 
 * @author rsa
 *
 */
public class Solution {
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7, 15 };
		quicksort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	static void quicksort(int[] arr, int begin, int end) {
		if (end <= begin) {
			return;
		}

		int pivotIndex = partition(arr, begin, end);
		quicksort(arr, begin, pivotIndex - 1);
		quicksort(arr, pivotIndex + 1, end);
	}

	/**
	 * 
	 * @param arr
	 * @param begin
	 * @param end
	 * @return
	 */
	static int partition(int[] arr, int begin, int end) {
		// first select the end element as pivot
		int pivot = end;

		// think as before begin element, all are less than pivot.
		int counter = begin;

		// traverse through the array and check whether the traversing element is lesser
		// than the pivot element. if yes, then move it to the left partition as swaping
		// it to the counter(being)[remember 2nd line of this method.]
		for (int i = begin; i < end; i++) {
			if (arr[i] < arr[pivot]) {
				int temp = arr[counter];
				arr[counter] = arr[i];
				arr[i] = temp;
				counter++;
			}
		}

		// after the traversal and checking of element, swap the pivot with the counter
		// indexed element to set the next counter.
		int temp = arr[pivot];
		arr[pivot] = arr[counter];
		arr[counter] = temp;

		return counter;
	}
}
