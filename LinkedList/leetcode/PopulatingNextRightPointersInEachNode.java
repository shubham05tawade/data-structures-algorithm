class Node{
	
	public int val;
	public Node left;
	public Node right;
	public Node next;
	
	public Node() {};
	
	public Node(int val) {
		this.val = val;
	}
	
	public Node(int val, Node left, Node right, Node next){
		this.val = val;
		this.left = left;
		this.right = right;
		this.next = next;
	}
	
}

public class PopulatingNextRightPointersInEachNode{
	
	public static Node connect(Node root){
		if(root == null) return null;
        if(root.left != null) root.left.next = root.right;
        if(root.right != null && root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
	}
	
	public static void main(String args[]){
		int perfectBinaryTree[] = {1, 2, 3, 4, 5, 6, 7};
		Node root = new Node(perfectBinaryTree[0]);
		root.left = new Node(perfectBinaryTree[1]);
		root.right = new Node(perfectBinaryTree[2]);
		root.left.left = new Node(perfectBinaryTree[3]);
		root.left.right = new Node(perfectBinaryTree[4]);
		root.right.left = new Node(perfectBinaryTree[5]);
		root.right.right = new Node(perfectBinaryTree[6]);
		Node result = connect(root);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}