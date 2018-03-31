package com.wxw.nengli;

import com.wxw.tree.TreeNode;

/**
 * 判断输入的树是不是平衡二叉树
 * 
 * @author 王馨苇
 *
 */
public class IsAVL {

	/**
	 * 第一种方法：节点需要重复遍历
	 * 在获得深度的时候需要遍历节点，在判断平衡的时候又要重复遍历。效率低下
	 * 
	 * @param root
	 * @return
	 */
	public boolean isAVL1(TreeNode root){
		if(root == null){
			return true;
		}
		int left = TreeDepth.getDepth(root.left);
		int right = TreeDepth.getDepth(root.right);
		int diff = left - right;
		if(diff > 1 || diff < -1)
			return false;
		return isAVL1(root.left) && isAVL1(root.right);
	}
	
	/**
	 * private boolean isBalanced(BinaryTreeNode root, int depth) {  
    if(root==null) {  
        depth=0;  
        return true;  
    }  
    int left=0,right=0;  
    if(isBalanced(root.leftNode,left)&&isBalanced(root.rightNod  
            e, right)) {  
        int diff=left-right;  
        if(diff<=1&&diff>=-1) {  
            depth=1+(left>right?left:right);  
            return true;  
        }  
    }  
    return false;  
}
	 */
}
