import java.util.*;

public class InsertionSort{
	public static void insertionSort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			//store current value in temp
			int temp = arr[i];
			int j = i - 1;
			//check if previous value is greater than current, if yes then swap, or else do nothing
			while(j > -1 && temp < arr[j]){
				arr[j + 1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
	}
	
	public static void main(String args[]){
		int arr[] = { 50, 80, 40, 20, 100, 70, 30, 60};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}