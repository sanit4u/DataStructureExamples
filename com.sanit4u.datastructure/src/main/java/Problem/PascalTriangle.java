package Problem;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		System.out.println(printPascalTriangle(5));
	}

	private static List<List<Integer>> printPascalTriangle(int size) {

		List<List<Integer>> results = new ArrayList<List<Integer>>();

		List<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(1);
		results.add(firstRow);

		for (int i = 1; i < size; i++) {

			List<Integer> prevRow = results.get(i - 1);
			List<Integer> currentRow = new ArrayList<Integer>();

			currentRow.add(1);
			for (int j = 1; j < i; j++) {
				currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
			}
			currentRow.add(1);
			results.add(currentRow);
		}

		return results;
	}
}
