package com.wxw.xiaolv;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();//����������Ŀ
		int[] result = new int[t];//���ս���������ʾ
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			Scanner in1 = new Scanner(System.in);
			String s = in1.nextLine();
			char[] c = s.toCharArray();
			int count = 0;
			int res = 0;//���յĽ��
			for (int j = 0; j < c.length; j++) {
				if(c[j] == '.'){
					count++;
				}else{
					if(count % 3 == 0){
						res += count / 3;
					}else{
						res += count / 3 + 1;
					}
					count = 0;
				}
			}
			result[i] = res;
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		return;
	}
}
