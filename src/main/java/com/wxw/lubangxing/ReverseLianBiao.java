package com.wxw.lubangxing;

import com.wxw.lianbiao.ListNode;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 
 * @author 王馨苇
 *
 */
public class ReverseLianBiao {

	//三个指针，分别指向当前遍历到的节点，它的前一个节点、它的后一个节点
	public static ListNode reverse(ListNode head){
		ListNode node = head;
		ListNode pre = null;
		ListNode reverseHead = null;
		while(node != null){
			//因为只要node的next指向了前面，就会找不到后面的了。所以要先保存一下
			ListNode next = node.next;//先保存一下，防止断裂
			if(next == null){//最后一个节点作为翻转的头结点
				reverseHead = node;
			}
			node.next = pre;
			
			pre = node;
			node = next;
		}
		return reverseHead;
	}
}
