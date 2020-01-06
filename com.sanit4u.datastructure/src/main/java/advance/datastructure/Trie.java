package advance.datastructure;

public class Trie {
	// Alphabet size (# of symbols)
	static final int ALPHABET_SIZE = 26;

	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];

		// isEndOfWord is true if the node represents
		// end of a word
		boolean isEndOfWord;

		public TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	}

	static TrieNode root;

	// If not present, inserts key into trie
	// If the key is prefix of trie node,
	// just marks leaf node
	static void insert(String key) {
		System.out.println("Inserting :" + key);
		int level;
		int length = key.length();
		int index;

		TrieNode pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a'; // As 26 characters can be there, The 'a' will start from 0th position.
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();

			pCrawl = pCrawl.children[index];
		}

		// mark last node as leaf
		pCrawl.isEndOfWord = true;
	}

	static boolean search(String value) {
		System.out.println("Searching :" + value);
		int level = value.length();

		TrieNode pCrawl = root;
		for (int i = 0; i < level; i++) {

			int childIndex = value.charAt(i) - 'a';
			if (pCrawl.children[childIndex] == null) {
				return false;
			}

			pCrawl = pCrawl.children[childIndex];

		}

		return pCrawl != null && pCrawl.isEndOfWord;

	}

	public static void main(String[] args) {
		root = new TrieNode();

		insert("santosh");
		insert("santosh");
		insert("sant");

		System.out.println(search("san"));
		System.out.println(search("santosh"));
		System.out.println(search("sant"));
	}

}
