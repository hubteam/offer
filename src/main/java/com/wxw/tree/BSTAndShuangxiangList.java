package com.wxw.tree;

/**
 * 二叉搜索树和双向链表：
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * 解题思路：中序遍历是有序的，利用中序遍历，
 *        原来指向左子树的指针，调整为指向中序遍历中前一个节点的指针
 *        原来指向右子树的指针，调整为指向中序遍历中后一个节点的指针
 *        
 * @author 王馨苇
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
			last = null;//置空，不然会记录上一次的结果
			inorder(pRootOfTree);
			//因为last指向尾节点，所以要找到头结点返回
			TreeNode head = last;
			while(head != null && head.left != null){
				head = head.left;
			}
			return head;
		}
	}
	
	/**
	 * 
	 * @param node 改变前的树
	 * @param last 链表的尾节点
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
