package advance.datastructure;

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
 * It should retrun true; as it has 5-4-11-2 path
 */
// @formatter:on
public class PathSum {
	public static class TreeNode {

		int val;

		TreeNode left, right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

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
}
