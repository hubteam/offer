package com.wxw.tree;

import java.util.ArrayList;

public class FindPathEqualHe {

	static ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
	static int count = 0;
	
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
		
		if(root != null){
			int sum = 0;
			ArrayList<Integer> array = new ArrayList<Integer>();
			find(root, sum, target, array);
		}	
		
		return arrays;
	}
	
	public static void find(TreeNode node, int sum, int target, ArrayList<Integer> arr){
		if(node == null){
			return;
		}
		sum += node.val;
		arr.add(node.val);
		if(node.left == null && node.right == null){
			if(sum == target){
				//这块一定要这样，不然arr变化，arrays也会跟着变化
				ArrayList<Integer> arrcopy = new ArrayList<Integer>(arr);
				arrays.add(arrcopy);
			}
		}
		if(node.left != null){
			find(node.left, sum, target, arr);
		}
		if(node.right != null){
			find(node.right, sum, target, arr);
		}
		sum -= node.val;
		arr.remove(arr.size() - 1);
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(10);  
        TreeNode node1 = new TreeNode(5);  
        TreeNode node2 = new TreeNode(12);  
        TreeNode node3 = new TreeNode(4);  
        TreeNode node4 = new TreeNode(7);  
        root1.left = node1;  
        root1.right = node2;  
        node1.left = node3;  
        node1.right = node4;
        ArrayList<ArrayList<Integer>> a = FindPath(root1, 22);
        for (ArrayList<Integer> arrayList : a) {
			for (Integer integer : arrayList) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
