package com.wxw.buchong;

/**
 * 最长公共子字符串
 * 
 * @author 王馨苇
 *
 */
public class MaxLengthSubChuan {

	/**
	 * 假设需要求的字符串为 str1 , str2 .函数 f(m,n) 求分别以str1[m] , str2[n] 结尾的公共字符串长度。
                    这有一下递推公式：

                f(m,n)=0        str1[m] != str2[n] ;
                f(m,n)=f(m-1,n-1) + 1      str[m]==str2[n];

                     别忘了递推的特殊边界:
                f(0,n)=0;
                f(m,0)=0;
	 * @param m
	 * @param n
	 */
	public void func(char[] m, char[] n){
		int[][] f = new int[m.length][n.length];
		
		for (int i = 0; i < f.length; i++) {
			for (int j = 0; j < f[0].length; j++) {
				if(m[i] == n[j]){
					if(i == 0 && j == 0){
						f[i][j] = 1;
					}else{
						f[i][j] = 1 + f[i-1][j-1];
					}
				}else{
					f[i][j] = 0;
				}
			}
		}
	}
}
