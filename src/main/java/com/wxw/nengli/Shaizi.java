package com.wxw.nengli;

/**
 * 把N个骰子扔在地上，所有筛子朝上一面的点数之和为S，输入N，所有为S的可能的值出现的概率
 * @author 王馨苇
 *
 */
public class Shaizi {

	/**
	 * 递归的方法：把N个筛子，分为两堆，第一堆有1个筛子，第二堆有N-1个
	 * 性能不好
	 * @param n
	 */
	public void print1(int n){
		
	}
	
	static int max = 6;
	/**
	 * 用两个数组来存储骰子点数的每一个总数出现的次数
	 * @param n
	 */
	public void print2(int n){
		int[][] p = new int[2][max * n + 1];
		
		int flag = 0;
		for (int i = 1; i <= max; i++) {//1-6初始化为
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
	有k-1个骰子时，再增加一个骰子，这个骰子的点数只可能为1、2、3、4、5或6。那k个骰子得到点数和为n的情况有： 
	(k-1,n-1)：第k个骰子投了点数1 
	(k-1,n-2)：第k个骰子投了点数2 
	(k-1,n-3)：第k个骰子投了点数3 
	.... 
	(k-1,n-6)：第k个骰子投了点数6 
	在k-1个骰子的基础上，再增加一个骰子出现点数和为n的结果只有这6种情况！ 
	所以：f(k,n)=f(k-1,n-1)+f(k-1,n-2)+f(k-1,n-3)+f(k-1,n-4)+f(k-1,n-5)+f(k-1,n-6) 
	初始化：有1个骰子，f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1。 
	     */ 
	public static void printP(int n){
		if(n < 1){
			return;
		}
		
		double total = Math.pow(max, n);
		
		int maxSum = n * max;
		double[][] f = new double[n+1][maxSum+1];
		
		//初始化，有一个筛子，
		for(int i = 1; i <= max; i++){  
            f[1][i] = 1;  
        }  
		
		for (int k = 2; k <= n; k++) {//从第二个筛子开始
			for (int sum = n; sum < maxSum; sum++) {//和最小为N，最大为maxSum
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
