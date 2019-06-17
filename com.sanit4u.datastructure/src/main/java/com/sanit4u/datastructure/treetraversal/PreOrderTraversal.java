package com.sanit4u.datastructure.treetraversal;

import java.util.List;

public class PreOrderTraversal {

	public static void main(String[] args) {

		TNode nonBinaryTree = Tree.getRandomNonBinaryTree(15);

		List<Integer> preOrderTraversal = Tree.preOrderTraversal(nonBinaryTree);

		System.out.println(preOrderTraversal);
	}

}
