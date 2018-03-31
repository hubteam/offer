package com.wxw.xiaolv;

/**
 * 从1到N整数中1出现的次数：输入一个整数N，求从1到N的这个N个整数中的十进制表示中1出现的次数，
 * 例如12，从1到12这些整数中包含了1的数字有1,10,11,12，   1一共出现了5次
 * 
 * @author 王馨苇
 *
 */
public class NumberOf1Between1AndN {

	/**
	 * 方法1：用每个数除以10，判断余数是不是1，
	 * 时间复杂度是O(NlogN),因为输入一个数字N，都有logN位
	 * @param n
	 * @return
	 */
	public static int fangfa1(int n){
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += numberof1(i);
		}
		return sum;
	}
	
	public static int numberof1(int n){
		int sum = 0;
		while(n != 0){
			if(n % 10 == 1){
				sum++;
			}
			n /= 10;
		}
		return sum;
	}
	
	/**
	 * O(logN)
	 * 方法2：从数字规律入手，提高时间效率
	 * @param n
	 * @return
	 */
	public static int fangfa2(int n){
		int ones = 0;
		for (long m = 1; m <= n; m *= 10)    
			ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
		return ones;
	}
	
	/**
	 * O(logN)
	 * @param n
	 * @return
	 */
	public static int fangfa3(int n){
		int count = 0;  
		int i = 1;  
		int current = 0,after = 0,before = 0;  
        while((n / i) != 0) {  
            current = (n / i) % 10; //当前位数字  
            before = n / (i * 10); //高位数字  
            after = n - (n / i) * i; //低位数字  
            if (current > 1)  
                count = count + (before + 1) * i;  
            else if (current == 0)  
                count = count + before * i;  
            else if(current == 1)  
                count = count + before * i + after + 1;  
            i = i * 10;  
        }  
        return count; 
	}
	
	public static void main(String[] args) {
		System.out.println(fangfa2(12));
	}
}
