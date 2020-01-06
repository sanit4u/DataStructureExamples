package advance.datastructure;

import java.util.Arrays;
import java.util.Comparator;

// this will order the element in ascending order. So, when we remove, the lowest element will be removed. o(n)
public class CusPriorityQueue {

	// the array will store the elements in desc order
	private Integer[] prArray;
	private int position;
	private int capacity;
	private Comparator comparator;

	public CusPriorityQueue(int size) {
		this.prArray = new Integer[size];
		this.position = 0;
		this.capacity = 0;
	}

	public CusPriorityQueue(int size, Comparator comparator) {
		this.prArray = new Integer[size];
		this.position = 0;
		this.capacity = 0;
		this.comparator = comparator;
	}

	private boolean isFull() {
		return position != 0 && position == capacity;
	}

	public boolean isEmpty() {
		return position == 0;
	}

	public int size() {
		return position;
	}

	public void add(int value) {

		if (isFull()) {
			System.err.println("cannnot add. queue is full");
			return;
		}

		if (isEmpty()) {
			prArray[position] = value;
			position++;
			return;
		}

		if (comparator == null) {

			int i;
			for (i = position - 1; i >= 0; i--) {
				if (value > prArray[i]) {
					prArray[i + 1] = prArray[i]; // shifting the lower elements up to create the space for the new
													// element.
				} else {
					break;
				}
			}

			i++; // this is space, where the new value supposed to go
			prArray[i] = value;
			position++;
		} else {
			prArray[position] = value;
			position++;
			Arrays.sort(prArray, 0, position, comparator);
		}
	}

	public int pop() {

		if (isEmpty()) {
			throw new RuntimeException("Empty queue.");
		}

		if (comparator == null) {
			int i = --position;
			int removedValue = prArray[i];
			prArray[i] = null; // removing the element from the queue
			return removedValue;
		} else {
			int removedValue = prArray[0];
			for (int i = 1; i < position; i++) {
				prArray[i - 1] = prArray[i];
			}

			return removedValue;
		}
	}

	public static void main(String[] args) {

		CusPriorityQueue priorityQueue = new CusPriorityQueue(10);
		priorityQueue.add(81);
		priorityQueue.add(72);
		priorityQueue.add(91);
		priorityQueue.add(52);
		priorityQueue.add(61);

		System.out.print("Deleted elements from queue: ");
		System.out.print(priorityQueue.pop() + " ");
		priorityQueue.add(48);
		priorityQueue.add(50);
		priorityQueue.add(6);
		
		System.out.print(priorityQueue.pop() + " ");
		System.out.print(priorityQueue.pop() + " ");
		System.out.print(priorityQueue.pop() + " ");
		System.out.print(priorityQueue.pop() + " ");
		System.out.print(priorityQueue.pop() + " ");
		System.out.print(priorityQueue.pop() + " ");
		
		System.out.println("Comparator");
		System.out.println("Comparator");
		System.out.println("Comparator");
		
		CusPriorityQueue priorityQueueComp = new CusPriorityQueue(10, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -1 * (o1.compareTo(o2));
			}
		});

		priorityQueueComp.add(61);
		priorityQueueComp.add(98);
		priorityQueueComp.add(52);
		priorityQueueComp.add(60);
		
		System.out.print(priorityQueueComp.pop() + " ");
		System.out.print(priorityQueueComp.pop() + " ");
		System.out.print(priorityQueueComp.pop() + " ");
		System.out.print(priorityQueueComp.pop() + " ");

	}
}
