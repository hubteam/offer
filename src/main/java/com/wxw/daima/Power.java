package com.wxw.daima;

/**
 * 一个数的整数次方
 * 
 * @author 王馨苇
 *
 */
public class Power {

	/**
	 * 最简单的方法
	 * 缺点是没有考虑指数小于1的情形，底数为0的情形
	 * @param base
	 * @param exp
	 * @return
	 */
	public static double power(double base, int exp){
		double result = 1.0;
		for (int i = 0; i < exp; i++) {
			result *= base;
		}
		return result;
	}
	
	//考虑参数的范围，因为这里是整数，不用考虑0-1之间的指数
	public static double power2(double base, int exp){
		//base=0，且exp<0的时候
		//注意：double类型等于0的判断
		if(equal(base, 0.0) && exp < 0){
			throw new IllegalArgumentException("非法参数");
		}
		//指数小于0的情况
		double result = power(base, Math.abs(exp));
		if(exp < 0){
			result = 1.0 / result;
		}
		return result;
	}
	
	private static boolean equal(double a, double b){
		if((a - b > -0.0000001) && (a - b < 0.0000001)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 高效的方法：An = A(n/2)A(n/2)偶数
	 *         An = A((n-1)/2)A((n-1)/2)A 奇数
	 * @param base
	 * @param exp
	 * @return
	 */
	public static double power3(double base, int exp){
		if(equal(base, 0.0) && exp < 0){
			throw new IllegalArgumentException("非法参数");
		}
		if(exp == 1){
			return base;
		}
		if(exp == 0){
			return 1;
		}
		//用右移代替除以2
		double res = power2(base, exp >> 1);
		res *= res;
		if(exp % 2 == 1){
			res *= base;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(power3(1000000000,1000000000));
	}
}
