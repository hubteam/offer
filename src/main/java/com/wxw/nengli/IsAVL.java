package com.wxw.nengli;

import com.wxw.tree.TreeNode;

/**
 * �ж���������ǲ���ƽ�������
 * 
 * @author ��ܰέ
 *
 */
public class IsAVL {

	/**
	 * ��һ�ַ������ڵ���Ҫ�ظ�����
	 * �ڻ����ȵ�ʱ����Ҫ�����ڵ㣬���ж�ƽ���ʱ����Ҫ�ظ�������Ч�ʵ���
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
