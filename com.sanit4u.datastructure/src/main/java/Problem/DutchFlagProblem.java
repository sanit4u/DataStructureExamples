package Problem;

import java.util.Arrays;

public class DutchFlagProblem {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

		dutchNationalFlag(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 0,1,2s arrays, sort it in O(n) and space complexity O(1).
	 * 
	 * @param array
	 */
	public static void dutchNationalFlag(int[] array) {

		// divide the array into 3 parts.
		// take pivot as 1 and assign less than pivot elements into the first part of
		// the array and greater than elements to the last part of the array.

		int high = array.length - 1, low = 0, mid = 0, temp;
		while (mid <= high) {

			switch (array[mid]) {
			case 0:
				// if 0, then swap it with the low [part] index, if its same(0), then no need to
				// swap, just increase the indices.
				if (array[low] != array[mid]) {
					temp = array[low];
					array[low] = array[mid];
					array[mid] = temp;
				}

				low++;
				mid++;
				break;
			case 1: // if its 1, then just increase the mid
				mid++;
				break;
			case 2:
				// if 2, then assign to high part. and increase the high index
				if (array[high] != array[mid]) {
					temp = array[high];
					array[high] = array[mid];
					array[mid] = temp;
				}

				high--;
				break;
			}
		}

	}
}
