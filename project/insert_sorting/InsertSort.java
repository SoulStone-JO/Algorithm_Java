package insert_sorting;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		//测试
		int arr[] =new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] =(int)(Math.random()*20);
		}
		System.out.println(Arrays.toString(arr));
		insertSort(arr);
		System.out.println(Arrays.toString(arr));	
	}
	
	public static void insertSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int temp = arr[i];
			while (j >= 0 && temp < arr[j]) {
				arr[j + 1] = arr[j];		
				j--;
			}
			arr[j+1] = temp;
		}
	}
}
