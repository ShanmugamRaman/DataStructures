package com.shan.algo.linear;

public class ParanthesisValidator {

	static class Stack {
		int top = -1;
		char[] items = new char[100];

		void push(char item) {
			if (top < 99) {
				items[++top] = item;
			} else {
				System.out.println("Stack full");
			}
		}

		char pop() {
			if (top >= 0) {
				char element = items[top];
				top--;
				return element;
			} else {
				System.out.println("Stack is empty..");
				return '\0';
			}
		}

		boolean isEmpty() {
			return top == -1;
		}

	}

	private static boolean areParenthesisBalanced(char[] exp) {
		Stack stack = new Stack();
		for (int i = 0; i < exp.length; i++) {
			if(exp[i] == '{' || exp[i] == '[' || exp[i] == '('  ) {
				stack.push(exp[i]);
			}else if(exp[i] == '}' || exp[i] == ']' || exp[i] == ')'  ) {
				if(stack.isEmpty()) {
					return false;
				}else if(!isMatchingCharacter(stack.pop(), exp[i])) {
					return false;
				}
			}
		}
		if(stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	private static boolean isMatchingCharacter(char c1, char c2) {
		if (c1 == '(' && c2 == ')')
			return true;
		else if (c1 == '{' && c2 == '}')
			return true;
		else if (c1 == '[' && c2 == ']')
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		char exp[] = { '{', '(', ')', '}', '[', ']' };
		if (areParenthesisBalanced(exp))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}

}
