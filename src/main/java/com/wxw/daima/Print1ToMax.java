package com.wxw.daima;

/**
 * 打印1到最大的N位数
 * 
 * 注意点：N的大小不知道，可能是long，可能溢出
 * 
 * 采用全排列，递归，先第一位，第二位和第一位相同的方法，就这样递归下去
 * @author 王馨苇
 *
 */
public class Print1ToMax {

	public static void printToMaxNdigit(int n){
		if(n <= 0){
			return;
		}else{
			int[] a = new int[n];
			printArray(a, 0);
		}
	}
	
	public static void printArray(int[] a, int n){
		for (int i = 0; i < 10; i++) {
			a[n] = i;
			if(n != a.length - 1){//递归的部分
				printArray(a, n + 1);
			}else{
				boolean flag = false;
				//第一位为0的时候不输出
				for (int j = 0; j < a.length; j++) {
					if(a[j] != 0){
						System.out.print(a[j]);
						flag = true;//已经输出过了
					}else{
						if(flag){//那就可以直接输出了
							System.out.print(a[j]);
						}
					}
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		printToMaxNdigit(3);
	}
	
}
