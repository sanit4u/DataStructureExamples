package string.examples.reverse;

public class Solution {

	public static void main(String[] args) {

		reverse("SANTA");

		reverseStringBuilder("SANTA");
		System.out.println(reverseRecursion("SANTA"));
	}

	private static void reverse(String str) {

		if (null == str || str.isEmpty()) {
			return;
		}

		char[] charArray = str.toCharArray();
		int end = charArray.length - 1;
		for (int i = 0; i <= end; i++) {

			char temp = charArray[i];
			charArray[i] = charArray[end];
			charArray[end] = temp;

			end--;

		}

		System.out.println(charArray);

	}

	private static void reverseStringBuilder(String str) {

		if (null == str || str.isEmpty()) {
			return;
		}

		StringBuilder builder = new StringBuilder(str);
		StringBuilder reverse = builder.reverse();

		System.out.println(reverse.toString());

	}

	private static String reverseRecursion(String str) {

		if (null == str || str.isEmpty()) {
			return "";
		}

		if (str.length() == 1) {
			return str;
		}

		return reverseRecursion(str.substring(1)) + str.charAt(0);
	}
}
