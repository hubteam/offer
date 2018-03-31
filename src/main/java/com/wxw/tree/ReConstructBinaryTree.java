package com.wxw.tree;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * 用到递归的思想
 * 
 * @author 王馨苇
 *
 */
public class ReConstructBinaryTree {


	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) throws Exception {
		
		if(pre.length <= 0 && in.length <= 0){
			return null;
		}else if(pre.length != in.length){
			throw new Exception("非法输入");
		}else{
			TreeNode root = null;
			for (int i = 0; i < in.length; i++) {
				if(in[i] == pre[0]){
					root = new TreeNode(in[i]);
					root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), 
							Arrays.copyOfRange(in, 0, i));
					root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), 
							Arrays.copyOfRange(in, i+1, in.length));
				}
			}
			return root;
		}
    }
	
	public static void main(String[] args) throws Exception {
		int[] preSort={1,2,4,7,3,5,6,8};  
        int[] inSort={4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(preSort, inSort);
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
	}
	
	/**
	 * 前序遍历
	 * @param root
	 */
	public static void preorder(TreeNode root){
	
		if(root != null){
			System.out.print(root.val+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	/**
	 * 中序遍历
	 * @param root
	 */
	public static void inorder(TreeNode root){
		
		if(root != null){
			inorder(root.left);
			System.out.print(root.val+" ");
			inorder(root.right);
		}
	}
	
	/**
	 * 后序遍历
	 * @param root
	 */
	public static void postorder(TreeNode root){
		
		if(root != null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.val+" ");
		}
	}
}
