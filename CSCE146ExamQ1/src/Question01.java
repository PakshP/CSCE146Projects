/*
 * <<Paksh Patel>>
 * CSCE 146 S2023 FinalExam Question01
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question01 {

	private class ListNode {
		PepperoniPizza data;
		ListNode link;

		public ListNode(PepperoniPizza aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	private ListNode head;
	private ListNode curr;
	private ListNode prev;

	public void removePizzasWithLessThan(int pepperonis) {
//-----------------------------------------------------------------------------------	
		// Write your solution here

		//Start at the beginning of list
		curr = head;
		//Keep track of the previous node in the list
		prev = null;
		while (curr != null) {
			//Check if the current node's pizza has fewer pepperonis than the specified amount
			if (curr.data.getPepperonis() < pepperonis) {
				//if so then remove
				if (prev == null) {
					head = curr.link;
				} else {
					//otherwise, skip over
					prev.link = curr.link;
				}
			} else {
				//if pepperoni count is the same as specified than keep on list
				prev = curr;
			}
			//Move to next
			curr = curr.link;
		}
	}

	// --------------------------------------------------------------------------------
//Do not alter-----------------------------------------------------------------------
	public void setTest01() {
		head = new ListNode(new PepperoniPizza(10),
				new ListNode(new PepperoniPizza(20),
						new ListNode(new PepperoniPizza(30), new ListNode(new PepperoniPizza(40),
								new ListNode(new PepperoniPizza(50), new ListNode(new PepperoniPizza(60), null))))));
	}

	public void setTest02() {
		head = new ListNode(new PepperoniPizza(80),
				new ListNode(new PepperoniPizza(20), new ListNode(new PepperoniPizza(50),
						new ListNode(new PepperoniPizza(60), new ListNode(new PepperoniPizza(10), null)))));
	}

	public void setTest03() {
		head = new ListNode(new PepperoniPizza(10),
				new ListNode(new PepperoniPizza(20),
						new ListNode(new PepperoniPizza(30), new ListNode(new PepperoniPizza(40),
								new ListNode(new PepperoniPizza(50), new ListNode(new PepperoniPizza(60), null))))));
	}

	public void printList() {
		if (head == null)
			System.out.print("Empty List");
		for (ListNode temp = head; temp != null; temp = temp.link)
			System.out.print(temp.data + ", ");
	}

//-----------------------------------------------------------------------------------	
	// Test your code here. You may alter this as needed.
	public static void main(String[] args) {
		Question01 linkedList = new Question01();
		System.out.println("Testing with pizzas that have the values {10,20,30,40,50,60} and removing less than 30");
		linkedList.setTest01();
		linkedList.removePizzasWithLessThan(30);
		linkedList.printList();
		System.out.println();

		System.out.println("Testing with pizzas that have the values {80, 20, 50, 60, 10} and removing less than 50");
		linkedList.setTest02();
		linkedList.removePizzasWithLessThan(50);
		linkedList.printList();
		System.out.println();

		System.out.println("Testing with pizzas that have the values {10,20,30,40,50,60} and removing less than 100");
		linkedList.setTest03();
		linkedList.removePizzasWithLessThan(100);
		;
		linkedList.printList();
		System.out.println();
	}
	// --------------------------------------------------------------------------------
}// Do not alter this