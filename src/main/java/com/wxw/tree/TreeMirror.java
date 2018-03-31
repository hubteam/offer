package com.wxw.tree;

public class TreeMirror {

	public static TreeNode Mirror(TreeNode root){
		if(root != null){
			TreeNode mirror = new TreeNode(root.val);
			mirror.left = Mirror(root.right);
			mirror.right = Mirror(root.left);
			return mirror;
		}else{
			return null;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root1=new TreeNode(8);  
        TreeNode node1=new TreeNode(6);  
        TreeNode node2=new TreeNode(10);  
        TreeNode node3=new TreeNode(5);  
        TreeNode node4=new TreeNode(7);  
        TreeNode node5=new TreeNode(9);  
        TreeNode node6=new TreeNode(11);  
        root1.left = node1;  
        root1.right = node2;  
        node1.left = node3;  
        node1.right = node4;  
        node2.left = node5;  
        node2.right = node6;  
//        ReConstructBinaryTree.preorder(root1);
//        System.out.println();
//        TreeNode mirror = Mirror(root1);
//        ReConstructBinaryTree.preorder(mirror);
        
        
        int[] source = new int[]{1,2,3,4};
        int[] destination = new int[]{2,3,4,1};
        //存放DP结果的数组
        int[] D = new int[8];
        for (int i = 0; i < D.length; i++)
            D[i] = 0;
        LeastStepsForChange(D, source, destination, 0);
        System.out.println(D[0]);
	}
	
	
	public static int LeastStepsForChange(int[] D, int[] source, int[] destination, int index) {
		  //设置两个变量分别存储两种转换方式所需要的最少转换步骤
        int steps1 = 0;
        int steps2 = Integer.MAX_VALUE;
        if (index == (source.length - 1)) {//如果当前已经处理到最后一个元素了，那么只需要计算对应位置元素之间差的绝对值
            D[index] = Math.abs(source[index] - destination[index]);
        } else {//否则就需要进行两种方式的尝试
            steps1 = Math.abs(source[index] - destination[index]) + LeastStepsForChange(D, source, destination, index + 1);
            //因为第二种方式会尝试交换index后面的任何一个元素，并且交换之后source也会变化，所以一方面要循环，
            //另一方面还要修改source数组.
            int[] src;
            for (int j = index + 1; j < source.length; j++) {
                //首先交换source[index]和source[j]
                int temp = 0;
                temp = source[j];
                source[j] = source[index];
                source[index] = temp;
                //记录变化之后的source数组
                src = source;


                if ((1 + Math.abs(source[index] - destination[index]) + LeastStepsForChange(D, src, destination, index + 1)) < steps2) {
                    steps2 = 1 + Math.abs(source[index] - destination[index]) + LeastStepsForChange(D, src, destination, index + 1);
                }
            }
            D[index] = Math.min(steps1, steps2);
        }
        return D[index];
	}
}
