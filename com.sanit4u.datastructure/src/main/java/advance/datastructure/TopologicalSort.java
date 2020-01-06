package advance.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Example input is based on the link :
 * https://www.youtube.com/watch?v=ddTC4Zovtbc
 * 
 *
 */
public class TopologicalSort {

	public static void main(String[] args) {
		TopologicalSort topologicalSort = new TopologicalSort();

		int n = 8;
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		int vertex = 1, child = 3;
		List<Integer> value = graph.getOrDefault(vertex, new ArrayList<Integer>());
		value.add(child);
		graph.put(vertex, value);

		vertex = 2;
		child = 3;
		value = graph.getOrDefault(vertex, new ArrayList<Integer>());
		value.add(child);
		value.add(4);
		graph.put(vertex, value);

		vertex = 3;
		child = 5;
		value = graph.getOrDefault(vertex, new ArrayList<Integer>());
		value.add(child);
		graph.put(vertex, value);

		vertex = 5;
		child = 6;
		value = graph.getOrDefault(vertex, new ArrayList<Integer>());
		value.add(child);
		graph.put(vertex, value);

		vertex = 4;
		child = 6;
		value = graph.getOrDefault(vertex, new ArrayList<Integer>());
		value.add(child);
		graph.put(vertex, value);

		vertex = 6;
		child = 7;
		value = graph.getOrDefault(vertex, new ArrayList<Integer>());
		value.add(child);
		graph.put(vertex, value);

		vertex = 5;
		child = 8;
		value = graph.getOrDefault(vertex, new ArrayList<Integer>());
		value.add(child);
		graph.put(vertex, value);

		Stack<Integer> sorted = topologicalSort.topSort(n, graph);
		List<Integer> result = new ArrayList<Integer>();
		while (!sorted.isEmpty()) {
			result.add(sorted.pop());
		}
		System.out.println(result);
	}

	private Stack<Integer> topSort(int n, Map<Integer, List<Integer>> graph) {
		Stack<Integer> sorted = new Stack<Integer>();
		Set<Integer> visited = new HashSet<Integer>();

		for (int vertex = 1; vertex <= n; vertex++) {
			if (!visited.contains(vertex)) {
				topSortUtil(vertex, sorted, visited, graph);
			}
		}

		return sorted;
	}

	private void topSortUtil(int vertex, Stack<Integer> sorted, Set<Integer> visited,
			Map<Integer, List<Integer>> graph) {

		visited.add(vertex);

		List<Integer> children = graph.getOrDefault(vertex, new ArrayList<Integer>());

		for (Integer child : children) {
			if (visited.contains(child)) {
				continue;
			}

			topSortUtil(child, sorted, visited, graph);
		}

		sorted.push(vertex);
	}

}
