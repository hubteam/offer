package com.wxw.lubangxing;

import com.wxw.lianbiao.ListNode;

/**
 * ����һ��������ת�����������������Ԫ�ء�
 * 
 * @author ��ܰέ
 *
 */
public class ReverseLianBiao {

	//����ָ�룬�ֱ�ָ��ǰ�������Ľڵ㣬����ǰһ���ڵ㡢���ĺ�һ���ڵ�
	public static ListNode reverse(ListNode head){
		ListNode node = head;
		ListNode pre = null;
		ListNode reverseHead = null;
		while(node != null){
			//��ΪֻҪnode��nextָ����ǰ�棬�ͻ��Ҳ���������ˡ�����Ҫ�ȱ���һ��
			ListNode next = node.next;//�ȱ���һ�£���ֹ����
			if(next == null){//���һ���ڵ���Ϊ��ת��ͷ���
				reverseHead = node;
			}
			node.next = pre;
			
			pre = node;
			node = next;
		}
		return reverseHead;
	}
}
