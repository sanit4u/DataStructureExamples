package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum {

	public static void main(String[] args) {
		int[] A = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		combinationSum(A, target);
		combinationSum2(A, target);
		combinationSum3(3, 15);
	}

	static List<List<Integer>> combinationSum(int[] candidates, int target) {

		Arrays.sort(candidates);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> tempResults = new ArrayList<Integer>();

		helperCombination(candidates, results, target, 0, 0, tempResults);

		for (List<Integer> integer : results) {
			System.out.println(integer);
		}

		return results;
	}

	// can use duplicate
	private static void helperCombination(int[] candidates, List<List<Integer>> results, int target, int i, int sum,
			List<Integer> tempResults) {

		if (sum > target) {
			return;
		}

		if (sum == target) {
			results.add(new ArrayList<Integer>(tempResults));
			return;
		}

		for (int j = i; j < candidates.length; j++) {
			tempResults.add(candidates[j]);
			helperCombination(candidates, results, target, j, sum + candidates[j], tempResults);

			int lastInsteredIndex = tempResults.size() - 1;
			tempResults.remove(lastInsteredIndex);
		}

	}

	static List<List<Integer>> combinationSum2(int[] candidates, int target) {

		Arrays.sort(candidates);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> tempResults = new ArrayList<Integer>();

		helperCombination2(candidates, results, target, 0, 0, tempResults);

		for (List<Integer> integer : results) {
			System.out.println(integer);
		}

		return results;
	}

	// with out using same candidate from arrays
	private static void helperCombination2(int[] candidates, List<List<Integer>> results, int target, int i, int sum,
			List<Integer> tempResults) {

		if (sum > target) {
			return;
		}

		if (sum == target) {
			results.add(new ArrayList<Integer>(tempResults));
			return;
		}

		for (int j = i; j < candidates.length; j++) {
//			if (j == i || candidates[j] != candidates[j - 1]) {

				tempResults.add(candidates[j]);
				helperCombination2(candidates, results, target, j + 1, sum + candidates[j], tempResults);

				int lastInsteredIndex = tempResults.size() - 1;
				tempResults.remove(lastInsteredIndex);
//			}
		}

	}

	static List<List<Integer>> combinationSum3(int k, int target) {

		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> tempResults = new ArrayList<Integer>();

		helperCombination3(results, target, 1, 0, k, tempResults);

		for (List<Integer> integer : results) {
			System.out.println(integer);
		}

		return results;
	}

	// with out using same candidate from arrays
	private static void helperCombination3(List<List<Integer>> results, int target, int i, int sum, int k,
			List<Integer> tempResults) {

		if (sum > target) {
			return;
		}

		if (sum == target) {
			if (tempResults.size() == k)
				results.add(new ArrayList<Integer>(tempResults));
			return;
		}

		for (int j = i; j < 9; j++) {

			tempResults.add(j);
			helperCombination3(results, target, j + 1, sum + j, k, tempResults);

			int lastInsteredIndex = tempResults.size() - 1;
			tempResults.remove(lastInsteredIndex);
		}

	}

}
