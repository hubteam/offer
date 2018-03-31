package com.wxw.tree;

/**
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * 
 * ��һ��������A�в��Һ͸��ڵ��ֵһ���Ľڵ�
 * @author ��ܰέ
 *
 */
public class SubTree {

	public static boolean hasSubTree(TreeNode root1, TreeNode root2){
		if(root1 == null || root2 == null){
			return false;
		}else{
			boolean result = false;
			if(root1.val == root2.val){//����ͬ��ʱ������ж��ӽڵ�
				result = same(root1, root2);
			}
			
			if(!result){
				result = hasSubTree(root1.left, root2);
			}
			
			if(!result){
				result = hasSubTree(root1.right, root2);
			}
			
			return result;
		}
	}
	
	/**
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean same(TreeNode root1, TreeNode root2){
		
		if(root2 == null){
			return true;
		}
		
		if(root1 == null){
			return false;
		}
		
		if(root1.val != root2.val){
			return false;
		}
		
		return same(root1.left, root2.left) && same(root1.right, root2.right);
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(8);  
		TreeNode node1 = new TreeNode(8);  
		TreeNode node2 = new TreeNode(7);  
		TreeNode node3 = new TreeNode(9);  
		TreeNode node4 = new TreeNode(2);  
		TreeNode node5 = new TreeNode(4);  
		TreeNode node6 = new TreeNode(7);  
        root1.left = node1;  
        root1.right = node2;  
        node1.left = node3;  
        node1.right = node4;  
        node4.left = node5;  
        node4.right = node6;  
        TreeNode root2 = new TreeNode(8);  
        TreeNode a = new TreeNode(9);  
        TreeNode b = new TreeNode(2);  
        root2.left = a;  
        root2.right = b;  
 
        System.out.println(hasSubTree(root1, root2));
	}
}
