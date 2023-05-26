//Paksh Patel

public interface QueueI<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    int size();
}