package com.wxw.wei;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * @author 王馨苇
 *
 */
public class NumberOfOne {

	//一般解法（可能引起死循环）：先判断一个整数的二进制中最后一位是不是1，接着右移一位，此时原来处于从右边数起的第二位被移到最右边了，在判断是不是1，每次移动一位，直到为0
	//解释：右移一位相当于除法，但是不能用除以2，因为除法的效率高
	//    判断是不是一，用与1的操作
	//问题：如果是负数，就会造成死循环
	public static int numberOfOne1(int n){
		
		int count = 0;
		while(n != 0){
			if((n & 1) == 1){
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
	
	//解决上述死循环的问题：把每次数字右移一位改为1左移1位
	public static int numberOfOne2(int n){
		
		int count = 0;
		int flag = 1;
		while(n != flag){
			if((n & flag) == 1){
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	//第三种方法：一个整数减去1，在和原来的整数做与运算，会把整数最右边的1变成0，那么一个整数的二进制有多少1，就可以进行多少次运算
	public static int numberOfOne3(int n){
		
		int count = 0;
		while(n != 0){
			n = (n - 1) & n;
			count++;
		}
		return count;
	}
}
