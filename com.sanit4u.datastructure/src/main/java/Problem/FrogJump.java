package Problem;

import java.util.HashSet;
import java.util.Stack;

public class FrogJump {

	public static void main(String[] args) {
		int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };

		System.out.println(canCross(stones));
	}

	// Its not fully implemented.
	private static boolean canCross(int[] stones) {

		HashSet<Integer> stonePostions = new HashSet<Integer>();
		for (int i : stones) {
			stonePostions.add(i);
		}

		int lastStone = stones[stones.length - 1];
		Stack<Integer> jump = new Stack<Integer>();
		Stack<Integer> positions = new Stack<Integer>();
		jump.add(0);
		positions.add(0);

		while (!positions.isEmpty()) {

			int jumpDistance = jump.pop();
			int position = positions.pop();

			for (int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {

				if (i <= 0) {
					continue;
				}

				int nextPosition = position + i;
				if (nextPosition == lastStone) {
					return true;
				} else if (stonePostions.contains(nextPosition)) {
					positions.add(nextPosition);
					jump.add(i);
				}

			}

		}

		return false;
	}
}
