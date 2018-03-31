package com.wxw.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ֮���ͱ�����ӡ������
 * 
 * @author ��ܰέ
 *
 */
public class ZhiBianli {

	public ArrayList<ArrayList<Integer>> print(TreeNode root){
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if(root == null){
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean reverse = false;
		while(!queue.isEmpty()){
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {//Ϊ�˽�һ������
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			if(reverse){
				Collections.reverse(list);
			}
			reverse = !reverse;
			ret.add(list);
		}
		return ret;
	}
}
