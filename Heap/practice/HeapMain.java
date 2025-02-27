import java.util.*;

class Heap{
	
	private ArrayList<Integer> heap;
	
	public Heap(){
		this.heap = new ArrayList<Integer>();
	}
	
	//Get index of left child
	private int leftChild(int index){
		return 2 * index + 1;
	}
	
	//Get index of right child
	private int rightChild(int index){
		return 2 * index + 2;
	}
	
	//Get index of parent
	private int parent(int index){
		return (index - 1) / 2 ;
	}
	
	//Swap two nodes
	private void swap(int index1, int index2){
		int temp = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}
	
	//Insert node
	public void insert(int value){
		//Add node to the end of list
		heap.add(value);
		int current = heap.size() - 1;
		//iterate loop till we reach left end of list or find parent node greater than child
		while(current > 0 && heap.get(current) > heap.get(parent(current))){
			//swap if child node is greater than parent
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	public void sinkDown(int index){
		int maxIndex = index;
		while(true){
			int leftIndex = heap.get(index);
			int rightIndex = heap.get(index);
			
			//check if leftchild has value greater than parent 
			if(leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)){
				maxIndex = leftIndex;
			}
			//check if rightchild has value greater than parent
			if(rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)){
				maxIndex = rightIndex;
			}
			//if any child has value greater than parent then perform swap operation
			if(maxIndex != index){
				swap(maxIndex, index);
				index = maxIndex;
			}
			//if the parent node is greater than left and right child that mean we have highest node on top so end the loop
			else{
				return;
			}
		}
	}
	
	public Integer remove(){
		if(heap.size() == 0) return null;
		if(heap.size() == 1){
			return heap.remove(0);
		}
		//Always remove top most node from heap
		int max = heap.get(0);
		//Replace the first node with last node
		heap.set(0, heap.remove(heap.size() - 1));
		//using this method to bring the highest node on top again
		sinkDown(0);
		return max;
	}
	
	public void printHeap(){
		System.out.println(heap);
	}
	
}

public class HeapMain{
	public static void main(String args[]){
		Heap heap = new Heap();
		heap.insert(100);
		heap.insert(98);
		heap.insert(80);
		heap.insert(50);
		heap.insert(66);
		heap.insert(86);
		heap.insert(99);
		heap.remove();
		heap.printHeap();
	}
}