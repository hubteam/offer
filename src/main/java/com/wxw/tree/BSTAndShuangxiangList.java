package com.wxw.tree;

/**
 * ������������˫������
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * 
 * ����˼·���������������ģ��������������
 *        ԭ��ָ����������ָ�룬����Ϊָ�����������ǰһ���ڵ��ָ��
 *        ԭ��ָ����������ָ�룬����Ϊָ����������к�һ���ڵ��ָ��
 *        
 * @author ��ܰέ
 *
 */
public class BSTAndShuangxiangList {

	private static TreeNode last = null;
	/**
	 * 
	 * @param pRootOfTree
	 * @return
	 */
	public static TreeNode Convert(TreeNode pRootOfTree){
		if(pRootOfTree == null){
			return null;
		}else{
			last = null;//�ÿգ���Ȼ���¼��һ�εĽ��
			inorder(pRootOfTree);
			//��Ϊlastָ��β�ڵ㣬����Ҫ�ҵ�ͷ��㷵��
			TreeNode head = last;
			while(head != null && head.left != null){
				head = head.left;
			}
			return head;
		}
	}
	
	/**
	 * 
	 * @param node �ı�ǰ����
	 * @param last �����β�ڵ�
	 */
	public static void inorder(TreeNode node){
		if(node == null){
			return;
		}else{
			TreeNode current = node;
			if(current.left != null){
				inorder(current.left);
			}
			current.left = last;
			if(last != null){
				last.right = current;
			}
			last = current;
			if(current.right != null){
				inorder(current.right);;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(10);  
        TreeNode node1 = new TreeNode(6);  
        TreeNode node2 = new TreeNode(14);  
        TreeNode node3 = new TreeNode(4);  
        TreeNode node4 = new TreeNode(8);  
        TreeNode node5 = new TreeNode(12);  
        TreeNode node6 = new TreeNode(16); 
        root1.left = node1;  
        root1.right = node2;  
        node1.left = node3;  
        node1.right = node4;
        node2.left = node5;  
        node2.right = node6;
        @SuppressWarnings("unused")
		TreeNode root = Convert(root1);
	}
}
