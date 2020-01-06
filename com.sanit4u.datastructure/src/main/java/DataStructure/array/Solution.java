package DataStructure.array;

import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {

		printPrimeNumbers(100);
		int arr[] = { 12, 11, 13, 5, 6, 7, 15 };
		int kthLargestElement = kthLargestElement(arr, 3);

		System.out.println(kthLargestElement); // 7
		int kthSmallestElement = kthSmallestElement(arr, 3);
		System.out.println(kthSmallestElement); // 7
	}

	static int kthLargestElement(int[] arr, int k) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for (int i : arr) {
			priorityQueue.offer(i);
		}

		int result = Integer.MIN_VALUE;
		while (k > 0) {

			result = priorityQueue.poll();
			k--;
		}
		return result;
	}

	static int kthSmallestElement(int[] arr, int k) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for (int i : arr) {
			priorityQueue.offer(i);
		}

		int result = Integer.MAX_VALUE;
		int length = arr.length;
		int after_ = length - k;
		while (after_ > 0) {

			result = priorityQueue.poll();
			after_--;
		}
		return result;
	}

	static void printPrimeNumbers(int limit) {
		System.out.println("prime Numbers till " + limit + "is :");
		for (int i = 2; i < limit; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	static boolean isPrime(int number) {

		if (number == 2 || number == 3) {
			return true;
		}

		if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}
		
		for (int i = 3; i < Math.sqrt(number); i += 2) {
			if ((number % i == 0) || (number % Math.sqrt(number) == 0)) {
				return false;
			}
		}

		return true;
	}
}
