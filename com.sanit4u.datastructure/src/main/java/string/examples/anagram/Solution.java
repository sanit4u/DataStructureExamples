package string.examples.anagram;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		System.out.println(isAnagram("CAT", "ACT"));
		System.out.println(isAnagramSB("DOG", "OGD"));
		System.out.println(isAnagramSB("DOG", "ghg"));
		System.out.println(isAnagram("KAFKA", "AKKAF"));

	}

	private static boolean isAnagram(String str1, String str2) {

		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		Arrays.parallelSort(charArray1);
		Arrays.parallelSort(charArray2);

		return Arrays.equals(charArray1, charArray2);
	}

	private static boolean isAnagramSB(String str1, String str2) {

		char[] charArray = str2.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int index = str1.indexOf(charArray[i]);
			if (index != -1) {
				str1 = str1.substring(0, index) + str1.substring(index + 1);
			}
		}

		return str1.isEmpty();
	}
}
