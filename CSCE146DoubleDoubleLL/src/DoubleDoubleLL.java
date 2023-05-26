//Paksh Patel

public class DoubleDoubleLL {
	
	private class Node {
		double data;
		Node next;
		Node prev;

		Node(double data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	//references to the head, tail, and current node in the list
	private Node head;
	private Node tail;
	private Node current;

	//Makes an empty list
	public DoubleDoubleLL() {
		head = null;
		tail = null;
		current = null;
	}

	//add node to end of linked list
	public void add(double data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	//add node after current node
	public void addAfterCurrent(double data) {
		if (current == null) {
			return;
		}
		Node newNode = new Node(data);
		newNode.next = current.next;
		if (current.next != null) {
			current.next.prev = newNode;
		}
		current.next = newNode;
		newNode.prev = current;
		if (newNode.next == null) {
			tail = newNode;
		}
	}

	//remove first node from the linked list
	public void remove(double data) {
		Node nodeToRemove = head;
		while (nodeToRemove != null && nodeToRemove.data != data) {
			nodeToRemove = nodeToRemove.next;
		}
		if (nodeToRemove == null) {
			return;
		}
		if (nodeToRemove == head) {
			head = nodeToRemove.next;
		} else {
			nodeToRemove.prev.next = nodeToRemove.next;
		}
		if (nodeToRemove == tail) {
			tail = nodeToRemove.prev;
		} else {
			nodeToRemove.next.prev = nodeToRemove.prev;
		}
	}
	
	//remove current node from the linked list
	public void removeCurrent() {
		if (current == null) {
			return;
		}
		if (current == head) {
			head = current.next;
		} else {
			current.prev.next = current.next;
		}
		if (current == tail) {
			tail = current.prev;
		} else {
			current.next.prev = current.prev;
		}
		current = current.next;
	}

	//checks linked list has data
	public boolean contains(double data) {
		Node nodeToCheck = head;
		while (nodeToCheck != null) {
			if (nodeToCheck.data == data) {
				return true;
			}
			nodeToCheck = nodeToCheck.next;
		}
		return false;
	}

	//sets current node to the head of the list
	public void reset() {
		current = head;
	}

	//sets current node to the tail of the list
	public void gotoEnd() {
		current = tail;
	}

	//moves node to next node
	public void gotoNext() {
		if (current != null) {
			current = current.next;
		}
	}

	//moves node to prev node
	public void gotoPrev() {
		if (current != null) {
			current = current.prev;
		}
	}

	//checks for more nodes to traverse in the list
	public boolean hasMore() {
		return current != null;
	}

	//returns data stored in the node
	public Double getCurrent() {
		return current != null ? current.data : null;
	}

	//sets data stored in the node to the given value
	public void setCurrent(double data) {
		if (current != null) {
			current.data = data;
		}
	}

	//prints out values stored in each node
	public void print() {
		Node nodeToPrint = head;
		while (nodeToPrint != null) {
			System.out.print(nodeToPrint.data + " ");
			nodeToPrint = nodeToPrint.next;
		}
		System.out.println();
	}
}