package com.wxw.lianbiao;

import java.util.Stack;

/**
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 * 
 * ע�⣺��1���Ƿ������޸�����ṹ������ı�ָ�뷽��
 *     ��2��ͨ����ӡ��һ��ֻ���Ĳ��������ǲ�ϣ����ӡʱ���޸�����
 *     
 * ������������˳���Ǵ�ͷ��β���������˳���Ǵ�β����ͷ��Ҳ����˵��һ���������һ����������һ��������һ����������Ƚ������--ջ
 *     ��ջ��ʵ�֣���Ȼ�ͻ��뵽�õݹ���ʵ��
 * @author ��ܰέ
 *
 */
public class PrintListFromTailToHead {


	/**
	 * ��ջ��ʵ��
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
	 * �ݹ�ʵ��
	 * @param node
	 */
	public static void printListFromTailToHeadByRecursive(ListNode node){
		if(node.next != null){
			printListFromTailToHeadByRecursive(node.next);
		}
		System.out.println(node.val);
	}
}
