package string.examples.combination;

public class Solution {

	public static void main(String[] args) {
		combination("ABCD");
	}

	private static void combination(String string) {
		StringBuilder sb = new StringBuilder();
		if (string == null || string.length() <= 0) {
			return;
		}

		combine(0, string, sb);

	}

	private static void combine(int start, String string, StringBuilder output) {
		for (int i = start; i < string.length(); ++i) {
			output.append(string.charAt(i));
			System.out.println(output);

			if (i < string.length()) {
				combine(i + 1, string, output);
			}

			output.setLength(output.length() - 1);
		}
	}
}
