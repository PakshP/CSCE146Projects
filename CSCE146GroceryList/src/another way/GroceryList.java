public class GroceryList {
    private class ListNode {
        public GroceryItem data;
        public ListNode next;

        public ListNode(GroceryItem data) {
            this.data = data;
            this.next = null;
        }
    }

    private ListNode head; // Head node of the list
    private ListNode current; // Current node for traversal

    public GroceryList() {
        head = null;
        current = null;
    }

    public void addItem(GroceryItem item) {
        ListNode newNode = new ListNode(item);
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public double totalCost() {
        double total = 0;
        ListNode temp = head;
        while (temp != null) {
            total += temp.data.getValue();
            temp = temp.next;
        }
        return total;
    }

    public boolean contains(GroceryItem item) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.data.getName().equals(item.getName()) && temp.data.getValue() == item.getValue()) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public GroceryItem getCurrent() {
        if (current != null) {
            return current.data;
        }
        return null; // Or throw an exception
    }

    public void gotoNext() {
        if (current != null) {
            current = current.next;
        }
    }

    public void removeCurrent() {
        if (current == null) {
            return; // Or throw an exception
        }
        if (current == head) {
            head = head.next;
            current = head;
        } else {
            ListNode temp = head;
            while (temp.next != current) {
                temp = temp.next;
            }
            temp.next = current.next;
            current = current.next;
        }
    }

    public void showList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}