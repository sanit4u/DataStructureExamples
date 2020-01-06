package Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationProblem {

	public static void main(String[] args) {

		findLetterCombination("124");
	}

	private static List<String> findLetterCombination(String string) {

		string = string.replaceAll("1", "");
		string = string.replaceAll("0", "");
		int[] intArray = new int[string.length()];

		for (int i = 0; i < string.length(); i++) {
			intArray[i] = string.charAt(i) - '0';
		}

		String[] stringTable = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		List<String> result = new ArrayList<String>();

		Queue<String> q = new LinkedList<String>();
		q.add("");

		while (!q.isEmpty()) {
			String str = q.poll();

			if (str.length() == string.length()) {
				result.add(str);
			} else {

				int ithDigitOfNum = intArray[str.length()];

				String val = stringTable[ithDigitOfNum];

				for (int i = 0; i < val.length(); i++) {

					str = str.trim();
					q.add(str + val.charAt(i));
				}
			}

		}

		System.out.println(result.toString());

		return result;
	}
}
