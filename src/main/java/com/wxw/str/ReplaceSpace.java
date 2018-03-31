package com.wxw.str;

/**
 * 问题：请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * 思路：（1）在原来的字符串上替换，要保证输入的字符串后面有足够多的内存：【会涉及移动，时间复杂度高】
 *     （2）创建新的字符串并在新的字符串上做替换，那么我们可以自己分配足够多的内存
 * @author 王馨苇
 *
 */
public class ReplaceSpace {

	public static String replaceSpace(StringBuffer str){
		if(str == null || str.length() <= 0){
			return null;
		}else{
			//可以第一遍扫描，看要分配多少空间
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == ' '){
					sb.append("%20");
				}else{
					sb.append(str.charAt(i));
				}
			}
			return sb.toString();
		}
		
	}
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("we are happy.");
		System.out.println(replaceSpace(sb));
	}
}
