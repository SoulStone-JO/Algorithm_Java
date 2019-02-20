package bubble_sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		//测试
		int arr[] =new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] =(int)(Math.random()*20);
		}
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void bubbleSort(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length-1; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length-1-i; j++) {
				 	if(arr[j] > arr[j+1]) {
					flag = false;
					swap(arr, j, j+1);
				}
				count++;	
			}
			if(flag==true)
				break;
		}
		System.out.println("循环次数："+count);
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
