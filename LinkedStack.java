public class LinkedStack<E> {
	
	private class Node {

		private E data;
		private Node next;
		private Node(E data){

			this.data = data;
		}


	}

	private int size;
	private Node top;

	public boolean isEmpty(){
		return top == null;
	}
	
	public E peek(){
		return top.data;
	}

	public void push(E data){
		Node node = new Node(data);
		node.next = top;
		top = node;
		size++;

	}

	public int size(){
		return size;
	}

	// public E top(){

	// 	return top.data;
	// }

	public E pop(){
		E data = top.data;
		top = top.next;
		size--;
		return data;
	}


}