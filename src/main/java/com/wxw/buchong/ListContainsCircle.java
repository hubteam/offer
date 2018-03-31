package com.wxw.buchong;

import java.util.HashSet;

import com.wxw.lianbiao.ListNode;

/**
 * �жϵ��������Ƿ��л����ҵ�������ڵ㣨׷�ϵķ����������ĳ��ȣ�slow��fast��һ����������
 * @author ��ܰέ
 *
 */
public class ListContainsCircle {

	/**
	 * �ù�ϣ��洢ÿ���ڵ�:ÿ�μ���һ���ڵ��ʱ���жϽڵ��Ƿ��Ѿ������ˣ�����Ѿ������˾ͷ��أ�û���ڽ������²���
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode jiaoDian(ListNode list){
		HashSet<ListNode> hs = new HashSet<ListNode>();
		while(list != null){
			if(!hs.contains(list)){
				hs.add(list);
			}else{
				return list;
			}
			list = list.next;
		}
		return null;
	}
	
	/**
	 * ׷�ϵķ�����
	 * 1����������ָ�룺slow��fast������ͷ��ʼ������ÿ�ηֱ�ǰ��1����ǰ��2��������ֻ���������������������ڻ���fast����NULL�˳���
	 * 2��һ����ͷ������һ����slow��fast�����ĵ㿪ʼ�����������ཻ��λ�þ��ǻ������
	 * @param list
	 * @return
	 */
	public ListNode nodeOfLoop(ListNode list){
		if(list == null){
			return null;
		}
		ListNode slow = list;
		ListNode fast = list;
		//ע���������������fast.next != null
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				ListNode p = list;
				ListNode q = slow;
				while(q != p){
					p = p.next;
					q = q.next;
				}
				if(p == q){
					return p;
				}
			}
		}
		return null;
	}
}
