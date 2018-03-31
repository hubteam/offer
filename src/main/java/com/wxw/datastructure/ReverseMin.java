package com.wxw.datastructure;

/**
 * ��ת�������Сֵ����һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء� 
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * 
 * ���⣺��ת֮��������Ի���Ϊ��������������У�����ǰ��������е�Ԫ�ض����ں���������е�Ԫ�أ���С��Ԫ�ظպ�������������ķָ��
 * @author ��ܰέ
 *
 */
public class ReverseMin {

	/**
	 * ��һ�ַ�ʽ��˳����ң�������Сֵ������������ķָ�ط�
	 * 
	 * O(N)
	 * 
	 * @param array
	 * @return
	 */
	public static int minNumberInRotateArray(int [] array) {
		    
		if(array.length <= 0){
			return 0;
		}else{
			int count = -1;
			for (int i = 0; i < array.length - 2; i++) {
				if(array[i] > array[i + 1]){
					count = i + 1;
				}
			}
			if(count == -1){
				return 0;
			}else{
				return array[count];
			}
		}
	 }
	
	/**
	 * �ڶ���ʵ�֣����ֲ��ң���Ϊ������ĳЩ�̶����������
	 * 
	 * ��������������������ǰ��0��Ԫ�ذᵽ����棬�������鱾����Ȼ��һ���������ת��������Ҫ֧���������Σ���ʱ�����еĵ�һ��Ԫ�ؾ�����С�����֣�����ֱ�ӷ���
	 *     left right mid����λ��Ԫ����ͬ��ʱ��{1,0,1,1,1} {1,1,1,0,1}����ʱ���޷�ȷ���м�Ԫ�����ڵ������ǵݼ��������У���˳����ҡ�
	 * ע�⣺Ҫ��������Ĳ�������
	 * O(logN)
	 * 
	 * @param array
	 * @return
	 */
	public static int minNumberInRotateArray2(int [] array) {
	    
		if(array.length <= 0){
			return 0;
		}else{
			
			int left = 0;
			int right = array.length - 1;//������length-1
			int mid = left;//��ʼ��Ϊleft����Ϊ�������û�з�ת���������鱾����һ�����־�����С������
			while(array[left] >= array[right]){				
				
				if((right - left) == 1){
					mid = right;//��һ���ĸ�ֵ���ҵ��󣬰�Ӧ�õõ���������ֵ��mid
					break;
				}
				
				mid = (left + right) / 2;
				//�������Ԫ����ȵ�ʱ��:˳�����
				if(array[mid] == array[left] && array[left] == array[right]){
					return minNumberInRotateArray(array);
				}
				if(array[mid] >= array[left]){
					left = mid;
				}else if(array[mid] <= array[right]){
					right = mid;
				}
			}
			//��ʱmid����������������ҵ��ģ���һ��ʼ����û��ת�ĵ�һ��
			return array[mid];
		}	 
	}
	
	public static void main(String[] args) {
		int[] a = {6,1,2,3,4,5};
		int[] b = {1,2,3,4,5,6,7,8};
		int[] c = {1,0,1,1,1};
		int[] d = {1,1,1,0,1};
		System.out.println(minNumberInRotateArray2(a));
		System.out.println(minNumberInRotateArray2(b));
		System.out.println(minNumberInRotateArray2(c));
		System.out.println(minNumberInRotateArray2(d));
	}
}
