package com.wxw.xiaolv;

/**
 * ����������Եĸ������������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ�������
 * 
 * ���ù鲢�����˼��
 * @author ��ܰέ
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
		int i = start + length;//i��ʼ��Ϊǰ������һ������
		int j = end;//j��ʼ��Ϊ�������һ������
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
