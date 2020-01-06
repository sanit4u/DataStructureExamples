package Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Input: "123456579" Output: [123,456,579]
 * 
 * Input: "11235813" Output: [1,1,2,3,5,8,13]
 *
 *
 * Input: "112358130" Output: []
 * 
 * Input: "0123" Output: []
 * 
 * Input: "1101111" Output: [110, 1, 111]
 */
public class SplitArrayIntoFibonacci {

	public List<Integer> splitIntoFibonacci(String S) {

		if (S.isEmpty()) {
			return Collections.emptyList();
		}

		List<Integer> temp = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		isFibonacciSequence(temp, res, S);
		return !res.isEmpty() ? res.get(0) : Collections.emptyList();

	}

	private void isFibonacciSequence(List<Integer> temp, List<List<Integer>> res, String s2) {

		if (s2.isEmpty() && temp.size() > 2) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 1; i <= s2.length(); i++) {

			String str = s2.substring(0, i);

			if (str.length() > 1 && str.charAt(0) == '0') {
				break;
			}

			int num = Integer.parseInt(str);

			temp.add(num);
			if (temp.size() < 3 || temp.get(temp.size() - 2) + temp.get(temp.size() - 3) == num) {

				isFibonacciSequence(temp, res, s2.substring(i));

			}

			temp.remove(temp.size() - 1);
		}

	}

	public static void main(String[] args) {

		SplitArrayIntoFibonacci s = new SplitArrayIntoFibonacci();

		System.out.println(s.splitIntoFibonacci("1101102203"));
	}
}
