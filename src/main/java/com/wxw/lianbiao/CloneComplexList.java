package com.wxw.lianbiao;

/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * 
 * ����������һ������next,���ù�ϣ���¼ÿ���ڵ��randomλ�ã��ڶ�������randomλ��       ���ַ�ʽ�ǿռ任ʱ��
 * 
 * @author ��ܰέ
 *
 */
public class CloneComplexList {

	/**
	 * �ռ任ʱ�䣬���ù�ϣ��
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
	
	//��¡�ڵ㣬��ÿ���ڵ������һ��N'
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
	
	//��ֵrandom
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
	
	//����λ����next������������ԭʼ����ż��λ�������������Ǹ��Ƴ���������
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
