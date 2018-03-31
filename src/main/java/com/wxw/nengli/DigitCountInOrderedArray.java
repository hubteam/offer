package com.wxw.nengli;

/**
 * ���������������г��ֵĴ���
 * 
 * @author ��ܰέ
 *
 */
public class DigitCountInOrderedArray {

	/**
	 * ��õ�һ��K
	 * @param data
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	public int getFirstK(int[] data, int k, int start, int end){
		if(start > end){
			return -1;
		}

		int midindex = (start + end) / 2;
		int middata = data[midindex];
		
		if(middata == k){
			if(((midindex > 0) && data[midindex - 1] != k) || midindex == 0){
				return midindex;
			}else{
				end = midindex - 1;
			}
		}else if(middata > k){
			end = midindex - 1;
		}else{
			start = midindex + 1;
		}
		return getFirstK(data, k, start, end);
	}
	
	/**
	 * ������һ��K
	 * @param data
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	public int getLastK(int[] data, int k, int start, int end){
		if(start > end){
			return -1;
		}
		int midindex = (start + end) / 2;
		int middata = data[midindex];
		
		if(middata == k){
			if(((midindex > 0) && data[midindex + 1] != k) || midindex == 0){
				return midindex;
			}else{
				start = midindex + 1;
			}
		}else if(middata > k){
			end = midindex - 1;
		}else{
			start = midindex + 1;
		}
		return getLastK(data, k, start, end);
	}
	
	public int getNumberOfK(int[] data, int k){
		int count = 0;
		if(data != null && data.length > 0){
			int first = getFirstK(data, k, 0, data.length - 1);
			int last = getFirstK(data, k, 0, data.length - 1);
			
			if(first > -1 && last > -1){
				count = last - first +1;
			}
		}
		return count;
	}
}
