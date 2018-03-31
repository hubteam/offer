package com.wxw.nengli;

import java.util.ArrayList;

/**
 * 输入一个递增的排序的数组，和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和为S，输出任意一对即可
 * @author 王馨苇
 *
 */
public class FindNumberWithSum {

	/**
	 * 一个指针指向数组的开始，一个指针指向数组的末尾
	 * @param data
	 * @param k
	 */
	public void find(int[] data, int k){
		if(data == null || data.length <= 0){
			return ;
		}
		
		int left = 0;
		int right = data.length - 1;
		ArrayList<Integer> arrays = new ArrayList<Integer>();
		while(left <= right){
			ArrayList<Integer> array = new ArrayList<Integer>();
			if(data[left] + data[right] == k){
				array.add(data[left]);
				array.add(data[right]);
				arrays.addAll(array);
			}else if(data[left] + data[right] < k){
				left++;
			}else{
				right--;
			}
		}
		
	}
}
