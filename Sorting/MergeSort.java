import java.util.*;

public class MergeSort{
	public static int[] mergeSort(int[] arr){
		if(arr.length == 1) return arr;
		
		int mid = arr.length / 2;
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		
		return merge(left, right);
	}
	
	public static int[] merge(int left[], int right[]){
		int[] combined = new int[left.length + right.length];
		int i=0, j=0, k=0;
		while(i < left.length && j < right.length){
			if(left[i] < right[j]){
				combined[k] = left[i];
				i++;
			}
			else{
				combined[k] = right[j];
				j++;
			}
			k++;
		}
		while(i < left.length){
			combined[k] = left[i];
			i++;
			k++;
		}
		while(j < right.length){
			combined[k] = right[j];
			j++;
			k++;
		}
		return combined;
	}
	
	public static void main(String args[]){
		int arr[] = { 50, 80, 40, 20, 100, 70, 30, 60};
		System.out.println(Arrays.toString(mergeSort(arr)));
	}
}