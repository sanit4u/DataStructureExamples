package linkedListds;

public class DoubleLinkedList<T> {

	private Node head, tail = null;

	/**
	 * Utility method to push the data at the end.
	 * 
	 * @param data
	 */
	public void pushAtEnd(T data) {

		Node node = new Node(data);

		if (head == null) {
			head = tail = node;
			head.next = head.previous = null;
			return;
		}

		tail.next = node;
		node.previous = tail;
		tail = node;
		tail.next = null;
	}

	/**
	 * Utility method to push the data at the beginning.
	 * 
	 * @param data
	 */
	public void pushAtBegin(T data) {

		Node node = new Node(data);

		if (head == null) {
			head = tail = node;
			head.next = head.previous = null;
			return;
		}

		node.next = head;
		head.previous = node;

		head = node;
	}

	/**
	 * Utility method to push the data at the Nth Position.
	 * 
	 * @param data
	 */
	public void pushAtPosition(T data, int position) {

		Node node = new Node(data);

		if (head == null) {

			if (position != 0) {
				return;
			}

			head = tail = node;
			head.next = head.previous = null;
			return;
		}

		if (head != null && position == 0) {
			this.pushAtBegin(data);
			return;
		}

		int i = 0;
		Node current = head;
		Node prev = null;
		Node next = null;

		while (current != null) {

			next = current.next;
			prev = current.previous;

			if (i == position) {

				node.next = current;
				node.previous = prev;

				prev.next = node;
				current.previous = node;

			}

			current = next;
			i++;
		}

	}

	public void reverseIteratively() {

		Node current = head;
		Node prev = null, next = null;

		while (current != null) {

			next = current.next;
			prev = current.previous;

			current.next = prev;
			current.previous = next;

			current = next;
		}

		head = prev.previous;
	}

	@Override
	public String toString() {

		Node current = this.head;

		StringBuilder sb = new StringBuilder();

		while (current != null) {
			sb.append(current.data);
			current = current.next;
			if (current != null) {
				sb.append("<-->");
			}
		}

		return sb.toString();
	}

	static class Node<T> {

		private T data;
		private Node next;
		private Node previous;

		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}
}
