import java.util.*;

public class BubbleSort{
	public static void bubbleSort(int[] arr){
		for(int i = arr.length - 1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String args[]){
		int arr[] = { 50, 80, 40, 20, 100, 70, 30, 60};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}