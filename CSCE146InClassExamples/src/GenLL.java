//Generic Link Lists
public class GenLL <T>{
	private class ListNode
	{
		T data;
		ListNode link; //REF TO THE NEXT NODE
		public ListNode(T aData, ListNode aLink) 
		{		
			this.data = aData;
			this.link = aLink;	
		}
	}
	private ListNode head;//REF TO FIRST ELEMENT
	private ListNode current; //MOVEABLE REF - USED OUTISED THIS CLASS
	private ListNode previous; //REF ONE BEHIND CURRENT previous.link == current
	private int size;
	public GenLL() 
	{
		head = current = previous = null;
		this.size = 0;	
	}
	//ADD TO THE END OF THE LIST
	//Head -> |0| -> |1| -> |2| -> X
	public void add(T aData) 
	{
		if(aData == null)
			return;
		ListNode newNode = new ListNode(aData,null);
		if(head == null)//EMPTY LIST
		{		
			head = current = newNode;
			this.size = 1;
			return;	
		}
		ListNode temp = head;
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode;
		this.size++;
	}
	public void print() 
	{	
		for(ListNode temp = head; temp != null; temp = temp.link) 		
			System.out.println(temp.data);
			System.out.println();	
		}
		// |1| -> |2| -> |3| -> |4| -> X
		// head  prev   curr
		public void addAfterCurrent (T aData) 
		{
			if(aData == null || current == null)
				return;
			ListNode newNode = new ListNode(aData,current.link);
			current.link = newNode;
			this.size++;	
		}
		public T getCurrent()
		{
			if(current == null)
				return null;
			return current.data;	
		}
		public void setCurrent(T aData) 
		{	
			if(aData == null || current == null)
				return;
			current.data = aData;	
		}
		public void gotoNext()
		{	
			if(current == null)
				return;
			previous = current;
			current = current.link;	
		}
		public void reset()
		{	
			current = head;
			previous = null;	
		}
		public boolean hasMore() 
		{	
			return current != null;	
		}
		public void removeCurrent()
		{
			if(head == current)
			{		
				head = head.link;
				current = head;	
			}
			else 
			{	
				previous.link = current.link;
				current = current.link;	
			}
			if(this.size > 0)
				this.size--;
		}
		public int getSize() 
		{
			return this.size;
		}
}