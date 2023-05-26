//Paksh Patel

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinHeap<T> {
    private List<T> heap;
    private Comparator<T> comparator;

    public MinHeap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    public void add(T element) {
        heap.add(element);
        int currentIndex = heap.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (comparator.compare(heap.get(currentIndex), heap.get(parentIndex)) < 0) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public T remove() {
        if (heap.isEmpty()) {
            return null;
        }

        T minElement = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        int currentIndex = 0;
        while (true) {
            int leftChildIndex = currentIndex * 2 + 1;
            int rightChildIndex = currentIndex * 2 + 2;
            int smallestChildIndex = -1;

            if (leftChildIndex < heap.size()) {
                smallestChildIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() &&
                    comparator.compare(heap.get(rightChildIndex), heap.get(leftChildIndex)) < 0) {
                smallestChildIndex = rightChildIndex;
            }

            if (smallestChildIndex != -1 &&
                    comparator.compare(heap.get(smallestChildIndex), heap.get(currentIndex)) < 0) {
                swap(currentIndex, smallestChildIndex);
                currentIndex = smallestChildIndex;
            } else {
                break;
            }
        }

        return minElement;
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
}
