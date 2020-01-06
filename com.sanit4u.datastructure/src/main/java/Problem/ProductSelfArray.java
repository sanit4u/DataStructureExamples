package Problem;

import java.util.*;

/**
 * 
 * Input = {1,2,3,4}, output = {24,12,8,6}
 *
 */
public class ProductSelfArray {
	public static void main(String[] args) {

		int[] A = { 1, 2, 3, 4 };

		getProductSelfArray(A);
	}

	private static void getProductSelfArray(int[] a) {

		int[] result = new int[a.length];

		result[a.length - 1] = 1;
		for (int i = a.length - 2; i >= 0; i--) {
			result[i] = result[i + 1] * a[i + 1];
		}

		int left = 1;
		for (int i = 0; i < result.length; i++) {
			result[i] = result[i] * left;
			left = a[i] * left;
		}

		System.out.println(Arrays.toString(result));
	}
}
