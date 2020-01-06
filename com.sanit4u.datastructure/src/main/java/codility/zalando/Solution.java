package codility.zalando;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		System.out.println(findMinMissingNumber(new int[] { -1, -3 }));
		printMissingNumbersUsingBitSet(new int[] { 1, 2, 3, 4, 5, 6, 8 }, 10);
//		int find = find(125);
//		System.out.println(find);

		int arr[] = { 12, 11, 13, 5, 6, 7, 15 };
		quicksortArray(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		// three missing number
		printMissingNumberLogN(new int[] { 1, 2, 3, 4, 5, 6, 8 }, 10);

		// three missing number
		printMissingNumber(new int[] { 1, 2, 3, 4, 6, 9, 8 }, 10);

//		int ans = sol(6, 20);
//		System.out.println(ans);

//		int x = s(-1, -3);
//		System.out.println(x);
//		String s = "sasa";
//
//		int longestNonduplicatedSubstring = longestNonduplicatedSubstring("8757 asbcdus1234567ds32ds32dfasfcbbcjdc");
//		System.out.println(longestNonduplicatedSubstring);

	}

	/**
	 * Find duplicate numbers in an array
	 * 
	 * @param numbers
	 */
	private static void findDuplicateNumber(int[] numbers) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : numbers) {

			if (map.containsKey(i)) {
				Integer count = map.get(i);
				map.put(i, count + 1);
			} else {
				map.put(i, 1);
			}
		}

	}

	/**
	 * generally, O(N) would be the traversing all the element and with sum/Xor you
	 * can find the missing element.
	 * 
	 * @param numbers
	 * @param count
	 */
	private static int printMissingNumberLogN(int[] numbers, int count) {

		int low = 0;
		int high = numbers.length - 1;

		int mid = 0;

		while ((high - low) > 1) {

			mid = (high + low) / 2;

			int result1 = numbers[low] - low;
			int result2 = numbers[mid] - mid;
			int result3 = numbers[high] - high;
			if (result1 != result2) {
				high = mid;
			} else if (result3 != result2) {
				low = mid;
			}
		}
		System.out.println(numbers[mid] + 1);
		return (numbers[mid] + 1);

	}

	public static int findMinMissingNumber(int[] A) {

		Set<Integer> presentedNumbers = new HashSet<Integer>();
		// That will contain numbers till that length
		int length = A.length;
		for (int i : A) {
			presentedNumbers.add(i);
		}

		// if all the numbers are present, then return length+1;
		int result = 1;
		boolean isAllPresent = true;
		for (int i = 1; i <= length; i++) {
			if (!presentedNumbers.contains(i)) {
				isAllPresent = false;
				result = i;
				break;
			}
		}

		result = isAllPresent ? length + 1 : result;
		return result;
	}

	/**
	 * * A general method to find missing values from an integer array in Java. *
	 * This method will work even if array has more than one missing element.
	 */
	private static void printMissingNumber(int[] numbers, int count) {
		int missingCount = count - numbers.length;
		BitSet bitSet = new BitSet(count);
		for (int number : numbers) {
			bitSet.set(number - 1);
		}
		System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers),
				count);
		int lastMissingIndex = 0;
		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println(++lastMissingIndex);
		}
	}

	private static void printMissingNumbersUsingBitSet(int[] numbers, int count) {

		int missingNumbersCount = count - numbers.length;
		BitSet bitset = new BitSet(count);
		for (int i : numbers) {
			bitset.set(i);
		}
		int nextClearBit = 0;
		System.out.println("Missing Numbers are as follows:");
		for (int i = 0; i < missingNumbersCount; i++) {
			nextClearBit = bitset.nextClearBit(nextClearBit);
			System.out.println(nextClearBit++);
		}

	}

	public static int sol(int A, int B) {

		if (A <= 0 || B <= 0) {
			return 0;
		}

		if (A > B) {
			return 0;
		}

		int result = 0;
		for (int i = A; i <= B; i++) {

			if (isConsecutiveProduct(i)) {
				result++;
			}
		}

		return result;
	}

	private static boolean isConsecutiveProduct(int number) {

		int x = (int) Math.floor(Math.sqrt(number));

		if (x * (x + 1) == number) {
			return true;
		}

		return false;
	}

//	public static int find(int N) {
//
//		if (N < 10) {
//			return 0;
//		}
//
//		int minDigitOfOrder = 1;
//		int orderDigit = 0;
////		while (N >= 10) {
////			N = N / 10;
////			orderDigit++;
////		}
//			
//
//		for (int i = 1; i < orderDigit; i++) {
//			minDigitOfOrder = minDigitOfOrder * 10;
//		}
//
//		return minDigitOfOrder;
//	}

	static int s(int... A) {
		Set<Integer> set = new LinkedHashSet<Integer>();

		for (int i = 0; i < A.length; i++) {

			if (A[i] > 0) {
				set.add(A[i]);
			}
		}

		final int length = A.length;

		int lowestPosInt = 1;
		for (int i = 1; i <= (length + 1); i++) {
			if (!set.contains(i)) {
				return i;
			}
		}

		return lowestPosInt;
	}

	/**
	 * You are given a string S consisting of N characters and an integer K. You can
	 * modify string S by removing any substring of it. A substring is defined as a
	 * contiguous segment of a string.
	 * 
	 * 1. Given S = "abaacbca" and K = 2, your function should return 3. After
	 * removing substring "cbc", string S will contain exactly two different
	 * characters: a and b.
	 * 
	 * 2. Given S = "aabcabc" and K = 1, your function should return 5. After
	 * removing "bcabc", string S will contain exactly one character: a.
	 * 
	 * 3. Given S = "zaaaa" and K = 1, your function should return 1. You can remove
	 * only one letter: z.
	 * 
	 * 4. Given S = "aaaa" and K = 2, your function should return −1. There is no
	 * such substring of S that, after removal, leaves S containing exactly 2
	 * different characters.
	 * 
	 * @param S
	 * @param K
	 * @return
	 */
	static int solution(String S, int K) {

		if (S == null || S.isEmpty()) {

			return -1;
		}

		char[] charArray = S.toCharArray();

		Set<Character> set = new HashSet<Character>();

		for (int i = 0; i < charArray.length; i++) {
			set.add(charArray[i]);
		}

		if (K > set.size()) {
			return -1;
		}

		int subStringLength = 0;

		return subStringLength;
	}

	static int longestNonduplicatedSubstring(String s) {
		int result = 0;
		boolean[] containsChar = new boolean[256];
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (containsChar[i]) {
				for (; j < i; j++) {
					containsChar[j] = false;
					if (s.charAt(j) == s.charAt(i)) {
						j++;
						break;
					}
				}
			}
			containsChar[i] = true;
			result = Math.max(result, i - j + 1);
		}
		return result;
	}

	static int longestNonrepetitiveSubstringLength(String s) {

		Set<Character> set = new HashSet<Character>();
		int result = 0;
		int i = 0, j = 0;

		for (j = 0; j < s.length(); j++) {

			char currChar = s.charAt(j);

			if (set.add(currChar)) {
				result = Math.max(result, set.size());
			} else {

				while (i < j) {

					if (s.charAt(i) == currChar) {
						i++;
						break;
					}

					set.remove(s.charAt(i));
					i++;
				}
			}

		}

		return result;

	}

	static void largestNSmallestNumberOfArray(int[] array) {

		int smallest = Integer.MIN_VALUE;
		int largest = Integer.MAX_VALUE;

		for (int i = 0; i < array.length; i++) {

			if (array[i] < smallest) {
				smallest = array[i];
			}

			if (array[i] > largest) {
				largest = array[i];
			}
		}

		System.out.println("smallest :" + smallest);
		System.out.println("largest :" + largest);
	}

	static void quicksortArray(int[] array) {

		quicksort(array, 0, array.length - 1);
	}

	private static void quicksort(int[] array, int start, int end) {

		if (start >= end) {
			return;
		}

		int pivot = partitions(array, start, end);
		quicksort(array, start, pivot - 1);
		quicksort(array, pivot + 1, end);

	}

	private static int partitions(int[] array, int start, int end) {

		int pivot = end;

		int counter = start;

		for (int i = start; i < end; i++) {

			if (array[i] < array[pivot]) {

				int temp = array[counter];
				array[counter] = array[i];
				array[i] = temp;
				counter++;
			}
		}

		int temp = array[counter];
		array[counter] = array[pivot];
		array[pivot] = temp;

		return counter;
	}
}
