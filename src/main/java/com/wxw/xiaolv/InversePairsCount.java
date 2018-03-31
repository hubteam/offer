package com.wxw.xiaolv;

/**
 * 数组中逆序对的个数：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对
 * 
 * 利用归并排序的思想
 * @author 王馨苇
 *
 */
public class InversePairsCount {

	public int pairs(int[] data){
		if(data == null || data.length <= 0){
			return 0;
		}else{
			int[] copy = new int[data.length];
			for (int i = 0; i < copy.length; i++) {
				copy[i] = data[i];
			}
			int count = countcore(data, copy, 0, data.length - 1);
			return count;
		}
	}
	
	public int countcore(int[] data, int[] copy, int start, int end){
		if(start == end){
			copy[start] = data[start];
			return 0;
		}
		int length = (end - start) / 2;
		int left = countcore(data, copy, start, start + length);
		int right = countcore(data, copy, start + length + 1, end);
		int i = start + length;//i初始化为前半段最后一个数字
		int j = end;//j初始化为后半段最后一个数字
		int indexCopy = end;
		int count = 0;
		while(i >= start && j >= start + length + 1){
			if(data[i] > data[j]){
				copy[indexCopy--] = data[i--];
				count += j - start - length;
			}else{
				copy[indexCopy--] = data[i--];
			}
		}
		for(; i >= start; --i)
			copy[indexCopy--] = data[i];
		for(; j >= start + length + 1; --j)
			copy[indexCopy--] = data[j];
		return left + right + count;
	}
}
