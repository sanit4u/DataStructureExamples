package string.examples.substring;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author rsa
 *
 */
public class LongestUniqueSubstring {

	public static void main(String[] args) {

		System.out.println(getLongestUniqueSubstring("asdsddrfgthj"));// 7
	}

	static int getLongestUniqueSubstring(String input) {

		int left, right;
		left = right = 0;
		int length = input.length();
		Set<Character> set = new HashSet<Character>();
		int max = Integer.MIN_VALUE;

		while (right < length) {

			char charRight = input.charAt(right);

			if (set.add(charRight)) {
				right++;
				max = Math.max(max, right - left);
			} else {
				set.remove(input.charAt(left));
				left++;
			}

		}

		return max;
	}
}
