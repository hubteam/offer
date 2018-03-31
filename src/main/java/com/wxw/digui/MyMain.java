package com.wxw.digui;

import java.util.Scanner;

public class MyMain {

	private static int color(int m, int n){

		if(n == 1){
			return m;
		}else if(n == 2){
			return m * (m - 1);
		}else{
			return (int) (m * Math.pow(m-1, n-1) - color(m, n-1));
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		System.out.println(color(n,m));		
	}
}
