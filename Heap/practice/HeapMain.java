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
		heap.printHeap();
	}
}