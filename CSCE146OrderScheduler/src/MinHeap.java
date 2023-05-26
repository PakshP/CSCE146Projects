//Paksh Patel

import java.util.ArrayList;

// MinHeap class
class MinHeap<E extends Comparable<E>> {
	private ArrayList<E> heap;

	public MinHeap() {
		heap = new ArrayList<>();
	}

	public void add(E element) {
		heap.add(element);
		int currentIndex = heap.size() - 1;
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) < 0) {
				E temp = heap.get(currentIndex);
				heap.set(currentIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				currentIndex = parentIndex;
			} else {
				break;
			}
		}
	}

	public E remove() {
		if (heap.isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}

		E removedElement = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);

		int currentIndex = 0;
		while (currentIndex < heap.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;

			if (leftChildIndex >= heap.size()) {
				break; // No child nodes
			}

			int minChildIndex = leftChildIndex; // Assume left child is the minimum

			if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(leftChildIndex)) < 0) {
				minChildIndex = rightChildIndex; // Update to right child if it is smaller
			}

			if (heap.get(currentIndex).compareTo(heap.get(minChildIndex)) > 0) {
				E temp = heap.get(currentIndex);
				heap.set(currentIndex, heap.get(minChildIndex));
				heap.set(minChildIndex, temp);
				currentIndex = minChildIndex;
			} else {
				break;
			}
		}

		return removedElement;
	}

	public E peek() {
		if (heap.isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}
		return heap.get(0);
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}

	public int size() {
		return heap.size();
	}

}