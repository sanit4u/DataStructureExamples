package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class PossibleUniquePaths {

	public static void main(String[] args) {

//		int possibleUniquePaths = possibleUniquePathsEfficient(3, 3);
		int possibleUniquePaths = possibleUniquePathsWithStoneInPathEfficient(
				new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } });
//		int possibleUniquePaths = possibleUniquePaths(10, 10);
		System.out.println(possibleUniquePaths);
	}

	/**
	 * 
	 * @param i
	 * @param j
	 */
	private static int possibleUniquePathsEfficient(int m, int n) {

		if (m <= 1 && n <= 1) {
			return 1;
		}

		int[][] count = new int[m][n];

		for (int i = 0; i < m; i++) {
			count[i][0] = 1;
		}

		for (int i = 0; i < n; i++) {
			count[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {

				count[i][j] = count[i - 1][j] + count[i][j - 1];
			}
		}

		return count[m - 1][n - 1];
	}

	/**
	 * 
	 * @param i
	 * @param j
	 */
	private static int possibleUniquePathsWithStoneInPathEfficient(int[][] m) {

		if (m == null || m.length == 0) {
			return 0;
		}

		if (m.length <= 1 && m[0].length <= 1) {
			if (m[0][0] != 1) {
				return 1;
			} else {
				return 0;
			}
		}

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 1) {
					m[i][j] = Integer.MIN_VALUE;
				}
			}
		}

		for (int i = 0; i < m.length; i++) {
			if (m[i][0] != Integer.MIN_VALUE) {
				m[i][0] = 1;
			} else {
				break;
			}
		}

		for (int i = 0; i < m[0].length; i++) {
			if (m[0][i] != Integer.MIN_VALUE) {
				m[0][i] = 1;
			} else {
				break;
			}
		}

		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				if (m[i][j] == Integer.MIN_VALUE) {
					continue;
				}
				if (m[i - 1][j] == Integer.MIN_VALUE && m[i][j - 1] == Integer.MIN_VALUE) {
					m[i][j] = 0;
				} else if (m[i - 1][j] == Integer.MIN_VALUE || m[i][j - 1] == Integer.MIN_VALUE) {
					m[i][j] = Math.max(m[i - 1][j], m[i][j - 1]);
				} else {
					m[i][j] = m[i - 1][j] + m[i][j - 1];
				}
			}
		}

		return m[m.length - 1][m[0].length - 1];
	}

	// this will have an exponential outcome, because of recursion
	public static int possibleUniquePaths(int m, int n) {
		int uniquePaths = 0;

		int destX = n - 1, destY = m - 1, currX = 0, currY = 0;
		boolean[][] grid = new boolean[n][m];
		String uniqePath = null;
		List<String> path = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		findOneUniquePath(grid, result, path, currX, currY, destX, destY, m, n);

		uniqePath = result.stream().filter(Objects::nonNull).collect(Collectors.joining());
		Set<String> uniquePathList = findUniquePermutations(uniqePath);
		uniquePaths = uniquePathList.size();
		return uniquePaths;
	}

	private static void findOneUniquePath(boolean[][] grid, List<String> result, List<String> path, int currX,
			int currY, int destX, int destY, int m, int n) {

		if (currX == destX && currY == destY && !isVisited(grid, currX, currY)) {

			if (result.isEmpty())
				result.addAll(path);

			return;
		}

		grid[currX][currY] = true;
		if (currX < n && (currY + 1) < m) {
			if (!isVisited(grid, currX, currY + 1)) {
				// moveRight
				path.add("R");

				findOneUniquePath(grid, result, path, currX, currY + 1, destX, destY, m, n);
			}
		}

		if (currX + 1 < n && (currY) < m) {
			if (!isVisited(grid, currX + 1, currY)) {
				// moveDown
				path.add("D");

				findOneUniquePath(grid, result, path, currX + 1, currY, destX, destY, m, n);
			}
		}

		grid[currX][currY] = false;

	}

	static boolean isVisited(boolean[][] grid, int currX, int currY) {
		// if it return true, then it is visited
		return grid[currX][currY];

	}

	private static Set<String> findUniquePermutations(String uniqePath) {

		Set<String> permutatedString = new HashSet<String>();

		findPermutations(uniqePath.toCharArray(), 0, permutatedString);

		return permutatedString;
	}

	private static void findPermutations(char[] charArray, int k, Set<String> permutatedString) {

		if (k == charArray.length - 1) {
			permutatedString.add(Arrays.toString(charArray));
			return;
		}

		for (int i = k; i < charArray.length; i++) {
			// swap i and k
			swap(charArray, i, k);
			// call recursion with k+1
			findPermutations(charArray, k + 1, permutatedString);
			// swap k & i back
			swap(charArray, k, i);
		}

	}

	private static void swap(char[] charArray, int i, int k) {

		char temp = charArray[i];
		charArray[i] = charArray[k];
		charArray[k] = temp;
	}

}
