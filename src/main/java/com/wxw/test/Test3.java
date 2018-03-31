package com.wxw.test;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		char[] c = s.toCharArray();
		int n = 1;
		int part = 1;
		for (int i = 1; i < c.length; i++) {
			
			if(c[i] != c[i-1]){
				
				part = 1;
				n++;
			}else{
				part++;
			}
		}
		System.out.println(String.format("%.2f", ((double)c.length / (double)n)));
	}
}
