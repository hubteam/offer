package com.wxw.lianbiao;

/**
 * 在O(1)时间内删除链表：注意给定了要删除的节点。
 * 常规的解法是：从头遍历到要删除节点的前面一个节点，但这涉及到遍历和查找，时间复杂度是0(N)
 * 另外的解法是：要删除节点的后一个节点值赋给要删除的节点,再删除要删除的节点后面的那个节点；【考虑要删除的节点是不是尾节点】
 * 
 * @author 王馨苇
 *
 */
public class DeleteInO1 {

	public static void deleteNode(ListNode head, ListNode deleteNode){
		if(head == null || deleteNode == null){//都为空的时候
			return ;
		}
		//只有一个节点的时候
		if(deleteNode == head){
			head = null;
		}else{//有多个节点
			if(deleteNode.next == null){//要删除的节点是最后一个节点
				//此时从前往后遍历到要删除的节点的前一个位置，进行常规的删除的操作
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
