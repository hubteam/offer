package com.wxw.buchong;

import java.util.HashSet;

import com.wxw.lianbiao.ListNode;

/**
 * 判断单链表中是否有环，找到环的入口点（追赶的方法），环的长度（slow和fast第一次相遇，）
 * @author 王馨苇
 *
 */
public class ListContainsCircle {

	/**
	 * 用哈希表存储每个节点:每次加入一个节点的时候判断节点是否已经存在了，如果已经存在了就返回，没存在接着往下查找
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
	 * 追赶的方法：
	 * 1、定义两个指针：slow和fast，均从头开始遍历，每次分别前进1步，前进2步，如果又换，两者相遇，如果不存在环，fast遇到NULL退出。
	 * 2、一个从头遍历，一个从slow和fast相遇的点开始遍历，两个相交的位置就是环的入口
	 * @param list
	 * @return
	 */
	public ListNode nodeOfLoop(ListNode list){
		if(list == null){
			return null;
		}
		ListNode slow = list;
		ListNode fast = list;
		//注意这里的条件还有fast.next != null
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
