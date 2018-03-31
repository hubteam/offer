package com.wxw.datastructure;

/**
 * 问题1：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * fibonacci的应用
 * 
 * 解题：考虑最简单的情况，如果只有1级台阶，显然是一种跳，如果是两级台阶，就有两种跳法
 *     当n > 2时候，第一次跳的时候有两种方法：跳一级，此时跳法数目等于后面的n-1级台阶，f(n-1)
 *                另外一种选择就是跳两级：此时跳法等于后面剩下的n-2级台阶的跳法数目，f(n-2)
 *                
 * 问题2：在青蛙跳台阶的问题中，把条件改为一个青蛙可以跳上一级，可以跳上2级，。。。也可以跳上N级，问一个青蛙跳上N级台阶，总共多少跳法。
 * 解决：数学归纳法：得到f(n) = 2 ^ (n-1)
 * 
 * 问题3：用2*1的小矩形横着或者竖着放，去覆盖更大的矩形区域，请问8个2*1的小矩形无重叠的覆盖一个2*8的大矩形，共多少种方法
 * 解决：仍然是FIBONACCI，竖着放有f(7),横着放是f(6)
 * 
 * @author 王馨苇
 *
 */
public class QingwaTiao {

	public static int func(int n){
		if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}else{
			return func(n - 1) + func(n - 2);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(func(10));
	}
}
