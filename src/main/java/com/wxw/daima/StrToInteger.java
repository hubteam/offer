package com.wxw.daima;

/**
 * 将字符串转换成整数
 * 考虑的情况：数值太大，溢出；数值有字母，异常输入；考虑前面的正负号
 * @author 王馨苇
 *
 */
public class StrToInteger {

	public int strToInt(String str) throws Exception{
		if(str == null || str.length() == 0){
			return 0;
		}
		int result = 0;
		int begin = 0;
		boolean minus = false;
		char[] c = str.toCharArray();
		//考虑开始正负号
		if(c[0] == '-'){
			begin++;
			minus = true;
		}else if(c[0] == '+'){
			begin++;
		}
		
		for (int i = c.length - 1, j = 0; i >= begin; i--, j++) {
			//考虑异常值
			if(c[i] < 48 || c[i] > 57){
				throw new IllegalArgumentException("输入异常");
			}else{
				int flag = minus ? -1 : 1;
				result += (c[i] - 48) * Math.pow(10, j) * flag;
				//考虑溢出
				if(result > 2147483647 || result < -2147483648){
					throw new Exception("越界异常");
				}
			}
		}
		return result;
	}
}
