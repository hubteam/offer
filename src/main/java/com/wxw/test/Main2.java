package com.wxw.test;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	private static int count = 0;
	
	public static void main(String[] args) {
		count = 0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			a.add(in.nextInt());
		}
		for (int i = 0; i < m; i++) {
			b.add(in.nextInt());
		}
		List<Integer> acopy = new ArrayList<Integer>(a);
		List<Integer> bcopy = new ArrayList<Integer>(b);
		fun(a, b, 0);
		fun(bcopy, acopy, 0);
		System.out.println(count);
	}
	
	public static void fun(List<Integer> a, List<Integer> b, int index){
		if(a.contains(b.get(index))){
			IntSummaryStatistics statspre = b.stream().mapToInt(x -> x).summaryStatistics();
			b.remove(index);
			IntSummaryStatistics statspost = b.stream().mapToInt(x -> x).summaryStatistics();
//			if(statspost.getAverage() > statspre.getAverage()){
//				count++;
//			}
		}else{
			IntSummaryStatistics apre = a.stream().mapToInt(x -> x).summaryStatistics();
			IntSummaryStatistics bpre = b.stream().mapToInt(x -> x).summaryStatistics();
			a.add(b.get(index));
			b.remove(index);
			IntSummaryStatistics apost = a.stream().mapToInt(x -> x).summaryStatistics();
			IntSummaryStatistics bpost = b.stream().mapToInt(x -> x).summaryStatistics();
			if((apre.getAverage() < apost.getAverage()) && 
					bpre.getAverage() < bpost.getAverage()){
				count++;
			}
		}
		if(b.size() > 0){
			fun(a, b, index);
		}
	}
}
