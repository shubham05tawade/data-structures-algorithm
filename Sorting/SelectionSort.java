import java.util.*;

public class SelectionSort{
	public static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			//Assign minimumIndex as ith postion
			int minIndex = i;
			for(int j = i + 1; j <arr.length; j++){
				//check if current value is less than the value at minIndex
				if(arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			//Swap the value at minIndex with the value at ith index if both index aren't same
			if(i != minIndex){
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
	
	public static void main(String args[]){
		int arr[] = { 50, 80, 40, 20, 100, 70, 30, 60};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}