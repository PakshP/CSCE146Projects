//Paksh Patel

public class GroceryList {

	// A private class representing a node in the linked list
	private class ListNode {
		private GroceryItem data;
		private ListNode link; 

		// Constructor for creating an empty node
		public ListNode() {
			this.data = null;
			this.link = null;
		}

		// Constructor for creating a node with data and a link to the next node
		public ListNode(GroceryItem data, ListNode link) {
			this.data = data;
			this.link = link;
		}
	}

	private ListNode head;
	private ListNode current;
	private ListNode previous;

	// Constructor for creating an empty grocery list
	public GroceryList() {
		head = new ListNode();
		current = head;
		previous = null;
	}

	// Move the current node to the next node in the list
	public void gotoNext() {
		if (current != null) {
			previous = current;
			current = current.link;
		}
	}

	// Get the data stored in the current node
	public GroceryItem getCurrent() {
		if (current != null) {
			return current.data;
		} else {
			return null;
		}
	}

	// Set the data stored in the current node
	public void setCurrent(GroceryItem data) {
		if (current != null && data != null) {
			current.data = data;
		}
	}

	// Add a new item to the end of the list
	public void addItem(GroceryItem item) {
		if (item == null) {
			return;
		}

		// Create a new node with the given item
		ListNode newNode = new ListNode(item, null);

		// If the list is empty, add the new node as the head
		if (head.link == null) {
			head.link = newNode;
			current = newNode;
			return;
		}

		// Traverse the list to find the last node
		ListNode temp = head.link;
		while (temp.link != null) {
			temp = temp.link;
		}

		// Add the new node to the end of the list
		temp.link = newNode;
	}

	// Add a new item after the current node
	public void addItemAfterCurrent(GroceryItem item) {
		if (current == null || item == null) {
			return;
		}

		ListNode newNode = new ListNode(item, current.link);

		current.link = newNode;
	}

	// Remove the current node from the list
	public void removeCurrent() {
		if (current == null) {
			return;
		}
		if (this.previous == null) {
			return;
		}

		previous.link = current.link;
		current = current.link;
	}

	// Print the data stored in each node in the list
	public void showList() {
		ListNode temp = head.link;
		while (temp != null) {
			System.out.println(temp.data.toString());
			temp = temp.link;
		}
	}

	public boolean contains(GroceryItem item) {
		ListNode temp = head.link;

		while (temp != null) {
			if (temp.data.equals(item)) {
				return true;
			}
			temp = temp.link;
		}

		return false;
	}

	public double totalCost() {
		double total = 0;
		ListNode temp = head.link;

		while (temp != null) {
			total += temp.data.getValue();
			temp = temp.link;
		}

		return total;
	}
}
