package com.wxw.test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 
 * @author Õı‹∞Œ≠
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) {
			set.add(in.nextInt());
		}	
		if(set.size() == 1 && k == 0){
			System.out.println(1);
			return;
		}
		int[] b = new int[set.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = set.pollFirst();
		}
		int i = 0;
		int j = 1;
		int count = 0;
		while(i < b.length - 1){
			
			while(j < b.length){
				if(b[j] - b[i] == k){					
					j = i+1;
					count++;
					break;
				}else if(b[j] - b[i] < k){
					j++;
				}else{					
					j = i+1;
					break;
				}
			}
			i++;
		}
		System.out.println(count);
	}
}
