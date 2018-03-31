package com.wxw.xiaolv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();//工作数量
		int m = in.nextInt();//小伙伴数量
		int[] d = new int[n];//工作强度
		int[] p = new int[n];//报酬
		for (int i = 0; i < n; i++) {
			d[i] = in.nextInt();
			p[i] = in.nextInt();
		}
		int[] a = new int[m];//人的能力
		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}
		
		int[] baochou = new int[m];//人得到的报酬
		
		for (int i = 0; i < a.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < d.length; j++) {
				if(d[j] < a[i]){
					list.add(j);//人能够接受的工作强度有哪些
				}
			}
			int[] copyp = new int[list.size()];
			for (int j = 0; j < list.size(); j++) {
				copyp[j] = p[list.get(j)];
			}
			Arrays.sort(copyp);//排序
			baochou[i] = copyp[copyp.length - 1];
		}
		
		for (int i = 0; i < baochou.length; i++) {
			System.out.println(baochou[i]);
		}
	}
}
