package com.wxw.lianbiao;

/**
 * ��O(1)ʱ����ɾ������ע�������Ҫɾ���Ľڵ㡣
 * ����Ľⷨ�ǣ���ͷ������Ҫɾ���ڵ��ǰ��һ���ڵ㣬�����漰�������Ͳ��ң�ʱ�临�Ӷ���0(N)
 * ����Ľⷨ�ǣ�Ҫɾ���ڵ�ĺ�һ���ڵ�ֵ����Ҫɾ���Ľڵ�,��ɾ��Ҫɾ���Ľڵ������Ǹ��ڵ㣻������Ҫɾ���Ľڵ��ǲ���β�ڵ㡿
 * 
 * @author ��ܰέ
 *
 */
public class DeleteInO1 {

	public static void deleteNode(ListNode head, ListNode deleteNode){
		if(head == null || deleteNode == null){//��Ϊ�յ�ʱ��
			return ;
		}
		//ֻ��һ���ڵ��ʱ��
		if(deleteNode == head){
			head = null;
		}else{//�ж���ڵ�
			if(deleteNode.next == null){//Ҫɾ���Ľڵ������һ���ڵ�
				//��ʱ��ǰ���������Ҫɾ���Ľڵ��ǰһ��λ�ã����г����ɾ���Ĳ���
				while(head.next != deleteNode){
					head = head.next;
				}
				head.next = null;
			}else{
				deleteNode.val = deleteNode.next.val;
				deleteNode.next = deleteNode.next.next;
			}
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);  
        ListNode second = new ListNode(2);  
        ListNode third = new ListNode(3);  
        head.next = second;  
        second.next = third;  
        deleteNode(head, second);
        while(head!= null){
        	System.out.println(head.val);
        	head = head.next;
        }
	}
}
