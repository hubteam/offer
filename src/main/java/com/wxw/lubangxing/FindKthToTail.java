package com.wxw.lubangxing;

import com.wxw.lianbiao.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * 
 * @author 王馨苇
 *
 */
public class FindKthToTail {

	/**
	 * 注意：head会不会是空
	 *     节点个数会不会少于K
	 *     输入的参数 K=0
	 * @param head
	 * @param k
	 */
	public static ListNode findk(ListNode head, int k){
		if(head == null || k == 0){
			return null;
		}else{
			ListNode Ahead = head;
			ListNode Bhead = head;
			for (int i = 0; i < k - 1; i++) {
				if(Ahead.next != null){//这样保证链表的长度是大于K的
					Ahead = Ahead.next;
				}else{
					return null;
				}
			}
			
			while(Ahead.next != null){
				Ahead = Ahead.next;
				Bhead = Bhead.next;
			}
			return Bhead;
		}
	}
}
