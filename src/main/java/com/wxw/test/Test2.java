package com.wxw.test;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int pre = n;
		int res = 0;
		while(n != 0){
			res = (res * 10) + (n % 10);
			n /= 10;
		}
		res += pre;
		System.out.println(res);
	}
}
