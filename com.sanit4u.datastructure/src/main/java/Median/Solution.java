package Median;

import java.util.PriorityQueue;
import java.util.*;

public class Solution {

	// finding the running median.
	// the problem is , there will be non negative integers, and we need to find the
	// median number from the list.
	// the first solution would be, insert the flow of stream to the sorted manner.
	// it would be like, whenever a integer is added to the array, it needs to be
	// checked with the existing elements. it would take O(n power 2) time
	// complexicity

	public static void main(String[] args) {

//		int[] input = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		int[] input = { 2, 3, 4 };
		getFlowingMedain(input);

	}

	private static void getFlowingMedain(int[] input) {

		double[] median = new double[input.length];
		// minHeap returns the mininum amount & this contains the higher elements.
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		// maxHeap returns the maximum amount & this contains the lower elements.
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return -1 * o1.compareTo(o2);
			}
		});

		for (int i = 0; i < input.length; i++) {

			int value = input[i];
			insertIntoHeap(minHeap, maxHeap, value);
			rebalanceHeap(minHeap, maxHeap);
			median[i] = getMedian(minHeap, maxHeap);
		}

		System.out.println(Arrays.toString(median));

	}

	private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		PriorityQueue<Integer> largerHeap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
		PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;

		if (largerHeap.size() == smallerHeap.size()) {
			return ((double) (largerHeap.peek() + smallerHeap.peek()) / 2);
		} else {
			return largerHeap.peek();
		}

	}

	private static void rebalanceHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		PriorityQueue<Integer> largerHeap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
		PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;

		if (largerHeap.size() - smallerHeap.size() > 1) {

			smallerHeap.add(largerHeap.poll());
		}

	}

	private static void insertIntoHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int value) {

		if (maxHeap.isEmpty() || value < maxHeap.peek()) {
			maxHeap.add(value);
		} else {
			minHeap.add(value);
		}
	}
}
