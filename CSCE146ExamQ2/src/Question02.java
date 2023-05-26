/*
 * <<Paksh Patel>>
 * CSCE 146 S2023 ExamFinal Question02
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 * Testing is encouraged but remove all testing code before turning it in.
 */
//Do not alter-----------------------------------------------------------------------
public class Question02 {
	public class Node // public for testing purposes
	{
		private Bucket data;
		private Node leftChild;
		private Node rightChild;

		public Node(Bucket aData) {
			this.data = aData;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	public Node root; // public for testing purposes

	public void add(Bucket aData) {
//-----------------------------------------------------------------------------------
		// Write your solution here
		Node newNode = new Node(aData);
		// empty tree
		if (root == null) 
		{
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			// go left
			if (aData.getWeight() < current.data.getWeight()) 
			{
				current = current.leftChild;
				// found insertion point
				if (current == null) 
				{
					parent.leftChild = newNode;
					return;
				}
			} else // go right
			{
				current = current.rightChild;
				// found insertion point
				if (current == null) 
				{
					parent.rightChild = newNode;
					return;
				}
			}
		}

	}// Do not alter this

//Do not alter-----------------------------------------------------------------------	
	public Bucket getHeaviestBucket() {
//-----------------------------------------------------------------------------------
		// Write your solution here
		// empty tree
		if(root == null) 
	        return null;
	    Node current = root;
	    while(current.rightChild != null)
	        current = current.rightChild;
	    return current.data;
	}// Do not alter this

	public Bucket getLightestBucket() {
//-----------------------------------------------------------------------------------
		// Write your solution here
		// empty tree
		if(root == null) 
	        return null;
	    Node current = root;
	    while(current.leftChild != null)
	        current = current.leftChild;
	    return current.data;
	}// Do not alter this

	// Write additional methods or properties here

	// --------------------------------------------------------------------------------
//Do not alter------------------------------------------------------------------------
	public void printPreorder() {
		printPreorder(root);
	}

	private void printPreorder(Node aNode) {
		if (aNode == null) {
			System.out.print("leaf, ");
			return;
		}
		System.out.print(aNode.data + ", ");
		printPreorder(aNode.leftChild);
		printPreorder(aNode.rightChild);
	}

//-----------------------------------------------------------------------------------
	// Test your code here. You may alter this as needed.
	public static void main(String[] args) {
		System.out.println("Adding Bucket to Bucket tree");
		Bucket[] buckets = { new Bucket(2100), new Bucket(600), new Bucket(1200), new Bucket(20), new Bucket(1000),
				new Bucket(7000), new Bucket(50), new Bucket(3000), new Bucket(2222) };
		Question02 tree = new Question02();
		for (Bucket b : buckets)
			tree.add(b);
		System.out.println("Printing the preorder traversal of Buckets");
		tree.printPreorder();

		System.out.println("\nThe Heaviest Bucket is: " + tree.getHeaviestBucket());
		System.out.println("The Lightest Bucket is: " + tree.getLightestBucket());

		System.out.println("Adding more buckets");
		tree.add(new Bucket(5));
		tree.add(new Bucket(10000));

		System.out.println("Printing the preorder traversal of Buckets");
		tree.printPreorder();

		System.out.println("\nThe Heaviest Bucket is: " + tree.getHeaviestBucket());
		System.out.println("The Lightest Bucket is: " + tree.getLightestBucket());

	}
	// --------------------------------------------------------------------------------
}// Do not alter this

/*Solution Description
 * 
 * ADD METHOD:
 * To add a bucket to the binary search tree, we first need to compare its weight with 
 * the weight of the root node. If the weight of the bucket to be added is 
 * less than the weight of the root node, we add the bucket to the left subtree; 
 * otherwise, we add it to the right subtree. We repeat this process recursively until 
 * we find the appropriate position for the new bucket. 
 * 
 * GETHEAVIESTBUCKET METHOD:
 * To find the heaviest bucket, we traverse the right subtree of the root node, since the
 * heaviest bucket will be the rightmost node in the tree.
 * 
 * GETLIGHTESTBUCKET METHOD:
 * to find the lightest bucket, we traverse the left subtree of the root node, since the 
 * lightest bucket will be the leftmost node in the tree.
 * 
 */
