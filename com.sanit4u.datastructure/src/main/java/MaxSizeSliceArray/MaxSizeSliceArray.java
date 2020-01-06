package MaxSizeSliceArray;

import java.util.ArrayList;
import java.util.List;

public class MaxSizeSliceArray {

	public static void main(String[] args) {
		int[] A = { 2, 2, 2, 2, 1, 2, -1, 2, 1, 3 };
		List<Integer> solution = MaxSizeSliceArray.solution(A);
		System.out.println(solution);
	}

	public static List<Integer> solution(final int[] A) {
		List<Integer> ints = new ArrayList<Integer>();
		int length = A.length;
		int maxLength = 1;
		int sliceStart = 0;

		for (int i = 1; i < length; i++) {

			if (A[i - 1] < A[i]) {
			}

		}

		return ints;
	}
}
