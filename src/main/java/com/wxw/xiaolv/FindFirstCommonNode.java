package com.wxw.xiaolv;

import com.wxw.lianbiao.ListNode;

/**
 * 两个链表的第一个公共节点【两个链表长度不一样】
 * 
 * @author 王馨苇
 *
 */
public class FindFirstCommonNode {

	/**
	 * 第一步先遍历两个链表得到长度的差；第二步让长的先走两个长度差的步伐；第三步同时向前走，第一个相等的位置就是要找到结果
	 * @param head1
	 * @param head2
	 * @return
	 */
	public ListNode findFirst(ListNode head1, ListNode head2){
		if(head1 == null || head2 == null){
			return null;
		}else{
			int l1 = getLength(head1);
			int l2 = getLength(head2);
			int len = l1 - l2;
			ListNode headlong = head1;
			ListNode headshort = head2;
			if(l2 > l1){
				headlong = head2;
				headshort = head1;
				len = l2 - l1;
			}
			for (int i = 0; i < len; i++) {
				headlong = headlong.next;
			}
			while(headlong != null && headshort != null && headlong != headshort){
				headlong = headlong.next;
				headshort = headshort.next;
			}
			ListNode common = headlong;
			return common;
		}
	}
	
	public int getLength(ListNode node){
		int count = 0;
		while(node.next != null){
			count++;
			node = node.next;
		}
		return count;
	}
}
