package string.examples.paliendrom;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * a string is palindrome, if you reverse a string, you get the same original
 * string.
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(isPaliendrome("CIVIC"));
		System.out.println(isPaliendrome("anna"));
		System.out.println(isPaliendrome("bbbbb"));
		System.out.println(isPaliendrome("bbb"));
		System.out.println(isPaliendrome("level"));
		System.out.println(isPaliendrome("Level".toLowerCase()));
		System.out.println(isPaliendrome("Levdsvel".toLowerCase()));
		System.out.println();
		System.out.println();
		System.out.println(isPaliendromeWithMap("CIVIC"));
		System.out.println(isPaliendromeWithMap("anna"));
		System.out.println(isPaliendromeWithMap("bbbbb"));
		System.out.println(isPaliendromeWithMap("bbb"));
		System.out.println(isPaliendromeWithMap("level"));
		System.out.println(isPaliendromeWithMap("Level".toLowerCase()));
		System.out.println(isPaliendromeWithMap("Levdsvel".toLowerCase()));
	}

	public static boolean isPaliendrome(final String input) {

		if (null == input)
			return false;

		for (int i = 0, j = input.length() - 1; i < j; i++, j--) {

			if (input.charAt(i) != input.charAt(j))
				return false;

		}

		return true;
	}

	public static boolean isPaliendromeWithMap(final String input) {

		if (null == input)
			return false;

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char character : input.toCharArray()) {
			int value = 0;
			if (map.containsKey(character)) {
				value = map.get(character);
			}

			map.put(character, value + 1);
		}

		int odd = 0;
		for (Entry<Character, Integer> entry : map.entrySet()) {

			// if its a paliendrome, then it can have at max one charater that will have odd occurrences.
			odd = entry.getValue() % 2 != 0 ? odd + 1 : odd;
		}

		return odd <= 1;
	}
}
