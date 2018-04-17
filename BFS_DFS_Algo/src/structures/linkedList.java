package structures;

import interfaces.LinkedList;



public class linkedList implements LinkedList{
	private node header;
	private node tail;
	private int numNodes;
	
	public linkedList(){
		tail = new node("tail");
		header = new node(null, tail);
		
		
	}
	
	
	@Override
	public void addFirst(Object o) {
		// TODO Auto-generated method stub
		node temp = new node(o);
		
		temp.setNext(header.getNext());
		header.setNext(temp);
		setNumNodes(getNumNodes() + 1);
		
	}

	@Override
	public void addLast(Object o) {
		// TODO Auto-generated method stub
		node temp = new node(o);
		node current = header;

		while(current.getNext().getData() != "tail")
		{
			current = current.getNext();
		}
	
		temp.setNext(current.getNext());
		current.setNext(temp);
		setNumNodes(getNumNodes() + 1);// increment the number of elements variable
	}

	@Override
	public Object getFirst() {
		// TODO Auto-generated method stub
		return header.getNext();
	}

	@Override
	public Object getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object removeFirst() {
		// TODO Auto-generated method stub
		node temp = header.getNext();
		header.setNext(temp.getNext());
		
		//bye bye in garbage collector
		//header.getNext().setNext(null);
		//header.getNext().setData(null);
		numNodes--;
		return temp.getData();
	}

	@Override
	public Object removeLast() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getNumNodes() {
		return numNodes;
	}


	public void setNumNodes(int numNodes) {
		this.numNodes = numNodes;
	}

}
