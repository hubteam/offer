package com.wxw.xiaolv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的K个数:输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * @author 王馨苇
 *
 */
public class GetLeastNumber {

	/**
	 * 这是个查找，找到最小的K个数，首先要明确是否可以修改数组
	 * 基于快速排序的思想 O(N)
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if(input == null || input.length <= 0 || k < 1 || input.length < k){
        	return null;
        }
        int index = MoreThanHalfNum.partition(input, 0, input.length - 1);
        while(index != k){
        	if(index < k){
        		index = MoreThanHalfNum.partition(input, index + 1, input.length - 1);
        	}else{
        		index = MoreThanHalfNum.partition(input, 0, index - 1);
        	}
        }
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
			array.add(input[i]);
		}
        return array;
    }
	
	/**
	 * 解法2：O(NlogK)适合处理海量数据
	 * 创建一个大小为K的数据容器来存储最小的K个数字，接下来，我们每次从输入的N个整数读入一个数，如果容器中少于K个数就直接放入容器，如果容器中已经有K个整数了，就是容器满了
	 * 此时不能再插入数字，只能替换已有的数字，找出已有的K个数字中的最大值和待插入的值比较，如果待插入的值比当前已有的最大值小，用这个数替换当前已有的最大值，
	 * 如果待插入的值比之前的最大值还打，就舍弃这个待插入的值
	 * 
	 * 当容器满了之后，需要做三件事情：一个是在K个整数中找到最大数，而是有可能在这个容器中删除最大数，三是有可能要插入一个新的数字
	 * 如果用二叉树来实现这个数据容器，那么可以在O(logK)时间内实现这三部
	 * 
	 * 可以选择不同的二叉树来实现这个数据容器，由于每次都需要找到K个整数中的最大数字，很容易想到最大堆。
	 * 这样可以每次在O(1)得到已有K个数字中的最大值，但是需要O(logK)时间去完成删除和插入的操作
	 * 
	 * 红河书中的查找、删除和插入都需要O(logK)
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static Queue<Integer> GetLeastNumbers_Solution2(int[] input, int k){
		if(input == null || input.length <= 0){
        	return null;
        }
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			public int compare(Integer arg0, Integer arg1) {
				return arg1 - arg0;
			}
		});
		for (int i = 0; i < k; i++) {
			queue.add(input[i]);
		}
		for (int i = k; i < input.length; i++) {
			
			if(input[i] > queue.peek()){
				
			}else{
				queue.poll();
				queue.add(input[i]);
			}
		}
		return queue;
	}
	
	public static void test(){
		PriorityQueue<Test> queue = new PriorityQueue<Test>();
		queue.add(new Test(4));
		queue.add(new Test(5));
		queue.add(new Test(1));
		queue.add(new Test(6));
	}
	
	public static void main(String[] args) {
		int[] a = {4,5,1,6,2,7,3,8};
		ArrayList<Integer> array = GetLeastNumbers_Solution(a, 4);
		for (Integer integer : array) {
			System.out.println(integer);
		}
		
		
		int[] b = {4,5,1,6,2,7,3,8};
		
		Queue<Integer> queue = GetLeastNumbers_Solution2(b, 4);
		for (Integer integer : queue) {
			System.out.println(integer);
		}
		test();
	}
}
