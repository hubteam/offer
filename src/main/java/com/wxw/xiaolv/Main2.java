package com.wxw.xiaolv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();//��������
		int m = in.nextInt();//С�������
		int[] d = new int[n];//����ǿ��
		int[] p = new int[n];//����
		for (int i = 0; i < n; i++) {
			d[i] = in.nextInt();
			p[i] = in.nextInt();
		}
		int[] a = new int[m];//�˵�����
		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}
		
		int[] baochou = new int[m];//�˵õ��ı���
		
		for (int i = 0; i < a.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < d.length; j++) {
				if(d[j] < a[i]){
					list.add(j);//���ܹ����ܵĹ���ǿ������Щ
				}
			}
			int[] copyp = new int[list.size()];
			for (int j = 0; j < list.size(); j++) {
				copyp[j] = p[list.get(j)];
			}
			Arrays.sort(copyp);//����
			baochou[i] = copyp[copyp.length - 1];
		}
		
		for (int i = 0; i < baochou.length; i++) {
			System.out.println(baochou[i]);
		}
	}
}
