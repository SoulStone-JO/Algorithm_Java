package select_sorting;

import java.util.Arrays;

public class SelectSort {
	public static void main(String[] args) {
		//测试
		int arr[] =new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] =(int)(Math.random()*20);
		}
		System.out.println(Arrays.toString(arr));
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int min = arr[i];
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j] < min) {
					minIndex = j;
					min = arr[j];
				}					
			}
			swap(arr, i, minIndex);
		}
	}
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	} 
}
