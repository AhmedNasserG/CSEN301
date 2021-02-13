package CSEN301.PA3;

public class ArrayStack {
	private int[] theStack;
	private int maxSize;
	private int top;

	public ArrayStack(int s) {
		maxSize = s;
		theStack = new int[maxSize];
		top = -1;
	}

	public void push(int elem) {
		top++;
		theStack[top] = elem;
	}

	public int pop() {
		int result = theStack[top];
		top--;
		return result;
	}

	public int top() {
		return theStack[top];
	}

	public boolean isFull() {
		return (top == (maxSize - 1));
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return (top + 1);
	}

	public void printStack() {
		if (top == -1)
			System.out.println("Stack is empty!!\n");
		else {
			System.out.println(theStack[top] + " <- top");
			for (int i = top - 1; i >= 0; i--)
				System.out.println(theStack[i]);
			System.out.println();
		}
	}

	public int search(int x){
		for (int i = 0; i < theStack.length; i++) {
			if(theStack[i] == x){
				return theStack.length - 1 - i;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		stack.push(5);
		stack.push(7);
		stack.push(1);
		stack.push(-5);
		System.out.println(stack.search(5));
	}


}