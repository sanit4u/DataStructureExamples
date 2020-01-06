package FailsafeIteratorOperations;

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
		list.add("pintu");
		list.add("d");

		// // causes concurrentModificationException
		// for (String string : list) {
		// if (string.length() > 1) {
		// list.remove(string);
		// }
		// }
		// System.out.println("after remove [foreach]");
		// System.out.println(list);
		//
		// System.out.println("Adding pintu 2 list");
		// list.add("pintu2");
		System.out.println(list);
		// To avoid the concurrent modification for removing while iteration ,
		// we should use iterator
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			if (string.length() > 1) {
				list.remove(string);
			}
		}
		System.out.println("after remove using iterator");
		System.out.println(list);

		// To avoid the concurrent modification for adding while iteration , we
		// should use ListIterator
		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			String string = (String) listIterator.next();
			if (string.equals("d")) {
				listIterator.add("new Pintu");
				// listIterator.remove();
			}
		}

		System.out.println("after add");
		System.out.println(list);

	}
}
