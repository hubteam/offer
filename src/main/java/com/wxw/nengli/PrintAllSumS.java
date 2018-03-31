package com.wxw.nengli;

import java.util.ArrayList;

/**
 * ��ӡ���к�ΪS���������������У����ٰ�����������
 * 
 * ����ָ�룬һ��ָ��ָ���һ����һ��ָ��ڶ��������������ĺ͵���Kʱ������������������ĺ�С��K���ڶ���ָ������ƶ������������ĺʹ���K��ʱ�򣬵�һ��ָ������ƶ�
 * @author ��ܰέ
 *
 */
public class PrintAllSumS {

	public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum){
		if(sum < 3){//��Ϊ�����������У��������жϱȽ�����
			return null;
		}
		int small = 1;
		int big = 2;
		int mid = (1 + sum) / 2;
		int curSum = small + big;
		ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		//big����small�����small��С��sum��һ�룬��ôsum��big�ĺͿ϶�����sum��
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
