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
	
	public int minValue(Node node){
		while(node.left != null){
			node = node.left;
		}
		return node.value;
	}
	
	public Node rDelete(Node node, int value){
		//Return null if value isn't found in BST
		if(node == null) return null;
		//Traverse to left of BST if value is less than current node value
		if(value < node.value){
			node.left = rDelete(node.left, value);
		}
		//Traverse to left of BST if value is less than current node value
		else if(value > node.value){
			node.right = rDelete(node.right, value);
		}
		else{
			//Return null if left and right node of current node is null
			if(node.left == null && node.right == null){
				return null;
			}
			//Set current node to right node if left node is null
			else if(node.left == null){
				node = node.right;
			}
			//Set current node to left node if right node is null
			else if(node.right == null){
				node = node.left;
			}
			else{
				//Get Minimum value from the right node's subtree
				int subTreeMin = minValue(node.right);
				//Replace the current node value with minValue
				node.value = subTreeMin;
				//Delete node
				node.right = rDelete(node.right, subTreeMin);
			}
		}
		return node;
	}
	
	//Get value to delete
	public void rDelete(int value){
		rDelete(root, value);
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
		binarySearchTree.rDelete(41);
		System.out.println(binarySearchTree.rContains(41));
	}
}