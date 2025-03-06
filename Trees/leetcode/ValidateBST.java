import java.util.*;

class BinarySearchTree{
	
	//Create Root Node
	private Node root;
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	class Node{
		int value;
		Node left;
		Node right;
		
		//Create Nodes
		public Node(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public Node getRoot(){
		return this.root;
	}
	
	public boolean insert(int value){
		Node newNode = new Node(value);
		//Add node to root if tree deosn't have any root
		if(root == null){
			this.root = newNode;
			return true;
		}
		Node temp = root;
		while(true){
			//Don't insert node if value to be inserted is already in tree
			if(newNode.value == temp.value) return false;
			//Append node to left of current Node if value to be inserted is less than current Node's value and also the left node should be null
			if(newNode.value < temp.value){
				if(temp.left == null){
					temp.left = newNode;
					return true;
				}
				temp = temp.left;
			}
			//Append node to right of current Node if value to be inserted is less than current Node's value and also right node should be null
			else{
				if(newNode.value > temp.value){
					if(temp.right == null){
						temp.right = newNode;
						return true;
					}
					temp = temp.right;
				}
			}
		}
	}
	
	public ArrayList<Integer> DFSInOrder(){
		ArrayList<Integer> results = new ArrayList<Integer>();
		//Traverse class is used to traverse in binary search tree such that we get values in arraylist like this [leftNodeValues..., root, rightNodeValues...]
		class Traverse{
			Traverse(Node currentNode){
				//Using recursion to traverse to the left most side of BST
				if(currentNode.left != null) {
					new Traverse(currentNode.left);
				}
				results.add(currentNode.value);
				//Using recursion to traverse to the right most side of BST
				if(currentNode.right != null) {
					new Traverse(currentNode.right);
				}
			}
		}
		//Using root node to traverse
		new Traverse(root);
		return results;
	}
	
	public boolean isValidBST(){
		ArrayList<Integer> binaryTreeList = DFSInOrder();
		boolean validBST = true;
		//check if previous value in arraylist is greater than or equal to current value, If yes set bool value to false and return the result
		for(int i=1; i<binaryTreeList.size(); i++){
			if(binaryTreeList.get(i - 1) >= binaryTreeList.get(i)){
				validBST = false;
				break;
			}
		}
		return validBST;
	}
}

public class ValidateBST{
	public static void main(String args[]){
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(100);
		binarySearchTree.insert(75);
		binarySearchTree.insert(125);
		binarySearchTree.insert(70);
		binarySearchTree.insert(80);
		binarySearchTree.insert(120);
		binarySearchTree.insert(130);
		System.out.println(binarySearchTree.isValidBST());
	}
}
