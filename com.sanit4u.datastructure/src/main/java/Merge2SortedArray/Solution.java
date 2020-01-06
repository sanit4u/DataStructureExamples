package Merge2SortedArray;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int a[] = new int[6];
		a[0] = 1;
		a[1] = 4;
		a[2] = 9;
		int b[] = { 2, 3, 8 };
		int[] c = sol.sort2Array(a, b, 3, 3);

	}

	/**
	 * 
	 * @param a array 1
	 * @param b array 2
	 * @param m number of elements array 1
	 * @param n length of array 2
	 * @return
	 */
	private int[] sort2Array(int[] a, int[] b, int m, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (i >= 0 && j >= 0) {
			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}

		}

		while (j >= 0) {

			a[k--] = b[j--];
		}

		System.out.println(Arrays.toString(a));
		return a;
	}
}
