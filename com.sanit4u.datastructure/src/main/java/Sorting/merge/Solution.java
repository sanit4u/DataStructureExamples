package Sorting.merge;

public class Solution {

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7, 15 };
		mergeSort(arr, 0, arr.length - 1);

		for (int i : arr) {
			System.out.println(i);
		}
	}

	static void mergeSort(int[] array, int start, int end) {

		if (end <= start)
			return;

		int mid = (start + end) / 2;
		mergeSort(array, start, mid);
		mergeSort(array, mid + 1, end);
		merge(array, start, mid, end);

	}

	private static void merge(int[] array, int start, int mid, int end) {

		int lengthLeftArray = mid - start + 1;
		int lengthRightArray = end - mid;

		int[] leftArray = new int[lengthLeftArray];
		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = array[start + i];
		}

		int[] rightArray = new int[lengthRightArray];

		for (int i = 0; i < lengthRightArray; i++) {
			rightArray[i] = array[mid + i + 1];
		}

		int leftIndex, rightIndex;
		leftIndex = rightIndex = 0;

		// copying from leftArray and rightArray back into array
		for (int i = start; i <= end; i++) {

			// if there are still uncopied elements in R and L, copy minimum of the two
			if (leftIndex < lengthLeftArray && rightIndex < lengthRightArray) {
				if (leftArray[leftIndex] < rightArray[rightIndex]) {
					array[i] = leftArray[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
			}

			// if all the elements have been copied from rightArray, copy the rest of
			// leftArray
			else if (leftIndex < lengthLeftArray) {
				array[i] = leftArray[leftIndex];
				leftIndex++;
			}

			// if all the elements have been copied from leftArray, copy the rest of
			// rightArray
			else if (rightIndex < lengthRightArray) {
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}

}
