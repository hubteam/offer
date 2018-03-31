package com.wxw.xiaolv;

/**
 * 圆圈中最后剩下的数字：0到N-1这N个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第M个数字，求出圆圈里剩下的最后一个数字
 * 这就是约瑟夫环问题
 * @author 王馨苇
 *
 */
public class DigitLeaveInCircle {

	public static int getLeave(int n, int m){
		
		int s = 0;
		for (int i = 2; i <= n; i++) {
			s = (s + m) % i;
			System.out.println(s);
		}
		return s;
	}
	
	public static void main(String[] args) {
		getLeave(6, 3);
	}
}
