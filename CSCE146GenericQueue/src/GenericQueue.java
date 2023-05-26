//Paksh Patel

class GenericQueue<T> {
private static class Node<T> {
private T data;
private Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

private Node<T> head;
private Node<T> tail;

public void enqueue(T data) {
    Node<T> node = new Node<>(data);
    if (tail == null) {
        head = node;
        tail = node;
    } else {
        tail.next = node;
        tail = node;
    }
}

public T dequeue() {
    if (head == null) {
        return null;
    }
    T data = head.data;
    head = head.next;
    if (head == null) {
        tail = null;
    }
    return data;
}

public boolean isEmpty() {
    return head == null;
}
}