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
	
	//Recursive Contains
	public boolean rContains(Node node, int value){
		if(node == null) return false;
		if(value == node.value) return true;
		if(value < node.value){
			return rContains(node.left, value);
		}
		if(value > node.value){
			return rContains(node.right, value);
		}
		return false;
	}
	
	public boolean rContains(int value){
		return rContains(root, value);
	}
	
	//Recursive Insert
	public Node rInsert(Node node, int value){
		if(node == null) return new Node(value);
		if(value < node.value){
			return rInsert(node.left, value);
		}
		if(value > node.value){
			return rInsert(node.right, value);
		}
		return null;
	}
	
	public void rInsert(int value){
		if(root == null) root = new Node(value);
		rInsert(root, value);
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
		binarySearchTree.insert(51);
		binarySearchTree.insert(41);
		System.out.println(binarySearchTree.contains(50));
		System.out.println(binarySearchTree.contains(60));
		System.out.println(binarySearchTree.rContains(51));
		System.out.println(binarySearchTree.rContains(41));
	}
}