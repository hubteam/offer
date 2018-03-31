package com.wxw.xiaolv;

import java.util.Stack;

import com.wxw.tree.TreeNode;

/**
 * ���������ڵ����͹�������
 * 
 * @author ��ܰέ
 *
 */
public class LowestFather {

	/**
	 * ����������������ʱ�临�Ӷ���O(logn)���ռ临�Ӷ���O(1)
	 * ˼·�������ĸ��ڵ㿪ʼ������������ڵ��ֵ��������һ���ڵ㣬С������һ���ڵ㣬����ڵ������͹������ȡ�
	 * ����������ڵ��ֵС�������ڵ��ֵ����ݹ�����ڵ����������������������ڵ��ֵ��ݹ��������������
	 * ������ڵ����������е�һ���ڵ㣬��ô˵���������ڵ���һ��·���ϣ�������͹����������Ǹ��ڵ�ĸ��ڵ�
	 */
	public static TreeNode get1(TreeNode root, TreeNode node1, TreeNode node2){
		if(root == null || node1 == null || node2 == null){  
            return null;  
        } 
		if((root.val - node1.val) * (root.val - node2.val) < 0){  
            return root;  
        }else {  
            TreeNode newRoot = ((root.val > node1.val) && (root.val > node2.val)) ? root.left : root.right;  
            return get1(newRoot, node1, node2);  
        }
	}
	
	/**
	 * ������ͨ���������������нڵ�ָ�򸸽ڵ�
	 * 
	 * ˼·�������������������·���ϣ�����������������ĵ�һ�������ڵ�
	 */
	 public static TreeNode  getLowestCommonAncestor1(TreeNode root, TreeNode node1, TreeNode node2){  
        if(root == null || node1 == null || node2 == null){  
            return null;  
        }  
        int depth1 = findTheDepthOfTheNode(node1);  
        int depth2 = findTheDepthOfTheNode(node2);  

        //pָ�����Ľڵ�qָ���ǳ�Ľڵ�  
        TreeNode p = depth1 > depth2 ? node1 : node2;  
        TreeNode q = depth1 > depth2 ? node2 : node1;  
        int depth =  Math.abs(depth1 - depth2);  
        while(depth > 0){  //�̵����߲�ֵ�Ĳ���
            p = p.parent;  
            depth --;  
        }  
        while(p != q){  
            p = p.parent;  
            q = q.parent;  
        }  
        return p;  
    }  
      
    //�õ����
    public static int findTheDepthOfTheNode(TreeNode root){  
        int depth = 0;  
        while(root != null){  
        	root = root.parent;  
            depth ++;  
        }  
        return depth;  
    } 
	 
	
	/**
	 * ��ͨ��������û��ָ�򸸽ڵ�
	 * 1���ҳ��ڵ��·����������ջ��
	 * 2��������ջ�ȳ�
	 * 2�����������ҵ����һ������ȵĽڵ�
	 * 
	 */
    public static TreeNode getLowestCommonAncestor2(TreeNode root, TreeNode node1, TreeNode node2){  
        if(root == null || node1 == null || node2 == null){  
            return null;  
        }  
        Stack<TreeNode> path1 = new Stack<TreeNode>();
        boolean flag1 = getThePathOfTheNode(root, node1, path1);  
        if(!flag1){//����û��node1�ڵ�  
            return null;  
        }  
        Stack<TreeNode> path2 = new Stack<TreeNode>();  
        boolean flag2 = getThePathOfTheNode(root, node2, path2);  
        if(!flag2){//����û��node2�ڵ�  
            return null;  
        }  
         
        //������·���ȳ�  
        if(path1.size() > path2.size()){ 
            while(path1.size() !=  path2.size()){  
                path1.pop();  
            }  
        }else{  
            while(path1.size() !=  path2.size()){  
                path2.pop();  
            }  
        }  
        
        //������ջ������ȵ�ʱ���Ƿ����
        if(path1.equals(path2)){//�������ڵ���һ��·����ʱ  
            path1.pop();  
            return path1.pop();  
        }else{  
        	//�ҵ���һ����ȵģ�ջ�ǵ����ҵģ���һ����ȵľ������һ����ȣ�
            TreeNode p = path1.pop();  
            TreeNode q = path2.pop();  
            while(q != p){  
                p = path1.pop();  
                q = path2.pop();  
            }  
            return p;  
        }  
    }   
      
    //��ø��ڵ㵽node�ڵ��·��  
    public static boolean getThePathOfTheNode(TreeNode root, TreeNode node, Stack<TreeNode> path){  
        path.push(root);  
        if(root == node){  
            return true;  
        }  
        boolean found = false;  
        if(root.left != null){  
            found = getThePathOfTheNode(root.left, node, path);  
        }  
        if(!found && root.right != null){  
            found = getThePathOfTheNode(root.right, node, path);  
        }  
        if(!found){  
            path.pop();  
        }  
        return found;  
    } 
	
    public static void main(String[] args) {
    	TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		
		TreeNode root6 = new TreeNode(6);
		TreeNode root7 = new TreeNode(7);
		TreeNode root8 = new TreeNode(8);
		TreeNode root9 = new TreeNode(9);
		TreeNode root10 = new TreeNode(10);
		TreeNode root11 = new TreeNode(11);
		TreeNode root12 = new TreeNode(12);
		
		root1.left = root2;
		root1.right = root4;
		root2.left = root3;
		root2.right = root5;
		root4.left = root6;
		root4.right = root7;
		root3.left = root8;
		root3.right = root9;
		root5.left = root10;
		root5.right = root11;
		root6.left = root12;
		Stack<TreeNode> s = new Stack<TreeNode>();
		getThePathOfTheNode(root1, root9, s);
		for (TreeNode treeNode : s) {
			System.out.println(treeNode.val);
		}
	}
}
