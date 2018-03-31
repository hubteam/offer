package com.wxw.nengli;

import java.util.ArrayList;

/**
 * ����һ����������������飬��һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ�ΪS���������һ�Լ���
 * @author ��ܰέ
 *
 */
public class FindNumberWithSum {

	/**
	 * һ��ָ��ָ������Ŀ�ʼ��һ��ָ��ָ�������ĩβ
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
