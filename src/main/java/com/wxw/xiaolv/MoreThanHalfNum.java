package com.wxw.xiaolv;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * 分析：考虑数组的特性，数组中有一个数字出现次数超过数组的长度的一半，如果这个数组排序，那么排序之后位于数组中间的数字一定就是那个出现次数超多数组长度一半的数字（中位数）
 * @author 王馨苇
 *
 */
public class MoreThanHalfNum {

	/**
	 * 受快速排序算法的启发 O(N)
	 * 
	 * 注意要检测输入的数组书否合法：也就是检验返回的那个数字在数组中是否超过了一半
	 * 
	 * @param array
	 * @return
	 */
	public static int MoreThanHalfNum_Solution(int[] array) {
		if(array == null || array.length <= 0){
			return 0;
		}
        int mid = array.length / 2;
        int i = partition(array, 0, array.length - 1);
        while(mid != i){
        	if(i < mid){
        		i = partition(array, i + 1, array.length - 1);
        	}else if(i > mid){
        		i = partition(array, 0, i - 1);
        	}
        }
        int result = array[mid];
        if(check(array, result)){
        	return array[mid];
        }else{
        	return 0;
        }
        
    }
	
	/**
	 * 根据数组自身的特点找出：O(N)
	 * 
	 * 数组中有一个数字出现的次数超过数组长度的一半，也就是说他出现的次数比其他所有数字出现的次数的和还要多，
	 * 在遍历数组的时候保存两个值：一个是数组中一个数字，一个是次数，当遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，次数+1，否则-1，
	 * 如果次数为0，我们需要保存下一个数字，把次数设为1，要找的数字肯定是最后一次把次数设为1对应的数字
	 * 
	 * @param array
	 * @return
	 */
	public static int fangfa2(int[] array){
		
		int result = array[0];
		int times = 1;
		for (int i = 1; i < array.length; i++) {
			System.out.println("times:"+times);
			//次数为0的时候，保存下一个数字
			if(times == 0){
				result = array[i];
				times = 1;
			}else if(array[i] == result){
				times++;
			}else{
				times--;
			}
		}
		return result;
	}
	
	public static boolean check(int[] array, int key){
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == key){
				count++;
			}
		}
		if(count > array.length / 2){
			return true;
		}else{
			return false;
		}
	}
	
	public static int partition(int[] array, int left, int right){
		if(left < right){
			int i = left;
			int j = right;
			int temp = array[j];
			while(i < j){
				while(i < j && array[i] < temp){
					i++;
				}
				if(i < j){
					array[j] = array[i];
					j--;
				}
				while(i < j && array[j] > temp){
					j--;
				}
				if(i < j){
					array[i] = array[j];
					i++;
				}
			}
			array[j] = temp;
			return j;
		}
		return right;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,2,2,2,5,4,2};
		System.out.println(MoreThanHalfNum_Solution(a));
		int[] b = {1,2,3,2,2,2,5,4,2};
		System.out.println(fangfa2(b));
	}
}
