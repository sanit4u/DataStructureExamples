package DataStructure;

/**
 * A custom implementation of Stack to determine Min of the numbers
 * 
 * @author santosh
 *
 */
public class Stack {
	private Node top;
	private Node current;
	private int length;
	private Node minNode;

	public Stack() {
		this.top = null;
		this.current = null;
		this.length = 0;
	}

	public void push(Object item) {
		Node node = new Node(item);
		Node previous = this.top;

		if (previous == null) {
			minNode = node;
		} else {
			Object min = Math.min((int) item, (int) minNode.getData());
			if (item == min) {
				minNode = node;
			} 
		}
		
		this.top = node;
		this.top.setNext(previous);
		this.current = this.top;
		this.length++;
	}

	public Object pop() {

		if (top == null) {
			return null;
		}

		Node next = top.getNext();

		Object data = top.getData();
		this.top = next;

		this.current = this.top;
		this.length--;
		return data;
	}

	/**
	 * It always gives you the first element
	 * @return
	 */
	public Object peek() {
		if (top == null) { 
			return null;
		}

		Object data = this.top.getData();
		return data;
	}

	public int size() {
		return this.length;
	}

	public Object min() {
		return minNode.getData();
	}

	public boolean isEmpty() {
		return this.length == 0;
	}

	/**
	 * Sorting with an auxilliary stack
	 * @param stack
	 * @return
	 */
	public static Stack sort(Stack stack) {
		Stack s = new Stack();

		while (!stack.isEmpty()) {
			Object tmp = stack.pop();

			while (!s.isEmpty() && ((int) s.peek()) > ((int) tmp)) {
				stack.push(s.pop());
			}

			s.push(tmp);
		}

		return s;
	}
}

class Node {
	private Object data;
	private Node next;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}

	public Node(final Object data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return this.next;
	}

	public Object getData() {
		return this.data;
	}

}
