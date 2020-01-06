package advance.datastructure;

public class KMPAlgorithm {

	public static void main(String[] args) {

		KMPAlgorithm kmp = new KMPAlgorithm();
		System.out.println(kmp.hasString("abcxabcdabcdabcy", "abcdabcy"));
		System.out.println(kmp.hasString("hasone", "sne"));

		System.out.println(kmp.indexOf("abcxabcdabcdabcy", "abcdabcy"));
		System.out.println(kmp.indexOf("loveYouGabby", "Gabby"));
	}

	public int indexOf(String sentence, String word) {

		int[] temp = buildPrefixSuffixArray(word);
		int j = 0, i = 0;
		while (i < sentence.length() && j < word.length()) {
			if (sentence.charAt(i) == word.charAt(j)) {
				i++;
				j++;

				if (j == word.length()) {
					return i - j;
				}
			} else {

				if (j != 0) {
					j = temp[j - 1];
				} else {
					i++;
				}
			}
		}

		return -1;
	}
	private int[] buildPrefixSuffixArray(String word) {
		int[] temp = new int[word.length()];

		int j = 0;
		for (int i = 1; i < word.length();) {

			if (word.charAt(j) == word.charAt(i)) {
				temp[i] = j + 1;
				i++;
				j++;
			} else {
				if (j != 0) {
					j = temp[j - 1];
				} else {
					temp[i] = 0;
					i++;
				}
			}
		}

		return temp;
	}
	public boolean hasString(String sentence, String word) {

		int[] temp = buildPrefixSuffixArray(word);
		int j = 0, i = 0;
		while (i < sentence.length() && j < word.length()) {
			if (sentence.charAt(i) == word.charAt(j)) {
				i++;
				j++;
			} else {

				if (j != 0) {
					j = temp[j - 1];
				} else {
					i++;
				}
			}
		}

		if (j == word.length()) {
			return true;
		}

		return false;
	}

	
}
