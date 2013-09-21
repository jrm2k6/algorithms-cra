package job_interview_questions;

import java.util.ArrayList;
import java.util.EmptyStackException;;

public class MaximumStack {
	private ArrayList<Integer> elements;
	private ArrayList<Integer> maximums;
	
	public MaximumStack() {
		elements = new ArrayList<Integer>();
		maximums = new ArrayList<Integer>();
	}
	
	public void push(int e) {
		elements.add(e);
		
		if (maximums.size() > 0) {
			if (maximums.get(maximums.size() - 1) < e) {
				maximums.add(e);
			}
		} else {
			maximums.add(e);
		}
	}
	
	public int pop() {
		if (elements.size() == 0) throw new EmptyStackException();
		int lastElem = elements.get(elements.size() - 1);
		int indexMax = maximums.size() - 1;
		int currentMaximum = maximums.get(indexMax);
		elements.remove(elements.size() - 1);
		
		if (maximums.size() > 0 && lastElem == currentMaximum) {
			maximums.remove(indexMax);
		}
		return lastElem;
	}
	
	public int getMaximumInStack() {
		return maximums.get(maximums.size() - 1);
	}
	
	public void printStack() {
		for (int i = elements.size() - 1; i >= 0; i--) {
			String item = "| " + elements.get(i) + " |";
			String lines = new String(new char[item.length()]).replace("\0", "_");
			System.out.println(item);
			System.out.println(lines);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumStack stack = new MaximumStack();
		stack.push(3);
		stack.push(8);
		stack.push(6);
		stack.push(10);
		stack.printStack();
		System.out.println(stack.getMaximumInStack());
		stack.pop();
		stack.printStack();
		System.out.println(stack.getMaximumInStack());
	}

}
