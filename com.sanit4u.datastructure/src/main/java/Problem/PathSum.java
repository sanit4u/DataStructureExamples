package Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @formatter:off
/**
 * Given input Binary Tree and sum = 22. Find if a path root-2-leaf exists in the BT
 *        5
 *       /  \
 *     4    8
 *    /     / \
 *   11    13  4
 *  /  \        \
 * 7    2        1
 * 
 * It should retur n true; as it has 5-4-11-2 path
 */
// @formatter:on
public class PathSum {
	public static class TreeNode {

		int val;

		TreeNode left, right;

		TreeNode(int x) {
			this.val = x;
		}
	}

	public static void main(String[] args) {
		int minValue = Integer.MIN_VALUE;
		int max = Math.max(0, 0);

		System.out.println(pathSum4(new int[] { 113, 215, 221 }));
	}

	public static boolean findPathSumExists(TreeNode root, int sum) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null && sum - root.val == 0) {
			return true;
		} else {
			return findPathSumExists(root.left, sum - root.val) || findPathSumExists(root.right, sum - root.val);
		}
	}

	public static List<List<String>> findPathSumPath(TreeNode root, int sum) {

		if (root == null) {
			return Collections.emptyList();
		}

		List<List<String>> result = new ArrayList<List<String>>();
		List<String> path = new ArrayList<String>();

		findPath(root, result, path, sum);

		return result;
	}

	private static void findPath(TreeNode root, List<List<String>> result, List<String> path, int sum) {
		if (root == null) {
			return;
		}

		path.add(String.valueOf(root.val));

		if (root.left == null && root.right == null && sum - root.val == 0) {
			result.add(new ArrayList<>(path));

		}

		findPath(root.left, result, new ArrayList<String>(path), sum - root.val);
		findPath(root.right, result, new ArrayList<String>(path), sum - root.val);

		path.remove(path.size() - 1);
	}

	public static int findNumOfPathSUm(TreeNode root, int sum) {

		if (root == null) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);

		return findCount(map, root, 0, sum);

	}

	private static int findCount(Map<Integer, Integer> map, TreeNode root, int currentSum, int target) {
		if (root == null) {
			return 0;
		}

		currentSum += root.val;
		int count = map.getOrDefault(currentSum - target, 0);
		map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

		count += findCount(map, root.left, currentSum, target) + findCount(map, root.right, currentSum, target);

		map.put(currentSum, map.get(currentSum) - 1);
		return count;
	}

	/**
	 * If the depth of a tree is smaller than 5, then this tree can be represented
	 * by a list of three-digits integers.
	 * 
	 * For each integer in this list:
	 * 
	 * The hundreds digit represents the depth D of this node, 1 <= D <= 4. The tens
	 * digit represents the position P of this node in the level it belongs to, 1 <=
	 * P <= 8. The position is the same as that in a full binary tree. The units
	 * digit represents the value V of this node, 0 <= V <= 9.
	 * 
	 * 
	 * Given a list of ascending three-digits integers representing a binary tree
	 * with the depth smaller than 5, you need to return the sum of all paths from
	 * the root towards the leaves.
	 * 
	 * Example 1:
	 * 
	 * Input: [113, 215, 221] Output: 12 Explanation: The tree that the list
	 * represents is: 3 / \ 5 1
	 * 
	 * The path sum is (3 + 5) + (3 + 1) = 12.
	 * 
	 * 
	 * Example 2:
	 * 
	 * Input: [113, 221] Output: 4 Explanation: The tree that the list represents
	 * is: 3 \ 1
	 * 
	 * The path sum is (3 + 1) = 4.
	 * 
	 * @param nums
	 * @return
	 */
	public static int pathSum4(int[] nums) {

		// build tree from the array
		// put it in the map
		// then traverse and add the node val

		Map<Integer, Integer> tree = new HashMap<Integer, Integer>();

		for (int num : nums) {
			tree.put(num / 10, num % 10);
		}
		int[] sum = new int[1];
		calPathSum(nums[0] / 10, 0, sum, tree);
		return sum[0];
	}

	private static void calPathSum(int node, int curSum, int[] sum, Map<Integer, Integer> tree) {

		int level = node / 10;
		int pos = node % 10;

		int left = ((level + 1) * 10) + (pos * 2 - 1);
		int right = ((level + 1) * 10) + pos * 2;

		curSum += tree.get(node);

		if (!tree.containsKey(left) && !tree.containsKey(right)) {
			sum[0] += curSum;
			return;
		}

		if (tree.containsKey(left)) {
			calPathSum(left, curSum, sum, tree);
		}

		if (tree.containsKey(right)) {
			calPathSum(right, curSum, sum, tree);
		}
	}
}
