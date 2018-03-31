package com.wxw.stackAndQueue;

import java.util.Stack;

/**
 * ����ջʵ�ֶ��У�
 * ����е�ʱ��ֱ����ջ1
 * �����е�ʱ��ջ2�գ�ջ1��ջ����ջ2���ٴ�ջ2����ջ2���յ�ʱ��ֱ�ӳ�
 * @author ��ܰέ
 *
 */
public class TwoStackImplementQueue {

	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	
	public void push(int node){
		stack1.push(node);
	}
	
	public int pop() throws Exception{
		
		if(stack2.isEmpty()){
			if(stack1.isEmpty()){//ջ2�գ�ջ1Ҳ��
				throw new Exception("�쳣����");
			}else{
				while(!stack1.isEmpty()){//ջ2�գ�ջ1����
					stack2.push(stack1.pop());
				}
			}
		}
		return stack2.pop();
	}
}
