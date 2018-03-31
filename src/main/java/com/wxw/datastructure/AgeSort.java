package com.wxw.datastructure;

/**
 * 对年龄的排序
 * 
 * 注意：年龄的范围比较集中，比如最大的年龄是99，可以采用计数排序
 * 
 * 这个问题说明了计数排序的一个应用场景：就是元素相对比较稳定，在一个范围内，不会太大， 如果太大的话，额外的内存就会占用的比较大
 * @author 王馨苇
 *
 */
public class AgeSort {

	public static void sort(int[] a){
		
		int[] b = new int[100];
		for (int i = 0; i < a.length; i++) {
			++b[a[i]];//每个年龄出现的次数，b数组下标代表年龄，里面的元素是次数
		}
		
		int index = 0;
		for (int i = 0; i < 100; i++) {//循环年龄
			for (int j = 0; j < b[i]; j++) {//循环当前年龄出现了多少次
				a[index++] = i;//同一个年龄会连续出现多次
			}
		}
	}
}
