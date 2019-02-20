package merge_sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		//测试
		int arr[] =new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] =(int)(Math.random()*20);
		}
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}
	public static void mergeSort(int[] arr, int low, int high) {		
		if(low < high) {
			int mid = (low + high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr,low,mid,high);
		}		
	}
	public static void merge(int arr[], int low, int mid,int high) {
		int[] temp =new int[high-low+1];
		int indexTemp = 0;
		int i = low;
		int j = mid + 1;
		while(i<=mid && j<=high) {
			if(arr[i]<arr[j])
				temp[indexTemp++] = arr[i++];
			else 
				temp[indexTemp++] = arr[j++];
		}
		while(i<=mid)
			temp[indexTemp++] = arr[i++];
		while(j<=high)
			temp[indexTemp++] = arr[j++];
		for (int k = 0; k < temp.length; k++) {
			arr[low+k] = temp[k];
		}
	}
}
