package string.examples.permutation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		printAllPermutationOfString("ABC");
//		System.out.println(isPermutationOfStringPallendrum("ivicc"));
		System.out.println(isPermutationOfStringPallendrum("civil"));
		System.out.println(isPermutationOfStringPallendrum("1324123"));
		printAllPermutationOfStringArray("CIVIC");
		int[] arr = { 3, 4, 7 };
		printAllPermutationOfArray(arr);
//		printAllPermutationOfString("Hello");
//		printAllPermutationOfString("cat");

	}

	/**
	 * get the characters occurance, if all the characters counts are all even
	 * and/or atmost 1 character is odd.
	 * 
	 * @param input
	 * @return
	 */
	private static boolean isPermutationOfStringPallendrum(String input) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			char keyChar = input.charAt(i);
			if (map.containsKey(keyChar)) {
				int value = map.get(keyChar) + 1;
				map.put(keyChar, value);
			} else {
				map.put(keyChar, 1);
			}
		}

		int odd = 0;
		for (Entry<Character, Integer> entry : map.entrySet()) {

			if (entry.getValue() % 2 != 0) {
				odd++;
			}
		}

		return odd <= 1;
	}

	private static void printAllPermutationOfStringArray(String string) {
		permutationOfStringArray(string.toCharArray(), 0);
	}

	private static void permutationOfStringArray(char[] charArray, int k) {

		if (k == charArray.length - 1) {
			System.out.println(charArray);
			return;
		}

		for (int i = k; i < charArray.length; i++) {

			swap(charArray, i, k);
			permutationOfStringArray(charArray, k + 1);
			swap(charArray, k, i);

		}
	}

	private static void swap(char[] charArray, int k, int i) {
		char temp = charArray[i];
		charArray[i] = charArray[k];
		charArray[k] = temp;
	}

	private static void printAllPermutationOfArray(int[] arr) {
		printAllPermutationsArr(arr, 0);

	}

	private static void printAllPermutationsArr(int[] arr, int k) {

		if (k == arr.length - 1) {
			printArray(arr);
			return;
		}

		for (int i = k; i < arr.length; i++) {

			swap(arr, i, k);
			printAllPermutationsArr(arr, k + 1);
			swap(arr, k, i);
		}

	}

	private static void swap(int[] arr, int i, int k) {
		int temp = arr[i];
		arr[i] = arr[k];
		arr[k] = temp;
	}

	private static void printArray(int[] input) {
		System.out.print('\n');
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
		}
	}

	private static void printAllPermutationOfString(String string) {
		Set<String> set = new HashSet<String>();
		printPermutations("", string, set);
		System.out.println(set);

	}

	private static void printPermutations(String pre, String rem, Set<String> set) {

		if (rem.isEmpty()) {
//			System.out.println(pre);
			set.add(pre);
			return;
		}

		for (int i = 0; i < rem.length(); i++) {

			String newPre = pre + rem.charAt(i);
			String newRem = rem.substring(0, i) + rem.substring(i + 1);

			printPermutations(newPre, newRem, set);
		}

	}

}
