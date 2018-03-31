package com.wxw.stackAndQueue;

import java.util.Stack;

/**
 * 定义栈的数据结构
 * 
 * 思路：借助辅助栈，辅助栈存储当前位置下最小的元素
 * @author 王馨苇
 *
 */
public class MinStack {

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	
	public void push(int node){
		stack.push(node);
		if(min.isEmpty()){
			min.push(node);
		}else{
			int temp = min.peek();
			if(temp > node){
				min.push(node);
			}else{
				min.push(temp);
			}
		}
	}
	
	public void pop(){
		if(stack.isEmpty() || min.isEmpty()){
			
		}else{
			stack.pop();
			min.pop();
		}
	}
	
	public Integer top(){

		if(stack.isEmpty() || min.isEmpty()){
			return null;
		}else{
			min.pop();
			return stack.pop();
		}
	}
	
	public Integer min(){
		if(min.isEmpty()){
			return null;
		}else{
			return min.peek();
		}
	}
}
