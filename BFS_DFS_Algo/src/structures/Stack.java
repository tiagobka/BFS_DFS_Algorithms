package structures;

import interfaces.StackInt;

public class Stack extends linkedList implements StackInt{

	@Override
	public boolean empty() {
	
		if (this.getNumNodes() == 0)
			return true;
		
		return false;
	}

	@Override
	public Object peek() {

		// TODO Auto-generated method stub
		return this.getFirst();
	}

	@Override
	public void push(Object theObject) {
		// TODO Auto-generated method stub
		this.addFirst(theObject);
		
	}

	@Override
	public Object pop() {
		
		// TODO Auto-generated method stub
		if (empty())
			return null;
		
		return this.removeFirst();
	}

	
	
	
}
