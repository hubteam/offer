package com.wxw.nengli;

import com.wxw.tree.TreeNode;

/**
 * 二叉树的深度
 * @author 王馨苇
 *
 */
public class TreeDepth {

	public static int getDepth(TreeNode node){
		if(node == null){
			return 0;
		}else{
			int l = getDepth(node.left);
			int r = getDepth(node.right);
			return (l > r ? l : r) + 1;
		}
	}
}
