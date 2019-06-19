package com.sanit4u.datastructure.custom.stack;

public class ImplTestSortStack {

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(2);
		s.push(7);
		s.push(9);
		s.push(1);
		s.push(3);
		s.push(8);
		s.push(-7);
		s.push(5);
		s.push(0);

		System.out.println("min :" + s.min());
		Stack sort = Stack.sortStack(s);
		while (!sort.isEmpty()) {
			System.out.println(sort.pop());
		}
		System.out.println("min :" + sort.min());

	}
}
