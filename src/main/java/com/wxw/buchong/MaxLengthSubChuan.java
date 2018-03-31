package com.wxw.buchong;

/**
 * ��������ַ���
 * 
 * @author ��ܰέ
 *
 */
public class MaxLengthSubChuan {

	/**
	 * ������Ҫ����ַ���Ϊ str1 , str2 .���� f(m,n) ��ֱ���str1[m] , str2[n] ��β�Ĺ����ַ������ȡ�
                    ����һ�µ��ƹ�ʽ��

                f(m,n)=0        str1[m] != str2[n] ;
                f(m,n)=f(m-1,n-1) + 1      str[m]==str2[n];

                     �����˵��Ƶ�����߽�:
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
