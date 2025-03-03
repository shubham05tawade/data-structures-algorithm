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
	
	public Integer leftChild(Integer index){
		return 2*index + 1;
	}
	
	public Integer rightChild(Integer index){
		return 2*index + 2;
	}
	
	public Integer parent(Integer index){
		return (index - 1) / 2;
	}
	
	public void swap(Integer currentIndex, Integer parentIndex){
		Integer temp = heap.get(currentIndex);
		heap.set(currentIndex, heap.get(parentIndex));
		heap.set(parentIndex, temp);
	}
	
	public void insert(int value){
		heap.add(value);
		int current = heap.size() - 1;
		while(current > 0 && heap.get(current) > heap.get(parent(current))){
			swap(current, parent(current));
			current = parent(current);
		}
	}
}

public class MaximumElementInStream{
	
	public static List<Integer> streamMax(int[] nums){
		List<Integer> result = new ArrayList<Integer>();
		Heap heap = new Heap();
		for(int num: nums){
			//insert node to heap
			heap.insert(num);
			//add top node from heap i.e. maximum in arraylist
			result.add(heap.getHeap().get(0));
		}
		return result;
	}
	
	public static void main(String args[]){
		int nums[] = {1, 5, 2, 9, 3, 6, 8};
		System.out.println(streamMax(nums));
	}
}