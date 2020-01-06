package com.sanit4u.datastructure.failsafeiter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class FailFASTSAFEITeratorOperations {
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		list.add("a");
		list.add("b");
		list.add("c");
		list.add("example0");
		list.add("example1");
		list.add("d");

//		// Causes Concurrent Modification
//		concurrentCause(list);

		System.out.println("Adding example 2 list");
		list.add("example2");
		System.out.println(list);
		iteratorRemoval(list);

		// To avoid the concurrent modification for adding while iteration , we
		// should use ListIterator
		listIterator4Add(list);

		System.out.println("after add");
		System.out.println(list);
	}

	private static void listIterator4Add(List<String> list) {
		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			String string = (String) listIterator.next();
			if (string.equals("d")) {
				listIterator.add("new Example");
			}
		}
	}

	private static void iteratorRemoval(List<String> list) {
		// To avoid the concurrent modification for removing while iteration ,
		// we should use iterator
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			if (string.length() > 1) {
				iterator.remove();
			}
		}
		System.out.println("after remove using iterator");
		System.out.println(list);
	}

	private static void concurrentCause(List<String> list) {
		for (String string : list) {
			if (string.length() > 1) {
				list.remove(string);
			}
		}
		System.out.println("after remove [foreach]");
		System.out.println(list);
	}
}
