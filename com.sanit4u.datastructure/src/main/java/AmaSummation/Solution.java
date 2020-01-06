package AmaSummation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Write a program that, given an array A[] of n numbers and another number x,
 * determines whether or not there exist two elements in S whose sum is exactly
 * x
 * 
 * @author rsa
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int A[] = { 2, 5, 3, 6, 1, 5 };

//		System.out.println(sol.checkIsElementforSumPresent(A, 10));
		System.out.println(sol.checkIsElementforSumPresentWithoutMap(A, 10));

	}

	private boolean checkIsElementforSumPresent(int[] A, int b) {
		if (A == null || A.length < 0) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (final int i : A) {

			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		for (final int i : A) {
			int rest = b - i;

			if (map.containsKey(rest)) {
				int occurance = map.get(rest);
				if (occurance > 0) {

					if (i == rest) {
						if (occurance > 1) {
							return true;
						}
					} else {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean checkIsElementforSumPresentWithoutMap(int[] A, int b) {
		if (A == null || A.length < 0) {
			return false;
		}

		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());

		for (int i = 0; i < A.length; i++) {

			int rest = b - A[i];

			if (list.contains(rest) && list.indexOf(rest) != i) {
				return true;
			}
		}
		return false;
	}
}
