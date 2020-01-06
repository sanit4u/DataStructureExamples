package DataStructure;

public class Impl {

	public static void main(String[] args) {
		DataStructure.Stack s = new DataStructure.Stack();
		s.push(2);
		s.push(7);
		s.push(9);
		s.push(1);
		s.push(3);
		s.push(8);
		s.push(5);

		System.out.println("min :" + s.min());
		DataStructure.Stack sort = Stack.sort(s);
		while (!sort.isEmpty()) {
			System.out.println(sort.pop());
		}
		System.out.println("min :" + sort.min());

	}
}
