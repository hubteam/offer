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
        //���DP���������
        int[] D = new int[8];
        for (int i = 0; i < D.length; i++)
            D[i] = 0;
        LeastStepsForChange(D, source, destination, 0);
        System.out.println(D[0]);
	}
	
	
	public static int LeastStepsForChange(int[] D, int[] source, int[] destination, int index) {
		  //�������������ֱ�洢����ת����ʽ����Ҫ������ת������
        int steps1 = 0;
        int steps2 = Integer.MAX_VALUE;
        if (index == (source.length - 1)) {//�����ǰ�Ѿ��������һ��Ԫ���ˣ���ôֻ��Ҫ�����Ӧλ��Ԫ��֮���ľ���ֵ
            D[index] = Math.abs(source[index] - destination[index]);
        } else {//�������Ҫ�������ַ�ʽ�ĳ���
            steps1 = Math.abs(source[index] - destination[index]) + LeastStepsForChange(D, source, destination, index + 1);
            //��Ϊ�ڶ��ַ�ʽ�᳢�Խ���index������κ�һ��Ԫ�أ����ҽ���֮��sourceҲ��仯������һ����Ҫѭ����
            //��һ���滹Ҫ�޸�source����.
            int[] src;
            for (int j = index + 1; j < source.length; j++) {
                //���Ƚ���source[index]��source[j]
                int temp = 0;
                temp = source[j];
                source[j] = source[index];
                source[index] = temp;
                //��¼�仯֮���source����
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
