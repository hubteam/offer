package com.wxw.datastructure;

public class Fibonacci {

	/**
	 * 递归会有严重的问题：因为小的问题中有很多重复，重复的节点会随着N的增大，急速增大，递归方式的时间复杂度，指数级增加。
	 * @param n
	 * @return
	 */
	public static int calRec(int n){
		if(n <= 0){
			return 0;
		}
		
		if(n == 1){
			return 1;
		}
		
		return calRec(n - 1) + calRec(n - 2);
	}
	
	/**
	 * 采用循环，更为实用，时间复杂度是0(N)
	 * @param n
	 * @return
	 */
	public static int calLoop(int n){
		//处理前两项
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}else{
			int a = 0;
			int b = 1;
			int c = 0;
			for (int i = 2; i <= n; i++) {
				c = a + b;
				a = b;
				b = c;
			}
			return c;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(calLoop(7));
	}
}
