package minStack;

import java.util.ArrayList;

/* For Managing Space Issues (If Maintaining 2*Num of Ints is a Problem), We Could Alternatively Just Use an Instance Var to Keep Track of Min */
public class minStack {
	ArrayList<Entry> entries;
	int stackPointer;

	public minStack() {
		entries = new ArrayList<Entry>();
		stackPointer = 0;
	}

	public static void main(String[] args) {
		minStack stack = new minStack();
		stack.runTests();
		return;
	}

	public void runTests() {
		push(1);
		push(2);
		push(3);
		if (min() != 1)
			System.out.println("Push/Min 1 Failed");
		push(0);
		if (min() != 0)
			System.out.println("Push/Min 2 Failed");
		pop();
		if (min() != 1)
			System.out.println("Pop/Min Failed");
		pop();
		pop();
		pop();
		if (isEmpty() != true)
			System.out.println("isEmpty/Pop Failed");
		System.out.println("Finished Testing Min Stacks");
		return;
	}

	public void push(int val) {
		if (stackPointer == 0) {
			Entry newEntry = new Entry(val, val);
			if (this.stackPointer < this.entries.size()) entries.set(stackPointer, newEntry);
			else entries.add(newEntry);
			entries.set(stackPointer, newEntry);
			stackPointer += 1;
		} else {
			Entry newEntry, currTop = entries.get(stackPointer - 1);
			if (currTop.min >= val) newEntry = new Entry(val, val);
			else newEntry = new Entry(val, currTop.min);
			if (this.stackPointer < this.entries.size()) entries.set(stackPointer, newEntry);
			else entries.add(newEntry);
			stackPointer += 1;
		}
		return;
	}

	/* If Stack is Empty, We Will Return Zero, You Should Check for Emptiness Before Doing a Pop */
	public int pop() {
		int ret = 0;
		if (stackPointer == 0) return ret;
		else {
			stackPointer -= 1;
			Entry currTop = entries.get(stackPointer);
			ret = currTop.val;
		}
		return ret;
	}

	/* If Stack is Empty, We Will Return Zero, You Should Check for Emptiness Before Doing a Peek */
	public int peek() {
		int ret = 0;
		if (stackPointer == 0) return ret;
		else {
			Entry currTop = entries.get(stackPointer - 1);
			ret = currTop.val;
		}
		return ret;
	}

	public boolean isEmpty() {
		if (stackPointer == 0) return true;
		return false;
	}

	/* If Stack is Empty, min Will Return 0, You Should Check for Emptiness Before Doing a min */
	public int min() {
		int ret = 0;
		if (stackPointer == 0) return ret;
		else {
			Entry currTop = entries.get(stackPointer - 1);
			ret = currTop.min;
		}
		return ret;
	}
}

class Entry {
	public int val;
	public int min;

	public Entry(int v, int m) {
		this.val = v;
		this.min = m;
	}
}


