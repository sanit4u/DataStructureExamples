package com.sanit4u.datastructure.treetraversal;

import java.util.List;

public class PreOrderTraversal {

	public static void main(String[] args) {

		TNode nonBinaryTree = Tree.getRandomNonBinaryTree(15);

		List<Integer> LevelOrderTraversal = Tree.levelOrderTraverse(nonBinaryTree);
		System.out.println("LevelOrder :" + LevelOrderTraversal);
		List<Integer> preOrderTraversal = Tree.preOrderTraversal(nonBinaryTree);
		System.out.println("PreOrder :" + preOrderTraversal);
		List<Integer> postOrderTraversal = Tree.postOrderTraversal(nonBinaryTree);
		System.out.println("PostOrder :" + postOrderTraversal);

	}

}
