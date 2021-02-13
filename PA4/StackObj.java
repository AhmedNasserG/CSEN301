package CSEN301.PA4;

public class StackObj
{
	private Object[] theStack;
	private int maxSize;	
	private int top;

	public StackObj(int s)
	{
		maxSize = s;
		theStack = new Object[maxSize];
		top = -1;
	}	

	public void push(Object elem)
	{
		top++;
		theStack[top] = elem;
	}

	public Object pop()
	{
		Object result = theStack[top];
		top--;
		return result;
	}

	public Object top()
	{
		return theStack[top];
	}

	public boolean isFull()
	{
		return (top == (maxSize-1) );
	}

	public boolean isEmpty()
	{
		return (top == -1);
	}

	public int size() 
	{
		return (top+1);
	}

	public void printStack()
	{
		if(top == -1)
			System.out.println("Stack is empty!!\n");
		else
		{
			//will use the toString() method of the objects stored in the stack
			System.out.println(theStack[top]+" <- top");
			for(int i=top-1; i>=0; i--)
				System.out.println(theStack[i]);
			System.out.println();
		}
	}
}