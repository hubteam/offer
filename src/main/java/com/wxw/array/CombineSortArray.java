package com.wxw.array;

/**
 * 有两个排序数组A1 A2，A1后有足够的空间容纳A2，实现一个函数，把A2中所有数字插入到A1中，并且所有数字是排序的
 * 
 * @author 王馨苇
 *
 */
public class CombineSortArray {

	public static int[] combine(int[] a, int[] b){
		int[] c = new int[a.length + b.length];
		
		int i = 0, j = 0, k = 0;
		while(i < a.length && j < b.length){
			if(a[i] <= b[j]){
				c[k++] = a[i];
				i++;
			}else{
				c[k++] = b[j];
				j++;
			}
		}
		
		while(i < a.length){
			c[k++] = a[i];
			i++;
		}
		
		while(j < b.length){
			c[k++] = b[j];
			j++;
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		int[] a = {1,4,8,9};
		int[] b = {0,2,6,7};
		int[] c = combine(a, b);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]+" ");
		}
	}
}
