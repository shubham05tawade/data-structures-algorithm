class BinarySearchTree{
	Node root;
	
	class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	public boolean insert(int value){
		Node newNode = new Node(value);
		if(root == null){
			root = newNode;
			return true;
		}
		Node temp = root;
		while(true){
			if(value == temp.value) return false;
			if(value < temp.value){
				if(temp.left != null) {
					temp = temp.left;
				}
				else{
					temp.left = newNode;
					return true;					
				}
				
			}
			if(value > temp.value){
				if(temp.right != null) {
					temp = temp.right;
				}
				else{
					temp.right = newNode;
					return true;
				}
			}
		}
	}
	
	public boolean contains(int value){
		Node temp = root;
		while(temp != null){
			if(temp.value == value) return true;
			if(value < temp.value){
				temp = temp.left;
			}
			if(value > temp.value){
				temp = temp.right;
			}
		}
		return false;
	}
}

class BinarySearchTreeMain{
	public static void main(String[] args){
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(30);
		binarySearchTree.insert(15);
		binarySearchTree.insert(45);
		binarySearchTree.insert(10);
		binarySearchTree.insert(20);
		binarySearchTree.insert(40);
		binarySearchTree.insert(50);
		System.out.println(binarySearchTree.contains(50));
		System.out.println(binarySearchTree.contains(60));
	}
}