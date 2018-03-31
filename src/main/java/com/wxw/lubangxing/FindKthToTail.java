package com.wxw.lubangxing;

import com.wxw.lianbiao.ListNode;

/**
 * ����һ����������������е�����k����㡣
 * 
 * 
 * @author ��ܰέ
 *
 */
public class FindKthToTail {

	/**
	 * ע�⣺head�᲻���ǿ�
	 *     �ڵ�����᲻������K
	 *     ����Ĳ��� K=0
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
				if(Ahead.next != null){//������֤����ĳ����Ǵ���K��
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
