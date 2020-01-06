package AnagramComprator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort an array of strings with anagrams next to each other
 * 
 * Here i Have used the comparator approach. 
 * 
 * @author rsa
 *
 */
public class AnaSolution {

	public static void main(String[] args) {
		AnaSolution ana = new AnaSolution();
		String[] arr = { "ant", "cat", "tan", "god", "act", "dog", };

		Arrays.sort(arr, ana.new AnagramComprator());
		System.out.println(Arrays.toString(arr));
	}

	class AnagramComprator implements Comparator<String> {

		public String sortChars(String s) {
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			return new String(charArray);
		}

		@Override
		public int compare(String o1, String o2) {
			return sortChars(o1).compareTo(sortChars(o2));
		}
	}
}
