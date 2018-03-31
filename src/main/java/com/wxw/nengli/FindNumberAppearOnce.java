package com.wxw.nengli;

/**
 * 数组中只出现一次的数字：一个整型数组中除了两个数字之外，其他的数字都出现了两次，要求时间复杂度O(1)，空间复杂度O(1)
 * 
 * 任何一个数字异或它自己都是0，从头到尾异或数组中每一个元素，最终结果刚好是哪个只出现一次的数字----解决数组中只有一个出现一次
 * 
 * 针对题中的问题：
 * 将数组分为两个部分，以数组中每个元素第N位是不是1分为两个数组，第一个子数组，第N位是1，第二个子数组，第N位是0
 * 
 * 具体的步骤是：
 * 先对数组异或，看得到的结果第几位是1
 * 根据上面的得到的第几位将数组分为两个子数组
 * 分别对两个子数组异或，可以得到要求的结果
 * 
 * @author 王馨苇
 *
 */
public class FindNumberAppearOnce {

	public void appearOnce(int[] data, int num1, int num2){
		if(data == null || data.length <= 0){
			return;
		}
		
		int result = 0;
		
		for (int i = 0; i < data.length; i++) {
			result ^= data[i];
		}
		int indexOf1 = findFirst1(result);
		num1 = num2 = 0;
		for (int i = 0; i < data.length; i++) {
			if(isBit1(data[i], indexOf1) == 1){
				num1 ^= data[i];
			}else{
				num2 ^= data[i];
			}
		}
	}
	
	public int findFirst1(int num){
		int indexBit = 0;
		while((num & 1) == 0){
			num = num >> 1;
		    indexBit++;
		}
		return indexBit;
		
	}
	
	public int isBit1(int num, int indexOf1){
		num = num >> 1;
		return (num & 1);
	}
}
