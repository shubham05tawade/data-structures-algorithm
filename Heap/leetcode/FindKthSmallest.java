import java.util.*;

class Heap{
	
	private ArrayList<Integer> heap;
	
	public Heap(){
		this.heap = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getHeap(){
		return this.heap;
	}
	
	public void printHeap(){
		System.out.println(heap);
	}
	
	public Integer getLeftChild(int index){
		return index * 2 + 1;
	}
	
	public Integer getRightChild(int index){
		return index * 2 + 2;
	}
	
	public Integer getParent(int index){
		return (index  - 1) / 2;
	}
	
	public void swap(Integer child, Integer parent){
		Integer temp = heap.get(child);
		heap.set(child, heap.get(parent));
		heap.set(parent, temp);
	}
	
	public void insert(int value){
		heap.add(value);
		int current = heap.size() - 1;
		while(current > 0 && heap.get(current) > heap.get(getParent(current))){
			swap(current, getParent(current));
			current = getParent(current);
		}
	}
	
	public void sinkDown(int index){
		int max = index;
		while(true){
			int leftChild = getLeftChild(index);
			int rightChild = getRightChild(index);
			if(leftChild < heap.size() && heap.get(leftChild) > heap.get(max)){
				max = leftChild;
			}
			if(rightChild < heap.size() && heap.get(rightChild) > heap.get(max)){
				max = rightChild;
			}
			if(max != index){
				swap(max, index);
				index = max;
			}
			else return;
		}
	}
	
	public Integer remove(){
		if(heap.size() == 0) return null;
		if(heap.size() == 1) return heap.remove(0);
		Integer max = heap.get(0);
		heap.set(0, heap.remove(heap.size() - 1));
		sinkDown(0);
		return max;
	}
}


public class FindKthSmallest{
	
	public static int findKthSmallest(int nums[], int k){
		Heap heap = new Heap();
		for(int num: nums){
			heap.insert(num);
		}
		Integer kthSmallest = 0;
		//Kth Smallest will reach on top if we have arraylist of size k so remove elements till we reach that size
		while(heap.getHeap().size() >= k){
			kthSmallest = heap.remove();
		}
		return kthSmallest;
	}
	
	public static void main(String args[]){
		int[] nums = {7, 10, 4, 3, 20, 15};
		int k = 3;
		findKthSmallest(nums, k);
	}
	
	
	
}