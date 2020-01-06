package SetsOfSubsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class SetsOfSubsets {

	public static void main(String[] args) {

		final List<List<String>> input = SetsOfSubsets.getInput();

		final Map<String, Set<List<String>>> map = new HashMap<String, Set<List<String>>>();

		for (final List<String> list : input) {
			list.forEach(word -> {

				Set<List<String>> result = map.getOrDefault(word,
						new HashSet<List<String>>());
				result.add(list);
				map.put(word, result);
			});
		}

		final Map<String, Integer> resultMap = new HashMap<String, Integer>();

		for (final Entry<String, Set<List<String>>> entrySet : map.entrySet()) {

			final String word = entrySet.getKey();
			final Set<List<String>> value = entrySet.getValue();

			if (!value.isEmpty() && value.size() > 1) {

				final List<List<String>> list = new ArrayList<List<String>>(value);

				for (int i = 0; i < list.size(); i++) {
					final List<String> first = list.get(i);
					final Set<String> s = new HashSet<String>(first);

					final List<String> nextList = list.get(i + 1);
					final Set<String> s1 = new HashSet<String>(nextList);

					s1.retainAll(s);
					if (!s1.isEmpty()) {

						String collectSubset = s1.stream().collect(
								Collectors.joining("#"));
						Integer previousValue = resultMap.getOrDefault(
								collectSubset, 0);
						resultMap.put(collectSubset, previousValue + 1);
					}
				}
			}
		}

		resultMap.forEach((m, v) -> System.out.println(m + "  " + v));
	}

	private static List<List<String>> getInput() {

		List<List<String>> input = new ArrayList<List<String>>();
		List<String> lst0 = new ArrayList<String>();
		lst0.add("ab");
		lst0.add("cat");
		lst0.add("cd");
		lst0.add("ef");
		lst0.add("de");

		List<String> lst1 = new ArrayList<String>();
		lst1.add("x");
		lst1.add("y");
		lst1.add("es");
		lst1.add("z");
		lst1.add("cat");
		lst1.add("ab");

		List<String> lst2 = new ArrayList<String>();
		lst2.add("a");
		lst2.add("f");
		lst2.add("es");
		lst2.add("z");
		lst2.add("cat");
		lst2.add("h");

		input.add(lst0);
		input.add(lst1);
		input.add(lst2);

		return input;
	}
}
