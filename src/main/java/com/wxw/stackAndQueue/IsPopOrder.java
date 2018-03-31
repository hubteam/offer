package com.wxw.stackAndQueue;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 
 * 思路：如果下一个弹出的数字刚好是栈顶元素，直接出栈；如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的元素压入栈顶为止。
 * @author 王馨苇
 *
 */
public class IsPopOrder {

	public static boolean isPopOrder(int[] pushA, int[] popA){
		
		if(pushA == null || popA == null){
			return false;
		}
		int index = 0;
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < popA.length; i++) {
			
			if(!s.isEmpty() && s.peek() == popA[i]){
				s.pop();
			}else{
				while(index != pushA.length && pushA[index] != popA[i]){
					s.push(pushA[index++]);
				}
				index++;
			}
		}
		if(index == pushA.length){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int[] b = {4,3,5,1,2};
		int[] c = {4,5,3,2,1};
		System.out.println(isPopOrder(a,b));
		System.out.println(isPopOrder(a,c));
	}
}
