package com.wxw.lubangxing;

import com.wxw.lianbiao.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author 王馨苇
 *
 */
public class CombineList {

	public static ListNode merge(ListNode list1, ListNode list2){
		
		//跳出递归的地方
		if(list1 == null){
			return list2;
		}else if(list2 == null){
			return list1;
		}
		
		ListNode combine ;
		if(list1.val <= list2.val){//递归完成
			combine = list1;
			combine.next = merge(list1.next, list2);
		}else{
			combine = list2;
			combine.next = merge(list1, list2.next);
		}
		return combine;
	}
}
