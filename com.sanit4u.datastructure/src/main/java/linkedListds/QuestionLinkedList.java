package linkedListds;

import linkedListds.SingleLinkedList.Node;

public class QuestionLinkedList {

	public static void main(String[] args) {
//		testSingleLinekdList();
//		testDoublyLinekdList();
//		testCircularLinekdList();

		test2AddLinekdList();
	}

	private static void test2AddLinekdList() {
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		singleLinkedList.append(1);
		singleLinkedList.append(2);
		singleLinkedList.append(5);
		singleLinkedList.append(7);
		System.out.println(singleLinkedList);
		SingleLinkedList<Integer> singleLinkedList2 = new SingleLinkedList<Integer>();
		singleLinkedList2.append(5);
		singleLinkedList2.append(6);
		singleLinkedList2.append(9);
		singleLinkedList2.append(9);
		System.out.println(singleLinkedList2);
		Node add2IntLinkedList = SingleLinkedList.add2IntLinkedList(singleLinkedList.getHead(),
				singleLinkedList2.getHead());
		System.out.println("-------------------------");

		System.out.println(SingleLinkedList.print(add2IntLinkedList));

	}

	private static void testCircularLinekdList() {
		CircularDoublyLinkedList<String> circularLinkedList = new CircularDoublyLinkedList<String>();
		circularLinkedList.pushAtEnd("A");
		circularLinkedList.pushAtEnd("B");
		circularLinkedList.pushAtEnd("C");
		circularLinkedList.pushAtEnd("D");
		circularLinkedList.pushAtEnd("E");
		circularLinkedList.pushAtEnd("F");
		System.out.println("circular linked list before reversing : " + circularLinkedList);
		circularLinkedList.reverse();
		System.out.println("circular linked list after reversing : " + circularLinkedList);
		circularLinkedList.reverse();
		System.out.println("circular linked list after reversing2 : " + circularLinkedList);
	}

	private static void testDoublyLinekdList() {
		DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<String>();
		doubleLinkedList.pushAtEnd("A");
		doubleLinkedList.pushAtEnd("B");
		doubleLinkedList.pushAtEnd("C");
		doubleLinkedList.pushAtEnd("D");
		doubleLinkedList.pushAtEnd("E");
		doubleLinkedList.pushAtEnd("F");

		System.out.println("Double linked list before reversing : " + doubleLinkedList);
		doubleLinkedList.pushAtBegin("O");
		doubleLinkedList.pushAtBegin("I");
		System.out.println("Double linked list after inserting at begin: " + doubleLinkedList);

		doubleLinkedList.pushAtPosition("P", 5);
		System.out.println("Double linked list after inserting at 5: " + doubleLinkedList);
		doubleLinkedList.reverseIteratively();
		System.out.println("Double linked list after reversing : " + doubleLinkedList);
		doubleLinkedList.reverseIteratively();
		System.out.println("Double linked list after reversing 2: " + doubleLinkedList);
	}

	private static void testSingleLinekdList() {
		SingleLinkedList<String> singleLinkedList = new SingleLinkedList<String>();
		singleLinkedList.append("A");
		singleLinkedList.append("B");
		singleLinkedList.append("C");
		singleLinkedList.append("D");
		singleLinkedList.append("E");
		singleLinkedList.append("F");
		System.out.println("linked list before reversing : " + singleLinkedList);
		singleLinkedList.reverseIterativey();
		System.out.println("linked list after reversing : " + singleLinkedList);
		singleLinkedList.reverseIterativey();
		System.out.println("linked list after reversing2 : " + singleLinkedList);
	}
}
