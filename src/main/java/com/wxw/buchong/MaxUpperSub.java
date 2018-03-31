package com.wxw.buchong;

/**
 * �����������
 * һ����������bi����b1 < b2 < �� < bS��ʱ�����ǳ���������������ġ����ڸ�����һ������(a1, a2, ��, aN)��
 * ���ǿ��Եõ�һЩ������������(ai1, ai2, ��, aiK)������1 <= i1 < i2 < �� < iK <= N��
 * ���磬��������(1, 7, 3, 5, 9, 4, 8)��������һЩ���������У���(1, 7), (3, 4, 8)�ȵȡ���Щ����������ĳ�����4������������(1, 3, 5, 8).
 * @author ��ܰέ
 *
 */
public class MaxUpperSub {

	/**
	 * ״̬��ƣ�F[i]������A[i]��β��LIS�ĳ���

״̬ת�ƣ�F[i]=max{F[j]+1}(1<=j< i,A[j]< A[i])

�߽紦��F[i]=1(1<=i<=n)

ʱ�临�Ӷȣ�O(n^2)
	 */
	public static void func(int[] data){
		int[] f = new int[data.length];
		f[0] = 1;
		for (int i = 1; i < f.length; i++) {
			for (int j = 0; j < i; j++) {
				if(data[j] < data[i]){
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}
		for (int i = 0; i < f.length; i++) {
			System.out.println(f[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] data = {1,7,3,5,9,4,8};
		func(data);
	}
	
}
