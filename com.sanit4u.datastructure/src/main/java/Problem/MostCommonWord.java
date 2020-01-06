package Problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	public static void main(String[] args) {
//		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//		String[] banned = { "hit" };
		String paragraph = "Bob. hIt, baLl";
		String[] banned = { "bob", "hit" };
		System.out.println(mostCommonWord(paragraph, banned));

	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		Set<String> bannedSet = new HashSet<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String word : banned) {
			bannedSet.add(word);
		}

		String[] words = paragraph.replaceAll("[^a-zA-z]", " ").toLowerCase().split(" ");
		for (String word : words) {
			if (null != word && word.length() > 0)
				map.put(word, map.getOrDefault(word, 0) + 1);
		}

		int maxOccurance = Integer.MIN_VALUE;
		String word = null;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			if (!bannedSet.contains(entry.getKey()) && entry.getValue() > maxOccurance) {
				maxOccurance = entry.getValue();
				word = entry.getKey();
			}
		}

		return word;
	}
}
