package com.wxw.lianbiao;

import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 
 * 注意：（1）是否允许修改链表结构，比如改变指针方向
 *     （2）通常打印是一个只读的操作，我们不希望打印时候修改内容
 *     
 * 分析：遍历的顺序是从头到尾，而输出的顺序是从尾部到头，也就是说第一个遍历最后一个输出，最后一个遍历第一个输出，”先进后出“--栈
 *     用栈来实现，自然就会想到用递归来实现
 * @author 王馨苇
 *
 */
public class PrintListFromTailToHead {


	/**
	 * 用栈来实现
	 * @param listNode
	 * @return
	 */
	public static Stack<Integer> printListFromTailToHead(ListNode listNode) {
		
		Stack<Integer> stack = new Stack<Integer>();
		while(listNode != null){
			stack.push(listNode.val);
			listNode = listNode.next;
			
		}

        return stack;
    }
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);  
        ListNode node2 = new ListNode(2);  
        ListNode node3 = new ListNode(3);   
        node1.next=node2;  
        node2.next=node3;  
        Stack<Integer> stack = printListFromTailToHead(node1);
        while(!stack.isEmpty()) {  
            System.out.println(stack.pop());  
        } 
        System.out.println();
        printListFromTailToHeadByRecursive(node1);
	}
	
	/**
	 * 递归实现
	 * @param node
	 */
	public static void printListFromTailToHeadByRecursive(ListNode node){
		if(node.next != null){
			printListFromTailToHeadByRecursive(node.next);
		}
		System.out.println(node.val);
	}
}
