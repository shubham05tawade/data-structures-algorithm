import java.util.*;

public class QuickSort{
	//Pivot is used to arrange all the element from an array to left and right wrt value at current index
	//Elements less than current index will move to left side of current index
	//Elements greater than current index will move to right side of current index
	public static int pivot(int[] arr, int pivotIndex, int endIndex){
		int swapIndex = pivotIndex;
		for(int i = pivotIndex + 1; i <= endIndex; i++){
			if(arr[i] < arr[pivotIndex]){
				swapIndex++;
				swap(arr, swapIndex, i);
			}
		}
		swap(arr, pivotIndex, swapIndex);
		return swapIndex;
	}
	
	//swap is used to swap the position of elements
	public static void swap(int[] arr, int leftIndex, int rightIndex){
		int temp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = temp;
	}
	
	//quickSortHelper will call pivot till we reach to a single element 
	public static void quickSortHelper(int[] arr, int left, int right){
		if(left < right){
			int pivotIndex = pivot(arr, left, right);
			quickSortHelper(arr, 0, pivotIndex - 1);
			quickSortHelper(arr, pivotIndex + 1, right);
		}
	}
	
	public static void quickSort(int[] arr){
		quickSortHelper(arr, 0, arr.length - 1);
	}
	
	public static void main(String args[]){
		int arr[] = { 50, 80, 40, 20, 100, 70, 30, 60};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}