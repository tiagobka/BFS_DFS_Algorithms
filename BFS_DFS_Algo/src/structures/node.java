package structures;

public class node {

	private node next;
	private Object data;
	
	
	public node(Object dataValue) {
		next = null;
		data = dataValue;
	}
	
	public node(Object dataValue, node nextValue) {
		next = nextValue;
		data = dataValue;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object dataValue) {
		data = dataValue;
	}

	public node getNext() {
		return next;
	}

	public void setNext(node nextValue) {
		next = nextValue;
	}
	
}
