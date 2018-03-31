package com.wxw.xiaolv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ��С��K����:����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 * 
 * @author ��ܰέ
 *
 */
public class GetLeastNumber {

	/**
	 * ���Ǹ����ң��ҵ���С��K����������Ҫ��ȷ�Ƿ�����޸�����
	 * ���ڿ��������˼�� O(N)
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
	 * �ⷨ2��O(NlogK)�ʺϴ���������
	 * ����һ����СΪK�������������洢��С��K�����֣�������������ÿ�δ������N����������һ�������������������K������ֱ�ӷ�������������������Ѿ���K�������ˣ�������������
	 * ��ʱ�����ٲ������֣�ֻ���滻���е����֣��ҳ����е�K�������е����ֵ�ʹ������ֵ�Ƚϣ�����������ֵ�ȵ�ǰ���е����ֵС����������滻��ǰ���е����ֵ��
	 * ����������ֵ��֮ǰ�����ֵ���򣬾���������������ֵ
	 * 
	 * ����������֮����Ҫ���������飺һ������K���������ҵ�������������п��������������ɾ��������������п���Ҫ����һ���µ�����
	 * ����ö�������ʵ�����������������ô������O(logK)ʱ����ʵ��������
	 * 
	 * ����ѡ��ͬ�Ķ�������ʵ�������������������ÿ�ζ���Ҫ�ҵ�K�������е�������֣��������뵽���ѡ�
	 * ��������ÿ����O(1)�õ�����K�������е����ֵ��������ҪO(logK)ʱ��ȥ���ɾ���Ͳ���Ĳ���
	 * 
	 * ������еĲ��ҡ�ɾ���Ͳ��붼��ҪO(logK)
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
