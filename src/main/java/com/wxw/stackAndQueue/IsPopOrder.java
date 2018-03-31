package com.wxw.stackAndQueue;

import java.util.Stack;

/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 * 
 * ˼·�������һ�����������ָպ���ջ��Ԫ�أ�ֱ�ӳ�ջ�������һ�����������ֲ���ջ�������ǰ�ѹջ�����л�û����ջ������ѹ�븨��ջ��ֱ������һ����Ҫ������Ԫ��ѹ��ջ��Ϊֹ��
 * @author ��ܰέ
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
