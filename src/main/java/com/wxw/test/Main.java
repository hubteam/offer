package com.wxw.test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int h = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}
		int[] high = new int[k+1];
		high[0] = 0;
		for (int i = 1; i <= k; i++) {
			high[i] = high[i-1] + (a[(i-1)%3] - high[i-1]) * 2;
		}
		System.out.println(high[high.length-1]);
	}
}
