package com.wxw.array;

/**
 * 调整数组顺序使奇数位于偶数的前面：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author 王馨苇
 *
 */
public class ReorderOldEven {

	//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
	public static void reorderOldEven(int[] array){
		if(array == null || array.length == 0){
			return;
		}
		
		int i = 0;
		int j = array.length - 1;
		
		while(i < j){
			while(i < j && array[i] % 2 != 0){
				i++;
			}
			while(i < j && array[j] % 2 == 0){
				j--;
			}
			if(i < j ){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
	}
	
	//保证奇数和奇数，偶数和偶数之间的相对位置不变
	public static void reorderOldEven2(int[] array){
		int i = 0;
		int j = 0;
		while(i < array.length && j < array.length){
			while(i < array.length && array[i] % 2 == 0){
				i++;
			}
			while(j < array.length && array[j] % 2 != 0){
				j++;
			}
			if( i > j){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				
				int index = i;
				i = j;
				j = index;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		reorderOldEven(a);
		for (int i = 0; i < a.length; i++) {
			if(i == a.length - 1){
				System.out.print(a[i]);
			}else{
				System.out.print(a[i]+",");
			}
		}
		System.out.println();
		int b[] = {1,2,3,4,5};
		reorderOldEven2(b);
		for (int i = 0; i < b.length; i++) {
			if(i == b.length - 1){
				System.out.print(b[i]);
			}else{
				System.out.print(b[i]+",");
			}
		}
	}
}
