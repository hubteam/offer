package com.wxw.buchong;

/**
 * 最长上升子序列
 * 一个数的序列bi，当b1 < b2 < … < bS的时候，我们称这个序列是上升的。对于给定的一个序列(a1, a2, …, aN)，
 * 我们可以得到一些上升的子序列(ai1, ai2, …, aiK)，这里1 <= i1 < i2 < … < iK <= N。
 * 比如，对于序列(1, 7, 3, 5, 9, 4, 8)，有它的一些上升子序列，如(1, 7), (3, 4, 8)等等。这些子序列中最长的长度是4，比如子序列(1, 3, 5, 8).
 * @author 王馨苇
 *
 */
public class MaxUpperSub {

	/**
	 * 状态设计：F[i]代表以A[i]结尾的LIS的长度

状态转移：F[i]=max{F[j]+1}(1<=j< i,A[j]< A[i])

边界处理：F[i]=1(1<=i<=n)

时间复杂度：O(n^2)
	 */
	public static void func(int[] data){
		int[] f = new int[data.length];
		f[0] = 1;
		for (int i = 1; i < f.length; i++) {
			for (int j = 0; j < i; j++) {
				if(data[j] < data[i]){
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}
		for (int i = 0; i < f.length; i++) {
			System.out.println(f[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] data = {1,7,3,5,9,4,8};
		func(data);
	}
	
}
