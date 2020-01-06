package Search.binary;

/**
 * Binary search can only be applied in a sorted array to get logN time
 * complexity. for an unsorted array, you need to think of a other solution.
 *
 */
public class BinarySearchSolution {

	public static void main(String[] args) {
		int[] A = new int[] { 0, 2, 3, 4, 7, 9, 12, 15 };

		System.out.println(binarySearch(A, 3));
	}

	/*
	 * returns the index of the number to be searched; iff it presents
	 */
	public static int binarySearch(int[] inputArray, int number) {
		int low = 0, mid = 0;
		int high = inputArray.length;

		while (low <= high) {
			mid = (high + low) / 2;

			if (inputArray[mid] == number) {
				return mid;
			} else if (inputArray[mid] < number) {
				low = mid + 1;
			} else if (inputArray[mid] > number) {
				high = mid - 1;
			}
		}

		return -1;
	}
}
