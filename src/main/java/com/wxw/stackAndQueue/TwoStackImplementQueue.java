package com.wxw.stackAndQueue;

import java.util.Stack;

/**
 * 两个栈实现队列：
 * 入队列的时候，直接入栈1
 * 出队列的时候，栈2空：栈1出栈进入栈2，再从栈2出；栈2不空的时候直接出
 * @author 王馨苇
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
			if(stack1.isEmpty()){//栈2空，栈1也空
				throw new Exception("异常出队");
			}else{
				while(!stack1.isEmpty()){//栈2空，栈1不空
					stack2.push(stack1.pop());
				}
			}
		}
		return stack2.pop();
	}
}
