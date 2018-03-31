package com.wxw.xiaolv;

/**
 * 丑数：只包含因子2、3、5的数称为丑数
 * 也就是说一个数能被2整除，我们把它连续除以2，如果能被3整除，就连续除以3，如果能被5整除，就连续除以5，如果最后得到1，这个数就是丑数
 * 
 * @author 王馨苇
 *
 */
public class Ugly {

	public boolean isUgly(int number){
		while(number % 2 == 0)
			number /= 2;
		while(number % 3 == 0)
			number /= 3;
		while(number % 5 == 0)
			number /= 5;
		return (number == 1)? true : false;
	}
	//第一种方法：逐个判断每个元素【效率比较低，因为不是丑数也要去判断】
	//第二种方法：
	//根据丑数的定义可得，丑数应该是一个丑数乘以2、3、5的结果，我们可以创建数组，里面的数字是排好序的丑数
	public static int getUglyNumber(int index){
		if(index <= 0){
			return 0;
		}
		
		int[] uglyNumber = new int[index];
		uglyNumber[0] = 1;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		int next = 1;
		while(next < index){
			int min = min(uglyNumber[index2] * 2, uglyNumber[index3] * 3, uglyNumber[index5] * 5);
			uglyNumber[next] = min;
			
			while(uglyNumber[index2] * 2 <= uglyNumber[next]){
				index2++;
			}
			while(uglyNumber[index3] * 3 <= uglyNumber[next]){
				index3++;
			}
			while(uglyNumber[index5] * 5 <= uglyNumber[next]){
				index5++;
			}
			++next;
		}
		return uglyNumber[next-1];
	}
	
	public static int min(int a, int b, int c){
		if(a <= b && a <= c){
			return a;
		}else if(b <= a && b <= c){
			return b;
		}else{
			return c;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getUglyNumber(6));
	}
}
