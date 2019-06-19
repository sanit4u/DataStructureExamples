package com.sanit4u.datastructure.custom.setOfStacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This SetOfStacks should create a new stack when the previous stack exceeds
 * the capacity. It should be composed of several stacks. It has similar
 * behavior of single stack.pop, push. Additionally, it should have popAt(index)
 * this performs pop operation on the specific task.
 * 
 * 
 */
public class SetOfStacks {

	List<Stack<String>> stacks = new ArrayList<Stack<String>>();
	private int stackCapacity = 10;

	public SetOfStacks(int stackCapacity) {
		this.stackCapacity = stackCapacity;
	}

	public int size() {
		return stacks.size();
	}

	public void push(String value) {

		Stack<String> lastStack = getLastStack();
		if (lastStack != null && !isStackFull(lastStack)) {
			lastStack.push(value);
		} else {
			Stack<String> stack = new Stack<String>();
			stack.push(value);
			stacks.add(stack);
		}
	}

	public String pop() {
		Stack<String> lastStack = getLastStack();

		if (lastStack == null) {
			return null;
		}

		String popedElement = lastStack.pop();
		if (lastStack.isEmpty()) {
			stacks.remove(stacks.size() - 1); // removes the last stack
		}
		return popedElement;
	}

	/**
	 * This would pop the element of the corresponding stack present at the given
	 * index of the setofstacks. Then the subsequent stacks bottom element needs to
	 * be pushed to the previous stacks top.F
	 * 
	 * @param index
	 * @return
	 */
	public String popAt(int index) {

		if (index > stackCapacity - 1) {
			throw new IndexOutOfBoundsException();
		}

		Stack<String> stack = stacks.get(index);

		String popedElement = stack.pop();

		Stack<String> previousStack = stack;
		Stack<String> nextStack = null;
		if (stacks.size() > index + 1) {
			int nextStackIndex = index + 1;
			for (; nextStackIndex < stacks.size(); nextStackIndex++) {

				// next stack in the setofstack
				nextStack = stacks.get(nextStackIndex);
				// if the current stack is empty,
				if (nextStack.isEmpty()) {
					stacks.remove(nextStackIndex);
					// remove the current stack from the set of stacks and no need to go for rolling
					// over.
					break;
				}

				// remove the bottom element for pushing it to the previous stack: rolling over
				String buttonElement = nextStack.remove(nextStack.size() - 1);
				// push it to the previous stack
				previousStack.push(buttonElement);
				// set the current stack to previous stack for the next iteration
				previousStack = nextStack;
			}

			if (nextStack.isEmpty()) {
				stacks.remove(--nextStackIndex);
			}
		}

		return popedElement;
	}

	private Stack<String> getLastStack() {

		if (stacks.isEmpty()) {

			return null;
		}

		return stacks.get(stacks.size() - 1);
	}

	private boolean isStackFull(Stack stack) {
		// here capacity is not used, since, as soon as the elements are pushed to the
		// java.util.stack, the capacity doubles. Size provides the actual number of
		// elements in the stack.
		return (stack.size() >= stackCapacity);
	}
}
