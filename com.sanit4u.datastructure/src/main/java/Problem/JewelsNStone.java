package Problem;

import java.util.HashSet;
import java.util.Set;

public class JewelsNStone {

	public static void main(String[] args) {
		getJewelCount("aAAbbb", "aA");
	}

	private static int getJewelCount(String S, String J) {
		int count = 0;

		Set<Character> set = new HashSet<Character>();

		for (char c : J.toCharArray()) {
			set.add(c);
		}
		
		for(char c : S.toCharArray()) {
			
			if(set.contains(c)) {
				count++;
			}
		}
		

		return count;
	}
}
