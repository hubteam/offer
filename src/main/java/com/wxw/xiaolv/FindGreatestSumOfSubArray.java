package com.wxw.xiaolv;

/**
 * ��������������ͣ�����һ���������飬������������Ҳ�и�������������һ������������������һ�������飬������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ���0(N)
 * 
 * @author ��ܰέ
 *
 */
public class FindGreatestSumOfSubArray {

	/**
	 * �ⷨ1��������������Ĺ���
	 * ����һ��λ�õ����������С���ʹ����λ�����¿�ʼ���(��ǰ�ĺ�Ϊ����)
	 * ����һ��λ�õ�����С�ڵ�ǰ�ĺͣ����������λ�ÿ��ܾ������ֵ������ӵ�����ʹ��ڵ�ǰ������ֵ���͸���
	 * @param array
	 * @return
	 */
	public static int find(int[] array){
		if(array == null || array.length <= 0){
			return 0;
		}
		
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if(sum <= 0){//����Ǹ���������һ����������С������ֻ�ܴ����λ�����¿�ʼ
				sum = array[i];
			}else{
				sum += array[i];
			}
			//maxsum��¼����
			if(sum > maxSum){
				maxSum = sum;
			}
		}
		
		return maxSum;
	}
	
	/**
	 * ��̬�滮��Ҫ������洢�м�����Ҫ��һ�����ƹ�ʽ
	 * ��ͨ�����ǻ��õݹ�ķ�ʽ������̬�滮�����⣬�������ն������ѭ��ȥд���룩
	 * @param array
	 * @return
	 */
	public static int find2(int[] array){
		//��һ�������¼
		int[] sum = new int[array.length];
		sum[0] = array[0];
		int maxsum = sum[0];
		for (int i = 1; i < sum.length; i++) {
			if(sum[i - 1] <= 0){
				sum[i] = array[i];
			}else{
				sum[i] = array[i] + sum[i - 1];
			}
			
			if(sum[i] > maxsum){
				maxsum = sum[i];
			}
		}
		return maxsum;
	}
	
	public static void main(String[] args) {
		int[] a = {1,-2,3,10,-4,7,2,-5};
		System.out.println(find2(a));
	}
}
