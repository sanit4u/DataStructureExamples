package NoeArc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PairTask {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Please enter input: ");
		String input = null;
		try {
			input = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("You entered : " + input);

		if (input == null || input.isEmpty()) {
			System.out.println("input string is empty");
		}

		String[] splitString = input.split(",");
		Map<String, Integer> recordMap = new HashMap<String, Integer>();
		for (String record : splitString) {

			String[] split = record.split("-");
			String animal = split[0].trim();
			if (null == recordMap.get(animal)) {
				recordMap.put(animal, 1);
			} else {
				int previousCount = recordMap.get(animal);
				recordMap.put(animal, previousCount + 1);
			}
		}
		System.out.println();
		for (Entry<String, Integer> entry : recordMap.entrySet()) {
			if (entry.getValue() == 2) {
				System.out.println(entry.getKey() + " completed");
			}
		}
	}
}
