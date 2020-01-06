package Problem;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoint2oRIGIN {

	public static void main(String[] args) {
		int[][] points = new int[][] { { 1, 3 }, { -2, 2 } };
		getKclosestPoint2Origin(points, 1);
	}

	private static void getKclosestPoint2Origin(int[][] points, int k) {

		int[][] result = null;

		// increasing heap. Min Heap
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(
				(a, b) -> ((a[0] * a[0]) + (a[1] * a[1])) - ((b[0] * b[0]) + (b[1] * b[1])));

		for (int[] point : points) {

			q.add(point);
		}

		while (k > 0) {
			System.out.println(Arrays.toString(q.poll()));
			k--;
		}

	}
}