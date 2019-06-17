package com.sanit4u.datastructure.treetraversal;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tree {
	private static final Random RANDOM = new SecureRandom();

	/**
	 * Each level will have 3 nodes. If it does not have enough nodes, then it will
	 * set the rest number of nodes as children.
	 * 
	 * @param numberOfNodes
	 * @return
	 */
	static TNode getRandomNonBinaryTree(int numberOfNodes) {

		// random input data
		Integer[] arr = new Integer[numberOfNodes];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		List<Integer> numOfData = Arrays.asList(arr);
		Collections.shuffle(numOfData);
		System.out.println("INPUT DATA :" + Arrays.toString(arr));

		// Creating the nodes
		List<TNode> nodeList = IntStream.range(0, numberOfNodes).mapToObj(x -> new TNode(numOfData.get(x)))
				.collect(Collectors.toList());

		final TNode root = nodeList.get(0);
		TNode current = root;
		Queue<TNode> queue = new LinkedList<TNode>();
		// no need to get the root node anymore.
		nodeList.remove(0);
		Iterator<TNode> iterator = nodeList.listIterator();
		int child = 0;
		for (TNode tNode : nodeList) {

			current.getChildren().add(tNode);

			if (current != tNode) {
				queue.add(tNode);
			}

			// maximum children size will be 3
			if (current.getChildren().size() == 3) {
				TNode nextLevelOrSiblingNode = queue.poll();
				current = nextLevelOrSiblingNode;
			}
		}

		printLevelOrderTree(root);
		return root;
	}

	/**
	 * This will print the Non binary tree level wise
	 * 
	 * @param root
	 */
	static void printLevelOrderTree(TNode root) {

		Queue<TNode> queue = new LinkedList<TNode>();
		queue.add(root);

		while (true) {

			int nodeCount = queue.size();
			if (nodeCount == 0)
				break;

			while (nodeCount > 0) {
				TNode node = queue.peek();
				System.out.print(node.getData() + " ");
				queue.remove();

				for (TNode tNode : node.getChildren()) {
					queue.add(tNode);
				}

				nodeCount--;

			}
			System.out.println();
		}
	}

	/**
	 * Preorder traversal will traverse from (Root node then left->right)
	 * 
	 * @param root
	 * @return
	 */
	static List<Integer> preOrderTraversal(TNode root) {
		System.out.println("Preordering");

		Stack<TNode> stack = new Stack<TNode>();
		List<Integer> path = new ArrayList<Integer>();
		stack.add(root);

		while (!stack.isEmpty()) {

			TNode current = stack.pop();

			List<TNode> children = current.getChildren();
			ArrayList<TNode> temp = new ArrayList<TNode>(children);
			Collections.reverse(temp);
			for (TNode tNode : temp) {
				stack.push(tNode);
			}

			path.add(current.getData());
		}

		return path;
	}

	static List<TNode> inOrderTraversal(TNode root) {

		return null;
	}

	static List<TNode> postOrderTraversal(TNode root) {

		return null;
	}

}

class TNode {
	int data;
	List<TNode> children = new ArrayList<TNode>();

	TNode(int item) {
		data = item;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public List<TNode> getChildren() {
		return children;
	}

}
