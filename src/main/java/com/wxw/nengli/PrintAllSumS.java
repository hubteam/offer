package com.wxw.nengli;

import java.util.ArrayList;

/**
 * 打印所有和为S的连续正数的序列（至少包含两个数）
 * 
 * 两个指针，一个指针指向第一个，一个指向第二个，当两个数的和等于K时候加入结果，当两个数的和小于K，第二个指针向后移动，当两个数的和大于K的时候，第一个指针向后移动
 * @author 王馨苇
 *
 */
public class PrintAllSumS {

	public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum){
		if(sum < 3){//因为是连续的序列，这样的判断比较正常
			return null;
		}
		int small = 1;
		int big = 2;
		int mid = (1 + sum) / 2;
		int curSum = small + big;
		ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		//big大于small，如果small不小于sum的一半，那么sum和big的和肯定大于sum了
		while(small <= mid){
			if(curSum == sum){
				for (int i = small; i <= big; i++) {
					array.add(i);
				}
				ArrayList<Integer> arrayCopy = new ArrayList<Integer>(array);
				arrays.add(arrayCopy);
                array.clear();
				big++;
				curSum += big;
				curSum -= small;
				small++;
				
			}else if(curSum < sum){
				big++;
				curSum += big;
			}else{
				curSum -= small;
				small++;
			}
		}
		return arrays;
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arrays = findContinuousSequence(15);
		for (ArrayList<Integer> arrayList : arrays) {
			for (Integer integer : arrayList) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
