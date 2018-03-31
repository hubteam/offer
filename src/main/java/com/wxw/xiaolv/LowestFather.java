package com.wxw.xiaolv;

import java.util.Stack;

import com.wxw.tree.TreeNode;

/**
 * 树中两个节点的最低公共祖先
 * 
 * @author 王馨苇
 *
 */
public class LowestFather {

	/**
	 * 树是搜索二叉树：时间复杂度是O(logn)，空间复杂度是O(1)
	 * 思路：从树的根节点开始遍历，如果根节点的值大于其中一个节点，小于另外一个节点，则根节点就是最低公共祖先。
	 * 否则如果根节点的值小于两个节点的值，则递归求根节点的右子树，如果大于两个节点的值则递归求根的左子树。
	 * 如果根节点正好是其中的一个节点，那么说明这两个节点在一条路径上，所以最低公共祖先则是根节点的父节点
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
	 * 树是普通二叉树，但树中有节点指向父节点
	 * 
	 * 思路：如果两个链表在两条路径上，类似于求两个链表的第一个公共节点
	 */
	 public static TreeNode  getLowestCommonAncestor1(TreeNode root, TreeNode node1, TreeNode node2){  
        if(root == null || node1 == null || node2 == null){  
            return null;  
        }  
        int depth1 = findTheDepthOfTheNode(node1);  
        int depth2 = findTheDepthOfTheNode(node2);  

        //p指向较深的节点q指向较浅的节点  
        TreeNode p = depth1 > depth2 ? node1 : node2;  
        TreeNode q = depth1 > depth2 ? node2 : node1;  
        int depth =  Math.abs(depth1 - depth2);  
        while(depth > 0){  //短的先走差值的步数
            p = p.parent;  
            depth --;  
        }  
        while(p != q){  
            p = p.parent;  
            q = q.parent;  
        }  
        return p;  
    }  
      
    //得到深度
    public static int findTheDepthOfTheNode(TreeNode root){  
        int depth = 0;  
        while(root != null){  
        	root = root.parent;  
            depth ++;  
        }  
        return depth;  
    } 
	 
	
	/**
	 * 普通二叉树，没有指向父节点
	 * 1、找出节点的路径，保存在栈中
	 * 2、让两个栈等长
	 * 2、遍历链表找到最后一个不相等的节点
	 * 
	 */
    public static TreeNode getLowestCommonAncestor2(TreeNode root, TreeNode node1, TreeNode node2){  
        if(root == null || node1 == null || node2 == null){  
            return null;  
        }  
        Stack<TreeNode> path1 = new Stack<TreeNode>();
        boolean flag1 = getThePathOfTheNode(root, node1, path1);  
        if(!flag1){//树上没有node1节点  
            return null;  
        }  
        Stack<TreeNode> path2 = new Stack<TreeNode>();  
        boolean flag2 = getThePathOfTheNode(root, node2, path2);  
        if(!flag2){//树上没有node2节点  
            return null;  
        }  
         
        //让两个路径等长  
        if(path1.size() > path2.size()){ 
            while(path1.size() !=  path2.size()){  
                path1.pop();  
            }  
        }else{  
            while(path1.size() !=  path2.size()){  
                path2.pop();  
            }  
        }  
        
        //让两个栈长度相等的时候，是否相等
        if(path1.equals(path2)){//当两个节点在一条路径上时  
            path1.pop();  
            return path1.pop();  
        }else{  
        	//找到第一个相等的（栈是倒着找的，第一个相等的就是最后一个相等）
            TreeNode p = path1.pop();  
            TreeNode q = path2.pop();  
            while(q != p){  
                p = path1.pop();  
                q = path2.pop();  
            }  
            return p;  
        }  
    }   
      
    //获得根节点到node节点的路径  
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
