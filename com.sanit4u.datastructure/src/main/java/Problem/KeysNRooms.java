package Problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/keys-and-rooms
 * 
 * Input: [[1],[2],[3],[]] Output: true Explanation: We start in room 0, and
 * pick up key 1. We then go to room 1, and pick up key 2. We then go to room 2,
 * and pick up key 3. We then go to room 3. Since we were able to go to every
 * room, we return true.
 * 
 * 
 * Input: [[1,3],[3,0,1],[2],[0]] Output: false Explanation: We can't enter the
 * room with number 2.
 * 
 * 
 *
 */
public class KeysNRooms {

	public static void main(String[] args) {

		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
//		input1 # false
		List<Integer> key = new ArrayList<Integer>();
		key.add(1);
		key.add(3);
		rooms.add(key);

		key = new ArrayList<Integer>();
		key.add(3);
		key.add(0);
		key.add(1);
		rooms.add(key);

		key = new ArrayList<Integer>();
		key.add(2);
		rooms.add(key);

		key = new ArrayList<Integer>();
		key.add(0);
		rooms.add(key);

//		//// input2 # true
//		List<Integer> key = new ArrayList<Integer>();
//		key.add(1);
//		rooms.add(key);
//		key = new ArrayList<Integer>();
//		key.add(2);
//		rooms.add(key);
//		key = new ArrayList<Integer>();
//		key.add(3);
//		rooms.add(key);
//		key = new ArrayList<Integer>();
//		rooms.add(key);
		System.out.println(canVisitAllRooms(rooms));
	}

	private static boolean canVisitAllRooms(List<List<Integer>> rooms) {

		Set<Integer> visited = new HashSet<Integer>();
		visited.add(0);
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);

		while (!stack.isEmpty()) {

			Integer index = stack.pop();

			List<Integer> keys = rooms.get(index);

			for (int key : keys) {

				if (!visited.contains(key)) {
					stack.add(key);
					visited.add(key);
				}
			}

		}

		return visited.size() == rooms.size();
	}
}