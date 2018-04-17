package structures;

import interfaces.QueueInt;

public class Queue extends linkedList implements QueueInt{

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.getNumNodes() == 0)
			return true;
		
		return false;
	}

	@Override
	public Object getFrontElement() {
		// TODO Auto-generated method stub
		return  getFirst();
	}

	@Override
	public Object getRearElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(Object theObject) {
		// TODO Auto-generated method stub
		addLast(theObject);
	}

	@Override
	public Object remove() {
		
		// TODO Auto-generated method stub
		return removeFirst();
	}

}
