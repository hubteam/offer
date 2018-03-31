package com.wxw.xiaolv;

import com.wxw.lianbiao.ListNode;

/**
 * ��������ĵ�һ�������ڵ㡾���������Ȳ�һ����
 * 
 * @author ��ܰέ
 *
 */
public class FindFirstCommonNode {

	/**
	 * ��һ���ȱ�����������õ����ȵĲ�ڶ����ó��������������Ȳ�Ĳ�����������ͬʱ��ǰ�ߣ���һ����ȵ�λ�þ���Ҫ�ҵ����
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
