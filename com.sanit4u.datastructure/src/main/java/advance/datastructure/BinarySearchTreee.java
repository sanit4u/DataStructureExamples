package advance.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * A sample binary search tree
 */
public class BinarySearchTreee {

	public static class Node {

		public int value;
		public Node left, right;
		public Object key;

		public Node(int value) {
			this.value = value;
		}
	}

	Node root;

	public BinarySearchTreee() {
		root = null;
	}

	public void insert(int value) {

		root = insertvalue(root, value);

	}

	private Node insertvalue(Node root, int value) {

		if (root == null) {
			Node node = new Node(value);
			root = node;
			return root;
		}

		if (value < root.value) {
			root.left = insertvalue(root.left, value);
		} else if (value > root.value) {
			root.right = insertvalue(root.right, value);
		}

		return root;
	}

	public Node search(int value) {

		return searchValue(root, value);
	}

	private Node searchValue(Node root, int value) {

		if (root == null || root.value == value) {
			return root;
		}

		if (value < root.value) {
			return searchValue(root.left, value);
		}

		return searchValue(root.right, value);
	}

	public List<Integer> toListInASC() {
		List<Integer> list = new ArrayList<Integer>();

		// InOrder traversal of tree as it would be from Left Right root
		inOrder(list);

		return list;
	}

	private void inOrder(List<Integer> list) {

		Stack<Node> stack = new Stack<Node>();
		Node current = root;

		while (current != null || !stack.isEmpty()) {

			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			// current here is null and when we pop the stack , then the last inserted
			// (which is the leaf) would poped out.
			current = stack.pop();

			list.add(current.value);

			current = current.right;
		}

	}
	
	static List<Integer> rightViewUsingStack(Node root) {

		System.out.println("print right view");

		List<Integer> path = new ArrayList<Integer>();
		if (root == null) {
			return path;
		}

		Map<Node, Integer> levelMap = new HashMap<Node, Integer>();
		Set<Integer> visitedLevels = new HashSet<Integer>();
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		levelMap.put(root, 0);
		while (!stack.isEmpty()) {

			Node element = stack.pop();
			Integer level = levelMap.get(element);
			if (element.left != null) {
				stack.add(element.left);
				levelMap.put(element.left, level + 1);
			}

			if (element.right != null) {
				stack.add(element.right);
				levelMap.put(element.right, level + 1);
			}

			if (visitedLevels.add(level)) {
				path.add(element.value);

			}

		}

		return path;
	}

	static List<Integer> rightViewUsingQueue(Node root) {
		System.out.println("print right view");

		List<Integer> path = new ArrayList<Integer>();
		if (root == null) {
			return path;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {

			// calculate num of nodes in the current level
			int size = q.size();
			int i = 0;
			while (i < size) {
				Node element = q.poll();

				if (i == size - 1) {
					// when this happens, then in the level where the element is, we can assume
					// that, this is the right most node of that level.
					path.add(element.value);
				}

				if (element.left != null) {
					q.add(element.left);
				}

				if (element.right != null) {
					q.add(element.right);
				}

				i++;
			}

		}

		return path;
	}

	static List<Integer> leftViewUsingStack(Node root) {
		System.out.println("print left view");
		List<Integer> path = new ArrayList<Integer>();
		if (root == null) {
			return path;
		}

		Stack<Node> stack = new Stack<Node>();
		Map<Integer, Node> levelMap = new HashMap<Integer, Node>();
		stack.add(root);
//		levelMap.put(0, root);
		int level = 0;
		while (!stack.isEmpty()) {
			int levelElements = stack.size();
			int i = 0;
			Node element = null;
			while (i < levelElements) {
				element = stack.pop();

				if (element.left != null) {
					stack.add(element.left);
				}
				if (element.right != null) {
					stack.add(element.right);
				}
				i++;
			}
			
			if (element != null) {
				level++;
				levelMap.put(level, element);
			}
		}

		for (Map.Entry<Integer, Node> entry : levelMap.entrySet()) {
			path.add(entry.getValue().value);
		}
		return path;
	}

	public Node delete(int value) {

		this.root = deleteNode(root, value);
		return this.root;
	}
	

	private Node deleteNode(Node root, int value) {

		if (root == null) {
			return root;
		}

		if (value < root.value) {
			return deleteNode(root.left, value);
		} else if (value > root.value) {
			return deleteNode(root.right, value);
		} else {

			// node with one children or no child
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			// if the desired node to be deleted is a root node then,
			// get the minium node in it's right and replace it with the root node

			root.value = minNodeFromRight(root.right);

			// delete the inorder successor
			root = deleteNode(root.right, root.value);
		}

		return root;
	}

	private int minNodeFromRight(Node root) {

		int min = root.value;

		while (root.left != null) {

			min = root.left.value;
			root = root.left;
		}

		return min;
	}

	public static void main(String[] args) {
		BinarySearchTreee tree = new BinarySearchTreee();
//		tree.insert(4);
//		tree.insert(3);
//		tree.insert(5);
//		tree.insert(8);
//		tree.insert(5);
//		tree.insert(2);
//		tree.insert(1);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		System.out.println(tree.toListInASC());
		List<Integer> leftViewUsingStack = leftViewUsingStack(tree.root);
		
		System.out.println(leftViewUsingStack.toString());
	}

}
