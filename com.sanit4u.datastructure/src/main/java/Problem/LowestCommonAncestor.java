package Problem;

import advance.datastructure.BinarySearchTreee.Node;

/**
 * Binary Search tree, given p ad q, get the lowest common ancestor
 *
 */
public class LowestCommonAncestor {

	public static void main(String[] args) {

	}

	private static Node getLowestCommonAncestor(Node root, Node p, Node q) {
		if (p.value < root.value && q.value < root.value) {
			return getLowestCommonAncestor(root.left, p, q);
		} else if (p.value > root.value && q.value > root.value) {
			return getLowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}
}
