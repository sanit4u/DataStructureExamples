package com.sanit4u.datastructure.custom.setOfStacks;

public class ImplTest {

	public static void main(String[] args) {
		SetOfStacks setOfStacks = new SetOfStacks(4);

		setOfStacks.push("1");
		setOfStacks.push("2");
		setOfStacks.push("3");
		setOfStacks.push("4");

		setOfStacks.push("5");
		setOfStacks.push("6");
		setOfStacks.push("7");
		setOfStacks.push("8");

		setOfStacks.push("9");
		setOfStacks.push("10");
		setOfStacks.push("11");
		setOfStacks.push("12");

		System.out.println(setOfStacks.size()); // should be 3
		assert setOfStacks.size() == 3;

		String pop = setOfStacks.pop();
		System.out.println(pop); // should be 12
		assert pop.equals("12");
		String pop1 = setOfStacks.pop();
		System.out.println(pop1); // should be 11
		assert pop.equals("11");

		String pop2 = setOfStacks.pop();
		System.out.println(pop2); // should be 10
		assert pop.equals("10");

		System.out.println(setOfStacks.size()); // should be 3
		assert setOfStacks.size() == 3;

		String popAt1 = setOfStacks.popAt(1);
		System.out.println(popAt1); // should be 8
		assert pop.equals("8");
		
		System.out.println(setOfStacks.size()); // should be 2
		assert setOfStacks.size() == 2;

	}

}
