package com.wxw.xiaolv;

/**
 * 连续子数组的最大和：输入一个整型数组，数组中有正数也有负数，数组中有一个或连续多个正数组成一个子数组，求所有子数组的和的最大值，要求时间复杂度是0(N)
 * 
 * @author 王馨苇
 *
 */
public class FindGreatestSumOfSubArray {

	/**
	 * 解法1：举例分析数组的规律
	 * 加上一个位置的数后比自身还小，就从这个位置重新开始求和(当前的和为负数)
	 * 加上一个位置的数后小于当前的和，保留，这个位置可能就是最大值，如果加到后面和大于当前保留的值，就更新
	 * @param array
	 * @return
	 */
	public static int find(int[] array){
		if(array == null || array.length <= 0){
			return 0;
		}
		
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if(sum <= 0){//如果是负数，加上一个数会让数小于自身，只能从这个位置重新开始
				sum = array[i];
			}else{
				sum += array[i];
			}
			//maxsum记录最大的
			if(sum > maxSum){
				maxSum = sum;
			}
		}
		
		return maxSum;
	}
	
	/**
	 * 动态规划：要用数组存储中间结果，要有一个递推公式
	 * （通常我们会用递归的方式分析动态规划的问题，但是最终都会基于循环去写代码）
	 * @param array
	 * @return
	 */
	public static int find2(int[] array){
		//用一个数组记录
		int[] sum = new int[array.length];
		sum[0] = array[0];
		int maxsum = sum[0];
		for (int i = 1; i < sum.length; i++) {
			if(sum[i - 1] <= 0){
				sum[i] = array[i];
			}else{
				sum[i] = array[i] + sum[i - 1];
			}
			
			if(sum[i] > maxsum){
				maxsum = sum[i];
			}
		}
		return maxsum;
	}
	
	public static void main(String[] args) {
		int[] a = {1,-2,3,10,-4,7,2,-5};
		System.out.println(find2(a));
	}
}
