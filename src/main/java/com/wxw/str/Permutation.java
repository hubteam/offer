package com.wxw.str;

import java.util.ArrayList;

/**
 * 字符串的全排列：输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *            例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * 解析步骤:第一个位置和后面所有的位置交换；  第一个位置固定，剩下的部分重复上一次的操作。
 * 
 * @author 王馨苇
 *
 */
public class Permutation {

	/**
	 * 递归
	 * @param str
	 * @return
	 */
	public static ArrayList<String> permutation(String str){
		if(str == null || str.length() <= 0){
			return null;
		}else{
			char[] c = str.toCharArray();
			ArrayList<String> arr = new ArrayList<String>();
			permutation(c, 0, arr);
			return arr;
		}
		
	}
	
	public static void permutation(char[] c, int begin, ArrayList<String> arr){
		if(c == null){
			return;
		}
		if(begin == c.length - 1){
			String s = "";
			for (int i = 0; i < c.length; i++) {
				s += c[i];
			}
			arr.add(s);
		}else{
			for (int i = begin; i < c.length; i++) {
				
				char temp = c[begin];
				c[begin] = c[i];
				c[i] = temp;
				
				permutation(c, begin + 1, arr);
				
				temp = c[begin];
				c[begin] = c[i];
				c[i] = temp;
			}
			
		}
	}
	
	public static void main(String[] args) {
		String str = "abc";
		permutation(str);
	}
}
