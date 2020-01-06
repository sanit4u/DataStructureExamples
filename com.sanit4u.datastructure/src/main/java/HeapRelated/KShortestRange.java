package HeapRelated;

import java.util.PriorityQueue;

/**
 * 
 * Problem status: You have k lists of sorted integers. Find the smallest range
 * that includes at least one number from each of the k lists.
 * 
 * For this: we need to check the minimum element form all of the first elements
 * in k number of array. we need to have heap that will give us minimum element
 * out of all the list at a particular iteration. we need the number of the
 * array to which the minimum number belongs and the position of the number in
 * that array. when you have these, then we can iterate and add more elements
 * and check the minimum again. and get the next element from that array.
 */
public class KShortestRange {

	public static class Node implements Comparable {

		private int value;
		private int arrayNumber;
		private int elementIndex;

		public Node(int value, int arrayNumber, int elementIndex) {
			super();
			this.value = value;
			this.arrayNumber = arrayNumber;
			this.elementIndex = elementIndex;
		}

		public int getValue() {
			return value;
		}

		public int getArrayNumber() {
			return arrayNumber;
		}

		public int getElementIndex() {
			return elementIndex;
		}

		@Override
		public int compareTo(Object o) {
			return this.value - ((Node) o).value;
		}
	}

	public static void main(String[] args) {

		int[][] A = new int[3][];
		A[0] = new int[] { 4, 7, 9, 12, 15 };
		A[1] = new int[] { 0, 1, 2, 20 };
		A[2] = new int[] { 1, 18, 21, 30 };

		findShortestRangeInKSortedArray(A);
	}

	private static void findShortestRangeInKSortedArray(int[][] inputArray) {

		int minElement = Integer.MIN_VALUE;
		int maxElement = Integer.MAX_VALUE;

		int high = Integer.MIN_VALUE;

		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		for (int i = 0; i < inputArray.length; i++) {
			int firstElement = inputArray[i][0];
			Node node = new Node(firstElement, i, 0);
			pq.add(node);
			high = Math.max(high, firstElement);
		}

		while (true) {

			Node current = pq.poll();

			int low = current.getValue();
			int arrayNumber = current.getArrayNumber();
			int elementIndex = current.getElementIndex();

			int range = maxElement - minElement;

			// because, maxvalue-minvalue gives us the range = -1
			if (maxElement == Integer.MAX_VALUE && minElement == Integer.MIN_VALUE) {
				range = Integer.MAX_VALUE;
			}

			if ((high - low) < range) {
				maxElement = high;
				minElement = low;
			}

			if (elementIndex == inputArray[arrayNumber].length - 1) {

				break;
			}

			Node nextNumber = new Node(inputArray[arrayNumber][elementIndex + 1], arrayNumber, elementIndex + 1);
			pq.add(nextNumber);
			high = Math.max(inputArray[arrayNumber][elementIndex + 1], high);
		}

		System.out.println(minElement + "-" + maxElement);
	}
}
