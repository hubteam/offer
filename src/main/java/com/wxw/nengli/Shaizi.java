package com.wxw.nengli;

/**
 * ��N���������ڵ��ϣ�����ɸ�ӳ���һ��ĵ���֮��ΪS������N������ΪS�Ŀ��ܵ�ֵ���ֵĸ���
 * @author ��ܰέ
 *
 */
public class Shaizi {

	/**
	 * �ݹ�ķ�������N��ɸ�ӣ���Ϊ���ѣ���һ����1��ɸ�ӣ��ڶ�����N-1��
	 * ���ܲ���
	 * @param n
	 */
	public void print1(int n){
		
	}
	
	static int max = 6;
	/**
	 * �������������洢���ӵ�����ÿһ���������ֵĴ���
	 * @param n
	 */
	public void print2(int n){
		int[][] p = new int[2][max * n + 1];
		
		int flag = 0;
		for (int i = 1; i <= max; i++) {//1-6��ʼ��Ϊ
			p[flag][i] = 1;
		}
		for (int k = 2; k <= n; k++) {
			for (int i = 0; i < k; i++) {
				p[1 - flag][i] = 0;
			}
			for (int i = k; i <= max * k; i++) {
				p[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= max; j++) {
					p[1 - flag][i] += p[flag][i - j];
				}
				flag = 1 - flag;
			}
		}
	}
	
	/* 
	��k-1������ʱ��������һ�����ӣ�������ӵĵ���ֻ����Ϊ1��2��3��4��5��6����k�����ӵõ�������Ϊn������У� 
	(k-1,n-1)����k������Ͷ�˵���1 
	(k-1,n-2)����k������Ͷ�˵���2 
	(k-1,n-3)����k������Ͷ�˵���3 
	.... 
	(k-1,n-6)����k������Ͷ�˵���6 
	��k-1�����ӵĻ����ϣ�������һ�����ӳ��ֵ�����Ϊn�Ľ��ֻ����6������� 
	���ԣ�f(k,n)=f(k-1,n-1)+f(k-1,n-2)+f(k-1,n-3)+f(k-1,n-4)+f(k-1,n-5)+f(k-1,n-6) 
	��ʼ������1�����ӣ�f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1�� 
	     */ 
	public static void printP(int n){
		if(n < 1){
			return;
		}
		
		double total = Math.pow(max, n);
		
		int maxSum = n * max;
		double[][] f = new double[n+1][maxSum+1];
		
		//��ʼ������һ��ɸ�ӣ�
		for(int i = 1; i <= max; i++){  
            f[1][i] = 1;  
        }  
		
		for (int k = 2; k <= n; k++) {//�ӵڶ���ɸ�ӿ�ʼ
			for (int sum = n; sum < maxSum; sum++) {//����СΪN�����ΪmaxSum
				for (int i = 1; i <= max && sum - i >= 1; i++) {
					f[k][sum] += f[k-1][sum-i];
				}
			}
		}
		
		for (int sum = n; sum <= maxSum; sum++) {
			System.out.println(sum + "," + f[n][sum] + "/" + total);
		}
	}
}
