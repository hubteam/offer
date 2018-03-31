package com.wxw.datastructure;

/**
 * 旋转数组的最小值：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * 解题：旋转之后数组可以划分为两个排序的子序列，而且前面的子序列的元素都大于后面的子序列的元素，最小的元素刚好是两个子数组的分割出
 * @author 王馨苇
 *
 */
public class ReverseMin {

	/**
	 * 第一种方式：顺序查找，利用最小值是两个子数组的分割地方
	 * 
	 * O(N)
	 * 
	 * @param array
	 * @return
	 */
	public static int minNumberInRotateArray(int [] array) {
		    
		if(array.length <= 0){
			return 0;
		}else{
			int count = -1;
			for (int i = 0; i < array.length - 2; i++) {
				if(array[i] > array[i + 1]){
					count = i + 1;
				}
			}
			if(count == -1){
				return 0;
			}else{
				return array[count];
			}
		}
	 }
	
	/**
	 * 第二种实现：二分查找，因为数组在某些程度上是排序的
	 * 
	 * 特例：如果把排序数组的前面0个元素搬到最后面，排序数组本身，仍然是一个数组的旋转，代码需要支持这种情形，此时数组中的第一个元素就是最小的数字，可以直接返回
	 *     left right mid三个位置元素相同的时候{1,0,1,1,1} {1,1,1,0,1}，这时候无法确定中间元素属于递增还是递减的数组中：【顺序查找】
	 * 注意：要考虑特殊的测试用例
	 * O(logN)
	 * 
	 * @param array
	 * @return
	 */
	public static int minNumberInRotateArray2(int [] array) {
	    
		if(array.length <= 0){
			return 0;
		}else{
			
			int left = 0;
			int right = array.length - 1;//这里是length-1
			int mid = left;//初始化为left是因为数组如果没有反转，就是数组本身，第一个数字就是最小的数字
			while(array[left] >= array[right]){				
				
				if((right - left) == 1){
					mid = right;//这一步的赋值是找到后，把应该得到的索引赋值给mid
					break;
				}
				
				mid = (left + right) / 2;
				//如果三个元素相等的时候:顺序查找
				if(array[mid] == array[left] && array[left] == array[right]){
					return minNumberInRotateArray(array);
				}
				if(array[mid] >= array[left]){
					left = mid;
				}else if(array[mid] <= array[right]){
					right = mid;
				}
			}
			//此时mid包含了两种情况：找到的，和一开始数组没反转的第一个
			return array[mid];
		}	 
	}
	
	public static void main(String[] args) {
		int[] a = {6,1,2,3,4,5};
		int[] b = {1,2,3,4,5,6,7,8};
		int[] c = {1,0,1,1,1};
		int[] d = {1,1,1,0,1};
		System.out.println(minNumberInRotateArray2(a));
		System.out.println(minNumberInRotateArray2(b));
		System.out.println(minNumberInRotateArray2(c));
		System.out.println(minNumberInRotateArray2(d));
	}
}
