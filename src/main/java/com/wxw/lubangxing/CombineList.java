package com.wxw.lubangxing;

import com.wxw.lianbiao.ListNode;

/**
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * 
 * @author ��ܰέ
 *
 */
public class CombineList {

	public static ListNode merge(ListNode list1, ListNode list2){
		
		//�����ݹ�ĵط�
		if(list1 == null){
			return list2;
		}else if(list2 == null){
			return list1;
		}
		
		ListNode combine ;
		if(list1.val <= list2.val){//�ݹ����
			combine = list1;
			combine.next = merge(list1.next, list2);
		}else{
			combine = list2;
			combine.next = merge(list1, list2.next);
		}
		return combine;
	}
}
