package Sorting;

import linkedListds.SingleLinkedList;

public class SortingExamples {

	public static void main(String[] args) {

		SingleLinkedList<String> singleLinkedList = new SingleLinkedList<String>();
		singleLinkedList.append("apricot");
		singleLinkedList.append("juhi");
		singleLinkedList.append("santosh");
		singleLinkedList.append("apple");
		singleLinkedList.append("zatharus");
		singleLinkedList.append("monkey");

		System.out.println("Before sorting :" + singleLinkedList);
		singleLinkedList.sort();
		System.out.println("After sorting :" + singleLinkedList);
		
		
		
		SingleLinkedList<Integer> intLinkedList = new SingleLinkedList<Integer>();
		intLinkedList.append(4);
		intLinkedList.append(5);
		intLinkedList.append(40);
		intLinkedList.append(43);
		intLinkedList.append(-3);
		intLinkedList.append(0);
		System.out.println("Before sorting :" + intLinkedList);
		intLinkedList.sort();
		System.out.println("After sorting :" + intLinkedList);
		
	}
}
