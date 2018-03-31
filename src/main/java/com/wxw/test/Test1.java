package com.wxw.test;

import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(selectPath(10));
		System.out.println(selectPath1(10));
	}
	
	/**
	 * 方法1：递归
	 * @param n
	 * @return
	 */
	public static String selectPath(int n){
		if(n < 1){
			return "";
		}else if(n % 2 == 0){
			return selectPath((n - 2) / 2) + '2';
		}else{
			return selectPath((n - 2) / 2) + '1';
		}
	}
	
	/**
	 * 方法2
	 * @param n
	 * @return
	 */
	public static String selectPath1(int n){
		String s = "";
		while(n != 0){
			if(n % 2 == 0){
				n = (n - 2) / 2;
				s = '2' + s;
			}else{
				n = (n - 1) / 2;
				s = '1' + s;
			}
		}
		return s;
	}
}
