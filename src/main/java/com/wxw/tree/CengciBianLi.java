package com.wxw.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * 
 * @author 王馨苇
 *
 */
public class CengciBianLi {

	//ArrayDeque
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
		ArrayList<Integer> array = new ArrayList<Integer>();
		if(root == null){
			return array;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			array.add(temp.val);
			if(temp.left != null){
				queue.add(temp.left);
			}
			if(temp.right != null){
				queue.add(temp.right);
			}
		}
		return array;
	}
}
