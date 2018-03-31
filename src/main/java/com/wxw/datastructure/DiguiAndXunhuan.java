package com.wxw.datastructure;

/**
 * 需要重复多次计算相同的问题的时候
 * 
 * 递归函数：简洁，但是调用有时间和空间的消耗
 *        但是递归的本质是把一个问题分解成两个或者多个问题，如果多个小问题存在相互重叠，那么就存在相互计算
 *        调用栈溢出
 * @author 王馨苇
 *
 */
public class DiguiAndXunhuan {

	public static int cal(int n){
		if(n == 0){
			return 0;
		}else{
			return n + cal(n-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(cal(5));
	}
	
}
