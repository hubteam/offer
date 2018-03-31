package com.wxw.tree;

/**
 * 二叉搜索树的后续遍历
 * 注意：这里不是中序遍历
 * 
 * 解析：后续遍历的最后一个是根节点，前面部分可以分为两个部分，比根小的左子树，和比根大的右子树
 * @author 王馨苇
 *
 */
public class PostBST {
	
	/**
	 * 判断一个序列是不是二叉搜索树得到的
	 * @param sequence
	 * @return
	 */
	public static boolean VerifySquenceOfBST(int[] sequence){
		
		if(sequence == null || sequence.length <= 0){
			return false;
		}else{
			int root = sequence[sequence.length - 1];
			int i = 0;
			
			for (i = 0; i < sequence.length - 1; i++) {
				if(sequence[i] > root){
					break;
				}
			}
			for (int j = i; j < sequence.length - 1; j++) {
				if(sequence[j] < root){//右面大于根，如果小于根，说明错误
					return false;
				}
			}
			
			boolean left = true;
			int[] leftcopy = new int[i];
			System.arraycopy(sequence, 0, leftcopy, 0, leftcopy.length);
			if(i > 0){
				left = VerifySquenceOfBST(leftcopy);
			}
			
			boolean right = true;
			int[] rightcopy = new int[sequence.length - 1 - i];
			System.arraycopy(sequence, i, rightcopy, 0, rightcopy.length);
			if(i < sequence.length - 1){
				right = VerifySquenceOfBST(rightcopy);
			}
			
			return (left && right);
		}
	}
	private static int min = Integer.MIN_VALUE;//记录前驱
	/**
	 * 判断一颗树是不是二叉查找树
	 * @param node
	 * @return
	 */
	public static boolean panduan(TreeNode node){
		if(node == null){
			return true;
		}else{
			boolean left = panduan(node.left);
			if(left == false || min > node.val){
				return false;
			}
			min = node.val;
			boolean right = panduan(node.right);
			return right;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {5,7,6,9,11,10,8};
		int[] b = {7,4,6,5};
		int[] c = {5,6,7,9,11,10,8};
		System.out.println(VerifySquenceOfBST(a));
		System.out.println(VerifySquenceOfBST(b));
		System.out.println(VerifySquenceOfBST(c));
		
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
        System.out.println(panduan(root1));
	}
}
