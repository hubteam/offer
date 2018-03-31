package com.wxw.nengli;

/**
 * ������ֻ����һ�ε����֣�һ�����������г�����������֮�⣬���������ֶ����������Σ�Ҫ��ʱ�临�Ӷ�O(1)���ռ临�Ӷ�O(1)
 * 
 * �κ�һ������������Լ�����0����ͷ��β���������ÿһ��Ԫ�أ����ս���պ����ĸ�ֻ����һ�ε�����----���������ֻ��һ������һ��
 * 
 * ������е����⣺
 * �������Ϊ�������֣���������ÿ��Ԫ�ص�Nλ�ǲ���1��Ϊ�������飬��һ�������飬��Nλ��1���ڶ��������飬��Nλ��0
 * 
 * ����Ĳ����ǣ�
 * �ȶ�������򣬿��õ��Ľ���ڼ�λ��1
 * ��������ĵõ��ĵڼ�λ�������Ϊ����������
 * �ֱ��������������򣬿��Եõ�Ҫ��Ľ��
 * 
 * @author ��ܰέ
 *
 */
public class FindNumberAppearOnce {

	public void appearOnce(int[] data, int num1, int num2){
		if(data == null || data.length <= 0){
			return;
		}
		
		int result = 0;
		
		for (int i = 0; i < data.length; i++) {
			result ^= data[i];
		}
		int indexOf1 = findFirst1(result);
		num1 = num2 = 0;
		for (int i = 0; i < data.length; i++) {
			if(isBit1(data[i], indexOf1) == 1){
				num1 ^= data[i];
			}else{
				num2 ^= data[i];
			}
		}
	}
	
	public int findFirst1(int num){
		int indexBit = 0;
		while((num & 1) == 0){
			num = num >> 1;
		    indexBit++;
		}
		return indexBit;
		
	}
	
	public int isBit1(int num, int indexOf1){
		num = num >> 1;
		return (num & 1);
	}
}
