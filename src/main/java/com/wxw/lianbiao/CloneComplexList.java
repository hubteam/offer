package com.wxw.lianbiao;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * 分两步：第一步设置next,并用哈希表记录每个节点的random位置；第二步设置random位置       这种方式是空间换时间
 * 
 * @author 王馨苇
 *
 */
public class CloneComplexList {

	/**
	 * 空间换时间，借用哈希表
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead){
		if(pHead == null){
			return null;
		}else{
			cloneNode(pHead);
			cloneRandom(pHead);
			return chaifen(pHead);
		}
	}
	
	//克隆节点，在每个节点后增加一个N'
	public void cloneNode(RandomListNode pHead){
		RandomListNode node = pHead;
		if(node == null){

		}else{
			while(node != null){
				RandomListNode clonenode = new RandomListNode(node.label);
				clonenode.next = node.next;
				node.next = clonenode;
				node = clonenode.next;
			}
		}
	}
	
	//赋值random
	public void cloneRandom(RandomListNode pHead){
		
		RandomListNode node = pHead;
		while(node != null){
			RandomListNode clone = node.next;
			if(node.random != null){
				clone.random = node.random.next;
			}
			node = clone.next;
		}
	}
	
	//奇数位置用next链接起来就是原始链表，偶数位置链接起来就是复制出来的链表
	public RandomListNode chaifen(RandomListNode pHead){
		RandomListNode cur = pHead;
		RandomListNode cloneHead = pHead.next;
		
		while(cur.next != null){
			RandomListNode next = cur.next;
			cur.next = next.next;
			cur = next;
		}
		return cloneHead;
	}
}
