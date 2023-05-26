import java.util.Arrays;
import java.util.NoSuchElementException;

/*
 * <<Paksh Patel>>
 * CSCE 146 S2023 ExamFinal Question03
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter------------------------------------------------------------------------
public class Question03 
{
	private ShippingContainer[] heap = new ShippingContainer[10];
	public int size;//First null element
		
	public void add(ShippingContainer aData)
	{
//------------------------------------------------------------------------------------	
		//Write your code here
	    if (size == heap.length) {
	        // resize the heap if necessary
	        heap = Arrays.copyOf(heap, heap.length * 2);
	    }
	    heap[size] = aData;
	    size++;

	    // bubble up the new element
	    int index = size - 1;
	    while (index > 0 && getVolume(heap[index]) > getVolume(heap[parent(index)])) {
	        swap(index, parent(index));
	        index = parent(index);
	    }

	}//Do not alter

//Do not alter------------------------------------------------------------------------	
	public ShippingContainer remove()
	{
//------------------------------------------------------------------------------------	
		//Write your code here
		if (size == 0) {
	        throw new NoSuchElementException("Heap is empty");
	    }

	    ShippingContainer root = heap[0];
	    size--;

	    if (size == 0) {
	        heap[0] = null;
	        return root;
	    }

	    heap[0] = heap[size];
	    heap[size] = null;

	    // bubble down the new root element
	    int index = 0;
	    while (hasLeftChild(index)) {
	        int largerChildIndex = leftChildIndex(index);
	        if (hasRightChild(index) && getVolume(heap[rightChildIndex(index)]) > getVolume(heap[largerChildIndex])) {
	            largerChildIndex = rightChildIndex(index);
	        }
	        if (getVolume(heap[index]) > getVolume(heap[largerChildIndex])) {
	            break;
	        } else {
	            swap(index, largerChildIndex);
	            index = largerChildIndex;
	        }
	    }

	    return root;
	}//Do not alter

	//Write any additional helper properties or methods here
	private int parent(int index) {
	    return (index - 1) / 2;
	}

	private int leftChildIndex(int index) {
	    return index * 2 + 1;
	}

	private int rightChildIndex(int index) {
	    return index * 2 + 2;
	}

	private boolean hasLeftChild(int index) {
	    return leftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
	    return rightChildIndex(index) < size;
	}

	private void swap(int i, int j) {
	    ShippingContainer temp = heap[i];
	    heap[i] = heap[j];
	    heap[j] = temp;
	}

	private double getVolume(ShippingContainer c) {
	    return c.getLength() * c.getWidth() * c.getHeight();
	}
	
	//--------------------------------------------------------------------------------
//Do not alter------------------------------------------------------------------------

	public void printBreadthOrder()
	{
		for(ShippingContainer c : this.heap)
		{
			if(c != null)
				System.out.print(c+", ");
			else
				System.out.print("null, ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		System.out.println("Testing the Add Method");
		
		ShippingContainer[] array = {
				new ShippingContainer("Container00",10.0,20.0,30.0),
				new ShippingContainer("Container01",80.0,70.0,60.),
				new ShippingContainer("Container02",65.0,75.0,85.0),
				new ShippingContainer("Container03",3.0,4.0,5.0),
				new ShippingContainer("Container04",44.0,54.0,64.0),
				new ShippingContainer("Container05",52.0,31.0,20.0),
				new ShippingContainer("Container06",555.0,1.0,1.0),
				new ShippingContainer("Container07",37.0,27.0,47.0),
				new ShippingContainer("Container08",44.0,32.0,21.0),
				new ShippingContainer("Container09",9.0,8.0,7.0)};
		
		Question03 heap = new Question03();
		for(ShippingContainer c : array)
			heap.add(c);
		heap.printBreadthOrder();
		
		System.out.println("Testing the Remove Method");
		for(int i=0;i<array.length;i++)
			System.out.print(heap.remove()+", ");
	}
	//--------------------------------------------------------------------------------

}//Do not alter
