package com.wxw.buchong;

/**
 * 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 *  在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author 王馨苇
 *
 */
public class RegexPiPei {

	/**
	 * 采用递归的方法：
	 * 1、下一位是*
	 *  1.1 匹配成功：match(str+1,pattern)
	 *  1.2
	 * @param str
	 * @param pattern
	 * @return
	 */
	public boolean match(char[] str, char[] pattern){
		if(str == null || pattern == null){
			return false;
		}
		return false;
	}
	
	public boolean matchRegCore(char[] str, int i, int length1, char[] pattern, int j, int length2){
		if(i != length1 && j == length2){
			return false;
		}
		if(i == length1){//主串匹配到末尾
			if(j == length2){
				return true;
			}else{
				return false;
			}
		}
		
		//如果模式串的下一个字符是*,
		//(1)模式串的当前字符能与主串的字符进行匹配，出现三种情况
		//1.模式串的当前字符匹配到0个字符，则主串不变，模式串移动两个字符
		//2.模式串的当前字符匹配到1个字符，主串移动一个位置，模式串移动两个位置
		//3.模式串匹配到多个字符，主串移动一个位置，模式串移动两个位置
		//(2)如果下一个字符不是*,逐个字符匹配
		//(3)模式串的下一个字符是.，则进行一个字符匹配
		if(j + 1 < length2 && pattern[j+1] == '*'){
			if(str[i] == pattern[j] || pattern[j] == '.'){
				return matchRegCore(str, i + 1, length1, pattern, j + 2, length2);
			}else{
				return matchRegCore(str, i, length1, pattern, j + 2, length2);
			}
		}
		
		if(i < length1 && (str[i] == pattern[j] || pattern[j] == '.')){
			return matchRegCore(str, i + 1, length1, pattern, j + 1, length2);
		}
		return false;
	}
}
